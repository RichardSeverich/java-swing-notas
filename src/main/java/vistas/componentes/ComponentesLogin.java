package vistas.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vistas.eventos.EventosLogin;
import vistas.ventanas.VentanaLogin;

/**
* Class.
*/
public final class ComponentesLogin {
  public static JTextField fieldUserName;
  public static JTextField fieldPassword;

  /**
  * Constructor.
  */
  private ComponentesLogin() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaLogin ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setLayout(null);
    // Usuario - Label
    JLabel userLabel = new JLabel("Usuario");
    userLabel.setBounds(40, 30, 80, 25);
    panel.add(userLabel);
    // Usuario - TextField
    fieldUserName = new JTextField();
    fieldUserName.setBounds(120, 30, 160, 25);
    panel.add(fieldUserName);
    // Password - Label
    JLabel passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(40, 65, 80, 25);
    panel.add(passwordLabel);
    // Password - TextField
    fieldPassword = new JPasswordField();
    fieldPassword.setBounds(120, 65, 160, 25);
    panel.add(fieldPassword);
    // Boton Login
    JButton loginButton = new JButton("login");
    loginButton.setBounds(40, 110, 80, 25);
    // Set action listener
    EventosLogin eventosLogin = new EventosLogin();
    loginButton.addActionListener(eventosLogin);
    panel.add(loginButton);
    fieldPassword.addKeyListener(eventosLogin);
  }
}
