package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoMotocicletas {

	private final String rutaArchivoMotocicleta = "./DATALOCAL/motocicletas.dat";
	private File file;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ArchivoMotocicletas() {
		this.file = new File(rutaArchivoMotocicleta);
	}

	public void escribirArchivoMotos(ArrayList<MotocicletaDTO> motos) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(motos);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<MotocicletaDTO> leerArchivoMotos() {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<MotocicletaDTO> motos = (ArrayList<MotocicletaDTO>) ois.readObject();
			ois.close();
			return motos;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
