package vistas.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Properties;

import com.toedter.calendar.JCalendar;

import vistas.ventanas.VentanaUsuariosRegistrar;
//import vistas.eventos.EventosLogin;

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
    labelUsername.setBounds(50, 50, 100, 25);
    fieldUsername.setBounds(150, 50, 200, 25);
    panel.add(labelUsername);
    panel.add(fieldUsername);
    // Password
    JLabel labelContrasena = new JLabel("Contrasena");
    JTextField fieldContrasena = new JTextField();
    labelContrasena.setBounds(50, 100, 100, 25);
    fieldContrasena.setBounds(150, 100, 200, 25);
    panel.add(labelContrasena);
    panel.add(fieldContrasena);
    // Nombres
    JLabel labelNombres = new JLabel("Nombres");
    JTextField fieldNombres = new JTextField();
    labelNombres.setBounds(50, 150, 100, 25);
    fieldNombres.setBounds(150, 150, 200, 25);
    panel.add(labelNombres);
    panel.add(fieldNombres);
    // Apellidos
    JLabel labelApellidos = new JLabel("Apellidos");
    JTextField fieldApellidos = new JTextField();
    labelApellidos.setBounds(50, 200, 100, 25);
    fieldApellidos.setBounds(150, 200, 200, 25);
    panel.add(labelApellidos);
    panel.add(fieldApellidos);
    
    // Fecha nacimiento
    JLabel labelFechaNacimiento = new JLabel("Fecha Nacimiento");
    JCalendar calendar = new JCalendar();        
    labelFechaNacimiento.setBounds(50, 250, 100, 25);
    calendar.setBounds(150, 250, 200, 25);
    panel.add(labelFechaNacimiento);
    panel.add(calendar);
  }
}
