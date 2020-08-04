package vistas.ventanas;

import javax.swing.JFrame;

public abstract class Ventana {

  public JFrame frame;
  
  public Ventana(String frameName){
    this.frame = new JFrame(frameName);
    this.frame.setResizable(false);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
