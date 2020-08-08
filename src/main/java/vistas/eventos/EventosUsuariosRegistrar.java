package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import datos.ConexionInsertUsuarios;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelos.Usuario;
import vistas.componentes.ComponentesUsuariosRegistrar;
import vistas.validadores.ValidadorUsuarios;


public class EventosUsuariosRegistrar implements ActionListener {

  public EventosUsuariosRegistrar() {

  }

  public void actionPerformed(ActionEvent actionEvent) {
    boolean esValido = ValidadorUsuarios.validar();
    if(esValido) {
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
      ConexionInsertUsuarios.execute(usuario);
      showMessageDialog(null, "Registrado exitosamente");
    }
  }

}
