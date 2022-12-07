package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DeportistaDbUtil {

	private DataSource dataSource;

	public DeportistaDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Deportista> getDeportistas() throws Exception {
		
		List<Deportista> deportistas = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "Select * from deportista";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String aPaterno = myRs.getString("aPaterno");
				String aMaterno = myRs.getString("aMaterno");
				String deporte = myRs.getString("deporte");
				
				// create new student object
				Deportista tempDeportista = new Deportista(id, nombre, aPaterno, aMaterno,deporte);
				
				// add it to the list of deportistas
				deportistas.add(tempDeportista);				
			}
			
			return deportistas;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addDeportista(Deportista theDeportista) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into deportista "
					   + "(nombre, aPaterno, aMaterno,deporte) "
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theDeportista.getNombre());
			myStmt.setString(2, theDeportista.getaPaterno());
			myStmt.setString(3, theDeportista.getaMaterno());
			myStmt.setString(4, theDeportista.getDeporte());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Deportista getDeportista(String theDeportistaId) throws Exception {

		Deportista theDeportista = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int deportistaId;
		
		try {
			// convert student id to int
			deportistaId = Integer.parseInt(theDeportistaId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from deportista where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, deportistaId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String aPaterno = myRs.getString("aPaterno");
				String aMaterno = myRs.getString("aMaterno");
				String deporte = myRs.getString("deporte");
				
				// use the deportistaId during construction
				theDeportista = new Deportista(deportistaId, nombre, aPaterno, aMaterno,deporte);
			}
			else {
				throw new Exception("Could not find student id: " + deportistaId);
			}				
			
			return theDeportista;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateDeportista(Deportista theDeportista) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update deportista "
						+ "set nombre=?, aPaterno=?, aMaterno=?, deporte=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theDeportista.getNombre());
			myStmt.setString(2, theDeportista.getaPaterno());
			myStmt.setString(3, theDeportista.getaMaterno());
			myStmt.setString(4, theDeportista.getDeporte());
			myStmt.setInt(5, theDeportista.getId());
			
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteDeportista(String theDeportistaId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int deportistaId = Integer.parseInt(theDeportistaId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from deportista where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, deportistaId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















