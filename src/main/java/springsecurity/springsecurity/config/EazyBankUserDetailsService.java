package springsecurity.springsecurity.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springsecurity.springsecurity.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username)
                .map(c -> new User(c.getEmail(), c.getPwd(), List.of(new SimpleGrantedAuthority(c.getRole()))))
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + username));
    }
}
