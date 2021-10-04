package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMIComponent {

	private JFrame frmBmiCalculator;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JTextField txtRes;
	private JTextField txtStt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMIComponent window = new BMIComponent();
					window.frmBmiCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMIComponent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBmiCalculator = new JFrame();
		frmBmiCalculator.setTitle("BMI CALCULATOR");
		frmBmiCalculator.getContentPane().setBackground(new Color(153, 255, 153));
		frmBmiCalculator.setBounds(100, 100, 444, 399);
		frmBmiCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBmiCalculator.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 102));
		panel.setBounds(0, 0, 430, 39);
		frmBmiCalculator.getContentPane().add(panel);
		
		JLabel lblMain = new JLabel("BMI CALCULATOR");
		lblMain.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblMain);
		
		JLabel lblHeight = new JLabel("Chi\u1EC1u cao");
		lblHeight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHeight.setBounds(38, 71, 91, 23);
		frmBmiCalculator.getContentPane().add(lblHeight);
		
		txtHeight = new JTextField();
		txtHeight.setBounds(142, 71, 212, 23);
		frmBmiCalculator.getContentPane().add(txtHeight);
		txtHeight.setColumns(10);
		
		JLabel lblCnNng = new JLabel("C\u00E2n n\u1EB7ng");
		lblCnNng.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCnNng.setBounds(38, 117, 91, 23);
		frmBmiCalculator.getContentPane().add(lblCnNng);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(142, 117, 212, 23);
		frmBmiCalculator.getContentPane().add(txtWeight);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Region", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(153, 255, 153));
		panel_1.setBounds(52, 241, 155, 111);
		frmBmiCalculator.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnAsian = new JRadioButton("Asian");
		rdbtnAsian.setBackground(new Color(153, 255, 153));
		rdbtnAsian.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnAsian.setBounds(6, 32, 103, 21);
		panel_1.add(rdbtnAsian);
		
		JRadioButton rdbtnNonAsian = new JRadioButton("Non Asian");
		rdbtnNonAsian.setFont(new Font("Times New Roman", Font.BOLD, 16));
		rdbtnNonAsian.setBackground(new Color(153, 255, 153));
		rdbtnNonAsian.setBounds(6, 69, 103, 21);
		panel_1.add(rdbtnNonAsian);
		
		txtRes = new JTextField();
		txtRes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtRes.setEditable(false);
		txtRes.setBounds(230, 274, 124, 23);
		frmBmiCalculator.getContentPane().add(txtRes);
		txtRes.setColumns(10);
		
		JLabel lblBMI = new JLabel("BMI");
		lblBMI.setHorizontalAlignment(SwingConstants.CENTER);
		lblBMI.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBMI.setBounds(261, 251, 60, 13);
		frmBmiCalculator.getContentPane().add(lblBMI);
		
		JButton btnNewButton = new JButton("T\u00EDnh to\u00E1n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStt.setText("");
				txtRes.setText("");
				try {
					double weight = Double.parseDouble(txtWeight.getText());
	                double height = Double.parseDouble(txtHeight.getText());
	                if (weight < 0 || height < 0) {
	                	txtStt.setText("Error");
	                } else {
	                	double bmi = Math.round((weight / (height*2))*100.0) / 100.0;
		                txtRes.setText(String.valueOf(bmi));
		                
		                if (rdbtnAsian.isSelected()) {
		                	if (bmi < 18.5) {
			                	 txtStt.setText("Underweight");
			                 } else if (bmi < 23) {
			                	 txtStt.setText("Normal");
			                 } else if (bmi < 25) {
			                	 txtStt.setText("Overweight");
			                 } else if (bmi < 30) {
			                	 txtStt.setText("Pre-Obese");
			                 } else {
			                	 txtStt.setText("Obese");
			                 }
		                } else if (rdbtnNonAsian.isSelected()) {
		                	if (bmi < 18.5) {
			                	 txtStt.setText("Underweight");
			                 } else if (bmi < 25) {
			                	 txtStt.setText("Normal");
			                 } else if (bmi < 30) {
			                	 txtStt.setText("Overweight");
			                 } else {
			                	 txtStt.setText("Obese");
			                 }
		                }
	                }
				} catch (Exception ex) {
					txtStt.setText("Error");
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(52, 172, 302, 39);
		btnNewButton.setFocusPainted(false);
		frmBmiCalculator.getContentPane().add(btnNewButton);
		
		txtStt = new JTextField();
		txtStt.setEditable(false);
		txtStt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtStt.setBounds(230, 320, 124, 32);
		frmBmiCalculator.getContentPane().add(txtStt);
		txtStt.setColumns(10);
	}
}
