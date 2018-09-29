package Saiita.cn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Saiita.cn.entity.alipayStatisticsInfo;
import Saiita.cn.service.GetInfo.alipayStatistics;
import Saiita.cn.service.GetInfo.getToltalAlipay;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class getTotalSpending
 */
@WebServlet("/pages/tables/getTotalSpending")
public class getTotalSpending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTotalSpending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			List<alipayStatisticsInfo> list = alipayStatistics.alipayStatisticsinfo();//获得指定页数据
			JSONArray getTotalinfo = JSONArray.fromObject(list);
			 response.getWriter().println(getTotalinfo);
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
		doGet(request, response);
	}

}
