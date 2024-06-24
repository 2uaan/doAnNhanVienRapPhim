package demNguoc;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class dongHo extends JFrame {

	private JPanel contentPane, hms;
	private JLabel hienthi, gio, phut, giay, _10p, _30p, background;
	private JTextField hour, min, sec;
	private JButton start, _10, _30;
	private GridLayout _32;
	private Font ht, gpg, ex, sta;
	private String hthi;
	private int soGiay;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new dongHo();
	}

	/**
	 * Create the frame.
	 */
	public dongHo() {
		setTitle("Đồng Hồ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\Do_An_Co_So_2\\new\\clock.png"));
		setBounds(100, 100, 400, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ht = new Font("Stencil", Font.BOLD, 80);
		gpg = new Font("Consolas",Font.PLAIN,20);
		ex = new Font("Consolas",Font.BOLD,35);
		sta = new Font("Arial",Font.BOLD, 30);
		
		hienthi = new JLabel("00:00:00");
		gio = new JLabel("Giờ");
		phut = new JLabel("Phút");
		giay = new JLabel("Giây");
		
		
		
		_10p = new JLabel("10 phút");
		_30p = new JLabel("30 phút");
		_10p.setFont(ex);
		_30p.setFont(ex);
		
		hour = new JTextField();
		min = new JTextField();
		sec = new JTextField();
		
		start = new JButton("Bắt đầu");
		_10 = new JButton("10'");
		_30 = new JButton("30'");
		_10.setBounds(260,270,100,40);
		_30.setBounds(260,350,100,40);
		
		
		_32 = new GridLayout(2,3);
		hms = new JPanel();
		hms.setLayout(_32);
		
		hour.setSize(40, 20);
		hms.add(hour);
		min.setSize(40, 20);
		hms.add(min);
		sec.setSize(40, 20);
		hms.add(sec);
		hour.setHorizontalAlignment(SwingConstants.CENTER);
		min.setHorizontalAlignment(SwingConstants.CENTER);
		sec.setHorizontalAlignment(SwingConstants.CENTER);
		gio.setHorizontalAlignment(SwingConstants.CENTER);
		phut.setHorizontalAlignment(SwingConstants.CENTER);
		giay.setHorizontalAlignment(SwingConstants.CENTER);
		gio.setFont(gpg);
		phut.setFont(gpg);
		giay.setFont(gpg);
		hms.add(gio);
		hms.add(phut);
		hms.add(giay);
		
		hms.setBounds(10, 160, 365, 80);
		hms.setBackground(new Color(255,255,255,0));
		contentPane.add(hms);
		
		_10p.setBounds(30, 280, 150, 40);
		contentPane.add(_10p);
		_30p.setBounds(30, 360, 150, 40);
		contentPane.add(_30p);
		contentPane.add(_10);
		contentPane.add(_30);
		

		
		hienthi.setFont(ht);
		hienthi.setHorizontalAlignment(SwingConstants.CENTER);
		hienthi.setBounds(3, 10,380, 150);
		contentPane.add(hienthi);
		

		start.setFont(sta);
		start.setBounds(125 ,430 ,150,100);
		start.setBorderPainted(false);
		start.setBackground(new Color(87, 64, 9));
		start.setForeground(Color.white);
		contentPane.add(start);		
		
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\Do_An_Co_So_2\\new\\background.png"));
		background.setBounds(0,0,400,600);
		contentPane.add(background);
		
		setVisible(true);
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}	
