/**********************************\
*Author: Matthew Yamamoto          *
*                                  *
*GUI:  Add Data                    *
*                                  *
*Last Edit: 5/19/15                *
\**********************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultComboBoxModel;


class addData2 extends JPanel{
   private JPanel contentPane;
	
	//buttons
	private JButton submit = new JButton();
	private JButton back = new JButton();
		
		
	//textfields
	private JTextField pVehicle;
	private JTextField nonPVehicle;
	private JTextField totalPasses;
   private JTextField totalAttendance;
   private JTextField sites;
	private JTextField freeDayUse;
	private JTextField paidDayUse;
   private JTextField date;
   private JTextField fVehicle;
   private JTextField fNonVehicle;
   private JTextField overNightSites;
   private JTextField overNightOther;   
   private String[] parkList ={"---","Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", "Oceano Dunes", "Ocohillo Wells", "Prairie City"};
   
   //variables from textfields
	private String totalVehicle = "";
	private String totPasses = "";
	private String numPVehicle = "";
	private String numPNonVehicle = "";
   private String numFVehicle = "";
   private String numFNonVehicle = "";
   private String ONSite = "";
   private String ONOther = "";
   private String siteCFT = "";
   private String paidDayUseCFT = "";
   private String freeDayUseCFT = "";
   private String searchDate = "";
   private String totalAttend = "";
   private JComboBox<String> parkSelect;
   private String parkSelection = "";
   private ActionListener AL1;		

	/**
	 * Launch the application.
	 */
	
   public addData2(JPanel contentPane){
      this.contentPane = contentPane;
      init();
   }

	private void init() {
	 setPreferredSize(new Dimension(1000, 600));
		setLayout(new BorderLayout(0, 0));
		
		//top of layout
		JPanel top = new JPanel();
		add(top, BorderLayout.NORTH);
		top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel parks = new JLabel("Select Park");
		parks.setFont(new Font("Tahoma", Font.PLAIN, 27));
		top.add(parks);
		
		JComboBox selectParks = new JComboBox<String>(parkList);
		selectParks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectParks.setPreferredSize(new Dimension(130, 35));
		selectParks.setMinimumSize(new Dimension(11000, 20));
		selectParks.setBackground(SystemColor.inactiveCaptionBorder);
		top.add(selectParks);
		
		
		//middle of layout
		JPanel middle = new JPanel();
		add(middle, BorderLayout.CENTER);
		middle.setLayout(null);
		
		//attendance title
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setBounds(164, 11, 236, 51);
		middle.add(lblAttendance);
		
		//passes title
		JLabel lblPasses = new JLabel("Passes");
		lblPasses.setMaximumSize(new Dimension(56, 14));
		lblPasses.setMinimumSize(new Dimension(56, 14));
		lblPasses.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblPasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasses.setBounds(548, 11, 244, 51);
		middle.add(lblPasses);
		
		//paid vehicle label and textfield
		JLabel paidDay = new JLabel("Paid Day");
		paidDay.setHorizontalAlignment(SwingConstants.CENTER);
		paidDay.setFont(new Font("Tahoma", Font.PLAIN, 23));
		paidDay.setBounds(166, 125, 94, 40);
		middle.add(paidDay);
		
		JLabel lblNewLabel_1 = new JLabel("Vehicle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(42, 175, 110, 50);
		middle.add(lblNewLabel_1);
		
		pVehicle = new JTextField();
		pVehicle.setBounds(164, 190, 94, 30);
		middle.add(pVehicle);
		pVehicle.setColumns(10);
		
		// paid nonvehicle label and textfield
		JLabel lblNewLabel_2 = new JLabel("Non Vehicle");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 250, 189, 51);
		middle.add(lblNewLabel_2);

		nonPVehicle = new JTextField();
		nonPVehicle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nonPVehicle.setBounds(164, 260, 94, 30);
		middle.add(nonPVehicle);
		nonPVehicle.setColumns(10);
		
		//total attendance label and textfield
		JLabel lblTotalAttendance = new JLabel("Total Attendance");
		lblTotalAttendance.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTotalAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAttendance.setBounds(288, 435, 189, 51);
		middle.add(lblTotalAttendance);
		
		totalAttendance = new JTextField();
      totalAttendance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		totalAttendance.setBounds(499, 445, 137, 30);
		middle.add(totalAttendance);
		totalAttendance.setColumns(10);
		
		//total passes label and textfield
		JLabel lblTotalPasses = new JLabel("Total Passes");
		lblTotalPasses.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTotalPasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPasses.setBounds(604, 81, 147, 40);
		middle.add(lblTotalPasses);
		
		totalPasses = new JTextField();
		totalPasses.setFont(new Font("Tahoma", Font.PLAIN, 23));
		totalPasses.setBounds(614, 129, 137, 30);
		middle.add(totalPasses);
		totalPasses.setColumns(10);
		
		JLabel conversionLabel = new JLabel("Conversion Factor Totals");
		conversionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		conversionLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		conversionLabel.setBounds(540, 180, 323, 40);
		middle.add(conversionLabel);
		
		//conversion label and text field for site
		JLabel lblSize = new JLabel("Sites");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize.setBounds(604, 231, 80, 30);
		middle.add(lblSize);
		
		sites = new JTextField();
		sites.setBounds(735, 236, 80, 30);
		middle.add(sites);
		sites.setColumns(10);
		
		//conversion label and textfield for paid day use
		JLabel lblPaidDayUse = new JLabel("Paid Day Use");
		lblPaidDayUse.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPaidDayUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaidDayUse.setBounds(548, 358, 150, 30);
		middle.add(lblPaidDayUse);
		
		paidDayUse = new JTextField();
		paidDayUse.setBounds(735, 358, 80, 30);
		middle.add(paidDayUse);
		paidDayUse.setColumns(10);
		
		//conversion label and textfield free day use
		JLabel lblFreeDayUse = new JLabel("Free Day Use");
		lblFreeDayUse.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFreeDayUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblFreeDayUse.setBounds(548, 292, 150, 30);
		middle.add(lblFreeDayUse);
		
		freeDayUse = new JTextField();
		freeDayUse.setBounds(735, 293, 80, 30);
		middle.add(freeDayUse);
		freeDayUse.setColumns(10);
     
      //enter date label and texfields
      JLabel lblEnterDate = new JLabel("Enter Date");
		lblEnterDate.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEnterDate.setBounds(10, 11, 123, 30);
		middle.add(lblEnterDate);
		
		JLabel lblMonthyear = new JLabel("Month/Year");
		lblMonthyear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMonthyear.setBounds(20, 33, 80, 25);
		middle.add(lblMonthyear);
		
		JLabel numsign = new JLabel("(##/##)");
		numsign.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numsign.setHorizontalAlignment(SwingConstants.CENTER);
		numsign.setBounds(0, 52, 108, 30);
		middle.add(numsign);
		
		date = new JTextField();
		date.setFont(new Font("Tahoma", Font.PLAIN, 23));
		date.setBounds(15, 80, 75, 30);
		middle.add(date);
		date.setColumns(10);		
		
		//freeday Vehicle nonPVehicle
		JLabel freeDay = new JLabel("Free Day");
		freeDay.setFont(new Font("Tahoma", Font.PLAIN, 23));
		freeDay.setHorizontalAlignment(SwingConstants.CENTER);
		freeDay.setBounds(295, 125, 105, 40);
		middle.add(freeDay);
		
		fVehicle = new JTextField();
		fVehicle.setBounds(306, 190, 94, 30);
		middle.add(fVehicle);
		fVehicle.setColumns(10);
		
		fNonVehicle = new JTextField();
		fNonVehicle.setBounds(306, 260, 94, 30);
		middle.add(fNonVehicle);
		fNonVehicle.setColumns(10);
		
		//overnight sections
		JLabel overNight = new JLabel("Over Night");
		overNight.setFont(new Font("Tahoma", Font.PLAIN, 23));
		overNight.setHorizontalAlignment(SwingConstants.CENTER);
		overNight.setBounds(186, 301, 182, 40);
		middle.add(overNight);
						
		JLabel lblSites = new JLabel("Sites");
		lblSites.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSites.setHorizontalAlignment(SwingConstants.CENTER);
		lblSites.setBounds(186, 366, 69, 17);
		middle.add(lblSites);
		
		JLabel other = new JLabel("Other");
		other.setFont(new Font("Tahoma", Font.PLAIN, 23));
		other.setHorizontalAlignment(SwingConstants.RIGHT);
		other.setBounds(163, 419, 80, 25);
		middle.add(other);
		
		overNightSites = new JTextField();
		overNightSites.setBounds(282, 366, 86, 25);
		middle.add(overNightSites);
		overNightSites.setColumns(10);
		
		overNightOther = new JTextField();
		overNightOther.setBounds(282, 419, 86, 25);
		middle.add(overNightOther);
		overNightOther.setColumns(10);

		//bottom of border layout
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new GridLayout(0, 4, 10, 0));
		
		//need label to center buttons keep it
		JLabel lblNewLabel_3 = new JLabel("");
		bottom.add(lblNewLabel_3);
		
		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(55, 40));
      back.setFont(new Font("Tahoma", Font.PLAIN, 23));
		bottom.add(back);
		JButton submit = new JButton("Submit");
      submit.setFont(new Font("Tahoma", Font.PLAIN, 23));
		bottom.add(submit);				
      
      //HomeScreen main = new HomeScreen();
      
      AL1 = new ActionListener(){      
         public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == back){
               CardLayout cardLayout = (CardLayout) contentPane.getLayout();
               cardLayout.next(contentPane);   
            }
            if(ae.getSource() == submit){
               
               parkSelection = (String) selectParks.getSelectedItem();
               searchDate = getSearchDate();
               totPasses = getTotPasses();
               numPVehicle = getPNumVehicle();
               numPNonVehicle = getPNumNonVehicle();
               numFVehicle = getFNumVehicle();
               numFNonVehicle = getFNumNonVehicle();
               ONOther = getOther();
               ONSite = getSite();
               siteCFT = getSiteCFT();
               paidDayUseCFT = getPaidDayUseCFT();
               freeDayUseCFT = getFreeDayUseCFT();
               
               String A = totalAttendance.getText();
               if(A.isEmpty()){
                  //goes to getTotAttendence() method and 
                  //addes nonPVehicle and Vehicle together to total
                  totalAttend = getTotAttendence();
               }else {
                  //just grabs totalAttendance textfield
                  totalAttend = getTotAttend();
               }
               
               //adding to database
               /*
                  //creating statement for conection.
                  Statement statement = conn.createStatement();
                  // insert the data
                  statement.executeUpdate("INSERT INTO  " + "VALUES ()");
               */
               
               //clear Textfields
               totalPasses.setText("");
               pVehicle.setText("");
               nonPVehicle.setText("");
               fVehicle.setText("");
               fNonVehicle.setText("");
               overNightSites.setText("");
               overNightOther.setText("");
               freeDayUse.setText("");
               sites.setText("");
               totalAttendance.setText("");
               paidDayUse.setText("");
               date.setText("");  
            }
         
         }
     };
      //actionlisteners
      back.addActionListener(AL1);
      submit.addActionListener(AL1);

	}
	//methods to get textfield data
   public String getTotPasses(){
      String A = totalPasses.getText();
      return A;
   }
   
   public String getPNumVehicle(){
      String A = pVehicle.getText();
      return A;
   }
   public String getFNumVehicle(){
      String A = fVehicle.getText();
      return A;
   }
  
   public String getFNumNonVehicle(){
      String A = fNonVehicle.getText();
      return A;
   }
  

   public String getPNumNonVehicle(){
      String A = nonPVehicle.getText();
      return A;
   }
   public String getSiteCFT(){
      String A = sites.getText();
      return A;
   }
   public String getPaidDayUseCFT(){
      String A = paidDayUse.getText();
      return A;

   }
   public String getFreeDayUseCFT(){
      String A = freeDayUse.getText();
      return A;
   }
   public String getSearchDate(){
      String A = date.getText();
      return A;
   }
   public String getTotAttendence(){
      int numPVeh, numPNonVeh, numFVeh, numFNonVeh;
      String fVeh = fVehicle.getText();
      String fNonveh = fNonVehicle.getText();
      String pVeh = pVehicle.getText();
      String pNonveh = nonPVehicle.getText();
      //without this will get integer error
      if(pVeh.isEmpty()){
         numPVeh = 0;
      }else {
         numPVeh = Integer.parseInt(pVehicle.getText());
      }
      if(pNonveh.isEmpty()){
         numPNonVeh = 0;
      }else{
         numPNonVeh = Integer.parseInt(nonPVehicle.getText());
      }
      if(fVeh.isEmpty()){
         numFVeh = 0;
      }else{
         numFVeh = Integer.parseInt(fVehicle.getText());
      }
      if(fNonveh.isEmpty()){
         numFNonVeh = 0;
      }else{
         numFNonVeh = Integer.parseInt(fNonVehicle.getText());
      }
      
      int A = numPVeh + numPNonVeh + numFVeh + numFNonVeh;
      String B = Integer.toString(A);
      return B;
   }
   public String getTotAttend(){
      String A = totalAttendance.getText();
      return A;
   }
   public String getSite(){
      String A = overNightSites.getText();
      return A;
   }
   public String getOther(){
      String A = overNightOther.getText();
      return A;
   }
   
}//end class
