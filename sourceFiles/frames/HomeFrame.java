package frames;

import entities.*;
import repositories.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;


public class HomeFrame extends JFrame implements ActionListener {

    JButton logoutBt=new JButton("Logout");
    JButton manageMedBt = new JButton("Manage Medicines");
    JButton sellMedBt = new JButton("Sell medicine");
    JButton manageEmpBt= new JButton("Manage Employees");
	JButton changePasswordBt = new JButton("Change Password");

	Person user;
    
    public HomeFrame(Person user){
		setTitle("Home");
		setSize(1200,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.user = user;
		
		logoutBt.setBounds(1070,20,80,20); //Logout button size
        logoutBt.addActionListener(this);
        add(logoutBt); 

        manageMedBt.setBounds(510,150,200,30); //Manage Medicine button size
        manageMedBt.addActionListener(this);
        add(manageMedBt);

        manageEmpBt.setBounds(510,250,200,30); //Manage emp button size
        manageEmpBt.addActionListener(this);
        add(manageEmpBt);

        sellMedBt.setBounds(510,350,200,30); //Sell med button size
        sellMedBt.addActionListener(this);
        add(sellMedBt);
		
		changePasswordBt.setBounds(510,450,200,30);
		changePasswordBt.addActionListener(this);
		add(changePasswordBt);
		
		 setVisible(true);
}

  public void actionPerformed(ActionEvent a){
  	if(a.getSource()==logoutBt){
  		new LoginFrame();
  		this.setVisible(false);
    }
	
    else if(a.getSource()==manageEmpBt){
		if(user.getStatus().equals("manager")){
			new ManageEmpFrame(user);
			this.setVisible(false);
		}
		else{
			JOptionPane.showMessageDialog(null,"You can't access","Access denied",JOptionPane.WARNING_MESSAGE);	
		}
	}
    else if(a.getSource()==manageMedBt){
      
		if(user.getStatus().equals("manager")){
			new ManageMedFrame(user);
			this.setVisible(false);
		}
		else{
			JOptionPane.showMessageDialog(null,"You can't access","Access denied",JOptionPane.WARNING_MESSAGE);	
		}
    }
    else if(a.getSource()==sellMedBt){
  		new SaleFrame(user);
  		this.setVisible(false);
    }
	else if(a.getSource()==changePasswordBt){
		new ChangePasswordFrame(user);
		this.setVisible(false);
	}
  }
}