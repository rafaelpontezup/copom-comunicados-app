package br.com.graphene.copom.sampledynamo.service;

import com.amazonaws.services.kms.model.NotFoundException;

import br.com.graphene.copom.sampledynamo.entity.Customer;
import br.com.graphene.copom.sampledynamo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerRepository repository;

  @Autowired
  private CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public void createCustomer(String name, String cpf) {
    Customer customer = new Customer(name, cpf);
    repository.save(customer);
  }

  public Customer fetchByCpf(String cpf) {
    return repository.findByCpf(cpf).orElseThrow(
        () -> new NotFoundException("Customer not found")
    );
  }
}
