/******************************************
 * This class is a child of EditFunction. *
 * It provides the function for editing   *
 * and displaying Attendance Data.        *
 * It contains 5 buttons:                 *
 *                       1-PAID DAY USE   *
 *                       2-FREE DAY USE   *
 *                       3-OVERNIGHT      *
 *                       4-SPECIAL EVENT  *
 *                       5-BACK TO MAIN   *
 * LAST EDIT:    17 MAY 2015              *
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

   static CardLayout contentPaneLayout;
   static JPanel contentPane;
   static JLabel attendanceLabel;
   static JLabel tipLabel;
   static JButton paidDayUse = new JButton("Paid Day Use");
   static JButton freeDayUse = new JButton("Free Day Use");
   static JButton overnight = new JButton("Overnight");
   static JButton specialEvent = new JButton("Special Event");
   static JButton back1 = new JButton("Go Back");
   
   public Attendances(JPanel contentPane){
   
      this.contentPane = contentPane;
      attendanceWindow();
   }

   private void attendanceWindow(){ 
   // components
      setLayout(contentPaneLayout=new CardLayout());
      attendanceLabel = new JLabel("Editing Attendance");
      JPanel attendancePanel = new JPanel(new BorderLayout());
      JPanel north1 = new JPanel(new FlowLayout());
      north1.add(attendanceLabel);
   // layout [center]
      JPanel center1 = new JPanel(new GridLayout(3,1));
      tipLabel = new JLabel(
         "You may edit the following!");
      center1.add(tipLabel);
   // layout [south]      
      JPanel south1 = new JPanel(new GridLayout(1,5));
      south1.add(paidDayUse);
      south1.add(freeDayUse);
      south1.add(overnight);
      south1.add(specialEvent);
      south1.add(back1);
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
