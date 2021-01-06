package vistas.validadores;

import static javax.swing.JOptionPane.showMessageDialog;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import vistas.componentes.ComponentesUsuariosRegistrar;

public class ValidadorUsuarios {

  private ValidadorUsuarios(){

  }

  public static boolean validar(){
    String dni = ComponentesUsuariosRegistrar.fieldDni.getText();
    String username = ComponentesUsuariosRegistrar.fieldUsername.getText();
    String contrasena = ComponentesUsuariosRegistrar.fieldContrasena.getText();
    String nombres = ComponentesUsuariosRegistrar.fieldNombres.getText();
    String apellidos = ComponentesUsuariosRegistrar.fieldApellidos.getText();
    String fechaNacimiento = ComponentesUsuariosRegistrar.datePicker.getJFormattedTextField().getText();
    String email = ComponentesUsuariosRegistrar.fieldEmail.getText();
    String tipoUsuario = ComponentesUsuariosRegistrar.tipoUsuarioCombox.getSelectedItem().toString();
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailPattern.matcher(email);
    Boolean esEmailValido = matcher.find(); // true si es valido.

    if (!dni.matches("[0-9]+") || dni.length() < 4 && dni.length() > 10) {
      showMessageDialog(null, "Error: DNI minimo 4 numeros y maximo 10 numeros");
      return false;
    } else if (username.length() < 4 && username.length() > 20) {
      showMessageDialog(null, "Error: Usuername minimo 4 caracteres y maximo 20");
      return false;
    } else if (contrasena.length() < 4 && contrasena.length() > 20) {
      showMessageDialog(null, "Error: Contrasena minimo 4 caracteres y maximo 20");
      return false;
    } else if (nombres.length() < 3 && nombres.length() > 20) {
      showMessageDialog(null, "Error: Nombres minimo 3 caracteres y maximo 20");
      return false;
    } else if (apellidos.length() < 3 && apellidos.length() > 20) {
      showMessageDialog(null, "Error: Apellidos minimo 3 caracteres y maximo 20");
      return false;
    } else if (!esEmailValido) {
      showMessageDialog(null, "Error: Email no valido");
      return false;
    } else if (fechaNacimiento.length() == 0) {
      showMessageDialog(null, "Error: Fecha nacimiento esta vacio");
      return false;
    } else if (tipoUsuario.length() < 3 && tipoUsuario.length() > 13) {
      showMessageDialog(null, "Error: Tipo minimo 3 caracteres y maximo 13");
      return false;
    }
    return true;
  }
}
