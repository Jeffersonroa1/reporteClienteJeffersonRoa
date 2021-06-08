package entidad;

import java.sql.Date;

public class Cliente {
	
	private int idCliente;
	private String nombres;
	private String apellidos;
	private int dni;
	private Date fechaNacimiento;
	private tipoCliente tipoCliente;
	private String nombreTipo;
	
	public String getNombreTipo() {
		nombreTipo = tipoCliente.getNombre();
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public tipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(tipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}
