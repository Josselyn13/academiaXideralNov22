package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Empleado;
import com.spring.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	// need to inject our customer service
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/list")
	public String listEmpleados(Model theModel) {
		
		// get empleados from the service
		List<Empleado> theEmpleados = empleadoService.getEmpleados();
				
		// add the empleados to the model
		theModel.addAttribute("empleados", theEmpleados);
		
		return "list-empleados";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Empleado theEmpleado = new Empleado();
		
		theModel.addAttribute("empleado", theEmpleado);
		
		return "empleado-form";
	}
	
	@PostMapping("/saveEmpleado")
	public String saveEmpleado(@ModelAttribute("empleado") Empleado theEmpleado) {
		
		// save the customer using our service
		empleadoService.saveEmpleado(theEmpleado);	
		
		return "redirect:/empleado/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empleadoId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Empleado theEmpleado = empleadoService.getEmpleado(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("empleado", theEmpleado);
		
		// send over to our form		
		return "empleado-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmpleado(@RequestParam("empleadoId") int theId) {
		
		// delete the customer
		empleadoService.deleteEmpleado(theId);
		
		return "redirect:/empleado/list";
	}
}










