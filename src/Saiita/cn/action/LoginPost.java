package Saiita.cn.action;

import java.io.IOException;

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
import Saiita.cn.service.GetSystemInformation.GetSystemTime;
import Saiita.cn.service.Login.CheckLoginInfo;

/**
 * Servlet implementation class LoginPost
 */
@WebServlet("/LoginPost")
public class LoginPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Log logger = LogFactory.getLog(LoginPost.class);
	//��ȡ���������
	static Browser getBrowser = new Browser();
	//�û���½��־
	static LogRecord log = new LogRecord();
	//��ȡϵͳʱ��
	GetSystemTime getSystemTime = new GetSystemTime();

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
		logger.info("��̨�����½");
		HttpSession session = request.getSession();
		// ��ȡ��¼������ݣ��û���������
		String username = request.getParameter("username");
		String password = request.getParameter("user_psw");
		String browser = getBrowser.getBrowserName(request.getHeader("User-Agent"));
		try {
			if (password == "0000" || password.equals("0000")) {
				logger.error("�û���������Ϊ�գ�");
				log.logrecorc(username, GetSystemTime.GetSyetemTimes(), "�û���½", "��½ʧ�ܣ��û���������Ϊ��", "1",
						request.getRemoteAddr(), browser, request.getHeader("User-Agent"));
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
					//ip
					session.setAttribute("ip", request.getRemoteAddr());
					//�����
					session.setAttribute("browser", browser);
					//�����ԭʼ��Ϣ
					session.setAttribute("browserType", request.getHeader("User-Agent"));
					
					if (result.equals("Success")) {
						logger.info("��½�ɹ�");
						response.sendRedirect("main.jsp");
					} else if (result.equals("failed")) {
						logger.error("��½ʧ��");
						response.sendRedirect("login.jsp");
					} else if (result.equals("No data")) {
						response.sendRedirect("login.jsp");
					} else if (result.equals("false")) {
						logger.error("��ȫУ�鲻ͨ����");
						response.sendRedirect("login.jsp");
					}
				} else {
					logger.error("����ԭ��2");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			logger.info("RSA�ļ������ڡ�" + "\n" + e.getMessage());
			response.sendRedirect("login.jsp");
		}
	}
}
