import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultComboBoxModel;


class addData2 extends JPanel {
	
	//buttons
	private JButton btnSubmit = new JButton();
	private JButton btnBack = new JButton();
		
		
	//textfields
	private JTextField vehicle;
	private JTextField nonVehicle;
	private JTextField totalPasses;
   private JTextField totalAttendance;
		
	//variables from textfields
	private int totalVehicle = 0;
	private int totPasses = 0;
	private int numVehicle = 0;
	private int numNonVehicle = 0;

   private ActionListener AL1;
		

	/**
	 * Launch the application.
	 */
	
   public addData2(){
      init();
   }

	private void init() {
	 
  
		setPreferredSize(new Dimension(1000, 600));
		setLayout(new BorderLayout(0, 0));
		
		JPanel top = new JPanel();
		add(top, BorderLayout.NORTH);
		top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Select Park");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		top.add(lblNewLabel);
		
		JComboBox selectParks = new JComboBox();
		selectParks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectParks.setPreferredSize(new Dimension(110, 35));
		selectParks.setMinimumSize(new Dimension(11000, 20));
		selectParks.setBackground(SystemColor.inactiveCaptionBorder);
		selectParks.setModel(new DefaultComboBoxModel(new String[] {"Carnegie", "Clay Pit", "Heber Dunes", "Hollister Hills", "Hungry Valley", "Oceano Dunes", "Ocohillo Wells", "Prairie City"}));
		top.add(selectParks);
		
		JPanel middle = new JPanel();
		add(middle, BorderLayout.CENTER);
		middle.setLayout(null);
		
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setBounds(219, 28, 236, 51);
		middle.add(lblAttendance);
		
		JLabel lblPasses = new JLabel("Passes");
		lblPasses.setMaximumSize(new Dimension(56, 14));
		lblPasses.setMinimumSize(new Dimension(56, 14));
		lblPasses.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblPasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasses.setBounds(550, 28, 244, 51);
		middle.add(lblPasses);
		
		JLabel lblNewLabel_1 = new JLabel("Vehicle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(246, 105, 147, 50);
		middle.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Non Vehicle");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(246, 233, 153, 45);
		middle.add(lblNewLabel_2);
		
		vehicle = new JTextField();
		vehicle.setBounds(246, 166, 147, 40);
		middle.add(vehicle);
		vehicle.setColumns(10);
		
		nonVehicle = new JTextField();
		nonVehicle.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nonVehicle.setBounds(246, 294, 147, 40);
		middle.add(nonVehicle);
		nonVehicle.setColumns(10);
		
		totalPasses = new JTextField();
		totalPasses.setFont(new Font("Tahoma", Font.PLAIN, 23));
		totalPasses.setBounds(604, 294, 147, 40);
		middle.add(totalPasses);
		totalPasses.setColumns(10);
		
		totalAttendance = new JTextField();
		totalAttendance.setBounds(246, 438, 147, 40);
		middle.add(totalAttendance);
		totalAttendance.setColumns(10);
		
		JLabel lblTotalAttendance = new JLabel("Total Attendance");
		lblTotalAttendance.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTotalAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAttendance.setBounds(216, 364, 200, 63);
		middle.add(lblTotalAttendance);
		
		JLabel lblTotalPasses = new JLabel("Total Passes");
		lblTotalPasses.setFont(new Font("Traditional Arabic", Font.PLAIN, 23));
		lblTotalPasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPasses.setBounds(604, 238, 147, 40);
		middle.add(lblTotalPasses);
		
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new GridLayout(0, 4, 10, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		bottom.add(lblNewLabel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.setPreferredSize(new Dimension(55, 40));
		bottom.add(btnBack);
		JButton btnSubmit = new JButton("Submit");
		bottom.add(btnSubmit);

		btnBack.addActionListener(AL1);
		btnSubmit.addActionListener(AL1);
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		//String something = (String) youritem.getSelectedItem(wutever items is);
		
		if (source == btnBack){
		
		 //* when pushed goes back to main screen
		 
		 
		}
		if(source == btnSubmit){
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
	   }
	
   }
}
