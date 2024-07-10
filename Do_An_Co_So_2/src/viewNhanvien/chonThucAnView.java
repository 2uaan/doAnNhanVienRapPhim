package viewNhanvien;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dao.thucAnDAO;
import model.*;

public class chonThucAnView extends JFrame{
	
	private JPanel contentPane, doAn, nuocUong, soluong, tong;
	private JScrollPane doanScroll, nuocuongScroll, sluongScrooll;
	private inforRapPhim infor = new inforRapPhim();
	private JTabbedPane danhMuc;
	private JButton hoanthanh;
	private thucAnDAO tadao = new thucAnDAO();
	private thucAn[] Doan = null, Nuoc = null;
	private font font = new font();
	private color colo = new color();
	private String[][] luuSoLuong;
	private boolean[] tongSoLuong;
	private int slHeight = 400;
	private JLabel hiensl[];
	
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
		
		
		tongSoLuong = new boolean[Doan.length+Nuoc.length];
		for (int i = 0; i<tongSoLuong.length; i++) {
			tongSoLuong[i] = false;
		}
		
		luuSoLuong = new String[tongSoLuong.length][2];
		hiensl = new JLabel[tongSoLuong.length];
		
		
		decor();
		doAn = new JPanel();
		doAn.setLayout(new GridLayout(10,1));
		
		nuocUong = new JPanel();
		nuocUong.setLayout(new GridLayout(10,1));
		
		themThucAn(Doan, Nuoc);
		doanScroll = new JScrollPane(doAn);
		nuocuongScroll = new JScrollPane(nuocUong);
		
		soluong = new JPanel();
//		soluong.setBounds(460, 40, 400, 300);
//		soluong.setBackground(Color.black);
		soluong.setLayout(new GridLayout(tongSoLuong.length, 1));
//		contentPane.add(soluong);
		
		sluongScrooll = new JScrollPane(soluong);
		sluongScrooll.setBounds(460, 40, 400, slHeight);
		contentPane.add(sluongScrooll);
		
		
		
