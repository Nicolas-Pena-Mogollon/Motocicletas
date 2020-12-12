package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;

public class VistaLocalRegistroCompra extends JPanel {

	private final String PROPERTIES_FILE = "/sources/Componentes.properties";

	private JLabel etiquetaFechaCompra;
	private JLabel etiquetaNombreProveedor;
	private JLabel etiquetaReferencia;
	private JLabel etiquetaCantidad;

	private JButton botonRegistrarCompra;

	private JTextField campoTextoFechaCompra;
	private JTextField campoTextoNombreProveedor;
	private JComboBox<String> campoTextoReferenciaMoto;

	private JSpinner spinnerCantidad;

	private JPanel containerDatos;
	private JPanel containerBoton;

	public VistaLocalRegistroCompra() {

		setLayout(new BorderLayout());
		containerDatos = new JPanel();
		containerDatos.setLayout(new GridLayout(4, 1));
		containerBoton = new JPanel();

		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFor = formateador.format(new Date());
		campoTextoFechaCompra = new JTextField(fechaFor);
		campoTextoNombreProveedor = new JTextField(20);
		campoTextoReferenciaMoto = new JComboBox<String>();
		spinnerCantidad = new JSpinner();

		// Trabajando con archivo de propiedades
		Properties prop = new Properties();
		try {
			InputStream tmp = VistaLocalRegistroCompra.class.getResourceAsStream(PROPERTIES_FILE);
			prop.load(tmp);
			// Etiquetas_______________________________________________
			String listaEtiquetas = prop.getProperty("etiquetasPanelCompra");
			String[] valorEtiquetas = listaEtiquetas.split("~");
			etiquetaFechaCompra = new JLabel(valorEtiquetas[0]);
			etiquetaNombreProveedor = new JLabel(valorEtiquetas[1]);
			etiquetaReferencia = new JLabel(valorEtiquetas[2]);
			etiquetaCantidad = new JLabel(valorEtiquetas[3]);
			// Botones_________________________________________________
			String boton = prop.getProperty("botonPanelCompra");
			botonRegistrarCompra = new JButton(boton);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A ocurrido un error", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		containerDatos.add(etiquetaFechaCompra);
		containerDatos.add(campoTextoFechaCompra);
		containerDatos.add(etiquetaNombreProveedor);
		containerDatos.add(campoTextoNombreProveedor);
		containerDatos.add(etiquetaReferencia);
		containerDatos.add(campoTextoReferenciaMoto);
		containerDatos.add(etiquetaCantidad);
		containerDatos.add(spinnerCantidad);
		containerBoton.add(botonRegistrarCompra);
		add(containerDatos, BorderLayout.PAGE_START);
		add(containerBoton, BorderLayout.PAGE_END);
	}

	public JLabel getEtiquetaFechaCompra() {
		return etiquetaFechaCompra;
	}

	public void setEtiquetaFechaCompra(JLabel etiquetaFechaCompra) {
		this.etiquetaFechaCompra = etiquetaFechaCompra;
	}

	public JLabel getEtiquetaNombreProveedor() {
		return etiquetaNombreProveedor;
	}

	public void setEtiquetaNombreProveedor(JLabel etiquetaNombreProveedor) {
		this.etiquetaNombreProveedor = etiquetaNombreProveedor;
	}

	public JLabel getEtiquetaReferencia() {
		return etiquetaReferencia;
	}

	public void setEtiquetaReferencia(JLabel etiquetaReferencia) {
		this.etiquetaReferencia = etiquetaReferencia;
	}

	public JLabel getEtiquetaCantidad() {
		return etiquetaCantidad;
	}

	public void setEtiquetaCantidad(JLabel etiquetaCantidad) {
		this.etiquetaCantidad = etiquetaCantidad;
	}

	public JButton getBotonRegistrarCompra() {
		return botonRegistrarCompra;
	}

	public void setBotonRegistrarCompra(JButton botonRegistrarCompra) {
		this.botonRegistrarCompra = botonRegistrarCompra;
	}

	public JTextField getCampoTextoFechaCompra() {
		return campoTextoFechaCompra;
	}

	public void setCampoTextoFechaCompra(JTextField campoTextoFechaCompra) {
		this.campoTextoFechaCompra = campoTextoFechaCompra;
	}

	public JTextField getCampoTextoNombreProveedor() {
		return campoTextoNombreProveedor;
	}

	public void setCampoTextoNombreProveedor(JTextField campoTextoNombreProveedor) {
		this.campoTextoNombreProveedor = campoTextoNombreProveedor;
	}

	public JComboBox<String> getCampoTextoReferenciaMoto() {
		return campoTextoReferenciaMoto;
	}

	public void setCampoTextoReferenciaMoto(JComboBox<String> campoTextoReferenciaMoto) {
		this.campoTextoReferenciaMoto = campoTextoReferenciaMoto;
	}

	public JSpinner getSpinnerCantidad() {
		return spinnerCantidad;
	}

	public void setSpinnerCantidad(JSpinner spinnerCantidad) {
		this.spinnerCantidad = spinnerCantidad;
	}

	public JPanel getContainerDatos() {
		return containerDatos;
	}

	public void setContainerDatos(JPanel containerDatos) {
		this.containerDatos = containerDatos;
	}

	public JPanel getContainerBoton() {
		return containerBoton;
	}

	public void setContainerBoton(JPanel containerBoton) {
		this.containerBoton = containerBoton;
	}

	public String getPROPERTIES_FILE() {
		return PROPERTIES_FILE;
	}

}
