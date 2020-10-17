package repositories;

import entities.*;
import java.util.ArrayList;


public class MedicineRepository implements IMedicineRepository{
	DatabaseConnection datacon = new DatabaseConnection();
	
	public void addMedicine(Medicine item){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("insert into med_info values ("+item.getMedId()+",'"+item.getMedName()+"','"+item.getMedType()+"',"+item.getUnitPrice()+","+item.getQuantity()+");");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void removeMedicine(int id){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("delete from med_info where medId ="+id);
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int addedQuantity(int medId,int qty){
		int quantity=0;
		try{
			datacon.openConnection();
			datacon.result=datacon.st.executeQuery("select quantity from med_info where medId = " +medId+";");
			
			while(datacon.result.next()){
				 quantity = datacon.result.getInt("quantity"); 
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		datacon.closeConnection();
		
		return quantity+qty;
	}
	
	public void updateMedicine(Medicine item){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("update med_info set medName='"+item.getMedName()+"', medType='"+item.getMedType()+"', unitPrice="+item.getUnitPrice()+", quantity="+item.getQuantity()+" where medId="+item.getMedId()+";");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void updateMedicine(int medId,int quantity){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("update med_info set quantity="+quantity+" where medId="+medId+";");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public  Medicine getMedicine(int id){
		Medicine med = null;    
		try{
			datacon.openConnection();
			datacon.result = datacon.st.executeQuery("select medId, medName, medType, unitPrice, quantity from med_info where medId = "+id+";");
		
			while(datacon.result.next()){
				int medId = datacon.result.getInt("medId");
				String name = datacon.result.getString("medName");
				String type = datacon.result.getString("medType");
				double unitPrice = datacon.result.getDouble("unitPrice");
				int quantity = datacon.result.getInt("quantity");
				
				med = new Medicine();
				med.setMedId(medId);
				med.setMedName(name);
				med.setMedType(type);
				med.setUnitPrice(unitPrice);
				med.setQuantity(quantity);
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		datacon.closeConnection();
		return med;
	}
	
	public String[][] searchMedicine(String keyword){
		ArrayList<Medicine> ar = new ArrayList<Medicine>();
		
		try{
			datacon.openConnection();
			datacon.result = datacon.st.executeQuery("select medId, medName, medType, unitPrice, quantity from med_info where medName like '%"+keyword+"%';");
			
			while(datacon.result.next()){
				int medId = datacon.result.getInt("medId");
				String name = datacon.result.getString("medName");
				String type = datacon.result.getString("medType");
				double unitPrice = datacon.result.getDouble("unitPrice");
				int quantity = datacon.result.getInt("quantity");
				
				Medicine med = new Medicine(medId,name,type,unitPrice,quantity);
				ar.add(med);
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
			data[i][0] = ((Medicine)obj[i]).getMedId()+"";
			data[i][1] = ((Medicine)obj[i]).getMedName();
			data[i][2] = ((Medicine)obj[i]).getMedType();
			data[i][3] = ((Medicine)obj[i]).getUnitPrice()+"";
			data[i][4] = (((Medicine)obj[i]).getQuantity())+"";
		}
		return data;
	}
	
	public String[][] getMedicines(){
		ArrayList<Medicine> ar = new ArrayList<Medicine>();
		
		try{
			datacon.openConnection();
			datacon.result = datacon.st.executeQuery("SELECT * FROM med_info;");
			
			while(datacon.result.next()){
				int medId = datacon.result.getInt("medId");
				String name = datacon.result.getString("medName");
				String type = datacon.result.getString("medType");
				double unitPrice = datacon.result.getDouble("unitPrice");
				int quantity = datacon.result.getInt("quantity");
				
				Medicine med = new Medicine(medId,name,type,unitPrice,quantity);
				ar.add(med);
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
			data[i][0] = ((Medicine)obj[i]).getMedId()+"";
			data[i][1] = ((Medicine)obj[i]).getMedName();
			data[i][2] = ((Medicine)obj[i]).getMedType();
			data[i][3] = ((Medicine)obj[i]).getUnitPrice()+"";
			data[i][4] = (((Medicine)obj[i]).getQuantity())+"";
		}
		return data;
	}

}