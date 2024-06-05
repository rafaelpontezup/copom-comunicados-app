package br.com.graphene.novoboletoapp0504.sampledynamo.repository;

import br.com.graphene.novoboletoapp0504.sampledynamo.entity.Customer;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {

  Optional<Customer> findById(String id);
  Optional<Customer> findByCpf(String cpf);
}

