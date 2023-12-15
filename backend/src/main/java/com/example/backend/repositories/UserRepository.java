package com.example.backend.repositories;

import com.example.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query( value = "SELECT U.id, U.email FROM user U WHERE U.id = :userId", nativeQuery = true)
    Object[] getUserById(@Param("userId") Long id);

    // Native query
    @Query( value = "SELECT U.id, U.email FROM user U", nativeQuery = true)
    List<Object[]> getAllUsers();

}

//
//package com.example.demo.repositories;
//
//import com.example.demo.entities.User;
//import org.springframework.data.jdbc.repository.query.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    //    @Query( "SELECT id, email FROM user WHERE id = ?1")
//    @Query( "SELECT U.id, U.email FROM user U WHERE U.id = ?1")
//    public Object getUserById(Long id);
//
//
//
//}
