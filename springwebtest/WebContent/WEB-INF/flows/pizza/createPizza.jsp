<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div xmlns:form="http://www.springframework.org/tags/form"
xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:output omit-xml-declaration="yes" />
<jsp:directive.page contentType="text/html; charset=UTF-8"/>
<h2>CreatePizza</h2>
<form:form commandName="pizza">
<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
<b>Size:</b><br/>
<form:radiobutton path="size" label="Small (12-inch)" value="SMALL"/><br/>
<form:radiobutton path="size" label="Medium (14-inch)" value="MEDIUM"/><br/>
<form:radiobutton path="size" label="Large (16-inch)" value="LARGE"/><br/>
<form:radiobutton path="size" label="Ginormous(20-inch)" value="GINORMOUS"/>
<br/>
<br/>
<b>Toppings:</b><br/>
<form:checkboxes path="toppings" items="${toppingsList}" delimiter="&lt;br/&gt;"/><br/><br/>
<input type="submit" class="button" name="_eventId_addPizza" value="Continue"/>
<input type="submit"class="button" name="_eventId_cancel" value="Cancel"/>
</form:form>
</div>
</body>
</html>