import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class threeButtonMonte implements ActionListener {
	private JFrame window;
	private JButton one, two, three;
	
	/**
	 * Makes window with four buttons to set the color of the background of the window.
	 */
	public threeButtonMonte() {
		window = new JFrame("Click the Buttons!");
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");

		addEventListener(one);
		addEventListener(two);
		addEventListener(three);
		
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
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		boolean correctButton = false;
		Random r = new Random();
		int correct = r.nextInt(3) + 1;
		if (correct == Integer.parseInt(e.getActionCommand()))
			correctButton = true;

		if (!correctButton) 
			System.exit(0);
	}

	/**
	 * main method to test the program
	 * @param args - does nothing
	 */
	public static void main(String[] args) {
		threeButtonMonte four = new threeButtonMonte();
	}
}
