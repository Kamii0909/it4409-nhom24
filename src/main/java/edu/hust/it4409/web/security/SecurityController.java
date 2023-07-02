package edu.hust.it4409.web.security;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController("/api")
class SecurityController {
    private final UserDetailsManager userDetailsService;
    @GetMapping("/user/current")
    public Object user(@CurrentSecurityContext(expression = "authentication.principal") Object principal) {
        return principal;
    }

    @PostMapping("/user/new")
    public ResponseEntity<?> createNewUser(@RequestBody UserDetails details) {
        // userDetailsService.createUser(details);
        return ResponseEntity.created(URI.create("/user/TODO")).build();
    }
}
