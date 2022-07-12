package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Java is not typically used for creating GUI
 */
public class GUIComponents {

	private static JFrame frame;
	
	public static void runGUI() {

		// Frame refers to the actual window.
		frame = new JFrame("GUI Example");

		frame.setSize(900, 400); // width x length
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		textPanel();
		menuPanel();
		buttonPanel();
	}

	@SuppressWarnings("unused")
	public static void textPanel() {
		
		// Panels are used to organize the Frame.
		JPanel textPanel = new JPanel();

		// Basic elements:
		JLabel label = new JLabel("Labels display text.");
		
		ImageIcon image = new ImageIcon("/home/t008/Desktop/Photos/Nice.jpg", "Meme");
		JLabel imageDisplay = new JLabel(image);
		
		JTextField input = new JTextField(20); // Textbox
		JTextArea lInput = new JTextArea(5, 20); // Text area
		
		// Adding elements to the panel.
		textPanel.add(label);
		// textPanel.add(imageDisplay);
		textPanel.add(input);
		textPanel.add(lInput);
		
		// Component method examples.
		System.out.println("Text Entered: " + input.getText());
		lInput.setBackground(Color.LIGHT_GRAY);	

		// Adds a scroll bar to the GUI element.
		textPanel.add(new JScrollPane(lInput));
		
		frame.getContentPane().add(textPanel, BorderLayout.NORTH);
		
	}

	public static void menuPanel() {
		
		JPanel menuPanel = new JPanel();
		
		JComboBox<String> age = new JComboBox<>();
		age.addItem(""); // Defaults to empty String.
		age.addItem("Under 18");
		age.addItem("18-21");
		age.addItem("Over 21");
		
		menuPanel.add(age);
		
		frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
	}
	
	public static void buttonPanel() {
		
		JPanel buttonPanel = new JPanel();
		
		JButton click = new JButton("Click me!"); 
		// The functionality of a component must be defined via Listeners.
		click.addMouseListener(new DefaultMouseListener());
		
		buttonPanel.add(click);
		
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		runGUI();
	}
}
