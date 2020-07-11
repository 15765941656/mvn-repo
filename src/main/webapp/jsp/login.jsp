<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2020/7/10
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta name='robots' content='noindex,follow' />
    <meta name="viewport" content="width=device-width" />

    <link rel="stylesheet" href="plugin/font-awesome/css/font-awesome.min.css">
    <link rel="shortcut icon" href="img/logo.png">
    <link rel='stylesheet' id='dashicons-css'  href='resources/plugin/login/dashicons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='buttons-css'  href='resources/plugin/login/buttons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='forms-css'  href='resources/plugin/login/forms.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='l10n-css'  href='resources/plugin/login/l10n.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='login-css'  href='resources/plugin/login/login.min.css' type='text/css' media='all' />
    <link rel='stylesheet'  href='resources/css/login.css' type='text/css' media='all' />

</head>
<script>
    var msg="${msg}";
    if(msg!=""){
        alert(msg);
    }
</script>

<body class="login login-action-login wp-core-ui  locale-zh-cn">
<div id="login">
    <br /> <br />
    <form name="loginForm" id="loginForm" action="admin/login"  method="post">
        <p>
            <label for="user_login">用户名或电子邮件地址<br />
                <input type="text" name="userName" id="user_login" class="input" value="admin" size="20" required/></label>
        </p>
        <p>
            <label for="user_pass">密码<br />
                <input type="password" name="userPass" id="user_pass" class="input" value="123456" size="20" required/>
            </label>
        </p>
        <p class="forgetmenot"><label for="rememberme"><input name="rememberme" type="checkbox" id="rememberme" value="1" checked /> 记住密码</label></p>
        <p class="submit">
            <input type="submit" name="wp-submit" id="submit-btn" class="button button-primary button-large" value="登录" />
        </p>
    </form>

    <p id="backtoblog"><a href="#">&larr; 去往博客前台</a></p>

</div>
<div class="clear"></div>
</body>
</html>