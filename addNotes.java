/**********************************\
*Author: Matthew Yamamoto          *
*                                  *
*GUI:  Add Note                    *
*                                  *
*Last Edit: 5/19/15                *
\**********************************/


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Color;


public class addNotes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNotes frame = new addNotes();
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
	public addNotes() {
		setBackground(Color.RED);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Note");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(193, 357, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setBounds(327, 357, 103, 23);
		contentPane.add(btnCancel);
		
		JLabel lblEnterNote = new JLabel("Enter Note");
		lblEnterNote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterNote.setBounds(270, 38, 103, 30);
		contentPane.add(lblEnterNote);
		
		JLabel lblSelectPark = new JLabel("Select Park");
		lblSelectPark.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPark.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSelectPark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectPark.setBounds(103, 103, 120, 30);
		contentPane.add(lblSelectPark);
		
		JComboBox comboSelectPark = new JComboBox();
		comboSelectPark.setModel(new DefaultComboBoxModel(new String[] {"", "Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", "Oceano Dunes", "Ocohillo Wells", "Prairie City"}));
		comboSelectPark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboSelectPark.setBounds(103, 176, 120, 20);
		contentPane.add(comboSelectPark);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(352, 103, 100, 23);
		contentPane.add(lblDate);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(273, 141, 100, 20);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(415, 141, 100, 20);
		contentPane.add(lblYear);
		
		JComboBox comboMonth = new JComboBox();
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novemember", "December"}));
		comboMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboMonth.setBounds(273, 176, 100, 20);
		contentPane.add(comboMonth);
		
		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004"}));
		comboYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboYear.setBounds(415, 176, 100, 20);
		contentPane.add(comboYear);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNote.setBounds(162, 259, 50, 20);
		contentPane.add(lblNote);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(222, 259, 257, 58);
		contentPane.add(textArea);
	}
}
