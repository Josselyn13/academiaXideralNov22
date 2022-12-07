package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DeportistaControllerServlet
 */
@WebServlet("/DeportistaControllerServlet")
public class DeportistaControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeportistaDbUtil deportistaDbUtil;
	
	@Resource(name="jdbc/web_deportista_tracker") //SE COMENTO PARA HACER USO DE JNDI
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			
			deportistaDbUtil = new DeportistaDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
						
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listDeportistas(request, response);
				break;
				
			case "ADD":
				addDeportista(request, response);
				break;
				
			case "LOAD":
				loadDeportista(request, response);
				break;
				
			case "UPDATE":
				updateDeportista(request, response);
				break;
			
			case "DELETE":
				deleteDeportista(request, response);
				break;
				
			default:
				listDeportistas(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteDeportista(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theDeportistaId = request.getParameter("deportistaId");
		
		// delete student from database
		deportistaDbUtil.deleteDeportista(theDeportistaId);
		
		// send them back to "list students" page
		listDeportistas(request, response);
	}

	private void updateDeportista(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("deportistaId"));
		String nombre = request.getParameter("nombre");
		String aPaterno = request.getParameter("aPaterno");
		String aMaterno = request.getParameter("aMaterno");
		String deporte = request.getParameter("deporte");
		
		// create a new student object
		Deportista theDeportista = new Deportista(id, nombre, aPaterno, aMaterno,deporte);
		
		// perform update on database
		deportistaDbUtil.updateDeportista(theDeportista);
		
		// send them back to the "list students" page
		listDeportistas(request, response);
		
	}

	private void loadDeportista(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theDeportistaId = request.getParameter("deportistaId");
		
		// get student from database (db util)
		Deportista theDeportista = deportistaDbUtil.getDeportista(theDeportistaId);
		
		// place student in the request attribute
		request.setAttribute("THE_DEPORTISTA", theDeportista);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-deportista-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addDeportista(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		// read student info from form data
				String nombre = request.getParameter("nombre");
				String aPaterno = request.getParameter("aPaterno");
				String aMaterno = request.getParameter("aMaterno");
				String deporte = request.getParameter("deporte");		
		
		// create a new student object
		Deportista theDeportista = new Deportista(nombre, aPaterno, aMaterno,deporte);
		
		// add the student to the database
		deportistaDbUtil.addDeportista(theDeportista);
				
		// send back to main page (the student list)
		listDeportistas(request, response);
	}

	private void listDeportistas(
			HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Deportista> deportistas = deportistaDbUtil.getDeportistas();
		
		for (Deportista d:deportistas) {
			System.out.println(d);
		}
		
		deportistas.add(new Deportista(999, "nombre","aPaterno", "aMaterno","deporte"));
		// add students to the request
		request.setAttribute("LISTA_DEPORTISTAS", deportistas);
		
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-deportistas.jsp");
		dispatcher.forward(request, response);
	}

}













