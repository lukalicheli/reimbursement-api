package com.revature.project2.users;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

// Example of a response DTO
@Component
public class UserResponse implements Serializable {

    private String id;
    private String givenName;
    private String surname;
    private String email;
    private String username;
    private String role;
    private boolean isActive;
    public UserResponse() {
        super();
    }
    public UserResponse(User subject) {
        this.id = subject.getUserId().toString();
        this.givenName = subject.getGivenName();
        this.surname = subject.getSurname();
        this.email = subject.getEmail();
        this.username = subject.getUsername();
        this.role = subject.getRole().getName();
        this.isActive = subject.getActive();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(givenName, that.givenName) && Objects.equals(surname, that.surname) && 
                Objects.equals(email, that.email) && Objects.equals(username, that.username) && Objects.equals(role, that.role) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, givenName, surname, email, username, role, isActive);
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", active='" + isActive +'\'' +
                '}';
    }

}
