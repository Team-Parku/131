import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.Vector;

public class ReportScreen extends JFrame {

   public static final int HEIGHT = 600;
   public static final int WIDTH = 1000;

   static JFrame frm;
	static CardLayout contentPaneLayout;
	static JPanel contentPane;
   static JTable reportTable = new JTable();
   static DefaultTableModel DTM = new DefaultTableModel();
   static JButton create = new JButton("Create");
   static Vector data;
   static Vector row;
   static Vector columnNames = new Vector();
   static JScrollPane scrollPane;
   static JTextField curParkDisplay;
   private static String parkName;
      
   private static String[] columnNames2 = {"Month", "Year", "Vehicle", "Non-Vehicle", "Total Attendance", "Total Passes", "Site Conversion Factor", "Free Day Conversion Factor",
       "Paid Day Conversion Factor"};
   private static String[] parkNames = {"Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", "Oceano Dunes", "Ocotillo Wells", "Prairie City"};
   private static JComboBox<String> nameList;
      
   Connection conn = null;
   ResultSet rs = null;
   ResultSet rs2 = null;
   
   public ReportScreen() {
      //conn = sqlConnection.dbConnector();
      createScreen();
   }
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
			public void run() {
            try {
               ReportScreen screen = new ReportScreen();
               screen.frm.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   private void createScreen() {
      for(int i = 0; i < columnNames2.length; i++) {
         columnNames.addElement(columnNames2[i]);
      }
      reportTable.setModel(DTM);
      frm = new JFrame();
      JPanel main = new JPanel();
      main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		JPanel left = new JPanel();
		JPanel reportArea = new JPanel();
		JPanel dataArea = new JPanel();
		Object[][] dummyData = new Object[15][10];
		reportTable = new JTable(data, columnNames);
		reportTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane = new JScrollPane(reportTable);
		scrollPane.setPreferredSize(new Dimension(800, 200));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		reportArea.setLayout(new BoxLayout(reportArea, BoxLayout.Y_AXIS));
		JPanel reportOptions = new JPanel();
		JLabel parkName = new JLabel("Park: ");
		nameList = new JComboBox<String>(parkNames);
      JLabel currentPark = new JLabel("Current Park Displayed: ");
      curParkDisplay = new JTextField();
      curParkDisplay.setPreferredSize(new Dimension(250, 25));
      curParkDisplay.setEditable(false);
		nameList.setPreferredSize(new Dimension(250, 25));
		
		reportOptions.add(parkName);
		reportOptions.add(nameList);
      reportOptions.add(currentPark);
      reportOptions.add(curParkDisplay);
		reportOptions.add(Box.createRigidArea(new Dimension(20, 0)));
		reportOptions.add(create);
		reportArea.add(reportOptions);
		reportArea.add(Box.createRigidArea(new Dimension(0, 50)));
		reportArea.add(scrollPane);
		bigTitle(main, "Reports");
		dataArea.add(Box.createHorizontalGlue());
		dataArea.add(Box.createRigidArea(new Dimension(100, 0)));
		dataArea.add(reportArea);
		dataArea.add(Box.createHorizontalGlue());
		main.add(dataArea);
      frm.add(main);
      
      frm.setSize(WIDTH, HEIGHT);
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
