package viewXacNhan;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.inforRapPhim;
import viewKhachhang.xemChoNgoi;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hoantatThongTinVe extends JFrame {

	private JPanel contentPane;
	private inforRapPhim infor = new inforRapPhim();

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
				xuatThongTinVe hd = new xuatThongTinVe();
				setVisible(false);
				hd.setVisible(true);
						
				
			}
		});
		next.setBackground(new Color(120, 67, 21));
		next.setForeground(new Color(238, 232,221));
		next.setBounds(115, 100, 50, 30);
		contentPane.add(next);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
		
	}
	
	
}
