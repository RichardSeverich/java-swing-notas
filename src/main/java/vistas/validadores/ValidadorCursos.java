package vistas.validadores;

import static javax.swing.JOptionPane.showMessageDialog;

import vistas.componentes.ComponentesCursosRegistrar;

public class ValidadorCursos {

  private ValidadorCursos(){

  }
  
  public static boolean validar() {
    String nombre = ComponentesCursosRegistrar.fieldNombre.getText();
    if (nombre.length() < 3 && nombre.length() > 20) {
      showMessageDialog(null, "Error: Nombre minimo 3 caracteres y maximo 20 caracteres");
      return false;
    } 
    return true;
  }
}
