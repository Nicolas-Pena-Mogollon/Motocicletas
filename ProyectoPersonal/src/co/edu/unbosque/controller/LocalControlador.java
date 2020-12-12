package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import co.edu.unbosque.export.ExportarExcel;
import co.edu.unbosque.export.ExportarPDF;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.OperacionArchivo;
import co.edu.unbosque.view.VistaLocalPrincipal;

public class LocalControlador implements ActionListener {

	private Local local;
	private VistaLocalPrincipal vistaLocalPrincipal;
	private OperacionArchivo opArchivo;
	private final String RUTA_ARCHIVO_MOTO = "/LocalMotosData/ArchivoMotos.txt";
	private final String RUTA_ARCHIVO_VENTA = "/LocalMotosData/ArchivoVenta.txt";
	private final String RUTA_ARCHIVO_COMPRA = "/LocalMotosData/ArchivoCompra.txt";
	private final String RUTA_ARCHIVO_IMAGEN = "/LocalMotosData/Imagenes/";
	private ExportarPDF exportarPDF;
	private ExportarExcel exportarExcel;

	public LocalControlador() {
		this.vistaLocalPrincipal = new VistaLocalPrincipal();
		this.opArchivo = new OperacionArchivo();
		this.local = new Local();
		this.exportarPDF = new ExportarPDF();
		this.exportarExcel = new ExportarExcel();
		actionListener(this);
		actualizarCatalogo();
		actualizarCompras();
		actualizarVentas();
		cargarInformacionJComboBox();
	}

	public void actionListener(ActionListener escuchador) {
		vistaLocalPrincipal.getVistaRegistroMoto().getBotonModificar().addActionListener(escuchador);
		vistaLocalPrincipal.getVistaRegistroMoto().getBotonRegistrar().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelEliminacionMoto().getBotonEliminar().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelRegistroCompra().getBotonRegistrarCompra().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelRegistroVenta().getBotonRegistrarVenta().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelExportar().getBotonExcel().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelExportar().getBotonPDF().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getBotonBuscar().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getBotonRegresar().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getOpcionInformacionGeneral().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getOpcionMayorCilindraje().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getOpcionReferencia().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getOpcionMenorCilindraje().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getOpcionMayorValor().addActionListener(escuchador);
		vistaLocalPrincipal.getPanelBusqueda().getOpcionMenorValor().addActionListener(escuchador);
		vistaLocalPrincipal.getVistaRegistroMoto().getBotonLimpiarCampos().addActionListener(escuchador);
	}

