<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Магазин</title>
    <meta name="description" content="My Store" />
    <link rel="stylesheet" type="text/css" href="stylesheet/960.css" media="all" />
    <link rel="stylesheet" type="text/css" href="stylesheet/screen.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="stylesheet/color.css" media="screen" />

    
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/shoppica.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="s_layout_fixed">
    <jsp:include page="header.jsp" />
    
  <!-- ********************** --> 
  <!--      C O N T E N T     -->
  <!-- ********************** --> 
    <div id="content" class="container_12">

    
        <div id="category" class="grid_9">
    
          
    
          <div class="clear"></div>
    
          <div class="s_listing s_list_view clearfix">
    		<c:forEach var="product" items="${products}">
	            <div class="s_item clearfix">
	              <div class="grid_3 alpha"> <a class="s_thumb" href="product?product_id=${product.id}"><img src="${product.photo}" title="${product.title}" alt="${product.title}" /></a> </div>
	              <div class="grid_6 omega">
	                <h3><a href="product?product_id=${product.id}">${product.title}</a></h3>
	                <p class="s_model"></p>
	                <p class="s_price s_promo_price"><span class="s_old_price"><span class="s_currency s_before">$</span>940.00</span> <span class="s_currency s_before">$</span>${product.price}</p>
	                <p class="s_description">${product.info}</p>
	                <a class="s_button_add_to_cart" href="product?product_id=${product.id}"><span class="s_icon_16"><span class="s_icon"></span>Add to Cart</span></a>
	              </div>
	            </div>
    		
            <div class="clear"></div>
            </c:forEach>
    
          </div>
          
          <div class="pagination">
            <div class="results"><c:if test="${page<=0}"><a href="listing?page=0"><</a></c:if>
            					<c:if test="${page>0}"><a href="listing?page=${page-1}"><</a></c:if>
            Showing page ${page} <a href="listing?page=${page+1}">></a></div>
          </div>
          
        </div>
        
    
      </div>
      <!-- end of content -->
	
    <jsp:include page="footer.jsp" />

</body>
</html>