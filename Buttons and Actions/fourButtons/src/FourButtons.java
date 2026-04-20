package fourButtons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FourButtons implements ActionListener {
	private JFrame window;
	private JButton red, green, blue, gray;
	
	/**
	 * Makes window with four buttons to set the color of the background of the window.
	 */
	public FourButtons() {
		window = new JFrame("Click the Buttons!");
		
		red = new JButton("Red");
		green = new JButton("Green");
		blue = new JButton("Blue");
		gray = new JButton("Gray");
		
		addEventListener(red);
		addEventListener(green);
		addEventListener(blue);
		addEventListener(gray);
		
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
		window.add(red);
		window.add(green);
		window.add(blue);
		window.add(gray);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonPressed = e.getActionCommand();
		System.out.println(buttonPressed);
		if (buttonPressed.equals("Red"))
			window.getContentPane().setBackground(Color.RED);
		if (buttonPressed.equals("Green"))
			window.getContentPane().setBackground(Color.GREEN);
		if (buttonPressed.equals("Blue"))
			window.getContentPane().setBackground(Color.BLUE);
		if (buttonPressed.equals("Gray"))
			window.getContentPane().setBackground(Color.GRAY);
		window.repaint();
	}

	/**
	 * main method to test the program
	 * @param args - does nothing
	 */
	public static void main(String[] args) {
		FourButtons four = new FourButtons();
	}
}
