package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import items.Item;
import methods.Calculation;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField mouseField;
	private JTextField laptopField;
	private JTextField desktopField;
	private JTextField lcdField;
	
	private JLabel resultLabel;
	private JLabel bestShippingMethod;

	public JLabel getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(JLabel resultLabel) {
		this.resultLabel = resultLabel;
	}

	public JLabel getBestShippingMethod() {
		return bestShippingMethod;
	}

	public void setBestShippingMethod(JLabel bestShippingMethod) {
		this.bestShippingMethod = bestShippingMethod;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shipping Company");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(266, 56, 190, 35);
		contentPane.add(lblNewLabel);
		
		JLabel laptopLabel = new JLabel("Number of Laptop:");
		laptopLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		laptopLabel.setBounds(243, 121, 132, 14);
		contentPane.add(laptopLabel);
		
		JLabel mouseLabel = new JLabel("Number of Mouse:");
		mouseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mouseLabel.setBounds(243, 165, 132, 14);
		contentPane.add(mouseLabel);
		
		JLabel desktopLabel = new JLabel("Number of Desktop:");
		desktopLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		desktopLabel.setBounds(243, 211, 132, 14);
		contentPane.add(desktopLabel);
		
		JLabel lcdLabel = new JLabel("Number of LCD:");
		lcdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lcdLabel.setBounds(243, 254, 132, 14);
		contentPane.add(lcdLabel);
		
		mouseField = new JTextField();
		mouseField.setBounds(385, 164, 86, 20);
		contentPane.add(mouseField);
		mouseField.setColumns(10);
		
		laptopField = new JTextField();
		laptopField.setColumns(10);
		laptopField.setBounds(385, 120, 86, 20);
		contentPane.add(laptopField);
		
		desktopField = new JTextField();
		desktopField.setColumns(10);
		desktopField.setBounds(385, 210, 86, 20);
		contentPane.add(desktopField);
		
		lcdField = new JTextField();
		lcdField.setColumns(10);
		lcdField.setBounds(385, 253, 86, 20);
		contentPane.add(lcdField);
		
		laptopField.setText("0");
		mouseField.setText("0");
		lcdField.setText("0");
		desktopField.setText("0");
		
		
		JLabel totalCostLabel = new JLabel("Total Shipping Cost:");
		totalCostLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalCostLabel.setBounds(243, 353, 132, 20);
		contentPane.add(totalCostLabel);
		
		JLabel euro = new JLabel("€");
		euro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		euro.setBounds(402, 353, 14, 20);
		contentPane.add(euro);
		
		resultLabel = new JLabel("_________");
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultLabel.setBounds(416, 353, 132, 20);
		contentPane.add(resultLabel);
		
		JButton totelButton = new JButton("Calculate Cost");
		totelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Calculation calculation = new Calculation();

		        // Add products details
		        calculation.addItems(new Item("Laptop", 60, 50, 50, 6.5));
		        calculation.addItems(new Item("Mouse", 30, 30, 20, 0.2));
		        calculation.addItems(new Item("Desktop", 100, 150, 50, 20));
		        calculation.addItems(new Item("LCD screens", 120, 140, 80, 2.6));
	        
		        // Read the order
		        calculation.addOrder(Integer.parseInt(laptopField.getText())); // 100 Laptops
		        calculation.addOrder(Integer.parseInt(mouseField.getText())); // 200 Mice
		        calculation.addOrder(Integer.parseInt(desktopField.getText())); // 150 Desktops
		        calculation.addOrder(Integer.parseInt(lcdField.getText())); // 200 LCD screens

		        // Print the results
		        calculation.printItemInfo();
		        calculation.printOrder();
		        calculation.bestShipping();
		        
		        
		        
		        resultLabel.setText(calculation.getShipPrice()+"");
		        bestShippingMethod.setText("Best shipping method:     " + calculation.getBestShipMethod());
			}
		});
		totelButton.setBounds(323, 307, 116, 29);
		contentPane.add(totelButton);
		
		bestShippingMethod = new JLabel("Best shipping method:     ");
		bestShippingMethod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bestShippingMethod.setBounds(143, 397, 584, 20);
		contentPane.add(bestShippingMethod);
	}
}
