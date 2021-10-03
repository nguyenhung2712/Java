package calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NumCalComponent {
	JLabel lblA, lblB;
	JTextField txtRes, txtA, txtB;
	public NumCalComponent() {
		JFrame f = new JFrame("CALCULATOR");
		f.getContentPane().setBackground(new Color(200, 217, 199));
		
		//Setting property of main label
		JLabel lblName = new JLabel("CALCULATOR", SwingConstants.CENTER);
		lblName.setOpaque(true);
		lblName.setBackground(new Color(156, 200, 164));
		lblName.setFont (lblName.getFont().deriveFont(24.0f));
		lblName.setBounds(0, 0, 286, 50);
		f.add(lblName);
		
		//Setting property of first number label
        lblA = new JLabel("A", SwingConstants.CENTER);
        lblA.setFont(lblA.getFont().deriveFont(14.0f));
        lblA.setBounds(40, 60, 10, 36);
        f.add(lblA); 
 
        //Setting property of second number label
        lblB = new JLabel("B", SwingConstants.CENTER);
        lblB.setFont(lblB.getFont().deriveFont(14.0f));
        lblB.setBounds(40, 105, 10, 36);
        f.add(lblB);
        
        //Setting property of first number text field
        txtA = new JTextField("");
        txtA.setBackground(new Color(233, 233, 231));
        txtA.setBounds(80, 68, 160, 26);
        f.add(txtA); 
 
        //Setting property of second number text field
        txtB = new JTextField("");
        txtB.setBackground(new Color(233, 233, 231));
        txtB.setBounds(80, 112, 160, 26);
        f.add(txtB); 
        
        //Setting property of plus button
        JButton plusBtn = new JButton("+"); 
        plusBtn.setBackground(new Color(233,233,231));
        plusBtn.setBounds(20, 180, 70, 30);
        plusBtn.setFocusPainted(false);
		f.add(plusBtn);
		
		//Setting property of plus button
        JButton minusBtn = new JButton("-"); 
        minusBtn.setBackground(new Color(233,233,231));
        minusBtn.setBounds(109, 180, 70, 30);
        minusBtn.setFocusPainted(false);
		f.add(minusBtn);
		
		//Setting property of multiply button
        JButton mulBtn = new JButton("*"); 
        mulBtn.setBackground(new Color(233,233,231));
        mulBtn.setBounds(198, 180, 70, 30);
        mulBtn.setFocusPainted(false);
		f.add(mulBtn);
		
		//Setting property of devided button
        JButton devBtn = new JButton("/"); 
        devBtn.setBackground(new Color(233,233,231));
        devBtn.setBounds(20, 220, 248, 30);
        devBtn.setFocusPainted(false);
		f.add(devBtn);
		
		//Setting property of result field
        txtRes = new JTextField("");
        txtRes.setBounds(20, 280, 248, 28);
        txtRes.setHorizontalAlignment(JTextField.CENTER);
        txtRes.setEditable(false);
        f.add(txtRes);
        
        plusBtn.addActionListener(new ExecuteEvent());
        minusBtn.addActionListener(new ExecuteEvent());
        mulBtn.addActionListener(new ExecuteEvent());
        devBtn.addActionListener(new ExecuteEvent());
		
		f.setSize(300, 380);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
	}
	
	class ExecuteEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				String execType = e.getActionCommand();
				double firstNum = Double.parseDouble(txtA.getText());
				double secNum = Double.parseDouble(txtB.getText());
				
				switch (execType) {
					case "+": txtRes.setText(String.valueOf(Math.round((firstNum + secNum)*100.0)/100.0)); break;
					case "-": txtRes.setText(String.valueOf(Math.round((firstNum - secNum)*100.0)/100.0)); break;
					case "*": txtRes.setText(String.valueOf(Math.round((firstNum * secNum)*100.0)/100.0)); break;
					case "/": {
						if (secNum == 0) {
							txtRes.setText("Error");
						} else {
							txtRes.setText(String.valueOf(Math.round((firstNum / secNum)*100.0)/100.0)); 
						}
					} break;
				}
			} catch (Exception ex) {
				txtRes.setText("Error");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new NumCalComponent();
	}
}
