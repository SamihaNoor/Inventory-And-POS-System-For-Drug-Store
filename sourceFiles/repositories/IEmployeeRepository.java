package repositories;

import entities.*;

interface IEmployeeRepository{
	void addEmployee(Employee emp);
	void removeEmployee(int id);
	void updateEmployee(Employee emp);
	Employee getEmployee(int empId);
	String[][] searchEmployee(String keyword);
	String[][] getEmployees();
}