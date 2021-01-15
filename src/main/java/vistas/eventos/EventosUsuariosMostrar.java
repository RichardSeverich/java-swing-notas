package vistas.eventos;

import datos.ConexionDelete;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import vistas.componentes.ComponentesUsuariosMostrar;
import vistas.componentes.ComponentesUsuariosRegistrar;
import vistas.ventanas.VentanaContainer;
import javax.swing.JOptionPane;

/**
* Class.
*/
public class EventosUsuariosMostrar extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosUsuariosMostrar() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesUsuariosMostrar
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesUsuariosMostrar.table.getRowHeight();
    Object value = ComponentesUsuariosMostrar.table.getValueAt(row, column);
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
    int id = (int) ComponentesUsuariosMostrar.table.getValueAt(row, 0);
    String dni = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 1);
    String username = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 2);
    String contrasena = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 3);
    String nombres = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 4);
    String apellidos = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 5);
    String fechaNacimiento = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 6);
    String email = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 7);
    String tipo = (String) ComponentesUsuariosMostrar.table.getValueAt(row, 8);
    // Set valores a los componenentes del modal.
    ComponentesUsuariosRegistrar.fieldDni.setText(dni);
    ComponentesUsuariosRegistrar.fieldUsername.setText(username);
    ComponentesUsuariosRegistrar.fieldContrasena.setText(contrasena);
    ComponentesUsuariosRegistrar.fieldNombres.setText(nombres);
    ComponentesUsuariosRegistrar.fieldApellidos.setText(apellidos);
    ComponentesUsuariosRegistrar.datePicker.getJFormattedTextField().setText(fechaNacimiento);
    ComponentesUsuariosRegistrar.fieldEmail.setText(email);
    ComponentesUsuariosRegistrar.tipoUsuarioCombox.setSelectedItem(tipo);
    // Abrir usuarios modal.
    EventosUsuariosRegistrar.editar = true;
    EventosUsuariosRegistrar.id = id;
    VentanaContainer.getInstancia().cerrarVentanas();
    VentanaContainer.getInstancia().ventanaUsuariosRegistrar.frame.setVisible(true);
  }

  /**
   * @param row row.
  */
  private void eliminar(int row) {
    int id = (int) ComponentesUsuariosMostrar.table.getValueAt(row, 0);
    String mensaje = "Realmente desea realizar esta accion";
    int result = JOptionPane.showConfirmDialog(null, mensaje, "Eliminar",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (result == 0) {
      ConexionDelete.execute("users", id);
      ComponentesUsuariosMostrar.actualizarTabla();
    }
  }
}
