package vistas.componentes;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import java.awt.BorderLayout;

import vistas.ventanas.VentanaUsuariosMostrar;

public class ComponentesUsuariosMostrar {


  private ComponentesUsuariosMostrar(){

  }

  public static void set(VentanaUsuariosMostrar ventana) {
    JPanel panel = new JPanel();
    panel.setBounds(40, 20, 800, 650);
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
    table.getColumnModel().getColumn(0).setPreferredWidth(50);
    table.getColumnModel().getColumn(1).setPreferredWidth(70);
    table.getColumnModel().getColumn(2).setPreferredWidth(90);
    table.getColumnModel().getColumn(3).setPreferredWidth(90);
    table.getColumnModel().getColumn(4).setPreferredWidth(120);
    table.getColumnModel().getColumn(5).setPreferredWidth(120);
    table.getColumnModel().getColumn(6).setPreferredWidth(125);
    table.getColumnModel().getColumn(7).setPreferredWidth(170);
    table.getColumnModel().getColumn(8).setPreferredWidth(90);
    table.getColumnModel().getColumn(9).setPreferredWidth(90);
    table.getColumnModel().getColumn(10).setPreferredWidth(90);
    JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    panel.add(scrollPane);

    // Titulo y Borde
    String title = "Mostrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }
}
