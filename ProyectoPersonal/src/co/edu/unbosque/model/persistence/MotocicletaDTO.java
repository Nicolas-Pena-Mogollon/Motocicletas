package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class MotocicletaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String referencia;
	private String cilindraje;
	private String modelo;
	private String marca;

	public MotocicletaDTO(String referencia, String cilindraje, String modelo, String marca) {
		this.referencia = referencia;
		this.cilindraje = cilindraje;
		this.modelo = modelo;
		this.marca = marca;
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
	 * @return the cilindraje
	 */
	public String getCilindraje() {
		return cilindraje;
	}

	/**
	 * @param cilindraje the cilindraje to set
	 */
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

}
