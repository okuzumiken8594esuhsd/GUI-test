import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuessingGame  implements ActionListener {

   protected JLabel inLabel    = new JLabel( "Enter the secret word: " ) ;
   protected TextField inText  = new TextField( 15 );

   protected JLabel outLabel   = new JLabel( "Were you right?: " ) ;
   protected TextField outText = new TextField( 15 );

   protected JFrame window;
   private int numberOfGuesses;
   
   /**
    * The constructor of a window with title given
    * @param title - the title of the window
    */
   public GuessingGame( String title )
   {  
      window = new JFrame(title);
      numberOfGuesses = 0;

      window.setLayout( new FlowLayout() ); 
      outText.setEditable(false);
      window.add( inLabel  ) ;
      window.add( inText   ) ;
      window.add( outLabel ) ;
      window.add( outText  ) ;

      window.setVisible(true);
      window.setBounds(100, 100, 300, 200);

      inText.addActionListener( this );
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
   }



   @Override
   public void actionPerformed(ActionEvent e) {
      numberOfGuesses++;
      String secretWord = "MySecret";
      // bottom field edited
      if (e.getActionCommand().equals(secretWord)) {
         outText.setText("correct");
      }
      else {
         outText.setText( "wrong!");
      }
      inText.setText("");

      if (numberOfGuesses == 3) {
         System.exit(0);
      }
   }
   
   public static void main(String[] args) {
      new GuessingGame("guess the word");
   }
   
}
