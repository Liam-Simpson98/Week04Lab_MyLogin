<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <label>Username: </label>
            <input type="text" name ="username" value="${username}" required>
            <br>
            <label>Password: </label>
            <input type="text" name ="password"  value="${password}" required>
            <br>
           <input type="submit" value="Log in">
        </form>
            <div class="invalidLogin">${invalidMessage}</div>
            <div class="loggedOut">${logoutMessage}</div>
    </body>
</html>
