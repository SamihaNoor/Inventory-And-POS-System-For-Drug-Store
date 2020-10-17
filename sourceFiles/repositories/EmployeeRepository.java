package repositories;

import entities.*;
import java.util.ArrayList;


public class EmployeeRepository implements IEmployeeRepository{
	DatabaseConnection datacon = new DatabaseConnection();
	
	public void addEmployee(Employee emp){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("insert into employee_info VALUES("+emp.getEmpId()+",'"+emp.getEmpName()+"',"+emp.getContact()+", "+emp.getSalary()+",'"+emp.getStatus()+"')");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void removeEmployee(int id){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("delete from employee_info where empId = " +id);
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void updateEmployee(Employee emp){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("update employee_info set empName= '"+emp.getEmpName()+"', contact="+emp.getContact()+", salary="+emp.getSalary()+", status='"+emp.getStatus()+"'  where empId="+emp.getEmpId()+";");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public Employee getEmployee(int empId){
		Employee emp = null;
		try{
			datacon.openConnection();
			datacon.result = datacon.st.executeQuery("select empId, empName, contact, status, salary from employee_info where empId="+empId+";");
		
			while(datacon.result.next()){
				int id = datacon.result.getInt("empId");
				String name = datacon.result.getString("empName");
				int contact = datacon.result.getInt("contact");
				String status = datacon.result.getString("status");
				double salary = datacon.result.getDouble("salary");
				
				emp = new Employee();
				emp.setEmpId(id);
				emp.setEmpName(name);
				emp.setContact(contact);
				emp.setStatus(status);
				emp.setSalary(salary);
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		datacon.closeConnection();
		return emp;
	}
	
	public String[][] searchEmployee(String keyword){
		ArrayList<Employee> ar = new ArrayList<Employee>();
		
		try
		{
			datacon.openConnection();
			datacon.result = datacon.st.executeQuery("select empId, empName, contact, status, salary from employee_info where empName like '%"+keyword+"%';");
			
			while(datacon.result.next())
			{
				int empId = datacon.result.getInt("empId");
				String name = datacon.result.getString("empName");
				int contact = datacon.result.getInt("contact");
				String status = datacon.result.getString("status");
				double salary = datacon.result.getDouble("salary");
				
				Employee emp = new Employee(empId,name,contact,salary,status);
				ar.add(emp);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		datacon.closeConnection();
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmpId()+"";
			data[i][1] = ((Employee)obj[i]).getEmpName();
			data[i][2] = ((Employee)obj[i]).getContact()+"";
			data[i][3] = ((Employee)obj[i]).getStatus();
			data[i][4] = (((Employee)obj[i]).getSalary())+"";
		}
		return data;
	}
	
	public String[][] getEmployees(){
		
		ArrayList<Employee> ar = new ArrayList<Employee>();
		
		try
		{
			datacon.openConnection();
			datacon.result = datacon.st.executeQuery("SELECT * FROM employee_info");
			
			while(datacon.result.next())
			{
				int empId = datacon.result.getInt("empId");
				String name = datacon.result.getString("empName");
				int contact = datacon.result.getInt("contact");
				String status = datacon.result.getString("status");
				double salary = datacon.result.getDouble("salary");
				
				Employee emp = new Employee(empId,name,contact,salary,status);
				ar.add(emp);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		datacon.closeConnection();
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmpId()+"";
			data[i][1] = ((Employee)obj[i]).getEmpName();
			data[i][2] = ((Employee)obj[i]).getContact()+"";
			data[i][3] = (((Employee)obj[i]).getSalary())+"";
			data[i][4] = ((Employee)obj[i]).getStatus();
		}
		return data;
	}
}