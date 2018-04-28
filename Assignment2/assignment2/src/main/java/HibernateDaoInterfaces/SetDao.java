package HibernateDaoInterfaces;

import AnnotedClasses.SetH;

public interface SetDao extends DAO<SetH>{
	
	SetH find(int id);
	
	void delete(SetH objectToDelete);

	void update(SetH objectToUpdate);

	void insert(SetH objectToCreate);
}
