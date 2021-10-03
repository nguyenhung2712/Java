package calculator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class BMIComponent extends JFrame {
	private static class RoundedBorder implements Border {

	    private int radius;
	    
	    public RoundedBorder(int radius) {
	        this.radius = radius;
	    }
	    public boolean isBorderOpaque() {
	        return true;
	    }
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width-1, height-1, radius, radius);
		}
		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
		}
	}
	public BMIComponent() {
		JFrame f = new JFrame("BMI CALCULATOR");
		f.getContentPane().setBackground(new Color(200, 217, 199));
		
		//Setting property of main label
		JLabel lblName = new JLabel("BMI CALCULATOR", SwingConstants.CENTER);
		lblName.setOpaque(true);
		lblName.setBackground(new Color(156, 200, 164));
		lblName.setFont (lblName.getFont().deriveFont(24.0f));
		lblName.setBounds(0, 0, 386, 50);
		f.add(lblName);
		
		//Setting property of height label
        JLabel lblHeight = new JLabel("Height(m)", SwingConstants.CENTER);
        lblHeight.setFont(lblHeight.getFont().deriveFont(14.0f));
        lblHeight.setBounds(50, 60, 120, 36);
        f.add(lblHeight); 
 
        //Setting property of weight label
        JLabel lblWeight = new JLabel("Weight(kg)", SwingConstants.CENTER);
        lblWeight.setFont(lblWeight.getFont().deriveFont(14.0f));
        lblWeight.setBounds(50, 105, 120, 36);
        f.add(lblWeight); 
        
        //Setting property of height text field
        JTextField txtHeight = new JTextField("");
        txtHeight.setBackground(new Color(233, 233, 231));
        txtHeight.setBounds(160, 70, 160, 26);
        f.add(txtHeight); 
 
        //Setting property of weight text field
        JTextField txtWeight = new JTextField("");
        txtWeight.setBackground(new Color(233, 233, 231));
        txtWeight.setBounds(160, 114, 160, 26);
        f.add(txtWeight); 
        
        //Setting property of execute button
        JButton btn = new JButton("CALCULATE"); 
        btn.setBackground(new Color(233,233,231));
        btn.setBorder(new RoundedBorder(20));
        btn.setBounds(20, 220, 350, 30);
        btn.setFocusPainted(false);
        
        //Setting property of BMI label
        JLabel lblBMI = new JLabel("BMI");
        lblBMI.setFont(lblWeight.getFont().deriveFont(14.0f));
        lblBMI.setBounds(30, 140, 32, 40);
        f.add(lblBMI);
        
        //Setting property of BMI result
        JTextField txtBMI = new JTextField("");
        txtBMI.setHorizontalAlignment(JTextField.CENTER);
        txtBMI.setBounds(62, 150, 60, 24);
        txtBMI.setEditable(false);
        f.add(txtBMI);
        
        //Setting property of Ideal Weight label
        JLabel lblIdeal = new JLabel("Ideal Weight");
        lblIdeal.setFont(lblWeight.getFont().deriveFont(14.0f));
        lblIdeal.setBounds(160, 140, 130, 40);
        f.add(lblIdeal);
        
        //Setting property of Ideal Weight result
        JTextField txtIdeal = new JTextField("");
        txtIdeal.setBounds(257, 150, 103, 24);
        txtIdeal.setHorizontalAlignment(JTextField.CENTER);
        txtIdeal.setEditable(false);
        f.add(txtIdeal);
        
        //Setting property of advice field
        JTextField txtStt = new JTextField("");
        txtStt.setBounds(30, 186, 330, 24);
        txtStt.setHorizontalAlignment(JTextField.CENTER);
        txtStt.setEditable(false);
        f.add(txtStt);
        
        //EventListener
        btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(txtWeight.getText());
	                double height = Double.parseDouble(txtHeight.getText());
	                if (weight < 0 || height < 0) {
	                	txtStt.setText("Error");
	                } else {
	                	double bmi = Math.round((weight / (height*2))*100.0) / 100.0;
		                double maxWeight = height*100 % 100;
		                double minWeight = (height*100 % 100)*8 / 10;
		                double perfectWeight = (height*100 % 100)*9 / 10;
		                
		                txtBMI.setText(String.valueOf(bmi));
		                txtIdeal.setText(String.valueOf(minWeight) + "kg - " + String.valueOf(maxWeight) + "kg");
		                
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
				} catch (Exception ex) {
					txtStt.setText("Error");
				}
			}
        });
        f.add(btn);
        
        f.setSize(400, 300);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new BMIComponent();
	}
	
}
