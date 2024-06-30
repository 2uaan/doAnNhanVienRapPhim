package viewNhanvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import dao.xuatChieuDAO;
import database.jdbc_new;
import model.xuatChieu;
import viewXacNhan.xacnhanGhe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.FlowLayout;

public class chonGhe extends JFrame {

	private int nsArray[][], vArray[][], cArray[][];
	private JCheckBox[][] ns, v, cup; 
	private JPanel panel_Khung, nutDone;
	private JButton[][] ganManHinh, vip, Couple;
	private JPanel couple, VIP, nearScreen, Screen;
	private JPanel poster_phim;
	private int stt_ns=1,stt_v=1,stt_c=1, hang, cot;
	private int toadoDoc=108, toadoNgang=105;
	private xuatChieu xc;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chonGhe frame = new chonGhe();
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
	public chonGhe() {
		setTitle("2uan Cinema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\2c_toolkit.png"));
		setBounds(100, 100, 800, 450);
		setResizable(false);
		setLocationRelativeTo(null);
//		setLayout(new BorderLayout());
		panel_Khung = new JPanel();
		panel_Khung.setBorder(new EmptyBorder(5, 5, 5, 5));

		nsArray = new int[2][8];
		vArray = new int[2][8];
		cArray = new int[2][4];
		
		
		setContentPane(panel_Khung);
		panel_Khung.setLayout(null);
		
		
		vip = new JButton[2][8];
		Couple = new JButton[2][4];
		
		tao_check_ns();
		tao_check_v();
		tao_check_c();
		
