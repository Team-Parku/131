import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

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


public class Login {

	private JFrame frmO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmO.getContentPane().setBackground(new Color(105, 105, 105));
		frmO.setTitle("OHMVR Attendance Data");
		frmO.setBounds(100, 100, 687, 437);
		frmO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmO.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setForeground(new Color(112, 128, 144));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
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
				AdminBox s = new AdminBox();
				s.setVisible(true);
				}	
				else{
					JOptionPane.showMessageDialog(null, "Username and Password is incorrect");
					
				}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(258, 316, 143, 36);
		frmO.getContentPane().add(btnNewButton);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameField.setBounds(326, 162, 189, 36);
		frmO.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel username = new JLabel("Username :");
		username.setForeground(new Color(192, 192, 192));
		username.setFont(new Font("Tahoma", Font.PLAIN, 24));
		username.setBounds(138, 162, 143, 38);
		frmO.getContentPane().add(username);
		
		JLabel password = new JLabel("Password :");
		password.setForeground(new Color(192, 192, 192));
		password.setFont(new Font("Tahoma", Font.PLAIN, 24));
		password.setBounds(138, 211, 143, 36);
		frmO.getContentPane().add(password);
		
		JLabel login = new JLabel("Login");
		login.setForeground(new Color(204, 204, 204));
		login.setFont(new Font("Tahoma", Font.PLAIN, 36));
		login.setBounds(281, 37, 95, 100);
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
					AdminBox s = new AdminBox();
					s.setVisible(true);
					}	
					else{
						JOptionPane.showMessageDialog(null, "Username and Password is incorrect");
						
					}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
						
					}
					
				}
					
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(326, 211, 189, 38);
		frmO.getContentPane().add(passwordField);
		
		JButton btnReadOnly = new JButton("Read Only...");
		btnReadOnly.setForeground(Color.BLUE);
		btnReadOnly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReadOnly.setBounds(566, 364, 95, 23);
		frmO.getContentPane().add(btnReadOnly);
	}
}
