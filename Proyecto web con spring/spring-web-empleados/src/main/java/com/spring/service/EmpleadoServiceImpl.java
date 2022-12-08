package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmpleadoDAO;
import com.spring.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	// need to inject customer dao
	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@Override
	@Transactional
	public List<Empleado> getEmpleados() {
		return empleadoDAO.getEmpleados();
	}

	@Override
	@Transactional
	public void saveEmpleado(Empleado theEmpleado) {

		empleadoDAO.saveEmpleado(theEmpleado);
	}

	@Override
	@Transactional
	public Empleado getEmpleado(int theId) {
		
		return empleadoDAO.getEmpleado(theId);
	}

	@Override
	@Transactional
	public void deleteEmpleado(int theId) {
		
		empleadoDAO.deleteEmpleado(theId);
	}
}





