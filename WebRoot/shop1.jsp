<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="jspservlet.vo.Product" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Free Snow Bootstrap Website Template | Shop :: w3layouts</title>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script type="application/x-javascript">
      addEventListener("load", function() {
        setTimeout(hideURLbar, 0);
      }, false);

      function hideURLbar() {
        window.scrollTo(0, 1);
      }
    </script>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        $(".dropdown img.flag").addClass("flagvisibility");

        $(".dropdown dt a").click(function() {
          $(".dropdown dd ul").toggle();
        });

        $(".dropdown dd ul li a").click(function() {
          var text = $(this).html();
          $(".dropdown dt a span").html(text);
          $(".dropdown dd ul").hide();
          $("#result").html("Selected value is: " + getSelectedValue("sample"));
        });

        function getSelectedValue(id) {
          return $("#" + id).find("dt a span.value").html();
        }

        $(document).bind('click', function(e) {
          var $clicked = $(e.target);
          if (!$clicked.parents().hasClass("dropdown"))
            $(".dropdown dd ul").hide();
        });


        $("#flagSwitcher").click(function() {
          $(".dropdown img.flag").toggleClass("flagvisibility");
        });
      });
    </script>
  </head>

  <body>
    <jsp:include page="header.jsp"/>
    <div class="main">
      <div class="shop_top">
        <div class="container">
          <%-- <div class="row shop_box-top" id="shop_box_row"> --%>
            <%-- <div class="col-md-3 shop_box"><a href="/product">
                <img src=<%String strdog1i = (String)session.getAttribute("pro_image0") ;%>
                  <%= strdog1i %> class="img-responsive" alt="" style="height:140px"/>
                <span class="new-box">
                  <span class="new-label">New</span>
                </span>
                <span class="sale-box">
                  <span class="sale-label">Sale!</span>
                </span>
                <div class="shop_desc">
                  <h3><a href="single1.jsp"><%String strdog1 = (String)session.getAttribute("pro_name0") ;%>
                  <%= strdog1 %></a></h3>

                  <span class="reducedfrom">$306.00</span>
                  <span class="actual">$<%String strdog1p = (String)session.getAttribute("pro_price0") ;%>
                  <%= strdog1p %></span><br>
                  <ul class="buttons">
                    <li class="cart"><a href="single1.jsp">Add To Cart</a></li>
                    <li class="shop_btn"><a href="foo.html">Read More</a></li>
                    <div class="clear"> </div>
                  </ul>
                </div>
              </a></div> --%>
			<%
          Product[] products = new Product[8];
          for (int i = 0; i < 8; i++) {
        	  products[i] = new Product();
        	  products[i].setId((String)session.getAttribute("pro_id" + Integer.toString(i)));
        	  products[i].setImage((String)session.getAttribute("pro_image" + Integer.toString(i)));
        	  products[i].setName((String)session.getAttribute("pro_name" + Integer.toString(i)));
        	  products[i].setPrice((double)session.getAttribute("pro_price" + Integer.toString(i)));
          }
            %>
           <%for (int j = 0; j < 2; j++) { %>
           <div class="row shop_box-top" id="shop_box_row">
          <%for (int i = 0; i < 4; i++) {
        	  %>
        	  <div class="col-md-3 shop_box">
        	  	<a href="<%=request.getContextPath() %>/product?product_id=<%=products[i].getId() %>">
					<img src=<%=products[i + j * 4].getImage() %> class="img-responsive" alt="" style="height:140px" />
					<span class="new-box">
						<span class="new-label">New</span>
					</span>
					<span class="sale-box">
						<span class="sale-label">Sale!</span>
					</span>
					<div class="shop_desc">
					<h3><a href="<%=request.getContextPath() %>/product?product_id=<%=products[i].getId() %>" name=<%=products[i].getName() %> ><%=products[i + j * 4].getName() %></a></h3>
					<span class="reducedfrom">$<%=(int)products[i + j * 4].getPrice() %></span>
					<span class="actual">$<%=(int)(products[i + j * 4].getPrice()*0.7) %></span><br/>
					<ul class="buttons">
            <%-- <li class="cart"><a href="#">Add to Cart</a></li> --%>
						<li class="cart"><a href="" name="cart">Add to Cart</li>
						<li class="cart"></li>
						<li class="shop_btn"><a href="" name="buy">Buy Now</a></li>
						<div class="clear"></div>
					</ul>
					</div>
        	  	</a>
        	  </div>
        	  <%} %>
        	  </div>
        	  <%} %>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>Products</h4>
              <li><a href="#">Mens</a></li>
              <li><a href="#">Womens</a></li>
              <li><a href="#">Youth</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>About</h4>
              <li><a href="#">Careers and internships</a></li>
              <li><a href="#">Sponserships</a></li>
              <li><a href="#">team</a></li>
              <li><a href="#">Catalog Request/Download</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>Customer Support</h4>
              <li><a href="#">Contact Us</a></li>
              <li><a href="#">Shipping and Order Tracking</a></li>
              <li><a href="#">Easy Returns</a></li>
              <li><a href="#">Warranty</a></li>
              <li><a href="#">Replacement Binding Parts</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>Newsletter</h4>
              <div class="footer_search">
                <form>
                  <input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your email';}">
                  <input type="submit" value="Go">
                </form>
              </div>
              <ul class="social">
                <li class="facebook"><a href="#"><span> </span></a></li>
                <li class="twitter"><a href="#"><span> </span></a></li>
                <li class="instagram"><a href="#"><span> </span></a></li>
                <li class="pinterest"><a href="#"><span> </span></a></li>
                <li class="youtube"><a href="#"><span> </span></a></li>
              </ul>

            </ul>
          </div>
        </div>
        <div class="row footer_bottom">
          <dl id="sample" class="dropdown">
            <dt><a href="#"><span>Change Region</span></a></dt>
            <dd>
              <ul>
                <li><a href="#">Australia<img class="flag" src="images/as.png" alt="" /><span class="value">AS</span></a></li>
                <li><a href="#">Sri Lanka<img class="flag" src="images/srl.png" alt="" /><span class="value">SL</span></a></li>
                <li><a href="#">Newziland<img class="flag" src="images/nz.png" alt="" /><span class="value">NZ</span></a></li>
                <li><a href="#">Pakistan<img class="flag" src="images/pk.png" alt="" /><span class="value">Pk</span></a></li>
                <li><a href="#">United Kingdom<img class="flag" src="images/uk.png" alt="" /><span class="value">UK</span></a></li>
                <li><a href="#">United States<img class="flag" src="images/us.png" alt="" /><span class="value">US</span></a></li>
              </ul>
            </dd>
          </dl>
        </div>
      </div>
    </div>
  </body>

</html>
