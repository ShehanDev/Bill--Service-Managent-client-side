package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bill {
	
	
		
     // connect to the DB
	private Connection connect(){
		Connection con = null;
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyer2", "root", "root");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return con;
	}
			
			
		//Insert Project Details
		public String insertBill(String billID, String billNo, String  unitType, String noUnits,String month, String costPer_month, String sub_total){
			String output = "";
			try{
				Connection con = connect();
					if (con == null){
						return "Error while connecting to the database for inserting."; 
						}
					
					// create a prepared statement
					String query = "INSERT INTO `bill`(`billID`,`billNo`, `unitType`, `noUnits`, `month`, `costPer_month`, `sub_total`) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);	
					 // binding values
					 preparedStmt.setInt(1, 0);
					 preparedStmt.setString(2, billNo);
					 preparedStmt.setString(3,unitType);
					 preparedStmt.setString(4,noUnits);
					 preparedStmt.setString(5, month);
					 preparedStmt.setDouble(6,Float.parseFloat(costPer_month)); 
					 preparedStmt.setDouble(7,Float.parseFloat(sub_total));		  
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
					 
					 String newBill = readBill1(); 
					 output = "{\"status\":\"success\", \"data\": \"" + newBill + "\"}";
					 
					 }catch (Exception e)
					 {
						 
						 output = "{\"status\":\"error\", \"data\":\"Error while inserting the to bill.\"}"; 
						 System.err.println(e.getMessage());
					 }
			 return output;
		 }
		
			
		private String readBill1() {
			// TODO Auto-generated method stub
			return null;
		}



		public String readBill(){
			String output = "";
			try{
				Connection con = connect();
					if (con == null){
						return "Error while connecting to the database for reading."; 
			}				
				// Prepare the html table to be displayed
				output = "<div   class=\"container-fluid\" >"+
						"<table border='1'  class=\"table align-middle\" >"+ 
						"<tr >" +
							 "<th >Bill No</th>" +
							 "<th >Unit Type</th>" +
							 "<th>No of units</th>" +
							 "<th>Month</th>" +
							 "<th>Cost per Month</th>" +
							 "<th>Total</th>" +	
							 "<th>Update</th>" +
							 "<th>Remove</th>" +
						 "</tr>"+
					     "</div>";
	
				String query = "select * from `bill`";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 
				 // iterate through the rows in the result set
				 while (rs.next()){
					 
					 
					 String billId =  Integer.toString(rs.getInt("billId"));
					 String bilNo =  rs.getString("billNo");
					 String unitType = Integer.toString(rs.getInt("unitType"));
					 String  noUnits = Integer.toString(rs.getInt("noUnits"));
					 String month = rs.getString("month");
					 String costPer_month = Float.toString(rs.getFloat("costPer_month"));
					 String sub_total = Float.toString(rs.getFloat("sub_total"));		 
					 // Add into the html table
					 
					 //output += "<tr><td>" + orderId + "</td>";
					 output += "<td>" + bilNo + "</td>";
					 output += "<td>" + unitType + "</td>";
					 output += "<td>" + noUnits + "</td>";
					 output += "<td>" + month + "</td>";
					 output += "<td>" + costPer_month + "</td>";
					 output += "<td>" + sub_total + "</td>";	 
					 // buttons
					
					 output += "<td><input name='btnUpdate' type='button' value='Update' "
								+ "class='btnUpdate btn btn-secondary' data-userid='" + billId + "'></td>"
								+ "<td><input name='btnRemove' type='button' value='Remove' "
								+ "class='btnRemove btn btn-danger' data-userid='" + billId + "'></td></tr>"; 
				 }
			 con.close();
			 
			 // Complete the html table
			 output += "</table>";
			 
			 
			 }catch (Exception e){
				 
				 output = "Error while reading the Bill .";
				 System.err.println(e.getMessage());
			 }
			return output;
			 
		}
		
		
//		
		public String updateBill( String billId,String billNo, String  unitType,String month,String noUnits, String costPer_month, String sub_total){ 
			String output = ""; 
			try{
				Connection con = connect();
				if (con == null){
					return "Error while connecting to the database for updating."; 
				} 
				
				 // create a prepared statement
				String query = "UPDATE `bill` SET `billNo`=?,`unitType`=?,`noUnits`=?,`month`=?,`costPer_month`=?,`sub_total`=? WHERE `billId`=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				  
				 preparedStmt.setString(1, billNo);
				 preparedStmt.setString(2, unitType );
				 preparedStmt.setString(3, noUnits);
				 preparedStmt.setString(4, month);
				 preparedStmt.setDouble(5, Float.parseFloat(costPer_month)); 
				 preparedStmt.setDouble(6, Float.parseFloat(sub_total)); 
				 preparedStmt.setString(7, billId);
				// preparedStmt.setString(4, sector);				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 
				 String newBill = readBill(); 
				 
				output = "{\"status\":\"success\", \"data\": \"" + newBill + "\"}";
				 
		
				 } catch (Exception e) {
					 
					 output = "{\"status\":\"error\", \"data\": \"Error while updating the Bill.\"}";
					 System.err.println(e.getMessage()); 
				 } 
				 return output; 
		 }
		
		
		
		
		public String deleteBill(String billId) { 
			String output = ""; 
			try{ 
				Connection con = connect();
				if (con == null) { 
					return "Error while connecting to the database for deleting."; 
				} 
					// create a prepared statement
				    String query ="DELETE FROM `bill` WHERE billId=?";
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(billId)); 
					
					// execute the statement
					preparedStmt.execute(); 
					con.close(); 
					
					String newBill = readBill(); 
					output = "{\"status\":\"success\", \"data\": \"" + newBill + "\"}"; 
					
			} catch (Exception e) { 
				output = "{\"status\":\"error\", \"data\": \"Error while deleting the Bill.\"}"; 
				System.err.println(e.getMessage()); 
			} 
			return output; 
		}
		
}