package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import datos.ConexionInsertUsuarios;
import datos.ConexionUpdateUsuarios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelos.Usuario;
import vistas.componentes.ComponentesUsuariosRegistrar;
import vistas.validadores.ValidadorUsuarios;

/**
* Class.
*/
public class EventosUsuariosRegistrar implements ActionListener {
  public static boolean editar;
  public static int id;

  /**
  * Constructor.
  */
  public EventosUsuariosRegistrar() {
    this.editar = false;
    this.id = 0;
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    boolean esValido = ValidadorUsuarios.validar();
    if (esValido) {
      Usuario usuario = new Usuario();
      usuario.dni = ComponentesUsuariosRegistrar.fieldDni.getText();
      usuario.username = ComponentesUsuariosRegistrar.fieldUsername.getText();
      usuario.contrasena = ComponentesUsuariosRegistrar.fieldContrasena.getText();
      usuario.nombres = ComponentesUsuariosRegistrar.fieldNombres.getText();
      usuario.apellidos = ComponentesUsuariosRegistrar.fieldApellidos.getText();
      usuario.fechaNacimiento = ComponentesUsuariosRegistrar.datePicker
          .getJFormattedTextField().getText();
      usuario.email = ComponentesUsuariosRegistrar.fieldEmail.getText();
      usuario.tipo = ComponentesUsuariosRegistrar.tipoUsuarioCombox.getSelectedItem().toString();
      if (this.editar) {
        this.modificar(usuario);
      } else {
        this.crear(usuario);
      }
    }
  }

  /**
   * @param usuario usuario.
  */
  private void crear(Usuario usuario) {
    ConexionInsertUsuarios.execute(usuario);
    showMessageDialog(null, "Registrado exitosamente");
  }

  /**
   * @param usuario usuario.
  */
  private void modificar(Usuario usuario) {
    usuario.id = this.id;
    ConexionUpdateUsuarios.execute(usuario);
    showMessageDialog(null, "Editado exitosamente");
  }
}
