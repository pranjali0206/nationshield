package nationshield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nationshield.dto.AuthResponse;
import nationshield.dto.LoginRequest;
import nationshield.dto.RegisterRequest;
import nationshield.entity.User;
import nationshield.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        User user = userService.registerUser(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getPhone(),
                request.getRole()
        );

        return ResponseEntity.ok(new AuthResponse(
                null,
                user.getRole().name(),
                "Registration successful!"
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(new AuthResponse(
                null,
                null,
                "Login endpoint - JWT coming soon!"
        ));
    }
}