package repositories;

import entities.*;

interface IPersonRepository{
	void addUser(Person user);
	void removeUser(int id);
	void updateUser(Person user);
	Person getUser(int id, String password);
}