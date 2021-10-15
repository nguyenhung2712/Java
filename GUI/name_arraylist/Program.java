package name_arraylist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Program {

	private ArrayList<String> nameList;
	private JFrame frmArraylistDemo;
	private JTextField textName;
	private JLabel lblName;
	private JButton btnAdd;
	private JButton btnShow;
	private JTextArea textAreaNameList;
	private JLabel lblStt;
	private JPanel panelFind;
	private JLabel lblNameFind;
	private JTextField textNameFind;
	private JTextArea textAreaNameAdded;
	private JPanel panelGenerate;
	private JButton btnFind;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frmArraylistDemo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Program() {
		initialize();
	}

	private void initialize() {
		frmArraylistDemo = new JFrame();
		frmArraylistDemo.setResizable(false);
		frmArraylistDemo.getContentPane().setVisible(true);
		frmArraylistDemo.getContentPane().setForeground(Color.WHITE);
		frmArraylistDemo.setTitle("ArrayList Demo");
		frmArraylistDemo.setBounds(100, 100, 758, 388);
		frmArraylistDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArraylistDemo.getContentPane().setLayout(null);
		frmArraylistDemo.setLocationRelativeTo(null); 
		nameList = new ArrayList<String>();
		
		panelGenerate = new JPanel();
		panelGenerate.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Name Generating", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGenerate.setBounds(10, 10, 403, 325);
		frmArraylistDemo.getContentPane().add(panelGenerate);
		panelGenerate.setLayout(null);
		
		btnShow = new JButton("Hiển thị danh sách");
		btnShow.setBounds(10, 89, 167, 27);
		panelGenerate.add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showListName(nameList);
			}
		});
		btnShow.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnShow.setFocusPainted(false);
		
		btnAdd = new JButton("Th\u00EAm");
		btnAdd.setBounds(310, 33, 83, 27);
		panelGenerate.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addName(nameList);
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setFocusPainted(false);
		
		lblStt = new JLabel("Tr\u1EA1ng th\u00E1i th\u00EAm");
		lblStt.setBounds(186, 64, 114, 15);
		panelGenerate.add(lblStt);
		
		
		lblStt.setForeground(new Color(0, 204, 0));
		lblStt.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		
		textName = new JTextField();
		textName.setBounds(111, 34, 189, 27);
		panelGenerate.add(textName);
		textName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblStt.setText("Đang chờ bạn...");
			}
		});
		textName.setColumns(10);
		
		textAreaNameList = new JTextArea();
		textAreaNameList.setBounds(10, 126, 167, 185);
		panelGenerate.add(textAreaNameList);
		
		lblName = new JLabel("Nh\u1EADp h\u1ECD t\u00EAn:");
		lblName.setBounds(10, 35, 91, 24);
		panelGenerate.add(lblName);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		textAreaNameAdded = new JTextArea();
		textAreaNameAdded.setBounds(233, 126, 160, 185);
		panelGenerate.add(textAreaNameAdded);
		
		panelFind = new JPanel();
		panelFind.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Name Finding", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFind.setBounds(429, 10, 305, 110);
		frmArraylistDemo.getContentPane().add(panelFind);
		panelFind.setLayout(null);
		
		lblNameFind = new JLabel("Nhập họ tên:");
		lblNameFind.setBounds(10, 33, 91, 18);
		lblNameFind.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelFind.add(lblNameFind);
		
		textNameFind = new JTextField();
		textNameFind.setBounds(101, 29, 194, 29);
		panelFind.add(textNameFind);
		textNameFind.setColumns(10);
		
		btnFind = new JButton("Tìm");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameList.contains(textNameFind.getText())) {
					JOptionPane.showMessageDialog(frmArraylistDemo, "Tên bạn cần tìm tồn tại trong danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frmArraylistDemo, "Tên bạn cần tìm không tồn tại", "Thông báo", JOptionPane.OK_OPTION);
				}
			}
		});
		btnFind.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnFind.setBounds(101, 71, 121, 29);
		btnFind.setFocusPainted(false);
		panelFind.add(btnFind);
	}
	private void addName(ArrayList<String> nameList) {
		String name = textName.getText();
		nameList.add(name);
		textAreaNameAdded.append(name + "\n");
		textName.setText("");
		lblStt.setText("Thêm thành công");
	}
	private void showListName(ArrayList<String> nameList) {
		if (!textAreaNameList.getText().trim().equals("")) {
			textAreaNameList.setText("");
			btnShow.setText("Hiện danh sách");
		} else {
			for (String name: nameList) {
				textAreaNameList.append(name + "\n");
			}
			btnShow.setText("Ẩn danh sách");
		}
	}
}
