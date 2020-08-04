package vistas.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Properties;

import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

import vistas.ventanas.VentanaUsuariosRegistrar;
import vistas.utiles.DateLabelFormatter;
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
    fieldUsername.setBounds(200, 50, 200, 25);
    panel.add(labelUsername);
    panel.add(fieldUsername);
    // Password
    JLabel labelContrasena = new JLabel("Contrasena");
    JTextField fieldContrasena = new JTextField();
    labelContrasena.setBounds(50, 100, 100, 25);
    fieldContrasena.setBounds(200, 100, 200, 25);
    panel.add(labelContrasena);
    panel.add(fieldContrasena);
    // Nombres
    JLabel labelNombres = new JLabel("Nombres");
    JTextField fieldNombres = new JTextField();
    labelNombres.setBounds(50, 150, 100, 25);
    fieldNombres.setBounds(200, 150, 200, 25);
    panel.add(labelNombres);
    panel.add(fieldNombres);
    // Apellidos
    JLabel labelApellidos = new JLabel("Apellidos");
    JTextField fieldApellidos = new JTextField();
    labelApellidos.setBounds(50, 200, 100, 25);
    fieldApellidos.setBounds(200, 200, 200, 25);
    panel.add(labelApellidos);
    panel.add(fieldApellidos);
    
    // Fecha nacimiento
    JLabel labelFechaNacimiento = new JLabel("Fecha Nacimiento");
    UtilDateModel model = new UtilDateModel();
    Properties properties = new Properties();
    properties.put("text.today", "Today");
    properties.put("text.month", "Month");
    properties.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    labelFechaNacimiento.setBounds(50, 250, 120, 25);
    datePicker.setBounds(200, 250, 200, 25);
    panel.add(labelFechaNacimiento);
    panel.add(datePicker);
  }
}
