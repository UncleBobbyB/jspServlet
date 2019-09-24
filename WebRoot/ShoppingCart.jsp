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
		<%Vector<TempProduct> products = (Vector<TempProduct>)session.getAttribute("products to display");
				if (products == null || products.size() == 0) {
				%>
				<h4 class="title">Shopping cart is empty</h4>
			<p class="cart">You have no items in your shopping cart.<br>Click<a href="index1.jsp"> here</a> to continue shopping</p>
				<%} else { %>
			<h4 class="checkout_title">Shoppingcart</h4>
			<%for (TempProduct product : products) { %>

				<div class="row">
					<ul class="checkout_ul">
						<li>Product</li>
						<li>Number</li>
						<li>Price</li>
					</ul>
				</div>
				<div class="row_product_checkout">
					<div class="row_product_checkout_left">
						<img src="<%=product.getProduct().getImage() %>"  style="max-height: 80%; max-width: 70%;
						margin-top: 2%; display: inline;"/>
						<h4 class="checkout_title_product_name"><%=product.getProduct().getName() %></h4>
					</div>

          <div class="row_product_checkout_middle">
            <div class="reduce"> <button type="button" name="reduce" id='reduce_btn_<%=product.getProduct().getId() %>'>-</button> </div>
            <script type="text/javascript">
              var btn = document.getElementById('reduce_btn_<%=product.getProduct().getId() %>');
              btn.onclick = function() {
                window.location.href = '<%=request.getContextPath() %>/ShoppingcartServlet?what=reduce&pro_id=<%=product.getProduct().getId() %>';
              }
            </script>
          	<div class='quantity'><h4><%=product.getQty() %></h4></div>
            <div class="increase"> <button type="button" name="increase" id='increase_btn_<%=product.getProduct().getId() %>'>+</button> </div>
            <script type="text/javascript">
              var btn = document.getElementById('increase_btn_<%=product.getProduct().getId() %>');
              btn.onclick = function() {
                window.location.href = '<%=request.getContextPath() %>/ShoppingcartServlet?what=add&pro_id=<%=product.getProduct().getId() %>&qty=1';
              }
            </script>
          </div>

          <div class="row_product_checkout_right">
          <h4><%=(int)(product.getProduct().getPrice() * 0.7) %></h4>
          </div>

          <div class="row_product_checkout_delete">
            <form class="" action="<%=request.getContextPath() %>/ShoppingcartServlet?what=delete&pro_id=<%=product.getProduct().getId() %>" method="post">
              <input type="submit" name="" value="Delete">
            </form>
          </div>
				</div>
			<%} %>

        <div class="btn_form">
          <form class="" action="<%=request.getContextPath() %>/ShoppingcartServlet?what=checkout" method="post">
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
