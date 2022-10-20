package com.revature.project2.reimbursements;


import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;
@Component
public class ReimbursementResponse {
    private UUID reimbID;
    private double amount;
    private String submitted;
    private String resolved;
    private String description;
    private String authorID;
    private String resolverID;
    private String status;
    private String type;


    public ReimbursementResponse(){
        super();
    }
    
    public ReimbursementResponse(Reimbursement reimbImport) {
               
        this.reimbID = reimbImport.getReimbID();
        this.amount = reimbImport.getAmount();
        this.submitted = reimbImport.getSubmitted();
        this.resolved = reimbImport.getResolved();
        this.description = reimbImport.getDescription();
        this.authorID = reimbImport.getAuthor().getUserId().toString();
        
        if(reimbImport.getResolver() != null){
            this.resolverID = reimbImport.getResolver().getUserId().toString();
        }else{
            this.resolverID = "";
        }
        
        this.status = reimbImport.getStatus().getStatusName();
        this.type = reimbImport.getType().getTypeName();

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

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getResolverID() {
        return resolverID;
    }

    public void setResolverID(String resolverID) {
        this.resolverID = resolverID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setTypeID(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementResponse that = (ReimbursementResponse) o;
        return Double.compare(that.amount, amount) == 0 && reimbID.equals(that.reimbID) && submitted.equals(that.submitted) && 
                resolved.equals(that.resolved) && description.equals(that.description) && authorID.equals(that.authorID) && 
                resolverID.equals(that.resolverID) && status.equals(that.status) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbID, amount, submitted, resolved, description, authorID, resolverID, status, type);
    }

    @Override
    public String toString() {
        return "ReimbursementResponse{" +
                "reimbID=" + reimbID +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", authorID=" + authorID +
                ", resolverID=" + resolverID +
                ", statusID=" + status +
                ", typeID=" + type +
                '}';
    }
}
