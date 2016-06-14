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
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
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
						<form:form id="starForm" method="post" modelAttribute="star"
							class="bs-example form-horizontal" action="savestar">
							<fieldset>
								<legend>Star Form</legend>

								<div class="form-group">
									<label for="userNameInput" class="col-lg-3 control-label">Name</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="name"
											id="nameInput" placeholder="Name" />
										<form:errors path="name" cssClass="error" />
									</div>
								</div>


								<div class="form-group">
									<label for="longitudeInput" class="col-lg-3 control-label">Longitude</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="longitude"
											id="longitudeInput" placeholder="longitude" />
										<form:errors path="longitude" cssClass="error" />
									</div>
								</div>
								<div class="form-group">
									<label for="altitudeInput" class="col-lg-3 control-label">Altitude</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="altitude"
											id="altitudeInput" placeholder="altitude" />
										<form:errors path="altitude" cssClass="error" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="clazzInput" class="col-lg-3 control-label">Spectral Class</label>
									<div class="date form_date col-lg-9" >
							
											
			<form:select path="clazz" class="form-control" id="clazzInput" placeholder="clazz">
					<form:option value="O"/>
					<form:option value="B"/>
					<form:option value="A"/>
					<form:option value="F"/>
					<form:option value="G"/>
					<form:option value="K"/>
					<form:option value="M"/>
			</form:select>											
								<form:errors path="clazz" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="discovererInput" class="col-lg-3 control-label">Discoverer</label>
									<div class="col-lg-9">

										
										
									<form:select path="discoverer" class="form-control" id="discovererInput" placeholder="discoverer">
					  				<form:option value="NONE" label="--- Select ---" />
					  					<form:options items="${discoverers}" />
				       				</form:select>
										
										
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default">Cancel</button>

									<button class="btn btn-primary" data-toggle="modal"
										data-target="#themodal">Submit</button>

										
									<div id="themodal" class="modal fade" data-backdrop="static">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h3>Form Submission</h3>
												</div>
												<div class="modal-body">
													<p>Save?</p>
													<div class="progress progress-striped active">
														<div id="doitprogress" class="progress-bar"></div>
													</div>
												</div>
												<div class="modal-footer">
													<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
													<input type="submit" value="Yes" id="yesbutton"
														class="btn btn-primary" data-loading-text="Saving.."
														data-complete-text="Saved!">
												</div>
											</div>
										</div>
									</div>

								</div>

							</fieldset>
						</form:form>
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