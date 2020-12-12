package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class ClienteDAO {

	private ArrayList<ClienteDTO> clienteDTOs;
	private ArchivoClientes archivoClientes;

	public ClienteDAO() {
		this.clienteDTOs = new ArrayList<ClienteDTO>();
		this.archivoClientes = new ArchivoClientes();
	}

	public void crearCliente(String documento, String nombre, String sexo, String celular, String direccion) {
		this.clienteDTOs.add(new ClienteDTO(documento, nombre, sexo, celular, direccion));
		this.archivoClientes.escribirArchivoClientes(clienteDTOs);
	}

	public ArrayList<ClienteDTO> leerMoto() {
		this.clienteDTOs = this.archivoClientes.leerArchivoClientes();
		return this.clienteDTOs;
	}

	public String eliminarCliente(String documento) {
		String salida = "No se ha encontrado el cliente seleccionado";
		for (ClienteDTO clienteDTO : clienteDTOs) {
			if (documento.equals(clienteDTO.getDocumento())) {
				this.clienteDTOs.remove(clienteDTO);
				salida = "Se ha eliminado el cliente";
			}
		}

		return salida;
	}

	/**
	 * @return the clienteDTOs
	 */
	public ArrayList<ClienteDTO> getClienteDTOs() {
		return clienteDTOs;
	}

	/**
	 * @param clienteDTOs the clienteDTOs to set
	 */
	public void setClienteDTOs(ArrayList<ClienteDTO> clienteDTOs) {
		this.clienteDTOs = clienteDTOs;
	}

	/**
	 * @return the archivoClientes
	 */
	public ArchivoClientes getArchivoClientes() {
		return archivoClientes;
	}

	/**
	 * @param archivoClientes the archivoClientes to set
	 */
	public void setArchivoClientes(ArchivoClientes archivoClientes) {
		this.archivoClientes = archivoClientes;
	}

}
