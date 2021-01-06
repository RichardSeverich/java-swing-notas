package vistas.validadores;

import static javax.swing.JOptionPane.showMessageDialog;

import vistas.componentes.ComponentesMateriasRegistrar;

public class ValidadorMaterias {

  private ValidadorMaterias(){

  }
  
  public static boolean validar() {
    String nombre = ComponentesMateriasRegistrar.fieldNombre.getText();
    if (nombre.length() < 3 && nombre.length() > 20) {
      showMessageDialog(null, "Error: Nombre minimo 3 caracteres y maximo 20");
      return false;
    } 
    return true;
  }
}
