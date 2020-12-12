package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;

public class VistaLocalRegistroVenta extends JPanel {

	private final String PROPERTIES_FILE = "/sources/Componentes.properties";

	private JLabel etiquetaFechaVenta;
	private JLabel etiquetaDocumentoCliente;
	private JLabel etiquetaReferencia;
	private JLabel etiquetaTipoDePago;

	private JButton botonRegistrarVenta;

	private JTextField campoTextoFechaVenta;
	private JSpinner campoTextoDocumentoCliente;
	private JComboBox<String> campoTextoReferenciaMoto;
	private JComboBox<String> campoTextoTipoDePago;

	private JPanel containerDatos;
	private JPanel containerBoton;

	public VistaLocalRegistroVenta() {

		setLayout(new BorderLayout());
		// TRabajando con archivo de propiedades
		containerDatos = new JPanel();
		containerDatos.setLayout(new GridLayout(4, 1));
		containerBoton = new JPanel();
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFor = formateador.format(new Date());
		campoTextoFechaVenta = new JTextField(fechaFor);
		campoTextoDocumentoCliente = new JSpinner();
		campoTextoReferenciaMoto = new JComboBox<String>();
		campoTextoTipoDePago = new JComboBox<String>();

		Properties prop = new Properties();

		try {
			InputStream tmp = VistaLocalRegistroVenta.class.getResourceAsStream(PROPERTIES_FILE);
			prop.load(tmp);
			// Etiquetas_______________________________________________
			String listaEtiquetas = prop.getProperty("etiquetaPanelVenta");
			String[] valorEtiquetas = listaEtiquetas.split("~");
			etiquetaFechaVenta = new JLabel(valorEtiquetas[0]);
			etiquetaDocumentoCliente = new JLabel(valorEtiquetas[1]);
			etiquetaReferencia = new JLabel(valorEtiquetas[2]);
			etiquetaTipoDePago = new JLabel(valorEtiquetas[3]);
			// Botones_________________________________________________
			String boton = prop.getProperty("botonPanelVenta");
			botonRegistrarVenta = new JButton(boton);
			String comboBox = prop.getProperty("comboVenta");
			String listaCombo[] = comboBox.split("~");
			for (int i = 0; i < listaCombo.length; i++) {
				campoTextoTipoDePago.addItem(listaCombo[i]);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A ocurrido un error", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		containerDatos.add(etiquetaFechaVenta);
		containerDatos.add(campoTextoFechaVenta);
		containerDatos.add(etiquetaDocumentoCliente);
		containerDatos.add(campoTextoDocumentoCliente);
		containerDatos.add(etiquetaReferencia);
		containerDatos.add(campoTextoReferenciaMoto);
		containerDatos.add(etiquetaTipoDePago);
		containerDatos.add(campoTextoTipoDePago);
		containerBoton.add(botonRegistrarVenta);
		add(containerDatos, BorderLayout.PAGE_START);
		add(containerBoton, BorderLayout.PAGE_END);
	}

	public JLabel getEtiquetaFechaVenta() {
		return etiquetaFechaVenta;
	}

	public void setEtiquetaFechaVenta(JLabel etiquetaFechaVenta) {
		this.etiquetaFechaVenta = etiquetaFechaVenta;
	}

	public JLabel getEtiquetaDocumentoCliente() {
		return etiquetaDocumentoCliente;
	}

	public void setEtiquetaDocumentoCliente(JLabel etiquetaDocumentoCliente) {
		this.etiquetaDocumentoCliente = etiquetaDocumentoCliente;
	}

	public JLabel getEtiquetaReferencia() {
		return etiquetaReferencia;
	}

	public void setEtiquetaReferencia(JLabel etiquetaReferencia) {
		this.etiquetaReferencia = etiquetaReferencia;
	}

	public JLabel getEtiquetaTipoDePago() {
		return etiquetaTipoDePago;
	}

	public void setEtiquetaTipoDePago(JLabel etiquetaTipoDePago) {
		this.etiquetaTipoDePago = etiquetaTipoDePago;
	}

	public JButton getBotonRegistrarVenta() {
		return botonRegistrarVenta;
	}

	public void setBotonRegistrarVenta(JButton botonRegistrarVenta) {
		this.botonRegistrarVenta = botonRegistrarVenta;
	}

	public JTextField getCampoTextoFechaVenta() {
		return campoTextoFechaVenta;
	}

	public void setCampoTextoFechaVenta(JTextField campoTextoFechaVenta) {
		this.campoTextoFechaVenta = campoTextoFechaVenta;
	}

	public JSpinner getCampoTextoDocumentoCliente() {
		return campoTextoDocumentoCliente;
	}

	public void setCampoTextoDocumentoCliente(JSpinner campoTextoDocumentoCliente) {
		this.campoTextoDocumentoCliente = campoTextoDocumentoCliente;
	}

	public JComboBox<String> getCampoTextoReferenciaMoto() {
		return campoTextoReferenciaMoto;
	}

	public void setCampoTextoReferenciaMoto(JComboBox<String> campoTextoReferenciaMoto) {
		this.campoTextoReferenciaMoto = campoTextoReferenciaMoto;
	}

	public JComboBox<String> getCampoTextoTipoDePago() {
		return campoTextoTipoDePago;
	}

	public void setCampoTextoTipoDePago(JComboBox<String> campoTextoTipoDePago) {
		this.campoTextoTipoDePago = campoTextoTipoDePago;
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
