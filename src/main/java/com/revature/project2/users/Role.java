package com.revature.project2.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ers_user_roles")
public class Role {

    @Id
    @Column(name = "role_id")
    private int role_id;

    @Column(name = "role", nullable = false, unique = true)
    private String name;

    public Role() {
        super();
    }

    public Role(int role_id, String role) {
        this.role_id = role_id;
        this.name = role;
    }
    
    //alternate constructor for taking JSON arguments
    public Role(String role_id, String role) {
        this.role_id = Integer.parseInt(role_id);
        this.name = role;
    }
    
    public Role(int idImport){
        this.role_id = idImport;
        
        switch(idImport){
            case 1:
                this.name = "admin";
                break;
            case 2:
                this.name = "finance manager";
                break;
            case 3:
                this.name = "employee";
                break;
        }
    }
    
    public Role(String idImport){
        this.role_id = Integer.parseInt(idImport);
        
        switch(this.role_id){
            case 1:
                this.name = "admin";
                break;
            case 2:
                this.name = "finance manager";
                break;
            case 3:
                this.name = "employee";
                break;
        }
    }

    public int getId() {
        return role_id;
    }

    public void setId(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role_id, role1.role_id) && Objects.equals(name, role1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_id, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", role='" + name + '\'' +
                '}';
    }

}
