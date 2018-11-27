package Saiita.cn.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RSA.RSAUtil;
import Saiita.cn.entity.RsaKey;

/**
 * Servlet implementation class getRsaPublicKey
 */
@WebServlet("/getRsaPublicKey")
public class getRsaPublicKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getRsaPublicKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RSAUtil rsa =new RSAUtil();
		RsaKey key = new RsaKey();
		List<RsaKey> list = new ArrayList<RsaKey>();
		
		try {
			key.setPublicKey(rsa.getKeyPair().getPublic().toString().substring(37,293));
			list.add(key);
			response.getWriter().println(rsa.getKeyPair().getPublic().toString().substring(37,293));
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
