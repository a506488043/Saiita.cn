package Saiita.cn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Saiita.cn.entity.RedmineBugs;
import Saiita.cn.service.GetInfo.getRedmineBug;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class getTheBugDayReport
 */
@WebServlet("/pages/tables/getTheBugDayReport")
public class getTheBugDayReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTheBugDayReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			List<RedmineBugs> list = getRedmineBug.getDaysInfo();//获得指定页数据
			JSONArray days = JSONArray.fromObject(list);
			 response.getWriter().println(days);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			List<RedmineBugs> list = getRedmineBug.getDaysInfo();//获得指定页数据
			JSONArray days = JSONArray.fromObject(list);
			 response.getWriter().println(days);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
