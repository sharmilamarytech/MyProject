<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
         
          <c:forEach items="${clist}" var="p">
          <li><a href="categoryproductlist?id=${p.categoryid}">${p.categoryname}</a></li>
           <%-- <li><a href='<c:url value="categoryproductlist?id=${p.categoryid}">${p.categoryname}"/>'</a></li> --%>
         </c:forEach>
         </li>
        </ul>
      
      <li><a href="product">ManageProduct</a></li>
      <li><a href="category">ManageCategory</a></li>
       <li><a href="login">Login</a></li>
        <li><a href="register">Register</a></li>
    </ul>
  </div>
</nav>
</body>
</html>