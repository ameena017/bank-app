
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to United Bank-User Login</title>
    </head>
    <body>
        <form method="post" action="login1">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Account no</td>
                        <td><input type="text" name="acc_no" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                       <center> <td><input type="submit" value="Login" /></td></center>
                       <!--  <td><input type="reset" value="Reset" /></td> -->
                    </tr>
                    <tr>
                        <td colspan="2">Don't have an account?! <a href="reg.jsp">Contact your nearest United Bank branch here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>