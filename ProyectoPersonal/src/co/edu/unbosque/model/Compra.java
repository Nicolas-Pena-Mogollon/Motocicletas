package co.edu.unbosque.model;

import java.util.Date;

public class Compra {

	private Date fechaCompra;
	private String nombreProveedor;
	private Motocicleta moto;
	private int cantidad;

	public Compra() {

	}

	public Compra(Date fechaCompra, String nombreProveedor, Motocicleta moto, int cantidad) {
		this.fechaCompra = fechaCompra;
		this.nombreProveedor = nombreProveedor;
		this.moto = moto;
		this.cantidad = cantidad;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public Motocicleta getMoto() {
		return moto;
	}

	public void setMoto(Motocicleta moto) {
		this.moto = moto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
