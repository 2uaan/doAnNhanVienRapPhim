package viewNhanvien;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import dao.nhanVienDAO;
import dao.xuatChieuDAO;
import model.font;
import model.inforRapPhim;
import model.xuatChieu;
import viewXacNhan.wait;

public class chonXuatChieuVie extends JFrame{
	private JPanel contentPane, khungXuatChieu, khungNgoai, movTime[], inmovTime[];
	private JTextArea tenPhim[];
	private inforRapPhim infor = new inforRapPhim();
	private GridLayout khungXC;
	private xuatChieuDAO xc = new xuatChieuDAO();
	private font f;
	private String tenP[] = xc.duyetTenPhim();
	private xuatChieu xchieu[] = xc.duyetXC();
	private int j=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chonXuatChieuVie frame = new chonXuatChieuVie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public chonXuatChieuVie() {
		
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
		
		
		
		tenPhim = new JTextArea[3];
		movTime = new JPanel[3];
		inmovTime = new JPanel[3];
		f = new font();
		
		khungXuatChieu = new JPanel();
//		khungXuatChieu.setBorder(UIManager.getBorder("OptionPane.buttonAreaBorder"));
		khungXuatChieu.setBackground(new Color(201, 192, 151));
		khungXuatChieu.setBounds( 5, 5,710, 400);
		
		
		khungXC = new GridLayout(3,2);
		khungXC.setVgap(20);
		wait xacNhanChonXC = new wait();
		
		for (int i = 0; i<6; i++) {
			if (i % 2 == 0) {
				tenPhim[i/2] = new JTextArea(tenP[i/2]);
				tenPhim[i/2].setFont(f.consolas);
				tenPhim[i/2].setBackground(new Color(201, 192, 151));
				tenPhim[i/2].setEditable(false);
				tenPhim[i/2].setLineWrap(true);
				tenPhim[i/2].setFocusable(false);
				tenPhim[i/2].setMargin(new Insets(30, 10, 0, 0));
				khungXuatChieu.add(tenPhim[i/2]);
			}else {
				movTime[(i-1)/2] = new JPanel();
				inmovTime[(i-1)/2] = new JPanel();
				movTime[(i-1)/2].setBackground(new Color(140, 97, 15));
				movTime[(i-1)/2].setLayout(null);
				inmovTime[(i-1)/2].setBackground(Color.black);
				inmovTime[(i-1)/2].setBounds(5, 5, 345, 110);
				inmovTime[(i-1)/2].setLayout(new FlowLayout());
				for (j =0; j< xchieu.length; j++) {
					if ((xchieu[j].getMaPhim() % 10) - 1 == (i-1)/2) {
						JButton n = new JButton(catS(xchieu[j].getGioBatDau()) + " - " + catS(xchieu[j].getGioKetThuc()));
						n.addActionListener(new ActionListener() {
						int temp = j;
							@Override
							public void actionPerformed(ActionEvent e) {
								xc.xoaXuatChieuDangChon();
								xc.luuXuatChieuDangChon(xchieu[temp].getMaXC());
								setVisible(false);
								xacNhanChonXC.setVisible(true);
							}
						});
						inmovTime[(i-1)/2].add(n);
					}
				}
				
				movTime[(i-1)/2].add(inmovTime[(i-1)/2]);
				khungXuatChieu.add(movTime[(i-1)/2]);
			}
		}
		
		khungXuatChieu.setLayout(khungXC);
		
		
		
		khungNgoai = new JPanel();
	    khungNgoai.setBounds( 90, 65, 720, 410);
	    khungNgoai.setBackground(Color.black);
	    khungNgoai.setLayout(null);
	    khungNgoai.add(khungXuatChieu);
	    contentPane.add(khungNgoai);
	    
	    
	    JLabel nvTC = new JLabel(new nhanVienDAO().nvTrongCa());
		nvTC.setForeground(new Color(138, 91, 65));
		nvTC.setFont(new Font("STLiti", Font.PLAIN, 25));
		nvTC.setBounds(20, -20, 213, 76);
		contentPane.add(nvTC);
	    
	    JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\toolkit.png"));
		logo.setBounds(500, -150, 512, 512);
		contentPane.add(logo);
		JLabel camera = new JLabel();
		camera.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\nenMayQuay.png"));
		camera.setBounds(-86, 301, 400, 400);
		contentPane.add(camera);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\git\\repository\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, infor.ngangKhung, infor.docKhung);
		contentPane.add(Background);
		
	}
	
	public String catS(String str) {
		String st = "";
		for (int i = 0; i<5; i++) {
			st += str.charAt(i);
		}
		
		return st;
	}
	
}
