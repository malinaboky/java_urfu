package at2.oslina.security.service;

import at2.oslina.security.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final InMemoryUserDetailsManager userDetailsService;

    public UserResponse getUser(Principal principal) {
        return new UserResponse(userDetailsService.loadUserByUsername(principal.getName()));
    }
}
