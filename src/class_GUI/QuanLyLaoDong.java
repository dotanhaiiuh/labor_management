package class_GUI;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import class_ConnectDB.ConnectDB;
import class_DAO.CongTrinh_DAO;
import class_DAO.NhanVien_DAO;
import class_DAO.PhongBan_DAO;
import class_DAO.QLCongTrinhNhanVien_DAO;
import class_Entity.CongTrinh;
import class_Entity.NhanVien;
import class_Entity.PhongBan;
import class_Entity.QLCongTrinhNhanVien;
import class_Enum.LoaiNV;
import class_Enum.TrinhDo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class QuanLyLaoDong extends JFrame implements MouseListener{

	private JPanel contentPane;
	JTabbedPane tabbedPane1;
    int numTabs;
	public Panel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_14;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	
	private List<CongTrinh> listCT;
	private List<NhanVien> listNV;
	private List<PhongBan> listPB;
	private List<QLCongTrinhNhanVien> listNVCT;
	private CongTrinh_DAO ct_dao;
	private NhanVien_DAO nv_dao;
	private PhongBan_DAO pb_dao;
	private QLCongTrinhNhanVien_DAO qlctnv_dao;
	private DefaultTableModel modelCongTrinh;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private DefaultTableModel modelNhanVien;
	private JTextField textField_13;
	private JTextField textField_24;
	private DefaultComboBoxModel<LoaiNV> cbbLNV;
	private DefaultComboBoxModel<TrinhDo> cbbTD;
	private DefaultComboBoxModel<String> cbbLPB;
	private QL_DangNhap qldn = new QL_DangNhap();
	private DefaultComboBoxModel<TrinhDo> cbbTD1;
	private DefaultComboBoxModel<String> cbbLPB1;
	private DefaultComboBoxModel<LoaiNV> cbbLNV1;
	private DefaultComboBoxModel<String> cbbLCT;
	private JComboBox comboBox_5;
	private JComboBox comboBox_10;
	private JComboBox comboBox_7;
	private JComboBox comboBox_1;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_9;
	private JTable tbct;
	private JTable tbnv;
	private DefaultComboBoxModel<String> cbbLCT1;
	private JButton btnNewButton;
	private JButton button_7;
	private static String maNV1;
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen(String maNV) 
	{
		maNV1 = maNV;
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					QuanLyLaoDong frame = new QuanLyLaoDong();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
		});		
	}

	/**
	 * Create the frame.
	 */
	public QuanLyLaoDong()
	{
		ConnectDB.getInstance().connect();
		ct_dao = new CongTrinh_DAO();
		nv_dao = new NhanVien_DAO();
		pb_dao = new PhongBan_DAO();
		qlctnv_dao = new QLCongTrinhNhanVien_DAO();
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuanLyLaoDong.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 629);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 0, 929, 590);
		contentPane.add(tabbedPane);
		
		Panel panel = new Panel();
		tabbedPane.addTab("Hệ Thống", null, panel, "Hệ Thống");
		panel.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_13.setBounds(703, 0, 219, 559);
		panel.add(panel_13);
		panel_13.setLayout(null);
		
		JButton btnBoCo = new JButton("Báo Cáo");
		btnBoCo.setBackground(Color.WHITE);
		btnBoCo.setForeground(Color.RED);
		btnBoCo.setBounds(21, 11, 170, 32);
		panel_13.add(btnBoCo);
		
		JButton btnThngBo = new JButton("Thông Báo");
		btnThngBo.setBackground(Color.WHITE);
		btnThngBo.setForeground(Color.RED);
		btnThngBo.setBounds(21, 54, 170, 32);
		panel_13.add(btnThngBo);
		
		JButton btnThngK = new JButton("Thống Kê");
		btnThngK.setBackground(Color.WHITE);
		btnThngK.setForeground(Color.RED);
		btnThngK.setBounds(21, 97, 170, 32);
		panel_13.add(btnThngK);
		
		JButton btnSaoLu = new JButton("Sao Lưu");
		btnSaoLu.setBackground(Color.WHITE);
		btnSaoLu.setForeground(Color.RED);
		btnSaoLu.setBounds(21, 140, 170, 32);
		panel_13.add(btnSaoLu);
		
		JButton btnPhcHi = new JButton("Phục Hồi");
		btnPhcHi.setBackground(Color.WHITE);
		btnPhcHi.setForeground(Color.RED);
		btnPhcHi.setBounds(21, 183, 170, 32);
		panel_13.add(btnPhcHi);
		
		panel_1 = new Panel();
		tabbedPane.addTab("Quản lí công trình", null, panel_1, "Quản lí công trình");
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Khung nhập liệu");
		panel_4.setForeground(Color.BLUE);
		panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Khung nh\u1EADp li\u1EC7u", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_4.setBounds(0, 0, 715, 251);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		panel_4.addMouseListener(new MouseListener() 
		{
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField.setEditable(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Mã Công Trình:");
		lblNewLabel.setBounds(10, 32, 92, 26);
		panel_4.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(102, 32, 585, 26);
		textField.setEditable(false);
		panel_4.add(textField);
		textField.setColumns(10);
		textField.addMouseListener(new MouseListener() 
		{
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField.setEditable(true);
			}
		});
		
		JLabel lblTnCngTrnh = new JLabel("Tên Công Trình:");
		lblTnCngTrnh.setBounds(10, 69, 92, 26);
		panel_4.add(lblTnCngTrnh);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 69, 585, 26);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Địa Điểm:");
		lblNewLabel_1.setBounds(10, 106, 92, 26);
		panel_4.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 106, 585, 26);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNgyCpPhp = new JLabel("Ngày Cấp Phép:");
		lblNgyCpPhp.setBounds(10, 143, 92, 26);
		panel_4.add(lblNgyCpPhp);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 143, 226, 26);
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNgyKhiCng = new JLabel("Ngày Khởi Công:");
		lblNgyKhiCng.setBounds(338, 143, 99, 26);
		panel_4.add(lblNgyKhiCng);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(435, 143, 252, 26);
		panel_4.add(textField_4);
		
		JLabel lblNgyHonThnh = new JLabel("Ngày Hoàn Thành Dự Kiến:");
		lblNgyHonThnh.setBounds(10, 180, 169, 26);
		panel_4.add(lblNgyHonThnh);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 180, 328, 26);
		panel_4.add(textField_5);
		
		JLabel lblTngCihiPh = new JLabel("Tổng Chi Phí:");
		lblTngCihiPh.setForeground(Color.RED);
		lblTngCihiPh.setBounds(10, 214, 82, 26);
		panel_4.add(lblTngCihiPh);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(102, 217, 404, 26);
		panel_4.add(textField_6);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Data/icons8-literature-50.png"));
		label.setBounds(637, 180, 50, 50);
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.BLUE);
		panel_5.setToolTipText("Tìm kiếm thông tin");
		panel_5.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "T\u00ECm ki\u1EBFm th\u00F4ng tin", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_5.setBounds(725, 0, 197, 251);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNhpThngTin = new JLabel("Nhập thông tin cần tìm:");
		lblNhpThngTin.setBounds(10, 31, 135, 25);
		panel_5.add(lblNhpThngTin);
		
		String[] headers4 = {"MaCT", "TenCT", "DiaDiem", "NgayCapGP", "NgayKC", "NgayHTDuKien", "TongChiPhiDuKien"};		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 67, 177, 26);
		panel_5.add(textField_7);
		textField_7.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int dem=0;
				String string;
				string = textField_7.getText().trim();
				for(CongTrinh ct : listCT) 
				{
					if(ct.getMaCT().trim().equalsIgnoreCase(string)) {
						searchTableDataCT(headers4, ct.getMaCT().trim());
						dem++;
						break;
					}
				}
				if(dem==0) {
					updateTableDataCT(headers4);
					JOptionPane.showMessageDialog(null, "Không tồn tại!");
				}	
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Data/icons8-search-24.png"));
		lblNewLabel_2.setBounds(155, 31, 32, 25);
		panel_5.add(lblNewLabel_2);
		
		ButtonGroup bgroup1 = new ButtonGroup();
		
		JRadioButton rdbtnTmTheoM = new JRadioButton("Tìm theo mã công trình");
		rdbtnTmTheoM.setBounds(10, 100, 157, 23);
		panel_5.add(rdbtnTmTheoM);
		rdbtnTmTheoM.setSelected(true);
		
		JRadioButton rdbtnTmTheoTn_1 = new JRadioButton("Tìm theo tên công trình");
		rdbtnTmTheoTn_1.setBounds(10, 126, 157, 23);
		panel_5.add(rdbtnTmTheoTn_1);
		
		bgroup1.add(rdbtnTmTheoM);
		bgroup1.add(rdbtnTmTheoTn_1);
		
		btnNewButton = new JButton("Tìm Kiếm");
		btnNewButton.setIcon(new ImageIcon("Data/icons8-search-24.png"));
		btnNewButton.setBounds(43, 192, 115, 26);
		panel_5.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dem=0;
				String string;
				string = textField_7.getText().trim();
				for(CongTrinh ct : listCT)
				{
					if(ct.getMaCT().trim().equalsIgnoreCase(string)) {
						searchTableDataCT(headers4, ct.getMaCT().trim());
						dem++;
						break;
					}
				}
				if(dem==0) 
				{
					updateTableDataCT(headers4);
					JOptionPane.showMessageDialog(null, "Không tồn tại!");
				}
			}
		});
		
		JScrollPane scrollPane_5;
		String[] headers = {"MaCT", "TenCT", "DiaDiem", "NgayCapGP", "NgayKC", "NgayHTDuKien", "TongChiPhiDuKien"};
		modelCongTrinh = new DefaultTableModel(headers, 0);
		tbct = new JTable(modelCongTrinh);
		tbct.setFillsViewportHeight(true);
		tbct.setForeground(new Color(255, 69, 0));
		scrollPane_5 = new JScrollPane(tbct);
		scrollPane_5.setBounds(0, 262, 922, 222);
		panel_1.add(scrollPane_5);
		tbct.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField.setEditable(false);
			}
		});
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBounds(10, 495, 902, 54);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Thêm Công Trình");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String maCT = textField.getText().trim();
				String tenCT = textField_1.getText().trim();
				String diaDiem = textField_2.getText().trim(); 				
				Date ngayCapGP=null;
				try 
				{
					ngayCapGP = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_3.getText().trim());
				} 
				catch (ParseException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Date ngayKhoiCong=null;
				try 
				{
					ngayKhoiCong = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_4.getText().trim());
				} 
				catch (ParseException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Date ngayHTDuKien=null;
				try 
				{
					ngayHTDuKien = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_5.getText().trim());
				} 
				catch (ParseException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				float tongChiPhiDuKien = Float.parseFloat(textField_6.getText());
				CongTrinh ct = new CongTrinh(maCT, tenCT, diaDiem, ngayCapGP, ngayKhoiCong, ngayHTDuKien, tongChiPhiDuKien);
				try 
				{
					if (!ct_dao.create(ct))
						throw new Exception();
					modelCongTrinh.addRow(new Object[] {ct.getMaCT(), ct.getTenCT(), ct.getDiaDiem(), ct.getNgayCapGP().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter),
							ct.getNgayKhoiCong().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter),
							ct.getNgayHTDuKien().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter), 
							ct.getTongChiPhi()});
				} 
				catch (Exception e1) 
				{
					JOptionPane.showMessageDialog(null, "Trùng");
				}
			}
		});
		
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setIcon(new ImageIcon("Data/icons8-plus-24.png"));
		btnNewButton_1.setBounds(10, 11, 170, 32);
		panel_6.add(btnNewButton_1);
	
		JButton btnNewButton_2 = new JButton("Xóa Công Trình");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int row = tbct.getSelectedRow();
				if(row != -1) 
				{
					String maCT = modelCongTrinh.getValueAt(row, 0).toString();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try 
						{
							if (!ct_dao.delete(maCT))
								throw new Exception();
							modelCongTrinh.removeRow(row);
							JOptionPane.showMessageDialog(null,"Đã Xóa 1 Công Trình!");
						} 
						catch (Exception e1) 
						{
							JOptionPane.showMessageDialog(null, "Không thể xóa CT đang hoạt động!");
						}			
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 công trình!");
				}
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setIcon(new ImageIcon("Data/icons8-delete-26.png"));
		btnNewButton_2.setBounds(190, 11, 165, 32);
		panel_6.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thay đổi Thông Tin");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int row = tbct.getSelectedRow();
				if(row != -1)
				{
					String maCT = modelCongTrinh.getValueAt(row, 0).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) 
					{
						for(CongTrinh i : listCT) 
						{
							if(i.getMaCT().trim().equalsIgnoreCase(maCT)) {
								String maCT1 = textField.getText().trim();
								String tenCT = textField_1.getText().trim();
								String diaDiem = textField_2.getText().trim(); 
								
								Date ngayCapGP=null;
								try 
								{
									ngayCapGP = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_3.getText().trim());
									
								} 
								catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								Date ngayKhoiCong=null;
								try 
								{
									ngayKhoiCong = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_4.getText().trim());
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								Date ngayHTDuKien=null;
								try {
									ngayHTDuKien = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_5.getText().trim());
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}	
								
								float tongChiPhiDuKien = Float.parseFloat(textField_6.getText());
								CongTrinh ct = new CongTrinh(maCT1, tenCT, diaDiem, ngayCapGP, ngayKhoiCong, ngayHTDuKien, tongChiPhiDuKien);
								try {
									if (!ct_dao.update(ct))
										throw new Exception();
									updateTableDataCT(headers);								
									JOptionPane.showMessageDialog(null,"Đã Sửa 1 Công Trình!");
								} 
								catch (Exception e1)
								{
									JOptionPane.showMessageDialog(null, "Không thể sửa!");
								}
								break;
							}
						}	
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 công trình!");
				}
			}
		});
		
		btnNewButton_3.setIcon(new ImageIcon("Data/icons8-edit-24.png"));
		btnNewButton_3.setBounds(365, 11, 183, 32);
		panel_6.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(751, 11, 141, 32);
		panel_6.add(comboBox);
		
		JButton btnXaTrng = new JButton("Xóa Trắng");
		btnXaTrng.setIcon(new ImageIcon("Data/icons8-clear-formatting-24.png"));
		btnXaTrng.setBounds(558, 11, 183, 32);
		panel_6.add(btnXaTrng);
		btnXaTrng.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearTextfieldsCT();
			}
		});
		
		DocDuLieuCTDatabaseVaoTable();
		
		Panel panel_2 = new Panel();
		tabbedPane.addTab("Quản lí lao động", null, panel_2, "Quản lí lao động");
		panel_2.setLayout(null);
		
		Panel panel_7 = new Panel();
		panel_7.setBounds(0, 0, 922, 559);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 0, 715, 251);
		panel_8.setToolTipText("Khung nhập liệu");
		panel_8.setForeground(Color.BLUE);
		panel_8.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Khung nh\u1EADp li\u1EC7u", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		panel_8.addMouseListener(new MouseListener() 
		{
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField_8.setEditable(false);
			}
		});
		
		JLabel lblMLaong = new JLabel("Mã Nhân Viên:");
		lblMLaong.setBounds(10, 32, 92, 26);
		panel_8.add(lblMLaong);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(102, 32, 176, 26);
		textField_8.setColumns(10);
		panel_8.add(textField_8);
		textField_8.addMouseListener(new MouseListener()
		{
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField_8.setEditable(true);
			}
		});
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setBounds(10, 69, 92, 26);
		panel_8.add(lblNgySinh);
		
		textField_9 = new JTextField();
		textField_9.setBounds(102, 69, 176, 26);
		textField_9.setColumns(10);
		panel_8.add(textField_9);
		
		JLabel lblaChThng = new JLabel("Địa Chỉ Thường Trú:");
		lblaChThng.setBounds(288, 69, 129, 26);
		panel_8.add(lblaChThng);
		
		textField_10 = new JTextField();
		textField_10.setBounds(427, 69, 265, 26);
		textField_10.setColumns(10);
		panel_8.add(textField_10);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setBounds(10, 106, 92, 26);
		panel_8.add(lblSinThoi);
		
		textField_11 = new JTextField();
		textField_11.setBounds(102, 106, 176, 26);
		textField_11.setColumns(10);
		panel_8.add(textField_11);
		
		JLabel lblaChMail = new JLabel("Địa Chỉ Mail:");
		lblaChMail.setBounds(288, 106, 75, 26);
		panel_8.add(lblaChMail);
		
		textField_12 = new JTextField();
		textField_12.setBounds(382, 106, 234, 26);
		textField_12.setColumns(10);
		panel_8.add(textField_12);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(636, 180, 50, 50);
		label_8.setIcon(new ImageIcon("Data/icons8-literature-50.png"));
		panel_8.add(label_8);
		
		JLabel lblNewLabel_3 = new JLabel("Họ:");
		lblNewLabel_3.setBounds(288, 32, 43, 26);
		panel_8.add(lblNewLabel_3);
		
		textField_16 = new JTextField();
		textField_16.setBounds(341, 32, 158, 26);
		panel_8.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblTn = new JLabel("Tên:");
		lblTn.setBounds(505, 32, 43, 26);
		panel_8.add(lblTn);
		
		textField_17 = new JTextField();
		textField_17.setBounds(558, 32, 134, 26);
		textField_17.setColumns(10);
		panel_8.add(textField_17);
		
		JLabel lblNgyVoLm = new JLabel("Ngày Vào Làm:");
		lblNgyVoLm.setBounds(10, 143, 88, 26);
		panel_8.add(lblNgyVoLm);
		
		textField_18 = new JTextField();
		textField_18.setBounds(102, 143, 176, 26);
		textField_18.setColumns(10);
		panel_8.add(textField_18);
		
		JLabel lblTrnh = new JLabel("Trình Độ:");
		lblTrnh.setBounds(288, 143, 70, 26);
		panel_8.add(lblTrnh);
		
		cbbTD = new DefaultComboBoxModel<TrinhDo>(TrinhDo.values());
		comboBox_1 = new JComboBox(cbbTD);
		comboBox_1.setBounds(382, 143, 234, 26);
		panel_8.add(comboBox_1);
		
		JLabel lblSNgyCng = new JLabel("Số Ngày Công:");
		lblSNgyCng.setBounds(288, 180, 94, 26);
		panel_8.add(lblSNgyCng);
		
		textField_14 = new JTextField();
		textField_14.setBounds(382, 180, 63, 26);
		textField_14.setColumns(10);
		panel_8.add(textField_14);
		
		JLabel lblMCngTrnh = new JLabel("Mã CT:");
		lblMCngTrnh.setBounds(10, 217, 57, 26);
		lblMCngTrnh.setForeground(Color.BLUE);
		panel_8.add(lblMCngTrnh);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(102, 217, 176, 26);
		panel_8.add(comboBox_3);
		
		JLabel lblNewLabel_4 = new JLabel("Loại NV:");
		lblNewLabel_4.setBounds(455, 180, 59, 26);
		panel_8.add(lblNewLabel_4);
		
		cbbLNV = new DefaultComboBoxModel<LoaiNV>(LoaiNV.values());
		comboBox_4 = new JComboBox(cbbLNV);
		comboBox_4.setBounds(524, 180, 92, 26);
		panel_8.add(comboBox_4);
		
		JLabel lblMPb = new JLabel("Mã PB:");
		lblMPb.setBounds(10, 180, 50, 26);
		panel_8.add(lblMPb);
		
		DocDuLieuPBDatabaseVaoTable();
		
		cbbLPB = new DefaultComboBoxModel<String>();
		for(int i=0; i<listPB.size(); i++)
		{
			cbbLPB.addElement(listPB.get(i).getMaPB().trim());
		}
		comboBox_9 = new JComboBox(cbbLPB);
		comboBox_9.setBounds(102, 180, 176, 26);
		panel_8.add(comboBox_9);
		
		JLabel lblNewLabel_5 = new JLabel("Lương:");
		lblNewLabel_5.setBounds(288, 216, 70, 27);
		panel_8.add(lblNewLabel_5);
		
		textField_13 = new JTextField();
		textField_13.setBounds(382, 217, 234, 26);
		textField_13.setColumns(10);
		panel_8.add(textField_13);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(725, 0, 197, 251);
		panel_9.setLayout(null);
		panel_9.setToolTipText("Tìm kiếm thông tin");
		panel_9.setForeground(Color.BLUE);
		panel_9.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "T\u00ECm ki\u1EBFm th\u00F4ng tin", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_7.add(panel_9);
		
		JLabel label_9 = new JLabel("Nhập thông tin cần tìm:");
		label_9.setBounds(10, 31, 135, 25);
		panel_9.add(label_9);

		String[] headers5 = new String[] {"MaNV", "HoNV", "TenNV", "NgaySinh", "DiaChiThuongTru", "SoDienThoai", "DiaChiMail", "NgayVaoLam", "TrinhDo", "MaPB", "SoNgayCong", "LoaiNV", "Luong"};
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(10, 67, 177, 26);
		panel_9.add(textField_15);
		textField_15.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				int dem=0;
				String string;
				string = textField_15.getText().trim();
				for(NhanVien ct : listNV) 
				{
					if(ct.getMaNV().trim().equalsIgnoreCase(string)) 
					{
						searchTableDataNV(headers5, ct.getMaNV().trim());
						dem++;
						break;
					}
				}
				if(dem==0) 
				{
					updateTableDataNV(headers5);
					JOptionPane.showMessageDialog(null, "Không tồn tại!");
				}
			}
		});
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("Data/icons8-search-24.png"));
		label_10.setBounds(155, 31, 32, 25);
		panel_9.add(label_10);
		
		ButtonGroup bgroup = new ButtonGroup();
		
		JRadioButton rdbtnTmTheoM_1 = new JRadioButton("Tìm theo mã nhân viên");
		rdbtnTmTheoM_1.setBounds(10, 100, 157, 23);
		panel_9.add(rdbtnTmTheoM_1);
		rdbtnTmTheoM_1.setSelected(true);
		
		JRadioButton rdbtnTmTheoTn = new JRadioButton("Tìm theo tên nhân viên");
		rdbtnTmTheoTn.setBounds(10, 126, 157, 23);
		panel_9.add(rdbtnTmTheoTn);
		
		bgroup.add(rdbtnTmTheoM_1);
		bgroup.add(rdbtnTmTheoTn);
		
		JButton button_4 = new JButton("Tìm Kiếm");
		button_4.setIcon(new ImageIcon("Data/icons8-search-24.png"));
		button_4.setBounds(43, 192, 115, 26);
		panel_9.add(button_4);
		button_4.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dem=0;
				String string;
				string = textField_15.getText().trim();
				for(NhanVien ct : listNV)
				{
					if(ct.getMaNV().trim().equalsIgnoreCase(string)) {
						searchTableDataNV(headers5, ct.getMaNV().trim());
						dem++;
						break;
					}
				}
				if(dem==0) 
				{
					updateTableDataNV(headers5);
					JOptionPane.showMessageDialog(null, "Không tồn tại!");
				}
			}
		});
		
		String[] headers1 = new String[] {"MaNV", "HoNV", "TenNV", "NgaySinh", "DiaChiThuongTru", "SoDienThoai", "DiaChiMail", "NgayVaoLam", "TrinhDo", "MaPB", "SoNgayCong", "LoaiNV", "Luong"};
		modelNhanVien = new DefaultTableModel(headers1, 0);
		tbnv = new JTable(modelNhanVien);
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(0, 262, 922, 222);
		scrollPane_6.setEnabled(false);
		scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel_7.add(scrollPane_6);		
		tbnv.setFillsViewportHeight(true);
		tbnv.setSurrendersFocusOnKeystroke(true);
		tbnv.setForeground(new Color(255, 69, 0));
		tbnv.setBorder(new LineBorder(new Color(0, 191, 255)));
		scrollPane_6.setViewportView(tbnv);
		tbnv.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField_8.setEditable(false);
			}
		});
		
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(10, 495, 902, 54);
		panel_10.setLayout(null);
		panel_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.add(panel_10);
		
		JButton btnThmLaong = new JButton("Thêm Nhân Viên");
		btnThmLaong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String trinhdo = null;
				String loainv = null;
				String maNV = textField_8.getText().trim();
				String hoNV = textField_16.getText().trim();
				String tenNV = textField_17.getText().trim();	
				Date ngaySinh=null;
				try 
				{
					ngaySinh = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_9.getText().trim());
				} 
				catch (ParseException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String diaChiThuongTru = textField_10.getText().trim();	
				String soDienThoai = textField_11.getText().trim();
				String diaChiMail = textField_12.getText().trim();
				Date ngayVaoLam=null;
				try {
					ngayVaoLam = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_18.getText().trim());
				} catch (ParseException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TrinhDo trinhDo = TrinhDo.valueOf(comboBox_1.getSelectedItem().toString());
				String maPB = comboBox_9.getSelectedItem().toString();
				int soNgayCong = Integer.parseInt(textField_14.getText().trim());
				LoaiNV loaiNV = LoaiNV.valueOf(comboBox_4.getSelectedItem().toString());
				float luong = Float.parseFloat(textField_13.getText().trim());				
				NhanVien ct = new NhanVien(maNV, hoNV, tenNV, ngaySinh, diaChiThuongTru, soDienThoai, diaChiMail, ngayVaoLam, trinhDo, maPB, soNgayCong, loaiNV, luong);
				try 
				{
					if(!nv_dao.create(ct))
						throw new Exception();
					if(ct.getTrinhDo()==TrinhDo.DaiHoc)
						trinhdo = "Đại Học";
					if(ct.getTrinhDo()==TrinhDo.CaoDang)
						trinhdo = "Cao Đẳng";
					if(ct.getTrinhDo()==TrinhDo.TrungCap)
						trinhdo = "Trung Cấp";
					if(ct.getLoaiNV()==LoaiNV.CT)
						loainv = "Chính Thức";
					if(ct.getLoaiNV()==LoaiNV.TV)
						loainv = "Thời Vụ";
					modelNhanVien.addRow(new Object[] {ct.getMaNV(), ct.getHoNV(),
							ct.getTenNV(),
							LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgaySinh()), formatter).format(formatter),
							ct.getDiaChiThuongTru(),
							ct.getSoDienThoai(), ct.getDiaChiMail(),
							LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayVaoLam()), formatter).format(formatter), 
							trinhdo,
							ct.getMaPB(),
							ct.getSoNgayCong(), loainv, ct.getLuong()});
				} 
				catch (Exception e1) 
				{
					JOptionPane.showMessageDialog(null, "Trùng");
				}
			
			}
		});
		btnThmLaong.setIcon(new ImageIcon("Data/icons8-plus-24.png"));
		btnThmLaong.setForeground(Color.GREEN);
		btnThmLaong.setBounds(10, 11, 170, 32);
		panel_10.add(btnThmLaong);
		
		JButton btnXaLaong = new JButton("Xóa Nhân Viên");
		btnXaLaong.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int row = tbnv.getSelectedRow();
				if(row != -1) 
				{
					String maNV = modelNhanVien.getValueAt(row, 0).toString();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) {
						try 
						{
							if (!nv_dao.delete(maNV))
								throw new Exception();
							modelNhanVien.removeRow(row);
							JOptionPane.showMessageDialog(null,"Đã xóa 1 nhân viên!");
						} 
						catch (Exception e1) 
						{
							JOptionPane.showMessageDialog(null, "Xóa không thành công!");
						}			
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhân viên!");
				}
			}
		});
		btnXaLaong.setIcon(new ImageIcon("Data/icons8-delete-26.png"));
		btnXaLaong.setForeground(Color.RED);
		btnXaLaong.setBounds(190, 11, 165, 32);
		panel_10.add(btnXaLaong);
		
		button_7 = new JButton("Thay đổi Thông Tin");
		button_7.setIcon(new ImageIcon("Data/icons8-edit-24.png"));
		button_7.setBounds(365, 11, 183, 32);
		panel_10.add(button_7);
		button_7.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				int row = tbnv.getSelectedRow();
				if(row != -1) {
					String maNV = modelNhanVien.getValueAt(row, 0).toString().trim();
					int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(nhacnho == JOptionPane.YES_OPTION) 
					{
						for (NhanVien i : listNV)
						{
							if(i.getMaNV().trim().equalsIgnoreCase(maNV))
							{
								String trinhdo = null;
								String loainv = null;
								String maNV1 = textField_8.getText().trim();
								String hoNV = textField_16.getText().trim();
								String tenNV = textField_17.getText().trim();	
								Date ngaySinh=null;
								try 
								{
									ngaySinh = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_9.getText().trim());
								} catch (ParseException e1) 
								{
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								String diaChiThuongTru = textField_10.getText().trim();	
								String soDienThoai = textField_11.getText().trim();
								String diaChiMail = textField_12.getText().trim();
								Date ngayVaoLam=null;
								try 
								{
									ngayVaoLam = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(textField_18.getText().trim());
								} 
								catch (ParseException e1) 
								{
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								TrinhDo trinhDo = TrinhDo.valueOf(comboBox_1.getSelectedItem().toString());
								String maPB = comboBox_9.getSelectedItem().toString();
								int soNgayCong = Integer.parseInt(textField_14.getText().trim());
								LoaiNV loaiNV = LoaiNV.valueOf(comboBox_4.getSelectedItem().toString());
								//String maCT = comboBox_3.getSelectedItem().toString();
								float luong = Float.parseFloat(textField_13.getText().trim());				
								NhanVien ct = new NhanVien(maNV, hoNV, tenNV, ngaySinh, diaChiThuongTru, soDienThoai, diaChiMail, ngayVaoLam, trinhDo, maPB, soNgayCong, loaiNV, luong);
								try 
								{
									if (!nv_dao.update(ct))
										throw new Exception();
									updateTableDataNV(headers1);								
									JOptionPane.showMessageDialog(null,"Đã sửa 1 nhân viên!");
								} 
								catch (Exception e1) 
								{
									JOptionPane.showMessageDialog(null, "Không thể sửa!");
								}
								break;
							}
						}	
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 công trình!");
				}
			}
		});
		
		
		JButton btnNewButton_4 = new JButton("Quản Lí");
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				QuanLy ql = new QuanLy();
				ql.NewScreen();
			}
		});
		
		btnNewButton_4.setIcon(new ImageIcon("Data/icons8-business-24.png"));
		btnNewButton_4.setBounds(558, 11, 183, 32);
		panel_10.add(btnNewButton_4);
		
		JButton button = new JButton("Xóa Trắng");
		button.setIcon(new ImageIcon("Data/icons8-clear-formatting-24.png"));
		button.setBounds(751, 11, 141, 32);
		panel_10.add(button);
		button.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearTextfieldsNV();
			}
		});
		
		DocDuLieuNVDatabaseVaoTable();
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		tabbedPane.addTab("Quản lí thông tin cá nhân", null, panel_3, "Quản lí thông tin cá nhân");
		panel_3.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setToolTipText("Thông tin cá nhân");
		panel_11.setForeground(Color.BLUE);
		panel_11.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Th\u00F4ng Tin C\u00E1 Nh\u00E2n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_11.setBounds(0, 0, 924, 485);
		panel_3.add(panel_11);
		panel_11.addMouseListener(new MouseListener() 
		{
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField_22.setEditable(false);
				textField_27.setEditable(false);
				textField_23.setEditable(false);
			}
		});
		
		JLabel label_1 = new JLabel("Mã Nhân Viên:");
		label_1.setBounds(10, 32, 92, 26);
		panel_11.add(label_1);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setEditable(false);
		textField_19.setBounds(102, 32, 793, 26);
		panel_11.add(textField_19);
		
		JLabel label_2 = new JLabel("Năm Sinh:");
		label_2.setBounds(10, 106, 92, 26);
		panel_11.add(label_2);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setEditable(false);
		textField_20.setBounds(102, 106, 265, 26);
		panel_11.add(textField_20);
		
		JLabel label_3 = new JLabel("Địa Chỉ Thường Trú:");
		label_3.setBounds(10, 143, 129, 26);
		panel_11.add(label_3);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setEditable(false);
		textField_21.setBounds(102, 328, 665, 26);
		panel_11.add(textField_21);
		
		JLabel label_4 = new JLabel("Số Điện Thoại:");
		label_4.setBounds(377, 106, 92, 26);
		panel_11.add(label_4);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setEditable(false);
		textField_22.setBounds(479, 106, 288, 26);
		panel_11.add(textField_22);
		textField_22.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField_22.setEditable(true);
			}
		});
		textField_22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(nhacnho == JOptionPane.YES_OPTION) {
					try {
						if (!nv_dao.updatephonenb(textField_22.getText().trim(), maNV1))
							throw new Exception();
						updateTableDataNV(headers1);
						setTextFieldQLCN();
						JOptionPane.showMessageDialog(null,"Sửa thành công!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					}
					textField_22.setEditable(false);
				}
			}
		});
		
		JLabel label_5 = new JLabel("Địa Chỉ Mail:");
		label_5.setBounds(10, 180, 75, 26);
		panel_11.add(label_5);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setEditable(false);
		textField_23.setBounds(102, 180, 665, 26);
		panel_11.add(textField_23);
		textField_23.addMouseListener(new MouseListener() {
			
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
				//textField_23.setEditable(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField_23.setEditable(true);
			}
		});
		textField_23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(nhacnho == JOptionPane.YES_OPTION) {
					try {
						if (!nv_dao.updatemail(textField_23.getText().trim(), maNV1))
							throw new Exception();
						updateTableDataNV(headers1);
						setTextFieldQLCN();
						JOptionPane.showMessageDialog(null,"Sửa thành công!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					}
					textField_23.setEditable(false);
				}
			}
		});
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(622, 180, 50, 50);
		panel_11.add(label_7);
		
		JLabel label_11 = new JLabel("Họ:");
		label_11.setBounds(10, 69, 43, 26);
		panel_11.add(label_11);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setEditable(false);
		textField_25.setBounds(532, 69, 363, 26);
		panel_11.add(textField_25);
		
		JLabel label_12 = new JLabel("Tên:");
		label_12.setBounds(479, 69, 43, 26);
		panel_11.add(label_12);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setEditable(false);
		textField_26.setBounds(102, 69, 367, 26);
		panel_11.add(textField_26);
		
		JLabel label_13 = new JLabel("Ngày Vào Làm:");
		label_13.setBounds(10, 217, 88, 26);
		panel_11.add(label_13);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setEditable(false);
		textField_27.setBounds(138, 143, 629, 26);
		panel_11.add(textField_27);
		textField_27.addMouseListener(new MouseListener() {
			
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				textField_27.setEditable(true);
			}
		});
		textField_27.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(nhacnho == JOptionPane.YES_OPTION) {
					try {
						if (!nv_dao.updatediachi(textField_27.getText().trim(), maNV1))
							throw new Exception();
						updateTableDataNV(headers1);
						setTextFieldQLCN();
						JOptionPane.showMessageDialog(null,"Sửa thành công!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					}
					textField_27.setEditable(false);
				}
			}
		});
		
		JLabel label_14 = new JLabel("Trình Độ:");
		label_14.setBounds(10, 254, 70, 26);
		panel_11.add(label_14);
		
		
		cbbTD1 = new DefaultComboBoxModel<TrinhDo>(TrinhDo.values());
		comboBox_5 = new JComboBox(cbbTD1);
		comboBox_5.setEnabled(false);
		comboBox_5.setForeground(Color.BLUE);
		comboBox_5.setBounds(102, 254, 665, 26);
		panel_11.add(comboBox_5);
		
		JLabel lblLng = new JLabel("Lương:");
		lblLng.setBounds(10, 402, 70, 26);
		panel_11.add(lblLng);
		
		JLabel label_16 = new JLabel("Số Ngày Công:");
		label_16.setBounds(10, 328, 92, 26);
		panel_11.add(label_16);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setEditable(false);
		textField_28.setBounds(102, 217, 665, 26);
		panel_11.add(textField_28);
		
		JLabel label_17 = new JLabel("Mã Công Trình:");
		label_17.setForeground(Color.BLUE);
		label_17.setBounds(10, 439, 88, 26);
		panel_11.add(label_17);
		
		cbbLNV1 = new DefaultComboBoxModel<LoaiNV>(LoaiNV.values());
		comboBox_7 = new JComboBox(cbbLNV1);
		comboBox_7.setEnabled(false);
		comboBox_7.setBounds(102, 365, 476, 26);
		panel_11.add(comboBox_7);
		
		JLabel label_18 = new JLabel("Loại NV:");
		label_18.setBounds(10, 365, 57, 26);
		panel_11.add(label_18);
		
		DocDuLieuNVCTDatabaseVaoTable();
		cbbLCT = new DefaultComboBoxModel<String>();
		for(int i=0; i<listNVCT.size(); i++) {
			if(listNVCT.get(i).getMaNV().equals(maNV1)) {
				cbbLCT.addElement(listNVCT.get(i).getMaCT());
			}
		}
		JComboBox comboBox_8 = new JComboBox(cbbLCT);
		comboBox_8.setBounds(102, 439, 476, 26);
		panel_11.add(comboBox_8);
		
		JButton btnThayi = new JButton("Thay đổi");
		btnThayi.setIcon(new ImageIcon("Data/icons8-edit-24.png"));
		btnThayi.setForeground(Color.RED);
		btnThayi.setBounds(785, 106, 110, 26);
		panel_11.add(btnThayi);
		btnThayi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(nhacnho == JOptionPane.YES_OPTION) {
					try {
						if (!nv_dao.updatephonenb(textField_22.getText().trim(), maNV1))
							throw new Exception();
						updateTableDataNV(headers1);
						setTextFieldQLCN();
						JOptionPane.showMessageDialog(null,"Sửa thành công!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					}
					textField_22.setEditable(false);
				}
			}
		});
		
		JButton button_5 = new JButton("Thay đổi");
		button_5.setIcon(new ImageIcon("Data/icons8-edit-24.png"));
		button_5.setForeground(Color.RED);
		button_5.setBounds(785, 143, 110, 26);
		panel_11.add(button_5);
		button_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(nhacnho == JOptionPane.YES_OPTION) {
					try {
						if (!nv_dao.updatediachi(textField_27.getText().trim(), maNV1))
							throw new Exception();
						updateTableDataNV(headers1);
						setTextFieldQLCN();
						JOptionPane.showMessageDialog(null,"Sửa thành công!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					}
					textField_27.setEditable(false);
				}
			}
		});
		
		JButton button_6 = new JButton("Thay đổi");
		button_6.setIcon(new ImageIcon("Data/icons8-edit-24.png"));
		button_6.setForeground(Color.RED);
		button_6.setBounds(785, 180, 110, 26);
		panel_11.add(button_6);
		button_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int nhacnho = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(nhacnho == JOptionPane.YES_OPTION) {
					try {
						if (!nv_dao.updatemail(textField_23.getText().trim(), maNV1))
							throw new Exception();
						updateTableDataNV(headers1);
						setTextFieldQLCN();
						JOptionPane.showMessageDialog(null,"Sửa thành công!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					}
					textField_23.setEditable(false);
				}
			}
		});
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon("Data/icons8-literature-50.png"));
		label_19.setBounds(845, 402, 50, 50);
		panel_11.add(label_19);
		
		JLabel lblMPb_1 = new JLabel("Mã PB:");
		lblMPb_1.setBounds(10, 291, 70, 26);
		panel_11.add(lblMPb_1);
		
		cbbLPB1 = new DefaultComboBoxModel<String>();
		for(int i=0; i<listPB.size(); i++) {
			cbbLPB1.addElement(listPB.get(i).getMaPB());
		}
		comboBox_10 = new JComboBox(cbbLPB1);
		comboBox_10.setEnabled(false);
		comboBox_10.setBounds(102, 291, 665, 26);
		panel_11.add(comboBox_10);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setEditable(false);
		textField_24.setBounds(102, 402, 476, 26);
		panel_11.add(textField_24);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_12.setBounds(10, 497, 904, 54);
		panel_3.add(panel_12);
		
		JButton button_9 = new JButton("Quản Lí");
		button_9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				QuanLy ql = new QuanLy();
				ql.NewScreen();
			}
		});
		button_9.setForeground(Color.GREEN);
		button_9.setIcon(new ImageIcon("Data/icons8-business-24.png"));
		button_9.setBounds(10, 11, 183, 32);
		panel_12.add(button_9);
		
		JButton btnLchLmVic = new JButton(" Lịch làm việc");
		btnLchLmVic.setIcon(new ImageIcon("Data/icons8-calendar-26.png"));
		btnLchLmVic.setForeground(Color.BLACK);
		btnLchLmVic.setBounds(203, 11, 183, 32);
		panel_12.add(btnLchLmVic);
		
		JButton btnXemThngBo = new JButton("Xem thông báo");
		btnXemThngBo.setIcon(new ImageIcon("Data/icons8-bell-26.png"));
		btnXemThngBo.setForeground(Color.BLACK);
		btnXemThngBo.setBounds(396, 11, 183, 32);
		panel_12.add(btnXemThngBo);
		setLocationRelativeTo(null);
		setTitle("Quản lý Phân Công Lao Động version: 1.0.0");
		setTextFieldQLCN();
		
		textField.setEditable(false);
		
		JPanel panel_14 = new JPanel();
		tabbedPane.addTab("Trợ giúp", null, panel_14, null);
		
		tbct.addMouseListener(this);
		tbnv.addMouseListener(this);
