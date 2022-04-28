package at2.oslina.security.controller;

import at2.oslina.security.dto.UserResponse;
import at2.oslina.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/public/api/method")
    public String getPublic() {
        return "Some public info";
    }

    @GetMapping("/admin/api/user")
    public UserResponse getAdmin(Principal principal) {
        return userService.getUser(principal);
    }

    @GetMapping("/support/api/user")
    public UserResponse getSupport(Principal principal) {
        return userService.getUser(principal);
    }
}