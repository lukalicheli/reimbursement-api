package com.revature.project2.users;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> findAllByIsActive(boolean active);
    List<User> findAllByRoleName(String roleName);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

//    @Query(nativeQuery = true, value = "SELECT * FROM app_users WHERE username = :1 AND password :2")
    Optional<User> findUserByUsernameAndPassword(String username, String password);
    
    @Modifying
    @Query(value = "update ers_users set is_active = true where username = :insertUsername", nativeQuery = true)
    int activateUser(@Param("insertUsername") String username);
    
    @Modifying
    @Query(value = "update ers_users set is_active = false where username = :insertUsername", nativeQuery = true)
    int deactivateUser(@Param("insertUsername") String username);


}
