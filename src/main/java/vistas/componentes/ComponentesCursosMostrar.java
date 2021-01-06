package vistas.componentes;

import datos.ConexionSelectCursos;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import listas.ContainerListas;
import modelos.Curso;
import vistas.utiles.Render;
import vistas.eventos.EventosCursosMostrar;
import vistas.ventanas.VentanaCursosMostrar;

public class ComponentesCursosMostrar {

  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "NOMBRE", "EDITAR", "ELIMINAR"};

  private ComponentesCursosMostrar(){
  }

  /** Set Componentes.*/
  public static void set(VentanaCursosMostrar ventana) {
    JPanel panel = new JPanel();
    panel.setBounds(40, 20, 800, 630);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object [][] datos = { {null, null, null, null} };
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosCursosMostrar eventosCursosMostrar = new EventosCursosMostrar();
    table = new JTable();
    table.addMouseListener(eventosCursosMostrar);
    table.setDefaultRenderer(Object.class, new Render());
    table.setModel(defaultTableModel);
    //table.setEnabled(false);
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

  /** Actualiza tabla.*/
  public static void actualizarTabla() {
    Object[][] datos = construtirDatos();
    defaultTableModel.setDataVector(datos, columnHeaders);
    setPreferredWidth();
  }

  private static void setPreferredWidth() {
    // Set columns width
    table.getColumnModel().getColumn(0).setPreferredWidth(50);
    table.getColumnModel().getColumn(1).setPreferredWidth(120);
    table.getColumnModel().getColumn(2).setPreferredWidth(90);
    table.getColumnModel().getColumn(3).setPreferredWidth(90);
  }

  private static Object[][] construtirDatos() {
    ConexionSelectCursos.execute();
    int size = ContainerListas.getInstance().listaCursos.size();
    Object[][] datos = new Object[size][4];
    int row = 0;
    for (Curso curso : ContainerListas.getInstance().listaCursos) {
      JButton botonEditar = new JButton("Editar");
      JButton botonEliminar = new JButton("Eliminar");
      botonEditar.setName("Editar");
      botonEliminar.setName("Eliminar");
      datos[row][0] = curso.id;
      datos[row][1] = curso.nombre;
      datos[row][2] = botonEditar;
      datos[row][3] = botonEliminar;
      row++;
    }
    return datos;
  }
}
