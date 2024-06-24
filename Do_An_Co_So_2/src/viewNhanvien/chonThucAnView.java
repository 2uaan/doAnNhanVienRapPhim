package viewNhanvien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.jdbc_new;
import viewXacNhan.hoantatThongTinVe;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class chonThucAnView extends JFrame {

	private JPanel contentPane, drink, food;
	private JButton coca, soda, cheese, caramel, waterCombo, normalCombo;
	private JLabel[] kedoc;
	private JLabel thucan, nuocuong;
	private int soke = 23, toadoDoc =50;
	private JCheckBox cwaterCombo, ccoca, csoda, ccheese, ccaramel, cnormalCombo;
	private JTextField cheesetf, carameltf, n2tf, cocatf, sodatf, w2tf;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public chonThucAnView() {
		setTitle("Thức Ăn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\2c_toolkit.png"));
		setResizable(false);
		setSize(800, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		thucan = new JLabel("FOOD");
		nuocuong = new JLabel("DRINK");
		thucan.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
		nuocuong.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
		thucan.setBounds(150, 10, 125, 60);
		
		Connection c = null;
		
		try {
			c = jdbc_new.getConnection();
			
			Statement st = c.createStatement();
			
			String sql = "DELETE FROM doan_dagoi";
			
			int check = st.executeUpdate(sql);
			
			jdbc_new.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		nuocuong.setBounds(520, 10, 140, 60);		
		contentPane.add(nuocuong);
		contentPane.add(thucan);
		
		kedoc = new JLabel[soke];
		for (int j=0; j<soke; j++) {
			kedoc[j] = new JLabel(".");
			kedoc[j].setFont(new Font("Consolas", Font.BOLD, 50));
			kedoc[j].setForeground(new Color(59, 31, 1));
			kedoc[j].setBounds(390, toadoDoc, 50, 50);
			contentPane.add(kedoc[j]);
			toadoDoc += 15;
		}
		
		cheesetf = new JTextField();
		cocatf = new JTextField();
		carameltf = new JTextField();
		n2tf = new JTextField();
		sodatf = new JTextField();
		w2tf = new JTextField();
		
		cheesetf.setLocation(325, 140);
		carameltf.setLocation(325, 240);
		n2tf.setLocation(325, 340);
		
		cocatf.setLocation(415, 140);
		sodatf.setLocation(415, 240);
		w2tf.setLocation(415, 340);
		
		
		
		
		tf_size(carameltf);
		tf_size(cheesetf);
		tf_size(cocatf);
		tf_size(sodatf);
		tf_size(n2tf);
		tf_size(w2tf);
		
		
		drink = new JPanel();
		drink.setLayout(null);
		drink.setBounds(480, 90, 220, 300);
		
		ccoca = new JCheckBox("");
		ccoca.setBounds(100, 30, 93, 65);
		ccoca.setBackground(new Color(249, 142, 114));
		drink.add(ccoca);
		
		csoda = new JCheckBox("");
		csoda.setBounds(100, 130, 93, 65);
		csoda.setBackground(new Color(255, 145, 77));
		drink.add(csoda);
		
		cwaterCombo = new JCheckBox("");
		cwaterCombo.setBounds(100, 230, 93, 65);
		cwaterCombo.setBackground(new Color(134, 197, 213));
		drink.add(cwaterCombo);
		
		
		coca = new JButton("COCACOLA");
		coca.setFont(new Font("STXinwei", Font.BOLD, 25));
		coca.setVerticalAlignment(SwingConstants.TOP);
		
		coca.setBackground(new Color(249, 142, 114));
		coca.setBounds(0,0, 220, 100);
		coca.setBorderPainted(false);
		coca.setEnabled(false);
		drink.add(coca);
		
		soda = new JButton("SODA");
		soda.setFont(new Font("STXinwei", Font.BOLD, 25));
		soda.setVerticalAlignment(SwingConstants.TOP);
		soda.setBackground(new Color(255, 145, 77));
		soda.setBounds(0,100, 220, 100);
		soda.setBorderPainted(false);
		soda.setEnabled(false);
		drink.add(soda);
		
		waterCombo = new JButton("COMBO 2 WATER");
		waterCombo.setFont(new Font("STXinwei", Font.BOLD, 21));
		waterCombo.setVerticalAlignment(SwingConstants.TOP);
		waterCombo.setBackground(new Color(134, 197, 213));
		waterCombo.setBounds(0,200, 220, 100);
		waterCombo.setBorderPainted(false);
		waterCombo.setEnabled(false);
		drink.add(waterCombo);
		
		food = new JPanel();
		food.setLayout(null);
		food.setBounds(100, 90, 220, 300);
		
		ccheese = new JCheckBox("");
		ccheese.setBounds(100, 50, 93, 21);
		ccheese.setBackground(new Color(255, 189, 89));
		food.add(ccheese);
		
		ccaramel = new JCheckBox("");
		ccaramel.setBounds(100, 150, 93, 21);
		ccaramel.setBackground(new Color(255, 145, 77));
		food.add(ccaramel);
		
		cnormalCombo = new JCheckBox("");
		cnormalCombo.setBounds(100, 250, 93, 21);
		cnormalCombo.setBackground(new Color(255, 226, 0));
		food.add(cnormalCombo);
		
		
		cheese = new JButton("CHEESE");
		cheese.setFont(new Font("STXinwei", Font.BOLD, 25));
		cheese.setVerticalAlignment(SwingConstants.TOP);
		cheese.setBackground(new Color(255, 189, 89));
		cheese.setBounds(0,0, 220, 100);
		cheese.setBorderPainted(false);
		cheese.setEnabled(false);
		food.add(cheese);
		
		caramel = new JButton("CARAMEL");
		caramel.setFont(new Font("STXinwei", Font.BOLD, 25));
		caramel.setVerticalAlignment(SwingConstants.TOP);
		caramel.setBackground(new Color(255, 145, 77));
		caramel.setBounds(0,100, 220, 100);
		caramel.setBorderPainted(false);
		caramel.setEnabled(false);
		food.add(caramel);
		
		normalCombo = new JButton("COMBO 2 NORMAL");
		normalCombo.setFont(new Font("STXinwei", Font.BOLD, 19));
		normalCombo.setVerticalAlignment(SwingConstants.TOP);
		normalCombo.setBackground(new Color(255, 226, 0));
		normalCombo.setBounds(0,200, 220, 100);
		normalCombo.setBorderPainted(false);
		normalCombo.setEnabled(false);
		food.add(normalCombo);
		
		contentPane.add(food);
		contentPane.add(drink);
		
		cwaterCombo.setText("Combo 2 Nước Lọc");
		cwaterCombo.setForeground(new Color(255, 255,255,0));
		ccheese.setText("Bắp Phô Mai");
		ccheese.setForeground(new Color(255, 255,255,0));
		ccaramel.setText("Bắp Caramel");
		ccaramel.setForeground(new Color(255, 255,255,0));
		ccoca.setText("Coca-cola");
		ccoca.setForeground(new Color(255, 255,255,0));
		csoda.setText("Soda");
		csoda.setForeground(new Color(255, 255,255,0));
		cnormalCombo.setText("Combo 2 Bắp Ngọt");
		cnormalCombo.setForeground(new Color(255, 255,255,0));
		
		JButton next = new JButton("→");
		next.setFont(new Font("Arial", Font.BOLD, 70));
		next.setBackground(new Color(238, 232, 221));
		next.setBorderPainted(false);
		next.setBounds(658, 393, 118, 60);
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				xu_li_checkb(ccaramel);
				xu_li_checkb(ccheese);
				xu_li_checkb(cnormalCombo);
				xu_li_checkb(ccoca);		
				xu_li_checkb(csoda);
				xu_li_checkb(cwaterCombo);				
				
				hoantatThongTinVe ht = new hoantatThongTinVe();
				setVisible(false);
				ht.setVisible(true);
				
			}
		});
		contentPane.add(next);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\toolkit.png"));
		logo.setBounds(150, 70, 512, 512);
		logo.setBackground(new Color(255,255,255,255));
		contentPane.add(logo);
		
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java old\\Do_An_Co_So_2\\image\\ChairBackground.png"));
		Background.setBounds(0, 0, 1035, 703);
		contentPane.add(Background);
		
	}
	
	public void tf_size(JTextField a) {
		a.setSize(60 , 50);
		a.setBackground(new Color(255, 241, 192));;
		a.setText("0");
		contentPane.add(a);
	}
	private int stt=1;
	public void xu_li_checkb(JCheckBox cb) {
		
		int ch, cr, w2, co, so, n2, sl=0;
		ch = Integer.parseInt(cheesetf.getText());
		cr = Integer.parseInt(carameltf.getText());
		n2 = Integer.parseInt(n2tf.getText());
		co = Integer.parseInt(cocatf.getText());
		so = Integer.parseInt(sodatf.getText());
		w2 = Integer.parseInt(w2tf.getText());
		
		switch (cb.getText()) {
			case "Combo 2 Nước Lọc":{
				sl=w2;
				break;
			}
			case "Bắp Phô Mai":{
				sl=ch;
				break;
			}
			case "Bắp Caramel":{
				sl=cr;
				break;
			}
			case "Coca-cola":{
				sl=co;
				break;
			}
			case "Soda":{
				sl=so;
				break;
			}
			case "Combo 2 Bắp Ngọt":{
				sl=n2;
				break;
			}
		}
		
		if (cb.isSelected()&& sl!=0) {
			Connection c = null;
			
			try {
				
				c = jdbc_new.getConnection();
				
				Statement st = c.createStatement();
				
				String sql = "INSERT INTO doan_dagoi(stt, tenThucAn, soLuong)"
						+ "VALUES ("+stt+",'"+cb.getText()+"',"+sl+")";
				
				int check = st.executeUpdate(sql);
				
				jdbc_new.closeConnection(c);
				
				stt++;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
