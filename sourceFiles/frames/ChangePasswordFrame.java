package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class ChangePasswordFrame extends JFrame implements ActionListener,MouseListener{
	
	JButton logout=new JButton("Logout");
    JButton back=new JButton("Back");
	
	JLabel currentPasswordLb = new JLabel("Current Password");
	JPasswordField currentPasswordTf = new JPasswordField();
	JLabel newPasswordLb = new JLabel("New Password");
	JPasswordField newPasswordTf = new JPasswordField();
	
	JButton showCurrentPasswordBt = new JButton("Show");
	JButton showNewPasswordBt = new JButton("Show");
    JButton doneBt=new JButton("Done");
	
	Person user;
	PersonRepository pr = new PersonRepository();
	public ChangePasswordFrame(Person user){
		setTitle("Change Password");
		setSize(1200,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.user = user;
		
		
		logout.setBounds(1070,20,80,20); 
        logout.addActionListener(this);
        add(logout); 

        back.setBounds(1075,50,70,20); 
        back.addActionListener(this);
        add(back);
		
		currentPasswordLb.setBounds(510,250,150,30);
		add(currentPasswordLb);
		currentPasswordTf.setBounds(510,290,150,30);		//current password
		add(currentPasswordTf);
		
		
		showCurrentPasswordBt.setBounds(680,290,80,20);
		add(showCurrentPasswordBt);
		showCurrentPasswordBt.addMouseListener(this);
		
		newPasswordLb.setBounds(510,330,150,30);
		add(newPasswordLb);
		newPasswordTf.setBounds(510,370,150,30);
		add(newPasswordTf);
		
		showNewPasswordBt.setBounds(680,370,80,20);
		add(showNewPasswordBt);
		showNewPasswordBt.addMouseListener(this);
		
		doneBt.setBounds(545,420,75,30);
		add(doneBt);
		doneBt.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==logout){
			new LoginFrame();
			this.setVisible(false);
		}
		else if(a.getSource()==back){
			new HomeFrame(user);
			this.setVisible(false);
		}
		else if(a.getSource()==doneBt){
			user.setPassword(newPasswordTf.getText());
			pr.updateUser(user);
			JOptionPane.showMessageDialog(this,"Password changed successfully","Succesful",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void mousePressed(MouseEvent me){
		if(me.getSource()==showCurrentPasswordBt){
			currentPasswordTf.setEchoChar((char)0);
		}
		else if(me.getSource()==showNewPasswordBt){
			newPasswordTf.setEchoChar((char)0);
		}
	}
    
	public void mouseReleased(MouseEvent me){
		if(me.getSource()==showCurrentPasswordBt){
			currentPasswordTf.setEchoChar('*');
		}
		else if(me.getSource()==showNewPasswordBt){
			newPasswordTf.setEchoChar('*');
		}
	}
	
    public void mouseClicked(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
}