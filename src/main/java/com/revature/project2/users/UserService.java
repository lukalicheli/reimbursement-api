package com.revature.project2.users;

import com.revature.project2.common.ResourceCreationResponse;
import com.revature.project2.common.exceptions.InvalidRequestException;
import com.revature.project2.common.exceptions.ResourceNotFoundException;
import com.revature.project2.common.exceptions.ResourcePersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserResponse> getAllUsers() {
        return userRepo.findAll()
                      .stream()
                      .map(UserResponse::new)
                      .collect(Collectors.toList());
    }//end getAllUsers method

    public UserResponse getUserById(String id) {
        try {
            return userRepo.findById(UUID.fromString(id))
                           .map(UserResponse::new)
                           .orElseThrow(ResourceNotFoundException::new);
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("A valid uuid must be provided!");
        }
    }//end getUserById method
    
    public UserResponse getUserByUsername(String usernameImport) {
        try {
            return userRepo.findByUsername(usernameImport)
                           .map(UserResponse::new)
                           .orElseThrow(ResourceNotFoundException::new);
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("A valid username must be provided!");
        }
    }//end getUserByUsername method

    public ResourceCreationResponse register(NewUserRequest newUser) {

        if (newUser == null) {
            throw new InvalidRequestException("Provided request payload was null.");
        }

        if (newUser.getGivenName() == null || newUser.getGivenName().length() <= 0 ||
            newUser.getSurname() == null || newUser.getSurname().length() <= 0)
        {
            throw new InvalidRequestException("A non-empty given name and surname must be provided");
        }

        if (newUser.getEmail() == null || newUser.getEmail().length() <= 0) {
            throw new InvalidRequestException("A non-empty email must be provided.");
        }

        if (newUser.getUsername() == null || newUser.getUsername().length() < 4) {
            throw new InvalidRequestException("A username with at least 4 characters must be provided.");
        }

        if (newUser.getPassword() == null || newUser.getPassword().length() < 8) {
            throw new InvalidRequestException("A password with at least 8 characters must be provided.");
        }

        if (userRepo.existsByEmail(newUser.getEmail())) {
            throw new ResourcePersistenceException("Resource not persisted! The provided email is already taken.");
        }

        if (userRepo.existsByUsername(newUser.getUsername())) {
            throw new ResourcePersistenceException("Resource not persisted! The provided username is already taken.");
        }

        User userToPersist = newUser.extractEntity();
        userRepo.save(userToPersist);
        return new ResourceCreationResponse(userToPersist.getUserId().toString());

    }//end register method
    
    @Transactional
    public UserResponse activateUser(String usernameImport){
        try{    
            userRepo.activateUser(usernameImport);
            
            return new UserResponse(userRepo.findByUsername(usernameImport).orElse(null));
        }catch (IllegalArgumentException e) {
            throw new InvalidRequestException("A valid uuid must be provided!");
        }
        
    }//end activateUser method
    
    @Transactional
    public UserResponse deactivateUser(String usernameImport){
        try{    
            userRepo.deactivateUser(usernameImport);
            
            
            UserResponse result = new UserResponse(userRepo.findByUsername(usernameImport).orElse(null));
            
            return result;
        }catch (IllegalArgumentException e) {
            throw new InvalidRequestException("A valid uuid must be provided!");
        }
        
    }//end deactivateUser method
    
    public UserResponse updateUserRole(String usernameImport, Role roleImport){
        //validation that neither import value is null
        if(usernameImport == null){
            throw new InvalidRequestException("ERROR: Null target username");
        }
        if(roleImport.equals(null)){
            throw new InvalidRequestException("ERROR: New Role null payload");
        }
        
        try{
            //attempt to find the reimbursement to be approved/denied
            User target = userRepo.findByUsername(usernameImport).orElse(null); 
            
            if(target == null){//can not update a reimbursement that is not in the database
                throw new InvalidRequestException();
            }
                
            target.setRole(roleImport);
            
            userRepo.save(target);
            
            UserResponse result = new UserResponse(target);
            return result;
            
        }catch(IllegalArgumentException e){
            throw new InvalidRequestException("ERROR: searched user was not found");
        }
    }//end updateUserRole method
    
    
}//end UserService class
