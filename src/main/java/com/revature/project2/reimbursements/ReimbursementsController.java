package com.revature.project2.reimbursements;

import static com.revature.project2.common.SecurityUtils.enforceAuthentication;
import static com.revature.project2.common.SecurityUtils.enforcePermissions;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.project2.auth.AuthController;
import com.revature.project2.common.ResourceCreationResponse;
import com.revature.project2.common.SecurityUtils;
import com.revature.project2.users.UserResponse;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
@RestController
@RequestMapping("/reimb")
public class ReimbursementsController {

    private static Logger logger = LogManager.getLogger(ReimbursementsController.class);

    private final ReimbursementService reimbService;

    @Autowired
    public ReimbursementsController(ReimbursementService reimbService) {
        this.reimbService = reimbService;
    }


    @GetMapping(produces = "application/json")
    public List<ReimbursementResponse> getAllReimbs(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        enforceAuthentication(AuthController.userSession);
        enforcePermissions(AuthController.userSession, "finance manager");
        return reimbService.getAllReimbs();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ReimbursementResponse getReimbByID(@PathVariable String id, HttpSession userSession) {
        logger.info("A GET request was received by /users/{id} at {}", LocalDateTime.now());
        enforceAuthentication(AuthController.userSession);
//        enforcePermissions(userSession, "employee");
        enforcePermissions(AuthController.userSession, "finance manager");
        return reimbService.getReimbByID(id);
    }
    
    @GetMapping(value = "/AllPending", produces = "application/json")
    public List<ReimbursementResponse> getAllPendingReimbs(HttpServletRequest req){
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        enforceAuthentication(AuthController.userSession);
        enforcePermissions(AuthController.userSession, "finance manager");
        return reimbService.getAllReimbsByStatus(1);
    }

    @GetMapping(value = "/AllDenied", produces = "application/json")
    public List<ReimbursementResponse> getAllDeniedReimbs(HttpServletRequest req){
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        enforceAuthentication(AuthController.userSession);
        enforcePermissions(AuthController.userSession, "finance manager");
        return reimbService.getAllReimbsByStatus(2);
    }

    @GetMapping(value = "/AllApproved", produces = "application/json")
    public List<ReimbursementResponse> getAllApprovedReimbs(HttpServletRequest req){
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        enforceAuthentication(AuthController.userSession);
        enforcePermissions(AuthController.userSession, "finance manager");
        return reimbService.getAllReimbsByStatus(3);
    }



    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse generate(@RequestBody NewReimbursementInsertion requestBody, HttpServletRequest req) {
        logger.info("A POST request was received by /users at {}", LocalDateTime.now());

        
        SecurityUtils.enforceAuthentication(AuthController.userSession);
        
        UserResponse requester = (UserResponse) AuthController.userSession.getAttribute("authUser");
        String authorID = requester.getId();
        requestBody.setAuthorID(UUID.fromString(authorID));
        
        return reimbService.generate(requestBody);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public ReimbursementResponse approveOrDenyReimbByID(@RequestBody ReimbursementApproveOrDenyAlteration importStatement, HttpServletRequest req){
        logger.info("A PUT request was received by /users at {}", LocalDateTime.now());

        
        //gathering who is logged in 
        UserResponse requester = (UserResponse) AuthController.userSession.getAttribute("authUser");
        String resolver = requester.getId();
        
        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "finance manager");
        return reimbService.updateStatusApproveOrDeny(importStatement, resolver);
    }
}