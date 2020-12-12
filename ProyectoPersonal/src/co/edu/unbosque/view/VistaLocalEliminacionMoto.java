package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.*;

public class VistaLocalEliminacionMoto extends JPanel {

	private final String PROPERTIES_FILE = "/sources/Componentes.properties";
	private JLabel etiquetaReferencia;
	private JButton botonEliminar;
	private JComboBox<String> campoTextoReferenciaMoto;
	private JPanel containerDatos;
	private JPanel containerBoton;

	public VistaLocalEliminacionMoto() {
		setLayout(new BorderLayout());
		containerDatos = new JPanel();
		containerDatos.setLayout(new GridLayout(0, 2));
		containerBoton = new JPanel();
		campoTextoReferenciaMoto = new JComboBox<String>();

		// Trabajando con archivo de propiedades
		Properties prop = new Properties();
		try {
			InputStream tmp = VistaLocalEliminacionMoto.class.getResourceAsStream(PROPERTIES_FILE);
			prop.load(tmp);
			// Etiquetas_______________________________________________
			String etiqueta = prop.getProperty("etiquetaPanelEliminacion");
			etiquetaReferencia = new JLabel(etiqueta);
			// Botones_________________________________________________
			String boton = prop.getProperty("botonPanelEliminacion");
			botonEliminar = new JButton(boton);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A ocurrido un error", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		containerDatos.add(etiquetaReferencia);
		containerDatos.add(campoTextoReferenciaMoto);
		containerBoton.add(botonEliminar);
		add(containerDatos, BorderLayout.PAGE_START);
		add(containerBoton, BorderLayout.PAGE_END);
	}

	public JLabel getEtiquetaReferencia() {
		return etiquetaReferencia;
	}

	public void setEtiquetaReferencia(JLabel etiquetaReferencia) {
		this.etiquetaReferencia = etiquetaReferencia;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}

	public JComboBox<String> getCampoTextoReferenciaMoto() {
		return campoTextoReferenciaMoto;
	}

	public void setCampoTextoReferenciaMoto(JComboBox<String> campoTextoReferenciaMoto) {
		this.campoTextoReferenciaMoto = campoTextoReferenciaMoto;
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
