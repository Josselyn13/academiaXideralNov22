package com.luv2code.web.jdbc;

public class Deportista {

	private int id;
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private String deporte;
	public Deportista(String nombre, String aPaterno, String aMaterno, String deporte) {
		super();

		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.deporte = deporte;
	}
	public Deportista(int id, String nombre, String aPaterno, String aMaterno, String deporte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.deporte = deporte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getaPaterno() {
		return aPaterno;
	}
	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}
	public String getaMaterno() {
		return aMaterno;
	}
	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	@Override
	public String toString() {
		return "Deportista [id=" + id + ", nombre=" + nombre + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno
				+ ", deporte=" + deporte + "]";
	}
	
	

	
}
