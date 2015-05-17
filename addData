
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
	private JTextField vehicle;
	private JTextField nonVehicle;
	private JTextField totalPasses;
   private JTextField totalAttendance;
   private JTextField sites;
	private JTextField freeDayUse;
	private JTextField paidDayUse;
   private JTextField date;
   
   //variables from textfields
	private int totalVehicle = 0;
	private int totPasses = 0;
	private int numVehicle = 0;
	private int numNonVehicle = 0;

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
		
		JComboBox selectParks = new JComboBox();
		selectParks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectParks.setPreferredSize(new Dimension(110, 35));
		selectParks.setMinimumSize(new Dimension(11000, 20));
		selectParks.setBackground(SystemColor.inactiveCaptionBorder);
		selectParks.setModel(new DefaultComboBoxModel(new String[] {"Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", "Oceano Dunes", "Ocohillo Wells", "Prairie City"}));
		top.add(selectParks);
		
		//middle of layout
		JPanel middle = new JPanel();
		add(middle, BorderLayout.CENTER);
		middle.setLayout(null);
		
		//attendance title
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setBounds(199, 11, 236, 51);
		middle.add(lblAttendance);
		
		//passes title
		JLabel lblPasses = new JLabel("Passes");
		lblPasses.setMaximumSize(new Dimension(56, 14));
		lblPasses.setMinimumSize(new Dimension(56, 14));
		lblPasses.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblPasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasses.setBounds(548, 11, 244, 51);
		middle.add(lblPasses);
		
		//vehicle label and textfield
		JLabel lblNewLabel_1 = new JLabel("Vehicle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(243, 73, 147, 50);
		middle.add(lblNewLabel_1);
		
		vehicle = new JTextField();
		vehicle.setBounds(253, 134, 137, 30);
		middle.add(vehicle);
		vehicle.setColumns(10);
		
		//nonvehicle label and textfield
		JLabel lblNewLabel_2 = new JLabel("Non Vehicle");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(220, 175, 189, 51);
		middle.add(lblNewLabel_2);

		nonVehicle = new JTextField();
		nonVehicle.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nonVehicle.setBounds(253, 231, 137, 30);
		middle.add(nonVehicle);
		nonVehicle.setColumns(10);
		

		

		//total attendance label and textfield
		JLabel lblTotalAttendance = new JLabel("Total Attendance");
		lblTotalAttendance.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTotalAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAttendance.setBounds(220, 272, 189, 51);
		middle.add(lblTotalAttendance);
		
		totalAttendance = new JTextField();
		totalAttendance.setBounds(253, 341, 137, 30);
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
		
		JLabel conversionLabel = new JLabel("Total Conversion Factors");
		conversionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		conversionLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		conversionLabel.setBounds(540, 180, 278, 40);
		middle.add(conversionLabel);
		
		//conversion label and text field for site
		JLabel lblSize = new JLabel("Sites");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setBounds(603, 231, 110, 30);
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
		lblEnterDate.setBounds(25, 129, 123, 30);
		middle.add(lblEnterDate);
		
		JLabel lblMonthyear = new JLabel("(Month/Year)");
		lblMonthyear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMonthyear.setBounds(25, 159, 123, 30);
		middle.add(lblMonthyear);
		
		date = new JTextField();
		date.setFont(new Font("Tahoma", Font.PLAIN, 23));
		date.setBounds(35, 195, 108, 30);
		middle.add(date);
		date.setColumns(10);
		

		//bottom of border layout
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new GridLayout(0, 4, 10, 0));
		
		//need label to center buttons keep it
		JLabel lblNewLabel_3 = new JLabel("");
		bottom.add(lblNewLabel_3);
		
		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(55, 40));
      back.setFont(new Font("Tahoma", Font.PLAIN, 27));
		bottom.add(back);
		JButton submit = new JButton("Submit");
      submit.setFont(new Font("Tahoma", Font.PLAIN, 27));
		bottom.add(submit);
		
      
      HomeScreen main = new HomeScreen();
      
      AL1 = new ActionListener(){      
         public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == back){
               CardLayout cardLayout = (CardLayout) contentPane.getLayout();
               cardLayout.next(contentPane);   
            }
            if(ae.getSource() == submit){
                        
            }
         }
      };
      back.addActionListener(AL1);
      submit.addActionListener(AL1);

	}
	
	      /* 
			if(source.equals("Carnegie")){
			totPasses =  Integer.parseInt(totalPasses.getText());
			numVehicle = Integer.parseInt(vehicle.getText());
			numNonVehicle = Integer.parseInt(nonVehicle.getText());
			when adding in total attendance
			//totAttendence = numVehicle + numNonVehicle;
			//or totAttendence = Integer.parseInt(totalAttendence.getText()); (if decide to add a totalattendence lable and textfield)
			 *
			 * 1.set the data into data base
			 
			}
         
			if(source.equals("Clay Pit")){
				totPasses =  Integer.parseInt(totalPasses.getText());
				numVehicle = Integer.parseInt(vehicle.getText());
				numNonVehicle = Integer.parseInt(nonVehicle.getText());
				//when adding in total attendance
				//totAttendence = numVehicle + numNonVehicle;
				//or totAttendence = Integer.parseInt(totalAttendence.getText()); (if decide to add a totalattendence lable and textfield)
				/*
				 * 1.set the data into data base
				 * 2.display to screen what was added 
				 *
			}
			if(source.equals("Heber Dunes")){
				totPasses =  Integer.parseInt(totalPasses.getText());
				numVehicle = Integer.parseInt(vehicle.getText());
				numNonVehicle = Integer.parseInt(nonVehicle.getText());
				//when adding in total attendance
				//totAttendence = numVehicle + numNonVehicle;
				//or totAttendence = Integer.parseInt(totalAttendence.getText()); (if decide to add a totalattendence lable and textfield)
				/*
				 * 1.set the data into data base
				 * 2.display to screen what was added 
				 *
			}
			if(source.equals("Hollister Hills")){
				totPasses =  Integer.parseInt(totalPasses.getText());
				numVehicle = Integer.parseInt(vehicle.getText());
				numNonVehicle = Integer.parseInt(nonVehicle.getText());
				//when adding in total attendance
				//totAttendence = numVehicle + numNonVehicle;
				//or totAttendence = Integer.parseInt(totalAttendence.getText()); (if decide to add a totalattendence lable and textfield)
				/*
				 * 1.set the data into data base
				 * 2.display to screen what was added 
				 *
			}
			if(source.equals("Hungry Valley")){
				totPasses =  Integer.parseInt(totalPasses.getText());
				numVehicle = Integer.parseInt(vehicle.getText());
				numNonVehicle = Integer.parseInt(nonVehicle.getText());
				//when adding in total attendance
				//totAttendence = numVehicle + numNonVehicle;
				//or totAttendence = Integer.parseInt(totalAttendence.getText()); (if decide to add a totalattendence lable and textfield)
				/*
				 * 1.set the data into data base
				 * 2.display to screen what was added 
				 *
			}
			if(source.equals("Oceano Dunes")){
				totPasses =  Integer.parseInt(totalPasses.getText());
				numVehicle = Integer.parseInt(vehicle.getText());
				numNonVehicle = Integer.parseInt(nonVehicle.getText());
				//when adding in total attendance
				//totAttendence = numVehicle + numNonVehicle;
				//or totAttendence = Integer.parseInt(totalAttendence.getText()); (if decide to add a totalattendence lable and textfield)
				
				 * 1.set the data into data base
				 * 2.display to screen what was added 
				 
			}
		}*/
}//end class
