import vistas.ventanas.VentanaContainer;

public class Main {

  public static void main(String[] args) {
    VentanaContainer
      .getInstancia()
      .ventanaLogin
      .frame
      .setVisible(true);
  }

}
