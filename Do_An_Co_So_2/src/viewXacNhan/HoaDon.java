package viewXacNhan;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.jdbc_new;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HoaDon extends JFrame {

	private JPanel contentPane, nen, hoadon_i4, trong;
	private JPanel soLuongGhe, soLuongThucAn, tongTienGhe, tongTienThucAn;
	private JLabel _2uanLabel, cinemaLabel, tenPhim;
	private JLabel gheNgoi, thucAn, tongTien;
	private JLabel giaTongGhe, giaTongTA, giaTong;
	private int tongGhe=0, tongThucAn=0, tongtien=0, dem=0;
	private JLabel tenGhe[], tenMon[];
	String tam="";
	private String mangDoAn[];
	private int soluongDoAn[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon frame = new HoaDon();
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
	public HoaDon() {
		setTitle("Hóa Đơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 784);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 241, 192));
	
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton next = new JButton("Hoàn Tất");
		next.setFont(new Font("Arial", Font.BOLD, 16));
		next.setBackground(new Color(238, 232, 221));
		next.setBorderPainted(false);
		next.setBounds(295, 677, 110, 40);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		contentPane.add(next);
		
		JPanel p = new JPanel();
		p.setBackground(new Color(120, 67, 21));
		p.setBounds(291, 675, 118, 44);
		contentPane.add(p);
		
		_2uanLabel = new JLabel("2uan");
		_2uanLabel.setForeground(new Color(255, 140, 0));
		_2uanLabel.setFont(new Font("STLiti", Font.BOLD, 99));
		_2uanLabel.setBounds(52, 20, 213, 76);
		contentPane.add(_2uanLabel);
		
		cinemaLabel = new JLabel("Cinema");
		cinemaLabel.setForeground(new Color(30, 144, 255));
		cinemaLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		cinemaLabel.setBounds(194, 58, 159, 74);
		contentPane.add(cinemaLabel);
		
		
		nen = new JPanel();
		nen.setBackground(new Color(120, 67, 21));
		nen.setBounds(0, 0, 434, 87);
		contentPane.add(nen);
		
		
		
		
		JLabel title = new JLabel("Hóa Đơn");
		title.setFont(new Font("Times New Roman", Font.BOLD, 45));
		title.setBounds(132, 123, 199, 67);
		contentPane.add(title);
		
		hoadon_i4 = new JPanel();
		hoadon_i4.setBounds(0, 187, 434, 461);
		hoadon_i4.setBackground(new Color(255, 241, 192));
		hoadon_i4.setLayout(new GridLayout(3, 3, 0, 0));
		
		gheNgoi = new JLabel("   Ghế:");
		label_style(gheNgoi);
		
		soLuongGhe = new JPanel();
		soLuongGhe.setBackground(new Color(255, 241, 192));
		
		
		hoadon_i4.add(soLuongGhe);
		soLuongGhe.setLayout(new GridLayout(4, 4, 0, 0));
		
		tongtien();
		
		giaTongGhe = new JLabel();
		giaTongGhe.setText(tongGhe+".000VND");
		label_style(giaTongGhe);
		
		
		
		thucAn = new JLabel("   Thức Ăn:");
		label_style(thucAn);
		
		soLuongThucAn = new JPanel();
		soLuongThucAn.setBackground(new Color(255, 241, 192));
		hoadon_i4.add(soLuongThucAn);
		soLuongThucAn.setLayout(new GridLayout(8, 2, 0, 0));
		
		ten_chi_tiet();
		tenGhe= new JLabel[dem];
		int temp = dem;
		String t ="";
		for (int j=0; j<tam.length(); j++) {
			t +=tam.charAt(j);
			if (tam.charAt(j)==' ') {
				temp--;
				tenGhe[temp] = new JLabel();
				tenGhe[temp].setText(t);
				tenGhe[temp].setFont(new Font("Times New Roman",Font.PLAIN, 20));
				soLuongGhe.add(tenGhe[temp]);
				
				t="";
			}
		}
		
		giaTongTA = new JLabel();
		giaTongTA.setText(tongThucAn+".000VND");
		label_style(giaTongTA);
		
		tongTien = new JLabel("   Tổng tiền:");
		label_style(tongTien);
		
		trong = new JPanel();
		trong.setBackground(new Color(255, 241, 192));
		hoadon_i4.add(trong);
		
		giaTong = new JLabel();
		giaTong.setText(tongtien+".000VND");
		label_style(giaTong);
		
		
		
		contentPane.add(hoadon_i4);
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setBounds(10, -42, 512, 512);
//		contentPane.add(lblNewLabel);
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\Do_An_Co_So_2\\image\\toolkit.png"));
		
	}
	
	public void label_style(JLabel a) {
		
		Font f = new Font("Times New Roman", Font.BOLD, 20);
		a.setFont(f);
		a.setVerticalAlignment(SwingConstants.TOP);
		
		hoadon_i4.add(a);
	}	
	
	
	public void tongtien() {
		
		int soghens=0, soghev=0, soghec=0, sl=0, i=0;
		int tenTA[]=null, soluongTA[]=null, num=1;
		
		Connection c = null;
		
		try {
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM xuatchieuhientai");
			
			while (result.next())
			{
				soghens = Integer.parseInt(result.getString("tongGheNS"));
				soghev = Integer.parseInt(result.getString("tongGheV"));
				soghec = Integer.parseInt(result.getString("tongGheC"));
			}
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			c = jdbc_new.getConnection();
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM doan_dagoi");
			
			while (result.next()) {
				int a = result.getInt("soLuong");
				num++;
			}
			tenTA = new int[num];
			soluongTA = new int[num];
			ResultSet r = st.executeQuery("SELECT * FROM doan_dagoi");
			
			while (r.next()) {
				String tam = r.getString("tenThucAn");
				int a = r.getInt("soLuong");
				switch (tam) {
				case "Combo 2 Nước Lọc":{
					sl=2;
					break;
				}
				case "Bắp Phô Mai":{
					sl=1;
					break;
				}
				case "Bắp Caramel":{
					sl=1;
					break;
				}
				case "Coca-cola":{
					sl=2;
					break;
				}
				case "Soda":{
					sl=2;
					break;
				}
				case "Combo 2 Bắp Ngọt":{
					sl=1;
					break;
				}
				
				
				}
				tenTA[i]=sl;
				soluongTA[i]=a;
				i++;
			}
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (int j =0; j<num;j++) {
			if (tenTA[j]==1) {
				tongThucAn += 69*soluongTA[j];
			}else {
				tongThucAn += 39*soluongTA[j];
			}
		}
		
		tongGhe = soghens*85 + soghev*105 + soghec*190;
		
		tongtien = tongGhe + tongThucAn;
		
	}
	
	public void ten_chi_tiet() {
		
		Connection c = null;
		tam ="";
		dem=0;
		
		try {
			c = jdbc_new.getConnection();
			
			Statement st = c.createStatement();
			ResultSet ns = st.executeQuery("SELECT * FROM ghens");
			
			while (ns.next()) {
				tam += ns.getString("tenGhe")+ " ";
			}
			
			ResultSet v = st.executeQuery("SELECT * FROM ghevip");
			
			while (v.next()) {
				tam += v.getString("tenGhe")+ " ";
			}
			
			ResultSet cup = st.executeQuery("SELECT * FROM ghecouple");
			
			while (cup.next()) {
				tam += cup.getString("tenGhe")+ " ";
			}
			
			
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (int j=0; j<tam.length(); j++) {
			if (tam.charAt(j)==' ') {
				dem++;
			}
		}
		int demm=0;
//		try {
//			c = jdbc_new.getConnection();
//			Statement st = c.createStatement();
//			
//			ResultSet r = st.executeQuery("SELECT * FROM doan_dagoi");
//			
//			while (r.next()) {
//				int a = r.getInt("soLuong");
//				demm++;
//			}
//			mangDoAn = new String[demm];
//			soluongDoAn = new int[demm];
//			int cc=demm;
//			while (r.next()) {
//				cc--;
//				mangDoAn[cc]= r.getString("tenThucAn");
//				soluongDoAn[cc] = r.getInt("soLuong");
//			}
//			
//			System.out.println(mangDoAn[0]);
//			
//			jdbc_new.closeConnection(c);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		int ccc = demm;
//		tenMon = new JLabel[demm*2];
//		for (int j=0; j<demm*2; j++) {
//			tenMon[j] = new JLabel();
//			if (j%2==0) {
//				ccc--;
//				tenMon[j].setText(mangDoAn[ccc]);
//			}else {
//				tenMon[j].setText(""+soluongDoAn[ccc]);
//			}
//			
//			soLuongThucAn.add(tenMon[j]);
//		}
		
	}
}
