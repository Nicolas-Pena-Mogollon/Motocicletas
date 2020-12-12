package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class MotocicletaDAO {

	private ArrayList<MotocicletaDTO> motocicletasDTO;
	private ArchivoMotocicletas archivoMotocicletas;

	public MotocicletaDAO() {
		this.motocicletasDTO = new ArrayList<MotocicletaDTO>();
		this.archivoMotocicletas = new ArchivoMotocicletas();
	}

	public void crearMoto(String referencia, String cilindraje, String modelo, String marca) {
		this.motocicletasDTO.add(new MotocicletaDTO(referencia, cilindraje, modelo, marca));
		this.archivoMotocicletas.escribirArchivoMotos(motocicletasDTO);
	}

	public ArrayList<MotocicletaDTO> leerMoto() {
		this.motocicletasDTO = this.archivoMotocicletas.leerArchivoMotos();
		return this.motocicletasDTO;
	}

	public String eliminarMoto(String referencia) {
		String salida = "No se ha encontrado la motocicleta seleccionada";
		for (MotocicletaDTO motocicletaDTO : motocicletasDTO) {
			if (referencia.equals(motocicletaDTO.getReferencia())) {
				this.motocicletasDTO.remove(motocicletaDTO);
				salida = "Se ha eliminado la motocicleta";
			}
		}
		return salida;
	}

	/**
	 * @return the motocicletasDTO
	 */
	public ArrayList<MotocicletaDTO> getMotocicletasDTO() {
		return motocicletasDTO;
	}

	/**
	 * @param motocicletasDTO the motocicletasDTO to set
	 */
	public void setMotocicletasDTO(ArrayList<MotocicletaDTO> motocicletasDTO) {
		this.motocicletasDTO = motocicletasDTO;
	}

	/**
	 * @return the archivoMotocicletas
	 */
	public ArchivoMotocicletas getArchivoMotocicletas() {
		return archivoMotocicletas;
	}

	/**
	 * @param archivoMotocicletas the archivoMotocicletas to set
	 */
	public void setArchivoMotocicletas(ArchivoMotocicletas archivoMotocicletas) {
		this.archivoMotocicletas = archivoMotocicletas;
	}

}
