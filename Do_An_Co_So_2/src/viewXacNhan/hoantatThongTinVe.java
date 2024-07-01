package viewXacNhan;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewKhachhang.xemChoNgoi;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hoantatThongTinVe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					hoantatThongTinVe frame = new hoantatThongTinVe();
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
	public hoantatThongTinVe() {
		setTitle("Success ^.^");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(238, 232,221));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bacham = new JLabel("Hoàn Tất Đặt Vé !!!");
		bacham.setFont(new Font("Leelawadee UI", Font.BOLD, 23));
		bacham.setForeground(new Color(120, 67, 21));
		bacham.setBounds(41, 13, 286, 75);
		contentPane.add(bacham);
		
		JButton next = new JButton("→");
		next.setFont(new Font("Tahoma", Font.PLAIN, 15));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HoaDon hd = new HoaDon();
				setVisible(false);
				hd.setVisible(true);
						
				
			}
		});
		next.setBackground(new Color(120, 67, 21));
		next.setForeground(new Color(238, 232,221));
		next.setBounds(115, 100, 50, 30);
		contentPane.add(next);
		
	}
	
	
}
