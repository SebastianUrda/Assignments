package HibernateDaoInterfaces;

import AnnotedClasses.AccountH;

public interface AccountDao extends DAO<AccountH>{

	AccountH find(int id);
}
