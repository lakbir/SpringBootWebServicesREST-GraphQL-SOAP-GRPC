package customer.service.customerservice.web;

import customer.service.customerservice.dto.CustomerRequest;
import customer.service.customerservice.entities.Customer;
import customer.service.customerservice.mapper.CustomerMapper;
import customer.service.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @QueryMapping
    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer==null) throw new RuntimeException(String.format("Customer %s not found", id));
        return customer;
    }

    @MutationMapping
    public Customer saveCustomer(@Argument CustomerRequest customer){
        Customer c = customerMapper.from(customer);
        return customerRepository.save(c);
    }
}
