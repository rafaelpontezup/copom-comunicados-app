package br.com.graphene.copomcomunicados.sampledynamo.repository;

import br.com.graphene.copomcomunicados.StackApplication;
import br.com.graphene.copomcomunicados.sampledynamo.entity.Customer;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(classes = StackApplication.class)
@ActiveProfiles("local")
public class CustomerRepositoryTest {

  @Autowired
  private AmazonDynamoDB amazonDynamoDB;

  @Autowired
  CustomerRepository repository;

  private static final String EXPECTED_NAME = "TEST";
  private static final String EXPECTED_CPF = "12345678900";

  private static DynamoDBProxyServer server;

  @BeforeAll
  public static void setupClass() throws Exception {
    System.setProperty("sqlite4java.library.path", "src/test/resources/libs/");
    String port = "8000";
    server = ServerRunner.createServerFromCommandLineArgs(new String[]{"-inMemory", "-port", port});
    server.start();
  }

  @AfterAll
  public static void teardownClass() throws Exception {
    server.stop();
  }

  @BeforeEach
  public void setup() {
    DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

    CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Customer.class);
    tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
    amazonDynamoDB.createTable(tableRequest);

    dynamoDBMapper.batchDelete(repository.findAll());
  }

  @Test
  public void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() {
    Customer customer = new Customer(EXPECTED_NAME, EXPECTED_CPF);
    repository.save(customer);
    List<Customer> result = (List<Customer>) repository.findAll();

    assert result.size() > 0;
    assert result.get(0).getName().equals(EXPECTED_NAME);
    assert result.get(0).getCpf().equals(EXPECTED_CPF);
  }
}

