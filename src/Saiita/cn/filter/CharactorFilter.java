package Saiita.cn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ×Ö·û±àÂë¹ýÂËÆ÷
 * Servlet Filter implementation class CharactorFilter
 */
@WebFilter("/CharactorFilter")
public class CharactorFilter implements Filter {
	String encoding = null;
	public static Log logger = LogFactory.getLog(CharactorFilter.class);

	@Override
	public void destroy() {
		encoding = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("×Ö·û±àÂë×ª»»(UTF-8)");
		// TODO Auto-generated method stub
		// place your code here
		if (encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset=" + encoding);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("×Ö·û±àÂë×ª»»(UTF-8),³õÊ¼»¯");
		encoding = fConfig.getInitParameter("encoding");
	}

}
