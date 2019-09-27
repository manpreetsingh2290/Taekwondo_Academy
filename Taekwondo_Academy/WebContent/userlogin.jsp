<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>Enter credentials</h1>
      <s:form action = "UserAuthentication" validate="true" method="post" namespace="action">
         <s:textfield label="User Name" key="userName" />
          <s:textfield label="Password" key="password" />
         <s:submit value="Login"></s:submit>
      </s:form>
</body>
</html>