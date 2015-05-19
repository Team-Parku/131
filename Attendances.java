/******************************************
 * This class is a child of EditFunction. *
 * It provides the function for editing   *
 * and displaying Attendance Data. Can    *
 * search for the 449 by month;year;park. *
 * It contains 3 buttons:                 *
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

import javax.swing.border.*;
import java.awt.Container;

public class Attendances extends JPanel{

   private static String[] columnNum = {
     "Paid Day Use", "Free Day Use", "Overnight", "Boats", "ST PK", 
     "Paid Conversion Total", "Free Conversion Total"};
   static JTable table = new JTable();
   //--------------------------------------------table end
   static CardLayout contentPaneLayout;
   static JPanel contentPane;
   static JLabel attendanceLabel;
   static JLabel tipLabel;
   static JButton save = new JButton("Save");
   static JButton paidDayUse = new JButton("Paid Day Use");
   static JButton freeDayUse = new JButton("Free Day Use");
   static JButton overnight = new JButton("Overnight");
   static JButton specialEvent = new JButton("Special Event");
   static JButton back1 = new JButton("Go Back");
   static JButton search = new JButton("Search");
   static ActionListener act;
   static JTextField year;
   
   public Attendances(JPanel contentPane){
   
      this.contentPane = contentPane;
      attendanceWindow();
   }

   private void attendanceWindow(){ 
   // components
      setLayout(contentPaneLayout=new CardLayout());
      attendanceLabel = new JLabel("...Attendance (Edit Mode)");
      JPanel attendancePanel = new JPanel(new BorderLayout());
      
   // layout [north1]   
      JPanel north1 = new JPanel(new GridLayout(4,2)); //ideal (3,3)
        
      north1.add(attendanceLabel);
      north1.add(search);
   // layout [center]
      JPanel center1 = new JPanel(new FlowLayout());
   // drop down month menu-----------Month
      JLabel tipMonth = new JLabel("Select Month :  ", SwingConstants.RIGHT);
      tipMonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
      north1.add(tipMonth); 
      JComboBox selectMonth = new JComboBox();
      selectMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
      selectMonth.setPreferredSize(new Dimension(110, 35));
      selectMonth.setMinimumSize(new Dimension(11000, 20));
      selectMonth.setBackground(SystemColor.inactiveCaptionBorder);
      selectMonth.setModel(new DefaultComboBoxModel(new String[] {
         "---","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
      north1.add(selectMonth);
   // drop down month end------------Month
      tipLabel = new JLabel(
         "Select Park :  ", SwingConstants.RIGHT);
      north1.add(tipLabel);
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
      north1.add(selectParks);
      //----end of drop down menu------8 parks
   // drop down year menu-----------YEAR
      JLabel tipYear = new JLabel("Enter Year (####) :  ", SwingConstants.RIGHT);
      tipYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
      north1.add(tipYear); 
      year = new JTextField();
      north1.add(year);
   // drop down year end------------YEAR
   // layout [south]      
      JPanel south1 = new JPanel(new FlowLayout());
      south1.add(back1);
   // --------data table start-------------------------
      
      Object[][] data = new Object[100][100];
      JTable table = new JTable(data, columnNum);
      table.setPreferredScrollableViewportSize(new Dimension(900, 375));
      table.setFillsViewportHeight(true);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      //Create the scroll pane and add the table to it.
      JScrollPane scrollPane = new JScrollPane(table);
   
      //Add the scroll pane to this panel.
      center1.add(scrollPane);
      center1.add(save);
   // --------data table end --------------------------
   // overall frame
      attendancePanel.add(north1, BorderLayout.NORTH);
      attendancePanel.add(center1, BorderLayout.CENTER);
   // add attendance data frame south        .........................................Needs to modify for DATA DISPLAY
      attendancePanel.add(south1, BorderLayout.SOUTH);
       
      add("Edit Attendance",attendancePanel);                            
   // action listeners
      back1.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                  CardLayout cardLayout = (CardLayout) contentPane.getLayout(); 
                  cardLayout.previous(contentPane);
                  cardLayout.previous(contentPane);
               }
               
            });
   } // end of attendanceWindow()
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