<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<div class="header">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="header-left">
          <div class="logo">
            <a href="index1.jsp"><img src="images/logo.png" alt="" /></a>
          </div>
          <div class="menu">
            <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
            <ul class="nav" id="nav">
              <li><a href="index1.jsp" , id="Home-link">Home</a></li>
              <li><a href="<%=request.getContextPath() %>/ShopServlet" , id="Products-link">Products</a></li>
              <li><a href="<%=request.getContextPath() %>/ShoppingcartServlet?what=display">Shoppingcart</a>  </li>
              <li><a href="team.html" , id="Team-link">Team</a></li>
              <li><a href="contact.html" , id="Contact-link">Contact</a></li>
              <div class="clear"></div>
            </ul>
            <script type="text/javascript" src="js/responsive-nav.js"></script>
          </div>
          <div class="clear"></div>
        </div>
        <div class="header_right">
          <!-- start search-->
          <div class="search-box">
            <div id="sb-search" class="sb-search">
              <form action="./search" , method="post">
                <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                <input class="sb-search-submit" type="submit" value="">
                <span class="sb-icon-search"> </span>
              </form>
            </div>
          </div>
          <!----search-scripts---->
          <script src="js/classie.js"></script>
          <script src="js/uisearch.js"></script>
          <script>
            new UISearch(document.getElementById('sb-search'));
          </script>
          <!----//search-scripts---->
          <ul class="icon1 sub-icon1 profile_img">
            <li><a class="active-icon c1" href="#"> </a>
              <ul class="sub-icon1 list">
                <div class="product_control_buttons">
                  <a href="#"><img src="images/edit.png" alt="" /></a>
                  <a href="#"><img src="images/close_edit.png" alt="" /></a>
                </div>
                <div class="clear"></div>
                <li class="list_img"><img src="images/1.jpg" alt="" style="width:50px" /></li>
                <li class="list_desc">
                  <h4><a href="#">
                      <%String str =(String) session.getAttribute("firstname"); String str1 =(String) session.getAttribute("lastname");
           if(str==null || str1 ==null || str == "" || str1 == ""){
            str = "Click Login";
            str1="";
           }
           %>
                      <%=str + " " + str1%></a></h4>
                </li>
                <div class="login_buttons">
                  <div class="check_button"><a href="shoppingcart.jsp">Check out</a></div>
                  <%if (str==null || str1 ==null || str == "" || str1 == "") { %>
                  <div class="login_button"><a href="login.jsp">Login</a></div>
                  <%} else { %>
                  <%-- <div class="login_button"><a href="logout">Logout</a></div> --%>
                  <form class="" action="<%=request.getContextPath()%>/logout" method="post">
                    <input class="logout_button" type="submit" name="logout_button" value="Logout">
                  </form>
                  <% } %>
                  <div class="clear"></div>
                </div>
                <div class="clear"></div>
              </ul>
            </li>
          </ul>
          <div class="clear"></div>
        </div>
      </div>
    </div>
  </div>
</div>
