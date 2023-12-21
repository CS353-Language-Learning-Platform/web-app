//package com.example.backend.repositories;
//
//import com.example.backend.entities.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface UserRepository {
//
//    @Query( value = "SELECT U.user_id, U.email FROM user U WHERE U.user_id = :userId", nativeQuery = true)
//    Object[] getUserById(@Param("userId") Long id);
//
//    // Native query
//    @Query( value = "SELECT U.user_id, U.email FROM user U", nativeQuery = true)
//    List<Object[]> getAllUsers();
//
////    @Query( value = "INSERT INTO user (name, email, biography, nationality, birth_date, password) VALUES (:user);", nativeQuery = true)
////    User addUser(@Param("user") User user);
//
//    @Modifying
//    @Query(value = "INSERT INTO user (name, email, biography, nationality, birth_date, password) " +
//            "VALUES (:#{#user.name}, :#{#user.email}, :#{#user.biography}, :#{#user.nationality}, :#{#user.birth_date}, :#{#user.password})", nativeQuery = true)
//    void addUser(@Param("user") User user);
//
//
//}
//
////
////package com.example.demo.repositories;
////
////import com.example.demo.entities.User;
////import org.springframework.data.jdbc.repository.query.Query;
////import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.stereotype.Repository;
////
////@Repository
////public interface UserRepository extends JpaRepository<User, Long> {
////
////    //    @Query( "SELECT id, email FROM user WHERE id = ?1")
////    @Query( "SELECT U.id, U.email FROM user U WHERE U.id = ?1")
////    public Object getUserById(Long id);
////
////
////
////}


package com.example.backend.repositories;

import com.example.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getUserById(Long userId) {
        String sql = "SELECT user_id, email FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, userRowMapper());
    }

    public List<User> getAllUsers() {
        String sql = "SELECT user_id, name, email, biography, nationality, birth_date, password FROM user";
        return jdbcTemplate.query(sql, userRowMapper());
    }

    @Transactional
    public void addUser(User user) {
        String sql = "INSERT INTO user (name, email, biography, nationality, birth_date, password) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getBiography(), user.getNationality(), user.getBirthDate(), user.getPassword());
    }

    public boolean existsById(Long userId) {
        String sql = "SELECT COUNT(*) FROM user WHERE user_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{userId}, Integer.class);
        return count != null && count > 0;
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getLong("user_id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setBiography(rs.getString("biography"));

            return user;
        };
    }
}
