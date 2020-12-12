package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoCompras {

	private final String rutaArchivoCompras = "./DATALOCAL/compras.dat";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ArchivoCompras() {
		this.file = new File(rutaArchivoCompras);
	}

	public void escribirArchivoCompras(ArrayList<CompraDTO> compras) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(compras);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CompraDTO> leerArchivoCompras() {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<CompraDTO> compras = (ArrayList<CompraDTO>) ois.readObject();
			ois.close();
			return compras;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
