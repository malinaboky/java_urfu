package at2.oslina.security.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserResponse {
    private String name;
    private Set<String> authorities;

    public UserResponse(UserDetails userDetails) {
        this.name = userDetails.getUsername();
        this.authorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> authority.startsWith("ROLE_"))
                .collect(Collectors.toSet());
    }
}
