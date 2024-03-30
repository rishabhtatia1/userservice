package dev.rishabh.userservice.controllers;

import dev.rishabh.userservice.dtos.LogoutRequestDto;
import dev.rishabh.userservice.dtos.SignUpRequestDto;
import dev.rishabh.userservice.dtos.UserDto;
import dev.rishabh.userservice.dtos.ValidateTokenRequestDto;
import dev.rishabh.userservice.models.SessionStatus;
import dev.rishabh.userservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    @PostMapping("/login")
//    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto request) {
//        return authService.login(request.getEmail(), request.getPassword());
////        return null;
//    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto request) {
        return authService.logout(request.getToken(), request.getUserId());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto request) {
        UserDto userDto = authService.signUp(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

//    @GetMapping("/signup")
//    public String signUp() {
////        UserDto userDto = authService.signUp(request.getEmail(), request.getPassword());
//        return "hello";
//    }

    @PostMapping("/validate")
    public ResponseEntity<SessionStatus> validateToken(ValidateTokenRequestDto request) {
        SessionStatus sessionStatus = authService.validate(request.getToken(), request.getUserId());
        return new ResponseEntity<>(sessionStatus, HttpStatus.OK);
    }

}
