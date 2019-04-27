<%-- 
    Document   : index
    Created on : Mar 12, 2019, 7:53:40 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="css\loginpage.css" />
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
    </head>

    <body>
        <p> LOGIN PAGE <p>
        <div class="form-popup" id="loginform">
            <form action="LoginServlet" method="post" class="form-container">
                <img src="images/logo.png" alt="Vietcombank" style="width:80%; margin-bottom: 15px"> <br>
                <input class="inf" name="username" type="text" placeholder="Tên đăng nhập" required oninvalid="this.setCustomValidity('Yêu cầu điền tên đăng nhập')"
                       oninput="this.setCustomValidity('')" /> <br>
                <input type="password" class="inf" name="password" type="text" placeholder="Mật khẩu" required  oninvalid="this.setCustomValidity('Yêu cầu điền mật khẩu')"
                       oninput="this.setCustomValidity('')"/> <br>
                <button class="loginbutton" type="submit" id="dn">Đăng nhập</button>
            </form>
        </div>
    </body>

</html>
