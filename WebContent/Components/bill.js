$(document).on("click", "#btnSave", function(event){ 
	
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
 
	 
	// Form validation-------------------
	var status = validateItemForm(); 
	if (status != true) 
	 { 
	 $("#alertError").text(status); 
	 $("#alertError").show(); 
	 
 return; 
} 


// If valid------------------------
var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
	$.ajax( 
	{ 
		
	 url : "BillAPI", 
	 type : type, 
	 data : $("#formItem").serialize(), 
	 dataType : "text", 
	 complete : function(response, status) { 
		 
		 onItemSaveComplete(response.responseText, status); 
	 } 
	}); 
	
});


function onItemSaveComplete(response, status){ 
	if (status == "success") {
		
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") { 
			 
			 $("#alertSuccess").text("Successfully saved."); 
			 $("#alertSuccess").show(); 
			 $("#divItemsGrid").html(resultSet.data); 
		 } 
		 else if (resultSet.status.trim() == "error") {
			 
			 $("#alertError").text(resultSet.data); 
			 $("#alertError").show(); 
		 } 
	} 
	else if (status == "error") { 
		
		 $("#alertError").text("Error while saving."); 
		 $("#alertError").show(); 
	} else{ 
		
		 $("#alertError").text("Unknown error while saving.."); 
		 $("#alertError").show(); 
		}
	$("#hidItemIDSave").val(""); 
	$("#formItem")[0].reset(); 
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event){ 
		
		 $("#hidItemIDSave").val($(this).data("userid")); 
		 $("#billNo").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#unitType").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#noUnits").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#month").val($(this).closest("tr").find('td:eq(3)').text()); 
		 $("#costPer_month").val($(this).closest("tr").find('td:eq(4)').text());  
		 $("#sub_total").val($(this).closest("tr").find('td:eq(5)').text()); 
		
		 
});





$(document).on("click", ".btnRemove", function(event) { 
	 $.ajax( 
	 { 
	 	url : "BillAPI", 
	 	type : "DELETE", 
	 	data : "billId=" + $(this).data("userid"),
	 	dataType : "text", 
	 	complete : function(response, status) { 
	 		onItemDeleteComplete(response.responseText, status); 
	 	} 
	}); 
})
	


function onItemDeleteComplete(response, status){
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response); 
			if (resultSet.status.trim() == "success"){
			
				$("#alertSuccess").text("Successfully deleted."); 
				$("#alertSuccess").show(); 
				$("#divItemsGrid").html(resultSet.data); 
				
			} else if (resultSet.status.trim() == "error") { 
				
				$("#alertError").text(resultSet.data); 
				$("#alertError").show(); 
		} 
	} 
	else if (status == "error") { 
		$("#alertError").text("Error while deleting."); 
		$("#alertError").show(); 
	} 
	else { 
		$("#alertError").text("Unknown error while deleting.."); 
		$("#alertError").show(); 
	} 
}

// CLIENT-MODEL================================================================
function validateItemForm(){
	// CODE

/*//Address---------------------------
if ($("#address").val().trim() == "")
{
return "Insert Address.";
} 

//NIC------------------------------
if ($("#NIC").val().trim() == "")
{
return "Insert NIC.";
}

//Software Name------------------------------
if ($("#softwareName").val().trim() == "")
{
return "Insert software Name.";
}

//Size-------------------------------
if ($("#size").val().trim() == "")
{
return "Insert Size.";
}

//Version----------------------------
if ($("#version").val().trim() == "")
{
return "Insert version.";
}

//Date---------------------------------
if ($("#date").val().trim() == "")
{
return "Insert Date.";
}
	
// Cost-------------------------------
if ($("#cost").val().trim() == ""){
	
	return "Insert Order Cost.";
}
// is numerical value
var tmpPrice = $("#cost").val().trim();
if (!$.isNumeric(tmpPrice)){
			
	return "Insert a numerical value for cost.";
}
		
// convert to decimal price
$("#cost").val(parseFloat(tmpPrice).toFixed(2));*/


	return true;
}

