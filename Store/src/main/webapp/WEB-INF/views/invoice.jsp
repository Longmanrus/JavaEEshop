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
  <div id="content" class="container_16">

    <div id="order_details" class="grid_16">

      <div class="s_order clearfix">
		<p class="s_status"><span class="s_999"></span> <span class="s_secondary_color">
			<c:if test="${orderProducts[0].status==1}">В обработке</c:if>
            <c:if test="${orderProducts[0].status==2}">Доставляется</c:if>
            <c:if test="${orderProducts[0].status==3}">Закрыт</c:if></span></p>
        <p class="s_id"><span class="s_999">Заказ ID</span> <span class="s_main_color">${orderProducts[0].order_id}</span></p>

        <span class="clear border_eee"></span>
        
        <dl class="grid_5 alpha clearfix">
          <dt>E-Mail</dt>
          <dd>${orderProducts[0].email}</dd>
          <dt>Пользователь</dt>
          <dd>${orderProducts[0].login}</dd>
          <dt>Метод доставки</dt>
          <dd>Фиксированная стоимость доставки</dd>
          <dt>Способ оплаты</dt>
          <dd>При получении</dd>
        </dl>
        
        <span class="clear border_eee"></span>

        <h2>Продукт</h2>
        <table class="s_table" width="100%" cellpadding="0" cellspacing="0" border="0">
          <tr>
            <th>Продукт</th>
            <th>Модель</th>
            <th>Количество</th>
            <th>Цена за шт.</th>
            <th width="130">Всего</th>
          </tr>
          <c:forEach var="orderProduct" items="${orderProducts}">
	          <tr>
	            <td class="align_left"><strong>${orderProduct.title}</strong></td>
	            <td>Model ${orderProduct.product_id}</td>
	            <td>${orderProduct.count}</td>
	            <td><span class="s_currency s_before">$</span>${orderProduct.price}</td>
	            <td><span class="s_currency s_before">$</span>${orderProduct.price*orderProduct.count}</td>
	          </tr>
          </c:forEach>
          <tr>
            <td class="align_right" colspan="4"><strong>Промежуточный итог:</strong></td>
            <td><span class="s_currency s_before">$</span>${total}</td>
          </tr>
          <tr>
            <td class="align_right" colspan="4"><strong>Фиксированная стоимость доставки:</strong></td>
            <td><span class="s_currency s_before">$</span>0.00</td>
          </tr>

          <tr class="last">
            <td class="align_right" colspan="4"><strong>Всего:</strong></td>
            <td class="s_secondary_color"><span class="s_currency s_before">$</span>${total}</td>
          </tr>
        </table>

      </div>

    </div>

    <div class="clear"></div>

  </div>
      <!-- end of content -->
    <jsp:include page="footer.jsp" />

</body>
</html>