		JButton quaylai = new JButton("←");
		quaylai.setFont(new Font("Arial", Font.BOLD, 50));
		quaylai.setBackground(new Color(238, 232, 221));
		quaylai.setBorderPainted(false);
		quaylai.setBounds(10, 10, 100, 50);
		quaylai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chonXuatChieuView cxc = new chonXuatChieuView();
				setVisible(false);
				cxc.setVisible(true);
				
			}
		});
		panel_Khung.add(quaylai);
		
		JLabel dc2 = new JLabel(". . .");
		dc2.setFont(new Font("STZhongsong", Font.BOLD, 59));
		dc2.setBounds(574, 264, 122, 70);
		panel_Khung.add(dc2);
		
		JLabel dc1 = new JLabel(". . .");
		dc1.setFont(new Font("STZhongsong", Font.BOLD, 59));
		dc1.setBounds(531, 10, 122, 70);
		panel_Khung.add(dc1);
		
		JLabel Cprice = new JLabel("(190K)");
		Cprice.setBounds(28, 358, 45, 13);
		panel_Khung.add(Cprice);
		
		JLabel Vprice = new JLabel("(105K)");
		Vprice.setBounds(28, 250, 45, 13);
		panel_Khung.add(Vprice);
		
		JLabel NSprice = new JLabel("(85K)");
		NSprice.setBounds(33, 142, 45, 13);
		panel_Khung.add(NSprice);
		
		JLabel V = new JLabel("V");
		V.setForeground(new Color(244, 206, 20));
		V.setFont(new Font("Tahoma", Font.BOLD, 28));
		V.setBounds(38, 184, 40, 97);
		panel_Khung.add(V);
		
		JLabel C = new JLabel("C");
		C.setForeground(Color.PINK);
		C.setFont(new Font("Tahoma", Font.BOLD, 28));
		C.setBounds(38, 294, 40, 97);
		panel_Khung.add(C);
		JLabel NS = new JLabel("NS");
		NS.setForeground(Color.LIGHT_GRAY);
		NS.setFont(new Font("Tahoma", Font.BOLD, 28));
		NS.setBounds(28, 79, 50, 97);
		panel_Khung.add(NS);
		
		poster_phim = new JPanel();
		poster_phim.setBounds(531, 79, 150, 225);
		poster_phim.setBackground(new Color(255, 255, 255, 255));
		
		panel_Khung.add(poster_phim);
		poster_phim.setLayout(null);
		
		anh_poster();
		
		couple = new JPanel();
		couple.setBounds(78, 291, 400, 100);
		couple.setBackground(new Color(255, 255, 255, 0));
		panel_Khung.add(couple);
		couple.setLayout(new GridLayout(2, 0, 0, 0));
		
		VIP = new JPanel();
		VIP.setBounds(78, 181, 400, 100);
		VIP.setBackground(new Color(255, 255, 255, 0));
		panel_Khung.add(VIP);
		VIP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		VIP.setLayout(new GridLayout(2, 0, 0, 0));
		
		nearScreen = new JPanel();
		nearScreen.setBounds(78, 76, 400, 100);
		nearScreen.setBackground(new Color(255, 255, 255, 0));
		panel_Khung.add(nearScreen);
		nearScreen.setLayout(new GridLayout(2, 0, 0, 0));
		
		Screen = new JPanel();
		Screen.setBackground(Color.BLACK);
		Screen.setBounds(171, 10, 212, 46);
		panel_Khung.add(Screen);
		Screen.setLayout(null);
		
		JLabel screen = new JLabel("SCREEN");
		screen.setBounds(52, 10, 108, 29);
		screen.setForeground(Color.WHITE);
		screen.setFont(new Font("Tahoma", Font.BOLD, 23));
		Screen.add(screen);
		
		tao_ghe_gan_man_hinh();
		tao_ghe_vip();
		tao_ghe_couple();
		
		
		
		JButton done = new JButton("XONG");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection c = null;
				
				check_ghe();
				
				int tam=0,tamm=0, tammm=0;
				
				
				if (ktr_ghe == 0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn ghế","Trống!!!", JOptionPane.ERROR_MESSAGE);
				}else {
					for (int i =0; i<2; i++) {
						for (int j=0; j<8; j++) {
							if (ns[i][j].isSelected()) {
								tammm++;
								try {
									
									c = jdbc_new.getConnection();
									
									Statement st = c.createStatement();
									
									String sql = "INSERT INTO ghens(stt, hang, cot, tenGhe)"
											+ "VALUES ("+stt_ns+","+i+","+j+",'"+ganManHinh[i][j].getText()+"')";
									
									int check = st.executeUpdate(sql);
									
									jdbc_new.closeConnection(c);
									
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								stt_ns++;
							}else {
								continue;
							}
						}
					}
					
					
					for (int i =0; i<2; i++) {
						for (int j=0; j<8; j++) {
							if (v[i][j].isSelected()) {
								tamm++;
								try {
									
									c = jdbc_new.getConnection();
									
									Statement stt = c.createStatement();
									
									String sqll = "INSERT INTO ghevip(stt, hang, cot, tenGhe)"
											+ "VALUES ("+stt_ns+","+i+","+j+",'"+vip[i][j].getText()+"')";
									
									int chec = stt.executeUpdate(sqll);
									
									jdbc_new.closeConnection(c);
									
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								stt_ns++;
							}else {
								continue;
							}
						}
					}
					
					
					
					for (int i =0; i<2; i++) {
						for (int j=0; j<4; j++) {
							if (cup[i][j].isSelected()) {
								tam++;
								try {
									
									c = jdbc_new.getConnection();
									
									Statement sttt = c.createStatement();
									
									String sqlll = "INSERT INTO ghecouple(stt, hang, cot, tenGhe)"
											+ "VALUES ("+stt_ns+","+i+","+j+",'"+Couple[i][j].getText()+"')";
									
									int che = sttt.executeUpdate(sqlll);
									
									jdbc_new.closeConnection(c);
									
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								stt_ns++;
							}else {
								continue;
							}
						}
					}
				
					Statement sttt;
					String sqlll;
					try {
						c = jdbc_new.getConnection();
						
						sttt = c.createStatement();
						
						sqlll = "INSERT INTO xuatchieuhientai(tenPhim, nhanvien, tongGheNS, tongGheV,  tongGheC)"
								+ "VALUES (0,0,"+tammm+","+tamm+","+tam+")";
						
						int che = sttt.executeUpdate(sqlll);
						
						jdbc_new.closeConnection(c);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					xacnhanGhe xg = new xacnhanGhe();
					setVisible(false);
					xg.setVisible(true);
				}
					
				
			}
		});
		done.setBounds(530, 350, 70, 30);
		done.setBackground(new Color(238, 232,221));
		done.setForeground(new Color(120, 67, 21));
		done.setBorderPainted(false);
		
		panel_Khung.add(done);
		
		nutDone = new JPanel();
		nutDone.setBounds(527,348, 76, 34);
		nutDone.setBackground(new Color(201,192,151));
		panel_Khung.add(nutDone);
		
		JLabel logoIcon = new JLabel("");
		logoIcon.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\cinema.png"));
		
		logoIcon.setBounds(633, 264, 226, 266);
		panel_Khung.add(logoIcon);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(-16, -36, 960, 447);
		panel_Khung.add(Background);
		
		
		
		
	}
	
	
	
	
	
	
	public void anh_poster() {
		JLabel poster = new JLabel("");
		poster.setBounds(0, 5, 150, 225);

		
//		xc = new xuatChieuDAO().xuatXuatChieu();
		Connection c = null;
//		int xh =0;
				
			switch (xc.getMaPhim())
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
		
		poster_phim.add(poster);
	}
	
	public void tao_ghe_gan_man_hinh() {

		String ghe ="";
		ganManHinh = new JButton[2][8];
		for (int i = 0; i<2; i++) {
			for (int j=0; j<8; j++) {
				ghe = "";
				int tam = j+1;
				if (i==0)
					ghe += "A" + tam;
				else ghe += "B" + tam;
				ganManHinh[i][j] = new JButton();
				ganManHinh[i][j].setSize(45, 45);
				ganManHinh[i][j].setText(ghe);
				ganManHinh[i][j].setBackground(Color.LIGHT_GRAY);
				ganManHinh[i][j].setEnabled(false);
				
				nearScreen.add(ganManHinh[i][j]);
				nearScreen.setVisible(false);
				nearScreen.setVisible(true);
				
				
			}
		}
	}
	
	public void tao_check_ns()
	{
		ktr_ghe_csdl();
		ns = new JCheckBox[2][8];
		for (int i =0; i<2; i++) {
			toadoNgang=105;
			for (int j=0; j<8; j++) {
				int dem=0;
				for (int k =0; k<temp_ns; k++) {
					if (i == hang1ns[k] && j == hang2ns[k]) {
						dem++;
					
					}
					
				}
				
				ns[i][j] = new JCheckBox();
				ns[i][j].setBackground(Color.LIGHT_GRAY);
				ns[i][j].setBounds(toadoNgang, toadoDoc, 17, 17);
				
				if (dem==0) {
					panel_Khung.add(ns[i][j]);
				}
				
				toadoNgang+= 50;
			}
			toadoDoc+=50;
		}
	}
	
	public void tao_check_v()
	{
		ktr_ghe_csdl_vip();
		toadoDoc = 212;
		v = new JCheckBox[2][8];
		for (int i =0; i<2; i++) {
			toadoNgang=105;
			for (int j=0; j<8; j++) {
				int dem=0;
				for (int k =0; k<temp_v; k++) {
					if (i == hang1v[k] && j == hang2v[k]) {
						dem++;
					
					}
					
				}
				
				v[i][j] = new JCheckBox();
				v[i][j].setBackground(new Color(244, 206, 20));
				v[i][j].setBounds(toadoNgang, toadoDoc, 17, 17);
				
				if (dem == 0) {
					panel_Khung.add(v[i][j]);
				}
				toadoNgang+= 50;
			}
			toadoDoc+=50;
		}
	}
	
	public void tao_check_c()
	{
		ktr_ghe_csdl_couple();
		toadoDoc = 322;
		cup = new JCheckBox[2][8];
		for (int i =0; i<2; i++) {
			toadoNgang=155;
			for (int j=0; j<4; j++) {
				int dem=0;
				for (int k =0; k<temp_c; k++) {
					if (i == hang1c[k] && j == hang2c[k]) {
						dem++;
					
					}
					
				}
				cup[i][j] = new JCheckBox();
				cup[i][j].setBackground(Color.pink);
				cup[i][j].setBounds(toadoNgang, toadoDoc, 17, 17);
				
				
				if (dem==0) {
					panel_Khung.add(cup[i][j]);
				}
				toadoNgang+= 100;
			}
			toadoDoc+=50;
		}
	}
	
	public void tao_ghe_vip() {
		String ghe = "";
		vip = new JButton[2][8];
		for (int i = 0; i<2; i++) {
			for (int j=0; j<8; j++) {
				ghe = "";
				int tam = j+1;
				if (i==0)
					ghe += "C" + tam;
				else ghe += "D" + tam;
				vip[i][j] = new JButton();
				vip[i][j].setSize(45, 45);
				vip[i][j].setText(ghe);
				vip[i][j].setBackground(new Color(244, 206, 20));
				vip[i][j].setEnabled(false);
				
				VIP.add(vip[i][j]);
				VIP.setVisible(false);
				VIP.setVisible(true);
			}
		}
	}
	
	public void tao_ghe_couple() {
		String ghe = "";
		Couple = new JButton[2][4];
		for (int i = 0; i<2; i++) {
			for (int j=0; j<4; j++) {
				ghe = "";
				int tam = j+1;
				if (i==0)
					ghe += "E" + tam;
				else ghe += "F" + tam;
				Couple[i][j] = new JButton();

				Couple[i][j].setSize(90, 45);
				Couple[i][j].setText(ghe);
				Couple[i][j].setBackground(Color.PINK);
				Couple[i][j].setEnabled(false);
				couple.add(Couple[i][j]);
				couple.setVisible(false);
				couple.setVisible(true);
			}
		}
	}
	
	
	public int ktr_ghe=0;
	public void check_ghe()
	{
		for (int i=0; i<2; i++) {
			for (int j=0; j<8; j++) {
				if (ns[i][j].isSelected()) {
					ktr_ghe++;
				}
				if (v[i][j].isSelected()) {
					ktr_ghe++;
				}
			}
			for (int j=0; j<4; j++) {
				if (cup[i][j].isSelected()) {
					ktr_ghe++;
				}
			}
		}
	}
	
	
	int hang1ns[] = new int[16], hang2ns[] = new int[16], temp_ns = 0;
	int hang1v[] = new int[16], hang2v[] = new int[16], temp_v = 0;
	int hang1c[] = new int[16], hang2c[] = new int[16], temp_c = 0;
	
	public void ktr_ghe_csdl() {
		
		Connection c = jdbc_new.getConnection();
		try {
			
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM ghens");
			
			while (result.next()) {
				String tenCot = result.getString("hang");
				String tencot2 = result.getString("cot");
				String stt = result.getString("stt");
				stt_ns = Integer.parseInt(stt);
				hang1ns[temp_ns]= Integer.parseInt(tenCot);
				hang2ns[temp_ns]= Integer.parseInt(tencot2);
				temp_ns++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		stt_ns++;	
	}
	
	public void ktr_ghe_csdl_vip() {
		
		Connection c = jdbc_new.getConnection();
		try {
			
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM ghevip");
			
			while (result.next()) {
				String tenCot = result.getString("hang");
				String tencot2 = result.getString("cot");
				String stt = result.getString("stt");
				stt_v = Integer.parseInt(stt);
				hang1v[temp_v]= Integer.parseInt(tenCot);
				hang2v[temp_v]= Integer.parseInt(tencot2);
				temp_v++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		stt_v++;	
	}
	
	public void ktr_ghe_csdl_couple() {
		
		Connection c = jdbc_new.getConnection();
		try {
			
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM ghecouple");
			
			while (result.next()) {
				String tenCot = result.getString("hang");
				String tencot2 = result.getString("cot");
				String stt = result.getString("stt");
				stt_c = Integer.parseInt(stt);
				hang1c[temp_c]= Integer.parseInt(tenCot);
		
				
				hang2c[temp_c]= Integer.parseInt(tencot2);
				temp_c++;
			}
			
			jdbc_new.closeConnection(c);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		stt_c++;	
	}
}


