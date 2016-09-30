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
import com.etiennedesticourt.formation.service.ComputerFetcher;

@WebServlet(name="DashboardServlet", urlPatterns = {"/dashboardServlet"})
public class DashboardServlet extends HttpServlet {
	
	
	public DashboardServlet() {
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		ArrayList<Computer> computers = ComputerFetcher.getComputers();
		request.setAttribute("computers", computers);
		request.setAttribute("numComputers", computers.size());
		request.getRequestDispatcher("/dashboard.jsp" ).forward(request, response);	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
	}
}
