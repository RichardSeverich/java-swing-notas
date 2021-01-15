package vistas.componentes;

import datos.ConexionSelectUsuarios;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import listas.ContainerListas;
import modelos.Usuario;
import vistas.utiles.Render;
import vistas.eventos.EventosUsuariosMostrar;
import vistas.ventanas.VentanaUsuariosMostrar;

/**
* Class.
*/
public final class ComponentesUsuariosMostrar {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "DNI", "USERNAME", "CONTRASENA",
    "NOMBRES", "APELLIDOS", "FECHA NACIMIENTO", "EMAIL", "TIPO", "EDITAR", "ELIMINAR"
  };

  /**
  * Constructor.
  */
  private ComponentesUsuariosMostrar() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaUsuariosMostrar ventana) {
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 890, 660);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object[][] datos = {{null, null, null, null, null, null, null, null, null, null, null}};
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosUsuariosMostrar eventosUsuariosMostrar = new EventosUsuariosMostrar();
    table = new JTable();
    table.addMouseListener(eventosUsuariosMostrar);
    table.setDefaultRenderer(Object.class, new Render());
    table.setModel(defaultTableModel);
    JScrollPane scrollPane = new JScrollPane(table,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    panel.add(scrollPane);
    // Titulo y Borde
    String title = "Mostrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /**
   * Method actualiza tabla.
  */
  public static void actualizarTabla() {
    Object[][] datos = construtirDatos();
    defaultTableModel.setDataVector(datos, columnHeaders);
    setPreferredWidth();
  }

  /**
   * Method set columnas.
  */
  private static void setPreferredWidth() {
    table.getColumnModel().getColumn(0).setPreferredWidth(50);
    table.getColumnModel().getColumn(1).setPreferredWidth(70);
    table.getColumnModel().getColumn(2).setPreferredWidth(90);
    table.getColumnModel().getColumn(3).setPreferredWidth(120);
    table.getColumnModel().getColumn(4).setPreferredWidth(120);
    table.getColumnModel().getColumn(5).setPreferredWidth(120);
    table.getColumnModel().getColumn(6).setPreferredWidth(125);
    table.getColumnModel().getColumn(7).setPreferredWidth(170);
    table.getColumnModel().getColumn(8).setPreferredWidth(90);
    table.getColumnModel().getColumn(9).setPreferredWidth(90);
    table.getColumnModel().getColumn(10).setPreferredWidth(90);
  }

  /**
   * @return datos.
  */
  private static Object[][] construtirDatos() {
    ConexionSelectUsuarios.execute();
    int size = ContainerListas.getInstance().listaUsuarios.size();
    Object[][] datos = new Object[size][11];
    int row = 0;
    for (Usuario usuario : ContainerListas.getInstance().listaUsuarios) {
      JButton botonEditar = new JButton("Editar");
      JButton botonEliminar = new JButton("Eliminar");
      botonEditar.setName("Editar");
      botonEliminar.setName("Eliminar");
      datos[row][0] = usuario.id;
      datos[row][1] = usuario.dni;
      datos[row][2] = usuario.username;
      datos[row][3] = usuario.contrasena;
      datos[row][4] = usuario.nombres;
      datos[row][5] = usuario.apellidos;
      datos[row][6] = usuario.fechaNacimiento;
      datos[row][7] = usuario.email;
      datos[row][8] = usuario.tipo;
      datos[row][9] = botonEditar;
      datos[row][10] = botonEliminar;
      row++;
    }
    return datos;
  }

}
