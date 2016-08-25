<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="page.title" /></title> 
</head>
<body>

<%-- 	<form:form action="add.html" commandName="personne" method="POST"> --%>
<%-- 		<form:hidden path="id" /> --%>
<%-- 		<form:label path="nom"><spring:message code="label.nom"/> : </form:label> --%>
<%-- 		<form:input path="nom" id="nom" /> --%>
<%-- 		<form:label path="prenom"><spring:message code="label.prenom"/> : </form:label> --%>
<%-- 		<form:input path="prenom" id="prenom" /> --%>
<%--   		<form:errors path="nom" cssclass="error"></form:errors>  --%>
<!-- 		<p /> -->
<!-- 		<input type="submit" value="valider" /> -->
<%-- 	</form:form> --%>
	
	<form:form action="add.html" commandName="personne" method="POST">
	            <legend >Informations de la personne </legend>
	                <div >
	               	<table>
	               		<form:hidden path="id" />
	               		<tr>
	                	<td></td><td><form:errors path="nom" cssclass="error" cssStyle="color:red"></form:errors></td> 
	                	</tr>
	               		<tr>
	                	<td><form:label path="nom"><spring:message code="label.nom"/> : </form:label></td> 
	                	
	                    <td><form:input path="nom" id="nom" /></td>
	                    </tr>
	                	<tr>
	                	<td><form:label path="prenom"><spring:message code="label.prenom"/> : </form:label></td>
	                    <td><form:input path="prenom" id="prenom" /></td>
	                    </tr>   
	                    <tr>
	                    <td></td><td> <input type="submit" value="valider" /></td>
	                    </tr> 	                             	
	                </table>
	                </div>
	               
	  </form:form>


</body>
</html>