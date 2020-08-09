import datos.ReadConfigProperties;
import vistas.ventanas.VentanaContainer;

public class Main {

  public static void main(String[] args) {
    ReadConfigProperties.leer();
    VentanaContainer
      .getInstancia()
      .ventanaLogin
      .frame
      .setVisible(true);
  }

}
