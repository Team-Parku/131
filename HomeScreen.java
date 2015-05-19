/* allyson.hansen@parks.ca.gov
 * jason.bariel@parks.ca.gov
 * robbie.holcomb@parks.ca.gov
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.table.AbstractTableModel;

public class HomeScreen implements ActionListener {
   
   static JFrame frm;
   static CardLayout contentPaneLayout;
   static JPanel contentPane;
   static JPanel buttonsPanel;
   static JTable totalsTable = new JTable();
   static JTable reportTable = new JTable();
	
   private static JButton[] but = new JButton[8];
   private static String[] columnNames = {"Day", "Vehicle", "Non-Vehicle", "Total Attendance", "Total Passes", "Paid Conversion Total", "Free Conversion Total"};
   private static String[] parkNames = {"Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", "Oceano Dunes", "Ocotillo Wells", "Prairie City"};
   private static Integer[] Months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
   private static JComboBox<Integer> yearList;
   private static JComboBox<Integer> monthList;
   private static JComboBox<String> nameList;
   
   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();
      for(int i = 0; i < but.length; i++) {
         if (source == but[i]) {
            contentPaneLayout.show(contentPane, (String) e.getActionCommand());
         } 
         else if (source == but[4]) {
            createReport();
         }
      }
   }
	
   private static void createReport() {
      String yearSelection = (String) yearList.getSelectedItem();
      String monthSelection = (String) monthList.getSelectedItem();
      String nameSelection = (String) nameList.getSelectedItem();
   }
	
   public static void main(String[] args) {
      ActionListener AL = new HomeScreen();
      frm = new JFrame("OHMVRDAD Login");
   //       Login login = new Login();
      contentPane = (JPanel) frm.getContentPane();
      contentPane.setBackground(new Color(105, 105, 105));
      contentPane.setLayout(contentPaneLayout = new CardLayout());
      createButtons(AL);
      JPanel main = new JPanel();
      addMain(main, AL);
      JPanel reportScreen = new JPanel();
      addReportScreen(reportScreen, AL);
      int width = 1000;
      int height = 600;
      contentPane.add("Main Menu", main);
      contentPane.add("Report", reportScreen);
      //contentPane.add(login.frmO, "Login");
      contentPaneLayout.show(contentPane, "Login");
     
         //constructor for classes
      EditFunction edit = new EditFunction(contentPane);
      Passes pass = new Passes(contentPane);
      Attendances attend = new Attendances(contentPane);
         
      contentPane.add("Edit Data", edit);
      contentPane.add(pass);
      contentPane.add(attend);	
         
      addNotes note = new addNotes(contentPane);
      contentPane.add(note, "Add Notes");
      addData2 data = new addData2(contentPane);
      contentPane.add(data, "Add Data");
   
      frm.pack();
      frm.setSize(width, height);
      frm.setResizable(false);
      frm.setLocationRelativeTo(null);
      frm.setVisible(true);
      
      
      
      /* //////////////////////////////////////// */
      //contentPaneLayout.show(contentPane, "Main Menu");
      /* //////////////////////////////////////// */
      
      
      
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
	
   public static void addMain(Container main, ActionListener AL) {
      main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
      JPanel left = new JPanel();
      JPanel dataNotes = new JPanel();
      JPanel notesArea = new JPanel();
      JPanel dataArea = new JPanel();
      JLabel notesLabel = new JLabel("Notes: ");
      JTextArea notesLoc = new JTextArea("Notes entered will apear here.", 5, 50);
      JScrollPane notesScroll = new JScrollPane(notesLoc);
      notesLoc.setEditable(false); 
      Object[][] testData = new Object[100][10];
      totalsTable = new JTable(testData, columnNames); //DUMMY DATA; FOR DISPLAY PURPOSES ONLY
      totalsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      JScrollPane scroll = new JScrollPane(totalsTable);
      scroll.setPreferredSize(new Dimension(500, 250));
      scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      dataNotes.setLayout(new BoxLayout(dataNotes, BoxLayout.Y_AXIS));
      left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
      left.add(Box.createVerticalGlue());
      left.add(Box.createRigidArea(new Dimension(0, 100)));
      left.add(but[0]);
      left.add(Box.createRigidArea(new Dimension(0, 50)));
      left.add(but[1]);
      left.add(Box.createRigidArea(new Dimension(0, 50)));
      left.add(but[6]);
      left.add(Box.createRigidArea(new Dimension(0, 50)));
      left.add(but[7]);
      left.add(Box.createRigidArea(new Dimension(0, 50)));
      left.add(Box.createVerticalGlue());
      dataNotes.add(scroll);
      dataNotes.add(Box.createRigidArea(new Dimension(0, 30)));
      notesArea.add(notesLabel);
      notesArea.add(notesScroll);
      dataNotes.add(notesArea);
      dataNotes.add(but[5]);
      bigTitle(main, "Park Overview");
      dataArea.add(Box.createHorizontalGlue());
      dataArea.add(left);
      dataArea.add(Box.createRigidArea(new Dimension(100, 400)));
      dataArea.add(dataNotes);
      dataArea.add(Box.createHorizontalGlue());
      main.add(dataArea);
   }
	
   public static void addReportScreen(Container main, ActionListener AL) {
      main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
      JPanel left = new JPanel();
      JPanel reportArea = new JPanel();
      JPanel dataArea = new JPanel();
      Object[][] dummyData = new Object[10][10];
      reportTable = new JTable(dummyData, columnNames);
      reportTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      JScrollPane scrollPane = new JScrollPane(reportTable);
      scrollPane.setPreferredSize(new Dimension(0, 200));
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      reportArea.setLayout(new BoxLayout(reportArea, BoxLayout.Y_AXIS));
      left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
      left.add(Box.createVerticalGlue());
      left.add(Box.createRigidArea(new Dimension(0, 100)));
      left.add(Box.createVerticalGlue());
      JPanel reportOptions = new JPanel();
      JLabel parkName = new JLabel("Park: ");
      nameList = new JComboBox<String>(parkNames);
      nameList.setPreferredSize(new Dimension(250, 25));
      JLabel dateMonth = new JLabel("Month: ");
      monthList = new JComboBox<Integer>(Months);
      JLabel dateYear = new JLabel("Year: ");
      yearList = new JComboBox<Integer>();
   	
      reportOptions.add(parkName);
      reportOptions.add(nameList);
      reportOptions.add(Box.createRigidArea(new Dimension(20, 0)));
      reportOptions.add(dateMonth);
      reportOptions.add(monthList);
      reportOptions.add(Box.createRigidArea(new Dimension(20, 0)));
      reportOptions.add(dateYear);
      reportOptions.add(yearList);
      reportOptions.add(Box.createRigidArea(new Dimension(20, 0)));
      reportOptions.add(but[4]);
      reportArea.add(reportOptions);
      reportArea.add(Box.createRigidArea(new Dimension(0, 50)));
      reportArea.add(scrollPane);
      reportArea.add(but[3]);
      bigTitle(main, "Reports");
      dataArea.add(Box.createHorizontalGlue());
      dataArea.add(left);
      dataArea.add(Box.createRigidArea(new Dimension(100, 0)));
      dataArea.add(reportArea);
      dataArea.add(Box.createHorizontalGlue());
      main.add(dataArea);
   }
   public static void createButtons(ActionListener AL) {
      but[0] = new JButton("Add Data");
      but[1] = new JButton("Edit Data");
      but[2] = new JButton("Notes");
      but[3] = new JButton("Main Menu");
      but[4] = new JButton("Create");
      but[5] = new JButton("Add Notes");
      but[6] = new JButton("Graphs");
      but[7] = new JButton("Report");
      for (int i = 0; i < but.length; i++) {
         but[i].addActionListener(AL);
      } 
   }
	
   public static void bigTitle(Container c, String title) {
      JLabel text = new JLabel(title, JLabel.CENTER);
      text.setFont(new Font("Arial", Font.BOLD, 30));
      c.add(Box.createRigidArea(new Dimension(0, 5)));
      text.setAlignmentX(Component.CENTER_ALIGNMENT);
      c.add(Box.createRigidArea(new Dimension(0, 30)));
      c.add(text);
   }
}