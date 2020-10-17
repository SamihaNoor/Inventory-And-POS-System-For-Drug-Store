package frames;


import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.util.Random;
import entities.*;
import repositories.*;

public class ManageEmpFrame extends JFrame implements ActionListener {

	JTextField searchTf = new JTextField();
	JButton searchBt = new JButton("Search");
	JButton showAllBt = new JButton("Show All");
	
	JTable empTable;
	JScrollPane empTableSP;
	
	JLabel  empIdLb = new JLabel("Emp Id");
	JTextField empIdTf= new JTextField();
	
	JCheckBox load = new JCheckBox("Load");
	
	JLabel  empNameLb = new JLabel("Emp Name");
	JTextField empNameTf= new JTextField();
	
	JLabel  contactLb = new JLabel("Contact");
	JTextField contactTf= new JTextField();
	
	JLabel salaryLb = new JLabel("Salary");
	JTextField salaryTf = new JTextField();
	
	JLabel statusLb = new JLabel("Status");
	JTextField statusTf = new JTextField();
	
	JButton addBt = new JButton("Add");
    JButton removeBt = new JButton("Remove");
	JButton refreshBt = new JButton("Refresh");
	JButton updateBt = new JButton("Update");
	
	JButton logout=new JButton("Logout");
    JButton back=new JButton("Back");
	
	Person user;
	PersonRepository pr = new PersonRepository();
	EmployeeRepository er = new EmployeeRepository();

