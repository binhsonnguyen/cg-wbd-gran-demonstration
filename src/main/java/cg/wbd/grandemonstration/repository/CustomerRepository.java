package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
