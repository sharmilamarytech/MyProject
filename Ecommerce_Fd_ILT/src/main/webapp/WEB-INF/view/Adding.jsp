<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<hr>
<form class="form-horizontal" action="addProductAction" method="post">
<fieldset>

<!-- Form Name -->
<legend>ADD PRODUCTS</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_id">PRODUCT ID</label>  
  <div class="col-md-4">
  <input id="product_id"  name="id" placeholder="PRODUCT ID" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
  <div class="col-md-4">
  <input id="product_name" name="pname" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
    
  </div>
</div>


<!-- Select Basic -->
<!--<div class="form-group">
  <label class="col-md-4 control-label" for="product_categorie">PRODUCT CATEGORY</label>
  <div class="col-md-4">
    <select id="product_categorie" name="cid" class="form-control">
    
             

                <option value="">Mobile1</option>
                <option value="">Mobile2</option>
                
    </select>
  </div>
</div>-->

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_prices">PRODUCT PRICES</label>  
  <div class="col-md-4">
  <input id="available_quantity" name="price" placeholder="PRODUCTPRICES" class="form-control input-md" required="" type="text">
    
  </div>
</div>

 <!-- File Button --> 
<!--<div class="form-group">
  <label class="col-md-4 control-label" for="filebutton">Select Your Product Image</label>
  <div class="col-md-4">
    <input id="filebutton" name="file" class="input-file" type="file">
  </div>
</div>
-->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">AddProduct</button>
  </div>
  </div>

</fieldset>
</form>
          

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>