package br.com.graphene.copom.sampledynamo.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.graphene.copom.sampledynamo.entity.Customer;

import java.util.Optional;

@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {

  Optional<Customer> findById(String id);
  Optional<Customer> findByCpf(String cpf);
}

