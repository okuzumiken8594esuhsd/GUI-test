import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class CombinationLock implements ActionListener {
	private JFrame window;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero;
    private int code, digit;
	
	/**
	 * Makes window with four buttons to set the color of the background of the window.
	 */
	public CombinationLock() {
		// declaring the variables
		window = new JFrame("Click the Buttons!");
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
        six = new JButton("6");
		seven = new JButton("7");
        eight = new JButton("8");
		nine = new JButton("9");
        zero = new JButton("0");

        code = 000;
        // index of digit
        digit = 0;

		// adding things to the instance variables
		addEventListener(one);
		addEventListener(two);
		addEventListener(three);
        addEventListener(four);
        addEventListener(five);
        addEventListener(six);
        addEventListener(seven);
        addEventListener(eight);
        addEventListener(nine);
        addEventListener(zero);
		
		addButtons();
		
		window.setBackground(Color.ORANGE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(50, 50, 500, 350);
		window.setVisible(true);
	}
	
	/**
	 * adds an event listener to each button
	 * @param b - the button to add an event listener to
	 */
	private void addEventListener(JButton b) {
		b.setActionCommand(b.getText());
		b.addActionListener(this);
	}
	
	/**
	 * adds the buttons to the window
	 */
	private void addButtons() {
		window.setLayout(new FlowLayout());
		window.add(one);
		window.add(two);
		window.add(three);
        window.add(four);
        window.add(five);
        window.add(six);
        window.add(seven);
        window.add(eight);
        window.add(nine);
        window.add(zero);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        int buttonNum = Integer.parseInt(e.getActionCommand());
        // the right code
        System.out.println(code);
        if (buttonNum == code % 10) {
            code /= 10;
            digit++;
            if (code == 0 && (digit >= 3)) {
                window.getContentPane().setBackground(Color.GREEN);
            }
        }
        // wrong code number
        else {
            window.getContentPane().setBackground(Color.RED);
        }
	}



	/**
	 * main method to test the program
	 * @param args - does nothing
	 */
	public static void main(String[] args) {
		new CombinationLock();
	}
}

