package Saiita.cn.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Saiita.cn.entity.SafeLog;
import Saiita.cn.service.GetInfo.getSafetyLog;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * Servlet implementation class getSafeLog
 */
@WebServlet("/pages/tables/getSafeLog")
public class getSafeLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Log logger = LogFactory.getLog(GetAllUserInfo.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getSafeLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("获取用户");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		try {
			List<SafeLog> list = getSafetyLog.getLogInfo();
			// 将list装换为Json数组（JSONArray）
			JSONArray UserList = JSONArray.fromObject(list);
			//System.out.println(UserList.toString());
			response.getWriter().println(UserList);
		} catch (SQLException e) {
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
