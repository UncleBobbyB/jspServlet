<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jspservlet.vo.Product, javax.servlet.http.HttpSession, jspservlet.vo.TempProduct, jspservlet.dao.impl.ShoppingcartDAOImpl" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Checkout</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js/jquery.min.js"></script>
 </head>
<body>
	<jsp:include page="/header.jsp" />
     <div class="main">
      <div class="shop_top">
		<div class="container">
		<h4 class="title"><%=request.getSession().getAttribute("prompt_title") %></h4>
		<p class="cart"><%=request.getSession().getAttribute("prompt") %></p>
		<br></br>
		<div class="btn_form">
		<form class="" action="index1.jsp" method="post">
		<input type="submit" value="Continue"/> 
		</form>
		</div>
	     </div>
	   </div>
	  </div>
	  <div class="footer">
		</div>
</body>
</html>
