import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.eclipse.wb.swing.HomeScreen;

import java.awt.Component;


public class AdminBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminBox frame = new AdminBox();
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
	public AdminBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 646);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Park Overview");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeScreen p = new HomeScreen();
				p.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setForeground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(426, 140, 224, 59);
		contentPane.add(btnNewButton);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setForeground(new Color(0, 139, 139));
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 40));
		lblWelcome.setBounds(436, 51, 203, 66);
		contentPane.add(lblWelcome);
		
		JButton btnNewButton_1 = new JButton("Graphs");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graph g = new Graph();
				g.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setForeground(new Color(100, 149, 237));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setBounds(426, 256, 224, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reports");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_2.setForeground(new Color(100, 149, 237));
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setBounds(426, 364, 224, 59);
		contentPane.add(btnNewButton_2);

		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(0, 0, 75, 24);
		contentPane.add(toolBar_1);
		
		JMenuBar File = new JMenuBar();
		toolBar_1.add(File);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setHorizontalAlignment(SwingConstants.LEFT);
		File.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenuItem mntmSvra = new JMenuItem("SVRA");
		mnNew.add(mntmSvra);
		
		JMenu mnPrint = new JMenu("Print");
		mnFile.add(mnPrint);
		
		JMenuItem mntmGraphs = new JMenuItem("Graphs/Charts");
		mnPrint.add(mntmGraphs);
		
		JMenuItem mntmReports = new JMenuItem("Reports");
		mnPrint.add(mntmReports);
		mnFile.add(mntmExit);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(72, 0, 75, 24);
		contentPane.add(toolBar);
		
		JMenuBar Edit = new JMenuBar();
		toolBar.add(Edit);
		
		JMenu mnEdit = new JMenu("Edit");
		Edit.add(mnEdit);
		
		JMenuItem mntmData = new JMenuItem("Data");
		mnEdit.add(mntmData);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Park-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 288, 345, 319);
		contentPane.add(lblNewLabel);
		
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setBounds(147, 0, 75, 24);
		contentPane.add(toolBar_2);
		
		JMenuBar Help = new JMenuBar();
		Help.setToolTipText("Help");
		toolBar_2.add(Help);
		
		JMenu mnNewMenu = new JMenu("Help");
		Help.add(mnNewMenu);
		
		JMenuItem mntmHelpInfo = new JMenuItem("Help Info");
		mnNewMenu.add(mntmHelpInfo);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnNewMenu.add(mntmAbout);

		
	}
}
