/******************************************
 * This class is a child of EditFunction. *
 * It provides the function for editing   *
 * and displaying data for Passes. It     *
 * contains 4 buttons:                    *
 *                       1-PAID DAY       *
 *                       2-FREE DAY       *     
 *                       3-BOAT PASS      *
 *                       4-GO BACK        *
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

public class Passes extends JPanel{

   static JLabel passesLabel;
   static CardLayout contentPaneLayout;
   static JPanel contentPane;
   static JLabel tipLabel;
   static JButton back1 = new JButton("Go Back");
   
   public Passes(JPanel contentPane){
   
      this.contentPane = contentPane;
      passesWindow();
    
   }
      
   
   private void passesWindow(){  
   // components
      setLayout(contentPaneLayout=new CardLayout());
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
   // add attendance data frame south                ....................Needs to modify for DATA DISPLAY
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
                  //cardLayout.previous(contentPane);  // michael's report screen
                  //cardLayout.previous(contentPane);  // park overview (main)
                  //cardLayout.previous(contentPane);  // attendance panel
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
