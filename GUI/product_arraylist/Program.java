package product_arraylist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Program {
	ArrayList<SanPham> productList;
	private JFrame frmProductManager;
	private JTextField txtAddID;
	private JTextField txtAddName;
	private JTextField txtAddPrice;
	private JTextField txtExecID;
	private JPanel panelAdd;
	private JLabel lblAddID;
	private JLabel lblAddName;
	private JLabel lblAddPrice;
	private JButton btnAdd;
	private JPanel panelFunc;
	private JLabel lblExecID;
	private JButton btnFind;
	private JButton btnDel;
	private JTextArea textAreaProductList;
	private JButton btnEdit;
	private JTextField txtIDEdit;
	private JLabel lblIDEdit;
	private JLabel lblNameEdit;
	private JTextField txtNameEdit;
	private JLabel lblPriceEdit;
	private JTextField txtPriceEdit;
	private JPanel EditPanel;
	private JButton btnCheck;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.getFrmProductManager().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		productList = new ArrayList<SanPham>();
		frmProductManager = new JFrame();
		getFrmProductManager().setTitle("Product Management");
		getFrmProductManager().setBounds(100, 100, 550, 586);
		getFrmProductManager().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmProductManager().getContentPane().setLayout(null);
		getFrmProductManager().setLocationRelativeTo(null);
		
		panelAdd = new JPanel();
		panelAdd.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Product Adding", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAdd.setBounds(10, 10, 521, 197);
		getFrmProductManager().getContentPane().add(panelAdd);
		panelAdd.setLayout(null);
		
		lblAddID = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m");
		lblAddID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddID.setBounds(10, 20, 95, 28);
		panelAdd.add(lblAddID);
		
		txtAddID = new JTextField();
		txtAddID.setBounds(115, 20, 396, 28);
		panelAdd.add(txtAddID);
		txtAddID.setColumns(10);
		
		lblAddName = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m");
		lblAddName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddName.setBounds(10, 63, 95, 28);
		panelAdd.add(lblAddName);
		
		txtAddName = new JTextField();
		txtAddName.setColumns(10);
		txtAddName.setBounds(115, 63, 396, 28);
		panelAdd.add(txtAddName);
		
		lblAddPrice = new JLabel("\u0110\u01A1n gi\u00E1");
		lblAddPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddPrice.setBounds(10, 108, 95, 28);
		panelAdd.add(lblAddPrice);
		
		txtAddPrice = new JTextField();
		txtAddPrice.setColumns(10);
		txtAddPrice.setBounds(115, 108, 396, 28);
		panelAdd.add(txtAddPrice);
		
		btnAdd = new JButton("Th\u00EAm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ID = txtAddID.getText();
					String name = txtAddName.getText();
					float price = Float.parseFloat(txtAddPrice.getText());
					
					if (checkID(ID)) {
						JOptionPane.showMessageDialog(getFrmProductManager(), "Đã tồn tại sản phẩm", "Thông báo", JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(getFrmProductManager(), "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						textAreaProductList.setText("");
						productList.add(new SanPham(ID, name, price));
						for (SanPham product: productList) {
							textAreaProductList.append(product.getMaSP() + " --- " + product.getTenSP() + " --- " + product.getDonGia() + "\n");
						}
						txtAddID.setText("");
						txtAddName.setText("");
						txtAddPrice.setText("");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(getFrmProductManager(), "Dữ liệu không hợp lệ", "Thông báo", JOptionPane.OK_OPTION);
					txtAddID.setText("");
					txtAddName.setText("");
					txtAddPrice.setText("");
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdd.setBounds(179, 146, 143, 35);
		btnAdd.setFocusPainted(false);
		panelAdd.add(btnAdd);
		
		panelFunc = new JPanel();
		panelFunc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Product Functions Management", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFunc.setBounds(10, 217, 516, 123);
		getFrmProductManager().getContentPane().add(panelFunc);
		panelFunc.setLayout(null);
		
		txtExecID = new JTextField();
		txtExecID.setColumns(10);
		txtExecID.setBounds(115, 37, 391, 28);
		panelFunc.add(txtExecID);
		
		lblExecID = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m");
		lblExecID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblExecID.setBounds(10, 37, 109, 28);
		panelFunc.add(lblExecID);
		
		btnFind = new JButton("T\u00ECm");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDExec = txtExecID.getText();
				if (checkID(IDExec)) {
					JOptionPane.showMessageDialog(getFrmProductManager(), "Sản phẩm bạn cần tìm tồn tại trong danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(getFrmProductManager(), "Sản phẩm bạn cần tìm không tồn tại", "Thông báo", JOptionPane.OK_OPTION);
				}
				txtExecID.setText("");
			}
		});
		btnFind.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnFind.setBounds(115, 75, 133, 28);
		btnFind.setFocusPainted(false);
		panelFunc.add(btnFind);
		
		btnDel = new JButton("X\u00F3a");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDExec = txtExecID.getText();
				if (checkID(IDExec)) {
					int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sản phẩm có mã là " + checkID(IDExec), "Thông báo", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						productList.remove(checkIDReturnProduct(IDExec));
						JOptionPane.showMessageDialog(getFrmProductManager(), "Đã xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						textAreaProductList.setText("");
						for (SanPham product: productList) {
							textAreaProductList.append(product.getMaSP() + " --- " + product.getTenSP() + " --- " + product.getDonGia() + "\n");
						}
					}
				} else {
					JOptionPane.showMessageDialog(getFrmProductManager(), "Sản phẩm bạn muốn xóa không tồn tại", "Thông báo", JOptionPane.OK_OPTION);
				}
				txtExecID.setText("");
			}
		});
		btnDel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDel.setBounds(287, 75, 133, 28);
		btnDel.setFocusPainted(false);
		panelFunc.add(btnDel);
		
		textAreaProductList = new JTextArea();
		textAreaProductList.setEditable(false);
		textAreaProductList.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaProductList.setBounds(10, 350, 251, 189);
		getFrmProductManager().getContentPane().add(textAreaProductList);
		
		EditPanel = new JPanel();
		EditPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Product Editing", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		EditPanel.setBounds(271, 350, 255, 189);
		frmProductManager.getContentPane().add(EditPanel);
		EditPanel.setLayout(null);
		
		btnEdit = new JButton("Chỉnh sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String IDExec = txtIDEdit.getText();
					String nameExec = txtNameEdit.getText();
					float priceExec = Float.parseFloat(txtPriceEdit.getText());
					SanPham sp = checkIDReturnProduct(IDExec);
					
					productList.add(productList.indexOf(sp), new SanPham(IDExec, nameExec, priceExec));
					productList.remove(sp);
					
					textAreaProductList.setText("");
					for (SanPham product: productList) {
						textAreaProductList.append(product.getMaSP() + " --- " + product.getTenSP() + " --- " + product.getDonGia() + "\n");
					}
					JOptionPane.showMessageDialog(getFrmProductManager(), "Chỉnh sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					txtIDEdit.setText("");
					txtNameEdit.setText("");
					txtPriceEdit.setText("");
					btnCheck.setEnabled(true);
					txtNameEdit.setEditable(false);
					txtPriceEdit.setEditable(false);
					btnEdit.setEnabled(false);
					txtIDEdit.setEditable(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(getFrmProductManager(), "Dữ liệu không hợp lệ", "Thông báo", JOptionPane.OK_OPTION);
					txtNameEdit.setText("");
					txtPriceEdit.setText("");
				}
			}
		});
		btnEdit.setEnabled(false);
		btnEdit.setBounds(137, 150, 108, 29);
		btnEdit.setFocusPainted(false);
		EditPanel.add(btnEdit);
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnCheck = new JButton("Kiểm tra");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDExec = txtIDEdit.getText();
				if (checkID(IDExec)) {
					txtNameEdit.setEditable(true);
					txtPriceEdit.setEditable(true);
					btnEdit.setEnabled(true);
					btnCheck.setEnabled(false);
					txtIDEdit.setEditable(false);
				} else {
					JOptionPane.showMessageDialog(getFrmProductManager(), "Sản phẩm bạn cần chỉnh sửa không tồn tại", "Thông báo", JOptionPane.OK_OPTION);
					txtNameEdit.setEditable(false);
					txtPriceEdit.setEditable(false);
					btnEdit.setEnabled(false);
				}
			}
		});
		btnCheck.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCheck.setBounds(10, 150, 108, 29);
		btnCheck.setFocusPainted(false);
		EditPanel.add(btnCheck);
		
		txtIDEdit = new JTextField();
		txtIDEdit.setColumns(10);
		txtIDEdit.setBounds(109, 26, 136, 28);
		EditPanel.add(txtIDEdit);
		
		lblIDEdit = new JLabel("Mã sản phẩm");
		lblIDEdit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblIDEdit.setBounds(10, 26, 99, 28);
		EditPanel.add(lblIDEdit);
		
		lblNameEdit = new JLabel("Tên sản phẩm");
		lblNameEdit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNameEdit.setBounds(10, 64, 99, 28);
		EditPanel.add(lblNameEdit);
		
		txtNameEdit = new JTextField();
		txtNameEdit.setEditable(false);
		txtNameEdit.setColumns(10);
		txtNameEdit.setBounds(109, 64, 136, 28);
		EditPanel.add(txtNameEdit);
		
		lblPriceEdit = new JLabel("Giá");
		lblPriceEdit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPriceEdit.setBounds(10, 102, 99, 28);
		EditPanel.add(lblPriceEdit);
		
		txtPriceEdit = new JTextField();
		txtPriceEdit.setEditable(false);
		txtPriceEdit.setColumns(10);
		txtPriceEdit.setBounds(109, 102, 136, 28);
		EditPanel.add(txtPriceEdit);
		
		
		
	}
	private boolean checkID(String IDExec) {
		boolean IDCheck = false;
		for (SanPham product: productList) {
			if (product.getMaSP().toLowerCase().equals(IDExec.toLowerCase())) {
				IDCheck = true;
				break;
			}
		}
		return IDCheck;
	}
	private SanPham checkIDReturnProduct(String IDExec) {
		SanPham pCheck = new SanPham();
		for (SanPham product: productList) {
			if (product.getMaSP().toLowerCase().equals(IDExec.toLowerCase())) {
				pCheck = product;
				break;
			}
		}
		return pCheck;
	}

	public JFrame getFrmProductManager() {
		return frmProductManager;
	}
}
