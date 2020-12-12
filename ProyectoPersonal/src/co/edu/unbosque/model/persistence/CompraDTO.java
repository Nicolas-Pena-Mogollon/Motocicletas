package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.Date;

public class CompraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date fecha;
	private String precioCompra;
	private String referencia;

	public CompraDTO(Date fecha, String precioCompra, String referencia) {
		this.fecha = fecha;
		this.precioCompra = precioCompra;
		this.referencia = referencia;
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
	 * @return the precioCompra
	 */
	public String getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * @param precioCompra the precioCompra to set
	 */
	public void setPrecioCompra(String precioCompra) {
		this.precioCompra = precioCompra;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
