package vistas.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vistas.ventanas.VentanaUsuariosRegistrar;
import vistas.eventos.EventosLogin;

public class componentesUsuariosRegistrar {

  private componentesUsuariosRegistrar(){

  }

  public static void set(VentanaUsuariosRegistrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setLayout(null);
    // username
    JLabel labelUsername = new JLabel("Username");
    JTextField fieldUsername = new JTextField();
    panel.add(labelUsername);
    panel.add(fieldUsername);
    // Password
    JLabel labelContrasena = new JLabel("Contrasena");
    JTextField fieldContrasena = new JTextField();
    panel.add(labelContrasena);
    panel.add(fieldContrasena);
    // Nombres
    JLabel labelNombres = new JLabel("Nombres");
    JTextField fieldNombres = new JTextField();
    panel.add(labelNombres);
    panel.add(fieldNombres);
    // Apellidos
    JLabel labelApellidos = new JLabel("Apellidos");
    JTextField fieldApellidos = new JTextField();
    panel.add(labelApellidos);
    panel.add(fieldApellidos);
  }
}
