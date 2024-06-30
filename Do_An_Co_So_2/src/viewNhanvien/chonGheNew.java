package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.gheCDAO;
import dao.gheNSDAO;
import dao.gheVDAO;
import dao.xuatChieuDAO;
import model.*;

public class chonGheNew extends JFrame{
	
	private color colo = new color();
	private font font;
	private JPanel contentPane, screen, ghens, ghev, ghec;
	private inforRapPhim infor = new inforRapPhim();
	private xuatChieuDAO xcdao = new xuatChieuDAO();
	private int ma[] = xcdao.xuatXuatChieu();
	private gheNS[] ns = new gheNSDAO().duyetGhe(ma[0]);
	private gheV[] v = new gheVDAO().duyetGhe(ma[0]);
	private gheC[] c = new gheCDAO().duyetGhe(ma[0]);
	private JLabel Screen;
	public JButton quaylai;
	
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
		quaylai.setBounds(35, 45, 70, 25);
		quaylai.setBackground(colo.screenColor);
		quaylai.setForeground(Color.white);
		quaylai.setFont(font.setTilt_Neon_Size(20));
		
		
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
		toaDoDoc = 160;
		
		tao_ghe_ns();
		
		toaDoDoc+=25;
		
		tao_ghe_vip();
		
		toaDoDoc+=25;
		
		tao_ghe_couple();
		
		anh_poster_phim();
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
	}
	
	boolean colorIsNS[] = new boolean[ns.length];
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
				
				JButton temp = new JButton(v[vitri].getTenGhe());
				temp.setEnabled(state);
				temp.setBackground((state) ? colo.ghev : Color.DARK_GRAY);
				temp.setBounds(toaDoNgang, toaDoDoc, 50, 50);
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
				
				JButton temp = new JButton(c[vitri].getTenGhe());
				temp.setEnabled(state);
				temp.setBackground((state) ? colo.ghec : Color.DARK_GRAY);
				temp.setBounds(toaDoNgang, toaDoDoc, 100, 50);
				contentPane.add(temp);
				contentPane.setVisible(false);
				contentPane.setVisible(true);
				
				toaDoNgang+=100;
			}
			toaDoDoc += 50; 
		}
	}
	
	public void anh_poster_phim() {
		JLabel poster = new JLabel("");
		poster.setBounds(550, 60, 300, 450);
		
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
}
