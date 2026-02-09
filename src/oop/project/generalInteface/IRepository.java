package oop.project.generalInteface;
import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    T findById(int id);
    void create(T entity);
}