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

import com.bank.model.model;
import com.bank.model.LoginUser;
import com.bank.model.bankDAO;

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
	

    private void loginValidate(HttpServletRequest request,HttpServletResponse response)
    throws SQLException,IOException,ServletException{
   	 
   	 String acc_no=request.getParameter("acc_no");
        String password=request.getParameter("password");
        LoginUser obj=new LoginUser(acc_no,password);
        if(password.equals("admin")){
    		//out.print("Welcome", uname);
    		HttpSession session=request.getSession();
    		session.setAttribute("acc_no",acc_no);
    		  response.sendRedirect("list");
    		
    		}
    		else{
    			//out.print("Sorry, username or password error!");
    			request.getRequestDispatcher("login.jsp").include(request, response);
    		}
    }
    
    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<model> listCustomer = bankDAO.listAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
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
        int acc_no = Integer.parseInt(request.getParameter("acc_no"));
        model existingBank =  bankDAO.getCustomer(acc_no);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index2.jsp");
        request.setAttribute("bank", existingBank);
        dispatcher.forward(request, response);
 

    }
 
    private void newCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname=request.getParameter("lname");
        String phone = request.getParameter("phone");
        String email= request.getParameter("email");
        String address = request.getParameter("address");
        String num = request.getParameter("amount");
        int amount = Integer.parseInt(num);
System.out.println(amount);  
model newbank = new model( password,fname,lname,phone,email,address,amount);
        bankDAO.newCustomer(newbank);
        response.sendRedirect("list");
    } 
    
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int acc_no = Integer.parseInt(request.getParameter("acc_no"));
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname=request.getParameter("lname");
        String phone = request.getParameter("phone");
        String email= request.getParameter("email");
        String address = request.getParameter("address");
        String num = request.getParameter("amount");
        int amount = Integer.parseInt(num);
 
        model bank = new model( acc_no,password,fname,lname,phone,email,address,amount);
        bankDAO.updateCustomer(bank);
        response.sendRedirect("list");
    }
 
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int acc_no = Integer.parseInt(request.getParameter("acc_no"));
 
        model bank = new model(acc_no);
        bankDAO.deleteCustomer(bank);
        response.sendRedirect("list");
 
    }

	
	
	
	
	

}