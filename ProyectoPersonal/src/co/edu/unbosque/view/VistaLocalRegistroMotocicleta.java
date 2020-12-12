package co.edu.unbosque.view;

import java.awt.*;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.*;

public class VistaLocalRegistroMotocicleta extends JPanel {

	private final String PROPERTIES_FILE = "/sources/Componentes.properties";

	private JLabel etiquetaModelo;
	private JLabel etiquetaReferencia;
	private JLabel etiquetaValor;
	private JLabel etiquetaCilindraje;
	private JLabel etiquetaDescripcion;

	private JTextField campoTextoModelo;
	private JTextField campoTextoReferencia;
	private JTextArea campoTextoDescripcion;

	private JButton botonModificar;
	private JButton botonRegistrar;
	private JButton botonLimpiarCampos;

	private JSpinner spinnerValor;
	private JSpinner spinnerCilindraje;

	private JPanel containerRecibir;
	private JPanel containerBotones;

	private JScrollPane barrita;

	private DragAndDropPanel dragAndDropPanel;

	public VistaLocalRegistroMotocicleta() {
		setLayout(new BorderLayout());
		containerRecibir = new JPanel();
		containerRecibir.setLayout(new GridLayout(5, 1));
		containerBotones = new JPanel();
		dragAndDropPanel = new DragAndDropPanel();

		campoTextoReferencia = new JTextField(20);
		campoTextoModelo = new JTextField(20);
		spinnerValor = new JSpinner();
		spinnerCilindraje = new JSpinner();

		campoTextoDescripcion = new JTextArea(2, 0);
		campoTextoDescripcion.setLineWrap(true);
		campoTextoDescripcion.setWrapStyleWord(true);
		barrita = new JScrollPane(campoTextoDescripcion);

		// Trabajando con archivo de propiedades
		Properties prop = new Properties();
		try {
			InputStream tmp = VistaLocalRegistroMotocicleta.class.getResourceAsStream(PROPERTIES_FILE);
			prop.load(tmp);

			// Etiquetas_______________________________________________
			String listaEtiquetas = prop.getProperty("etiquetasPanelRegistro");
			String[] valorEtiquetas = listaEtiquetas.split("~");
			etiquetaModelo = new JLabel(valorEtiquetas[0]);
			etiquetaReferencia = new JLabel(valorEtiquetas[1]);
			etiquetaValor = new JLabel(valorEtiquetas[2]);
			etiquetaCilindraje = new JLabel(valorEtiquetas[3]);
			etiquetaDescripcion = new JLabel(valorEtiquetas[4]);

			// Botones_________________________________________________
			String listaBotones = prop.getProperty("botonesPanelRegistro");
			String[] valorBotones = listaBotones.split("~");
			botonModificar = new JButton(valorBotones[0]);
			botonRegistrar = new JButton(valorBotones[1]);
			botonLimpiarCampos = new JButton(valorBotones[2]);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A ocurrido un error", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		containerRecibir.add(etiquetaModelo);
		containerRecibir.add(campoTextoModelo);
		containerRecibir.add(etiquetaReferencia);
		containerRecibir.add(campoTextoReferencia);
		containerRecibir.add(etiquetaValor);
		containerRecibir.add(spinnerValor);
		containerRecibir.add(etiquetaCilindraje);
		containerRecibir.add(spinnerCilindraje);
		containerRecibir.add(etiquetaDescripcion);
		containerRecibir.add(barrita);
		containerBotones.add(botonModificar);
		containerBotones.add(botonRegistrar);
		containerBotones.add(botonLimpiarCampos);
		add(containerRecibir, BorderLayout.PAGE_START);
		add(dragAndDropPanel, BorderLayout.CENTER);
		add(containerBotones, BorderLayout.PAGE_END);
	}

	public JLabel getEtiquetaModelo() {
		return etiquetaModelo;
	}

	public void setEtiquetaModelo(JLabel etiquetaModelo) {
		this.etiquetaModelo = etiquetaModelo;
	}

	public JLabel getEtiquetaReferencia() {
		return etiquetaReferencia;
	}

	public void setEtiquetaReferencia(JLabel etiquetaReferencia) {
		this.etiquetaReferencia = etiquetaReferencia;
	}

	public JLabel getEtiquetaValor() {
		return etiquetaValor;
	}

	public void setEtiquetaValor(JLabel etiquetaValor) {
		this.etiquetaValor = etiquetaValor;
	}

	public JLabel getEtiquetaCilindraje() {
		return etiquetaCilindraje;
	}

	public void setEtiquetaCilindraje(JLabel etiquetaCilindraje) {
		this.etiquetaCilindraje = etiquetaCilindraje;
	}

	public JLabel getEtiquetaDescripcion() {
		return etiquetaDescripcion;
	}

	public void setEtiquetaDescripcion(JLabel etiquetaDescripcion) {
		this.etiquetaDescripcion = etiquetaDescripcion;
	}

	public JTextField getCampoTextoModelo() {
		return campoTextoModelo;
	}

	public void setCampoTextoModelo(JTextField campoTextoModelo) {
		this.campoTextoModelo = campoTextoModelo;
	}

	public JTextField getCampoTextoReferencia() {
		return campoTextoReferencia;
	}

	public void setCampoTextoReferencia(JTextField campoTextoReferencia) {
		this.campoTextoReferencia = campoTextoReferencia;
	}

	public JTextArea getCampoTextoDescripcion() {
		return campoTextoDescripcion;
	}

	public void setCampoTextoDescripcion(JTextArea campoTextoDescripcion) {
		this.campoTextoDescripcion = campoTextoDescripcion;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	public void setBotonRegistrar(JButton botonRegistrar) {
		this.botonRegistrar = botonRegistrar;
	}

	public JButton getBotonLimpiarCampos() {
		return botonLimpiarCampos;
	}

	public void setBotonLimpiarCampos(JButton botonLimpiarCampos) {
		this.botonLimpiarCampos = botonLimpiarCampos;
	}

	public JSpinner getSpinnerValor() {
		return spinnerValor;
	}

	public void setSpinnerValor(JSpinner spinnerValor) {
		this.spinnerValor = spinnerValor;
	}

	public JSpinner getSpinnerCilindraje() {
		return spinnerCilindraje;
	}

	public void setSpinnerCilindraje(JSpinner spinnerCilindraje) {
		this.spinnerCilindraje = spinnerCilindraje;
	}

	public JPanel getContainerRecibir() {
		return containerRecibir;
	}

	public void setContainerRecibir(JPanel containerRecibir) {
		this.containerRecibir = containerRecibir;
	}

	public JPanel getContainerBotones() {
		return containerBotones;
	}

	public void setContainerBotones(JPanel containerBotones) {
		this.containerBotones = containerBotones;
	}

	public JScrollPane getBarrita() {
		return barrita;
	}

	public void setBarrita(JScrollPane barrita) {
		this.barrita = barrita;
	}

	public DragAndDropPanel getDragAndDropPanel() {
		return dragAndDropPanel;
	}

	public void setDragAndDropPanel(DragAndDropPanel dragAndDropPanel) {
		this.dragAndDropPanel = dragAndDropPanel;
	}

	public String getPROPERTIES_FILE() {
		return PROPERTIES_FILE;
	}

}