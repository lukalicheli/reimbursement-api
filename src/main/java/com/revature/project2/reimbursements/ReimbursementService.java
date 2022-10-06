package com.revature.project2.reimbursements;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.revature.project2.common.ResourceCreationResponse;
import com.revature.project2.common.exceptions.InvalidRequestException;
import com.revature.project2.common.exceptions.ResourceNotFoundException;
import com.revature.project2.users.User;
import com.revature.project2.users.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReimbursementService {
    private final ReimbursementRepository reimbRepo;

    @Autowired
    public ReimbursementService(ReimbursementRepository reimbRepo) {
        this.reimbRepo = reimbRepo;
    }
    
    public List<ReimbursementResponse> getAllReimbs(){
            return reimbRepo.findAll()
                      .stream()
                      .map(ReimbursementResponse::new)
                      .collect(Collectors.toList());
        }

    public ReimbursementResponse getReimbByID(String id) {
        try {
            return reimbRepo.findById(UUID.fromString(id))
                    .map(ReimbursementResponse::new)
                    .orElseThrow(ResourceNotFoundException::new);
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("A valid uuid must be provided!");
        }
    }
    
    public ResourceCreationResponse generate(NewReimbursementInsertion reimbImport) {


        reimbImport.setSubmitted(Timestamp.valueOf(LocalDateTime.now()).toString());
        reimbImport.setStatusID(1);

        if(reimbImport == null){
            throw new InvalidRequestException("ERROR: can not register null payload");
        }
        if(reimbImport.getAmount() <= 0){
            throw new InvalidRequestException("ERROR: can not register reimbursement amount less than $0.01");
        }
        if(reimbImport.getDescription() == null || reimbImport.getDescription().length() <= 0 ){
            throw new InvalidRequestException("ERROR: reimbursement description must be provided");
        }

        Reimbursement reimbToPersist = reimbImport.extractEntity();
        reimbRepo.save(reimbToPersist);
        return new ResourceCreationResponse(reimbToPersist.getReimbID().toString());
   }
//    
//    
//    
//    public List<ReimbursementResponse> getAllPendingReimbs(String usernameImport){
//        List<ReimbursementResponse> result = new ArrayList<>();
//        List<Reimbursement> reimbList = reimbRepo.getAllPending(usernameImport);
//        for(Reimbursement transfer : reimbList){
//            result.add(new ReimbursementResponse(transfer));
//        }
//        
//        return result;
//    }
//    
//    public List<ReimbursementResponse> getOwnedReimbs(String usernameImport){
//        List<ReimbursementResponse> result = new ArrayList<>();
//        List<Reimbursement> reimbList = reimbRepo.getOwned(usernameImport);
//        for(Reimbursement transfer : reimbList){
//            result.add(new ReimbursementResponse(transfer));
//        }
//        
//        return result;
//    }
//    
//    public List<ReimbursementResponse> getOwnedPendingReimbs(String usernameImport){
//        List<ReimbursementResponse> result = new ArrayList<>();
//        List<Reimbursement> reimbList = reimbRepo.getOwnedPending(usernameImport);
//        for(Reimbursement transfer : reimbList){
//            result.add(new ReimbursementResponse(transfer));
//        }
//        
//        return result;
//    }
//    
//    public ReimbursementResponse getIdentifiedReimb(int reimbIDImport){
//        //filter invalid usernames
//        if(reimbIDImport <= 0){
//            throw new InvalidRequestException(
//                    "ERROR: ReimbusementeID number must be greater than 0");
//        }
//        
//        try{
//            Reimbursement target = reimbRepo.getSingleByReimbID(reimbIDImport).orElse(null); 
//            if (target == null){
//                throw new IllegalArgumentException("ERROR: Reimbursement not found");
//            }
//            
//            ReimbursementResponse result = new ReimbursementResponse(target);
//            return result;
//        }catch(IllegalArgumentException e){
//            throw new InvalidRequestException("ERROR: searched reimbursement was not found");
//        }
//    }//end of getIdentifiedReimb
//    
//    public ReimbursementResponse updateStatusApproveOrDeny (ReimbursementApproveOrDenyAlteration alterationImport, int resolverIDImport){
//        if(alterationImport == null){
//            throw new InvalidRequestException("ERROR: can not update with null payload");
//        }
//        if(resolverIDImport <=0 ){
//            throw new InvalidRequestException("ERROR: Resolver ID not recognized");
//        }
//        
//        try{
//            //attempt to find the reimbursement to be approved/denied
//            Reimbursement target = reimbRepo.getSingleByReimbID(alterationImport.getReimbursementID()).orElse(null); 
//            
//            
//            if (target == null){//can not update a reimbursement that is not in the database
//                throw new InvalidRequestException("ERROR: Reimbursement not found, could not alter");
//            }else if (!target.getStatusID().equals("1")){//can only update a reimbursement that is in pending status
//                throw new InvalidRequestException("ERROR: Reimbursement is not pending approval / rejection");
//            }else{
//                target = reimbRepo.updateReimbursementStatus(alterationImport.getReimbursementID(), alterationImport.getStatusUpdate(), resolverIDImport).orElse(null);
//            }
//            
//            
//            
//            ReimbursementResponse result = new ReimbursementResponse(target);
//            return result;
//        }catch(IllegalArgumentException e){
//            throw new InvalidRequestException("ERROR: searched reimbursement was not found");
//        }
//        
//    }
}//end ReimbursementService class
