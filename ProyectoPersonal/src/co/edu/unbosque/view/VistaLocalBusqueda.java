package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.*;

public class VistaLocalBusqueda extends JPanel {

	private final String PROPERTIES_FILE = "/sources/Componentes.properties";

	private JMenuBar menuOpciones;
	private JMenu menuNombre;
	private JMenuItem opcionInformacionGeneral;
	private JMenuItem opcionReferencia;
	private JMenuItem opcionMayorValor;
	private JMenuItem opcionMenorValor;
	private JMenuItem opcionMayorCilindraje;
	private JMenuItem opcionMenorCilindraje;

	private JLabel etiquetaImagen;
	private JTextArea campoMostrar;

	private JComboBox<String> campoTextoReferencia;

	private JButton botonBuscar;
	private JButton botonRegresar;

	private JPanel containerMostrar;
	private JPanel containerReferencia;
	private JScrollPane barrita;

	public VistaLocalBusqueda() {
		setLayout(new BorderLayout());
		containerMostrar = new JPanel();
		containerMostrar.setLayout(new GridLayout(1, 2));
		containerReferencia = new JPanel();
		containerReferencia.setLayout(new GridLayout(1, 3));
		campoTextoReferencia = new JComboBox<String>();
		campoTextoReferencia.setVisible(false);
		menuOpciones = new JMenuBar();

		// Trabajando con archivo de propiedades
		Properties prop = new Properties();
		try {
			InputStream tmp = VistaLocalBusqueda.class.getResourceAsStream(PROPERTIES_FILE);
			prop.load(tmp);

			// Nombre menu_____________________________________________
			String nombreMenu = prop.getProperty("menuPanelBusqueda");
			menuNombre = new JMenu(nombreMenu);
			// Se añade________________________________________________
			menuOpciones.add(menuNombre);

			// Elementos del JMenu_____________________________________
			String listaMenu = prop.getProperty("itemMenuPanelBusqueda");
			String[] valorMenu = listaMenu.split("~");

			opcionInformacionGeneral = new JMenuItem(valorMenu[0]);
			opcionReferencia = new JMenuItem(valorMenu[1]);
			opcionMayorValor = new JMenuItem(valorMenu[2]);
			opcionMenorValor = new JMenuItem(valorMenu[3]);
			opcionMayorCilindraje = new JMenuItem(valorMenu[4]);
			opcionMenorCilindraje = new JMenuItem(valorMenu[5]);

			menuNombre.add(opcionInformacionGeneral);
			menuNombre.add(new JSeparator());
			menuNombre.add(opcionReferencia);
			menuNombre.add(new JSeparator());
			menuNombre.add(opcionMayorValor);
			menuNombre.add(new JSeparator());
			menuNombre.add(opcionMenorValor);
			menuNombre.add(new JSeparator());
			menuNombre.add(opcionMayorCilindraje);
			menuNombre.add(new JSeparator());
			menuNombre.add(opcionMenorCilindraje);
			menuNombre.add(new JSeparator());

			// Etiquetas_______________________________________________
			etiquetaImagen = new JLabel("");
			campoMostrar = new JTextArea();
			campoMostrar.setLineWrap(true);
			campoMostrar.setWrapStyleWord(true);
			campoMostrar.setOpaque(false);
			campoMostrar.setEditable(false);
			// Botones_________________________________________________
			String listaBotones = prop.getProperty("botonPanelBusqueda");
			String valorBotones[] = listaBotones.split("~");
			botonBuscar = new JButton(valorBotones[0]);
			botonRegresar = new JButton(valorBotones[1]);
			botonBuscar.setVisible(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A ocurrido un error", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		add(menuOpciones, BorderLayout.PAGE_START);
		containerMostrar.add(campoMostrar);
		containerMostrar.add(etiquetaImagen);
		barrita = new JScrollPane(containerMostrar);
		containerReferencia.add(campoTextoReferencia);
		containerReferencia.add(botonBuscar);
		containerReferencia.add(botonRegresar);
		add(barrita, BorderLayout.CENTER);
		add(containerReferencia, BorderLayout.PAGE_END);
	}

	public JMenuBar getMenuOpciones() {
		return menuOpciones;
	}

	public void setMenuOpciones(JMenuBar menuOpciones) {
		this.menuOpciones = menuOpciones;
	}

	public JMenu getMenuNombre() {
		return menuNombre;
	}

	public void setMenuNombre(JMenu menuNombre) {
		this.menuNombre = menuNombre;
	}

	public JMenuItem getOpcionInformacionGeneral() {
		return opcionInformacionGeneral;
	}

	public void setOpcionInformacionGeneral(JMenuItem opcionInformacionGeneral) {
		this.opcionInformacionGeneral = opcionInformacionGeneral;
	}

	public JMenuItem getOpcionReferencia() {
		return opcionReferencia;
	}

	public void setOpcionReferencia(JMenuItem opcionReferencia) {
		this.opcionReferencia = opcionReferencia;
	}

	public JMenuItem getOpcionMayorValor() {
		return opcionMayorValor;
	}

	public void setOpcionMayorValor(JMenuItem opcionMayorValor) {
		this.opcionMayorValor = opcionMayorValor;
	}

	public JMenuItem getOpcionMenorValor() {
		return opcionMenorValor;
	}

	public void setOpcionMenorValor(JMenuItem opcionMenorValor) {
		this.opcionMenorValor = opcionMenorValor;
	}

	public JMenuItem getOpcionMayorCilindraje() {
		return opcionMayorCilindraje;
	}

	public void setOpcionMayorCilindraje(JMenuItem opcionMayorCilindraje) {
		this.opcionMayorCilindraje = opcionMayorCilindraje;
	}

	public JMenuItem getOpcionMenorCilindraje() {
		return opcionMenorCilindraje;
	}

	public void setOpcionMenorCilindraje(JMenuItem opcionMenorCilindraje) {
		this.opcionMenorCilindraje = opcionMenorCilindraje;
	}

	public JLabel getEtiquetaImagen() {
		return etiquetaImagen;
	}

	public void setEtiquetaImagen(JLabel etiquetaImagen) {
		this.etiquetaImagen = etiquetaImagen;
	}

	public JTextArea getCampoMostrar() {
		return campoMostrar;
	}

	public void setCampoMostrar(JTextArea campoMostrar) {
		this.campoMostrar = campoMostrar;
	}

	public JComboBox<String> getCampoTextoReferencia() {
		return campoTextoReferencia;
	}

	public void setCampoTextoReferencia(JComboBox<String> campoTextoReferencia) {
		this.campoTextoReferencia = campoTextoReferencia;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}

	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
	}

	public JPanel getContainerMostrar() {
		return containerMostrar;
	}

	public void setContainerMostrar(JPanel containerMostrar) {
		this.containerMostrar = containerMostrar;
	}

	public JPanel getContainerReferencia() {
		return containerReferencia;
	}

	public void setContainerReferencia(JPanel containerReferencia) {
		this.containerReferencia = containerReferencia;
	}

	public JScrollPane getBarrita() {
		return barrita;
	}

	public void setBarrita(JScrollPane barrita) {
		this.barrita = barrita;
	}

	public String getPROPERTIES_FILE() {
		return PROPERTIES_FILE;
	}

}