package vistas.eventos;

import datos.ConexionDelete;
import datos.ConexionSelectTieneRelacion;
import listas.ContainerListas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import vistas.componentes.ComponentesCursosMostrar;
import vistas.componentes.ComponentesCursosRegistrar;
import vistas.ventanas.VentanaContainer;
import javax.swing.JOptionPane;

/**
* Class.
*/
public class EventosCursosMostrar extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosCursosMostrar() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesCursosMostrar
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesCursosMostrar.table.getRowHeight();
    Object value = ComponentesCursosMostrar.table.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton.equals("Editar")) {
        this.editar(row);
      } else if (nombreBoton.equals("Eliminar")) {
        this.eliminar(row);
      }
    }
  }

  /**
   * @param row row.
  */
  private void editar(int row) {
    // Obtener valores de la tabla
    int id = (int) ComponentesCursosMostrar.table.getValueAt(row, 0);
    String nombre = (String) ComponentesCursosMostrar.table.getValueAt(row, 1);
    // Set valores a los componenentes del modal.
    ComponentesCursosRegistrar.fieldNombre.setText(nombre);
    // Abrir usuarios modal.
    EventosCursosRegistrar.editar = true;
    EventosCursosRegistrar.id = id;
    VentanaContainer.getInstancia().cerrarVentanas();
    VentanaContainer.getInstancia().ventanaCursosRegistrar.frame.setVisible(true);
  }

  /**
   * @param row row.
  */
  private void eliminar(int row) {
    int id = (int) ComponentesCursosMostrar.table.getValueAt(row, 0);
    ConexionSelectTieneRelacion.execute("courses_students", "id_course", id);
    if (ContainerListas.getInstance().listaRelacion.size() == 0) {
      ConexionSelectTieneRelacion.execute("courses_subjects", "id_course", id);
    }
    if (ContainerListas.getInstance().listaRelacion.size() > 0) {
      JOptionPane.showMessageDialog(null, "Tiene relacion NO SE PUEDE ELIMINAR");
    } else {
      // Si = 0, No = 1
      String mensaje = "Realmente desea realizar esta accion";
      int result = JOptionPane.showConfirmDialog(null, mensaje, "Eliminar",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (result == 0) {
        ConexionDelete.execute("courses", id);
        ComponentesCursosMostrar.actualizarTabla();
      }
    }
  }
}
