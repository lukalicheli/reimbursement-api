package com.revature.project2.reimbursements;

import static com.revature.project2.common.SecurityUtils.enforceAuthentication;
import static com.revature.project2.common.SecurityUtils.enforcePermissions;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.project2.common.ResourceCreationResponse;
import com.revature.project2.common.SecurityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        HttpSession userSession = req.getSession(false);
        enforceAuthentication(userSession);
        enforcePermissions(userSession, "finance manager");
        return reimbService.getAllReimbs();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ReimbursementResponse getReimbByID(@PathVariable String id, HttpSession userSession) {
        logger.info("A GET request was received by /users/{id} at {}", LocalDateTime.now());
        enforceAuthentication(userSession);
//        enforcePermissions(userSession, "employee");
        enforcePermissions(userSession, "finance manager");
        return reimbService.getReimbByID(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse generate(@RequestBody NewReimbursementInsertion requestBody, HttpServletRequest req) {
        logger.info("A POST request was received by /users at {}", LocalDateTime.now());
        HttpSession userSession = req.getSession(false);

        SecurityUtils.enforceAuthentication(userSession);
        SecurityUtils.enforcePermissions(userSession, "finance manager");
        return reimbService.generate(requestBody);
    }
}