		hoanthanh = new JButton("Xong");
		hoanthanh.setBounds(625,480,70,40);
		hoanthanh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hoanthanh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i< luuSoLuong.length; i++) {
					luuSoLuong[i][1] = hiensl[i].getText();
				}
				
				
				tadao.luu_thuc_an_order(luuSoLuong);
			}
		});
		contentPane.add(hoanthanh);
		
		danhMuc = new JTabbedPane();
		danhMuc.setBounds(25,20, 400, 500);
		danhMuc.add("Đồ Ăn",doanScroll);
		danhMuc.add("Nước Uống",nuocuongScroll);
		
		contentPane.add(danhMuc);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
	}

	
	public String doi_sang_gia_tien(int giaThanh) {
		
		String temp = "";
		
		while(giaThanh > 1000) {
			giaThanh /= 1000;
			temp+= ".000";
		}
		
		temp = giaThanh + temp;
		
		temp += "đ";
		
		return temp;
	}
	
	private void themThucAn(thucAn[] food, thucAn[] drink) {
		ImageIcon nut = new ImageIcon();
		
		for (int i =0; i<food.length; i++) {
			luuSoLuong[i][0] = food[i].getMaTA();
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
			int dem = i;
			
			JPanel bao = new JPanel(), tangGiam, tg;
			JLabel tenMon, giaThanh;
			bao.setLayout(null);
			bao.setBackground(colo.mau_thuc_an(food[i].getTenMon()));
			bao.setBorder(BorderFactory.createRaisedBevelBorder());
			
			int tangGiamHeight = 30;
			
			tangGiam = new JPanel();
			tangGiam.setLayout(new GridLayout(1,3));
			tangGiam.setBounds(250, (400/tongSoLuong.length - tangGiamHeight)/2, 90, tangGiamHeight);
			
			
			
			hiensl[i] = new JLabel("0");
			hiensl[i].setFont(font.setTilt_Neon_Size(20));
			hiensl[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			JButton remove, tang, giam;
			
			tang = new JButton("+");
			giam = new JButton("-");
			tang.setFont(font.setTilt_Neon_Size(18));
			giam.setFont(font.setTilt_Neon_Size(25));
			tang.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int t =  Integer.parseInt(hiensl[dem].getText()) + 1;
					hiensl[dem].setText(t+"");
				}
			});
			giam.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (Integer.parseInt(hiensl[dem].getText()) > 1) {
						int t =  Integer.parseInt(hiensl[dem].getText()) -1;
						hiensl[dem].setText(t+"");
					}
				}
			});
			
			
			remove = new JButton();
			remove.setFont(font.setTilt_Neon_Size(15));
			remove.setBounds(373,3,20,20);
			remove.setBackground(Color.red);
			remove.setBorder(BorderFactory.createRaisedBevelBorder());
			remove.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					bao.setVisible(false);
					soluong.remove(bao);
					tongSoLuong[dem] = false;
					hiensl[dem].setText("1");
					
				}
			});
			
			bao.add(remove);
			tg = new JPanel();
			tg.setLayout(new GridLayout(2,1));
			tg.add(tang);
			tg.add(giam);
			
			tangGiam.add(hiensl[i]);
			tangGiam.add(tg);
			
			tenMon = new JLabel(food[i].getTenMon());
			giaThanh = new JLabel(doi_sang_gia_tien(food[i].getGiaThanh()));
			tenMon.setBounds(10,(slHeight/tongSoLuong.length - tangGiamHeight)/2 ,100,30);
			tenMon.setFont(font.setTilt_Neon_Size(tenMon.getWidth()/5));
			giaThanh.setBounds(120, (slHeight/tongSoLuong.length - tangGiamHeight)/2, 100, 30);
			bao.add(tenMon);
			bao.add(giaThanh);
			bao.add(tangGiam);
			
			
			JButton temp = new JButton(food[i].getTenMon()+"("+doi_sang_gia_tien(food[i].getGiaThanh())+")");
			temp.setIcon(nut);
			temp.setFont(font.setUTMWindsorBT(30));
			temp.setBackground(colo.mau_thuc_an(food[i].getTenMon()));
			temp.setBorder(BorderFactory.createRaisedBevelBorder());
			temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			temp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (tongSoLuong[dem]) {
						int t =  Integer.parseInt(hiensl[dem].getText()) + 1;
						hiensl[dem].setText(t+"");
					}else {
						hiensl[dem].setText("1");
						bao.setVisible(true);
						soluong.add(bao);
						soluong.setVisible(false);
						soluong.setVisible(true);
						tongSoLuong[dem] = !tongSoLuong[dem];
					}
					
				}
			});
			doAn.add(temp);
			doAn.setVisible(false);
			doAn.setVisible(true);
		}
		
		for (int i =0; i<drink.length; i++) {
			int flenght= food.length;
			luuSoLuong[flenght + i][0] = drink[i].getMaTA();
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
			
			int dem = i;
			int tangGiamHeight = 30;
			JPanel bao = new JPanel(), tangGiam, tg;
			JLabel tenMon, giaThanh;
			bao.setLayout(null);
			bao.setSize(0, 30);
			bao.setBackground(colo.mau_thuc_an(drink[i].getTenMon()));
			bao.setBorder(BorderFactory.createRaisedBevelBorder());
			
			tangGiam = new JPanel();
			tangGiam.setLayout(new GridLayout(1,3));
			tangGiam.setBounds(250, (slHeight/tongSoLuong.length - tangGiamHeight)/2, 90, tangGiamHeight);
			
			hiensl[flenght + i] = new JLabel("0");
			hiensl[flenght + i].setFont(font.setTilt_Neon_Size(20));
			hiensl[flenght + i].setHorizontalAlignment(SwingConstants.CENTER);
			
			JButton remove, tang, giam;
			
			tang = new JButton("+");
			giam = new JButton("-");
			tang.setFont(font.setTilt_Neon_Size(18));
			giam.setFont(font.setTilt_Neon_Size(25));
			tang.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int t =  Integer.parseInt(hiensl[flenght + dem].getText()) + 1;
					hiensl[flenght + dem].setText(t+"");
				}
			});
			giam.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (Integer.parseInt(hiensl[flenght + dem].getText()) > 1) {
						int t =  Integer.parseInt(hiensl[flenght + dem].getText()) -1;
						hiensl[flenght + dem].setText(t+"");
					}
				}
			});
			
			
			remove = new JButton();
			remove.setFont(font.setTilt_Neon_Size(15));
			remove.setBounds(373,3,20,20);
			remove.setBackground(Color.red);
			remove.setBorder(BorderFactory.createRaisedBevelBorder());
			remove.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					bao.setVisible(false);
					soluong.remove(bao);
					tongSoLuong[flenght + dem] = false;
					hiensl[flenght + dem].setText("1");
					
				}
			});
			
			bao.add(remove);
						
			tg = new JPanel();
			tg.setLayout(new GridLayout(2,1));
			tg.add(tang);
			tg.add(giam);
			
			tangGiam.add(hiensl[flenght + i]);
			tangGiam.add(tg);
			
			tenMon = new JLabel(drink[i].getTenMon());
			giaThanh = new JLabel(doi_sang_gia_tien(drink[i].getGiaThanh()));
			tenMon.setBounds(10,(400/tongSoLuong.length - tangGiamHeight)/2 ,100,30);
			tenMon.setFont(font.setTilt_Neon_Size(tenMon.getWidth()/5));
			giaThanh.setBounds(120, (400/tongSoLuong.length - tangGiamHeight)/2, 100, 30);
			bao.add(tenMon);
			bao.add(giaThanh);
			bao.add(tangGiam);
			
			
			JButton temp = new JButton(drink[i].getTenMon()+"("+doi_sang_gia_tien(drink[i].getGiaThanh())+")");
			temp.setIcon(nut);
			temp.setFont(font.setUTMWindsorBT(30));
			temp.setBackground(colo.mau_thuc_an(drink[i].getTenMon()));
			temp.setBorder(BorderFactory.createRaisedBevelBorder());
			temp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			temp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (tongSoLuong[flenght + dem]) {
						int t =  Integer.parseInt(hiensl[flenght + dem].getText()) + 1;
						hiensl[flenght + dem].setText(t+"");
					}else {
						hiensl[flenght + dem].setText("1");
						bao.setVisible(true);
						soluong.add(bao);
						soluong.setVisible(false);
						soluong.setVisible(true);
						tongSoLuong[flenght + dem] = !tongSoLuong[flenght + dem];
					}
					
				}
			});
			nuocUong.add(temp);
			nuocUong.setVisible(false);
			nuocUong.setVisible(true);
		}
		
	}
	
	public void decor() {
		
		JLabel mov, hap;
		
		mov = new JLabel(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\mov.png"));
		hap = new JLabel(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\happy.png"));
		mov.setBounds(500, 450, 60, 60);
		hap.setBounds(750, 450, 60, 60);
		
		
		contentPane.add(hap);
		contentPane.add(mov);
	}
	
}
