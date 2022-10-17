package com.revature.project2.reimbursements;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "ers_reimbursement_types")
@Component
public class ReimbursementType {
    @Id // indicates a primary key
    @Column(name = "type_id")
    private int typeID;

    @Column(name = "type", nullable = false, unique = true)
    private String type;

    public ReimbursementType() {
        super();
    }

    public ReimbursementType(int typeID, String type) {
        this.typeID = typeID;
        this.type = type;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementType that = (ReimbursementType) o;
        return typeID == that.typeID && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeID, type);
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "typeID=" + typeID +
                ", type='" + type + '\'' +
                '}';
    }
}
