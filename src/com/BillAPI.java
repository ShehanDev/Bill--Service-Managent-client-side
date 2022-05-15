package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FundAPI
 */
@WebServlet("/BillAPI")
public class BillAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Bill billObj = new Bill();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillAPI() {
        super();
        //constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		//doGet(request, response);
		String output = billObj.insertBill(request.getParameter("hidItemIDSave"),
				request.getParameter("billNo"),
            	request.getParameter("unitType"),
				request.getParameter("month"),		
				request.getParameter("noUnits"),		
				request.getParameter("costPer_month"), 
				request.getParameter("sub_total")
			);

           response.getWriter().write(output);
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		Map paras = getParasMap(request); 
		String output = billObj.updateBill(paras.get("hidItemIDSave").toString(), 
												paras.get("billNo").toString(), 
												paras.get("unitType").toString(),
												paras.get("noUnits").toString(),
												paras.get("month").toString(), 
												paras.get("costPer_month").toString(),
												paras.get("sub_total").toString()
												); 
		response.getWriter().write(output); 
	}
	
	

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	Map paras = getParasMap(request); 
		
		String output = billObj.deleteBill(paras.get("billId").toString()); 
		response.getWriter().write(output);
	}
	// Convert request parameters to a Map
	
	
	
		private static Map getParasMap(HttpServletRequest request) {
			
			Map<String, String> map = new HashMap<String, String>(); 
			try{ 
				
				 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
				 String queryString = scanner.hasNext() ? 
				 scanner.useDelimiter("\\A").next() : ""; 
				 scanner.close(); 
				 String[] params = queryString.split("&"); 
				 for (String param : params) {
					 
					 String[] p = param.split("=");
					 map.put(p[0], p[1]); 
				 } 
			}catch (Exception e) { 
				
			} 
			return map; 
		}

}
