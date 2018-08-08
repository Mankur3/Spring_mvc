package org.app.service;

import org.apache.log4j.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.app.model.User;
import org.app.util.HibernateUtil;
import org.app.service.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 * Servlet implementation class delete
 */
@WebServlet("/delete1")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger log = Logger.getLogger(delete.class.getName());
		String b = request.getParameter("userid");
		System.out.println("deleting for database for user '"+b+"'");
		
		Session session = HibernateUtil.openSession();
		Query q = session.createQuery("delete from User where userid ='"+b+"'");
		q.executeUpdate();
		 log.debug(q.executeUpdate());
	      log.info(q.executeUpdate());
		System.out.println("deletion done");
		session.close();
		System.out.println("sql session close");
		
		System.out.println("getting session id:  '"+request.getSession().getId()+"'");
		
		HttpSession session1=request.getSession();
		String a=(String)session1.getAttribute("user1");
	System.out.println("firstname from type cast is  '"+a+"'");
	String c=(String)session1.getAttribute("user2");
	System.out.println("lastname from type cast is  '"+c+"'");
	
	
		
		
		LoginService loginService = new LoginService();
		User user = loginService.getUserByUserId(a);
		System.out.println("session from database is:'"+user.getFirstName()+"' ");
		
		request.getSession().setAttribute("user", user);
		        response.sendRedirect("Home.jsp");
		
		
		

	}


}
