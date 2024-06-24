package viewXacNhan;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewKhachhang.xemChoNgoi;
import viewNhanvien.chonGhe;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wait extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wait frame = new wait();
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
	public wait() {
		setTitle("Loading . . . ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(238, 232,221));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bacham = new JLabel("Hoàn tất chọn xuất chiếu");
		bacham.setFont(new Font("Leelawadee UI", Font.BOLD, 23));
		bacham.setForeground(new Color(120, 67, 21));
		bacham.setBounds(5, 27, 286, 75);
		contentPane.add(bacham);
		
		JButton next = new JButton("→");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xemChoNgoi xcn = new xemChoNgoi();
				chonGhe cg = new chonGhe();
				setVisible(false);
				
				cg.setVisible(true);
				xcn.setVisible(true);
				
			}
		});
		next.setBackground(new Color(120, 67, 21));
		next.setForeground(new Color(238, 232,221));
		next.setBounds(115, 100, 50, 30);
		contentPane.add(next);
		
	}
	
	
}
