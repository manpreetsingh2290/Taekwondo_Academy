<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="css/login.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="login">
        <div class="heading">
            <h2>Sign in</h2>
            <s:form action="login">

                <div class="input-group input-group-lg" style="margin-bottom:10px">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <s:textfield name="userName" label="User Name" class="form-control"></s:textfield>
                    </div>

                <div class="input-group input-group-lg" style="margin-bottom:10px">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <s:textfield name="password" label="Password" type="password" class="form-control"></s:textfield>              
                </div>
                <div align="center" class="row" style="margin-top:10px">
				<s:submit class="btn btn-light" value="Login"></s:submit>
				</div>
            </s:form>
        </div>
    </div>    
</body>
</html>