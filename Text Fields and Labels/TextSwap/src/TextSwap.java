import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextSwap implements ActionListener {
   protected JLabel inLabel    = new JLabel( "Word 1: " ) ;
   protected TextField inText  = new TextField( 15 );

   protected JLabel outLabel   = new JLabel( "Word 2: " ) ;
   protected TextField outText = new TextField( 15 );

   protected JButton swapTextButton;

   protected JFrame window;

   public TextSwap() {
      window = new JFrame("swaps text");

      window.setLayout(new FlowLayout());
      swapTextButton = new JButton("Swap the text");

      // this action listener for the class
      inText.addActionListener(this);
      outText.addActionListener(this);
      swapTextButton.addActionListener(this);

      window.add(inLabel);
      window.add(inText);
      window.add(outLabel);
      window.add(outText);
      window.add(swapTextButton);

      window.setVisible(true);
      window.setBounds(100, 100, 290, 200);
      
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String inTextString = inText.getText();

      inText.setText(outText.getText());
      outText.setText(inTextString);
   }
   
   public static void main(String[] args) {
      new TextSwap();
   }
}
