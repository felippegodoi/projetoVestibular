<%-- 
    Document   : logar
    Created on : 11/12/2014, 22:09:16
    Author     : Felippe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <title>SisVestibular</title>
    <link rel="stylesheet" href="css/styleLogin.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">

    <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
 <![endif]-->

  </head>

  <body>
    <div class="container">
      <div id="login">

        <form action="LogarUsuario" method="POST">
          <fieldset class="clearfix">

            <p><span class="fontawesome-user"></span><input type="text" name="loginpessoa" value="Username" onBlur="if(this.value == '') this.value = 'Username'" onFocus="if(this.value == 'Username') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
            <p><span class="fontawesome-lock"></span><input type="password" name="senhapessoa" value="Password" onBlur="if(this.value == '') this.value = 'Password'" onFocus="if(this.value == 'Password') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
            <p><input type="submit" value="Sign In"></p>

          </fieldset>
        </form>
      </div> 
        <!-- end login -->
    </div>
  </body>
</html>
