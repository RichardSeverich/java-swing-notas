package vistas.componentes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vistas.eventos.EventosLogin;
import vistas.ventanas.VentanaLogin;

public class ComponentesLogin {

  private ComponentesLogin(){

  }

  /** Set Componentes.*/
  public static void set(VentanaLogin ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setLayout(null);
    // Usuario - Label
    JLabel userLabel = new JLabel("Usuario");
    int positionX = 40;
    int positionY = 30;
    userLabel.setBounds(positionX, positionY, 80, 25);
    panel.add(userLabel);
    // Usuario - TextField
    JTextField userText = new JTextField();
    positionX = 120;
    userText.setBounds(positionX, positionY, 160, 25);
    panel.add(userText);
    // Password - Label 
    JLabel passwordLabel = new JLabel("Password");
    positionX = 40;
    positionY = 65;
    passwordLabel.setBounds(positionX, positionY, 80, 25);
    panel.add(passwordLabel);
    // Password - TextField
    JPasswordField passwordText = new JPasswordField();
    positionX = 120;
    passwordText.setBounds(positionX, positionY, 160, 25);
    panel.add(passwordText);
    // Boton Login
    JButton loginButton = new JButton("login");
    positionX = 40;
    positionY = 110;
    loginButton.setBounds(positionX, positionY, 80, 25);
    // Set action listener
    EventosLogin eventosLogin = new EventosLogin();
    loginButton.addActionListener(eventosLogin);
    panel.add(loginButton);
  }
}
