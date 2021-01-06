package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.ActionListener;

import listas.ContainerListas;

import java.awt.event.ActionEvent;

import vistas.validadores.ValidadorLogin;
import vistas.ventanas.VentanaContainer;

public class EventosLogin implements ActionListener {

  public EventosLogin() {

  }

  public void actionPerformed(ActionEvent actionEvent) {
    if (ValidadorLogin.validar()) {
      ContainerListas.userName = ContainerListas.getInstance().listaUsuarios.get(0).username;
      VentanaContainer.getInstancia().cerrarVentanas();
      VentanaContainer.getInstancia().ventanaDashboard.frame.setVisible(true);
      showMessageDialog(null, "Welcome " + ContainerListas.userName);
    } else {
      showMessageDialog(null, "Error: usuario o contrasena incorrecto");
    }
  }
}
