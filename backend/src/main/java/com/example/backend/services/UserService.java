////package com.example.backend.services;
////
////import com.example.backend.entities.User;
////import com.example.backend.repositories.UserRepository;
////import jakarta.transaction.Transactional;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class UserService {
////
////    private final UserRepository userRepository;
////
////    public UserService(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
////
//////    public Object[] getUserById(Long id) {
//////        return userRepository.getUserById(id);
//////    }
////
////    public User getUserById(Long id) {
////        Object[] result = userRepository.getUserById(id);
////        if (result != null) {
////            User user = new User();
////            user.setUserId((Long) result[0]);
////            user.setEmail((String) result[1]);
////            // set other fields as needed
////            return user;
////        }
////        return null;
////    }
////
////    public List<Object[]> getAllUsers() {
////        return userRepository.getAllUsers();
////    }
////
////
////    @Transactional
////    public void addUser(User user) {
////         userRepository.addUser(user);
////    }
////}
////    public User addUser(User user) {
////        return userRepository.save(user);
////    }
//
//
//package com.example.backend.services;
//
//import com.example.backend.entities.User;
//import com.example.backend.repositories.UserRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User getUserById(Long id) {
//        Object[] result = userRepository.getUserById(id);
//        return mapToUser(result);
//    }
//
//    public List<User> getAllUsers() {
//        List<Object[]> results = userRepository.getAllUsers();
//        List<User> users = new ArrayList<>();
//        for (Object[] result : results) {
//            User user = mapToUser(result);
//            if (user != null) {
//                users.add(user);
//            }
//        }
//        return users;
//    }
//
//    @Transactional
//    public void addUser(User user) {
//        userRepository.addUser(user);
//    }
//
//    private User mapToUser(Object[] result) {
//        if (result != null && result.length == 2) {
//            User user = new User();
//            user.setUserId((Long) result[0]);
//            user.setEmail((String) result[1]);
//            // Map other fields as necessary
//            return user;
//        }
//        return null;
//    }
//}

package com.example.backend.services;

import com.example.backend.models.User;
import com.example.backend.repositories.UserRepository;
import com.example.backend.requests.UserAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Transactional
    public void addUser(UserAddRequest userAddRequest) {
        User user = new User();
        user.setUserId(userAddRequest.getUserId());
        user.setName(userAddRequest.getName());
        user.setEmail(userAddRequest.getEmail());
        user.setPassword(userAddRequest.getPassword());
        user.setBirthDate(userAddRequest.getBirthDate());
        user.setBiography(userAddRequest.getBiography());
        user.setNationality(userAddRequest.getNationality());
//        user.setSuspenseDate(userAddRequest.getSuspenseDate());


        // check if the important fields are not null or empty
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new RuntimeException("Name is required");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email is required");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is required");
        }

        // Map other fields from userAddRequest to user
        userRepository.addUser(user);
    }
}
