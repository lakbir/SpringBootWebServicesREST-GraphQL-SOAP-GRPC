package customer.service.customerservice;

import customer.service.customerservice.entities.Customer;
import customer.service.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("customer1").email("customer1@email.com").build());
            customerRepository.save(Customer.builder().name("customer2").email("customer2@email.com").build());
            customerRepository.save(Customer.builder().name("customer3").email("customer3@email.com").build());
            customerRepository.save(Customer.builder().name("customer4").email("customer4@email.com").build());
        };
    }
}
