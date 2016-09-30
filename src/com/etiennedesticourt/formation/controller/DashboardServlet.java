package com.etiennedesticourt.formation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.etiennedesticourt.formation.model.Computer;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

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

	
String name = String.valueOf(request.getParameter("name"));
Timestamp introduced = (Timestamp)request.getAttribute("introduced");
Timestamp discontinued= (Timestamp)request.getAttribute("discontinued");
int company_id = Integer.valueOf(request.getParameter("company"));
JOptionPane.showMessageDialog(null,request.getParameter("name"));
JOptionPane.showMessageDialog(null,String.valueOf(request.getParameter("name")));
       /* request.setAttribute("name", name);
        request.setAttribute("introduced", introduced);
        request.setAttribute("discontinued", discontinued);
        request.setAttribute("company", company_id);*/
        
        JOptionPane.showMessageDialog(null,"POST2");
        
        String url = "jdbc:mysql://localhost:3306/computer-database-db";
        String utilisateur = "root";
        String motDePasse = "mysql";
        Connection connexion = null;
        try {
            connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );

            java.sql.Statement statement =  connexion.createStatement();
            JOptionPane.showMessageDialog(null,"connected");
            JOptionPane.showMessageDialog(null,name);
            JOptionPane.showMessageDialog(null,introduced);
            JOptionPane.showMessageDialog(null,company_id);
            //int statut = statement.executeUpdate( "INSERT INTO computer (name, introduced, discontinued, company_id) VALUES ('coucou', 04/04/0004, 05/05/0005, 2 );" );
            //if (statut==0) {JOptionPane.showMessageDialog(null,"statut false");}
            JOptionPane.showMessageDialog(null,"database");
        } catch ( SQLException e ) {
        	  JOptionPane.showMessageDialog(null,"UNconnected");
        } finally {
            if ( connexion != null )
                try {
                	
                    connexion.close();
                    JOptionPane.showMessageDialog(null,"closed");
                } catch ( SQLException ignore ) {
                    // Si une erreur survient lors de la fermeture, il suffit de l'ignorer. 
                }
        }
        
        
        
		
		

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
