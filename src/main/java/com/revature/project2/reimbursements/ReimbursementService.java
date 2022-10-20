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
import com.revature.project2.users.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReimbursementService {
    private final ReimbursementRepository reimbRepo;
    private final UserRepository userRepo;

    @Autowired
    public ReimbursementService(ReimbursementRepository reimbRepo, UserRepository userRepo) {
        this.reimbRepo = reimbRepo;
        this.userRepo = userRepo;
    }
    
    public List<ReimbursementResponse> getAllReimbs(){
        return reimbRepo.findAll()
                  .stream()
                  .map(ReimbursementResponse::new)
                  .collect(Collectors.toList());
    }//end getAllReimbs method

    public List<ReimbursementResponse> getAllReimbsByStatus(int type){
        try{
            List<Reimbursement> result = reimbRepo.findAllReimbursementByStatusStatusID(type);
            
            if(result.isEmpty()){
                throw new ResourceNotFoundException();
            }
            
            List<ReimbursementResponse> cleanResult = new ArrayList<>();
            
            for(Reimbursement transfer:result){
                cleanResult.add(new ReimbursementResponse(transfer));
            }
            
            return cleanResult;
        }catch(Exception e){
            throw new InvalidRequestException();
        }
    }//end getAllReimbsByStatus method
    
    public List<ReimbursementResponse> getAllOwnedReimbs(String ownerUsername){
        return reimbRepo.findAllReimbursementByAuthorUsername(ownerUsername)
                  .stream()
                  .map(ReimbursementResponse::new)
                  .collect(Collectors.toList());
    }//end getAllOwnedReimbs method
    
    public ReimbursementResponse getReimbByID(String id) {
        try {
            return reimbRepo.findById(UUID.fromString(id))
                    .map(ReimbursementResponse::new)
                    .orElseThrow(ResourceNotFoundException::new);
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("A valid uuid must be provided!");
        }
    }//end getReimbByID method
    
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
        reimbToPersist.setAuthor(userRepo.getById(reimbImport.getAuthorID()));
        
        reimbRepo.save(reimbToPersist);
        return new ResourceCreationResponse(reimbToPersist.getReimbID().toString());
   }//end generate method
    
    public ReimbursementResponse updateStatusApproveOrDeny (ReimbursementApproveOrDenyAlteration alterationImport, String resolverIDImport){
        //validation that neither import value is null
        if(alterationImport == null){
            throw new InvalidRequestException("ERROR: can not update with null payload");
        }
        if(resolverIDImport.equals(null)){
            throw new InvalidRequestException("ERROR: Resolver ID null payload");
        }
        
        try{
            //attempt to find the reimbursement to be approved/denied
            Reimbursement target = reimbRepo.findById(alterationImport.getReimbursementID()).orElse(null); 
            
            
            if(target == null){//can not update a reimbursement that is not in the database
                throw new InvalidRequestException("ERROR: Reimbursement not found, could not alter");
                
            }else if (target.getStatus().getStatusID() != 1){//can only update a reimbursement that is in pending status
                throw new InvalidRequestException("ERROR: Reimbursement is not pending approval / rejection");
            
            }else{//reimbursement approved
                if(alterationImport.getStatusUpdate()){
                    target.setResolver(new User (UUID.fromString(resolverIDImport)));
                    target.setResolved(Timestamp.valueOf(LocalDateTime.now()).toString());
                    target.setStatus(new Status(3, "approved"));
                }else{//reimbursement denied
                    target.setResolver(new User (UUID.fromString(resolverIDImport)));
                    target.setResolved(Timestamp.valueOf(LocalDateTime.now()).toString());
                    target.setStatus(new Status(2, "denied"));
                }
                
                reimbRepo.save(target);
            }
            
            ReimbursementResponse result = new ReimbursementResponse(target);
            return result;
        }catch(IllegalArgumentException e){
            throw new InvalidRequestException("ERROR: searched reimbursement was not found");
        }
        
    }//end updateStatusApproveOrDeny method

}//end ReimbursementService class
