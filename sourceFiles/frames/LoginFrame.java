package frames;

import entities.*;
import repositories.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;



public class LoginFrame extends JFrame implements ActionListener,MouseListener{

    JTextField userIdTf = new JTextField();
    JPasswordField passwordTf = new JPasswordField();
    JLabel userIdLb = new JLabel("User ID:");
    JLabel passwordLb = new JLabel("Password:");
   
    
    JButton showBt=new JButton("Show");
    JButton loginBt=new JButton("Login");
    
	PersonRepository pr;
	Person user;
	
    public LoginFrame(){
        super("Login");
        setSize(1200,700);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       

        loginBt.setBounds(550,450,80,30); //Login button size
        loginBt.addActionListener(this);
        add(loginBt);

        showBt.setBounds(690,300,80,30); //Show button size
        showBt.addMouseListener(this);
        add(showBt);
        
        userIdTf.setBounds(480,200,200,40); //Username Textfield size
        add(userIdTf);
        userIdLb.setBounds(405,200,100,30); //Username Label size
        add(userIdLb);

        passwordTf.setBounds(480,300,200,40); //Password Textfield size
        add(passwordTf);

        passwordLb.setBounds(405,300,100,30); //Password label size
        add(passwordLb);
     }
    
	public void mousePressed(MouseEvent me){
        passwordTf.setEchoChar((char)0);
    }
    
	public void mouseReleased(MouseEvent me){
         passwordTf.setEchoChar('*');
    }

    public void mouseClicked(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
	
    public void actionPerformed(ActionEvent a){
		if(userIdTf.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Username required","ERROR",JOptionPane.WARNING_MESSAGE);
			}
		else if(passwordTf.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Password required","ERROR",JOptionPane.WARNING_MESSAGE);
        }
		else{
			pr = new PersonRepository();
			user = pr.getUser(Integer.parseInt(userIdTf.getText()),passwordTf.getText());
			if(user!=null){
					new HomeFrame(user);
					this.setVisible(false);
				}
			else{
				JOptionPane.showMessageDialog(null,"User not found.\nTry Again","ERROR",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}