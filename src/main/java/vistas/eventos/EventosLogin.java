package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import listas.ContainerListas;
import vistas.validadores.ValidadorLogin;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosLogin implements ActionListener, KeyListener {

  /**
  * Constructor.
  */
  public EventosLogin() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    if (ValidadorLogin.validar()) {
      ContainerListas.userName = ContainerListas.getInstance().listaUsuarios.get(0).username;
      showMessageDialog(null, "Welcome " + ContainerListas.userName);
      VentanaContainer.getInstancia().cerrarVentanas();
      VentanaContainer.getInstancia().ventanaDashboard.frame.setVisible(true);
    } else {
      showMessageDialog(null, "Error: usuario o contrasena incorrecto");
    }
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void keyTyped(KeyEvent ke) {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void keyPressed(KeyEvent ke) {
    if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
      if (ValidadorLogin.validar()) {
        ContainerListas.userName = ContainerListas.getInstance().listaUsuarios.get(0).username;
        showMessageDialog(null, "Welcome " + ContainerListas.userName);
        VentanaContainer.getInstancia().cerrarVentanas();
        VentanaContainer.getInstancia().ventanaDashboard.frame.setVisible(true);
      } else {
        showMessageDialog(null, "Error: usuario o contrasena incorrecto");
      }
    }
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void keyReleased(KeyEvent ke) {
  }
}
