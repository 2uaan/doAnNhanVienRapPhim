package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dao.gheCDAO;
import dao.gheNSDAO;
import dao.nhanVienDAO;
import dao.xuatChieuDAO;
import database.jdbc_new;
import model.inforRapPhim;
import model.nhanVien;
import viewXacNhan.xacnhanNV;

public class loginNVview extends JFrame {

	private JPanel contentPane;
	private JLabel background, _2uanLabel, cinemaLabel, manvLabel, marapLabel;
	private JTextField manvTextField, marapTextField;
	private nhanVienDAO nvdao = new nhanVienDAO();
	private nhanVien nVien[] = nvdao.duyetNV();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginNVview frame = new loginNVview();
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
	public loginNVview() {
//		duyet_csdl_nv();
		setTitle("2uan Cinema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\2c_toolkit.png"));
		setResizable(false);
		setSize(1000, 675);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton loginButton = new JButton("→");
		
		xacnhanNV tc = new xacnhanNV();	
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ktrMaNv = manvTextField.getText();
				String ktrMaRap = marapTextField.getText();
				int mnv=0, mr=0;
				
				Connection c = null;
				
				for (int i=0; i<nVien.length; i++) {
					if (ktrMaNv.equals(nVien[i].getMaNV() + "")) {
						mnv = 1;
						xuatChieuDAO xc = new xuatChieuDAO();
						nvdao.updateNV(nVien[i]);
					}
				}
				if (ktrMaRap.equals(new inforRapPhim().marap))
					mr = 1;
				
				if (mnv == 1 && mr == 1) {
					setVisible(false);
					tc.setVisible(true);
				}else{
					if (ktrMaRap.equals("") && ktrMaNv.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin !!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Bạn đã nhập sai thông tin !!!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
						manvTextField.setText("");
						marapTextField.setText("");
					}
				}
				
			}
		});
		
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setBackground(new Color(120, 67, 21));
		loginButton.setForeground(new Color(240, 255, 255));
		loginButton.setBounds(386, 235, 52, 26);
		contentPane.add(loginButton);
		
		
		manvLabel = new JLabel("Mã Nhân Viên:");
		manvLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		manvLabel.setForeground(new Color(59, 31, 1));
		manvLabel.setBounds(39, 226, 116, 35);
		contentPane.add(manvLabel);
		
		marapLabel = new JLabel("Mã Rạp:");
		marapLabel.setForeground(new Color(59, 31, 1));
		marapLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		marapLabel.setBounds(39, 176, 116, 35);
		contentPane.add(marapLabel);
		
		marapTextField = new JTextField();
		marapTextField.setToolTipText("Nhập mã rạp ở đây!!");
		marapTextField.setBounds(165, 183, 204, 25);
		contentPane.add(marapTextField);
		marapTextField.setColumns(10);
		
		manvTextField = new JTextField();
		manvTextField.setToolTipText("Nhập mã nhân viên ở đây!!");
		manvTextField.setColumns(10);
		manvTextField.setBounds(165, 236, 204, 25);
		contentPane.add(manvTextField);
		
		_2uanLabel = new JLabel("2uan");
		_2uanLabel.setForeground(new Color(255, 140, 0));
		_2uanLabel.setFont(new Font("STLiti", Font.BOLD, 99));
		_2uanLabel.setBounds(52, 27, 213, 76);
		contentPane.add(_2uanLabel);
		
		cinemaLabel = new JLabel("Cinema");
		cinemaLabel.setForeground(new Color(30, 144, 255));
		cinemaLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		cinemaLabel.setBounds(194, 52, 159, 74);
		contentPane.add(cinemaLabel);
		
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\back.png"));
		background.setBounds(0, 0, 1000, 675);
		contentPane.add(background);
	}
}
