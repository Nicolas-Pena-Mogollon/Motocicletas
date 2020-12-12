package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

public class CompraDAO {

	private ArrayList<CompraDTO> comprasDTO;
	private ArchivoCompras archivoCompras;

	public CompraDAO() {
		this.comprasDTO = new ArrayList<CompraDTO>();
		this.archivoCompras = new ArchivoCompras();
	}

	public void crearCompra(Date fecha, String precioCompra, String referencia) {
		this.comprasDTO.add(new CompraDTO(fecha, precioCompra, referencia));
		this.archivoCompras.escribirArchivoCompras(comprasDTO);
	}

	public ArrayList<CompraDTO> leerCompra() {
		this.comprasDTO = this.archivoCompras.leerArchivoCompras();
		return this.comprasDTO;
	}

	public String eliminarCompra(String referencia) {
		String salida = "No se ha encontrado el cliente seleccionado";
		for (CompraDTO comprasDTO : comprasDTO) {
			if (referencia.equals(comprasDTO.getReferencia())) {
				this.comprasDTO.remove(comprasDTO);
				salida = "Se ha eliminado el cliente";
			}
		}

		return salida;
	}

	/**
	 * @return the comprasDTO
	 */
	public ArrayList<CompraDTO> getComprasDTO() {
		return comprasDTO;
	}

	/**
	 * @param comprasDTO the comprasDTO to set
	 */
	public void setComprasDTO(ArrayList<CompraDTO> comprasDTO) {
		this.comprasDTO = comprasDTO;
	}

	/**
	 * @return the archivoCompras
	 */
	public ArchivoCompras getArchivoCompras() {
		return archivoCompras;
	}

	/**
	 * @param archivoCompras the archivoCompras to set
	 */
	public void setArchivoCompras(ArchivoCompras archivoCompras) {
		this.archivoCompras = archivoCompras;
	}

}
