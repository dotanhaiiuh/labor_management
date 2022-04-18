package class_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class QuanLy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_7;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLy frame = new QuanLy();
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
	public QuanLy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuanLy.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setTitle("Qu\u1EA3n l\u00ED ph\u00E2n c\u00F4ng Lao \u0110\u1ED9ng version 1.0.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 699, 560);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ph\u00E2n C\u00F4ng C\u00F4ng Tr\u00ECnh", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLUE);
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Th\u00F4ng Tin Nh\u00E2n Vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBounds(0, 0, 253, 532);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblMNhnVin.setBounds(10, 25, 85, 26);
		panel_2.add(lblMNhnVin);
		
		textField = new JTextField();
		textField.setBounds(10, 52, 233, 26);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblTnNhnVin = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn: ");
		lblTnNhnVin.setBounds(10, 89, 85, 26);
		panel_2.add(lblTnNhnVin);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 115, 233, 26);
		panel_2.add(textField_1);
		
		JLabel lblCcCngTrnh = new JLabel("C\u00E1c c\u00F4ng tr\u00ECnh \u0111ang tham gia: ");
		lblCcCngTrnh.setBounds(10, 152, 176, 26);
		panel_2.add(lblCcCngTrnh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 233, 134);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("T\u1ED5ng:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(150, 334, 46, 26);
		panel_2.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 334, 46, 23);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblChnCngTrnh = new JLabel("Ch\u1ECDn c\u00F4ng tr\u00ECnh mu\u1ED1n th\u00EAm: ");
		lblChnCngTrnh.setBounds(10, 371, 176, 26);
		panel_2.add(lblChnCngTrnh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 408, 233, 35);
		panel_2.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setIcon(new ImageIcon("Data/icons8-delete-26.png"));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(73, 470, 103, 40);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Chi Ti\u1EBFt C\u00F4ng Tr\u00ECnh", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setBounds(263, 0, 431, 447);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 c\u00F4ng tr\u00ECnh:");
		lblNewLabel_1.setBounds(10, 33, 84, 28);
		panel_3.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 33, 317, 28);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTnCngTrnh = new JLabel("T\u00EAn c\u00F4ng tr\u00ECnh:");
		lblTnCngTrnh.setBounds(10, 72, 84, 28);
		panel_3.add(lblTnCngTrnh);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(104, 72, 317, 28);
		panel_3.add(textField_4);
		
		JLabel lblaim = new JLabel("\u0110\u1ECBa \u0111i\u1EC3m:");
		lblaim.setBounds(10, 111, 84, 28);
		panel_3.add(lblaim);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(104, 111, 317, 28);
		panel_3.add(textField_5);
		
		JLabel lblNgyCpPhp = new JLabel("Ng\u00E0y c\u1EA5p ph\u00E9p:");
		lblNgyCpPhp.setBounds(10, 150, 104, 28);
		panel_3.add(lblNgyCpPhp);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(104, 150, 317, 28);
		panel_3.add(textField_6);
		
		JLabel lblNgyKhiCng = new JLabel("Ng\u00E0y kh\u1EDFi c\u00F4ng:");
		lblNgyKhiCng.setBounds(10, 189, 104, 28);
		panel_3.add(lblNgyKhiCng);
		
		JLabel lblNgyHonThnh = new JLabel("Ng\u00E0y ho\u00E0n th\u00E0nh d\u1EF1 ki\u1EBFn:");
		lblNgyHonThnh.setBounds(10, 228, 147, 28);
		panel_3.add(lblNgyHonThnh);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(167, 228, 254, 28);
		panel_3.add(textField_8);
		
		JLabel lblTngChiPh = new JLabel("T\u1ED5ng chi ph\u00ED:");
		lblTngChiPh.setForeground(Color.RED);
		lblTngChiPh.setBounds(10, 267, 147, 28);
		panel_3.add(lblTngChiPh);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(104, 267, 317, 28);
		panel_3.add(textField_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(104, 193, 317, 28);
		panel_3.add(textField_7);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Data/icons8-edit-property-64.png"));
		label.setBounds(30, 352, 64, 64);
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(263, 458, 421, 63);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Ch\u1ECDn");
		btnNewButton.setIcon(new ImageIcon("Data/icons8-plus-24.png"));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(43, 11, 131, 41);
		panel_4.add(btnNewButton);
		
		JButton btnBChn = new JButton("B\u1ECF ch\u1ECDn");
		btnBChn.setIcon(new ImageIcon("Data/icons8-indeterminate-checkbox-24.png"));
		btnBChn.setForeground(Color.GRAY);
		btnBChn.setBounds(246, 11, 131, 41);
		panel_4.add(btnBChn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Qu\u1EA3n L\u00ED C\u00F4ng", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Chi Ti\u1EBFt Gi\u1EDD C\u00F4ng", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_5.setBounds(0, 0, 694, 287);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 674, 255);
		panel_5.add(scrollPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u1ED5ng s\u1ED1 gi\u1EDD c\u00F4ng c\u1EE7a c\u00E1c c\u00F4ng tr\u00ECnh:");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 290, 225, 28);
		panel_1.add(lblNewLabel_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(245, 290, 46, 28);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Data/icons8-calendar-100.png"));
		label_1.setBounds(584, 415, 100, 106);
		panel_1.add(label_1);
	}
}
