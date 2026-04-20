import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class colorCycle implements ActionListener {
	private JFrame window;
	private JButton next;
	
	/**
	 * Makes window with four buttons to set the color of the background of the window.
	 */
	public colorCycle() {
		window = new JFrame("Click the Buttons!");
		
		next = new JButton("Next Color");
		
		addEventListener(next);
		
		addButtons();
		
		window.setBackground(Color.ORANGE);
		window.getContentPane().setBackground(Color.RED);
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
		window.add(next);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// if gray, wrap around to red
		if (window.getContentPane().getBackground().equals(Color.GRAY))
			window.getContentPane().setBackground(Color.RED);
		// if red, set to green
		else if (window.getContentPane().getBackground().equals(Color.RED))
			window.getContentPane().setBackground(Color.GREEN);
		// if green, set to blue
		else if (window.getContentPane().getBackground().equals(Color.GREEN))
			window.getContentPane().setBackground(Color.BLUE);
		// if blue, set to gray
		else if (window.getContentPane().getBackground().equals(Color.BLUE))
			window.getContentPane().setBackground(Color.GRAY);
		window.repaint();
	}

	/**
	 * main method to test the program
	 * @param args - does nothing
	 */
	public static void main(String[] args) {
		colorCycle c = new colorCycle();
	}
}
