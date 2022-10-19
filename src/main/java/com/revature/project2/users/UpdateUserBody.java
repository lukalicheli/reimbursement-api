package com.revature.project2.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UpdateUserBody {

    private String userId;
    private String username;
    private String email;
    private String password;
    private String givenName;
    private String surname;
    @JsonProperty("isActive")
    private String isActive;
    private String roleName;

    public UpdateUserBody() {
        super();
    }

    public UpdateUserBody(String userId, String username, String email, String password, String givenName, String surname, String isActive, String roleName) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.givenName = givenName;
        this.surname = surname;
        this.isActive = isActive;
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserBody that = (UpdateUserBody) o;
        return userId.equals(that.userId) && username.equals(that.username) && email.equals(that.email) && password.equals(that.password) && givenName.equals(that.givenName) && surname.equals(that.surname) && isActive.equals(that.isActive) && roleName.equals(that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, givenName, surname, isActive, roleName);
    }

    @Override
    public String toString() {
        return "UpdateUserBody{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", isActive='" + isActive + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
