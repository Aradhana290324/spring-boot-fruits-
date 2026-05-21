package com.GuruFruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.GuruFruit.dto.AdminLoginRequest;
import com.GuruFruit.entity.Admin;
import com.GuruFruit.repository.AdminRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AdminRepository adminRepository;

    // =========================
    // ADMIN LOGIN
    // =========================

    @PostMapping("/login")
    public Map<String, Object> login(
            @RequestBody AdminLoginRequest req
    ) {

        Map<String, Object> response = new HashMap<>();

        Optional<Admin> adminOpt =
                adminRepository.findByUsername(
                        req.getUsername()
                );

        if (adminOpt.isPresent()) {

            Admin admin = adminOpt.get();

            // CHECK ACTIVE STATUS
            if (!admin.isActive()) {

                response.put("status", "error");
                response.put("message", "Account Disabled");

                return response;
            }

            // PASSWORD CHECK
            if (admin.getPassword().equals(req.getPassword())) {

                response.put("status", "success");
                response.put("message", "Login Successful");

                // TOKEN
                response.put(
                        "token",
                        "guru-token-" + admin.getId()
                );

                // ADMIN DETAILS
                response.put("adminId", admin.getId());
                response.put("name", admin.getName());
                response.put("username", admin.getUsername());

            } else {

                response.put("status", "error");
                response.put("message", "Wrong Password");
            }

        } else {

            response.put("status", "error");
            response.put("message", "User Not Found");
        }

        return response;
    }

    // =========================
    // RESET PASSWORD
    // =========================

    @PutMapping("/reset-password")
    public Map<String, Object> resetPassword(
            @RequestBody Map<String, String> req
    ) {

        Map<String, Object> response =
                new HashMap<>();

        String username = req.get("username");

        String oldPassword =
                req.get("oldPassword");

        String newPassword =
                req.get("newPassword");

        Optional<Admin> adminOpt =
                adminRepository.findByUsername(
                        username
                );

        if (adminOpt.isPresent()) {

            Admin admin = adminOpt.get();

            // OLD PASSWORD CHECK
            if (!admin.getPassword().equals(oldPassword)) {

                response.put("status", "error");
                response.put(
                        "message",
                        "Old Password Incorrect"
                );

                return response;
            }

            // UPDATE PASSWORD
            admin.setPassword(newPassword);

            adminRepository.save(admin);

            response.put("status", "success");

            response.put(
                    "message",
                    "Password Reset Successful"
            );

        } else {

            response.put("status", "error");

            response.put(
                    "message",
                    "User Not Found"
            );
        }

        return response;
    }
}