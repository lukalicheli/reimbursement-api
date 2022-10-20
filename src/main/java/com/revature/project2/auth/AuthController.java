package com.revature.project2.auth;

import com.revature.project2.common.exceptions.AuthorizationException;
import com.revature.project2.users.UserResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static Logger logger = LogManager.getLogger(AuthController.class);

    private final AuthService authService;
    public static HttpSession userSession;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public UserResponse authenticate(@RequestBody Credentials credentials, HttpServletRequest req) {

        try{
            UserResponse authUser = authService.authenticate(credentials);

            if(authUser.getIsActive() == false){
                throw new AuthorizationException("User credentials are not active, contact your system admin for activation");
            }

            logger.info("Establishing user session for user: {}", authUser.getUsername());
            userSession = req.getSession();
            userSession.setAttribute("authUser", authUser);

            return authUser;
        }catch(Exception e){
            throw new AuthorizationException();
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpServletRequest req) {
        req.getSession().invalidate();
    }

}
