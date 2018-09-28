package Saiita.cn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Saiita.cn.entity.alipayInfo;
import Saiita.cn.Page.getPageCount;
import Saiita.cn.service.GetInfo.getAllAlpayInfo;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class getAllAlpayInfo
 */
@WebServlet("/pages/tables/GetAllAlpayInfo")
public class GetAllAlpayInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllAlpayInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取参数
		int PAGESIZE = 10;
		int pageNo = 1;
		String s = request.getParameter("pgno");
		if (s != null) {
			pageNo = Integer.parseInt(s);
		}
		try {
			int pageCount = new getPageCount().PageCount(PAGESIZE);//获得总页数
			List<alipayInfo> list = getAllAlpayInfo.getAllAlpay(pageNo, PAGESIZE);//获得指定页数据
			int currentPage = pageNo;
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("cars", list);
			int pagePrev = pageNo > 1 ? pageNo - 1 : 1;// 上一页
			int pageNext = pageNo < pageCount ? pageNo + 1 : pageCount;// 下一页
			request.setAttribute("pageNow", pageNo);
			request.setAttribute("pagePrev", pagePrev);
			request.setAttribute("pageNext", pageNext);
			// JSONArray getAllAlpayInfo = JSONArray.fromObject(list);
			// response.getWriter().println(getAllAlpayInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
