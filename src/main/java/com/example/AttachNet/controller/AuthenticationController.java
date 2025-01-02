package com.example.AttachNet.controller;


import com.example.AttachNet.dto.UserDTO;
import com.example.AttachNet.model.User;
import com.example.AttachNet.responses.LoginReponse;
import com.example.AttachNet.service.JwtService;
import com.example.AttachNet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserDTO userDto) {
        User registeredUser = userService.signup(userDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginReponse> authenticate(@RequestBody UserDTO userDto) {
        User authenticatedUser = userService.authenticate(userDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginReponse loginResponse = new LoginReponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
