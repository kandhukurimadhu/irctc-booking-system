package com.irctc.booking.controller;

import com.irctc.booking.entity.User;
import com.irctc.booking.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    // ✅ Signup API
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        // Check if email already exists
        User existing = repo.findByEmail(user.getEmail());

        if (existing != null) {
            return "Email already registered!";
        }

        repo.save(user);
        return "Signup Successful ✅";
    }

    // ✅ Login API
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repo.findByEmail(user.getEmail());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return "Login Successful ✅";
        }

        return "Invalid Credentials ❌";
    }
}
