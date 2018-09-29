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
		try {
			List<alipayInfo> list = getAllAlpayInfo.getAllAlpay();//获得指定页数据
			JSONArray getAllAlpayInfo = JSONArray.fromObject(list);
			 response.getWriter().println(getAllAlpayInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
