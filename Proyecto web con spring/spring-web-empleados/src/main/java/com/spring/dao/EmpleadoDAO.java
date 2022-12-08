package com.spring.dao;

import java.util.List;

import com.spring.entity.Empleado;

public interface EmpleadoDAO {

	public List<Empleado> getEmpleados();

	public void saveEmpleado(Empleado theCustomer);

	public Empleado getEmpleado(int theId);

	public void deleteEmpleado(int theId);
	
}
