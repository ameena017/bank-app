package com.bank.model;

public class LoginUser {
	
		String username;
		String password;
		public LoginUser(String uname,String pwd)
		{
			this.username=uname;
			this.password=pwd;
			
		}
		    public void setUsername(String value)
		    {
		            username=value;
		    }
		    public void setPassword(String value)
		    {
		        password=value;
		    }
		public String getUsername()
		{
			return username;
		}
		public String getPassword()
		{
			return password;
			}


}
