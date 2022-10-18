package com.revature.project2.reimbursements;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "ers_reimbursement_types")
public class Type {
    
    @Id // indicates a primary key
    @Column(name = "type_id")
    private int typeID;

    @Column(name = "type", nullable = false, unique = true)
    private String type;

    public Type() {
        super();
    }

    public Type(int typeID, String type) {
        this.typeID = typeID;
        this.type = type;
    }

    public Type(int idImport){
        this.typeID = idImport;

        switch(idImport){
            case 1:
                this.type = "lodging";
                break;
            case 2:
                this.type = "travel";
                break;
            case 3:
                this.type = "food";
                break;
            case 4:
                this.type = "other";
                break;
        }
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return type;
    }

    public void setTypeName(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type that = (Type) o;
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