	public void actionPerformed(ActionEvent evento) {

		if (vistaLocalPrincipal.getVistaRegistroMoto().getBotonRegistrar() == evento.getSource()) {
			// Verificaci�n del ingreso de datos
			if (!"".equals(vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoModelo().getText())
					&& (!"".equals(vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoDescripcion().getText()))
					&& (!"".equals(vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoReferencia().getText()))
					&& (!"".equals(
							vistaLocalPrincipal.getVistaRegistroMoto().getDragAndDropPanel().getTa().getText()))) {
				try {
					String pModelo = vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoModelo().getText();
					String pReferencia = vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoReferencia().getText();
					int pValorCompra = (int) vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerValor().getValue();
					int pCilindraje = (int) vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerCilindraje()
							.getValue();
					// Se evita la generaci�n de saltos de l�nea
					String pDescripcion = vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoDescripcion()
							.getText().replace("\n", " ").replace("\r", "");
					String aux = vistaLocalPrincipal.getVistaRegistroMoto().getDragAndDropPanel().getTa().getText();

					// Verificaci�n de la referencia de la motocicleta
					if (local.getCatalogo().verificarReferencia(pReferencia)) {
						JOptionPane.showMessageDialog(null, "Motocicleta existente en el cat�logo!!!", "Warning",
								JOptionPane.WARNING_MESSAGE);

						// Verificaci�n del cilindraje (Valor entre 0 y 10000) y valor compra (No puede
						// ser cero o menor que cero)
					} else if ((pCilindraje > 0) && (pCilindraje < 10000) && (pValorCompra > 0)) {
						// S� es posible la copia de la imagen al proyecto se guarda la informaci�n
						if (CrearImagen(aux, pReferencia)) {
							// Se crea la motocicleta
							Motocicleta objMoto = local.getCatalogo().crearMotocicleta(pReferencia, pModelo,
									pCilindraje, pDescripcion, pValorCompra, pReferencia + ".jpg");
							// Se a�ade al cat�logo
							local.getCatalogo().agregarMotocicleta(objMoto);
							// Se graba en el archivo
							String mensaje = grabarEnArchivoMotos();
							JOptionPane.showMessageDialog(null, mensaje, "Informaci�n",
									JOptionPane.INFORMATION_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null, "Error en la imagen!!!", "Warning",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Valor incorrecto", "Warning", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "A ocurrido un error...", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hay campos requeridos", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			// Se limpian los campos
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoModelo().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoReferencia().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoDescripcion().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerValor().setValue(0);
			vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerCilindraje().setValue(0);
			vistaLocalPrincipal.getVistaRegistroMoto().getDragAndDropPanel().getTa().setText("");

		} else if (vistaLocalPrincipal.getVistaRegistroMoto().getBotonModificar() == evento.getSource()) {
			// Si hay algo en el texto donde se ingresa la imagen, no se guarda la
			// informaci�n, ya que no est� disonible la modificaci�n de la imagen
			if (!"".equals(vistaLocalPrincipal.getVistaRegistroMoto().getDragAndDropPanel().getTa().getText())) {
				JOptionPane.showMessageDialog(null, "No es posible modificar la imagen!!!", "Warning",
						JOptionPane.WARNING_MESSAGE);
				// Se toma la referencia
			} else if (!"".equals(vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoReferencia().getText())) {
				try {
					String pModelo = vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoModelo().getText();
					String pReferencia = vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoReferencia().getText();
					int pValorCompra = (int) vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerValor().getValue();
					int pCilindraje = (int) vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerCilindraje()
							.getValue();
					String pDescripcion = vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoDescripcion()
							.getText();
					// Se verifican los datos
					if ((pCilindraje > 0) && (pCilindraje < 10000) && (pValorCompra > 0)) {
						// Se usa el m�todo
						String recibidor = this.local.getCatalogo().modificarMoto(pReferencia, pModelo, pCilindraje,
								pDescripcion, pValorCompra);
						// Se separa la cadena para obtener la posici�n de la l�nea del archivo a
						// modificar
						String opcion[] = recibidor.split(",");
						int posicion = Integer.parseInt(opcion[1]);
						String mensaje;
						// Si la posici�n es diferente de -1 es porque s� se logr� la modificaci�n
						if (posicion != -1) {
							// Paso de la posici�n al m�todo para modificar esa l�nea
							mensaje = modificarEnArchivoMotos(posicion);
						} else {
							mensaje = opcion[0];
						}
						JOptionPane.showMessageDialog(null, mensaje, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Valor incorrecto", "Warning", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "A ocurrido un error...", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hay campos requeridos", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoModelo().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoDescripcion().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoReferencia().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerValor().setValue(0);
			vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerCilindraje().setValue(0);
			vistaLocalPrincipal.getVistaRegistroMoto().getDragAndDropPanel().getTa().setText("");
		} else if (vistaLocalPrincipal.getPanelEliminacionMoto().getBotonEliminar() == evento.getSource()) {
			if (!"Seleccione".equals(
					vistaLocalPrincipal.getPanelEliminacionMoto().getCampoTextoReferenciaMoto().getSelectedItem())) {
				// Se toma la referencia de la moto que se quiere eliminar
				String pReferencia = (String) vistaLocalPrincipal.getPanelEliminacionMoto()
						.getCampoTextoReferenciaMoto().getSelectedItem();
				// Se toma el nombre de la foto m�s un indicador que determina si hay
				// existencias
				String recibidor[] = (local.getCatalogo().eliminarMoto(pReferencia)).split("~");
				if (Integer.parseInt(recibidor[1]) == 1) {
					// Nombre de la foto a eliminar
					String pFoto = recibidor[0];
					// M�todo que elimina la imagen
					String mensaje = eliminarImagen(pFoto);
					// Se actualiza el archivo
					ActualizarEnArchivoMotos();
					JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
					cargarInformacionJComboBox();
				} else {
					JOptionPane.showMessageDialog(null, "Hay existencias en el sistema", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Escoja una referencia", "Warning", JOptionPane.WARNING_MESSAGE);
			}

		} else if (vistaLocalPrincipal.getPanelRegistroCompra().getBotonRegistrarCompra() == evento.getSource()) {
			// Verificaci�n de los campos a llenar
			if (!"".equals(vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoFechaCompra().getText())
					&& (!"".equals(
							vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoNombreProveedor().getText()))
					&& (!"Seleccione".equals(vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoReferenciaMoto()
							.getSelectedItem()))) {

				String pFecha = vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoFechaCompra().getText();
				String pReferencia = (String) vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoReferenciaMoto()
						.getSelectedItem();
				String pNombre = vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoNombreProveedor().getText();
				int pCantidad = (int) vistaLocalPrincipal.getPanelRegistroCompra().getSpinnerCantidad().getValue();
				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
				Date pFechaCompra = null;
				Date pFechaControlAntes = null;
				Date ahora = null;
				// Se formatea la fecha
				try {
					formateador.setLenient(false);
					pFechaCompra = formateador.parse(pFecha);
					pFechaControlAntes = formateador.parse("31/12/2019");
					// Fecha de hoy
					ahora = new Date();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "A ocurrido un error en la fecha!!!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				// Se verifica la fecha, tiene que ser de inicios del 2020 hasta la fecha
				if (pFechaCompra.after(ahora) || pFechaCompra.before(pFechaControlAntes)) {
					JOptionPane.showMessageDialog(null, "Fecha incorrecta...", "Warning", JOptionPane.WARNING_MESSAGE);
					// Verificaci�n de la cantidad de motos compradas
				} else if (pCantidad > 0) {
					// Se crea el objeto compra
					Compra objCompra = this.local.crearCompra(pFechaCompra, pNombre, pReferencia, pCantidad);
					// Se agrega la compra
					this.local.agregarCompra(objCompra);
					// Se graba en el archivo
					String mensaje = grabarEnArchivoCompra();
					JOptionPane.showMessageDialog(null, mensaje, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
					// Se actualizan las existencias en el archivo de las motos
					ActualizarEnArchivoMotos();
				} else {
					JOptionPane.showMessageDialog(null, "Valor incorrecto", "Warning", JOptionPane.WARNING_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Hay campos requeridos", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoFechaCompra()
					.setText(formateador.format(new Date()));
			vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoNombreProveedor().setText("");
			vistaLocalPrincipal.getPanelRegistroCompra().getSpinnerCantidad().setValue(0);
		} else if (vistaLocalPrincipal.getPanelRegistroVenta().getBotonRegistrarVenta() == evento.getSource()) {
			// Se verifican los campos a llenar
			if (!"".equals(vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoFechaVenta().getText())
					&& ((int) vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoDocumentoCliente()
							.getValue() > 0)
					&& (!"Seleccione".equals(vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoReferenciaMoto()
							.getSelectedItem()))
					&& (!"Seleccione".equals(
							vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoTipoDePago().getSelectedItem()))) {
				String pFecha = vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoFechaVenta().getText();
				String pReferencia = (String) vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoReferenciaMoto()
						.getSelectedItem();
				String pDocumento = (int) vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoDocumentoCliente()
						.getValue() + "";
				String pTipoDePago = (String) vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoTipoDePago()
						.getSelectedItem();
				// Si no hay existencias el valores true y no se permite el registro de la
				// venta.
				if (local.verificarExistencias(pReferencia)) {
					JOptionPane.showMessageDialog(null, "No hay existencias!!!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						// Se formatea la fecha
						SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
						formateador.setLenient(false);
						Date pFechaVenta = formateador.parse(pFecha);
						Date pFechaControlAntes = formateador.parse("31/12/2019");
						// Fecha de hoy
						Date ahora = new Date();
						// Se verifica la fecha igual que en la compra
						if (pFechaVenta.after(ahora) || pFechaVenta.before(pFechaControlAntes)) {
							JOptionPane.showMessageDialog(null, "Fecha incorrecta...", "Warning",
									JOptionPane.WARNING_MESSAGE);
						} else {
							// Se crea el objeto y se agrega a las ventas
							Venta objVenta = this.local.crearVenta(pFechaVenta, pDocumento, pTipoDePago, pReferencia);
							this.local.agregarVenta(objVenta);
							// Se graba en el archivo
							String mensaje = grabarEnArchivoVenta();
							JOptionPane.showMessageDialog(null, mensaje, "Informaci�n",
									JOptionPane.INFORMATION_MESSAGE);
							ActualizarEnArchivoMotos();
						}
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null, "A ocurrido un error...", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hay campos requeridos", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoFechaVenta()
					.setText(formateador.format(new Date()));
			vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoDocumentoCliente().setValue(0);
			// Al seleccionar la busqueda por referencia se habilita el campo para la
			// interacci�n de la b�squeda
		} else if (vistaLocalPrincipal.getPanelBusqueda().getOpcionReferencia() == evento.getSource()) {
			vistaLocalPrincipal.getPanelBusqueda().getCampoTextoReferencia().setVisible(true);
			vistaLocalPrincipal.getPanelBusqueda().getBotonBuscar().setVisible(true);
			vistaLocalPrincipal.getPanelBusqueda().getMenuOpciones().setVisible(false);

		} else if (vistaLocalPrincipal.getPanelBusqueda().getBotonBuscar() == evento.getSource()) {
			// Se verifica la existencia de elementos en el cat�logo
			if (local.getCatalogo().getMotos().isEmpty()) {
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("No hay informaci�n en el cat�logo");
			} else if (!"Seleccione"
					.equals(vistaLocalPrincipal.getPanelBusqueda().getCampoTextoReferencia().getSelectedItem())) {
				String pReferencia = (String) vistaLocalPrincipal.getPanelBusqueda().getCampoTextoReferencia()
						.getSelectedItem();
				// Se pasa la referencia a buscar
				String informacion = this.local.getCatalogo().buscarPorReferencia(pReferencia);
				String aux[] = informacion.split("~");
				// M�todo para mostrar imagen
				mostrarImagen(aux[1]);
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText(aux[0]);
			} else {
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("Seleccione una referencia");

			}
			// Se regresa al men� de b�squeda
		} else if (vistaLocalPrincipal.getPanelBusqueda().getBotonRegresar() == evento.getSource()) {
			vistaLocalPrincipal.getPanelBusqueda().getCampoTextoReferencia().setVisible(false);
			vistaLocalPrincipal.getPanelBusqueda().getBotonBuscar().setVisible(false);
			vistaLocalPrincipal.getPanelBusqueda().getMenuOpciones().setVisible(true);
			vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("");
			vistaLocalPrincipal.getPanelBusqueda().getEtiquetaImagen().setIcon(null);
		} else if (vistaLocalPrincipal.getPanelBusqueda().getOpcionInformacionGeneral() == evento.getSource()) {
			// Se muestra la informaci�n general del cat�logo
			if (local.getCatalogo().getMotos().isEmpty()) {
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("No hay informaci�n en el cat�logo");
			} else {
				String informacion = "Informaci�n b�sica:" + "\n\n" + this.local.getCatalogo().promedioValores()
						+ "\n\n" + this.local.getCatalogo().cantidadCilindrajeMayorMilDos() + "\n\n"
						+ this.local.getCatalogo().cantidadCilindrajeMenorMil() + "\n\n"
						+ this.local.getCatalogo().cantidadRangoCilindraje();
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText(informacion);
			}
		} else if (vistaLocalPrincipal.getPanelBusqueda().getOpcionMayorCilindraje() == evento.getSource()) {
			// Muestra la moto de mayor cilindraje
			if (local.getCatalogo().getMotos().isEmpty()) {
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("No hay informaci�n en el cat�logo");
			} else {
				String informacion = this.local.getCatalogo().motoMayorCilindraje();
				String aux[] = informacion.split("~");
				mostrarImagen(aux[1]);
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText(aux[0]);
			}
		} else if (vistaLocalPrincipal.getPanelBusqueda().getOpcionMenorCilindraje() == evento.getSource()) {
			if (local.getCatalogo().getMotos().isEmpty()) {
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("No hay informaci�n en el cat�logo");
			} else {
				String informacion = this.local.getCatalogo().motoMenorCilindraje();
				String aux[] = informacion.split("~");
				mostrarImagen(aux[1]);
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText(aux[0]);
			}
		} else if (vistaLocalPrincipal.getPanelBusqueda().getOpcionMayorValor() == evento.getSource()) {
			if (local.getCatalogo().getMotos().isEmpty()) {
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("No hay informaci�n en el cat�logo");
			} else {
				String informacion = this.local.getCatalogo().motoMayorValor();
				String aux[] = informacion.split("~");
				mostrarImagen(aux[1]);
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText(aux[0]);
			}
		} else if (vistaLocalPrincipal.getPanelBusqueda().getOpcionMenorValor() == evento.getSource()) {
			if (local.getCatalogo().getMotos().isEmpty()) {
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText("No hay informaci�n en el cat�logo");
			} else {
				String informacion = this.local.getCatalogo().motoMenorValor();
				String aux[] = informacion.split("~");
				mostrarImagen(aux[1]);
				vistaLocalPrincipal.getPanelBusqueda().getCampoMostrar().setText(aux[0]);
			}
			// Bot�nes para exportar
		} else if (vistaLocalPrincipal.getPanelExportar().getBotonPDF() == evento.getSource()) {
			this.exportarPDF.createPDF(this.local.getCompra());
		} else if (vistaLocalPrincipal.getPanelExportar().getBotonExcel() == evento.getSource()) {
			this.exportarExcel.crearExcel(this.local.getVenta());
			// Limpia los campos del registro de las motos para ingresar nuevamente sin
			// guardar nada
		} else if (vistaLocalPrincipal.getVistaRegistroMoto().getBotonLimpiarCampos() == evento.getSource()) {
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoModelo().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoReferencia().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getCampoTextoDescripcion().setText("");
			vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerValor().setValue(0);
			vistaLocalPrincipal.getVistaRegistroMoto().getSpinnerCilindraje().setValue(0);
			vistaLocalPrincipal.getVistaRegistroMoto().getDragAndDropPanel().getTa().setText("");
		}
	}

	// Remueve la informaci�n de los JComboBox y la acrualiza con los arreglos
	public void cargarInformacionJComboBox() {
		vistaLocalPrincipal.getPanelEliminacionMoto().getCampoTextoReferenciaMoto().removeAllItems();
		vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoReferenciaMoto().removeAllItems();
		vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoReferenciaMoto().removeAllItems();
		vistaLocalPrincipal.getPanelBusqueda().getCampoTextoReferencia().removeAllItems();

		vistaLocalPrincipal.getPanelEliminacionMoto().getCampoTextoReferenciaMoto().addItem("Seleccione");
		vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoReferenciaMoto().addItem("Seleccione");
		vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoReferenciaMoto().addItem("Seleccione");
		vistaLocalPrincipal.getPanelBusqueda().getCampoTextoReferencia().addItem("Seleccione");

		for (int i = 0; i < local.getCatalogo().getMotos().size(); i++) {
			vistaLocalPrincipal.getPanelEliminacionMoto().getCampoTextoReferenciaMoto()
					.addItem(local.getCatalogo().getMotos().get(i).getReferencia());
			vistaLocalPrincipal.getPanelRegistroCompra().getCampoTextoReferenciaMoto()
					.addItem(local.getCatalogo().getMotos().get(i).getReferencia());
			vistaLocalPrincipal.getPanelRegistroVenta().getCampoTextoReferenciaMoto()
					.addItem(local.getCatalogo().getMotos().get(i).getReferencia());
			vistaLocalPrincipal.getPanelBusqueda().getCampoTextoReferencia()
					.addItem(local.getCatalogo().getMotos().get(i).getReferencia());
		}
	}

	// Carga la informaci�n del archivo en los arreglos
	public void actualizarCatalogo() {
		ArrayList<Motocicleta> listaDeMotos = this.opArchivo.leerArchivoMotocicleta(new File(RUTA_ARCHIVO_MOTO));
		for (int i = 0; i < listaDeMotos.size(); i++) {
			this.local.getCatalogo().getMotos().add(listaDeMotos.get(i));
		}
	}

	// Carga la informaci�n del archivo en los arreglos
	public void actualizarCompras() {
		ArrayList<Compra> listaDeCompra = this.opArchivo.leerArchivoCompra(new File(RUTA_ARCHIVO_COMPRA));
		for (int i = 0; i < listaDeCompra.size(); i++) {
			this.local.getCompra().add(listaDeCompra.get(i));
		}
	}

	// Carga la informaci�n del archivo en los arreglos
	public void actualizarVentas() {
		ArrayList<Venta> listaDeVenta = this.opArchivo.leerArchivoVenta(new File(RUTA_ARCHIVO_VENTA));
		for (int i = 0; i < listaDeVenta.size(); i++) {
			this.local.getVenta().add(listaDeVenta.get(i));
		}
	}

	// Guarda la informaci�n en el archivo de las motos
	public String grabarEnArchivoMotos() {
		String mensaje = opArchivo.escribirArchivoMoto(new File(RUTA_ARCHIVO_MOTO), local.getCatalogo().getMotos());
		return mensaje;
	}

	// Guarda la informaci�n en el archivo de las compras
	public String grabarEnArchivoCompra() {
		String mensaje = opArchivo.escribirArchivoCompra(new File(RUTA_ARCHIVO_COMPRA), local.getCompra());
		return mensaje;
	}

	// Guarda la informaci�n en el archivo venta
	public String grabarEnArchivoVenta() {
		String mensaje = opArchivo.escribirArchivoVenta(new File(RUTA_ARCHIVO_VENTA), local.getVenta());
		return mensaje;
	}

	// M�todo para modificar una l�nea en el archivo
	public String modificarEnArchivoMotos(int pPosicion) {
		String mensaje = opArchivo.modificarArchivoMoto(new File(RUTA_ARCHIVO_MOTO), local.getCatalogo().getMotos(),
				pPosicion);
		return mensaje;
	}

	// Actualiza la informac�n del archivo donde se encuentran las motos
	public String ActualizarEnArchivoMotos() {
		String mensaje = opArchivo.sobrescribirArchivoMoto(new File(RUTA_ARCHIVO_MOTO), local.getCatalogo().getMotos());
		return mensaje;
	}

	// M�todo para copiar la imagen y pegarla en una nueva ruta
	public boolean CrearImagen(String pAux, String pMoto) {
		boolean mensaje = opArchivo.escritorDeImagenes(pAux, pMoto);
		return mensaje;
	}

	// M�todo para eliminar la imagen
	public String eliminarImagen(String pFoto) {
		String salida = opArchivo.borrarImagen(RUTA_ARCHIVO_IMAGEN + pFoto);
		return salida;
	}

	// M�todo para mostrar la imagen en el label de b�squeda
	public void mostrarImagen(String pFoto) {
		try {
			// Se crea (Obtiene) el archivo
			File a = new File(RUTA_ARCHIVO_IMAGEN + pFoto);
			// Se obtiene toda la ruta y se pasa para crear la imagen
			ImageIcon image = new ImageIcon(a.getAbsolutePath());
			ImageIcon ic = new ImageIcon(
					image.getImage().getScaledInstance(((vistaLocalPrincipal.getPanelBusqueda().getWidth()) - 20) / 2,
							(vistaLocalPrincipal.getPanelBusqueda().getHeight() - 20), Image.SCALE_DEFAULT));
			vistaLocalPrincipal.getPanelBusqueda().getEtiquetaImagen().setIcon(ic);
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "Error al buscar la imagen", "Warning", JOptionPane.WARNING_MESSAGE);
		}

	}
}
