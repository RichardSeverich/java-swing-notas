package vistas.eventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vistas.ventanas.VentanaContainer;

public class EventosLogin implements ActionListener {

  public EventosLogin() {

  }

  public void actionPerformed(ActionEvent actionEvent) {
    VentanaContainer.getInstancia().cerrarVentanas();
    VentanaContainer.getInstancia().ventanaDashboard.frame.setVisible(true);
  }

}
