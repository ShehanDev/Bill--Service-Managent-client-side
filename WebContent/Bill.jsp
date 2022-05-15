<%@page import="com.Bill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/bill.js"></script>


<meta charset="ISO-8859-1">
<title>Bill Management</title>
</head>
<body>

<div class="container-fluid"><div class="row"><div class="col-7">
<h1>Bill Management</h1>

	<form id="formItem" name="formItem">
		
		 Bill No:
		<input id="billNo" name="billNo" type="text" class="form-control form-control-sm"><br> 
		Month :
		<input id="month" name="month" type="text" class="form-control form-control-sm"><br>
		 No Units:
		<input id="noUnits" name="noUnits" type="text" class="form-control form-control-sm"><br>
		
		<label>Unit Type:</label> 
							<select id="unitType" name="unitType" class="form-control form-control-sm">
							<option value="1">1</option>
							<option value="2">2</option>
							</select><br>
		 CostPer Month:
		<input id="costPer_month" name="costPer_month" type="text" class="form-control form-control-sm"><br>
		 Total :
		<input id="sub_total" name="sub_total" type="text" class="form-control form-control-sm"><br>
		
		
		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
	</form>
	
	<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divItemGrid">
 
	<%  Bill billObj = new Bill(); 
	 out.print(billObj.readBill()); %>
	</div>
</div> </div>
 </div> 
	
</body>
</html>