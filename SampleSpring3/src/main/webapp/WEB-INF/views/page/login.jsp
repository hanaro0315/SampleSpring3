<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body onload="document.f.username.focus();">
    <h3>Login with Username and Password</h3>
    <form name="f" action="/sample3/loginAction" method="POST">
        <table>
            <tbody>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name="loginId" placeholder="loginId"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="loginPwd" placeholder="Password"></td>
                </tr>
                <tr>
                    <td colspan="2"><input name="submit" type="submit" value="Login"></td>
                </tr>
                
                <c:if test="${not empty ERRORMSG}">
        			<font color="red">
       					 <p>Your login attempt was not successful due to <br/>
        				${ERRORMSG }</p>
        			</font>
			    </c:if>

                <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
            </tbody>
        </table>
    </form>
</body>


</html>