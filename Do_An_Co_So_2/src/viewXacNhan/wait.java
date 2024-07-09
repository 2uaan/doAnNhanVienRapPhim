package viewXacNhan;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewKhachhang.xemChoNgoi;
import viewNhanvien.chonGheNew;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.*;

public class wait extends JFrame {

	private JPanel contentPane;
	private font font = new font();
	private color colo = new color();
	private inforRapPhim infor = new inforRapPhim();

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
		setTitle("✓✓✓");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(238, 232,221));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bacham = new JLabel("Hoàn tất chọn xuất chiếu");
		bacham.setFont(font.leelawadee);
		bacham.setForeground(new Color(120, 67, 21));
		bacham.setBounds(20, 27, 286, 75);
		contentPane.add(bacham);
		
		JButton next = new JButton("→");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonGheNew cg = new chonGheNew();
				setVisible(false);
				
				cg.setVisible(true);
				
			}
		});
		next.setBackground(colo.nauXam);
		next.setForeground(colo.nauVang);
		next.setFont(font.setTilt_Neon_Size(20));
		next.setBounds(130, 100, 50, 30);
		contentPane.add(next);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
		
	}
	
	
}
