package repositories;

import java.util.ArrayList;
import entities.*;

public class SaleRepository implements ISale{
	
	DatabaseConnection datacon = new DatabaseConnection();
	
	public SaleRepository(){}
	
	public int getSaleId(){
		int saleId=-1;
		try{
			datacon.openConnection();
			datacon.result=datacon.st.executeQuery("select MAX(saleId) from sale ;");
			
			while(datacon.result.next()){
				 saleId = datacon.result.getInt("MAX(saleId)"); 
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		datacon.closeConnection();
		
		return saleId+1;
	}
	
	public double getTotalAmount(int saleId){
		double amount=0;
		try{
			datacon.openConnection();
			datacon.result=datacon.st.executeQuery("select sum(amount) from sale where saleId = "+saleId+";");
			
			while(datacon.result.next()){
				 amount = datacon.result.getDouble("sum(amount)"); 
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		datacon.closeConnection();
		
		return amount;
	}
	
	public int updateQuantity(int id){
		int quantity=0;
		try{
			datacon.openConnection();
			datacon.result=datacon.st.executeQuery("select (med_info.quantity-sale.quantity) quantity from med_info, sale where med_info.medId=sale.medId and sale.saleId =" +id+";");
			
			while(datacon.result.next()){
				 quantity = datacon.result.getInt("quantity"); 
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		datacon.closeConnection();
		
		return quantity;
	}
	
	public void insertSale(Sale sale){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("insert into sale values("+sale.getSaleId()+","+sale.getMedId()+",'"+sale.getMedName()+"',"+sale.getPurchasedQuantity()+","+sale.getUnitPrice()+","+sale.getAmount()+")");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateSale(Sale sale){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("update sale set quantity="+sale.getPurchasedQuantity()+ ", amount =" +sale.getAmount()+ " where medId="+sale.getMedId()+";");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removeSale(int saleId,int medId){
		try{
			datacon.openConnection();
			datacon.st.executeUpdate("delete from sale where saleId="+saleId+" and medId="+medId+";");
			datacon.closeConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public String [][] getSale(int id){
		ArrayList<Sale> ar = new ArrayList<Sale>();
		try{
			datacon.openConnection();
			datacon.result=datacon.st.executeQuery("select saleId, medId, medName, quantity, unitPrice, amount from sale where saleId ="+id+";");

			while(datacon.result.next()){
				int saleId = datacon.result.getInt("saleId");
				int medId = datacon.result.getInt("medId");
				String medName = datacon.result.getString("medName");
				int quantity = datacon.result.getInt("quantity");
				double unitPrice = datacon.result.getDouble("unitPrice");
				double amount = datacon.result.getDouble("amount");
				
				Sale sale = new Sale(saleId,medId,medName,quantity,unitPrice,amount);
				ar.add(sale);
			}
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		datacon.closeConnection();
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Sale)obj[i]).getSaleId()+"";
			data[i][1] = ((Sale)obj[i]).getMedId()+"";
			data[i][2] = ((Sale)obj[i]).getMedName();
			data[i][3] = ((Sale)obj[i]).getPurchasedQuantity()+"";
			data[i][4] = ((Sale)obj[i]).getUnitPrice()+"";
			data[i][5] = ((Sale)obj[i]).getAmount()+"";
		}
		return data;
	}
}