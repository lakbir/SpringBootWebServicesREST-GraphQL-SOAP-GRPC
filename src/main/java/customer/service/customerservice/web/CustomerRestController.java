package customer.service.customerservice.web;

import customer.service.customerservice.entities.Customer;
import customer.service.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
