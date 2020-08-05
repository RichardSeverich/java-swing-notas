package vistas.validadores;

import static javax.swing.JOptionPane.showMessageDialog;

import vistas.componentes.ComponentesUsuariosRegistrar;

public class ValidadorUsuarios {

  private ValidadorUsuarios(){

  }
  
  public static boolean validar(){
    String username = ComponentesUsuariosRegistrar.fieldUsername.getText();
    String contrasena = ComponentesUsuariosRegistrar.fieldContrasena.getText();
    String nombres = ComponentesUsuariosRegistrar.fieldNombres.getText();
    String apellidos = ComponentesUsuariosRegistrar.fieldApellidos.getText();
    String fechaNacimiento = ComponentesUsuariosRegistrar.datePicker.getJFormattedTextField().getText();
    String tipoUsuario = ComponentesUsuariosRegistrar.tipoUsuarioCombox.getSelectedItem().toString();
    if (username.length() < 4){
      showMessageDialog(null, "Error: Usuername minimo 4 caracteres");
      return false;
    } else if (contrasena.length() < 4){
      showMessageDialog(null, "Error: Contrasena minimo 4 caracteres");
      return false;
    } else if (nombres.length() < 3){
      showMessageDialog(null, "Error: Nombres minimo 3 caracteres");
      return false;
    } else if (apellidos.length() < 3){
      showMessageDialog(null, "Error: Apellidos minimo 3 caracteres");
      return false;
    } else if (fechaNacimiento.length() == 0){
      showMessageDialog(null, "Error: Fecha nacimiento esta vacio");
      return false;
    }
    return true;
  }
}
