package Saiita.cn.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Saiita.cn.annotation.RSA;
import Saiita.cn.service.GetInfo.Log.LogRecord;
import Saiita.cn.service.GetSystemInformation.Browser;
import Saiita.cn.service.Login.CheckLoginInfo;

/**
 * Servlet implementation class LoginPost
 */
@WebServlet("/LoginPost")
public class LoginPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Log logger = LogFactory.getLog(LoginPost.class);
	// 用户登陆日志
	static LogRecord log = new LogRecord();
	static Browser getBrowser = new Browser();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet #doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = "登陆日志";
		logger.info("后台管理登陆");
		HttpSession session = request.getSession();
		// 获取登录框的数据，用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("user_psw");
		try {
			if (password == "0000" || password.equals("0000")) {
				logger.error("用户名或密码为空！");
				log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation, "用户名或密码为空",
						"1");
				response.sendRedirect("login.jsp");
			} else {
				RSA rsa = new RSA();
				String pwd = rsa.getPrivateKey(password);
				// 与数据库的账号核对密码，并返回结果
				if (pwd != null) {
					String result = CheckLoginInfo.checkLogin(username, pwd, request.getRemoteAddr(),
							request.getHeader("User-Agent"));
					// 这个不能删，用于用户判断是否登陆，没登陆拦截。
					session.setAttribute("result", result);
					session.setAttribute("username", username);
					// ip
					session.setAttribute("ip", request.getRemoteAddr());
					// 浏览器
					session.setAttribute("browser", getBrowser.getBrowserName(request.getHeader("User-Agent")));
					// 浏览器原始信息
					session.setAttribute("browserType", request.getHeader("User-Agent"));

					if (result.equals("Success")) {
						logger.info("登陆成功");
						response.sendRedirect("main.jsp");
					} else if (result.equals("failed")) {
						logger.error("登陆失败");
						log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation, "用户或密码错误",
								"1");
						response.sendRedirect("login.jsp");
					} else if (result.equals("No data")) {
						response.sendRedirect("login.jsp");
					} else if (result.equals("false")) {
						logger.error("安全校验不通过！");
						log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation,
								"安全校验不通过！", "1");
						response.sendRedirect("login.jsp");
					}
				} else {
					logger.error("其他原因2");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			try {
				log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation,
						"RSA文件不存在。" + "\n" + e.getMessage(), "1");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.error("RSA文件不存在。" + "\n" + e.getMessage());

			response.sendRedirect("login.jsp");
		}
	}
}
