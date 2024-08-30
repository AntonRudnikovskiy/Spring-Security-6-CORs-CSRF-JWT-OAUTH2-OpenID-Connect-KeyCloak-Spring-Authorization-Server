package springsecurity.springsecurity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springsecurity.springsecurity.dto.CustomerDto;
import springsecurity.springsecurity.entity.Customer;
import springsecurity.springsecurity.mapper.UserMapper;
import springsecurity.springsecurity.repository.CustomerRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final CustomerRepository customerRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CustomerDto register(CustomerDto customerDto) {
        Customer customer = userMapper.toEntity(customerDto);
        String hashPwd = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashPwd);
        customerRepository.save(customer);
        log.info("Customer saved with id: {}", customer.getId());
        return userMapper.toDto(customer);
    }
}
