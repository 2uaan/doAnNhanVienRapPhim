package viewXacNhan;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewKhachhang.menuDoAn;
import viewKhachhang.menuNuocUong;
import viewNhanvien.chonThucAnView;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class xacnhanGhe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xacnhanGhe frame = new xacnhanGhe();
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
	public xacnhanGhe() {
		setTitle("Loading . . . ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(238, 232,221));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton no = new JButton("×");
		no.setForeground(new Color(238, 232, 221));
		no.setFont(new Font("Tahoma", Font.BOLD, 14));
		no.setBackground(new Color(120, 67, 21));
		no.setBounds(193, 100, 50, 30);
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hoantatThongTinVe ht = new hoantatThongTinVe();
				setVisible(false);
				ht.setVisible(true);
			}
		});
		contentPane.add(no);
		
		JLabel lblBnCMun = new JLabel("Bạn có muốn chọn thức ăn ???");
		lblBnCMun.setForeground(new Color(120, 67, 21));
		lblBnCMun.setFont(new Font("Leelawadee UI", Font.BOLD, 18));
		lblBnCMun.setBounds(12, 52, 260, 36);
		contentPane.add(lblBnCMun);
		
		JLabel bacham = new JLabel("Hoàn Tất Chọn Ghế !!!");
		bacham.setFont(new Font("Leelawadee UI", Font.BOLD, 23));
		bacham.setForeground(new Color(120, 67, 21));
		bacham.setBounds(12, 23, 249, 36);
		contentPane.add(bacham);
		
		JButton next = new JButton("→");
		next.setFont(new Font("Tahoma", Font.BOLD, 14));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonThucAnView cta = new chonThucAnView();
				setVisible(false);
				cta.setVisible(true);
			}
		});
		next.setBackground(new Color(120, 67, 21));
		next.setForeground(new Color(238, 232,221));
		next.setBounds(115, 100, 50, 30);
		contentPane.add(next);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\Do_An_Co_So_2\\image\\xacnhanNVview.png"));
		background.setBounds(0, -29, 309, 192);
		contentPane.add(background);
		
	}
}
