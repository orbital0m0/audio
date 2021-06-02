package com.audio.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.audio.dao.MemberDao;
import com.audio.util.SHAUtils;



/**
 * Servlet implementation class SignIn
 */

public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HttpSession session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("entered signIn servlet : " + System.currentTimeMillis());
		
		String id = request.getParameter("id");
		String temppwd = request.getParameter("pwd");
		
		SHAUtils sha = new SHAUtils();

		byte[] sha265 = new byte[0];

		try {
			sha265 = sha.sha256(temppwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String pwd = sha.bytesToHex1(sha265);
		System.out.println(sha.bytesToHex1(sha265));
		
		MemberDao memdao = new MemberDao();

		int rownum = 0;
		
		try {
			
			rownum = memdao.bringMemeber(id, pwd);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rownum > 0) {
			session = request.getSession();
			session.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("../main.jsp");
			rd.forward(request, response);
		}else {

			request.setAttribute("id", id);
			request.setAttribute("pwd", temppwd);
			RequestDispatcher rd = request.getRequestDispatcher("./signin.jsp");
			rd.forward(request, response);
		}

	}

}
