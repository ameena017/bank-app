package com.app.app;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.bankDAO;
import com.bank.model.model;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private bankDAO bankDAO;
    HttpSession session =null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        bankDAO = new bankDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	     
	         String action = request.getServletPath();
	         System.out.println("action"+action);
             //   String email=(String)session.getAttribute("email");
	       
	         
	  
	         try {
	             switch (action) {
	             case "/new":
	                 showNewForm(request, response);
	                 break;
	             case "/insert":
	                newCustomer(request, response);
	                 break;
	             case "/delete":
	                 deleteCustomer(request, response);
	                 break;
	             case "/edit":
	                 showEditForm(request, response);
	                 break;
	             case "/update":
	                 updateCustomer(request, response);
	                 break;
	             case "/list":
	            	 listCustomer(request, response);
	                 break;
	             /*case "/logout":
                     logout(request,response);
                     break;*/
                  case "/login":
                     loginValidate(request,response);
                     break;
                  default:
                     response.sendRedirect("index.jsp");
                     break;
	             }
	         } catch (SQLException ex) {
	             throw new ServletException(ex);
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
