import DAO.Login;
import DAO.PersonDB;
import Models.Person;

public class PersonController {

	public static int testLogIn (String name,String password)
	{
		Login logger = new Login(name,password);
        return logger.test();

	}
	public static void createAccount (String name,String email,String password,Boolean isadmin)
	{	
		Person person=new Person(name,email,password,isadmin);
		System.out.println(PersonDB.insert(person));
	}
	public static void updateAccount(String find,String name,String email,String password,Boolean isadmin)
	{
		Person toUpdate=PersonDB.findByName(find);
		toUpdate.setName(name);
		toUpdate.setEmail(email);
		toUpdate.setPassword(password);
		toUpdate.setIsAdmin(isadmin);
		PersonDB.update(toUpdate);
	}
	public static void deleteAccount(String find)
	{
		Person toUpdate=PersonDB.findByName(find);
		PersonDB.delete(toUpdate.getId());
	}
}
