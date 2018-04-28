package Business;

import java.util.List;
import java.util.Observable;

import AnnotedClasses.AccountH;
import AnnotedClasses.PersonH;
import AnnotedClasses.TournamentH;
import HibernateDAO.AccountDAOH;
import HibernateDAO.PersonDAOH;
import HibernateDAO.TournamentDAOH;
import HibernateDaoInterfaces.AccountDao;
import HibernateDaoInterfaces.PersonDao;
import HibernateDaoInterfaces.TournamentDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UserBusiness extends Observable{
public boolean authenticate(String name, String pass) {
		
		PersonDao personDao=new PersonDAOH();
		PersonH credentials = personDao.findByName(name);
		boolean checkCredentials = false;
		
		if(credentials != null)
		{
			if(credentials.getPassword().equals(pass))
				checkCredentials = true;
			else
				checkCredentials = false;				
		}
		return checkCredentials;
}
public boolean checkIfAdmin(String name)
{
	PersonDao personDao=new PersonDAOH();
	PersonH credentials = personDao.findByName(name);
	if(credentials != null)
	{
		return credentials.getIsadmin();
	}
	return false;
}
public static void deleteUser (String name)
{
	System.out.println("to be deleted"+name);
	PersonDao personDao=new PersonDAOH();
	PersonH credentials = personDao.findByName(name);
	System.out.println(credentials.getName());
	personDao.delete(credentials);
}
public static PersonH findByName(String name)
{
	PersonDao personDao=new PersonDAOH();
	System.out.println(name);
	System.out.println(personDao.findByName(name).getName());
	return personDao.findByName(name);
}
public static void updateData (PersonH toUpdate,TextField name, TextField pass,TextField email,CheckBox isAdmin, TextField balance, Stage windo)
{
	PersonDao personDao=new PersonDAOH();
	toUpdate.setName(name.getText());
	toUpdate.setEmail(email.getText());
	toUpdate.setPassword(pass.getText());
	 if(isAdmin.isSelected())
	    	toUpdate.setIsadmin(true);
	    else toUpdate.setIsadmin(false);
	AccountBusiness.updateBalance(toUpdate.getAccount().getId(),Integer.parseInt(balance.getText()));
	personDao.update(toUpdate);
}
public static void createUser(TextField name, TextField pass,TextField email,CheckBox isAdmin, TextField balance, Stage window )
{
	PersonH person=new PersonH();
	PersonDao personDao=new PersonDAOH();
	AccountH account=new AccountH();
	AccountDao accountDao =new AccountDAOH();
	person.setName(name.getText());
	person.setPassword(pass.getText());
	person.setEmail(email.getText());
    if(isAdmin.isSelected())
    	person.setIsadmin(true);
    else person.setIsadmin(false);
    account.setBalance(Integer.parseInt(balance.getText()));
    accountDao.insert(account);
    person.setAccount(account);
    personDao.insert(person);
    System.out.println("DONE!");
}
public ObservableList<PersonH> getAllPersons()
{
	PersonDao personDao= new PersonDAOH();
	List<PersonH> toPrint= personDao.getAll();
	ObservableList<PersonH> at = FXCollections.observableArrayList(toPrint);
	

	return at;
}
}
