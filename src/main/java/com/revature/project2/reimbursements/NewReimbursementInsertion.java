package com.revature.project2.reimbursements;

import com.revature.project2.common.Request;

import java.util.UUID;
import javax.persistence.Column;



public class NewReimbursementInsertion implements Request<Reimbursement>{
        
    @Column(columnDefinition = "NUMERIC(6,2)", nullable = false)
    private double amount;
    
    @Column(nullable = false)
    private String submitted;
    
    @Column(nullable = false)
    private String description;
    
    @Column(name = "author_id", nullable = false)
    private UUID authorID;

    @Column(name = "status_id", nullable = false)
    private int statusID;

    @Column(name = "type_id", nullable = false)
    private int typeID;

    public NewReimbursementInsertion() {
        super();
    }

    public NewReimbursementInsertion(double amount, String submitted, String description, UUID authorID, int statusID, int typeID) {
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

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
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
    public Reimbursement extractEntity(){
        Reimbursement extractedEntity = new Reimbursement();
        extractedEntity.setReimbID(UUID.randomUUID());
        extractedEntity.setAmount(this.amount);
        extractedEntity.setSubmitted(this.submitted);
        extractedEntity.setDescription(this.description);
        extractedEntity.setAuthorID(this.authorID);
        extractedEntity.setStatusID(1);
        extractedEntity.setTypeID(this.typeID);
        
        return extractedEntity;
    }
   
}