    public ManageEmpFrame(Person user){
		setSize(1200,700);
		setTitle("Employee Management");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		
		this.user=user;
        
        logout.setBounds(1070,20,80,20); //Logout button size
        logout.addActionListener(this);
        add(logout); 

        back.setBounds(1075,50,70,20); //Back button size
        back.addActionListener(this);
        add(back);

        searchTf.setBounds(550,120,200,30);
		add(searchTf);
		searchBt.setBounds(760,120,80,30);
		add(searchBt);
		searchBt.addActionListener(this);
		
		showAllBt.setBounds(850,120,100,30);
		add(showAllBt);
		showAllBt.addActionListener(this);
		
		String dataM[][] = {{"", "", "", "",""}};
		String headM[] = {"empId", "empName", "contact", "salary", "status"};
		
		empTable = new JTable(dataM,headM);
		empTable.setEnabled(false);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(500,170,600,400);
		add(empTableSP);
		
		empIdLb.setBounds(100,200,60,30);
		add(empIdLb);
		empIdTf.setBounds(170,200,120,30);
		add(empIdTf);
		
		load.setBounds(310,204,60,20);
		add(load);
		load.addActionListener(this);
		
		empNameLb.setBounds(100,250,70,30);
		add(empNameLb);
		empNameTf.setBounds(170,250,120,30);
		add(empNameTf);
		
		contactLb.setBounds(100,300,60,30);
		add(contactLb);
		contactTf.setBounds(170,300,120,30);
		add(contactTf);
		
		salaryLb.setBounds(100,350,60,30);
		add(salaryLb);
		salaryTf.setBounds(170,350,120,30);
		add(salaryTf);
		
		statusLb.setBounds(100,400,60,30);
		add(statusLb);
		statusTf.setBounds(170,400,120,30);
		add(statusTf);
		
		addBt.setBounds(100,450,100,30);
		add(addBt);
		addBt.addActionListener(this);
		
		removeBt.setBounds(210,450,100,30);
		add(removeBt);
		removeBt.addActionListener(this);
		removeBt.setEnabled(false);
		
		refreshBt.setBounds(100,500,100,30);
		add(refreshBt);
		refreshBt.addActionListener(this);
		
		updateBt.setBounds(210,500,100,30);
		add(updateBt);
		updateBt.addActionListener(this);
		updateBt.setEnabled(false);
		
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
		else if(a.getSource()==searchBt){
			if(searchTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
				String dataM[][] = er.searchEmployee(searchTf.getText());
				String headM[] = {"empId", "empName", "contact", "salary", "status"};
				remove(empTableSP);
				
				empTable = new JTable(dataM,headM);
				empTable.setEnabled(false);
				empTableSP = new JScrollPane(empTable);
				empTableSP.setBounds(500,170,600,400);
				add(empTableSP);
				
				this.revalidate();
				this.repaint();
			}
		}
		else if(a.getSource()==showAllBt){
				String dataM[][] = er.getEmployees();
				String headM[] = {"empId", "empName", "contact", "salary", "status"};
				remove(empTableSP);
				
				empTable = new JTable(dataM,headM);
				empTable.setEnabled(false);
				empTableSP = new JScrollPane(empTable);
				empTableSP.setBounds(500,170,600,400);
				add(empTableSP);
				
				this.revalidate();
				this.repaint();
		}
		else if(a.getSource()==load){
			if(empIdTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Employee Id required!!","WARNING",JOptionPane.WARNING_MESSAGE);
				load.setSelected(false);
			}
			else{
				Employee emp = er.getEmployee(Integer.parseInt(empIdTf.getText()));
				if(emp==null){
					JOptionPane.showMessageDialog(this,"No employee for this id","warning",JOptionPane.WARNING_MESSAGE);
					load.setSelected(false);
				}
				else{
					empNameTf.setText(emp.getEmpName());
					contactTf.setText(emp.getContact()+"");
					salaryTf.setText(emp.getSalary()+"");
					statusTf.setText(emp.getStatus());
					updateBt.setEnabled(true);
					removeBt.setEnabled(true);
				}
			}
		}
		else if(a.getSource()==addBt){
			if(empIdTf.getText().equals("") || empNameTf.getText().equals("") || contactTf.getText().equals("") || salaryTf.getText().equals("") || statusTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
				int id = Integer.parseInt(empIdTf.getText());
				String name = empNameTf.getText();
				int contact = Integer.parseInt(contactTf.getText());
				double sal = Double.parseDouble(salaryTf.getText());
				String status = statusTf.getText();
				
				Random rd = new Random();
				String password = rd.nextInt(89999999)+ 10000000 +""; 
			
				Employee emp = new Employee(id,name,contact,sal,status);
				
				Person p = new Person(id,password,status);
				
				er.addEmployee(emp);
				pr.addUser(p);
				JOptionPane.showMessageDialog(this,"id("+id+")  password("+password+")","your info",JOptionPane.INFORMATION_MESSAGE);
				
				String dataM[][] = er.getEmployees();
				String headM[] = {"empId", "empName", "contact", "salary", "status"};
				remove(empTableSP);
				
				empTable = new JTable(dataM,headM);
				empTable.setEnabled(false);
				empTableSP = new JScrollPane(empTable);
				empTableSP.setBounds(500,170,600,400);
				add(empTableSP);
				
				this.revalidate();
				this.repaint();
			}
		}
		else if(a.getSource()==refreshBt){
			searchTf.setText("");
			empIdTf.setText("");
			empNameTf.setText("");
			contactTf.setText("");
			salaryTf.setText("");
			statusTf.setText("");
			
			load.setSelected(false);
			updateBt.setEnabled(false);
			removeBt.setEnabled(false);
		}
		else if(a.getSource()==removeBt){
			er.removeEmployee(Integer.parseInt(empIdTf.getText()));
			pr.removeUser(Integer.parseInt(empIdTf.getText()));
			JOptionPane.showMessageDialog(this,"Employee removed","Information",JOptionPane.INFORMATION_MESSAGE);
			String data[][] = er.getEmployees();
			String head[] = {"empId", "empName", "contact", "salary", "status"};
			
			remove(empTableSP);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(500,170,600,400);
			add(empTableSP);
			
			this.revalidate();
			this.repaint();
		}
		else if(a.getSource()==updateBt){
			if(empIdTf.getText().equals("") || empNameTf.getText().equals("") || contactTf.getText().equals("") || salaryTf.getText().equals("") || statusTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
				int id = Integer.parseInt(empIdTf.getText());
				String name = empNameTf.getText();
				int contact = Integer.parseInt(contactTf.getText());
				double sal = Double.parseDouble(salaryTf.getText());
				String status = statusTf.getText();
				
				Employee emp = new Employee(id,name,contact,sal,status);
				
				er.updateEmployee(emp);
				pr.updateUser(id,status);
				JOptionPane.showMessageDialog(this,"Employee Updated","Information",JOptionPane.INFORMATION_MESSAGE);
				String dataM[][] = er.getEmployees();
				String headM[] = {"empId", "empName", "contact", "salary", "status"};
				remove(empTableSP);
				
				empTable = new JTable(dataM,headM);
				empTable.setEnabled(false);
				empTableSP = new JScrollPane(empTable);
				empTableSP.setBounds(500,170,600,400);
				add(empTableSP);
				
				this.revalidate();
				this.repaint();
			}
		}
	}
}    