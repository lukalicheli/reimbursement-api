package com.revature.project2.reimbursements;

import com.revature.project2.common.Request;

import java.util.UUID;



public class NewReimbursementInsertion implements Request<Reimbursement>{
        
    private double amount;
    
    private String submitted;
    
    private String description;
    
    private UUID authorID;

    private int statusID;

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
        extractedEntity.setStatus(new Status(1, "pending"));
        extractedEntity.setType(new Type(typeID, null));
        
        return extractedEntity;
    }
   
}
