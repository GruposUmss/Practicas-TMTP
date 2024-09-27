package clases;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JTableInNullLayout
{
  public static void main(String[] argv) throws Exception {

      JPanel panel = new JPanel(null);

      JLabel helloLabel = new JLabel("Hello world! fghtgihjyjyujkyukuikuoioighjnghj");
      helloLabel.setBounds( 70, 70, 400, 60 ); // x, y, width, height
      panel.add(helloLabel);

      JFrame frame = new JFrame();
      frame.add(panel);
      frame.setPreferredSize( new Dimension(400,400));
      frame.pack();
      frame.setVisible(true);
  }
}