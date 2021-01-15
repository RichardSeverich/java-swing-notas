package vistas.componentes;

import datos.ConexionSelectMaterias;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import listas.ContainerListas;
import modelos.Materia;
import vistas.utiles.Render;
import vistas.eventos.EventosMateriasMostrar;
import vistas.ventanas.VentanaMateriasMostrar;

/**
* Class.
*/
public final class ComponentesMateriasMostrar {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "NOMBRE", "EDITAR", "ELIMINAR"};

  /**
  * Constructor.
  */
  private ComponentesMateriasMostrar() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaMateriasMostrar ventana) {
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 890, 660);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object[][] datos = {{null, null, null, null}};
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosMateriasMostrar eventosMateriasMostrar = new EventosMateriasMostrar();
    table = new JTable();
    table.addMouseListener(eventosMateriasMostrar);
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
    table.getColumnModel().getColumn(0).setPreferredWidth(70);
    table.getColumnModel().getColumn(1).setPreferredWidth(565);
    table.getColumnModel().getColumn(2).setPreferredWidth(120);
    table.getColumnModel().getColumn(3).setPreferredWidth(120);
  }

  /**
   * @return datos.
  */
  private static Object[][] construtirDatos() {
    ConexionSelectMaterias.execute();
    int size = ContainerListas.getInstance().listaMaterias.size();
    Object[][] datos = new Object[size][10];
    int row = 0;
    for (Materia materia : ContainerListas.getInstance().listaMaterias) {
      JButton botonEditar = new JButton("Editar");
      JButton botonEliminar = new JButton("Eliminar");
      botonEditar.setName("Editar");
      botonEliminar.setName("Eliminar");
      datos[row][0] = materia.id;
      datos[row][1] = materia.nombre;
      datos[row][2] = botonEditar;
      datos[row][3] = botonEliminar;
      row++;
    }
    return datos;
  }
}
