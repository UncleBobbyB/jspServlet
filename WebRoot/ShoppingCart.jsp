<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jspservlet.vo.Product, javax.servlet.http.HttpSession, jspservlet.vo.TempProduct" %>

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
		<%Vector<TempProduct> products = (Vector<TempProduct>)session.getAttribute("products to display");
				if (products == null || products.size() == 0) {
				%>
				<h4 class="title">Shopping cart is empty</h4>
			<p class="cart">You have no items in your shopping cart.<br>Click<a href="index1.jsp"> here</a> to continue shopping</p>
				<%} else { %>
			<h4 class="checkout_title">Shoppingcart</h4>
				<div class="row">
					<ul class="checkout_ul">
						<li>Product</li>
						<li>Number</li>
						<li>Price</li>
					</ul>
				</div>
				<div class="row_product_checkout">
					<div class="row_product_checkout_left">
					</div>

          <div class="row_product_checkout_middle">
          </div>

          <div class="row_product_checkout_right">
          </div>
				</div>

        <div class="btn_form">
          <form class="" action="" method="post">
            <input type="submit" value="checkout" title="" name="product_checkout_buy_btn">
          </form>
        </div>

		<%} %>
	     </div>
	   </div>
	  </div>
	  <div class="footer">
		</div>
</body>
</html>
