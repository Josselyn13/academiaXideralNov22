package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Empleado;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Empleado> getEmpleados() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Empleado> theQuery = 
				currentSession.createQuery("from Empleado order by id",
											Empleado.class);
		
		// execute query and get result list
		List<Empleado> empleados = theQuery.getResultList();
				
		// return the results		
		return empleados;
	}

	@Override
	public void saveEmpleado(Empleado theEmpleado) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theEmpleado);
		
	}

	@Override
	public Empleado getEmpleado(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Empleado theEmpleado = currentSession.get(Empleado.class, theId);
		
		return theEmpleado;
	}

	@Override
	public void deleteEmpleado(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Empleado where id=:empleadoId");
		theQuery.setParameter("empleadoId", theId);
		
		theQuery.executeUpdate();		
	}

}











