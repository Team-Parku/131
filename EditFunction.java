/***********************************************\
 * GUI:          EDIT / DEL                    *
 * This class is a child of Report Screen and  *
 * it displays the Edit Options panel with     *
 * three buttons: ATTENDANCE,PASSES,MAIN MENU. *
 * LAST EDIT:    17 MAY 2015                   *
\***********************************************/

import java.util.*;
                          /* GUI imports:     */
import javax.swing.*;     /* GUI components   */
import java.awt.*;        /* for Dimension    */
import java.awt.event.*;  /* Action Listeners */ 
import java.awt.event.*;

import javax.swing.border.*;
import java.awt.Container;

public class EditFunction extends JPanel{

// buttons / labels / textfields: 
   static JLabel frame;
   private JButton edit;
   static CardLayout contentPaneLayout;
   static JPanel contentPane;
   static JLabel label;
   static JButton attendance = new JButton("Attendance");
   static JButton passes = new JButton("Passes");
   static JButton main = new JButton("Main Menu");
   static JButton back1 = new JButton("Go Back");
   static JButton paidDayUse = new JButton("Paid Day Use");
   static JButton freeDayUse = new JButton("Free Day Use");
   static JButton overnight = new JButton("Overnight");
   static JButton specialEvent = new JButton("Special Event");
   static JLabel tipLabel;
   static JLabel passesLabel;
   static JLabel attendanceLabel;
   private ActionListener pas;
   private ActionListener att;
   static JPanel attendancePanel;
   static JPanel editPanel;
   
   public EditFunction(JPanel contentPane){
      this.contentPane = contentPane;
      editOptionWindow();
   }
   
   private void editOptionWindow(){
      frame = new JLabel("Edit Options", JLabel.CENTER);
      label = new JLabel("Select one to edit:",JLabel.CENTER);
    //contentPane = (JPanel) frame.getContentPane();
      setLayout(contentPaneLayout=new CardLayout());
      
      JPanel editPan = new JPanel();
      JPanel base = new JPanel();
      JPanel all = new JPanel(new GridLayout(3,1));
    //add buttons to the JPanels/Cards ('all' is final panel)
      all.add(frame);
      editPan.add(attendance);
      editPan.add(passes);
      base.add(main);
      all.add(editPan);
      all.add(base);
    //adds to main pane
      add(all, "Edit Options");                                      
    //action listeners
      main.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                  CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                  cardLayout.previous(contentPane);   
                  cardLayout.previous(contentPane);
                  
               }
               
            });
      passes.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                  CardLayout cardLayout = (CardLayout) contentPane.getLayout();  
                  cardLayout.next(contentPane);
               }
               
            });
      attendance.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
               {
                  CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                  cardLayout.next(contentPane);   
                  cardLayout.next(contentPane); 
               }
               
            }); 
   } //end of editOptionWindow()
  
  
} //end of program

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