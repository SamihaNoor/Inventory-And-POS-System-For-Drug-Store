package repositories;
	
import entities.*;
import java.util.ArrayList;

public class PersonRepository implements IPersonRepository{
	
	DatabaseConnection datacon = new DatabaseConnection();
	
	public void addUser(Person user){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("insert into userinfo VALUES("+user.getUserId()+",'"+user.getPassword()+"','"+user.getStatus()+"')");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void removeUser(int id){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("DELETE FROM userinfo WHERE userId = " +id);
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUser(int id,String status){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("update userinfo set status ='"+status+"' where userId="+id+";");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUser(Person user){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("update userinfo set password = '"+user.getPassword()+"' where userId="+user.getUserId()+";");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public Person getUser(int id,String password){
		Person user = null;
		try
		{
			datacon.openConnection();
			datacon.result = datacon.st.executeQuery("select userId, password, status from userinfo where userId="+id+" and password='"+password+"'");
		
			while(datacon.result.next())
			{
				user = new Person();
				user.setUserId(datacon.result.getInt("userId"));
				user.setPassword(datacon.result.getString("password"));
				user.setStatus(datacon.result.getString("status"));
			}
		}
        catch(Exception e)
		{
			System.out.println(e.getMessage());
        }
		datacon.closeConnection();
		return  user;
	}
}