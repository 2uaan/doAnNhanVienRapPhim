package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.inforRapPhim;

public class chonThucAnView extends JFrame{
	
	private JPanel contentPane, doAn, nuocUong, soluong, tong;
	private JScrollPane doan, nuocuong;
	private inforRapPhim infor = new inforRapPhim();
	private JTabbedPane danhMuc;
	private JButton hoanthanh;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chonThucAnView frame = new chonThucAnView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public chonThucAnView() {
		setTitle("Xuất Chiếu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\2c_toolkit.png"));
		setResizable(false);
		setSize(infor.ngangKhung, infor.docKhung);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		doAn = new JPanel();
		nuocUong = new JPanel();
		doan = new JScrollPane(doAn);
		nuocuong = new JScrollPane(nuocUong);
		
		
		soluong = new JPanel();
		soluong.setBounds(460, 40, 400, 300);
		soluong.setBackground(Color.black);
		contentPane.add(soluong);
		
		tong = new JPanel();
		tong.setBounds(460, 375, 400, 70);
		tong.setBackground(Color.black);
		contentPane.add(tong);
		
		hoanthanh = new JButton("Xong");
		hoanthanh.setBounds(625,480,70,40);
		
		contentPane.add(hoanthanh);
		
		danhMuc = new JTabbedPane();
		danhMuc.setBounds(25,20, 400, 500);
		danhMuc.add("Đồ Ăn",doan);
		danhMuc.add("Nước Uống",nuocuong);
		
		contentPane.add(danhMuc);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
	}

}
