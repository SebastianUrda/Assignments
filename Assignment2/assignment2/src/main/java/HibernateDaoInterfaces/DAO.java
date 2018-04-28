package HibernateDaoInterfaces;

public interface DAO<T>
{
     T find(int id);

    void delete(T objectToDelete);

    void update(T objectToUpdate);

    void insert(T objectToCreate);

    void deleteById(int id);

    void closeConnection();
}
