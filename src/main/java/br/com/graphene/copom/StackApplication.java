package br.com.graphene.copom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StackApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackApplication.class, args);
	}
}
