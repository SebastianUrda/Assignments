package HibernateDaoInterfaces;

import AnnotedClasses.TournamentH;

public interface TournamentDao {
	TournamentH find(int id);
	
	void delete(TournamentH objectToDelete);

	void update(TournamentH objectToUpdate);

	void insert(TournamentH objectToCreate);

	void getAll();

	public void getByTaxZero();
	
	public void getByTaxNonZero();
}
