package com.revature.project2.users;

import com.revature.project2.auth.AuthController;
import com.revature.project2.common.ResourceCreationResponse;
import com.revature.project2.common.SecurityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public List<UserResponse> getAllUsers(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.getAllUsers();
    }
    
    @GetMapping(value = "/active",produces = "application/json")
    public List<UserResponse> getAllActiveUsers(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.getAllUsersFilterByActiveStatus(true);
    }
    
    @GetMapping(value = "/inactive",produces = "application/json")
    public List<UserResponse> getAllInactiveUsers(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.getAllUsersFilterByActiveStatus(false);
    }
    
    @GetMapping(value = "/admins",produces = "application/json")
    public List<UserResponse> getAllAdminUsers(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.getAllUsersFilterByRole("admin");
    }
    
    @GetMapping(value = "/financeManagers",produces = "application/json")
    public List<UserResponse> getAllFinanceManagerUsers(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.getAllUsersFilterByRole("finance manager");
    }
    
    @GetMapping(value = "/employees",produces = "application/json")
    public List<UserResponse> getAllEmployeeUsers(HttpServletRequest req) {
        logger.info("A GET request was received by /users at {}", LocalDateTime.now());

        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.getAllUsersFilterByRole("employee");
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public UserResponse getUserById(@PathVariable String id, HttpSession userSession) {
        logger.info("A GET request was received by /users/{id} at {}", LocalDateTime.now());
        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.getUserById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse registerNewUser(@RequestBody NewUserRequest requestBody, HttpServletRequest req) {
        logger.info("A POST request was received by /users at {}", LocalDateTime.now());

        //confirming that a user is logged in and that they have "admin" credentials 
//        SecurityUtils.enforceAuthentication(AuthController.userSession);
//        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");
        return userService.register(requestBody);
    }

    @PutMapping(consumes = "application/json")
    public void updateUser(@RequestBody UpdateUserBody updateUserBody, HttpServletRequest req) {

        logger.info("A PUT request was received by /users at {}", LocalDateTime.now());

        SecurityUtils.enforceAuthentication(AuthController.userSession);
        SecurityUtils.enforcePermissions(AuthController.userSession, "admin");

        userService.updateUser(updateUserBody);

    }

}
