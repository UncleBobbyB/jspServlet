<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>

  <head>
    <title>ROBOT DOG</title>
    <!-- <link href="css/bootstrap.css" rel='stylesheet' type='text/css' /> -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script src="js/jquery.min.js"></script>
    <!-- <script src="js/jquery.easydropdown.js"></script> -->
    <!--start slider -->
    <!-- <link rel="stylesheet" href="css/fwslider.css" media="all" defer> -->
    <script src="js/jquery-ui.min.js" defer></script>
    <script src="js/fwslider.js" defer></script>
    <script src="js/json.js" defer></script>
    <!-- <link href="css/style.css" rel='stylesheet' type='text/css' /> -->
    <!--end slider -->
  </head>

  <body>
    <jsp:include page="header.jsp"/>

    <div class="banner">
      <!-- start slider -->
      <div id="fwslider">
        <div class="slider_container">

        </div>
        <div class="timers"></div>
        <div class="slidePrev"><span></span></div>
        <div class="slideNext"><span></span></div>
      </div>
      <!--/slider -->
    </div>


    <div class="main">
      <div class="content-top">
        <h2>Robot Dog</h2>

        <p class="movie-examples">See examples of work shot on professional products.</p>
        <!-- <div class="close_but"><i class="close1"> </i></div> -->
        <ul id="flexiselDemo3">

		  <li><img src="images/dog1.jpg" /></li>
          <li><img src="images/dog2.jpg" /></li>
          <li><img src="images/dog3.jpg" /></li>
          <li><img src="images/dog4.jpg" /></li>
          <li><img src="images/dog5.jpg" /></li>
          <li><img src="images/dog6.jpg" /></li>
          <li><img src="images/dog7.jpg" /></li>
        </ul>

        <script type="text/javascript">
          $(window).load(function() {
            $("#flexiselDemo3").flexisel({
              visibleItems: 5,
              animationSpeed: 1000,
              autoPlay: true,
              autoPlaySpeed: 3000,
              pauseOnHover: true,
              enableResponsiveBreakpoints: true,
              responsiveBreakpoints: {
                portrait: {
                  changePoint: 480,
                  visibleItems: 1
                },
                landscape: {
                  changePoint: 640,
                  visibleItems: 2
                },
                tablet: {
                  changePoint: 768,
                  visibleItems: 3
                }
              }
            });

          });
        </script>
        <script type="text/javascript" src="js/jquery.flexisel.js"></script>
      </div>
    </div>

    <div class="content-bottom">
      <div class="container">
        <div class="row content_bottom-text">
          <div class="col-md-7">
            <h3>We Are<br>CoCLUB</h3>
            <p class="m_1">Artificial Intelligence is a new technical science to study and develop the theory, method, technology and application system for simulating, extending and extending human intelligence.</p>
            <p class="m_2">Technology is always advancing. </p>
          </div>
        </div>
      </div>
    </div>

    <div class="features">
      <div class="container">
        <h3 class="m_3">Features</h3>
        <div class="close_but"><i class="close1"> </i></div>
        <div class="col-md-3 top_box">
          <div class="view view-ninth"><a href="single.html">
              <img src="images/pic2.jpg" class="img-responsive" alt="" />
              <div class="mask mask-1"> </div>
              <div class="mask mask-2"> </div>

            </a> </div>
          <h4 class="m_4"><a href="#">Load Forward</a></h4>
          <p class="m_5">The safe distance can be configured.</p>
        </div>
        <div class="col-md-3 top_box">
          <div class="view view-ninth"><a href="single.html">
              <img src="images/pic3.jpg" class="img-responsive" alt="" style="height:133px"/>
              <div class="mask mask-1"> </div>
              <div class="mask mask-2"> </div>

            </a> </div>
          <h4 class="m_4"><a href="#">Guide</a></h4>
          <p class="m_5">It can provide verbal notifications and accept verbal commands.</p>
        </div>
        <div class="col-md-3 top_box1">
          <div class="view view-ninth"><a href="single1.jsp">
              <img src="images/pic4.jpg" class="img-responsive" alt="" style="height:133px"/>
              <div class="mask mask-1"> </div>
              <div class="mask mask-2"> </div>

            </a> </div>
          <h4 class="m_4"><a href="#">Entertainment</a></h4>
          <p class="m_5">It can be a pet like a normal dog.</p>
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
                  <input type="text" value="Enter your email" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Enter your email';}">
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
