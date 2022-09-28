package com.revature.project2.reimbursements;


import java.util.Objects;
import java.util.UUID;

public class ReimbursementResponse {
    private UUID reimbID;
    private double amount;
    private String submitted;
    private String resolved;
    private String description;
    private UUID authorID;
    private UUID resolverID;
    private UUID statusID;
    private UUID typeID;

    //make Jackson happy with default constructor
    public ReimbursementResponse(){
        super();
    }
    
    public ReimbursementResponse(Reimbursement reimbImport) {
        this.reimbID = reimbImport.getReimbID();
        this.amount = reimbImport.getAmount();
        this.submitted = reimbImport.getSubmitted();
        this.resolved = reimbImport.getResolved();
        this.description = reimbImport.getDescription();
        this.authorID = reimbImport.getAuthorID();
        this.resolverID = reimbImport.getResolverID();
        this.statusID = reimbImport.getStatusID();
        this.typeID = reimbImport.getTypeID();
        
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
        ReimbursementResponse that = (ReimbursementResponse) o;
        return Double.compare(that.amount, amount) == 0 && reimbID.equals(that.reimbID) && submitted.equals(that.submitted) && resolved.equals(that.resolved) && description.equals(that.description) && authorID.equals(that.authorID) && resolverID.equals(that.resolverID) && statusID.equals(that.statusID) && typeID.equals(that.typeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbID, amount, submitted, resolved, description, authorID, resolverID, statusID, typeID);
    }

    @Override
    public String toString() {
        return "ReimbursementResponse{" +
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
