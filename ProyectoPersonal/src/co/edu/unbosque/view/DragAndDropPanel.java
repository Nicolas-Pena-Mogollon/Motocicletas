package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.*;

public class DragAndDropPanel extends JPanel implements DropTargetListener {

	private final String PROPERTIES_FILE = "/sources/Componentes.properties";
	private DropTarget dt;
	private JTextArea ta;

	public DragAndDropPanel() {
		setLayout(new BorderLayout());
		setSize(300, 300);
		Properties prop = new Properties();

		try {
			InputStream tmp = VistaLocalRegistroVenta.class.getResourceAsStream(PROPERTIES_FILE);
			prop.load(tmp);
			// Etiquetas_______________________________________________
			String listaEtiquetas = prop.getProperty("dragAndDropLabels");
			String[] valorEtiquetas = listaEtiquetas.split("~");
			add(new JLabel(valorEtiquetas[0]), BorderLayout.NORTH);
			add(new JLabel(valorEtiquetas[1]), BorderLayout.SOUTH);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "A ocurrido un error", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		ta = new JTextArea(0, 2);
		ta.setEditable(false);
		ta.setBackground(new Color(194, 210, 214));
		add(ta, BorderLayout.CENTER);
		// El DropTarget se asocia con un componente cuando ese componente desea aceptar
		// un drop durante las operaciones de drag and drop, en este caso es el
		// JTextArea ta, al cual se le debe asignar un listener (DropTargetListener)
		dt = new DropTarget(ta, this);
		setVisible(true);
	}

	// Métodos por defecto de la interfaz, no se usan ya que no es necesario saber
	// cuándo el puntero está arrastrando el elemento, cuándo sale de la parte
	// operativa, cuándo está sobre esta o cuándo se hacen modificaciones

	public void dragEnter(DropTargetDragEvent dtde) {
	}

	public void dragExit(DropTargetEvent dte) {
	}

	public void dragOver(DropTargetDragEvent dtde) {
	}

	public void dropActionChanged(DropTargetDragEvent dtde) {
	}

	// Método de DropTargetListener, que usa DropTargetDropEvent para generar el
	// evento al terminar la operación de arrastre
	public void drop(DropTargetDropEvent dtde) {
		try {
			// El método getTransferable de la clase DropTargetDropEvent retorna un objeto
			// Transferable asociado con el Drop. Cuando el usuario interviene con el drop.
			// Este se almacena en tr. Un objeto de la clase Transferable para que se puedan
			// proporcionar los datos en la operación de transferencia.
			Transferable tr = dtde.getTransferable();

			// Devuelve una matriz de objetos DataFlavor (Clase que encapsula un tipo de
			// contenido (datos), normalmente MIME) que indica los tipos en los que se
			// pueden proporcionar los datos. (docs.oracle)
			DataFlavor[] flavors = tr.getTransferDataFlavors();
			for (int i = 0; i < flavors.length; i++) {
				// Se verifica si el tipo de datos representa una lista de objetos de archivo
				if (flavors[i].isFlavorJavaFileListType()) {
					// Se acepta el Drop y DnDConstants.ACTION_COPY_OR_MOVE determina que se copian
					// los datos
					dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
					// El método getTransferData retorna un objeto que representa los datos a
					// transferir que toma de flavors en la posición i, para luego añadirlos a una
					// lista
					java.util.List list = (java.util.List) tr.getTransferData(flavors[i]);
					// Se añade la ruta o el nombre del archivo al área de texto
					for (int j = 0; j < list.size(); j++) {
						// El método apend añade nueva información
						ta.append(list.get(j) + "\n");
					}
					// Se da por terminado el drop
					dtde.dropComplete(true);
				} else {
					i = flavors.length;
					JOptionPane.showMessageDialog(null, "Error al insetar imagen!!!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			dtde.rejectDrop();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al insetar imagen!!!", "Warning", JOptionPane.WARNING_MESSAGE);
			dtde.rejectDrop();
		}
	}

	// Getters and Setters
	public DropTarget getDt() {
		return dt;
	}

	public void setDt(DropTarget dt) {
		this.dt = dt;
	}

	public JTextArea getTa() {
		return ta;
	}

	public void setTa(JTextArea ta) {
		this.ta = ta;
	}

}