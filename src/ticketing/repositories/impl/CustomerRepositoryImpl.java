package ticketing.repositories.impl;

import ticketing.entities.Customer;
import ticketing.repositories.interfaces.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void create(Customer customer) {
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>();
    }
}
