<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit your details</title>
</head>
<body>

<center>
        <h1>United Bank</h1>
        <!-- <h2>
            <a href="new">Click to Add New Customer</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Accounts</a>
             
        </h2> -->
    </center>
    <div align="center">
        
            <form action="update" method="post">
       
        <table border="1" cellpadding="5">
           
            </caption>
                <c:if test="${bank != null}">
                    <input type="hidden" name="acc_no" value="<c:out value='${bank.acc_no}' />" />
                </c:if>           
            <tr>
                <th>Password </th>
                <td>
                    <input type="password" name="password" size="45"
                            value="<c:out value='${bank.password}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>First Name </th>
                <td>
                    <input type="text" name="fname" size="45"
                            value="<c:out value='${bank.fname}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name </th>
                <td>
                    <input type="text" name="lnmae" size="45"
                            value="<c:out value='${bank.lname}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Phone No </th>
                <td>
                    <input type="text" name="fname" size="45"
                            value="<c:out value='${bank.phone}' />"
                    />
                </td>
            </tr>
            <tr>
            
            <tr>
                <th>Email ID </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${bank.email}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Address </th>
                <td>
                    <input type="text" name="address" size="100"
                            value="<c:out value='${bank.address}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Present Account Balance </th>
                <td>
                    <input type="text" name="amount" size="45"
                            value="<c:out value='${bank.amount}' />"
                    />
                </td>
            </tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   

</body>
</html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>