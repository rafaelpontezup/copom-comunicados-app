package br.com.graphene.novoboletoapp0504.sampledynamo.service;

import br.com.graphene.novoboletoapp0504.sampledynamo.entity.Customer;
import br.com.graphene.novoboletoapp0504.sampledynamo.repository.CustomerRepository;
import com.amazonaws.services.kms.model.NotFoundException;
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
