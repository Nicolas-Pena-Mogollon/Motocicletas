package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class VendedorDAO {

	private ArrayList<VendedorDTO> vendedorDTO;
	private ArchivoVendedor archivoVendedor;

	public VendedorDAO() {
		this.vendedorDTO = new ArrayList<VendedorDTO>();
		this.archivoVendedor = new ArchivoVendedor();
	}

	public void crearVendedor(String documentoVendedor, String nombre, String celular, String direccion,
			double sueldo) {
		this.vendedorDTO.add(new VendedorDTO(documentoVendedor, nombre, celular, direccion, sueldo));
		this.archivoVendedor.escribirArchivoVendedor(vendedorDTO);
	}

	public ArrayList<VendedorDTO> leerVendedor() {
		this.vendedorDTO = this.archivoVendedor.leerArchivoVendedor();
		return this.vendedorDTO;
	}

	public boolean editarVendedor(String documentoVendedor, String nombre, String celular, String direccion,
			double sueldo) {
		boolean verificar = false;
		for (VendedorDTO vendedorDTO : vendedorDTO) {
			if (documentoVendedor.equals(vendedorDTO.getDocumentoVendedor())) {
			 if (!nombre.equals("")) {
					vendedorDTO.setNombre(nombre);
				} else if (!celular.equals("")) {
					vendedorDTO.setCelular(celular);
				} else if (!direccion.equals("")) {
					vendedorDTO.setDireccion(direccion);
				} else if (!(sueldo == 0)) {
					vendedorDTO.setSueldo(sueldo);
				}
				this.archivoVendedor.escribirArchivoVendedor(this.vendedorDTO);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

	public String eliminarVendedor(String documentoVendedor) {
		String salida = "No se ha encontrado el vendedor seleccionado";
		for (VendedorDTO vendedorDTO : vendedorDTO) {
			if (documentoVendedor.equals(vendedorDTO.getDocumentoVendedor())) {
				this.vendedorDTO.remove(vendedorDTO);
				salida = "Se ha eliminado el vendedor";
			}
		}

		return salida;
	}

	/**
	 * @return the vendedorDTO
	 */
	public ArrayList<VendedorDTO> getVendedorDTO() {
		return vendedorDTO;
	}

	/**
	 * @param vendedorDTO the vendedorDTO to set
	 */
	public void setVendedorDTO(ArrayList<VendedorDTO> vendedorDTO) {
		this.vendedorDTO = vendedorDTO;
	}

	/**
	 * @return the archivoVendedor
	 */
	public ArchivoVendedor getArchivoVendedor() {
		return archivoVendedor;
	}

	/**
	 * @param archivoVendedor the archivoVendedor to set
	 */
	public void setArchivoVendedor(ArchivoVendedor archivoVendedor) {
		this.archivoVendedor = archivoVendedor;
	}

}
