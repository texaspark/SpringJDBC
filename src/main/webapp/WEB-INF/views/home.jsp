<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Spring JDBC world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="<%=request.getScheme() + "://" 
	+ request.getServerName() + ":" 
	+ request.getServerPort() + 
	request.getContextPath()+"/list"%>">Board List </a><br><br>
	
<a href="<%=request.getScheme() + "://" 
	+ request.getServerName() + ":" 
	+ request.getServerPort() + 
	request.getContextPath()+"/writeView"%>">Board Write View </a><br><br>
</body>
</html>
