package vistas.componentes;

import java.awt.Font;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import vistas.eventos.EventosUsuariosRegistrar;
import vistas.utiles.DateLabelFormatter;
import vistas.ventanas.VentanaUsuariosRegistrar;

/**
* Class.
*/
public final class ComponentesUsuariosRegistrar {
  public static JTextField fieldDni;
  public static JTextField fieldUsername;
  public static JPasswordField fieldContrasena;
  public static JTextField fieldNombres;
  public static JTextField fieldApellidos;
  public static JDatePickerImpl datePicker;
  public static JTextField fieldEmail;
  public static JComboBox tipoUsuarioCombox;

  /**
  * Constructor.
  */
  private ComponentesUsuariosRegistrar() {
  }

  /**
   * @param ventana ventana.
  */
  @SuppressWarnings("unchecked")
  public static void set(VentanaUsuariosRegistrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setBounds(200, 20, 500, 610);
    panel.setLayout(null);
    // Titulo
    JLabel labelTitulo = new JLabel("Registrar Usuarios");
    labelTitulo.setFont(new Font("Arial", Font.PLAIN, 22));
    labelTitulo.setBounds(200, 30, 250, 50);
    panel.add(labelTitulo);
    // dni
    JLabel labelDni = new JLabel("Numero Identidad");
    fieldDni = new JTextField();
    labelDni.setBounds(50, 100, 100, 25);
    fieldDni.setBounds(200, 100, 200, 25);
    panel.add(labelDni);
    panel.add(fieldDni);
    // username
    JLabel labelUsername = new JLabel("Username");
    fieldUsername = new JTextField();
    labelUsername.setBounds(50, 150, 100, 25);
    fieldUsername.setBounds(200, 150, 200, 25);
    panel.add(labelUsername);
    panel.add(fieldUsername);
    // Password
    JLabel labelContrasena = new JLabel("Contrasena");
    fieldContrasena = new JPasswordField();
    labelContrasena.setBounds(50, 200, 100, 25);
    fieldContrasena.setBounds(200, 200, 200, 25);
    panel.add(labelContrasena);
    panel.add(fieldContrasena);
    // Nombres
    JLabel labelNombres = new JLabel("Nombres");
    fieldNombres = new JTextField();
    labelNombres.setBounds(50, 250, 100, 25);
    fieldNombres.setBounds(200, 250, 200, 25);
    panel.add(labelNombres);
    panel.add(fieldNombres);
    // Apellidos
    JLabel labelApellidos = new JLabel("Apellidos");
    fieldApellidos = new JTextField();
    labelApellidos.setBounds(50, 300, 100, 25);
    fieldApellidos.setBounds(200, 300, 200, 25);
    panel.add(labelApellidos);
    panel.add(fieldApellidos);
    // Fecha nacimiento
    UtilDateModel model = new UtilDateModel();
    Properties properties = new Properties();
    properties.put("text.today", "Today");
    properties.put("text.month", "Month");
    properties.put("text.year", "Year");
    JLabel labelFechaNacimiento = new JLabel("Fecha Nacimiento");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
    datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    model.setSelected(true);
    labelFechaNacimiento.setBounds(50, 350, 120, 25);
    datePicker.setBounds(200, 350, 200, 25);
    panel.add(labelFechaNacimiento);
    panel.add(datePicker);
    // Email
    JLabel labelEmail = new JLabel("Correo");
    fieldEmail = new JTextField();
    labelEmail.setBounds(50, 400, 100, 25);
    fieldEmail.setBounds(200, 400, 200, 25);
    panel.add(labelEmail);
    panel.add(fieldEmail);
    // Tipo Usuario
    JLabel labelTipoUsuario = new JLabel("Tipo Usuario");
    String[] comboxItems = {"Administrador", "Profesor"};
    tipoUsuarioCombox = new JComboBox(comboxItems);
    labelTipoUsuario.setBounds(50, 450, 120, 25);
    tipoUsuarioCombox.setBounds(200, 450, 200, 25);
    panel.add(labelTipoUsuario);
    panel.add(tipoUsuarioCombox);
    // Boton Registrar
    JButton registrarButton = new JButton("Guardar");
    registrarButton.setBounds(200, 520, 200, 30);
    EventosUsuariosRegistrar eventosUsuariosRegistrar = new EventosUsuariosRegistrar();
    registrarButton.addActionListener(eventosUsuariosRegistrar);
    panel.add(registrarButton);
    // Titulo y Borde
    String title = "Registrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /**
   * Method Limpia Componentes.
  */
  public static void limpiar() {
    ComponentesUsuariosRegistrar.fieldDni.setText("");
    ComponentesUsuariosRegistrar.fieldUsername.setText("");
    ComponentesUsuariosRegistrar.fieldContrasena.setText("");
    ComponentesUsuariosRegistrar.fieldNombres.setText("");
    ComponentesUsuariosRegistrar.fieldApellidos.setText("");
    ComponentesUsuariosRegistrar.fieldEmail.setText("");
    ComponentesUsuariosRegistrar.tipoUsuarioCombox.setSelectedItem("");
  }
}
