package customer.service.customerservice.mapper;

import customer.service.customerservice.dto.CustomerRequest;
import customer.service.customerservice.entities.Customer;
import customer.service.customerservice.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    ModelMapper modelMapper = new ModelMapper();
    public Customer from(CustomerRequest customerRequest){
        return modelMapper.map(customerRequest, Customer.class);
    }

    public CustomerServiceOuterClass.Customer fromCustomer(Customer customer){
        return modelMapper.map(customer, CustomerServiceOuterClass.Customer.Builder.class).build();
    }

    public Customer fromGrpcCustomerRequest(CustomerServiceOuterClass.CustomerRequest customerRequest){
        return modelMapper.map(customerRequest, Customer.class);
    }
}
