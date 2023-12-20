package com.example.backend.services;


import com.example.backend.models.Admin;
import com.example.backend.models.User;
import com.example.backend.repositories.AdminRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.requests.AdminAddRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public AdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    public Admin getAdminById(Long userId) {
        return adminRepository.getAdminById(userId);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    public void addAdmin(AdminAddRequest request) {
        if (request == null || !userRepository.existsById(request.getUserId())) {
            throw new RuntimeException("User id is null or user does not exist while adding an admin");
        }

        Admin admin = new Admin();
        admin.setUserId(request.getUserId());
        admin.setStartDate(request.getStartDate());

        adminRepository.addAdmin(admin);
    }

}
