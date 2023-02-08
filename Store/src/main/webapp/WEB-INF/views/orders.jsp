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
    <script>
		function change(id) {
			
			let str = "id="+id+"&state="+$("#order_"+id+"_state").val();
			$.ajax({
				  type: "POST",
				  url: "orders",
				  data: str,
				  success: function(answer){
				   	 alert(answer);
				  }
				});
		}	
	</script>
    <jsp:include page="header.jsp" />

  <!-- ********************** --> 
  <!--      C O N T E N T     -->
  <!-- ********************** --> 
  <div id="content" class="container_12">
  
    <div id="order_history" class="grid_12">
      
      <div class="s_listing s_grid_view clearfix">
      <c:forEach var="order" items="${orders}">
        <div class="grid_4">
          <div class="s_order clearfix">
            <p class="s_id"><span class="s_999">Заказ ID:</span> <span class="s_main_color">${order.id}</span></p>
            <c:if test="${rights==3}">
			<p style="float:right">
			<select onchange=change(${order.id}) size="1" id="order_${order.id}_state" name="order_${order.id}_state">
            <option <c:if test="${order.status==1}">selected </c:if>value="1">В обработке</option>
            <option <c:if test="${order.status==2}">selected </c:if>value="2">Доставляется</option>
            <option <c:if test="${order.status==3}">selected </c:if>value="3">Закрыт</option>
            </select>
            </p>
            </c:if>
            <c:if test="${rights!=3}">
            <p class="s_status s_secondary_color">
            <c:if test="${order.status==1}">В обработке</c:if>
            <c:if test="${order.status==2}">Доставляется</c:if>
            <c:if test="${order.status==3}">Закрыт</c:if>
            </p>
            </c:if>
            <span class="clear"></span>
            <dl class="clearfix">
              <dt>Дата создания::</dt>
              <dd>${order.date}</dd>
              <dt>Пользователь::</dt>
              <dd>${order.login}</dd>
            </dl>
            <span class="clear border_eee"></span>
            <br />
            <p class="s_total left">${order.total}<span class="s_currency s_after"> $</span></p>

            <a href="invoice?order_id=${order.id}" class="s_main_color right"><strong>Подробнее</strong></a>
          </div>
        </div>
        </c:forEach>   
        
      </div>

          <div class="pagination">
            <div class="results"><c:if test="${page<=0}"><a href="orders?page=0"><</a></c:if>
            					<c:if test="${page>0}"><a href="orders?page=${page-1}"><</a></c:if>
            Showing page ${page} <a href="orders?page=${page+1}">></a></div>
          </div>

      <div class="clear"></div>
      <br />

      <br />

    </div>
    
  </div>
      <!-- end of content -->

    <jsp:include page="footer.jsp" />

</body>
</html>