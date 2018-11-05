package dosclic.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Gui {
	public static JFrame window = new JFrame("Downloading time");
	public static JPanel panel = new JPanel(new GridLayout(0,2,0,8));
	public static JPanel panel2 = new JPanel(new GridLayout(0,2));
	public static JPanel panel3 = new JPanel(new GridLayout(0,2,15,0));
	public static JPanel panelEmpty = new JPanel(new GridLayout(2,2));
	public static JTextField input0 = new JTextField(10);
	public static JLabel labelInput0 = new JLabel("Downloading size(GB): ");
	public static JButton buttonInput = new JButton("Calculate");
	public static JButton buttonReset = new JButton("Reset");
	public static JTextField input1 = new JTextField(10);
	public static JLabel labelInput1 = new JLabel("Downloading speed(MB/s) : ");
	public static JTextField output = new JTextField(10);
	public static JLabel labelOutput = new JLabel("Time requested: ");
	
	
	public static void main(String[] args) {
		createTextFieldInput();
		createPanel();
		createWindow();
		calculateEvent();
		resetEvent();
	}

	private static void resetEvent() {
		buttonReset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				input0.setText("");
				input1.setText("");
				output.setText("");
			}
		});

	}

	public static void calculateEvent() {
		buttonInput.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				String out = getInput(input0);
				output.setText(out);
			}
		});

	}

	public static String getInput(JTextField input2) {
		String in = input0.getText();
		String in1 = input1.getText();
		String out = null;
		try {
			/* 'out' viene usato per il parseDouble, per poter sapere quale
			 * stringa non � un numero valido */
			out = in;
			double d1 = Double.parseDouble(out);
			out = in1;
			double d2 = Double.parseDouble(out);
			out = OutCalc.time(d1, d2);
		} catch(NumberFormatException ex) {
			if(out.matches("\\s*")) // controlla se 'out' � una stringa vuota
				out = "Invalid number: <empty>";
			else
				out = "Invalid number: '"+out+"'";
		}
		return out;
	}

	public static void createTextFieldInput() {
		input0.setHorizontalAlignment(JTextField.LEFT);
	}
	public static void createWindow() {
		window.getContentPane().setBackground(new Color(77,77,77));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel, BorderLayout.NORTH);
		window.add(panel2, BorderLayout.CENTER);
		window.add(panel3, BorderLayout.SOUTH);
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
	}

	public static void createPanel() {
		panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 30, 15));
		panel.add(labelInput0);
		panel.add(input0);
		panel.add(labelInput1);
		panel.add(input1);

		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(labelOutput);
		panel2.add(output);

		// Disable user input and set black color
		output.setHorizontalAlignment(JTextField.CENTER);
		output.setEnabled(false);
		output.setDisabledTextColor(new Color(0,0,0));

		panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		// buttonInput.setSize(50, 50);
		panel3.add(buttonInput);
		panel3.add(buttonReset);
	}


}
