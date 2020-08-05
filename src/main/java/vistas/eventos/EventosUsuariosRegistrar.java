package vistas.eventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static javax.swing.JOptionPane.showMessageDialog;

import vistas.validadores.ValidadorUsuarios;

public class EventosUsuariosRegistrar implements ActionListener {

  public EventosUsuariosRegistrar() {

  }

  public void actionPerformed(ActionEvent actionEvent) {
    boolean esValido = ValidadorUsuarios.validar();
    if(esValido){
      showMessageDialog(null, "Registrado exitosamente");
    }
  }

}
