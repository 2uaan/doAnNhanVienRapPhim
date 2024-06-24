package viewNhanvien;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import viewKhachhang.menuDoAn;
import viewKhachhang.menuNuocUong;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class TrangChinhView extends JFrame{

	private JPanel contentPane, khung2nut;
	private JButton vePhim, veThucAn;
	private JLabel _2uanLabel, cinemaLabel, newTicketLabel;
	private JLabel[] champ1, champ2, chamt1, chamt2;
	private int  toadoNgang = 400, toadoDoc = 140;
	private static String tam;
	private int num = 1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChinhView frame = new TrangChinhView();
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
	public TrangChinhView() {
		setTitle("2uan Cinema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\2c_toolkit.png"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
//		newTicketLabel = new JLabel("New Ticket");
//		newTicketLabel.setFont(new Font("STLiti", Font.BOLD, 40));
//		newTicketLabel.setBounds(310, 320, 200, 100);
//		newTicketLabel.setForeground(new Color(59, 31, 1));
//		contentPane.add(newTicketLabel);
		
		khung2nut = new JPanel();
		khung2nut.setBounds(200, 150, 400, 200);
		khung2nut.setLayout(null);
		khung2nut.setBackground(new Color(255,255,255,100));
		
		champ1 = new JLabel[4]; 
		for (int i = 0; i<4; i++) {
			champ1[i] = new JLabel(".");
			champ1[i].setFont(new Font("Showcard Gothic", Font.BOLD, 50));
			champ1[i].setBounds(toadoNgang, 70, 50, 50);
			contentPane.add(champ1[i]);
			toadoNgang += 80;
		}
		
		champ2 = new JLabel[2];
		for (int j=0; j<2; j++) {
			champ2[j] = new JLabel(".");
			champ2[j].setFont(new Font("Showcard Gothic", Font.BOLD, 50));
			champ2[j].setBounds(640, toadoDoc, 50, 50);
			contentPane.add(champ2[j]);
			toadoDoc += 70;
		}
		toadoDoc = 240;
		chamt1 = new JLabel[3];
		for (int j=0; j<3; j++) {
			chamt1[j] = new JLabel(".");
			chamt1[j].setFont(new Font("Showcard Gothic", Font.BOLD, 50));
			chamt1[j].setBounds(140, toadoDoc, 50, 50);
			contentPane.add(chamt1[j]);
			toadoDoc += 70;
		}
		toadoNgang=210;
		chamt2 = new JLabel[3];
		for (int j=0; j<3; j++) {
			chamt2[j] = new JLabel(".");
			chamt2[j].setFont(new Font("Showcard Gothic", Font.BOLD, 50));
			chamt2[j].setBounds(toadoNgang, 380, 50, 50);
			contentPane.add(chamt2[j]);
			toadoNgang += 70;
		}
		
		chonThucAnView thucAn = new chonThucAnView();
		chonXuatChieuView xuatChieu = new chonXuatChieuView();
		menuDoAn menudoan = new menuDoAn();
		menuNuocUong menunuoc = new menuNuocUong();
		
		
//		tam lg = new tam();
//		
//		JButton logOut = new JButton("←");
//		logOut.setFont(new Font("Arial", Font.BOLD, 40));
//		logOut.setBackground(new Color(238, 232, 221));
//		logOut.setBorderPainted(false);
//		logOut.setBounds(20, 460, 80, 30);
//		logOut.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (num == 1) {
//					setVisible(false);
//					lg.setVisible(true);
//				}
//			}
//		});
//		contentPane.add(logOut);
		
		veThucAn = new JButton("FOOD");
		veThucAn.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\popcorn.png"));
		veThucAn.setFont(new Font("Showcard Gothic", Font.BOLD, 22));
		veThucAn.setBounds(200, 0, 200, 200);
		veThucAn.setBackground(new Color(174, 189, 147));
		veThucAn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				thucAn.setVisible(true);
				menudoan.setVisible(true);
				menunuoc.setVisible(true);
			}
		});
		
		vePhim = new JButton("Movie Ticket");
		vePhim.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\mayChieu.png"));
		vePhim.setText("Movie");
		vePhim.setFont(new Font("Showcard Gothic", Font.BOLD, 22));
		vePhim.setBounds(0, 0, 200, 200);
		vePhim.setBackground(new Color(255, 152, 42));
		vePhim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				xuatChieu.setVisible(true);
				
			}
		});
		
		
		_2uanLabel = new JLabel("2uan");
		_2uanLabel.setForeground(new Color(255, 140, 0));
		_2uanLabel.setFont(new Font("STLiti", Font.BOLD, 99));
		_2uanLabel.setBounds(40, 25, 213, 76);
		contentPane.add(_2uanLabel);
		
		cinemaLabel = new JLabel("Cinema");
		cinemaLabel.setForeground(new Color(30, 144, 255));
		cinemaLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
		cinemaLabel.setBounds(170, 52, 159, 74);
		contentPane.add(cinemaLabel);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\cinema.png"));
		logo.setBounds(600, 340, 256, 256);
		contentPane.add(logo);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		khung2nut.add(veThucAn);
		khung2nut.add(vePhim);
		getContentPane().add(khung2nut);
		
		
		
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, 1035, 703);
		contentPane.add(Background);
		
		
	}

	
}


