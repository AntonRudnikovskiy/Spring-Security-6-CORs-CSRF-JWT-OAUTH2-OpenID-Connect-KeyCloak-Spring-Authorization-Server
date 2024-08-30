package springsecurity.springsecurity.mapper;

import org.springframework.stereotype.Component;
import springsecurity.springsecurity.dto.CustomerDto;
import springsecurity.springsecurity.entity.Customer;

@Component
public class UserMapper {

    public CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .pwd(customer.getPwd())
                .role(customer.getRole())
                .build();
    }

    public Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .email(customerDto.getEmail())
                .pwd(customerDto.getPwd())
                .role(customerDto.getRole())
                .build();
    }
}
