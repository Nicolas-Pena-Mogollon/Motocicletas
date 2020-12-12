package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoVendedor {

	private final String rutaArchivoVendedor = "./DATALOCAL/vendedor.dat";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ArchivoVendedor() {
		this.file = new File(rutaArchivoVendedor);
	}

	public void escribirArchivoVendedor(ArrayList<VendedorDTO> vendedor) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(vendedor);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<VendedorDTO> leerArchivoVendedor() {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<VendedorDTO> vendedor = (ArrayList<VendedorDTO>) ois.readObject();
			ois.close();
			return vendedor;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
