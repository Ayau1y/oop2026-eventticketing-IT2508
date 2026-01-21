package ticketing.repositories.interfaces;

import ticketing.entities.Customer;
import java.util.List;

public interface CustomerRepository {
    void create(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
}
