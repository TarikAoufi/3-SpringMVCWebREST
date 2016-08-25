<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="page_list.title" /></title> 
</head>
<body >

	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th colspan=2>Actions</th>
			</tr>
		</thead>
		<tbody id="msg">
			<c:forEach items="${personnes}" var="personne">

				<tr>
					<td>${personne.id}</td>
					<td>${personne.nom}</td>
					<td>${personne.prenom}</td>
					
					<td> 
					<a href="edit.html?id=${personne.id}"> Modifier</a>
					</td>
					<td> 
					<a href="delete.html?id=${personne.id}"> Supprimer</a>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
<a href="edit.html"> Ajouter une nouvelle personne</a>

 <script src="../resources/jquery/dist/jquery.min.js"></script>

	<script type="text/javascript">
		var update = function() {

			var current = "";

			$.ajax({
				datatype : "json",
				type : "GET",
				url : "../personnes"
			
			}).done(
					function(response) {

						for ( var i = 0; i < response.length; i++) {

						console.log("response : " + response);

						current += '<tr><td>' + response[i]["id"] + '</td><td>'
								+ response[i]["nom"] + ' ('
								+ response[i]['prenom'] + ')</td>';
						}
						$('#msg').html(current);

					});
		};
	</script>
 
</body>
</html>