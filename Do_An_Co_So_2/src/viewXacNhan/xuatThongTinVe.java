package viewXacNhan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import dao.thucAnDAO;
import dao.xuatChieuDAO;
import model.*;
import viewNhanvien.TrangChinhView;

public class xuatThongTinVe extends JFrame{
	
	private JPanel contentPane, foodPane, seetPane;
	private inforRapPhim infor = new inforRapPhim();
	private color colo = new color();
	private gheCDAO cdao = new gheCDAO();
	private gheNSDAO nsdao = new gheNSDAO();
	private gheVDAO vdao = new gheVDAO();
	private thucAnDAO tadao = new thucAnDAO();
	private xuatChieuDAO xcdao = new xuatChieuDAO();
	private JLabel bill, food, seet;
	private font font = new font();
	private JLabel mov = new JLabel(), hap = new JLabel();
	
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
		
		foodPane = new JPanel();
		seetPane = new JPanel();
		bill = new JLabel("HÓA ĐƠN");
		food = new JLabel("Thức Ăn");
		seet = new JLabel("Ghế Ngồi");
		
		bill.setFont(font.setTilt_Neon_Size(35));
		food.setFont(font.setTilt_Neon_UnBold_Size(25));
		seet.setFont(font.setTilt_Neon_UnBold_Size(25));
		
		bill.setBounds(this.getWidth()/2-80, 10, 180, 40);
		food.setBounds(this.getWidth()/4-65, 80, 150, 40);
		seet.setBounds(this.getWidth()*3/4-65, 80, 150, 40);
		
		foodPane.setBounds(35,140, 370, 325);
		foodPane.setBackground(Color.black);
		seetPane.setBounds(35 + this.getWidth()/2,140, 370, 325);
		seetPane.setBackground(Color.black);
		
		foodPane.setLayout(new BorderLayout());
		seetPane.setLayout(new BorderLayout());
		
		
		
		
		
		contentPane.add(seetPane);
		contentPane.add(foodPane);
		contentPane.add(bill);
		contentPane.add(food);
		contentPane.add(seet);
		
		JButton chia = new JButton();
		chia.setBackground(colo.nauVang);
		chia.setBounds(this.getWidth()/2 -5, 60, 10, 420);
		chia.setEnabled(false);
		chia.setBorder(BorderFactory.createLoweredBevelBorder());
		contentPane.add(chia);
		
