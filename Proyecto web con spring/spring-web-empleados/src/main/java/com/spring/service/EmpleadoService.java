package com.spring.service;

import java.util.List;

import com.spring.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> getEmpleados();

	public void saveEmpleado(Empleado theEmpleado);

	public Empleado getEmpleado(int theId);

	public void deleteEmpleado(int theId);
	
}
