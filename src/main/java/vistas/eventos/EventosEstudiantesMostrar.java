package vistas.eventos;

import datos.ConexionDelete;
import datos.ConexionSelectTieneRelacion;

import listas.ContainerListas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import vistas.componentes.ComponentesEstudiantesMostrar;
import vistas.componentes.ComponentesEstudiantesRegistrar;
import vistas.ventanas.VentanaContainer;
import javax.swing.JOptionPane;

/**
* Class.
*/
public class EventosEstudiantesMostrar extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosEstudiantesMostrar() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesEstudiantesMostrar
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesEstudiantesMostrar.table.getRowHeight();
    Object value = ComponentesEstudiantesMostrar.table.getValueAt(row, column);
    if (value instanceof JButton) {
      //((JButton)value).doClick();
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
    int id = (int) ComponentesEstudiantesMostrar.table.getValueAt(row, 0);
    String dni = (String) ComponentesEstudiantesMostrar.table.getValueAt(row, 1);
    String nombres = (String) ComponentesEstudiantesMostrar.table.getValueAt(row, 2);
    String apellidos = (String) ComponentesEstudiantesMostrar.table.getValueAt(row, 3);
    String fechaNacimiento = (String) ComponentesEstudiantesMostrar.table.getValueAt(row, 4);
    String telefono = (String) ComponentesEstudiantesMostrar.table.getValueAt(row, 5);
    String direccion = (String) ComponentesEstudiantesMostrar.table.getValueAt(row, 6);
    String email = (String) ComponentesEstudiantesMostrar.table.getValueAt(row, 7);
    // Set valores a los componenentes del modal.
    ComponentesEstudiantesRegistrar.fieldDni.setText(dni);
    ComponentesEstudiantesRegistrar.fieldNombres.setText(nombres);
    ComponentesEstudiantesRegistrar.fieldApellidos.setText(apellidos);
    ComponentesEstudiantesRegistrar.datePicker.getJFormattedTextField().setText(fechaNacimiento);
    ComponentesEstudiantesRegistrar.fieldTelefono.setText(telefono);
    ComponentesEstudiantesRegistrar.fieldDireccion.setText(direccion);
    ComponentesEstudiantesRegistrar.fieldEmail.setText(email);
    // Abrir usuarios modal.
    EventosEstudiantesRegistrar.editar = true;
    EventosEstudiantesRegistrar.id = id;
    VentanaContainer.getInstancia().cerrarVentanas();
    VentanaContainer.getInstancia().ventanaEstudiantesRegistrar.frame.setVisible(true);
  }

  /**
   * @param row row.
  */
  private void eliminar(int row) {
    int id = (int) ComponentesEstudiantesMostrar.table.getValueAt(row, 0);
    ConexionSelectTieneRelacion.execute("courses_students", "id_student", id);
    if (ContainerListas.getInstance().listaRelacion.size() == 0) {
      ConexionSelectTieneRelacion.execute("subjects_students", "id_student", id);
    }
    if (ContainerListas.getInstance().listaRelacion.size() > 0) {
      JOptionPane.showMessageDialog(null, "Tiene relacion NO SE PUEDE ELIMINAR");
    } else {
      // Si = 0, No = 1
      String mensaje = "Realmente desea realizar esta accion";
      int result = JOptionPane.showConfirmDialog(null, mensaje, "Eliminar",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      if (result == 0) {
        ConexionDelete.execute("students", id);
        ComponentesEstudiantesMostrar.actualizarTabla();
      }
    }
  }
}
