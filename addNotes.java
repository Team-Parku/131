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
   private JButton back = new JButton();
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
		lblEnterDate.setBounds(368, 179, 117, 49);
		middle.add(lblEnterDate);
		
		searchDate = new JTextField();
		searchDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchDate.setBounds(494, 183, 200, 50);
		middle.add(searchDate);
		searchDate.setColumns(10);
		
		//bottom of border layout
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new GridLayout(0, 4, 10, 0));
		JLabel lblNewLabel = new JLabel("");
		bottom.add(lblNewLabel);
		
		//buttons	
		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.PLAIN, 29));
		back.setMaximumSize(new Dimension(89, 55));
		back.setSize(new Dimension(55, 40));
		bottom.add(back);
				
		JButton enterNotes = new JButton("Enter Notes");
		enterNotes.setFont(new Font("Tahoma", Font.PLAIN, 29));
		bottom.add(enterNotes);
      
      
   
      
      //homescrren constuctor
      HomeScreen home = new HomeScreen();

      
       AL2 = new ActionListener(){
      
       public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == back)
                {
                      CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                      cardLayout.previous(contentPane);
                      cardLayout.previous(contentPane);

                }
                if(ae.getSource() == enterNotes){
                     String parkSelection = (String) selectPark.getSelectedItem();
                     date =searchDate.getText();
                     noteEntered = notesEntered.getText();                    
                     /*//add to data base.
                     */
                     
                     //clears textfields for new entry
                     searchDate.setText("");
                     notesEntered.setText("");
                     
                     //switch back to main screen after note is entered
                     CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                     cardLayout.previous(contentPane);
                     cardLayout.previous(contentPane);
                     

                     
                }
            }
        };

      
      //action listeners      
      enterNotes.addActionListener(AL2);
      back.addActionListener(AL2);

     
      }//end init
        
}//end class  
  