<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- datatable -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
<link rel="stylesheet" type="text/css" href="./resources/css/dataTables.bootstrap.min.css"/>

<link rel="stylesheet" type="text/css" href="./resources/css/ss.css"/>


<link rel="stylesheet" type="text/css" href="./resources/css/datatables.css"/>


<link rel="stylesheet" type="text/css" href="./resources/css/datatables.min.css"/>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
  <script type="text/javascript" src="./resources/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="./resources/js/dataTables.bootstrap.min.css"></script>

<script type="text/javascript">
$(document).ready(function(){
    $('.table').DataTable();
});
</script>
<!-- end -->

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
                <security:authorize access="hasRole( 'ROLE_ADMIN' )"> 
				
					 <li style="font-family:Times New Roman"><a href="<c:url value="/admin/add"/>" role="button" aria-haspopup="true"
					aria-expanded="false" style="font-size:20px;color:black">ManageProducts</a>
					
					<li style="font-family:Times New Roman"><a href="<c:url value="/admin/add1"/>" role="button" aria-haspopup="true"
					aria-expanded="false" style="font-size:20px;color:black">ManageCategory</a>
								
					</li>
					
								
					
					
					</security:authorize>
			</ul>
		
			
				<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                 </c:if>
                 </ul>
			  <ul class="nav navbar-nav navbar-right">
			  <c:if test="${pageContext.request.userPrincipal.name == null }">
					<li>
					<%-- <a href=' <c:url value="/login" />'>Login</a> --%>
					</li>
					<li ><a href="<c:url value="admin/add"/>" role="button" aria-haspopup="true"
					aria-expanded="false" class="fa fa-user" style="font-size:20px;color:black">Login</a> </li>
				<li style="font-family:Times New Roman"><a href=' <c:url value="/register" />'class="fa fa-users" style="font-size:20px;color:black">Signup</a></li>
				
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name  != null}">
                               <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
	              				<li><a href='<c:url value="/logout" />'>Signout</a></li>
                 </c:if>
				 
				</ul>
				 
		</div>		

</nav> 
  
</body>
</html>