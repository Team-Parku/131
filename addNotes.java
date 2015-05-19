/**********************************\
*Author: Matthew Yamamoto          *
*                                  *
*GUI:  Add Note                    *
*                                  *
*Last Edit: 5/19/15                *
\**********************************/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class addNotes extends JPanel {
   //needed for panel layout etc
   private BorderLayout contentPaneLayout;
   private JPanel contentPane;
   //buttons   
   private JButton back2 = new JButton();
   private JButton enterNotes = new JButton();
   //text fields
   private JTextField searchDate;
	private JTextArea notesEntered;
   //action listener
   private ActionListener AL2;
   //variables
   //private String parkSelection = "";
   private String date = "";
   private String noteEntered = "";
   private static String[] parkList ={"Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", "Oceano Dunes", "Ocohillo Wells", "Prairie City"};
   private JComboBox<String> parkSelect;
   //private JComboBox<String> parkList;
   

   public addNotes(JPanel contentPane) 
    {
        this.contentPane = contentPane;
        init();
    }

   private void init(){ 
       
      setPreferredSize(new Dimension(1000, 600));
		setLayout(new BorderLayout(0, 0));
		
		//top of borderlayout
		JPanel top = new JPanel();
		add(top, BorderLayout.NORTH);
		
		JLabel lblAddNote = new JLabel("Add Notes");
		lblAddNote.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddNote.setHorizontalAlignment(SwingConstants.CENTER);
		top.add(lblAddNote);
		
		
		
		//middle of borderlayout
		JPanel middle = new JPanel();
		add(middle, BorderLayout.CENTER);
		middle.setLayout(null);
		
		//select park label and combo box
		JLabel lblNewLabel_1 = new JLabel("Select Park");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(340, 35, 112, 39);
		middle.add(lblNewLabel_1);
		
		JComboBox selectPark = new JComboBox<String>(parkList);
		selectPark.setBounds(531, 37, 141, 39);
		selectPark.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectPark.setPreferredSize(new Dimension(110, 35));
		selectPark.setMinimumSize(new Dimension(11000, 20));
		selectPark.setBackground(SystemColor.inactiveCaptionBorder);
		middle.add(selectPark);
		
		//enter notes label and text area
		JLabel lblEnterNote = new JLabel("Enter Notes");
		lblEnterNote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNote.setBounds(437, 343, 141, 39);
		middle.add(lblEnterNote);
		
		JTextArea notesEntered = new JTextArea();
		notesEntered.setBounds(316, 393, 378, 82);
		middle.add(notesEntered);
		
		//enter date label and text area
		JLabel lblEnterDate = new JLabel("Enter Date:");
		lblEnterDate.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEnterDate.setBounds(273, 190, 117, 49);
		middle.add(lblEnterDate);
		
		//date combo boxes and labels		
		JComboBox comboMonth = new JComboBox();
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novemember", "December"}));
		comboMonth.setBounds(427, 196, 125, 31);
		middle.add(comboMonth);
		
		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004"}));
		comboYear.setBounds(593, 196, 101, 31);
		middle.add(comboYear);
		
		JLabel month = new JLabel("Month");
		month.setFont(new Font("Tahoma", Font.PLAIN, 20));
		month.setHorizontalAlignment(SwingConstants.CENTER);
		month.setBounds(427, 154, 112, 37);
		middle.add(month);
		
		JLabel Year = new JLabel("Year");
		Year.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Year.setHorizontalAlignment(SwingConstants.CENTER);
		Year.setBounds(608, 160, 68, 25);
		middle.add(Year);
      		
		//bottom of border layout
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new GridLayout(0, 4, 10, 0));
		JLabel lblNewLabel = new JLabel("");
		bottom.add(lblNewLabel);
		
		//buttons	
		JButton back2 = new JButton("Back");
		back2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		back2.setMaximumSize(new Dimension(89, 55));
		back2.setSize(new Dimension(55, 40));
		bottom.add(back2);
				
		JButton enterNotes = new JButton("Enter Notes");
		enterNotes.setFont(new Font("Tahoma", Font.PLAIN, 29));
		bottom.add(enterNotes);
      
      
   
      
      //homescrren constuctor
      //HomeScreen home = new HomeScreen();

      
       AL2 = new ActionListener(){
      
       public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == back2)
                {
                      CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                      cardLayout.previous(contentPane);
                      //cardLayout.previous(contentPane);

                }
                if(ae.getSource() == enterNotes){
                     String parkSelection = (String) selectPark.getSelectedItem();
                     String monthSelect = (String)comboMonth.getSelectedItem();
                     String yearSelect = (String)comboYear.getSelectedItem();
                     noteEntered = notesEntered.getText();                    
                     /*//add to data base.
                     */
                     
                     //clears textfields for new entry
                     notesEntered.setText("");
                     
                     //switch back2 to main screen after note is entered
                     CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                     cardLayout.previous(contentPane);
                     cardLayout.previous(contentPane);
                     

                     
                }
            }
        };

      
      //action listeners      
      enterNotes.addActionListener(AL2);
      back2.addActionListener(AL2);

     
      }//end init
        
}//end class  