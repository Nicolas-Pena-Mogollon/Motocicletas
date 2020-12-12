package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoVentas {

	private final String rutaArchivoVentas = "./DATALOCAL/ventas.dat";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ArchivoVentas() {
		this.file = new File(rutaArchivoVentas);
	}

	public void escribirArchivoVentas(ArrayList<VentaDTO> ventas) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(ventas);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<VentaDTO> leerArchivoVentas() {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<VentaDTO> ventas = (ArrayList<VentaDTO>) ois.readObject();
			ois.close();
			return ventas;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
