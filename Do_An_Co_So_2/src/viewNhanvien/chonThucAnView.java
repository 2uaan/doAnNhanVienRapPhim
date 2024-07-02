package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dao.thucAnDAO;
import model.*;

public class chonThucAnView extends JFrame{
	
	private JPanel contentPane, doAn, nuocUong, soluong, tong;
	private JScrollPane doan, nuocuong;
	private inforRapPhim infor = new inforRapPhim();
	private JTabbedPane danhMuc;
	private JButton hoanthanh;
	private thucAnDAO tadao = new thucAnDAO();
	private thucAn[] Doan, Nuoc;
	private font font = new font();
	private color colo = new color();
	
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
		Doan = tadao.duyet_do_an();
		Nuoc = tadao.duyet_nuoc_uong();
		
		decor();
		doAn = new JPanel();
		doAn.setLayout(new GridLayout(10,1));
//		doAn.setBackground(colo.nauVang);
		
		nuocUong = new JPanel();
		nuocUong.setLayout(new GridLayout(10,1));
//		nuocUong.setBackground(colo.nauVang);
		
		themThucAn(Doan, Nuoc);
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

	
	private void themThucAn(thucAn[] food, thucAn[] drink) {
		ImageIcon nut = new ImageIcon();
		
		for (int i =0; i<food.length; i++) {
			
			switch (food[i].getTenMon()) {
				
			case "Bắp":{
				nut = new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\popcorn.png");
				break;
			}
			case "Snack":{
				nut = new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\snack.png");
				break;
			}
				
			}
			
			JButton temp = new JButton(food[i].getTenMon());
			temp.setIcon(nut);
			temp.setFont(font.setUTMWindsorBT(30));
			temp.setBackground(colo.mau_thuc_an(food[i].getTenMon()));
			doAn.add(temp);
			doAn.setVisible(false);
			doAn.setVisible(true);
		}
		
		for (int i =0; i<drink.length; i++) {
			switch (drink[i].getTenMon()) {
			
			case "Coca-cola":{
				nut = new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\coca.png");
				break;
			}
			case "7up":{
				nut = new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\7up.png");
				break;
			}
			case "Nước lọc":{
				nut = new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\water.png");
				break;
			}
				
			}
			
			JButton temp = new JButton(drink[i].getTenMon());
			temp.setIcon(nut);
			temp.setFont(font.setUTMWindsorBT(30));
			temp.setBackground(colo.mau_thuc_an(drink[i].getTenMon()));
			temp.setForeground(Color.white);
			nuocUong.add(temp);
			nuocUong.setVisible(false);
			nuocUong.setVisible(true);
		}
		
	}
	
	public void decor() {
		
		JLabel mov, hap;
		
		mov = new JLabel(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\mov.png"));
		hap = new JLabel(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\happy.png"));
		mov.setBounds(500, 320, 60, 60);
		hap.setBounds(750, 320, 60, 60);
		
		
		contentPane.add(hap);
		contentPane.add(mov);
	}
	
}
