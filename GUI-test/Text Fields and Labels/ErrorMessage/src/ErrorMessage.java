import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ErrorMessage implements ActionListener {
   protected JLabel inLabel    = new JLabel( "Enter the message: " ) ;
   protected TextField inText  = new TextField( 15 );

   protected JLabel outLabel   = new JLabel( "response: " ) ;
   protected TextField outText = new TextField( 15 );

   protected JFrame window;

   /**
    * The constructor of a window with title given
    * @param title - the title of the window
    */
   public ErrorMessage( String title )
   {  
      window = new JFrame(title);

      window.setLayout( new FlowLayout() ); 
      window.add( inLabel  ) ;
      window.add( inText   ) ;
      window.add( outLabel ) ;
      window.add( outText  ) ;

      window.setVisible(true);
      window.setBounds(100, 100, 300, 200);

      inText.addActionListener( this );
      outText.addActionListener(this);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
   }

   @Override
   /**
    * This runs whenever the actionlistener for the text fields are triggered
    * that is, whenever ENTER is hiton the text field
    */
   public void actionPerformed(ActionEvent e) {
      String newText = e.getActionCommand();
      // new line to input text
      System.out.println("New Text " + newText + " " + newText.length());
      // if (newText.equals("\n")) {
         // if the newest text entered is the top box
         if (newText.equals(inText.getText())) {
            outText.setText(newText);
         } else {
            outText.setText("Enter text in the top field");
         }
      // }
   }
   public static void main(String[] args) {
      new ErrorMessage(
         "s"
      );
   }
}
