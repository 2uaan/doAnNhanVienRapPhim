package viewXacNhan;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.gheCDAO;
import dao.gheNSDAO;
import dao.gheVDAO;
import model.*;
import viewNhanvien.TrangChinhView;

public class xuatThongTinVe extends JFrame{
	
	private JPanel contentPane;
	private inforRapPhim infor = new inforRapPhim();
	private color colo = new color();
	private gheCDAO cdao = new gheCDAO();
	private gheNSDAO nsdao = new gheNSDAO();
	private gheVDAO vdao = new gheVDAO();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xuatThongTinVe frame = new xuatThongTinVe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public xuatThongTinVe() {
		setTitle("Thông Tin Vé");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\2c_toolkit.png"));
		setResizable(false);
		setSize(infor.ngangKhung, infor.docKhung);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TrangChinhView trang = new TrangChinhView();
		
		JButton chia = new JButton();
		chia.setBackground(colo.nauVang);
		chia.setBounds(this.getWidth()/2 -5, 50, 10, 400);
		chia.setEnabled(false);
		chia.setBorder(BorderFactory.createLoweredBevelBorder());
		contentPane.add(chia);
		
		
		JButton done = new JButton("Xong");
		done.setBounds(this.getWidth()/2-40, 500, 80, 30);
		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nsdao.update_trang_thai_ghe();
				vdao.update_trang_thai_ghe();
				cdao.update_trang_thai_ghe();
				
				setVisible(false);
				trang.setVisible(true);
			}
		});
		contentPane.add(done);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
	}

	
}
