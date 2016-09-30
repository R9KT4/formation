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
	private final String SEARCH_REQUEST = "SEARCH";
	private final String ACTION_PARAM = "action";
	private final String VALUE_PARAM = "value";
	
	
	public DashboardServlet() {
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		ArrayList<Computer> computers = ComputerDao.getComputers();
		request.setAttribute("computers", computers);
		request.setAttribute("numComputers", computers.size());
		request.getRequestDispatcher("/dashboard.jsp" ).forward(request, response);	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		String action = request.getParameter(ACTION_PARAM);
		String value = request.getParameter(VALUE_PARAM);
		System.out.println(action);;
		System.out.println(value);
		if (action.equals(DELETE_REQUEST)) {
			System.out.println("Deleting");
			try  {
				int id = Integer.parseInt(value);
				ComputerDao.deleteComputer(id);
			}
			catch (NumberFormatException e) {				
			}
		}
		else if (action == SEARCH_REQUEST) {
			
		}
		response.sendRedirect("/formation/dashboardServlet");
	}
}
