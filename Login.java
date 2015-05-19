import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;


public class Login {

	public JFrame frmO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
      HomeScreen s = new HomeScreen();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmO.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	ResultSet rs = null;
	PreparedStatement pst=null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = sqlConnection.dbConnector();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmO = new JFrame();
		frmO.setFont(new Font("Verdana", Font.PLAIN, 12));
		frmO.setResizable(false);
		frmO.setBackground(new Color(255, 240, 245));
		frmO.getContentPane().setBackground(new Color(105, 105, 105));
		frmO.setTitle("OHMVRDAD Login");
		frmO.setBounds(100, 100, 502, 324);
		frmO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmO.getContentPane().setLayout(null);
		
		JLabel wrongUorP = new JLabel("Username and/or password is wrong. Please try again.");
		wrongUorP.setVisible(false);
		wrongUorP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wrongUorP.setBackground(new Color(192, 192, 192));
		wrongUorP.setForeground(new Color(255, 192, 203));
		wrongUorP.setBounds(83, 229, 373, 27);
		frmO.getContentPane().add(wrongUorP);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setForeground(new Color(105, 105, 105));
		enterButton.setBackground(new Color(211, 211, 211));
		enterButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String sql = "select * from AdminUser where username=? and password=?";
				try{
				pst=connection.prepareStatement(sql);
				pst.setString(1, usernameField.getText());
				pst.setString(2, passwordField.getText());
				
				rs=pst.executeQuery();
				if(rs.next()){
				JOptionPane.showMessageDialog(null, "Username and Password is correct");
				frmO.dispose();
            HomeScreen s = new HomeScreen();
            frmO.getContentPane().add(s.frm);
            //frmO.getContentPane().show(s.contentPane, "Main Menu");
 				frmO.setVisible(true);
				}	
				else{
					wrongUorP.setVisible(true);
					
				}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
      //HomeScreen home = new HomeScreen();
      //frmO.getContentPane().add("", home);
      
		enterButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		enterButton.setBounds(201, 191, 89, 27);
		frmO.getContentPane().add(enterButton);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Verdana", Font.PLAIN, 14));
		usernameField.setBounds(228, 108, 163, 27);
		frmO.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel username = new JLabel("Username :");
		username.setForeground(new Color(192, 192, 192));
		username.setFont(new Font("Verdana", Font.PLAIN, 18));
		username.setBounds(101, 108, 133, 27);
		frmO.getContentPane().add(username);
		
		JLabel password = new JLabel("Password :");
		password.setForeground(new Color(192, 192, 192));
		password.setFont(new Font("Verdana", Font.PLAIN, 18));
		password.setBounds(101, 146, 143, 27);
		frmO.getContentPane().add(password);
		
		JLabel login = new JLabel("OHMVR Division Attendance Database");
		login.setForeground(new Color(204, 204, 204));
		login.setFont(new Font("Verdana", Font.PLAIN, 18));
		login.setBounds(10, 11, 392, 27);
		frmO.getContentPane().add(login);
	
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER){
					
					String sql = "select * from AdminUser where username=? and password=?";
					try{
					pst=connection.prepareStatement(sql);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					
					rs=pst.executeQuery();
					if(rs.next()){
					JOptionPane.showMessageDialog(null, "Username and Password is correct");
					frmO.dispose();
               HomeScreen.main(new String[1]);
					}	
					else{
						wrongUorP.setVisible(true);
						
					}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
                  System.out.println("this is the second thing");
						
					}
					
				}
					
			}
		});
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordField.setBounds(228, 146, 163, 27);
		frmO.getContentPane().add(passwordField);
	
		
		JButton readOnly = new JButton("Read Only");
		readOnly.setForeground(new Color(30, 144, 255));
		readOnly.setFont(new Font("Verdana", Font.PLAIN, 10));
		readOnly.setBounds(383, 261, 103, 23);
		frmO.getContentPane().add(readOnly);
		

	}
}
