/* allyson.hansen@parks.ca.gov
 * jason.bariel@parks.ca.gov
 * robbie.holcomb@parks.ca.gov
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HomeScreen implements ActionListener {
	
	static JFrame frm;
	static CardLayout contentPaneLayout;
	static JPanel contentPane;
	static JPanel buttonsPanel;
	static JTable totalsTable = new JTable();
	static JTable reportTable = new JTable();
	/*private TableModel Model = new DefaultTableModel(data, columnNames) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}; */
	
	
	private static JButton[] but = new JButton[6];
	private static String[] columnNames = {"Date", "Vehicles", "Non-Vehicles", "Passes", "Column 5", "Column 6", "awefawefa"};
	private static JComboBox<String> yearList;
	private static JComboBox<String> monthList;
	private static JComboBox<String> nameList;
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i = 0; i < but.length - 1; i++) {
			if (source == but[i]) {
				contentPaneLayout.show(contentPane, (String) e.getActionCommand());
			} else if (source == but[4]) {
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
		frm = new JFrame("OVR Attendance");
		contentPane = (JPanel) frm.getContentPane();
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
     //  contentPane.add(Login, "Login");
     //  contentPaneLayout.show(Login, "Login");
		frm.pack();
		frm.setSize(width, height);
		frm.setResizable(false);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
      
      
      /* //////////////////////////////////////// */
      contentPaneLayout.show(contentPane, "Main Menu");
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
      but[0].addActionListener(AL);
      left.add(but[1]);
      left.add(Box.createRigidArea(new Dimension(0, 50)));
      but[1].addActionListener(AL);
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
		String[] listData = {"", "Name x", "name y", "name z"};
		nameList = new JComboBox<String>(listData);
		nameList.setPreferredSize(new Dimension(250, 25));
		JLabel dateMonth = new JLabel("Month: ");
		monthList = new JComboBox<String>(listData);
		JLabel dateYear = new JLabel("Year: ");
		yearList = new JComboBox<String>(listData);
		
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
