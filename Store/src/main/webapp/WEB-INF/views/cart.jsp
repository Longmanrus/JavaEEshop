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
  
    <div id="shopping_cart" class="grid_12">

      <form id="cart" class="clearfix" method="post">
        <table class="s_table_1" width="100%" cellpadding="0" cellspacing="0" border="0">
          <tr>
            <th width="65">Удалить</th>
            <th width="60">Картинка</th>
            <th width="320">Название</th>
            <th>Модель</th>
            <th>Количество</th>
            <th>Цена за шт.</th>
            <th>Всего</th>
          </tr>
			<c:forEach var="product" items="${cart}"> 
			
				<tr class="even">
				
	            <td valign="middle"><input name="product${product.productId}[]" type="hidden" value="${product.productId}"/>
	            					Да <input name="product${product.productId}[]" type="radio" value="true"/>
	            					<br/>Нет <input name="product${product.productId}[]" type="radio" value="false" checked="checked"/>
	            </td>
	            <td valign="middle"><a href="product?product_id=${product.productId}"><img src="${product.photo}" width="60" height="60" alt="${product.title}" /></a></td>
	            <td valign="middle"><a href="product?product_id=${product.productId}"><strong>${product.title}</strong></a></td>
	            <td valign="middle">Product ${product.productId}</td>
	            <td valign="middle"><input name="product${product.productId}[]" type="text" size="3" value="${product.count}"/></td>
	            <td valign="middle"><c:out value ="${product.price}"></c:out><span class="s_currency s_after"> $</span></td>
	            <td valign="middle"><c:out value ="${product.price*product.count}"></c:out><span class="s_currency s_after"> $</span></td>
	          	</tr>
	          	
			</c:forEach>
        </table>
        <br />

        <p class="s_total s_secondary_color last"><strong>Всего:</strong>${totalCart}<span class="s_currency s_after"> $</span></p>
                        
        <div class="clear"></div>
        <br />

        <a href = "listing?page=0" class="s_button_1 s_ddd_bgr left"><span class="s_text">Продолжить покупки</span></a>
        <button class="s_button_1 s_main_color_bgr" formaction="checkout" type="submit"><span class="s_text">Заказать</span></button>
        <button class="s_button_1 s_main_color_bgr" formaction="cart" type="submit"><span class="s_text">Обновить</span></button>
      </form>

    </div>

    <div class="clear"></div>
    <br />
    <br />
    
  </div>
  <!-- end of content --> 
	
    <jsp:include page="footer.jsp" />

</body>
</html>