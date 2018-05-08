package Saiita.cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoginFilter implements Filter {
	public static Log logger = LogFactory.getLog(LoginFilter.class);

	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// ��������URL
		String url = req.getRequestURL().toString();
		// ���session�еĶ���
		String result = (String) session.getAttribute("result");
		// ʹ��endsWith()�ж�url��β���ַ���,����У��򲻻���ˡ�û���򱻹���
		if ("Success".equals(result) || url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".gif")
				|| url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith(".do") || url.endsWith("build")
				|| url.endsWith("dist") || url.endsWith("documentation") || url.endsWith("plugins")
				|| url.endsWith(".json") || url.endsWith("yarn.lock") || url.endsWith("login.jsp")
				|| url.endsWith("pages") || url.endsWith("bootstrap") || url.endsWith("RSADecryption")
				|| url.endsWith("pk") || url.endsWith(".min.css") || url.endsWith(".min.js")
				|| url.endsWith("/bootstrap/css/bootstrap.min.css")) {
			logger.info("����·����" + url);
			// ���������ͼ���ִ��
			if (result != null && "Success".equals(result)) {
				logger.info("��½��֤ͨ��,,ǰ�˵�½У����:" + result);
			} else {
				logger.info("��½��֤��ͨ��(��½ʧ��),�û��������������");
			}
			chain.doFilter(request, response);
		} else {
			// ��������������ת������ҳ��
			logger.error("�û�û��½,��½��֤������");
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * 
	 * @see Filter#init(FilterConfig)
	 * 
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		// TODO Auto-generated method stub
		logger.info("��½Fliter,��ʼ��.");

	}

}
