import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class addNotes extends JPanel {
   private BorderLayout contentPaneLayout;
   private JPanel contentPane;
   private JLabel label = new JLabel();
   private JTextField txt = new JTextField();
   private JButton back = new JButton();
   private JButton enterNotes = new JButton();
   private JButton search = new JButton();
   private ActionListener AL2;

   public addNotes() 
    {
        init();
    }

   private void init(){ 
       
      setLayout(new BorderLayout());
      JPanel top = new JPanel(new FlowLayout());
      label =  new JLabel("Notes", JLabel.CENTER);
      top.add(label);
      add(top,BorderLayout.NORTH);
      
      JPanel middle = new JPanel(new GridLayout(3,2,2,2));
      JPanel middle1 = new JPanel(new FlowLayout());
      label =  new JLabel("Search for date", JLabel.LEFT);
      txt = new JTextField("",10);
      middle1.add(label);
      middle1.add(txt);
      JPanel middle3 = new JPanel(new FlowLayout());
      middle3.add(search = new JButton("Search"));
      JPanel middle2 = new JPanel(new FlowLayout());
      label = new JLabel("Enter note",JLabel.LEFT);
      txt = new JTextField("");
      txt.setPreferredSize(new Dimension(400,50));
      middle2.add(label);
      middle2.add(txt);
      middle.add(middle1);
      middle.add(middle3);
      middle.add(middle2);
      add(middle,BorderLayout.CENTER);
      
      JPanel bottom = new JPanel(new FlowLayout());
      bottom.add(back = new JButton("Back"));
      bottom.add(enterNotes = new JButton("Enter Notes"));
      add(bottom,BorderLayout.SOUTH);
      
      
      
      
      enterNotes.addActionListener(AL2);
      back.addActionListener(AL2);
      search.addActionListener(AL2);
           
   }
   public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source == back){
      /*
       sends user back to main screen
      */
        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.previous(contentPane);
         
		}
		if(source == search){
		/*
       search for specific month/year
      */	
		}
		if(source == enterNotes){
      
      /*(code)
       * enterNotes.setText(note);
       * (next step)
       * transfer the note to the front screen
       * switch to main page
      */
			
		}
   }
}