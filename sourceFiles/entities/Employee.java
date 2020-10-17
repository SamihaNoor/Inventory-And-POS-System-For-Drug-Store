package entities;

public class Employee{

	private int empId;
	private String empName;
	private int contact;
	private double salary;
	private String status;

	public Employee(){}
	
	public Employee(int empId, String empName,int contact,double salary,String status){
		this.empId = empId;
		this.empName = empName;
		this.contact = contact;
		this.salary = salary;
		this.status = status;
	}
	
	public void setEmpId(int empId){
		this.empId=empId;
	}
		
	public int getEmpId(){
		return this.empId;
	}
	
	public void setEmpName(String empName){
		this.empName=empName;
	}
	public String getEmpName(){
		return this.empName;
	}
	
	public void setContact(int contact){
		this.contact=contact;
	}
		
	public int getContact(){
		return this.contact;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
		
	public double getSalary(){
		return this.salary;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return this.status;
	}
}