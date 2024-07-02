package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dao.gheCDAO;
import dao.gheNSDAO;
import dao.gheVDAO;
import dao.xuatChieuDAO;
import model.*;
import viewXacNhan.xacnhanGhe;

public class chonGheNew extends JFrame{
	
	private String[][] giaBan = {{"NS","75.000đ"},{"V","90.000đ"},{"C","200.000đ"}};
	private String[] kyHieu = {"Gần Màn Hình", "Vip", "Couple", "Đã Bán"};
	private color colo = new color();
	private font font;
	private JPanel contentPane, screen, ghens, ghev, ghec;
	private inforRapPhim infor = new inforRapPhim();
	private xuatChieuDAO xcdao = new xuatChieuDAO();
	private gheNSDAO nsdao = new gheNSDAO();
	private gheVDAO vdao = new gheVDAO();
	private gheCDAO cdao = new gheCDAO();
	private int ma[] = xcdao.xuatXuatChieu();
	private gheNS[] ns = nsdao.duyetGhe(ma[0]);
	private gheV[] v = vdao.duyetGhe(ma[0]);
	private gheC[] c = cdao.duyetGhe(ma[0]);
	private JLabel Screen;
	public JButton quaylai, next;
	boolean colorIsNS[] = new boolean[ns.length];
	boolean colorIsV[] = new boolean[v.length];
	boolean colorIsC[] = new boolean[c.length];
	private int toaDoNgang, toaDoDoc;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chonGheNew frame = new chonGheNew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public chonGheNew() {
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
		
		chonXuatChieuVie chonxc = new chonXuatChieuVie();
		
		font = new font();
		quaylai = new JButton("←");
		quaylai.setBounds(35, 45, 70, 35);
		quaylai.setBackground(colo.screenColor);
		quaylai.setForeground(Color.white);
		quaylai.setFont(font.setTilt_Neon_Size(30));
		
		
		quaylai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				chonxc.setVisible(true);
				
			}
		});
		contentPane.add(quaylai);
		
		screen = new JPanel();
		screen.setBounds(150, 35, 300, 100);
		screen.setBackground(colo.screenColor);
		
		Screen = new JLabel("Screen");
		Screen.setFont(font.tilt_neon);
		Screen.setForeground(Color.white);
		screen.add(Screen);
		
		contentPane.add(screen);
		toaDoNgang = 100;
		toaDoDoc = 145;
		
		tao_ghe_ns();
		
		toaDoDoc+=25;
		
		tao_ghe_vip();
		
		toaDoDoc+=25;
		
		tao_ghe_couple();
		
		xacnhanGhe xn = new xacnhanGhe();
		
		next = new JButton("→");
		next.setBackground(colo.nauXam);
		next.setForeground(colo.nauVang);
		next.setFont(font.setTilt_Neon_Size(30));
		next.setBounds(800, 520, 70, 35);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nsdao.duyet_gheNS_dang_chon(ns, ma[0], colorIsNS);
				vdao.duyet_gheV_dang_chon(v, ma[0], colorIsV);
				cdao.duyet_gheC_dang_chon(c, ma[0], colorIsC);
				nsdao.luu_so_ghe_da_chon(checkFalse(colorIsNS));
				vdao.luu_so_ghe_da_chon(checkFalse(colorIsV));
				cdao.luu_so_ghe_da_chon(checkFalse(colorIsC));
				
				setVisible(false);
				xn.setVisible(true);
			}
		});
		contentPane.add(next);
		
		anh_poster_phim();
		
		tao_gia_ghe();
		tao_ky_hieu();
		
		decor_poster();
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
	}
	
	
	private void tao_ghe_ns() {
		
		for (int i = 0; i < ns.length/8; i++) {
			toaDoNgang = 100;
			for (int j = 0; j< ns.length/2; j++) {
				
				int vitri = (i==0 && j==0) ? 0 : 8*(i+1)-(8-j);
				boolean state = (ns[vitri].getTrangThai() == 0) ? true : false;
				colorIsNS[vitri] = true;
				
				JButton temp = new JButton(ns[vitri].getTenGhe());
				temp.setBackground((state) ? colo.ghens : Color.DARK_GRAY);
				temp.setBounds(toaDoNgang, toaDoDoc, 50, 50);
				temp.setEnabled(state);
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (colorIsNS[vitri]) {
							temp.setBackground(Color.red);
							ns[vitri].setTrangThai(1);
						}else {
							temp.setBackground(colo.ghens);
							ns[vitri].setTrangThai(0);
						}
						colorIsNS[vitri] = !colorIsNS[vitri];
					}
				});
				contentPane.add(temp);
				contentPane.setVisible(false);
				contentPane.setVisible(true);
				
				toaDoNgang+=50;
			}
			toaDoDoc += 50; 
		}
	}
		
	private void tao_ghe_vip() {
		
		for (int i = 0; i < v.length/8; i++) {
			toaDoNgang = 100;
			for (int j = 0; j< v.length/2; j++) {
				
				int vitri = (i==0 && j==0) ? 0 : 8*(i+1)-(8-j);
				boolean state = (v[vitri].getTrangThai() == 0) ? true : false;
				colorIsV[vitri] = true;
				
				JButton temp = new JButton(v[vitri].getTenGhe());
				temp.setEnabled(state);
				temp.setBackground((state) ? colo.ghev : Color.DARK_GRAY);
				temp.setBounds(toaDoNgang, toaDoDoc, 50, 50);
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (colorIsV[vitri]) {
							temp.setBackground(Color.red);
							v[vitri].setTrangThai(1);
						}else {
							temp.setBackground(colo.ghev);
							v[vitri].setTrangThai(0);
						}
						colorIsV[vitri] = !colorIsV[vitri];
					}
				});
				contentPane.add(temp);
				contentPane.setVisible(false);
				contentPane.setVisible(true);
				
				toaDoNgang+=50;
			}
			toaDoDoc += 50; 
		}
	}
	private void tao_ghe_couple() {
		
		for (int i = 0; i < c.length/4; i++) {
			toaDoNgang = 100;
			for (int j = 0; j< c.length/2; j++) {
				
				int vitri = (i==0 && j==0) ? 0 : 4*(i+1)-(4-j);
				boolean state = (c[vitri].getTrangThai() == 0) ? true : false;
				colorIsC[vitri] = true;
				
				JButton temp = new JButton(c[vitri].getTenGhe());
				temp.setEnabled(state);
				temp.setBackground((state) ? colo.ghec : Color.DARK_GRAY);
				temp.setBounds(toaDoNgang, toaDoDoc, 100, 50);
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (colorIsC[vitri]) {
							temp.setBackground(Color.red);
							c[vitri].setTrangThai(1);
						}else {
							temp.setBackground(colo.ghec);
							c[vitri].setTrangThai(0);
						}
						colorIsC[vitri] = !colorIsC[vitri];
					}
				});
				contentPane.add(temp);
				contentPane.setVisible(false);
				contentPane.setVisible(true);
				
				toaDoNgang+=100;
			}
			toaDoDoc += 50; 
		}
	}
	
	public void tao_ky_hieu() {
		int doc =50;
		for (int i =0; i< kyHieu.length; i++) {
			JPanel bao = new JPanel();
			bao.setLayout(new FlowLayout());
			bao.setBounds(doc, 520, (i==0) ? 150: 100, 30);
			bao.setBackground(colo.trongSuot);;
			doc+= (i==0) ? 150: 110;
			
			JButton kyhieu = new JButton();
			kyhieu.setBackground(colo.mau_ky_hieu(kyHieu[i]));
			kyhieu.setEnabled(false);
			kyhieu.setBorderPainted(false);
			
			JLabel ghiChu = new JLabel(": "+kyHieu[i]);
			ghiChu.setFont(font.setTilt_Neon_Size(12));
			ghiChu.setForeground(colo.screenColor);
			
			bao.add(kyhieu);
			bao.add(ghiChu);
			
			contentPane.add(bao);
			contentPane.setVisible(false);
			contentPane.setVisible(true);
		}
	}
	
	public void tao_gia_ghe() {
		int doc = 170;
		for (int i =0; i< giaBan.length; i++) {
				JPanel bao = new JPanel();
				bao.setLayout(new GridLayout(2,0));
				bao.setBackground(colo.trongSuot);
				bao.setBounds(20, doc, 100, 50);
				
				
				JLabel loaiGhe = new JLabel(giaBan[i][0]);
				JLabel giaGhe = new JLabel(giaBan[i][1]);
				loaiGhe.setForeground(colo.mau_ten_ghe(giaBan[i][0]));
				giaGhe.setBackground(Color.DARK_GRAY);
				loaiGhe.setLocation((i==0) ? 30:70, 0);
				giaGhe.setLocation(0, 30);
				loaiGhe.setFont(font.setUTMfacebookKnT(30));
				giaGhe.setFont(font.setUTMtimes(12));
				
				bao.add(loaiGhe);
				bao.add(giaGhe);
				
				contentPane.add(bao);
				contentPane.setVisible(false);
				contentPane.setVisible(true);
				doc += 125;
			
				
		}
	}
	
	public void decor_poster() {
		int doc = 10;
		for (int i=0; i<2; i++) {
			
			Color[] temp = colo.mau_decor_poster(ma[1]);
			
			JButton khung = new JButton();
			khung.setBackground(temp[i]);
			khung.setEnabled(false);
			khung.setBounds(535, doc, 330, 50);
			khung.setBorderPainted(false);
			
			
			contentPane.add(khung);
			contentPane.setVisible(false);
			contentPane.setVisible(true);
			doc+=450;
		}
	}
	
	public void anh_poster_phim() {
		JLabel poster = new JLabel("");
		poster.setBounds(550, 35, 300, 450);
		
		switch (ma[1])
		{
			case 111:{
				poster.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\Poster_phim\\inside_out_2.png"));
				break;
			}
			case 112:{
				poster.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\Poster_phim\\Deadpool&Wolverine.png"));
				break;
			}
			case 113:{
				poster.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\Poster_phim\\GodzillaxKong.png"));
				break;
			}
		}
	
		contentPane.add(poster);
		
	}
	
	public int checkFalse(boolean[] check) {
		int soCheck = 0;
		
		for (int i =0; i<check.length; i++) {
			if (check[i]) continue;
			else soCheck++;
		}
		
		return soCheck;
	}
}
