package com.etiennedesticourt.formation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etiennedesticourt.formation.model.Computer;
import com.etiennedesticourt.formation.service.ComputerDao;

@WebServlet(name="DashboardServlet", urlPatterns = {"/dashboardServlet"})
public class DashboardServlet extends HttpServlet {
	private final String DELETE_REQUEST = "DELETE";
	private final String SEARCH_REQUEST = "search";
	private final String ACTION_PARAM = "action";
	private final String VALUE_PARAM = "value";
	
	
	public DashboardServlet() {
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		ArrayList<Computer> computers;
		
		String name = request.getParameter("search");
		if (name != null){
			computers = ComputerDao.searchComputers(name);						
		}
		else{
			computers = ComputerDao.getComputers();	
		}
		
		request.setAttribute("computers", computers);
		request.setAttribute("numComputers", computers.size());
		request.getRequestDispatcher("/dashboard.jsp" ).forward(request, response);	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		String action = request.getParameter(ACTION_PARAM);
		String value = request.getParameter(VALUE_PARAM);
		if (action.equals(DELETE_REQUEST)) {
			try  {
				int id = Integer.parseInt(value);
				ComputerDao.deleteComputer(id);
			}
			catch (NumberFormatException e) {				
			}
			response.sendRedirect("/formation/dashboardServlet");
		}
	}
}
