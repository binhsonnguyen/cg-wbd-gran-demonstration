package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitJupiterConfig(CustomerServiceTestConfig.class)
public class CustomerServiceTest {
  @Autowired
  private CustomerService customerService;

  @Autowired
  private CustomerRepository customerRepository;

  @AfterEach
  private void resetMocks() {
    Mockito.reset(customerRepository);
  }

  @Test
  void testFindAll() {
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer(1L, "Foo Bar", "a@dummy.im", "Nowhere"));
    Pageable pageInfo = new PageRequest(0, 25);
    Page<Customer> customerPage = new PageImpl<Customer>(customers, pageInfo, 1);
    when(customerRepository.findAll(pageInfo)).thenReturn(customerPage);

    Page<Customer> actual = customerService.findAll(pageInfo);
    verify(customerRepository).findAll(pageInfo);
    assertEquals(customerPage, actual);
  }

  @Test
  void testFindOneFound() {
    Customer customer = new Customer(1L, "Foo Bar", "a@dummy.im", "Nowhere");
    when(customerRepository.findOne(1L)).thenReturn(customer);

    Customer actual = customerService.findOne(1L);
    verify(customerRepository).findOne(1L);
    assertEquals(customer, actual);
  }

  @Test
  void testFindOneNotFound() {
    when(customerRepository.findOne(1L)).thenReturn(null);

    Customer actual = customerService.findOne(1L);
    verify(customerRepository).findOne(1L);
    assertNull(actual);
  }

  @Test
  void saveCustomer() {
    Customer customer = new Customer(1L, "Foo Bar", "a@dummy.im", "Nowhere");
    customerService.save(customer);
    verify(customerRepository).save(customer);
  }
}
