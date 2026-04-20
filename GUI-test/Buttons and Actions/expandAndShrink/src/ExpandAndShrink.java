import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExpandAndShrink implements ActionListener{
	private JFrame window;
    private JButton expand, shrink;
    private double width, height;
    
    public ExpandAndShrink() {
        window = new JFrame("Click the Buttons!");
        expand = new JButton("Make larger");
        shrink = new JButton("Make smaller");
        width = 200.0;
        height = 100.0;

        addEventListener(expand);
        addEventListener(shrink);

        addButtons();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(50, 50, (int)width, (int)height);
		window.setVisible(true);
    }

	/**
	 * adds an event listener to each button
	 * @param b - the button to add an event listener to
	 */
	private void addEventListener(JButton b) {
        String action = b.getText();
        if (action.equals("Make larger")) {
            action = "+";
        }
        else if (action.equals("Make smaller")) {
            action = "-";
        }
		b.setActionCommand(action);
		b.addActionListener(this);
	}

    /**
	 * adds the buttons to the window
	 */
	private void addButtons() {
		window.setLayout(new FlowLayout());
		window.add(expand);
		window.add(shrink);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        // readjusting the height and width in case the user resizes the window
        if (window.getWidth() != width) {
            width = window.getWidth();
        }
        if (window.getHeight() != height) {
            height = window.getHeight();
        }
        // making the window larger or smaller
        if (action.equals("+")) {
            width *= 1.1;
            height *= 1.1;
            window.setSize((int)width, (int)height);
        }
        else if (action.equals("-")) {
            width *= 0.9;
            height *= 0.9;
            window.setSize((int)width, (int)height);
        }
    }

    public static void main(String[] args) {
        new ExpandAndShrink();
    }
}
