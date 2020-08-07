package vistas.componentes;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;

import vistas.ventanas.VentanaUsuariosMostrar;
import controlador.ControladorUsuarios;
import utiles.Render;
import vistas.eventos.EventosUsuariosMostrar;

public class ComponentesUsuariosMostrar {

  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  
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
 
    Object[][] datos = ControladorUsuarios.getArray();

    table = new JTable();
    EventosUsuariosMostrar eventosUsuariosMostrar = new EventosUsuariosMostrar();
    table.addMouseListener(eventosUsuariosMostrar);
    table.setDefaultRenderer(Object.class, new Render());
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
       @Override
      public boolean isCellEditable(int row, int column){
        return false;
      }
    };
    table.setModel(defaultTableModel);
    //table.setEnabled(false);
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
