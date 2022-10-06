package com.revature.project2.reimbursements;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ers_reimbursements")
public class Reimbursement {
    @Id
    @Column(name = "reimb_id")
    private UUID reimbID;

    @Column(columnDefinition = "NUMERIC(6,2)", nullable = false)
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
    private int statusID;

    @Column(name = "type_id", nullable = false)
    private int typeID;

    public Reimbursement() {
        super();
    }
    public Reimbursement(UUID reimbID, double amount, String submitted, String resolved, String description, UUID authorID, UUID resolverID, int statusID, int typeID) {
        this.reimbID = reimbID;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.authorID = authorID;
        this.resolverID = resolverID;
        this.statusID = statusID;
        this.typeID = typeID;
    }

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

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return Double.compare(that.amount, amount) == 0 && statusID == that.statusID && typeID == that.typeID && reimbID.equals(that.reimbID) && submitted.equals(that.submitted) && resolved.equals(that.resolved) && description.equals(that.description) && authorID.equals(that.authorID) && resolverID.equals(that.resolverID);
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
