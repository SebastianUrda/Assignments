package HibernateDaoInterfaces;

import java.util.List;

import AnnotedClasses.TournamentH;

public interface TournamentDao {
	TournamentH find(int id);
	TournamentH findByName(String name);
	void delete(TournamentH objectToDelete);

	void update(TournamentH objectToUpdate);

	void insert(TournamentH objectToCreate);

	List getAll();

	List getByTaxZero();
	
	List getByTaxNonZero();
}
