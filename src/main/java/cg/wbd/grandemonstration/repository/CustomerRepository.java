package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.Customer;

import java.util.List;

public interface CustomerRepository extends Repository<Customer> {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer model);

    void remove(Long id);
}
