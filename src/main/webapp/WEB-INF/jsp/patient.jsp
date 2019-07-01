<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.bootgrid.min.css" />
<title>Doctor Anywhere</title>
</head>
<script src="js/jquery.js"></script>
<script src="js/custom.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/jquery.serializejson.js"></script>
<script src="js/jquery.bootgrid.min.js"></script>

<body onload="createGrid();">
	<form id="newPatientForm" name="newPatientForm">
		<nav class="navbar navbar-inverse">
		<div class="container">
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>

				</ul>
			</div>
		</div>
		</nav>
		<div class="container">
			<div class="panel panel-success">
				<div class="panel-heading">Add New Patient</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">First Name</span> <input
									type="text" name="patientFirstName" id="patientFirstName"
									style="text-transform: uppercase"
									onkeypress="return isAlphaKey(event)" class="form-control"
									placeholder="First name of the patient"
									aria-describedby="basic-addon1">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Contact Number</span> <input
									onkeypress="return isNumberKey(event)" type="text"
									name="contactNumber" id="contactNumber" class="form-control"
									placeholder="Contact number of the patient"
									aria-describedby="basic-addon1">
							</div>
						</div>
						<div class="col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">Last Name</span> <input
									type="text" name="patientLastName" id="patientLastName"
									style="text-transform: uppercase"
									onkeypress="return isAlphaKey(event)" class="form-control"
									placeholder="Last name of the patient"
									aria-describedby="basic-addon1">
							</div>
						</div>
					</div>
					<br>
					<div class="panel panel-success panel-heading">Patient
						Address</div>
					<div id="patientAddressFields"></div>

					<div class="panel-body">
						<div class="row">
							<div class="col-sm-3 nopadding">
								<div class="form-group">
									<input type="text" name="addressLine1[]" id="addressLine1"
										style="text-transform: uppercase"
										onkeypress="return isAlphaKey(event)" class="form-control"
										placeholder="Address line 1" aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="col-sm-3 nopadding">
								<div class="form-group">
									<input type="text" name="addressLine2[]" id="addressLine2"
										style="text-transform: uppercase"
										onkeypress="return isAlphaKey(event)" class="form-control"
										placeholder="Address line 2" aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="col-sm-2 nopadding">
								<div class="form-group">
									<input onkeypress="return isAlphaKey(event)" type="text"
										name="city[]" id="city" class="form-control"
										style="text-transform: uppercase" placeholder="City"
										aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="col-sm-2 nopadding">
								<div class="form-group">
									<input onkeypress="return isAlphaKey(event)" type="text"
										name="country[]" id="country" class="form-control"
										style="text-transform: uppercase" placeholder="Country"
										aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="col-sm-2 nopadding">
								<div class="form-group">
									<div class="input-group">
										<input onkeypress="return isNumberKey(event)" type="text"
											name="postalCode[]" id="postalCode" class="form-control"
											placeholder="Postal Code" aria-describedby="basic-addon1">
										<div class="input-group-btn">
											<button class="btn btn-success" type="button"
												onclick="addressFields();">
												<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<br>
					<div id="newPatientValidationMessage"></div>
					<div class="btn-group" role="group" aria-label="...">
						<button type="button" onclick="addPatient('newPatientForm');"
							class="btn btn-secondary">Add New Patient</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">Patient Information</div>
			<div class="panel-body">
				<table id="grid-basic" data-toggle="bootgrid"
					class="table table-condensed table-hover table-striped">
					<thead>
						<tr>
							<th data-column-id="patientId" data-type="numeric" data-visible="false" data-sortable="false">ID</th>
							<th data-column-id="patientFirstName" data-order="desc">First
								Name</th>
							<th data-column-id="patientLastName" data-sortable="false">Last Name</th>
							<th data-column-id="contactNumber" data-sortable="false">Contact Number</th>
							<th data-column-id="patientStatus" data-sortable="false">Patient Status</th>
							<th data-column-id="commands" data-formatter="commands" data-sortable="false">Commands</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

</body>
</html>