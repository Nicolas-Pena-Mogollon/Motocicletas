package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoClientes {

	private final String rutaArchivoClientes = "./DATALOCAL/clientes.dat";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ArchivoClientes() {
		this.file = new File(rutaArchivoClientes);
	}

	public void escribirArchivoClientes(ArrayList<ClienteDTO> clientes) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(clientes);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ClienteDTO> leerArchivoClientes() {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<ClienteDTO> motos = (ArrayList<ClienteDTO>) ois.readObject();
			ois.close();
			return motos;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
