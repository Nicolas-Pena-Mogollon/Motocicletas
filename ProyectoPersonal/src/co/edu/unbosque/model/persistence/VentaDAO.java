package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

public class VentaDAO {

	private ArrayList<VentaDTO> ventasDTO;
	private ArchivoVentas archivoVentas;

	public VentaDAO() {
		this.ventasDTO = new ArrayList<VentaDTO>();
		this.archivoVentas = new ArchivoVentas();
	}

	public void crearVenta(String referencia, Date fecha, String documentoCliente, String documentoVendedor,
			int precioVenta) {
		this.ventasDTO.add(new VentaDTO(referencia, fecha, documentoCliente, documentoVendedor, precioVenta));
		this.archivoVentas.escribirArchivoVentas(ventasDTO);
	}

	public ArrayList<VentaDTO> leerVenta() {
		this.ventasDTO = this.archivoVentas.leerArchivoVentas();
		return this.ventasDTO;
	}

	public String eliminarVenta(String referencia) {
		String salida = "No se ha encontrado la venta seleccionada";
		for (VentaDTO ventasDTO : ventasDTO) {
			if (referencia.equals(ventasDTO.getReferencia())) {
				this.ventasDTO.remove(ventasDTO);
				salida = "Se ha eliminado la venta";
			}
		}

		return salida;
	}

	/**
	 * @return the ventasDTO
	 */
	public ArrayList<VentaDTO> getVentasDTO() {
		return ventasDTO;
	}

	/**
	 * @param ventasDTO the ventasDTO to set
	 */
	public void setVentasDTO(ArrayList<VentaDTO> ventasDTO) {
		this.ventasDTO = ventasDTO;
	}

	/**
	 * @return the archivoVentas
	 */
	public ArchivoVentas getArchivoVentas() {
		return archivoVentas;
	}

	/**
	 * @param archivoVentas the archivoVentas to set
	 */
	public void setArchivoVentas(ArchivoVentas archivoVentas) {
		this.archivoVentas = archivoVentas;
	}

}
