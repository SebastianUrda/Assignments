package HibernateDaoInterfaces;
import AnnotedClasses.MatchH;

public interface MatchDao {
	MatchH find(int id);
	
	void delete(MatchH objectToDelete);

	void update(MatchH objectToUpdate);

	void insert(MatchH objectToCreate);

}
