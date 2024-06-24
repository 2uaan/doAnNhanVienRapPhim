package viewXacNhan;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewNhanvien.matKhauRapview;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class xacnhanNV extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xacnhanNV frame = new xacnhanNV();
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
	public xacnhanNV() {
		setTitle("Loading . . . ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(238, 232,221));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bacham = new JLabel("Mã Rạp Hợp Lệ !!!");
		bacham.setFont(new Font("Leelawadee UI", Font.BOLD, 23));
		bacham.setForeground(new Color(120, 67, 21));
		bacham.setBounds(45, 15, 286, 75);
		contentPane.add(bacham);
		
		JButton next = new JButton("→");
		next.setFont(new Font("Tahoma", Font.BOLD, 14));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matKhauRapview cg = new matKhauRapview();
				setVisible(false);
				cg.setVisible(true);
			}
		});
		next.setBackground(new Color(120, 67, 21));
		next.setForeground(new Color(238, 232,221));
		next.setBounds(115, 100, 50, 30);
		contentPane.add(next);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\xacnhanNVview.png"));
		lblNewLabel.setBounds(0, -29, 309, 192);
		contentPane.add(lblNewLabel);
		
	}
}
