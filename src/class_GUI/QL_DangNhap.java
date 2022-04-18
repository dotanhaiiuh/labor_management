package class_GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import class_ConnectDB.ConnectDB;
import class_Entity.DangNhap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class QL_DangNhap extends JFrame
{
	private JPanel contentPane;
	private JTextField textField;
	//private DangNhap_DAO dn;
	private List<DangNhap> list;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					QL_DangNhap frame = new QL_DangNhap();
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
	public QL_DangNhap() 
	{
		super("Simple GUI"); 
		ConnectDB.getInstance().connect();
		///dn = new DangNhap_DAO();
		setIconImage(Toolkit.getDefaultToolkit().getImage(QL_DangNhap.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setTitle("Ph\u00E2n c\u00F4ng lao \u0111\u1ED9ng version: 1.0.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setIcon(new ImageIcon("Data/icons8-user-male-26.png"));
		lblNewLabel.setBounds(44, 51, 99, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setIcon(new ImageIcon("Data/icons8-lock-26.png"));
		lblNewLabel_1.setBounds(44, 90, 99, 41);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(143, 57, 251, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation") 
			public void actionPerformed(ActionEvent e) 
			{
				boolean check = false;
				try 
				{
					for(DangNhap dn1 : list) 
					{
						if(textField.getText().trim().toString().equalsIgnoreCase(dn1.getUsername().trim()) && passwordField.getText().toString().equalsIgnoreCase(dn1.getPassword().trim())) 
						{
							dispose();
							//giaodien1.NewScreen(textField.getText().trim());
							check = true;
							break;
						}
					}	
					if(check == false)
					{
						throw new Exception();
					}
				}
				catch(Exception e1) 
				{
					JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu");	
				}
				
			}
		});
		
		DocDuLieuDatabase();
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation") 
			public void actionPerformed(ActionEvent e)
			{
				boolean check = false;
				try 
				{
					for(DangNhap dn1 : list) 
					{
						if(textField.getText().trim().toString().equalsIgnoreCase(dn1.getUsername().trim()) && passwordField.getText().toString().equalsIgnoreCase(dn1.getPassword().trim())) 
						{
							dispose();
							//giaodien1.NewScreen(textField.getText().trim());
							check = true;
							break;
						}
					}	
					if(check == false)
					{
						throw new Exception();
					}
				}
				catch(Exception e1) 
				{
					JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu");	
				}	
			}
		});
		
		btnNewButton.setIcon(new ImageIcon("Data/icons8-checkmark-26.png"));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(70, 143, 115, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		
		btnNewButton_1.setIcon(new ImageIcon("Data/icons8-delete-26.png"));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(253, 143, 115, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblngNhp = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblngNhp.setVerticalAlignment(SwingConstants.TOP);
		lblngNhp.setForeground(SystemColor.textHighlight);
		lblngNhp.setToolTipText("\u0110\u0103ng nh\u1EADp");
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblngNhp.setBounds(167, 11, 122, 40);
		contentPane.add(lblngNhp);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Data/images.png"));
		lblNewLabel_2.setBounds(404, 0, 200, 200);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 96, 251, 28);
		contentPane.add(passwordField);
		passwordField.addActionListener(new ActionListener()
		{@SuppressWarnings("deprecation") 
			public void actionPerformed(ActionEvent e)
			{
				boolean check = false;
				try 
				{
					for(DangNhap dn1 : list) 
					{
						if(textField.getText().trim().toString().equalsIgnoreCase(dn1.getUsername().trim()) && passwordField.getText().toString().equalsIgnoreCase(dn1.getPassword().trim())) {
							dispose();
							//giaodien1.NewScreen(textField.getText().trim());
							check = true;
							break;
						}
					}	
					if(check == false)
					{
						throw new Exception();
					}
				}
				catch(Exception e1) 
				{
					JOptionPane.showMessageDialog(null, "Sai Tài Khoản hoặc Mật Khẩu");	
				}	
			}
		});
	}
	
	public void DocDuLieuDatabase() 
	{
		//list = dn.getalltabledangnhap();
	}
}
