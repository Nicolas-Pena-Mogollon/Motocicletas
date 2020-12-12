package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.Date;

public class VendedorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String documentoVendedor;
	private String nombre;
	private String celular;
	private String direccion;
	private Date fecha;

	public VendedorDTO(String documentoVendedor, String nombre, String celular, String direccion, Date fecha) {
		this.documentoVendedor = documentoVendedor;
		this.nombre = nombre;
		this.celular = celular;
		this.direccion = direccion;
		this.fecha = fecha;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
