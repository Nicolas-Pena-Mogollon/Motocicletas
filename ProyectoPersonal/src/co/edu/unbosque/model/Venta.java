package co.edu.unbosque.model;

import java.util.Date;

public class Venta {

    private Date fechaVenta;
    private String documentoCliente;
    private Motocicleta moto;
    private String tipoDePago;
    private int precioDeVenta;

    public Venta() {

    }

    public Venta(Date fechaVenta, String documentoCliente, Motocicleta moto, String tipoDePago, int precioDeVenta) {
        this.fechaVenta = fechaVenta;
        this.documentoCliente = documentoCliente;
        this.moto = moto;
        this.tipoDePago = tipoDePago;
        this.precioDeVenta = precioDeVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public Motocicleta getMoto() {
        return moto;
    }

    public void setMoto(Motocicleta moto) {
        this.moto = moto;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public int getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(int precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

}
