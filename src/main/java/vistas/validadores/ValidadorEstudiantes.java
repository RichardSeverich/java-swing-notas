package vistas.validadores;

import static javax.swing.JOptionPane.showMessageDialog;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import vistas.componentes.ComponentesEstudiantesRegistrar;

/**
* Class.
*/
public final class ValidadorEstudiantes {

  /**
  * Constructor.
  */
  private ValidadorEstudiantes() {
  }

  /**
  * @return boolean.
  */
  public static boolean validar() {
    String dni = ComponentesEstudiantesRegistrar.fieldDni.getText();
    String nombres = ComponentesEstudiantesRegistrar.fieldNombres.getText();
    String apellidos = ComponentesEstudiantesRegistrar.fieldApellidos.getText();
    String fechaNacimiento = ComponentesEstudiantesRegistrar.datePicker.getJFormattedTextField().getText();
    String telefono = ComponentesEstudiantesRegistrar.fieldTelefono.getText();
    String direccion = ComponentesEstudiantesRegistrar.fieldDireccion.getText();
    String email = ComponentesEstudiantesRegistrar.fieldEmail.getText();
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailPattern.matcher(email);
    Boolean esEmailValido = matcher.find(); // true si es valido.

    if (!dni.matches("[0-9]+") || dni.length() < 4 && dni.length() > 10) {
      showMessageDialog(null, "Error: DNI minimo 4 numeros maximo 10 numeros");
      return false;
    } else if (nombres.length() < 3 && nombres.length() > 20) {
      showMessageDialog(null, "Error: Nombres minimo 3 caracteres y maximo 20");
      return false;
    } else if (apellidos.length() < 3 && apellidos.length() > 20) {
      showMessageDialog(null, "Error: Apellidos minimo 3 caracteres y maximo 20");
      return false;
    } else if (fechaNacimiento.length() == 0) {
      showMessageDialog(null, "Error: Fecha nacimiento esta vacio");
      return false;
    } else if (telefono.length() < 8 && telefono.length() > 15) {
      showMessageDialog(null, "Error: Numero de telefono minimo 8 numeros y maximo 15");
      return false;
    } else if (direccion.length() < 7 && direccion.length() > 50) {
      showMessageDialog(null, "Error: Direccion minimo 7 caracteres y maximo 50");
      return false;
    } else if (!esEmailValido) {
      showMessageDialog(null, "Error: Email no valido");
      return false;
    }
    return true;
  }
}
