/*****************************\
 *AUTHOR:       Kathleen
 *GUI:          EDIT / DEL 
 *LAST EDIT:    04 MAY 2015
\*****************************/

import java.util.*;
                          /* GUI imports:     */
import javax.swing.*;     /* GUI components   */
import java.awt.*;        /* for Dimension    */
import java.awt.event.*;  /* Action Listeners */ 

public class EditFunction extends HomeScreen implements ActionListener {

// buttons / labels / textfields: 
   private JFrame frame;
   private JButton edit;
   static CardLayout contentPaneLayout;
   static JPanel contentPane;
   static JLabel label;
   static JButton attendance = new JButton("Attendance");
   static JButton passes = new JButton("Passes");
   static JButton main = new JButton("Back To Main");
   static JButton back1 = new JButton("Go Back");
   static JLabel tipLabel;
   static JLabel passesLabel;
   static JLabel attendanceLabel;
   
   // should delete:
   public void editFrame() {
      frame = new JFrame();
      frame.setForeground(Color.WHITE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(new Point(10, 50));
      frame.setSize(new Dimension(300, 120));
      frame.setTitle("Main Window");  
   }  
   /* -construct button
      -set properties
      -add to frame        */
   public void editButton() {
   
      edit = new JButton();
      edit.setText("EDIT");
      edit.setBackground(Color.ORANGE);
      frame.add(edit);
      
      // action listener
      edit.addActionListener(this);
      // frame becomes visible
      frame.setVisible(true);
      
   }   
   // where it really begins
   public void editOptionWindow(){
      frame = new JFrame("Edit Options");
      label = new JLabel("Select one to edit:",JLabel.CENTER);
      contentPane = (JPanel) frame.getContentPane();
      contentPane.setLayout(contentPaneLayout=new CardLayout());
      JPanel editPan = new JPanel();
      JPanel base = new JPanel();
      JPanel all = new JPanel(new GridLayout(3,1));
    //add buttons to the JPanels/Cards
      editPan.add(attendance);
      editPan.add(passes);
      base.add(main);
      all.add(editPan);
      all.add(base);
    //add the panels to the contentPane
      contentPane.add("Edit Options",all);
      contentPaneLayout.show(contentPane,"Edit Options");
     
    // action listeners!  
      attendance.addActionListener(this);
      passes.addActionListener(this);
      main.addActionListener(this);        /*<-------------------- needs to change this actionListener */
    // setting the frame!  
      frame.pack();
      frame.setSize(580,220);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   
   } //edit option window

   public void passesWindow() {
      
   // components
      passesLabel = new JLabel("Editing Passes");
   // layout [top]
      JPanel north = new JPanel(new FlowLayout());
      north.add(passesLabel);
   // layout [center]
      JPanel center = new JPanel(new FlowLayout());
      tipLabel = new JLabel(
         "You may edit the following!");
   
      center.add(tipLabel);  
   // layout [south]      
      JPanel south = new JPanel(new GridLayout(1,3));
      south.add(new JButton("Paid Day"));
      south.add(new JButton("Free Day"));
      south.add(new JButton("Boat Pass"));
      south.add(back1);
   // overall frame (content pane)
      JPanel editPanel = new JPanel(new BorderLayout());
      editPanel.add(north, BorderLayout.NORTH);
      editPanel.add(center, BorderLayout.CENTER);
   // add attendance data frame south                HOW?!!?
      editPanel.add(south, BorderLayout.SOUTH);
   // add to contentPane
      contentPane.add("Edit Panel",editPanel);
   // action Listeners  
      back1.addActionListener(this);
      
      frame.pack();
      frame.setSize(580,220);
      frame.setResizable(false);
      frame.setVisible(true);   
     
   } // passesWindow()
  
   public void attendanceWindow(){
      
   // components
      attendanceLabel = new JLabel("Editing Attendance");
      JPanel attendancePanel = new JPanel(new BorderLayout());
      JPanel north = new JPanel(new FlowLayout());
      north.add(attendanceLabel);
   // layout [center]
      JPanel center = new JPanel(new GridLayout(3,1));
      tipLabel = new JLabel(
         "You may edit the following!");
      center.add(tipLabel);
       
   // layout [south]      
      JPanel south = new JPanel(new GridLayout(2,2));
      south.add(new JButton("Paid Day Use"));
      south.add(new JButton("Free Day Use"));
      south.add(new JButton("Overnight"));
      south.add(new JButton("Special Event"));
   // overall frame
      attendancePanel.add(north, BorderLayout.NORTH);
      attendancePanel.add(center, BorderLayout.CENTER);
        // add attendance data frame south
      attendancePanel.add(south, BorderLayout.SOUTH);
      contentPane.add("Attendance Panel", attendancePanel);
      
      frame.pack();
      frame.setSize(680,220);
      frame.setResizable(false);
      frame.setVisible(true);   
     
   } // attendanceWindow
   
     //edit panel , edit options:
   public void actionPerformed(ActionEvent e){
      Object source = e.getSource();
   
      if(source==edit) contentPaneLayout.show(contentPane, "Edit Options");
      if(source==main) contentPaneLayout.show(contentPane, "Main"); // <----------Needs to change to match Michael's
      if(source==attendance) contentPaneLayout.show(contentPane, "Edit Panel");
      if(source==passes) contentPaneLayout.show(contentPane, "Edit Panel");
      if(source==back1) contentPaneLayout.show(contentPane, "Edit Options");
   } // end of actionListeners   

  
   public static void main(String[] args) {
   
      EditFunction login = new EditFunction();
     
      //login.editFrame();
      //login.editButton(); 
      login.editOptionWindow();
      login.passesWindow();  
      
   } // main  	  
} //end of program