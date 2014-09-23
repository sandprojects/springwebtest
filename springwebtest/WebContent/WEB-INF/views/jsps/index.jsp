<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h1>Spring MVC <spring:message code="message.indexPage.title" text="internationalization example" /></h1>
 
<h3>
	<spring:message code="message.indexPage.springmvc" text="default text" />
	<spring:url var="url_pizza" value="/pizza" />
	<br /><spring:message code="message.gentext.please" text="Please" />&#160;<a href="${url_pizza}"><spring:message code="message.gentext.clickHere" text="click here" /></a>&#160;<spring:message code="message.indexPage.orderPizza" text="to order your pizza" />..!
</h3>
 
Current Locale : ${pageContext.response.locale}<br />

Language : <a href="?language=en">English</a>|<a href="?language=zh_CN">Chinese</a>
 
</body>
</html>