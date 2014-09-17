<html xmlns:c="http://java.sun.com/jsp/jstl/core"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:spring="http://www.springframework.org/tags"
xmlns:form="http://www.springframework.org/tags/form">

<jsp:outputomit-xml-declaration="yes"/>

<jsp:directive.pagecontentType="text/html;charset=UTF-8"/>

<head><title>Spizza</title></head>
<body>
<h2>CustomerRegistration</h2>
<form:form commandName="customer">
<inputtype="hidden"name="_flowExecutionKey" 	value="${flowExecutionKey}"/>
<b>Phonenumber:</b><form:input path="phoneNumber"/><br/>
<b>Name:</b><form:input path="name"/><br/>
<b>Address:</b><form:input path="address"/><br/>
<b>City:</b><form:input path="city"/><br/>
<b>State:</b><form:input path="state"/><br/>
<b>ZipCode:</b><form:input path="zipCode"/><br/>
<input type="submit" name="_eventId_submit" value="Submit" />
<input type="submit" name="_eventId_cancel" value="Cancel" />
</form:form>
</body>
</html>