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
import vistas.eventos.EventosPlanRegistrarCurso;
import vistas.ventanas.VentanaPlanRegistrarCurso;

public class ComponentesPlanRegistrarCurso {

  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "NOMBRE", "SELECCIONAR"};

  private ComponentesPlanRegistrarCurso(){
  }

  /** Set Componentes.*/
  public static void set(VentanaPlanRegistrarCurso ventana) {
    JPanel panel = new JPanel();
    panel.setBounds(40, 20, 800, 630);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object [][] datos = { {null, null, null} };
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosPlanRegistrarCurso eventosPlanRegistrarCurso = new EventosPlanRegistrarCurso();
    table = new JTable();
    table.addMouseListener(eventosPlanRegistrarCurso);
    table.setDefaultRenderer(Object.class, new Render());
    table.setModel(defaultTableModel);
    JScrollPane scrollPane = new JScrollPane(table,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    panel.add(scrollPane);
    // Titulo y Borde
    String title = "Seleccionar Curso";
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
    table.getColumnModel().getColumn(2).setPreferredWidth(110);
  }

  private static Object[][] construtirDatos() {
    ConexionSelectCursos.execute();
    int size = ContainerListas.getInstance().listaCursos.size();
    Object[][] datos = new Object[size][3];
    int row = 0;
    for (Curso curso : ContainerListas.getInstance().listaCursos) {
      JButton botonSeleccionar = new JButton("seleccionar");
      botonSeleccionar.setName("seleccionar");
      datos[row][0] = curso.id;
      datos[row][1] = curso.nombre;
      datos[row][2] = botonSeleccionar;
      row++;
    }
    return datos;
  }
}
