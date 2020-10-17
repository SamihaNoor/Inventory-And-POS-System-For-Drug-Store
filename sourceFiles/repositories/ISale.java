package repositories;

import entities.*;

interface ISale{
	String[][] getSale(int id);
	void insertSale(Sale sale);
	void updateSale(Sale sale);
	void removeSale(int saleId,int medId);
}