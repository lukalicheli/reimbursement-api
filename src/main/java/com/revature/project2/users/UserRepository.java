package com.revature.project2.users;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> findAllByIsActive(boolean active);
    List<User> findAllByRoleName(String roleName);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    Optional<User> findUserByUsernameAndPassword(String username, String password);
    


}
