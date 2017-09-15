package com.employee.app;

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

import com.employee.model.empDAO;
import com.employee.model.model;

import com.employee.model.LoginUser;

@WebServlet("")

	
	 public class ControllerServlet extends HttpServlet {
	     private static final long serialVersionUID = 1L;
	     private empDAO emplDAO;
	     HttpSession session =null;
	  
	     public void init() {
	         String jdbcURL = getServletContext().getInitParameter("jdbcURL");
	         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
	         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
	  
	         emplDAO = new empDAO(jdbcURL, jdbcUsername, jdbcPassword);
	  
	     }
	  
	     protected void doPost(HttpServletRequest request, HttpServletResponse response)
	             throws ServletException, IOException {
	         doGet(request, response);
	     }
	  
	     protected void doGet(HttpServletRequest request, HttpServletResponse response)
	             throws ServletException, IOException {
	         String action = request.getServletPath();
	         System.out.println("action"+action);
             //   String email=(String)session.getAttribute("email");
	       
	         
	  
	         try {
	             switch (action) {
	             case "/new":
	                 showNewForm(request, response);
	                 break;
	             case "/insert":
	                 insertemp(request, response);
	                 break;
	             case "/delete":
	                 deleteemp(request, response);
	                 break;
	             case "/edit":
	                 showEditForm(request, response);
	                 break;
	             case "/update":
	                 updateemp(request, response);
	                 break;
	             case "/list":
	            	 listemp(request, response);
	                 break;
	             /*case "/logout":
                     logout(request,response);
                     break;*/
                  case "/login":
                     loginValidate(request,response);
                     break;
                  default:
                     response.sendRedirect("LoginPage.jsp");
                     break;
	             }
	         } catch (SQLException ex) {
	             throw new ServletException(ex);
	         }
	     }
	  
	     
	     private void loginValidate(HttpServletRequest request,HttpServletResponse response)
	     throws SQLException,IOException,ServletException{
	    	 
	    	 String uname=request.getParameter("username");
             String pwd=request.getParameter("password");
             LoginUser obj=new LoginUser(uname,pwd);
             if(pwd.equals("admin")){
         		//out.print("Welcome", uname);
         		HttpSession session=request.getSession();
         		session.setAttribute("username",uname);
         		  response.sendRedirect("list");
         		
         		}
         		else{
         			//out.print("Sorry, username or password error!");
         			request.getRequestDispatcher("LoginPage.jsp").include(request, response);
         		}
	     }
	     
	     
	     
	     private void listemp(HttpServletRequest request, HttpServletResponse response)
	             throws SQLException, IOException, ServletException {
	         List<model> listemp = emplDAO.listAllemp();
	         request.setAttribute("listemp", listemp);
	         RequestDispatcher dispatcher = request.getRequestDispatcher("index1.jsp");
	         dispatcher.forward(request, response);
	     }
	  
	     private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	             throws ServletException, IOException {
	         RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
	         dispatcher.forward(request, response);
	     }
	  
	     private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	             throws SQLException, ServletException, IOException {
	         int id = Integer.parseInt(request.getParameter("id"));
	         model existingBook = emplDAO.getemp(id);
	         RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
	         request.setAttribute("emp", existingBook);
	         dispatcher.forward(request, response);
	  
	     }
	  
	     private void insertemp(HttpServletRequest request, HttpServletResponse response)
	             throws SQLException, IOException {
	         String name = request.getParameter("name");
	         String stream = request.getParameter("stream");
	         String num=request.getParameter("number");
	         
	         int number = Integer.parseInt(num);
	System.out.println(num);  
	         model newemp = new model(name, stream, number);
	         emplDAO.insertemp(newemp);
	         response.sendRedirect("list");
	     }
	  
	     private void updateemp(HttpServletRequest request, HttpServletResponse response)
	             throws SQLException, IOException {
	         int id = Integer.parseInt(request.getParameter("id"));
	         String name = request.getParameter("name");
	         String stream = request.getParameter("stream");
	         int number = Integer.parseInt(request.getParameter("number"));
	  
	         model emp = new model(id, name, stream, number);
	         emplDAO.updateemp(emp);
	         response.sendRedirect("list");
	     }
	  
	     private void deleteemp(HttpServletRequest request, HttpServletResponse response)
	             throws SQLException, IOException {
	         int id = Integer.parseInt(request.getParameter("id"));
	  
	         model emp = new model(id);
	         emplDAO.deleteemp(emp);
	         response.sendRedirect("list");
	  
	     }

}

