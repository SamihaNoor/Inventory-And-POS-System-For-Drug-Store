package entities;

public class Medicine{
	private int medId;
	private String medName;
	private String medType;
	private double unitPrice;
	private int quantity;
	
	public Medicine(){}
	
	public Medicine(int medId, String medName, String medType, double unitPrice, int quantity){
		this.medId = medId;
		this.medName = medName;
		this.medType = medType;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public void setMedId(int medId){
		this.medId = medId;
	}
	
	public int getMedId(){
		return this.medId;
	}
	
	public void setMedName(String medName){
		this.medName = medName;
	}
	
	public String getMedName(){
		return this.medName;
	}
	
	public void setMedType(String medType){
		this.medType = medType;
	}
	
	public String getMedType(){
		return this.medType;
	}
	
	public void setUnitPrice(double unitPrice){
		this.unitPrice = unitPrice;
	}
	
	public double getUnitPrice(){
		return this.unitPrice;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
}