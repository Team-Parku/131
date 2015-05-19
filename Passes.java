/******************************************
 * This class is a child of EditFunction. *
 * It provides the function for editing   *
 * and displaying data for Passes. It can *
 * search a 449 by month/park/year. It    *
 * contains 3 buttons:                    *
 *                       1-Back to Main   *        
 *                       2-Save           *     
 *                       3-Search         *
 * LAST EDIT:    19 MAY 2015              *
 ******************************************/   
import java.util.*;
                          /* GUI imports:     */
import javax.swing.*;     /* GUI components   */
import java.awt.*;        /* for Dimension    */
import java.awt.event.*;  /* Action Listeners */ 
import java.awt.event.*;

import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Container;
import javax.swing.DefaultComboBoxModel;
public class Passes extends JPanel{
//-------table vars--------\\
   private static String[] columnNum = {
     "Annual Day Use", "Golden", "OHV Annual","Disabled Discount","Limited Use Golden","Other","Golden Bear",
     "Distinguished Veteran","ST PK Foundation","Other","Boat Use"};
   static JTable table = new JTable();
    //-------panel vars---------\\
   static JLabel passesLabel;
   static CardLayout contentPaneLayout;
   static JPanel contentPane;
   static JLabel tipLabel;
   static JButton back1 = new JButton("Go Back");
   static JButton save = new JButton("Save");
   static JButton search = new JButton("Search");
   static JTextField year;
  
   public Passes(JPanel contentPane){
   
      this.contentPane = contentPane;
      passesWindow();
    
   }
   
      
   private void passesWindow(){ 
      HomeScreen home = new HomeScreen(); 
   // components
      setLayout(contentPaneLayout=new CardLayout());
      passesLabel = new JLabel("...Passes (Edit Mode)");
   // layout [top]
      JPanel north = new JPanel(new GridLayout(4,2));
      search.setPreferredSize(new Dimension(40, 40));
      north.add(passesLabel);
      north.add(search);
   // layout [center]
      JPanel center = new JPanel(new FlowLayout());
   // drop down month menu-----------Month
      JLabel tipMonth = new JLabel("Select Month :  ", SwingConstants.RIGHT);
      tipMonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
      north.add(tipMonth); 
      JComboBox selectMonth = new JComboBox();
      selectMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
      selectMonth.setPreferredSize(new Dimension(110, 35));
      selectMonth.setMinimumSize(new Dimension(11000, 20));
      selectMonth.setBackground(SystemColor.inactiveCaptionBorder);
      selectMonth.setModel(new DefaultComboBoxModel(new String[] {
         "---","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
      north.add(selectMonth);
   // drop down month end------------Month
      tipLabel = new JLabel(
         "Select Park :  ", SwingConstants.RIGHT);
      north.add(tipLabel);
      tipLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
   // drop down park menu-----------8 parks
      JComboBox selectParks = new JComboBox();
      selectParks.setFont(new Font("Tahoma", Font.PLAIN, 18));
      selectParks.setPreferredSize(new Dimension(110, 35));
      selectParks.setMinimumSize(new Dimension(11000, 20));
      selectParks.setBackground(SystemColor.inactiveCaptionBorder);
      selectParks.setModel(new DefaultComboBoxModel(new String[] {
         "---","Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", 
         "Oceano Dunes", "Ocohillo Wells", "Prairie City"}));
      north.add(selectParks);
      //----end of drop down menu------8 parks
   // drop down year menu-----------YEAR
      JLabel tipYear = new JLabel("Enter Year (####) :  ", SwingConstants.RIGHT);
      tipYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
      north.add(tipYear); 
      year = new JTextField();
      north.add(year);
   // drop down year end------------YEAR
      
   // layout [south]  
      JPanel south = new JPanel(new FlowLayout());  
      south.add(back1);
      
   // --------data table start-------------------------
      
      Object[][] data = new Object[100][100];
      JTable table = new JTable(data, columnNum);
      table.setPreferredScrollableViewportSize(new Dimension(900, 375));
      table.setFillsViewportHeight(true);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      //Create the scroll pane and add the table to it.
      JScrollPane scrollPane = new JScrollPane(table);
   
      //Add the scroll pane to this panel.
      center.add(scrollPane);
      center.add(save);
      
   // --------data table end --------------------------....................Needs to modify for DATA DISPLAY
   // overall frame (content pane)
      JPanel editPanel = new JPanel(new BorderLayout());
      editPanel.add(north, BorderLayout.NORTH);
      editPanel.add(center, BorderLayout.CENTER);
   // add attendance data frame south                
      editPanel.add(south, BorderLayout.SOUTH);
      
      add("Edit Passes",editPanel);              
   // action listeners
      back1.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                  CardLayout cardLayout = (CardLayout) contentPane.getLayout(); 
                  cardLayout.previous(contentPane);
               }
               
            });
            
   } // end of passesWindow()
   
   
} 
/*****************************
  May 17, Sunday
  The queue order of panels:
  --------------------------
  0.Main
  
  1.Report Screen
  
  2.Edit Options {Main Button (prev.prev = Main), (prev = Report Screen) }
  
  3.Passes (prev = back to Options)
  
  4.Attendance (prev.prev = back to Options)
  ---------------------------
 ******************************/