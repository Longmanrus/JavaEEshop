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
  

    <div id="login_page" class="grid_16">
            
      <div class="grid_8 alpha">
        <h2 class="s_title_1"><span class="s_secondary_color">Я новый</span> пользователь.</h2>
        <div class="clear"></div>
        <form id="account" action="registration" method="post">
          <div class="s_row_3 clearfix">
           <c:if test="${errorReg == null}"> <p>Форма для регистрации:</p></c:if>
            <c:if test="${errorReg != null}"><p style="color:red">${errorReg}</p></c:if>
            
            <label><strong>E-Mail Адрес:</strong></label>
             <input name="email" type="text" size="35" class="required email" />
           	<br />
           	<br />
			<label><strong>Логин:</strong></label>
            <input name="login" type="text" size="35" class="required email" />
            <br />
           	<br />
            <label><strong>Пароль:</strong></label>
            <input name="passwordFirst" type="password" size="35" class="required" />
           	<br />
           	<br />
           	<label><strong>Повторите пароль:</strong></label>
            <input name="passwordSecond" type="password" size="35" class="required" />
           	<br />
           	<br />

            <br/>
            <p>Email должен иметь нормализованный вид,а пароль не менее 6 латинских букв и цифр. Логин должен состоять из латинских букв и содержать не менее 3 символов.</p>

          </div>
          <br />
          <span class="clear border_ddd"></span>
          <br />
          <br />
          <br />
          <button class="s_button_1 s_main_color_bgr" type="submit"><span class="s_text">Продолжить</span></button>
        </form>
      </div>

      <div class="grid_8 omega">
        <h2 class="s_title_1"><span class="s_secondary_color">Уже</span> зарегестрированы?</h2>

        <div class="clear"></div>
        <form id="login" action="login" method="post">
          <div class="s_row_3 clearfix">
            Воспользуйтесь формой для авторизации<br />
            <br />
            <label><strong>E-Mail Адрес:</strong></label>
            <input name="email" type="text" size="35" class="required email" />
            <br />
            <br />
            <label><strong>Пароль:</strong></label>
            <input name="password" type="password" size="35" class="required" />
            <br />
          </div>
          <br />
          <span style="text:larger"><c:out value="${errorLogin}"></c:out></span>
          <br />
          <br />
          <br />
          <span class="clear border_ddd"></span>
          <br />
          <br />
          <br />
          <div class="s_nav s_size_2 left">
            <ul class="clearfix">
              <li><a href="#">Забыли пароль?</a></li>
            </ul>
          </div>
          <button class="s_button_1 s_main_color_bgr" type="submit"><span class="s_text">Войти</span></button>
        </form>
      </div>

      <div class="clear"></div>

    </div>
    
  </div>
  <!-- end of content --> 
	
    <jsp:include page="footer.jsp" />

</body>
</html>