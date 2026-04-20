import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EchoBothFields implements ActionListener {
   protected JLabel inLabel    = new JLabel( "Word 1: " ) ;
   protected TextField inText  = new TextField( 15 );

   protected JLabel outLabel   = new JLabel( "Word 2: " ) ;
   protected TextField outText = new TextField( 15 );

   protected JFrame window;

   public EchoBothFields() {
      window = new JFrame("echos words");

      window.setLayout(new FlowLayout());

      inText.addActionListener(this);
      outText.addActionListener(this);

      window.add(inLabel);
      window.add(inText);
      window.add(outLabel);
      window.add(outText);

      window.setVisible(true);
      window.setBounds(100, 100, 300, 200);
      
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      inText.setText(e.getActionCommand());
      outText.setText(e.getActionCommand());
   }
   
   public static void main(String[] args) {
      new EchoBothFields();
   }
}
