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
		// 获得请求的URL
		String url = req.getRequestURL().toString();
		// 获得session中的对象
		String result = (String) session.getAttribute("result");
		// 使用endsWith()判断url结尾的字符串,如果有，则不会过滤。没有则被过滤
		if ("Success".equals(result) || url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".gif")
				|| url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith(".do") || url.endsWith("build")
				|| url.endsWith("dist") || url.endsWith("documentation") || url.endsWith("plugins")
				|| url.endsWith(".json") || url.endsWith("yarn.lock") || url.endsWith("login.jsp")
				|| url.endsWith("pages") || url.endsWith("bootstrap") || url.endsWith("RSADecryption")
				|| url.endsWith("pk") || url.endsWith(".min.css") || url.endsWith(".min.js")
				|| url.endsWith("/bootstrap/css/bootstrap.min.css")) {
			logger.info("请求路径：" + url);
			// 满足条件就继续执行
			if (result != null && "Success".equals(result)) {
				logger.info("登陆验证通过,,前端登陆校验结果:" + result);
			} else {
				logger.info("登陆验证不通过(登陆失败),用户或密码密码错误");
			}
			chain.doFilter(request, response);
		} else {
			// 不满足条件就跳转到其他页面
			logger.error("用户没登陆,登陆验证被拦截");
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
		logger.info("登陆Fliter,初始化.");

	}

}
