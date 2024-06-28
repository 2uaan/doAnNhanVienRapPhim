package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.nhanVienDAO;
import dao.xuatChieuDAO;
import database.jdbc_new;
import model.font;
import model.inforRapPhim;
import viewXacNhan.wait;

import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class chonXuatChieuView extends JFrame {

	private JPanel contentPane, khungXuatChieu, mov1, mov2, mov3, khungNgoai;
	private JLabel nameMov1, nameMov2, nameMov3;
	private JCheckBox check_mov2;
	private JCheckBox check_mov1;
	private JCheckBox check_mov3;
	private String[] tenP, gioC;
	private xuatChieuDAO xc = new xuatChieuDAO();
	private inforRapPhim infor = new inforRapPhim();
	private font f;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chonXuatChieuView frame = new chonXuatChieuView();
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
	public chonXuatChieuView() {
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
		
		f = new font();
		tenP = xc.duyetTenPhim();
		gioC = xc.duyetGioChieu();
		xc.xoaXuatChieuDangChon();
		
		
		khungXuatChieu = new JPanel();
//		khungXuatChieu.setBorder(UIManager.getBorder("OptionPane.buttonAreaBorder"));
		khungXuatChieu.setBackground(new Color(201, 192, 151));
		khungXuatChieu.setBounds( 100, 70, 700, 400);
		
		Insets in = new Insets(0, 10, 0, 0);
		
//		Font font = new Font("Consolas", Font.BOLD | Font.ITALIC, 20);
		GridBagLayout gbl_khungXuatChieu = new GridBagLayout();
		gbl_khungXuatChieu.columnWidths = new int[]{145, 350, 0};
		gbl_khungXuatChieu.rowHeights = new int[]{133, 133, 133, 0};
		gbl_khungXuatChieu.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_khungXuatChieu.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		khungXuatChieu.setLayout(gbl_khungXuatChieu);
		
		nameMov1 = new JLabel(tenP[0]);
		
		nameMov1.setFont(f.consolas);
		
		GridBagConstraints gbc_nameMov1 = new GridBagConstraints();
		gbc_nameMov1.fill = GridBagConstraints.BOTH;
		gbc_nameMov1.insets = new Insets(0, 10, 5, 5);
		gbc_nameMov1.gridx = 0;
		khungXuatChieu.add(nameMov1, gbc_nameMov1);
		
		mov1 = new JPanel();
		GridBagConstraints gbc_mov1 = new GridBagConstraints();
		gbc_mov1.fill = GridBagConstraints.BOTH;
		gbc_mov1.insets = new Insets(5, 5, 5, 5);
		gbc_mov1.gridx = 1;
//		gbc_mov1.gridy = 0;
		gbc_mov1.weightx = 2;
		khungXuatChieu.add(mov1, gbc_mov1);
		mov1.setLayout(new GridLayout(0,1));
		
		check_mov1 = new JCheckBox(gioC[0]);
		check_mov1.setMargin(new Insets(0, 10, 0, 0));
		mov1.add(check_mov1);
		
		nameMov2 = new JLabel(tenP[1]);
		nameMov2.setFont(f.consolas);
		GridBagConstraints gbc_nameMov2 = new GridBagConstraints();
		gbc_nameMov2.fill = GridBagConstraints.BOTH;
		gbc_nameMov2.insets = new Insets(0, 10, 5, 5);
		gbc_nameMov2.gridx = 0;
		gbc_nameMov2.gridy = 1;
		khungXuatChieu.add(nameMov2, gbc_nameMov2);
		
		mov2 = new JPanel();
		GridBagConstraints gbc_mov2 = new GridBagConstraints();
		gbc_mov2.weightx = 2.0;
		gbc_mov2.fill = GridBagConstraints.BOTH;
		gbc_mov2.insets = new Insets(0, 5, 5, 5);
		gbc_mov2.gridx = 1;
		gbc_mov2.gridy = 1;
		khungXuatChieu.add(mov2, gbc_mov2);
		mov2.setLayout(new GridLayout(0, 1, 0, 0));
		
		check_mov2 = new JCheckBox(gioC[1]);
		check_mov2.setMargin(new Insets(0, 10, 0, 0));
		mov2.add(check_mov2);
		
		
		
		nameMov3 = new JLabel(tenP[2]);
		nameMov3.setFont(f.consolas);
		GridBagConstraints gbc_nameMov3 = new GridBagConstraints();
		gbc_nameMov3.fill = GridBagConstraints.BOTH;
		gbc_nameMov3.insets = new Insets(0, 10, 0, 5);
		gbc_nameMov3.gridx = 0;
		gbc_nameMov3.gridy = 2;
		khungXuatChieu.add(nameMov3, gbc_nameMov3);
		
		
//		contentPane.add(khungXuatChieu);
		mov3 = new JPanel();
		GridBagConstraints gbc_mov3 = new GridBagConstraints();
		gbc_mov3.weightx = 2.0;
		gbc_mov3.insets = new Insets(0, 5, 5, 5);
		gbc_mov3.fill = GridBagConstraints.BOTH;
		gbc_mov3.gridx = 1;
		gbc_mov3.gridy = 2;
		khungXuatChieu.add(mov3, gbc_mov3);
		mov3.setLayout(new GridLayout(0, 1, 0, 0));
		
		check_mov3 = new JCheckBox(gioC[2]);
		check_mov3.setMargin(new Insets(0, 10, 0, 0));
		mov3.add(check_mov3);
		
		wait cg = new wait();
		
		JButton next = new JButton("→");
		next.setFont(new Font("Arial", Font.BOLD, 50));
		next.setBackground(new Color(238, 232, 221));
		next.setBorderPainted(false);
		next.setBounds(730, 480, 100, 50);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				luu_xuat_chieu();
				setVisible(false);
				
				cg.setVisible(true);
			}
		});
		contentPane.add(next);
		
		khungNgoai = new JPanel();
	    khungNgoai.setBounds( 90, 65, 720, 410);
	    khungNgoai.setBackground(Color.black);
	    khungNgoai.add(khungXuatChieu);
	    contentPane.add(khungNgoai);
		
	    JLabel nvTC = new JLabel(new nhanVienDAO().nvTrongCa());
		nvTC.setForeground(new Color(138, 91, 65));
		nvTC.setFont(new Font("STLiti", Font.PLAIN, 25));
		nvTC.setBounds(765, -20, 213, 76);
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
	
	public void luu_xuat_chieu() {
		int phim=0;
		if (check_mov1.isSelected()) {
			phim=312;
		}
		if (check_mov2.isSelected()) {
			phim=465;
		}
		if (check_mov3.isSelected()) {
			phim=798; 
		}
		
		xc.luuXuatChieuDangChon(phim);
		
	}

}