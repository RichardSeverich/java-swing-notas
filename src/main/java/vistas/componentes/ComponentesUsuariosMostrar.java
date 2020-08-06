package vistas.componentes;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

import vistas.ventanas.VentanaUsuariosMostrar;

public class ComponentesUsuariosMostrar {


  private ComponentesUsuariosMostrar(){

  }

  public static void set(VentanaUsuariosMostrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());

    String[] columnHeaders = new String[] {"ID", "DNI", "USERNAME", "CONTRASENA", "NOMBRES", 
      "APELLIDOS", "FECHA NACIMIENTO", "EMAIL", "TIPO", "EDITAR", "ELIMINAR"
    };

    //actual data for the table in a 2d array
    Object[][] datos = new Object[][] {
      {1, "5928025", 40.0, false, "John" , "John", "John", "John", "John", new JButton("Editar"), new JButton("Eliminar")},
      {2, "5928025", 70.0, false, "John", "John", "John", "John", "John", new JButton("Editar"), new JButton("Eliminar") },
      {100, "5928025", 60.0, true, "John", "John", "John", "John", "John", new JButton("Editar"), new JButton("Eliminar") },
    };

    JTable table = new JTable(datos, columnHeaders);
    table.getColumn("ID").setMaxWidth(50);
    table.getColumn("DNI").setMaxWidth(70);
    table.getColumn("USERNAME").setMaxWidth(100);
    JScrollPane scrollPane = new JScrollPane(table);
    panel.add(scrollPane);

    // Titulo y Borde
    String title = "Mostrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }
}
