package Saiita.cn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Saiita.cn.entity.UserInfo;
import Saiita.cn.service.GetInfo.getAllUserInfo;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * Servlet implementation class GetAllUserInfo
 */
@WebServlet("/pages/tables/GetAllUserInfo")
public class GetAllUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Log logger = LogFactory.getLog(GetAllUserInfo.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("获取用户");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		List<UserInfo> list = getAllUserInfo.getAllUser();
		// 将list装换为Json数组（JSONArray）
		JSONArray UserList = JSONArray.fromObject(list);
		//System.out.println(UserList.toString());
		response.getWriter().println(UserList);
	}

}
