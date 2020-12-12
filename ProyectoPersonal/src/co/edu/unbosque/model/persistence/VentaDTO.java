package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.Date;

public class VentaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String referencia;
	private Date fecha;
	private String documentoCliente;
	private String documentoVendedor;
	private int precioVenta;

	public VentaDTO(String referencia, Date fecha, String documentoCliente, String documentoVendedor, int precioVenta) {
		this.referencia = referencia;
		this.fecha = fecha;
		this.documentoCliente = documentoCliente;
		this.documentoVendedor = documentoVendedor;
		this.precioVenta = precioVenta;
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
	 * @return the documentoCliente
	 */
	public String getDocumentoCliente() {
		return documentoCliente;
	}

	/**
	 * @param documentoCliente the documentoCliente to set
	 */
	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
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
	 * @return the precioVenta
	 */
	public int getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
