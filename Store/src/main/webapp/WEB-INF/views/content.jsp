<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
  <!-- ********************** --> 
  <!--     I N T R O          --> 
  <!-- ********************** --> 
  <div id="intro">
    <div id="intro_wrap">
      <div id="product_intro" class="container_12">
        <div id="product_intro_info" class="grid_5">
        <c:forEach var="product" items="${products}" varStatus="counter">
          <div style="position: relative;<c:if test="${counter.count>1}">display: none;</c:if>">
            <h2><a href="product?product_id=${product.id}">${product.title}</a></h2>
            <p class="s_desc">${product.info}</p>
            <div class="s_price_holder">
              <p class="s_price"> <span class="s_currency s_before">$</span>${product.price} </p>
            </div>
          </div>
          </c:forEach>
        </div>
        <div id="product_intro_preview">
          <div class="slides_container">
          <c:forEach var="product" items="${products}">
            <div class="slideItem" style="display: none"><a href="product?product_id=${product.id}"><img src="${product.photo}" alt="" /></a></div>
            </c:forEach>
          </div>
          <a class="s_button_prev" href="javascript:;"></a>
          <a class="s_button_next" href="javascript:;"></a>
        </div>
      </div>
    </div>
  </div>
	<script type="text/javascript" src="js/jquery/jquery.slides.js"></script> 
  <script type="text/javascript" src="js/shoppica.products_slide.js"></script>
  <!-- end of intro --> 
  
  
  <!-- ********************** --> 
  <!--      C O N T E N T     --> 
  <!-- ********************** --> 
  <div id="content" class="container_12">
  
    <div id="welcome" class="grid_12">
      <h2>Welcome to Shoppica store</h2>
      <p> <a href="">Shoppica</a> is a stylish premium OpenCart theme (currently supported versions are 1.4.9.3/1.4.9.4). The clean and modern design allows you to use the theme for every kind of online shop: clothes, accessories, gifts, electronics, furniture, health and cosmetics store and so on.</p>
      <p> One of the main features is to choose different types of slideshows for every category, so you can personalise every part of your store. Shoppica allows you to customize product listing size, column position and layout type, giving you the power to easy adapt the theme to your produc or service. With the color themer tool you can change site&#39;s elements and make your store unique and stand out of the crowd.</p>
    </div>
    
    <div class="clear"></div>
    
  </div>
  <!-- end of content --> 