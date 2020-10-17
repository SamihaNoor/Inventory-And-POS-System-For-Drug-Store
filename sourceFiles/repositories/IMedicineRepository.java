package repositories;

import entities.*;

interface IMedicineRepository{
	void addMedicine(Medicine item);
	void removeMedicine(int id);
	void updateMedicine(Medicine item);
	Medicine getMedicine(int id);
	String[][] searchMedicine(String keyword);
	String[][] getMedicines();
}