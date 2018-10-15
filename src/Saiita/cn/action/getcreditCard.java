package Saiita.cn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Saiita.cn.entity.creditCard;
import Saiita.cn.service.GetInfo.getCreditCard;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class getcreditCard
 */
@WebServlet("/pages/tables/getcreditCard")
public class getcreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getcreditCard() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			getCreditCard.calculate(request.getParameter("amount"));
			List<creditCard> list = getCreditCard.getCreditCardinfo();// 获得指定页数据
			JSONArray cardinfo = JSONArray.fromObject(list);
			response.getWriter().println(cardinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