		mov = new JLabel(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\mov.png"));
		hap = new JLabel(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\happy.png"));
		mov.setBounds(320, 470, 60, 60);
		hap.setBounds(520, 470, 60, 60);
		mov.setVisible(false);
		hap.setVisible(false);
		
		contentPane.add(hap);
		contentPane.add(mov);
		
		JButton done = new JButton("Thanh Toán");
		done.setBounds(this.getWidth()/2-55, 500, 110, 30);
		done.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				mov.setVisible(false);
				hap.setVisible(false);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mov.setVisible(true);
				hap.setVisible(true);
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
		int tienTA = tao_thong_tin_food(tadao.duyet_tat_ca_thuc_an(), tadao.duyet_so_luong_tung_loai());
		int tienGhe =  tao_thong_tin_ghe();
		JLabel tongtien = new JLabel("(" + doi_sang_gia_tien(tienGhe + tienTA) + ")");
		tongtien.setFont(font.setTilt_Neon_Size(35));
		tongtien.setForeground(colo.nauVang);
		tongtien.setBounds(this.getWidth()/2+100, 10, 280, 40);
		contentPane.add(tongtien);
		
		
		
		
		
		trang_tri_cham(35,40);
		trang_tri_cham(485,40);
		trang_tri_cham(35,100);
		trang_tri_cham(485,100);
		trang_tri_cham(35,450);
		trang_tri_cham(485,450);
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
	}
	
	public String doi_sang_gia_tien(int giaThanh) {
			
		String temp = "";
		
		while(giaThanh > 1000) {
			String t = giaThanh +"";
			temp = "."+t.substring(t.length()-3, t.length()) + temp;
			giaThanh /= 1000;
		}
		
		temp = giaThanh + temp;
		
		temp += "đ";

		
		return temp;
	}
	
	private void trang_tri_cham(int toaDoNgang, int toaDoDoc) {
		for (int i = 0; i< 25; i++) {
			JLabel cham = new JLabel(".");
			cham.setBounds(toaDoNgang, toaDoDoc, 30,30);
			cham.setFont(font.setUTMfacebookKnT(40));
			toaDoNgang += 15;
			
			contentPane.add(cham);
			contentPane.setVisible(false);
			contentPane.setVisible(true);
		}
		
		
	}
	private int tao_thong_tin_food(thucAn[] ta, int[] soluong) {
		String cot[] = {" Tên"," Số Lượng"," Giá Thành"};
		JPanel dau, giua, cuoi;
		int tongtien=0;
		int dem = 0;
		
		dau = new JPanel();
		giua = new JPanel();
		cuoi = new JPanel();
		
		dau.setLayout(new GridLayout(1,3));
		giua.setLayout(new GridLayout(ta.length,3));
		cuoi.setLayout(new GridLayout(1,2));
		
		for (int i = 0; i<3; i++) {
			JLabel temp = new JLabel(cot[i]);
			temp.setBorder(BorderFactory.createLineBorder(Color.black));
			temp.setFont(font.setUTMfacebookKnT(20));
			
			dau.add(temp);
		}
		
		for (int i =0; i< ta.length; i++) {
			if (soluong[i] > 0) {
				JLabel ten, so, gia;
				ten = new JLabel(" "+ta[i].getTenMon());
				so = new JLabel(" "+soluong[i]+"");
				gia = new JLabel(" "+doi_sang_gia_tien(ta[i].getGiaThanh()));
				
				tongtien += soluong[i]*ta[i].getGiaThanh();
				
				giua.add(ten);
				giua.add(so);
				giua.add(gia);
				giua.setVisible(false);
				giua.setVisible(true);
				dem++;
			}
		}
		for (int i = 0; i< ta.length-dem; i++) {
			JLabel ten, so, gia;
			ten = new JLabel();
			so = new JLabel();
			gia = new JLabel();
			
			giua.add(ten);
			giua.add(so);
			giua.add(gia);
			giua.setVisible(false);
			giua.setVisible(true);
		}
		
		JLabel tongLabel = new JLabel(" Tổng Thức Ăn:");
		tongLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		tongLabel.setFont(font.setUTMfacebookKnT(20));
		JLabel tong = new JLabel(" "+doi_sang_gia_tien(tongtien));
		tong.setBorder(BorderFactory.createLineBorder(Color.black));
		tong.setFont(font.setUTMfacebookKnT(20));
		tong.setForeground(colo.nauVang);
		cuoi.add(tongLabel);
		cuoi.add(tong);
		
		giua.setBorder(BorderFactory.createLineBorder(Color.black));
		
		foodPane.add(dau, BorderLayout.PAGE_START);
		foodPane.add(giua, BorderLayout.CENTER);
		foodPane.add(cuoi, BorderLayout.PAGE_END);
		foodPane.setVisible(false);
		foodPane.setVisible(true);
		
		return tongtien;
	}
	private int tao_thong_tin_ghe() {
		
		String[][] dsGhe = xcdao.duyet_ghe_dang_chon();
		String cot[] = {" Tên Ghế"," Loại"," Giá Thành"};
		JPanel dau, giua, cuoi;
		int tongtien = 0;
		
		dau = new JPanel();
		giua = new JPanel();
		cuoi = new JPanel();
		
		GridLayout gr = new GridLayout();
		gr.setRows(10);
		gr.setColumns(1);
		
		dau.setLayout(new GridLayout(1,3));
		giua.setLayout(gr);
		giua.setBorder(BorderFactory.createLineBorder(Color.black));
		cuoi.setLayout(new GridLayout(1,2));
		
		
		for (int i = 0; i<3; i++) {
			JLabel temp = new JLabel(cot[i]);
			temp.setBorder(BorderFactory.createLineBorder(Color.black));
			temp.setFont(font.setUTMfacebookKnT(20));
			
			dau.add(temp);
		}
		
		for (int i = 0; i< dsGhe.length; i++) {

			JPanel gom = new JPanel();
			gom.setLayout(new GridLayout(1,3));
			
			JLabel ten, loai, gia;
			ten = new JLabel(" "+dsGhe[i][0]);
			loai = new JLabel(" "+dsGhe[i][1]);
			gia = new JLabel(" "+doi_sang_gia_tien(Integer.parseInt(dsGhe[i][2])));
			tongtien+= Integer.parseInt(dsGhe[i][2]);
			
			gom.add(ten);
			gom.add(loai);
			gom.add(gia);
			
			giua.add(gom);
			
		}
		
		JLabel tongLabel = new JLabel(" Tổng Ghế:");
		tongLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		tongLabel.setFont(font.setUTMfacebookKnT(20));
		JLabel tong = new JLabel(" "+doi_sang_gia_tien(tongtien));
		tong.setBorder(BorderFactory.createLineBorder(Color.black));
		tong.setFont(font.setUTMfacebookKnT(20));
		tong.setForeground(colo.nauVang);
		
		cuoi.add(tongLabel);
		cuoi.add(tong);
		
		seetPane.add(dau, BorderLayout.PAGE_START);
		seetPane.add(giua, BorderLayout.CENTER);
		seetPane.add(cuoi, BorderLayout.PAGE_END);
		seetPane.setVisible(false);
		seetPane.setVisible(true);
		
		return tongtien;
	}
	
}
