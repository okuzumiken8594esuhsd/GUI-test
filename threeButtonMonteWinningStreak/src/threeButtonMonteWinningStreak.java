import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class threeButtonMonteWinningStreak implements ActionListener {
	private JFrame window;
	private JButton one, two, three;
	private int streak;
	
	/**
	 * Makes window with four buttons to set the color of the background of the window.
	 */
	public threeButtonMonteWinningStreak() {
		// declaring the variables
		window = new JFrame("Click the Buttons!");
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");

		streak = 0;

		// adding things to the instance variables
		addEventListener(one);
		addEventListener(two);
		addEventListener(three);
		
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
		window.add(one);
		window.add(two);
		window.add(three);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		boolean correctButton = false;
		Random r = new Random();
		int incorrect = r.nextInt(3) + 1;
		System.out.println("anything but: " + incorrect);

		// exit the program if the close button is next to avoid calling Integer.parse("close")
		if (e.getActionCommand().equals("close"))
			System.exit(0);

		if (incorrect != Integer.parseInt(e.getActionCommand())) {
			streak++;
			correctButton = true;
			updateBGColor();
		}

		// show streak if not the correct button
		if (!correctButton) {
			window.getContentPane().setBackground(Color.CYAN);
			window.remove(one);
			window.remove(two);
			window.remove(three);
			TextArea score = new TextArea("Score: " + streak);
			JButton close = new JButton("close");
			addEventListener(close);
			window.add(score);
			window.add(close);
			// not sure what repaint does because I need the line of code below to make the new things appear
			window.repaint();
			// resizing the window makes the TextArea and JButton appear for some reason
			window.setSize(501, 350);
			window.setSize(500, 350);
			window.setTitle("Game Over!");
			System.out.println(window.getComponentCount());
			System.out.println(window.getExtendedState());
		}
	}

	/**
	 * Updates the background color between red, gree, blue, and gray
	 */
	private void updateBGColor() {
		// if gray, return to red
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
		new threeButtonMonteWinningStreak();
	}
}
