package ticketing.repositories.interfaces;
import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(int id);
    void create(T entity);
}