<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Star Edit</title>
<link href="bootstrap/assets/main.css" rel="stylesheet">
<link href="/datepicker/css/datepicker.css" rel="stylesheet" />
<link href="/assets/css/bootstrap-united.css" rel="stylesheet" />

<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Home</a></li>
				<li><a href="stars.html">Stars Catalog</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Actions<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="discoverers.html">Discoverers</a></li>
						<li><a href="newstar">Add Star</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<script src="jquery-1.8.3.js">
	</script>
	<script src="bootstrap/js/bootstrap.js">
	</script>
	<script src="datepicker/js/bootstrap-datepicker.js">
	</script>


	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Welcome to Stars catalog</h1>
			</div>
		</div>
		<div></div>
	</div>


	<c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">

						
						
<c:url var="addAction" value="/discoverer/add" ></c:url>

<form:form action="${addAction}" commandName="discoverer">
<table>
	<c:if test="${!empty discoverer.name}">
	<tr>

		<td>
			<form:input path="name" readonly="true" size="8"  disabled="true" />
			<form:hidden path="name" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty discoverer.name}">
				<input type="submit"
					value="<spring:message text="Edit Discoverer"/>" />
			</c:if>
			<c:if test="${empty discoverer.name}">
				<input type="submit"
					value="<spring:message text="Add Discoverer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Discoverers List</h3>
<c:if test="${!empty listDiscoverers}">
	<table  class="col-lg-3 control-label" style="width:100%" align="left" border="1" colspan="30" rowspan="30">
	<tr>
		<th width="120">Discoverer Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listDiscoverers}" var="discoverer">
		<tr>
			<td>${discoverer.name}</td>
			<td><a href="<c:url value='/edit/${discoverer.name}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${discoverer.name}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
						
						
						
						
						
					</div>
				</div>
			</div>
		</div>
	</div>



	<script>
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");

			yesButton.click(function() {
				yesButton.button("loading");

				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};
				setTimeout(countDown, 100);
			});

		});
	</script>


</body>
</html>