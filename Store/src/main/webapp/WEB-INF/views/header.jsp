<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="wrapper"> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- ********************** --> 
  <!--      H E A D E R       --> 
  <!-- ********************** -->
  <div id="header" class="container_12">
    <div class="grid_12">
    
    	<a id="site_logo" href="index">Магазин всего на свете</a> 

      <div id="system_navigation" class="s_nav">
        <ul class="s_list_1 clearfix">
          <li><a href="index">Главная</a></li>
          <li><a href="<c:if test="${alreadyLogon == false}">#</c:if>
         				<c:if test="${alreadyLogon == true}">cart</c:if>">
         				Корзина</a></li>
          <li><a href="<c:if test="${alreadyLogon == false}">#</c:if>
         				<c:if test="${alreadyLogon == true}">orders?page=0</c:if>">
          				Заказы</a></li>
          <li><a href="#">О компании</a></li>
        </ul>
      </div>
      
      <c:if test="${alreadyLogon == true}">
	      <div id="login_button">
	      <br/><span>${name}</span>
			<a href="logout" id="login_href" class="double-border-button">Выход</a>
	      </div>
      </c:if>
            <c:if test="${alreadyLogon == false}">
	      <div id="login_button">
	      <br/>
			<a href="login" id="login_href" class="double-border-button">Вход</a>
	      </div>
      </c:if>
      
      <div id="categories" class="s_nav">
        <ul>
          <li id="menu_home"> <a href="index">Домой</a> </li>
          <li> <a href="listing?page=0">Электроника</a>
            <div class="s_submenu">
              <h3>Категории</h3>
              <ul class="s_list_1 clearfix">
                <li> <a href="listing?page=0">Цифровые камеры</a>
                  <ul class="s_list_1 clearfix">
                    <li><a href="listing?page=0">Компактные камеры</a></li>
                    <li><a href="listing?page=0">Цифровые SLR</a></li>
                  </ul>
                </li>
                <li><a href="listing?page=0">Домашнее Аудио</a></li>
                <li><a href="listing?page=0">Домашнее Кино</a></li>
                <li><a href="listing?page=0">Телефоны</a></li>
                <li><a href="listing?page=0">MP3 Плееры</a></li>
                <li><a href="listing?page=0">Автомагнитолы</a></li>
              </ul>
              <span class="clear border_eee"></span>
              <h3>Брэнды электроники</h3>
              <ul class="s_list_1 clearfix">
                <li><a href="listing?page=0">Canon</a></li>
                <li><a href="listing?page=0">Hugo Boss</a></li>
                <li><a href="listing?page=0">Panasonic</a></li>
                <li><a href="listing?page=0">Samsung</a></li>
                <li><a href="listing?page=0">Sony</a></li>
              </ul>
            </div>
          </li>
          <li> <a href="listing?page=0">Компьютеры</a>
            <div class="s_submenu">
              <h3>Категории</h3>
              <ul class="s_list_1 clearfix">
                <li><a href="listing?page=0">Декстоп</a></li>
                <li><a href="listing?page=0">Ноутбуки</a></li>
                <li><a href="listing?page=0">Мониторы</a></li>
                <li><a href="listing?page=0">Комплектующие</a></li>
                <li><a href="listing?page=0">Программы</a></li>
              </ul>
              <span class="clear border_eee"></span>
              <h3>Брэнды Компьютеров</h3>
              <ul class="s_list_1 clearfix">
                <li><a href="listing?page=0">Nvidia</a></li>
                <li><a href="listing?page=0">AMD</a></li>
                <li><a href="listing?page=0">Corsair</a></li>
              </ul>
            </div>
          </li>
          <li><a href="listing?page=0">Книги</a>
            <div class="s_submenu">
              <h3>Категории</h3>
              <ul class="s_list_1 clearfix">
                <li><a href="listing?page=0">Фэнтэзи</a></li>
                <li><a href="listing?page=0">Романтика</a></li>
                <li><a href="listing?page=0">Научная фантастика</a></li>
                <li><a href="listing?page=0">Учебные</a></li>
              </ul>
            </div>
          </li>
        </ul>
      </div>
      
      <div id="cart_menu" class="s_nav">
      	<a href="<c:if test="${alreadyLogon == false}">#</c:if>
         				<c:if test="${alreadyLogon == true}">cart</c:if>">
      	
      	<span class="s_icon"></span> <small class="s_text">Корзина</small><span class="s_grand_total s_main_color">$ ${totalCart}</span></a>
        <div class="s_submenu s_cart_holder">
        <c:forEach var="product" items="${cart}"> 
          <div class="s_cart_item">
            <span class="block">${product.count}x <a href="product?product_id=${product.productId}">${product.title}</a></span>
          </div>
        </c:forEach>
          <div class="s_total clearfix"><strong class="cart_module_total left">Цена за все:</strong><span class="cart_module_total">$ ${totalCart}<span class="s_currency s_after">$</span></span></div>
          <span class="clear s_mb_15"></span>
          <div class="align_center clearfix">
            <a class="s_button_1 s_secondary_color_bgr s_ml_0" href="<c:if test="${alreadyLogon == false}">#</c:if>
         																<c:if test="${alreadyLogon == true}">cart</c:if>">
            
            <span class="s_text">В корзину</span></a>
          </div>
        </div>
      </div>
      
    </div>
  </div>
  <!-- end of header --> 