package com.revature.project2.reimbursements;

import com.revature.project2.common.Request;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;



public class NewReimbursementInsertion implements Request<Reimbursement>{
        
    @Column(columnDefinition = "NUMERIC(6,2)", nullable = false)
    private double amount;
    
    @Column(nullable = false)
    private Timestamp submitted;
    
    @Column(nullable = false)
    private String description;
    
    @Column(name = "author_id", nullable = false)
    private UUID authorID;

    @Column(name = "status_id", nullable = false)
    private UUID statusID;

    @Column(name = "type_id", nullable = false)
    private UUID typeID;

    public NewReimbursementInsertion() {
        super();
    }

    public NewReimbursementInsertion(double amount, Timestamp submitted, String description, UUID authorID, UUID statusID, UUID typeID) {
        this.amount = amount;
        this.submitted = submitted;
        this.description = description;
        this.authorID = authorID;
        this.statusID = statusID;
        this.typeID = typeID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
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
    public String toString() {
        return "NewReimbursementInsertion{" +
                "amount=" + amount +
                ", submitted=" + submitted +
                ", description='" + description + '\'' +
                ", authorID=" + authorID +
                ", statusID=" + statusID +
                ", typeID=" + typeID +
                '}';
    }

    @Override
    public Reimbursement extractEntity(){
        Reimbursement extractedEntity = new Reimbursement();
        extractedEntity.setAmount(this.amount);
        extractedEntity.setSubmitted(this.submitted);
        extractedEntity.setDescription(this.description);
        extractedEntity.setAuthorID(this.authorID);
        extractedEntity.setStatusID(UUID.fromString("32034027-9e73-4cad-8747-17fdd3f5e3ef"));
        extractedEntity.setTypeID(this.typeID);
        
        return extractedEntity;
    }
   
}
