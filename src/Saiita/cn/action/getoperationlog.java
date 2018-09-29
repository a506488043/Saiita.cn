package Saiita.cn.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Saiita.cn.entity.SafeLog;
import Saiita.cn.service.GetInfo.getSafetyLog;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class getoperationlog
 */
@WebServlet("/pages/tables/getoperationlog")
public class getoperationlog extends HttpServlet {
	public static Log logger = LogFactory.getLog(GetAllUserInfo.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getoperationlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				logger.info("操作日志");
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				// TODO Auto-generated method stub
				try {
					List<SafeLog> list = getSafetyLog.getLog1Info();
					// 将list装换为Json数组（JSONArray）
					JSONArray LoginList = JSONArray.fromObject(list);
					//System.out.println(UserList.toString());
					response.getWriter().println(LoginList);
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
