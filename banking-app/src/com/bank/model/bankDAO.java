package com.bank.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class bankDAO {
	
	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	     
	    public bankDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	        this.jdbcURL = jdbcURL;
	        this.jdbcUsername = jdbcUsername;
	        this.jdbcPassword = jdbcPassword;
	    }
	     
	    protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = DriverManager.getConnection(
	                                        jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }
	     
	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }
	     
	    public boolean newCustomer(model bank) throws SQLException {
	        String sql = "INSERT INTO customer_det (password,fname,lname,phone,email,address,amount) VALUES (?, ?, ?,?,?,?,?)";
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, bank.getPassword());
	        statement.setString(2, bank.getFname());
	        statement.setString(3, bank.getLname());
	        statement.setString(4, bank.getPhone());
	        statement.setString(5, bank.getEmail());
	        statement.setString(6, bank.getAddress());
	        statement.setInt(7, bank.getAmount());
	         
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowInserted;
	    }
	     
	    public List<model> listAllCustomer() throws SQLException {
	        List<model> listCustomer = new ArrayList<>();
	         
	        String sql = "SELECT * FROM customer_det";
	        System.out.println("hello");
	         
	        connect();
	         
	        Statement statement = jdbcConnection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	            int acc_no = resultSet.getInt("acc_no");
	            String password = resultSet.getString("password");
	            String fname = resultSet.getString("fname");
	            String lname = resultSet.getString("lname");
	            String phone = resultSet.getString("phone");
	            String email = resultSet.getString("email");
	            String address = resultSet.getString("address");
	               
	            int amount = resultSet.getInt("amount");
	             System.out.println(address);
	            model bank = new model(acc_no, password,fname,lname,phone,email,address,amount);
	            listCustomer.add(bank);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        disconnect();
	         
	        return listCustomer;
	    }
	     
	    public boolean deleteCustomer(model bank) throws SQLException {
	        String sql = "DELETE FROM customer_det where acc_no = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, bank.getAcc_no());
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;     
	    }
	     
	    public boolean updateCustomer(model bank) throws SQLException {
	        String sql = "UPDATE customer_det SET password = ?, fname = ?, lname = ?, phone=?, email=? ,address=?, amount=?";
	        sql += " WHERE acc_no = ?";
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, bank.getPassword());
	        statement.setString(2, bank.getFname());
	        statement.setString(3, bank.getLname());
	        statement.setString(4, bank.getPhone());
	        statement.setString(5, bank.getEmail());
	        statement.setString(6, bank.getAddress());
	        statement.setInt(7, bank.getAmount());
	        statement.setInt(7, bank.getAcc_no());
	        
	         
	         
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowUpdated;     
	    }
	     
	    public model getCustomer(int acc_no) throws SQLException {
	        model bank = null;
	        String sql = "SELECT * FROM customer_det WHERE acc_no = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, acc_no);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	        	
	            String password = resultSet.getString("password");
	            String fname = resultSet.getString("fname");
	            String lname = resultSet.getString("lname");
	            String phone = resultSet.getString("phone");
	            String email = resultSet.getString("email");
	            String address = resultSet.getString("address");
	               
	            int amount = resultSet.getInt("amount");
	             
	           bank = new model(acc_no, password,fname,lname,phone,email,address,amount);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return bank;
	    }
	    
	    public  String loginCheck(LoginUser obj) throws SQLException {

	    	String sql = "SELECT * FROM customer_det WHERE acc_no = ? AND password=?";
	    	String uname= obj.getUsername();
	    	String pwd = obj.getPassword();
	    	connect();

	    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	    	statement.setString(1, uname);
	    	statement.setString(2, pwd);
	    	ResultSet resultSet = statement.executeQuery();

	    	if (resultSet.next()) {
	    	resultSet.close();
	    	statement.close();
	    	return "true";
	    	} else {
	    	resultSet.close();
	    	statement.close();
	    	return "false";
	    	}
}
}
