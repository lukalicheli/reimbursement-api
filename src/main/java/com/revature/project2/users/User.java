package com.revature.project2.users;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "app_users")
public class User {

    @Id // indicates a primary key
    @Column // all fields in an entity implicitly have @Column
    private UUID user_id;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(name = "given_name", nullable = false)
    private String givenName;
    
    @Column(nullable = false)
    private String surname;
    
    @Column(name = "is_active")
    private boolean isActive;

    

    
    
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // JPA REQUIRES A NO-ARG CONSTRUCTOR FOR ALL ENTITIES
    public User() {
        super();
    }

    public User(UUID id, String givenName, String surname, String email, String username, String password, Role role, boolean isActive) {
        this.user_id = id;
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    public UUID getId() {
        return user_id;
    }

    public void setId(UUID id) {
        this.user_id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public boolean isIsActive() {
            return isActive;
        }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" + 
                "user_id=" + user_id + 
                ", username=" + username + 
                ", email=" + email + 
                ", password=" + password + 
                ", givenName=" + givenName + 
                ", surname=" + surname + 
                ", isActive=" + isActive + 
                ", role=" + role + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.user_id);
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.givenName);
        hash = 89 * hash + Objects.hashCode(this.surname);
        hash = 89 * hash + (this.isActive ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.isActive != other.isActive) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.givenName, other.givenName)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }
}
