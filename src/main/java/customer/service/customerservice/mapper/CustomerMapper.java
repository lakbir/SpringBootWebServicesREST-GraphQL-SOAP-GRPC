package customer.service.customerservice.mapper;

import customer.service.customerservice.dto.CustomerRequest;
import customer.service.customerservice.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer from(CustomerRequest customerRequest){
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = new Customer();
        Customer customer1 = modelMapper.map(customerRequest, Customer.class);
        return customer1;
    }
}
