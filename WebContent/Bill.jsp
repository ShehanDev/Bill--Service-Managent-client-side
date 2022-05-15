
<%@ page import="com.Bill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/bill.js"></script>
<meta charset="ISO-8859-1">

<!-- new CSS JS Import -->

<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- new CSS JS Import end -->

<title>Bill Management</title>
</head>
<body>

	<!-- form container -->

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Bill Management</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="img" style="background-image: url(images/images.jpg);">
						</div>
						<div class="login-wrap p-4 p-md-5">
							<div class="d-flex">
								<div class="w-100">
									<h3 class="mb-4">Bill Details</h3>
								</div>
							</div>
							
							<form id="formItem" name="formItem" class="signin-form">
							
								<div class="form-group mb-3">
									<label class="label" for="name">Bill No</label> <input
										id="billNo" name="billNo" type="text" class="form-control"
										placeholder="Bill No" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Month</label> <input
										id="month" type="text" name="month" class="form-control"
										placeholder="month number" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">NO of Units:</label> <input
										id="noUnits" type="text" name="noUnits" class="form-control"
										placeholder="no of units" required>
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="name">Unit Type</label> <select
										id="unitType" type="text" name="unitType" class="form-control"
										placeholder="Type" required >
										<option value="1">1</option>
										<option value="2">2</option>
										</select>
								</div>
								
								
								
								<div class="form-group mb-3">
									<label class="label" for="name">Cost per Month</label> <input
										id="costPer_month" type="text" name="costPer_month" class="form-control"
										placeholder="0.00" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Total</label> <input
										id="sub_total" type="text" name="sub_total" class="form-control"
										placeholder="0.00" required>
								</div>
								
				
								<div class="form-group">
								
								<input id="btnSave" name="btnSave" type="button" value="Save"
									class="form-control btn btn-primary rounded submit px-3"> 
								<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- form container End-->
	<div class="container">
		<div class="row">
			<div>
				<h1 style= "text-align:center">Bill Management</h1>
				
				

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemGrid">
					<%
					Bill billObj = new Bill();
					out.print(billObj.readBill());
					%>
				</div>
			</div>
			</div>
		</div>
	</div>

	<!-- script -->

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

	<!-- script End-->

</body>
</html>