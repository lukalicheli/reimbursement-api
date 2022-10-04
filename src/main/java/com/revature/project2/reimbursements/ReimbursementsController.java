package com.revature.project2.reimbursements;

import static com.revature.project2.common.SecurityUtils.enforceAuthentication;
import static com.revature.project2.common.SecurityUtils.enforcePermissions;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reimb")
public class ReimbursementsController {
    
    private static Logger logger = LogManager.getLogger(ReimbursementsController.class);

    private final ReimbursementService reimbService;
    
    @Autowired
    public ReimbursementsController(ReimbursementService reimbService){
        this.reimbService=reimbService;
    }
    
    
    @GetMapping(produces = "application/json")
    public List<ReimbursementResponse> getAllReimbs(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());
        HttpSession userSession = req.getSession(false);
        enforceAuthentication(userSession);
        enforcePermissions(userSession, "admin");
        return reimbService.getAllReimbs();
    }
}
