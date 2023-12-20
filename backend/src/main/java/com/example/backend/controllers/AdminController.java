package com.example.backend.controllers;

import com.example.backend.models.Admin;
import com.example.backend.requests.AdminAddRequest;
import com.example.backend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/{userId}")
    public Admin getAdminById(@PathVariable Long userId) {
        return adminService.getAdminById(userId);
    }

    @GetMapping()
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping()
    public void addAdmin(@RequestBody AdminAddRequest request) {
        adminService.addAdmin(request);
    }
}
