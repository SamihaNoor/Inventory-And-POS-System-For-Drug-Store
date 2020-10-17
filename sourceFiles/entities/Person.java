package entities;

import java.util.Random;

public class Person{
	
	private int userId;
	private String password;
	private String status;
	
	public Person(){}
	
	public Person(int userId, String password, String status){
		this.password = password; 
		this.userId = userId;
		this.status = status;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
		
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
}