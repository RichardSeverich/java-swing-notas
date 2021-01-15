package vistas.eventos;

import datos.ConexionDelete;
import datos.ConexionSelectTieneRelacion;

import listas.ContainerListas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import vistas.componentes.ComponentesMateriasMostrar;
import vistas.componentes.ComponentesMateriasRegistrar;
import vistas.ventanas.VentanaContainer;

import javax.swing.JOptionPane;

/**
* Class.
*/
public class EventosMateriasMostrar extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosMateriasMostrar() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesMateriasMostrar
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesMateriasMostrar.table.getRowHeight();
    Object value = ComponentesMateriasMostrar.table.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton == "Editar") {
        this.editar(row);
      } else if (nombreBoton == "Eliminar") {
        this.eliminar(row);
      }
    }
  }

  /**
   * @param row row.
  */
  private void editar(int row) {
    // Obtener valores de la tabla
    int id = (int) ComponentesMateriasMostrar.table.getValueAt(row, 0);
    String nombre = (String) ComponentesMateriasMostrar.table.getValueAt(row, 1);
    // Set valores a los componenentes del modal.
    ComponentesMateriasRegistrar.fieldNombre.setText(nombre);
    // Abrir usuarios modal.
    EventosMateriasRegistrar.editar = true;
    EventosMateriasRegistrar.id = id;
    VentanaContainer.getInstancia().cerrarVentanas();
    VentanaContainer.getInstancia().ventanaMateriasRegistrar.frame.setVisible(true);
  }

  /**
   * @param row row.
  */
  private void eliminar(int row) {
    int id = (int) ComponentesMateriasMostrar.table.getValueAt(row, 0);
    ConexionSelectTieneRelacion.execute("courses_subjects", "id_subject", id);
    if (ContainerListas.getInstance().listaRelacion.size() == 0) {
      ConexionSelectTieneRelacion.execute("subjects_students", "id_subject", id);
    }
    if (ContainerListas.getInstance().listaRelacion.size() > 0) {
      JOptionPane.showMessageDialog(null, "Tiene relacion NO SE PUEDE ELIMINAR");
    } else {
      String mensaje = "Realmente desea realizar esta accion";
      int result = JOptionPane.showConfirmDialog(null, mensaje, "Eliminar",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (result == 0) {
        ConexionDelete.execute("subjects", id);
        ComponentesMateriasMostrar.actualizarTabla();
      }
    }
  }
}
