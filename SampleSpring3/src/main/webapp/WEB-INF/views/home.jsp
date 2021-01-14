<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<c:forEach items="${list}" var="member">
  <div class="row">
        <div class="col-md-3">${member.ID}</div>
    </div>
</c:forEach>

 <br><br>
      <div class="container text-center">
          <h1>Security Prj</h1><br>
      </div>
      <br><br>
      <div class="container text-center col-2">
          <a href='<c:url value="/page"/>'>GUEST</a>
          <a href='<c:url value="/user/page"/>'>USER</a>
          <a href='<c:url value="/member/page"/>'>MEMBER</a>
          <a href='<c:url value="/admin/page"/>'>ADMIN</a>
      </div>
</body>
</html>
