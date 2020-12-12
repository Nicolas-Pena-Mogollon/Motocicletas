package co.edu.unbosque.view;

import java.awt.GridLayout;
import javax.swing.*;

public class VistaLocalExportar extends JPanel {

	private final String PDF = "/sources/PDF.jpg";
	private final String EXCEL = "/sources/EXCEL.jpg";

	private JButton botonPDF;
	private JButton botonExcel;

	public VistaLocalExportar() {
		setLayout(new GridLayout(1, 2));
		try {
			botonPDF = new JButton();
			botonExcel = new JButton();
			botonPDF.setIcon(new ImageIcon(getClass().getResource(PDF)));
			botonExcel.setIcon(new ImageIcon(getClass().getResource(EXCEL)));
			botonPDF.setToolTipText("Información de las compras");
			botonExcel.setToolTipText("Información de las ventas");
			add(botonPDF);
			add(botonExcel);
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "Error al buscar la imagen exportar", "Warning",
					JOptionPane.WARNING_MESSAGE);

		}
	}

	public JButton getBotonPDF() {
		return botonPDF;
	}

	public void setBotonPDF(JButton botonPDF) {
		this.botonPDF = botonPDF;
	}

	public JButton getBotonExcel() {
		return botonExcel;
	}

	public void setBotonExcel(JButton botonExcel) {
		this.botonExcel = botonExcel;
	}

	public String getPDF() {
		return PDF;
	}

	public String getEXCEL() {
		return EXCEL;
	}

}
