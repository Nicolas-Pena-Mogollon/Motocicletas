package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class VendedorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String documentoVendedor;
	private String nombre;
	private String celular;
	private String direccion;
	private double sueldo;

	public VendedorDTO(String documentoVendedor, String nombre, String celular, String direccion, double sueldo) {
		this.documentoVendedor = documentoVendedor;
		this.nombre = nombre;
		this.celular = celular;
		this.direccion = direccion;
		this.sueldo = sueldo;
	}

	/**
	 * @return the documentoVendedor
	 */
	public String getDocumentoVendedor() {
		return documentoVendedor;
	}

	/**
	 * @param documentoVendedor the documentoVendedor to set
	 */
	public void setDocumentoVendedor(String documentoVendedor) {
		this.documentoVendedor = documentoVendedor;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the sueldo
	 */
	public double getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
