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
    <script>
		function add(id) {
			let str = "id="+id;
			$.ajax({
				  type: "POST",
				  url: "product",
				  data: str,
				  success: function(answer){
				   	 alert(answer);
				  }
				});
		}	
	</script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="s_layout_fixed">
    <jsp:include page="header.jsp" />
    
  <!-- ********************** --> 
  <!--      C O N T E N T     -->
  <!-- ********************** --> 
  <div id="content" class="product_view container_12">

    <div id="product" class="grid_12">
      <div id="product_images" class="grid_4 alpha">
      	<a id="product_image_preview" rel="prettyPhoto[gallery]" href="${product.photo}"><img id="image" src="${product.photo}" title="${product.title}" alt="${product.title}" /></a>
      </div>
      <div id="product_info" class="grid_4">
        <p class="s_price s_promo_price"><span class="s_old_price">940.00<span class="s_currency s_after"> $</span></span> ${product.price}<span class="s_currency s_after"> $</span></p>
        <dl class="clearfix">
          <dt>Availability</dt>
          <dd>In Stock</dd>
          <dt>Model</dt>
          <dd>Product 4</dd>
          <dt>Manufacturer</dt>
          <dd><a href="#">Canon</a></dd>
          <dt>Average Rating</dt>
          <dd>
            <p class="s_rating s_rating_5"><span style="width: 100%;" class="s_percent"></span></p>
          </dd>
        </dl>
      	<p class="s_short_desc">${product.info}</p>
      </div>
      <div class="grid_4 omega">
      	<div class="suffix_2 left s_999">
        	<p>Including 12% VAT</p>
          <p class="s_f_11"><strong>Free delivery</strong> for purchases over 200$ for all the United Kingdom</p>
        </div>
        <div id="product_options">
          <h3>Available Options</h3>
          <label for="option_Memory">Memory</label>
          <select id="option_Memory">
            <option value="676">1 GB +29.38<span class="s_currency s_after"> $</span> </option>
            <option value="677">2 GB +47.00<span class="s_currency s_after"> $</span> </option>
          </select>
          <span class="clear"></span>
        </div>
        <div id="product_buy" class="clearfix">
          <a onclick=add(${product.id}) id="add_to_cart" class="s_main_color_bgr"><span class="s_text"><span class="s_icon"></span>Add to Cart</span></a>
        </div>
      </div>
      <div class="clear"></div>
      <div class="s_tabs grid_12 alpha omega">
        <ul class="s_tabs_nav clearfix">
          <li><a href="#product_description">Описание</a></li>
          <li><a href="#product_reviews">Обзоры (0)</a></li>
          <li><a href="#product_gallery">Фото (2)</a></li>
        </ul>
        <div class="s_tab_box">
        
          <div id="product_description">
            <div class="cpt_product_description ">
				${product.info}
            </div>
            <!-- cpt_container_end -->
          </div>

          <div id="product_reviews" class="s_listing">
            <div class="s_review last">
              <p class="s_author"><strong>Shoppica</strong><small>(29/03/2011)</small></p>
              <div class="right">
                <div class="s_rating_holder">
                  <p class="s_rating s_rating_5"><span class="s_percent" style="width: 100%;"></span></p>
                  <span class="s_average">5 out of 5 Stars!</span>
                </div>
              </div>
              <div class="clear"></div>
              <p>Vestibulum molestie tellus rhoncus nulla cursus quis dictum orci laoreet! metus. Vestibulum molestie tellus rhoncus nulla cursus quis dictum orci laoreet! metus.</p>
            </div>
            <div class="pagination"><div class="results">Showing 1 to 1 of 1 (1 Pages)</div></div>
            <h2 class="s_title_1"><span class="s_main_color">Write</span> Review</h2>
            <div id="review_title" class="clear"></div>
            <div class="s_row_3 clearfix">
              <label><strong>Your Name:</strong></label>
              <input type="text" />
            </div>
            <div class="s_row_3 clearfix">
              <label><strong>Your Review:</strong></label>
              <textarea style="width: 98%;" rows="8"></textarea>
              <p class="s_legend"><span style="color: #FF0000;">Note:</span> HTML is not translated!</p>
            </div>
            <div class="s_row_3 clearfix">
              <label><strong>Rating</strong></label>
              <span class="clear"></span> <span>Bad</span>&nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp;
              <input type="radio" />
              &nbsp; <span>Good</span>
            </div>
            <span class="clear border_ddd"></span>
            <a class="s_button_1 s_main_color_bgr"><span class="s_text">Continue</span></a> <span class="clear"></span> </div>
          <div id="product_gallery">
            <ul class="s_thumbs clearfix">
              <li><a class="s_thumb" href="images/dummy/pic_2.jpg" title="Leica M7" rel="prettyPhoto[gallery]"><img src="images/dummy/pic_2.jpg" width="120" title="Leica M7" alt="Leica M7" /></a></li>
              <li><a class="s_thumb" href="images/dummy/pic_3.jpg" title="Leica M7" rel="prettyPhoto[gallery]"><img src="images/dummy/pic_3.jpg" width="120" title="Leica M7" alt="Leica M7" /></a></li>
            </ul>
          </div>
        </div>
      </div>
      

      
    </div>

  </div>
  <!-- end of content -->
	
    <jsp:include page="footer.jsp" />

</body>
</html>