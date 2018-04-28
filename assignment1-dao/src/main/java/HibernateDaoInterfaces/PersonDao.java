package HibernateDaoInterfaces;

import AnnotedClasses.PersonH;

public interface PersonDao extends DAO<PersonH> {
	
	PersonH find(int id);
	
	PersonH findByName(String name);
	
	void delete(PersonH objectToDelete);

	void update(PersonH objectToUpdate);

	void insert(PersonH objectToCreate);
	
	
}