//		textField_22.addMouseListener(this);
//		textField_23.addMouseListener(this);
//		textField_27.addMouseListener(this);
		addMouseListener(this);
	}

	public void DocDuLieuCTDatabaseVaoTable() 
	{
		listCT = ct_dao.getalltbCongTrinh();
		for (CongTrinh ct : listCT) {
			modelCongTrinh.addRow(new Object[] {ct.getMaCT(),ct.getTenCT(),
					ct.getDiaDiem(),
					LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayCapGP()), formatter).format(formatter),
					LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayKhoiCong()), formatter).format(formatter),
					LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayHTDuKien()), formatter).format(formatter),
					ct.getTongChiPhi()});
		}
	}
	
	public void XoaDuLieuCT(CongTrinh ct) 
	{
		//listCT = ct_dao.delete(ct);
	}
	
	public void DocDuLieuNVDatabaseVaoTable() 
	{
		String trinhDo = null;
		String loaiNV = null;
		listNV = nv_dao.getalltbNhanVien();
		for (NhanVien ct : listNV) {
			if(ct.getTrinhDo()==TrinhDo.DaiHoc)
				trinhDo = "Đại Học";
			if(ct.getTrinhDo()==TrinhDo.CaoDang)
				trinhDo = "Cao Đẳng";
			if(ct.getTrinhDo()==TrinhDo.TrungCap)
				trinhDo = "Trung Cấp";
			if(ct.getLoaiNV()==LoaiNV.CT)
				loaiNV = "Chính Thức";
			if(ct.getLoaiNV()==LoaiNV.TV)
				loaiNV = "Thời Vụ";
			modelNhanVien.addRow(new Object[] {ct.getMaNV(), ct.getHoNV(),
					ct.getTenNV(),
					LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgaySinh()), formatter).format(formatter),
					ct.getDiaChiThuongTru(),
					ct.getSoDienThoai(), ct.getDiaChiMail(),
					LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayVaoLam()), formatter).format(formatter), 
					trinhDo,
					ct.getMaPB(),
					ct.getSoNgayCong(), loaiNV, ct.getLuong()});
		}
	}
	
	public void DocDuLieuPBDatabaseVaoTable() {
		listPB = pb_dao.getalltbPhongBan();
	}
	
	public void DocDuLieuNVCTDatabaseVaoTable() {
		listNVCT = qlctnv_dao.getalltableCTNV();
	}
	
	public void setTextFieldQLCN()
	{
		NhanVien nv = new NhanVien();
		for(NhanVien i : listNV) 
		{
			if(i.getMaNV().equalsIgnoreCase(maNV1)) {
				nv.setMaNV(i.getMaNV());
				nv.setHoNV(i.getHoNV());
				nv.setTenNV(i.getTenNV());
				nv.setNgaySinh(i.getNgaySinh());
				nv.setDiaChiThuongTru(i.getDiaChiThuongTru());
				nv.setSoDienThoai(i.getSoDienThoai());
				nv.setDiaChiMail(i.getDiaChiMail());
				nv.setNgayVaoLam(i.getNgayVaoLam());
				nv.setTrinhDo(i.getTrinhDo());
				nv.setMaPB(i.getMaPB());
				nv.setSoNgayCong(i.getSoNgayCong());
				nv.setLoaiNV(i.getLoaiNV());
				nv.setLuong(i.getLuong());				
			}
		}
		
		textField_19.setText(nv.getMaNV());
		textField_26.setText(nv.getHoNV());
		textField_25.setText(nv.getTenNV());	
		textField_20.setText(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(nv.getNgaySinh()), formatter).format(formatter));
		textField_22.setText(nv.getSoDienThoai());
		textField_27.setText(nv.getDiaChiThuongTru());
		textField_23.setText(nv.getDiaChiMail());
		textField_28.setText(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(nv.getNgayVaoLam()), formatter).format(formatter));
		comboBox_5.setSelectedItem(nv.getTrinhDo());
		comboBox_10.setSelectedItem(nv.getMaPB());
		textField_21.setText(String.valueOf(nv.getSoNgayCong()));;
		comboBox_7.setSelectedItem(nv.getLoaiNV());
		textField_24.setText(String.valueOf(nv.getLuong()));
		for(QLCongTrinhNhanVien i : listNVCT) 
		{
			if(i.getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				comboBox_7.setSelectedItem(i.getMaCT());
			}
		}	
	}
	
	private void clearTextfieldsCT()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
	}
	
	private void clearTextfieldsNV() {
		textField_8.setText("");
		textField_16.setText("");
		textField_17.setText("");
		textField_9.setText("");
		textField_10.setText("");
		textField_11.setText("");
		textField_12.setText("");
		textField_18.setText("");
		comboBox_1.setSelectedIndex(0);
		comboBox_9.setSelectedIndex(0);
		textField_14.setText("");
		comboBox_4.setSelectedIndex(0);
		textField_13.setText("");
		textField_15.setText("");
	}
	
	private void fillFormCT(int row) 
	{
		if (row != -1) {		
			String maCT = modelCongTrinh.getValueAt(row, 0).toString();
			for(CongTrinh ct : listCT) 
			{
				if(ct.getMaCT().equalsIgnoreCase(maCT))
				{				
					textField.setText(ct.getMaCT());
					
					if(ct.getTenCT()==null)
						textField_1.setText("NULL");
					else
						textField_1.setText(ct.getTenCT().toString());
					
					if(ct.getDiaDiem()==null)
						textField_2.setText("NULL");
					else
						textField_2.setText(ct.getDiaDiem().toString());	
					
					if(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayCapGP()), formatter).format(formatter)==null)
						textField_3.setText("NULL");
					else
						textField_3.setText(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayCapGP()), formatter).format(formatter));
					
					if(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayKhoiCong()), formatter).format(formatter)==null)
						textField_4.setText("NULL");
					else
						textField_4.setText(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayKhoiCong()), formatter).format(formatter));
					
					if(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayHTDuKien()), formatter).format(formatter)==null)
						textField_5.setText("NULL");
					else
						textField_5.setText(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayHTDuKien()), formatter).format(formatter));
					
					if(String.valueOf((double)ct.getTongChiPhi())=="")
						textField_6.setText("NULL");
					else
						textField_6.setText(String.valueOf((double)ct.getTongChiPhi()));
					break;
				}
			}
		}
	}
	
	
	private void fillFormNV(int row)
	{
		if (row != -1) 
		{
			String maNV = modelNhanVien.getValueAt(row, 0).toString();
			for(NhanVien i : listNV)
			{
				if(i.getMaNV().equalsIgnoreCase(maNV)) {
					textField_8.setText(i.getMaNV());
					if(i.getHoNV()==null)
						textField_16.setText("NULL");
					else
						textField_16.setText(i.getHoNV());
					if(i.getTenNV()==null)
						textField_17.setText("NULL");
					else
						textField_17.setText(i.getTenNV());
					if(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(i.getNgaySinh()), formatter).format(formatter)==null)
						textField_9.setText("NULL");
					else
						textField_9.setText(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(i.getNgaySinh()), formatter).format(formatter));
					if(i.getDiaChiThuongTru()==null)
						textField_10.setText("NULL");
					else
						textField_10.setText(i.getDiaChiThuongTru());
					if(i.getSoDienThoai()==null)
						textField_11.setText("NULL");
					else
						textField_11.setText(i.getSoDienThoai());
					if(i.getDiaChiMail()==null)
						textField_12.setText("NULL");
					else
						textField_12.setText(i.getDiaChiMail());
					if(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(i.getNgayVaoLam()), formatter).format(formatter)==null)
						textField_18.setText("NULL");
					else
						textField_18.setText(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(i.getNgayVaoLam()), formatter).format(formatter));
					if(i.getTrinhDo().toString()==null)
						comboBox_1.setSelectedIndex(0);
					else 
					{
						for(int k=0; k<comboBox_1.getItemCount(); k++) 
						{
							if(i.getTrinhDo().toString().equals(comboBox_1.getItemAt(k).toString())) {
								comboBox_1.setSelectedIndex(k);
							}
						}
					}	
					if(i.getMaPB()==null)
						comboBox_9.setSelectedIndex(0);
					else 
					{
						for(int k=0; k<comboBox_9.getItemCount(); k++)
						{
							if(i.getMaPB().equals(comboBox_9.getItemAt(k).toString())) {
								comboBox_9.setSelectedIndex(k);
								break;
							}
						}
					}
					if(String.valueOf(i.getSoNgayCong())==null)
						textField_14.setText("NULL");
					else
						textField_14.setText(String.valueOf(i.getSoNgayCong()));
					if(i.getLoaiNV().toString()==null)
						comboBox_4.setSelectedIndex(0);
					else {
						for(int k=0; k<comboBox_4.getItemCount(); k++) {
							if(i.getLoaiNV().toString().equals(comboBox_4.getItemAt(k).toString())) {
								comboBox_4.setSelectedIndex(k);
								break;
							}
						}
					}
					cbbLCT1 = new DefaultComboBoxModel<String>();
					for(int j=0; j<listNVCT.size(); j++) {
						if(listNVCT.get(j).getMaNV().equalsIgnoreCase(i.getMaNV())) {
							cbbLCT1.addElement(listNVCT.get(j).getMaCT().trim());
						}
					}
					if(cbbLCT1!=null)
						comboBox_3.setModel(cbbLCT1);
					if(String.valueOf(i.getLuong())==null)
						textField_13.setText("NULL");
					else
						textField_13.setText(String.valueOf(i.getLuong()));
					break;
				}		
			}
		}
	}
	private void searchTableDataCT(String[] headers, String maCT) 
	{
		XoaHetDuLieuTrenTableModelCT();
		DefaultTableModel modelCongTrinh2 = new DefaultTableModel(headers, 0);
		for(CongTrinh s : listCT) 
		{
			if(s.getMaCT().trim().equalsIgnoreCase(maCT)) {
				modelCongTrinh2.addRow(new Object[] {
						s.getMaCT(), s.getTenCT(), s.getDiaDiem(),
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(s.getNgayCapGP()), formatter).format(formatter),
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(s.getNgayKhoiCong()), formatter).format(formatter),
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(s.getNgayHTDuKien()), formatter).format(formatter),
						s.getTongChiPhi()});
				break;
			}
		}
		tbct.setModel(modelCongTrinh2);
	}
	
	private void updateTableDataCT(String[] headers) {
		
		XoaHetDuLieuTrenTableModelCT();
		DocDuLieuCTDatabaseVaoTable();
		clearTextfieldsCT();
		DefaultTableModel modelCongTrinh2 = new DefaultTableModel(headers, 0);
		for(CongTrinh s : listCT) 
		{
			if(s != null) {
				modelCongTrinh2.addRow(new Object[] {
						s.getMaCT(), s.getTenCT(), s.getDiaDiem(),
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(s.getNgayCapGP()), formatter).format(formatter), 
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(s.getNgayKhoiCong()), formatter).format(formatter),
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(s.getNgayHTDuKien()), formatter).format(formatter), 
						s.getTongChiPhi()});
			}
		}
		tbct.setModel(modelCongTrinh2);
	}
	
	private void XoaHetDuLieuTrenTableModelCT() {
		modelCongTrinh.getDataVector().removeAllElements();
	}
	
	private void updateTableDataNV(String[] headers)
	{	
		String loaiNV = null;
		String trinhDo = null;
		XoaHetDuLieuTrenTableModelNV();
		DocDuLieuNVDatabaseVaoTable();
		clearTextfieldsNV();
		DefaultTableModel modelNhanVien2 = new DefaultTableModel(headers, 0);
		for (NhanVien ct : listNV)
		{		
			if(ct.getTrinhDo()==TrinhDo.DaiHoc)
				trinhDo = "Đại Học";
			if(ct.getTrinhDo()==TrinhDo.CaoDang)
				trinhDo = "Cao Đẳng";
			if(ct.getTrinhDo()==TrinhDo.TrungCap)
				trinhDo = "Trung Cấp";			
			if(ct.getLoaiNV()==LoaiNV.CT)
				loaiNV = "Chính Thức";
			if(ct.getLoaiNV()==LoaiNV.TV)
				loaiNV = "Thời Vụ";
			modelNhanVien2.addRow(new Object[] {ct.getMaNV(), ct.getHoNV(),
					ct.getTenNV(),
					LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgaySinh()), formatter).format(formatter),
					ct.getDiaChiThuongTru(),
					ct.getSoDienThoai(), ct.getDiaChiMail(),
					LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayVaoLam()), formatter).format(formatter), 
					trinhDo,
					ct.getMaPB(),
					ct.getSoNgayCong(), loaiNV, ct.getLuong()});
		}
		tbnv.setModel(modelNhanVien2);
	}
	
	private void XoaHetDuLieuTrenTableModelNV() 
	{
		modelNhanVien.getDataVector().removeAllElements();
	}
	
	private void searchTableDataNV(String[] headers, String maNV) 
	{
		String trinhDo = null;
		String loaiNV = null;
		XoaHetDuLieuTrenTableModelNV();
		DefaultTableModel modelNhanVien2 = new DefaultTableModel(headers, 0);
		for(NhanVien ct : listNV) 
		{
			if(ct.getMaNV().trim().equalsIgnoreCase(maNV)) 
			{
				if(ct.getTrinhDo()==TrinhDo.DaiHoc)
					trinhDo = "Đại Học";
				if(ct.getTrinhDo()==TrinhDo.CaoDang)
					trinhDo = "Cao Đẳng";
				if(ct.getTrinhDo()==TrinhDo.TrungCap)
					trinhDo = "Trung Cấp";			
				if(ct.getLoaiNV()==LoaiNV.CT)
					loaiNV = "Chính Thức";
				if(ct.getLoaiNV()==LoaiNV.TV)
					loaiNV = "Thời Vụ";
				modelNhanVien2.addRow(new Object[] {ct.getMaNV(), ct.getHoNV(),
						ct.getTenNV(),
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgaySinh()), formatter).format(formatter),
						ct.getDiaChiThuongTru(),
						ct.getSoDienThoai(), ct.getDiaChiMail(),
						LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(ct.getNgayVaoLam()), formatter).format(formatter), 
						trinhDo,
						ct.getMaPB(),
						ct.getSoNgayCong(), loaiNV, ct.getLuong()});
				break;
			}
		}
		tbnv.setModel(modelNhanVien2);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		int row = tbct.getSelectedRow();
		fillFormCT(row);
		int row1 = tbnv.getSelectedRow();
		//String maNV = modelNhanVien.getValueAt(row, 0).toString();
		//textField_8.setText(modelNhanVien.getValueAt(row1, 0).toString());
		fillFormNV(row1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
