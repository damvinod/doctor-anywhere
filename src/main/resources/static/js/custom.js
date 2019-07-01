var room = 1;
var failureStyle = "alert alert-danger fade in";

function addressFields() {

	room++;

	var addLine1 = '<div class="col-sm-3 nopadding"><div class="form-group"><input type="text" name="addressLine1[]" id="addressLine1"style="text-transform: uppercase"onkeypress="return isAlphaKey(event)" class="form-control"placeholder="Address line 1" aria-describedby="basic-addon1"></div></div>';
	var addLine2 = '<div class="col-sm-3 nopadding"><div class="form-group"><input type="text" name="addressLine2[]" id="addressLine2"style="text-transform: uppercase"onkeypress="return isAlphaKey(event)" class="form-control"placeholder="Address line 2" aria-describedby="basic-addon1"></div></div>';
	var city = '<div class="col-sm-2 nopadding"><div class="form-group"><input onkeypress="return isAlphaKey(event)" type="text"name="city[]" id="city" class="form-control"style="text-transform: uppercase" placeholder="City"aria-describedby="basic-addon1"></div></div>';
	var country = '<div class="col-sm-2 nopadding"><div class="form-group"><input onkeypress="return isAlphaKey(event)" type="text"name="country[]" id="country" class="form-control"style="text-transform: uppercase" placeholder="Country"aria-describedby="basic-addon1"></div></div>';
	var postal = '<div class="col-sm-2 nopadding"><div class="form-group"><div class="input-group"><input onkeypress="return isNumberKey(event)" type="text"name="postalCode[]" id="postalCode" class="form-control"placeholder="Postal Code"aria-describedby="basic-addon1"><div class="input-group-btn"><button class="btn btn-danger" type="button"onclick="removeAddressFields('
			+ room
			+ ');"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button></div></div></div></div>';

	var objTo = document.getElementById('patientAddressFields')
	var divtest = document.createElement("div");
	divtest.setAttribute("class", "form-group removeclass" + room);
	var rdiv = 'removeclass' + room;

	divtest.innerHTML = addLine1 + addLine2 + city + country + postal;

	objTo.appendChild(divtest)
}

function removeAddressFields(rid) {
	$('.removeclass' + rid).remove();
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	return true;
}

function isAlphaKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return true;
	return false;
}

function addPatient(formName) {

	console.log(JSON.stringify($("#" + formName).serializeJSON()));

	var message = checkMandatoryForNewPatient();

	if (message != "") {
		showMessage('newPatientValidationMessage',
				'Please fill the listed mandatory field ' + message,
				failureStyle);
		return false;
	}

	var formData = new FormData();

	var data = $("#" + formName).serializeJSON();

	formData.append('patientData', JSON.stringify($("#" + formName)
			.serializeJSON()));

	var targetUrl = "addNewPatient";

	$.ajax({
		url : targetUrl,
		data : formData,
		async : false,
		cache : false,
		processData : false, // tell jQuery not to process the data
		contentType : false, // tell jQuery not to set contentType
		type : "POST",
		success : function(response) {
			window.location.href = "/home";
		},
		error : function(xhr, status, errorThrown) {
			alert("Sorry, there was a problem!");
			console.log("Error: " + errorThrown);
			console.log("Status: " + status);
			console.dir(xhr);
		},
		// Code to run regardless of success or failure
		complete : function(xhr, status) {
			console.log("The request is complete!");
		}
	});
}

function checkMandatoryForNewPatient() {

	var patientFirstName = $("#patientFirstName").val();
	var patientLastName = $("#patientLastName").val();
	var contactNumber = $("#contactNumber").val();

	var message = "";

	if (patientFirstName == "")
		message = "First Name, ";
	if (patientLastName == "")
		message = message + "Last Name, ";
	if (contactNumber == "")
		message = message + "Contact Number, ";

	if (message != "")
		message = message.slice(0, -2);

	return message;
}

function showMessage(messageDiv, message, style) {

	$('#' + messageDiv)
			.html(
					'<div class="'
							+ style
							+ '"><button type="button" class="close close-alert" data-dismiss="alert" aria-hidden="true">x</button>'
							+ message + ' </div>');
}

function createGrid() {

	var grid = $("#grid-basic").bootgrid({
		ajax : true,
		post : function() {
			return {
				id : "b0df282a-0d67-40e5-8558-c9e93b7befed"
			};
		},
		url : "/getAllPatient",
		searchSettings: {
	        delay: 100,
	        characters: 3
	    },
		formatters : {
			"commands" : function(column, row) {
				var editButton = '<button type="button" class="btn btn-xs btn-default command-edit" data-row-id=" '
					+ row.patientId + '"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></i></button>';
				var deleteButton = '<button type="button" class="btn btn-xs btn-default command-delete" data-row-id=" '
					+ row.patientId + '"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>';
				var tempDeleteButton = '<button type="button" class="btn btn-xs btn-default command-tempDelete" data-row-id=" '
					+ row.patientId + '"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>';
				
				return editButton + deleteButton + tempDeleteButton;
			}
		}
	}).on("loaded.rs.jquery.bootgrid", function() {
		grid.find(".command-edit").on("click", function(e) {
			alert("You pressed edit on row: " + $(this).data("row-id"));
		}).end().find(".command-delete").on("click", function(e) {
			console.log("You pressed delete on row: " + $(this).data("row-id"));
			deletePatient($(this).data("row-id"));
		}).end().find(".command-tempDelete").on("click", function(e) {
			console.log("You pressed tempDelete on row: " + $(this).data("row-id"));
			inactivePatient($(this).data("row-id"));
		});
	});
}

function deletePatient(patientId) {

	var targetUrl = "/sg/v1/patient/" + patientId;

	$.ajax({
		url : targetUrl,
		//data : formData,
		async : false,
		cache : false,
		processData : false, // tell jQuery not to process the data
		contentType : false, // tell jQuery not to set contentType
		type : "DELETE",
		success : function(response) {
			window.location.href = "/home";
		},
		error : function(xhr, status, errorThrown) {
			alert("Sorry, there was a problem!");
			console.log("Error: " + errorThrown);
			console.log("Status: " + status);
			console.dir(xhr);
		},
		// Code to run regardless of success or failure
		complete : function(xhr, status) {
			console.log("The request is complete!");
		}
	});
}

function inactivePatient(patientId) {

	var targetUrl = "/sg/v1/patient/inactive/" + patientId;

	$.ajax({
		url : targetUrl,
		//data : formData,
		async : false,
		cache : false,
		processData : false, // tell jQuery not to process the data
		contentType : false, // tell jQuery not to set contentType
		type : "DELETE",
		success : function(response) {
			window.location.href = "/home";
		},
		error : function(xhr, status, errorThrown) {
			alert("Sorry, there was a problem!");
			console.log("Error: " + errorThrown);
			console.log("Status: " + status);
			console.dir(xhr);
		},
		// Code to run regardless of success or failure
		complete : function(xhr, status) {
			console.log("The request is complete!");
		}
	});
}