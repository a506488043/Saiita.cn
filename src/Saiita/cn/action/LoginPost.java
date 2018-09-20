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
	// �û���½��־
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
		String operation = "��½��־";
		logger.info("��̨�����½");
		HttpSession session = request.getSession();
		// ��ȡ��¼������ݣ��û���������
		String username = request.getParameter("username");
		String password = request.getParameter("user_psw");
		try {
			if (password == "0000" || password.equals("0000")) {
				logger.error("�û���������Ϊ�գ�");
				log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation, "�û���������Ϊ��",
						"1");
				response.sendRedirect("login.jsp");
			} else {
				RSA rsa = new RSA();
				String pwd = rsa.getPrivateKey(password);
				// �����ݿ���˺ź˶����룬�����ؽ��
				if (pwd != null) {
					String result = CheckLoginInfo.checkLogin(username, pwd, request.getRemoteAddr(),
							request.getHeader("User-Agent"));
					// �������ɾ�������û��ж��Ƿ��½��û��½���ء�
					session.setAttribute("result", result);
					session.setAttribute("username", username);
					// ip
					session.setAttribute("ip", request.getRemoteAddr());
					// �����
					session.setAttribute("browser", getBrowser.getBrowserName(request.getHeader("User-Agent")));
					// �����ԭʼ��Ϣ
					session.setAttribute("browserType", request.getHeader("User-Agent"));

					if (result.equals("Success")) {
						logger.info("��½�ɹ�");
						response.sendRedirect("main.jsp");
					} else if (result.equals("failed")) {
						logger.error("��½ʧ��");
						log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation, "�û����������",
								"1");
						response.sendRedirect("login.jsp");
					} else if (result.equals("No data")) {
						response.sendRedirect("login.jsp");
					} else if (result.equals("false")) {
						logger.error("��ȫУ�鲻ͨ����");
						log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation,
								"��ȫУ�鲻ͨ����", "1");
						response.sendRedirect("login.jsp");
					}
				} else {
					logger.error("����ԭ��2");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			try {
				log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), operation,
						"RSA�ļ������ڡ�" + "\n" + e.getMessage(), "1");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.error("RSA�ļ������ڡ�" + "\n" + e.getMessage());

			response.sendRedirect("login.jsp");
		}
	}
}
