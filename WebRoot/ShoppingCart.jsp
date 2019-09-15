<%@ page language="java" import="java.util.*" import="jspservlet.vo.Cart" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShoppingCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
     <%
    if(session.getAttribute("Cart")!=null){
    ArrayList<Cart> arrGood=(ArrayList<Cart>)session.getAttribute("Cart");
    for(int i=0;i<arrGood.size();i++){ %>
    good name:<%=arrGood.get(i).getGoodName()%><br/>
    good price:<%=arrGood.get(i).getPrice()%><br/>
    <form method="post" action="./reducePurchase">
    <input type="submit" name="<%=i%>" value="reuduce"/>
    </form>
    good number:<%=arrGood.get(i).getGoodNumber()%><br/>
    <form method="post" action="./addPurchase">
    <input type="submit" name="<%=i%>" value="add"/>
    </form>
    <%}}
    %> 
	<form method="post" action="./pay">
	<input type="submit" name="pay" value="pay">
	</form><br>
  </body>
</html>
