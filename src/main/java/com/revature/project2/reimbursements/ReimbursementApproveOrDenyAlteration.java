package com.revature.project2.reimbursements;

import java.util.UUID;

public class ReimbursementApproveOrDenyAlteration {
    private UUID reimbursementID;
    private boolean statusUpdate;//true if approved, false if denied

    //make Jackson happy with default constructor
    public ReimbursementApproveOrDenyAlteration(){
        super();
    }
    
    public ReimbursementApproveOrDenyAlteration(UUID reimbIDImport, boolean statusUpdateImport){
        this.reimbursementID = reimbIDImport;
        this.statusUpdate = statusUpdateImport;
    }
    
    //getters and setters
    public UUID getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(UUID reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public boolean getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(boolean statusUpdate) {
        this.statusUpdate = statusUpdate;
    }
    
    
}
