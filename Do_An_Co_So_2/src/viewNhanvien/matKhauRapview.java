package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.nhanVienDAO;
import dao.xuatChieuDAO;
import database.jdbc_new;
import model.inforRapPhim;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class matKhauRapview extends JFrame {

	private JPanel contentPane;
	private JLabel background, chaoLabel, passRapLabel, tennvLabel;
	private JPasswordField rapPF;
	private JButton next;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					matKhauRapview frame = new matKhauRapview();
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
	public matKhauRapview() {
		setTitle("2uan Cinema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\2c_toolkit.png"));
		setResizable(false);
		setSize(450, 270);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String tennv=new nhanVienDAO().nvTrongCa();
		
		chaoLabel = new JLabel("Rạp 2uanCinema" );
		chaoLabel.setBackground(new Color(240, 240, 240));
		chaoLabel.setForeground(new Color(59, 31, 1));
		chaoLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		chaoLabel.setBounds(21, 26, 549, 38);
		contentPane.add(chaoLabel);
		
		tennvLabel = new JLabel("Xin Chào "+tennv+" <3" );
		tennvLabel.setBackground(new Color(240, 240, 240));
		tennvLabel.setForeground(new Color(59, 31, 1));
		tennvLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		tennvLabel.setBounds(21, 56, 549, 38);
		contentPane.add(tennvLabel);
		
		passRapLabel = new JLabel("Mật khẩu rạp:");
		passRapLabel.setForeground(new Color(59, 31, 1));
		passRapLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passRapLabel.setBounds(21, 102, 111, 38);
		contentPane.add(passRapLabel);
		
		rapPF = new JPasswordField();
		rapPF.setBounds(150, 110, 235, 27);
		contentPane.add(rapPF);
		
		TrangChinhView tcv = new TrangChinhView();
		
		next = new JButton("→");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] tam = rapPF.getPassword();
				String ktrPassRap = new String(tam);
				
				if (ktrPassRap.equals(new inforRapPhim().matkhauRap)) {
					setVisible(false);
					tcv.setVisible(true);
				}else if (ktrPassRap.equals("")){
					JOptionPane.showMessageDialog(null, "Mật Khẩu Rạp Chưa Được Nhập!!!", "ERORR!!!", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Mật Khẩu Rạp Sai!!!", "WRONG!!!", JOptionPane.ERROR_MESSAGE);
					rapPF.setText("");
				}
				
			}
		});
		next.setBackground(new Color(120, 67, 21));
		next.setBounds(323, 170, 75, 30);
		next.setFont(new Font("Tahoma", Font.BOLD, 14));
		next.setForeground(Color.white);
		contentPane.add(next);
		
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\xacnhanNVview.png"));
		background.setBounds(0, -15, 450, 300);
		contentPane.add(background);
	}

}
