package com.revature.project2.reimbursements;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class Reimbursement {
    @Id
    @Column(name = "reimb_id")
    private UUID reimbID;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String submitted;

    @Column
    private String resolved;

    @Column(nullable = false)
    private String description;

    @Column(name = "author_id", nullable = false)
    private UUID authorID;

    @Column(name = "resolver_id")
    private UUID resolverID;

    @Column(name = "status_id", nullable = false)
    private UUID statusID;

    @Column(name = "type_id", nullable = false)
    private UUID typeID;



    public UUID getReimbID() {
        return reimbID;
    }

    public void setReimbID(UUID reimbID) {
        this.reimbID = reimbID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getAuthorID() {
        return authorID;
    }

    public void setAuthorID(UUID authorID) {
        this.authorID = authorID;
    }

    public UUID getResolverID() {
        return resolverID;
    }

    public void setResolverID(UUID resolverID) {
        this.resolverID = resolverID;
    }

    public UUID getStatusID() {
        return statusID;
    }

    public void setStatusID(UUID statusID) {
        this.statusID = statusID;
    }

    public UUID getTypeID() {
        return typeID;
    }

    public void setTypeID(UUID typeID) {
        this.typeID = typeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return Double.compare(that.amount, amount) == 0 && reimbID.equals(that.reimbID) && submitted.equals(that.submitted) && resolved.equals(that.resolved) && description.equals(that.description) && authorID.equals(that.authorID) && resolverID.equals(that.resolverID) && statusID.equals(that.statusID) && typeID.equals(that.typeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbID, amount, submitted, resolved, description, authorID, resolverID, statusID, typeID);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbID=" + reimbID +
                ", amount=" + amount +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", authorID=" + authorID +
                ", resolverID=" + resolverID +
                ", statusID=" + statusID +
                ", typeID=" + typeID +
                '}';
    }
}
