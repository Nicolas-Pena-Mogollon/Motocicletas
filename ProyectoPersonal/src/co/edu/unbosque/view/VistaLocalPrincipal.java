package co.edu.unbosque.view;

import javax.swing.*;

import org.apache.poi.ss.usermodel.Color;

public class VistaLocalPrincipal extends JFrame {

	private VistaLocalRegistroMotocicleta vistaRegistroMoto;
	private VistaLocalRegistroCompra panelRegistroCompra;
	private VistaLocalRegistroVenta panelRegistroVenta;
	private VistaLocalEliminacionMoto panelEliminacionMoto;
	private VistaLocalBusqueda panelBusqueda;
	private VistaLocalExportar panelExportar;

	private JTabbedPane pestanas;

	public VistaLocalPrincipal() {

		super("Sistema de administraci�n almac�n de motos");
		this.setSize(900, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);

		pestanas = new JTabbedPane();
		panelBusqueda = new VistaLocalBusqueda();
		pestanas.add(panelBusqueda, "Buscar");
		vistaRegistroMoto = new VistaLocalRegistroMotocicleta();
		pestanas.add(vistaRegistroMoto, "Registro / Modificaci�n Moto");
		panelEliminacionMoto = new VistaLocalEliminacionMoto();
		pestanas.add(panelEliminacionMoto, "Eliminaci�n Moto");
		panelRegistroCompra = new VistaLocalRegistroCompra();
		pestanas.add(panelRegistroCompra, "Registro Compra");
		panelRegistroVenta = new VistaLocalRegistroVenta();
		pestanas.add(panelRegistroVenta, "Registro Venta");
		panelExportar = new VistaLocalExportar();
		pestanas.add(panelExportar, "Exportar");

		getContentPane().add(pestanas);
		revalidate();
		repaint();
	}

	public VistaLocalRegistroMotocicleta getVistaRegistroMoto() {
		return vistaRegistroMoto;
	}

	public void setVistaRegistroMoto(VistaLocalRegistroMotocicleta vistaRegistroMoto) {
		this.vistaRegistroMoto = vistaRegistroMoto;
	}

	public VistaLocalRegistroCompra getPanelRegistroCompra() {
		return panelRegistroCompra;
	}

	public void setPanelRegistroCompra(VistaLocalRegistroCompra panelRegistroCompra) {
		this.panelRegistroCompra = panelRegistroCompra;
	}

	public VistaLocalRegistroVenta getPanelRegistroVenta() {
		return panelRegistroVenta;
	}

	public void setPanelRegistroVenta(VistaLocalRegistroVenta panelRegistroVenta) {
		this.panelRegistroVenta = panelRegistroVenta;
	}

	public VistaLocalEliminacionMoto getPanelEliminacionMoto() {
		return panelEliminacionMoto;
	}

	public void setPanelEliminacionMoto(VistaLocalEliminacionMoto panelEliminacionMoto) {
		this.panelEliminacionMoto = panelEliminacionMoto;
	}

	public VistaLocalBusqueda getPanelBusqueda() {
		return panelBusqueda;
	}

	public void setPanelBusqueda(VistaLocalBusqueda panelBusqueda) {
		this.panelBusqueda = panelBusqueda;
	}

	public VistaLocalExportar getPanelExportar() {
		return panelExportar;
	}

	public void setPanelExportar(VistaLocalExportar panelExportar) {
		this.panelExportar = panelExportar;
	}

	public JTabbedPane getpestanas() {
		return pestanas;
	}

	public void setpestanas(JTabbedPane pestanas) {
		this.pestanas = pestanas;
	}

}
