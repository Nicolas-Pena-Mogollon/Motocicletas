package co.edu.unbosque.view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import co.edu.unbosque.controller.LocalControlador;
import com.jtattoo.plaf.noire.*;

public class AplMainLocal {

	public static void main(String[] args) {
		try {
			// Uso de otra librer�a (JTatoo)
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		LocalControlador controlador = new LocalControlador();
	}

}