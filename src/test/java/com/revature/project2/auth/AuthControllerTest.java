package com.revature.project2.auth;

import com.revature.project2.users.Role;
import com.revature.project2.users.User;
import com.revature.project2.users.UserRepository;
import com.revature.project2.users.UserResponse;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;
import org.apache.catalina.session.PersistentManager;
import org.apache.catalina.session.StandardSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplicationExtensionsKt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    /**
     * Method under test: {@link AuthController#authenticate(Credentials, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate() {


        UUID userId = UUID.randomUUID();
        when(authService.authenticate((Credentials) any())).thenReturn(new UserResponse(
                new User(userId, "janedoe", "jane.doe@example.org", "iloveyou", "Given Name", "Doe", true, new Role())));
        Credentials credentials = new Credentials("janedoe", "iloveyou");

        authController.authenticate(credentials, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link AuthController#authenticate(Credentials, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate2() {


        when(authService.authenticate((Credentials) any())).thenReturn(null);
        Credentials credentials = new Credentials("janedoe", "iloveyou");

        authController.authenticate(credentials, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link AuthController#authenticate(Credentials, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate3() {


        UUID userId = UUID.randomUUID();
        when(authService.authenticate((Credentials) any())).thenReturn(new UserResponse(
                new User(userId, "janedoe", "jane.doe@example.org", "iloveyou", "Given Name", "Doe", true, new Role())));
        authController.authenticate(new Credentials("janedoe", "iloveyou"), null);
    }

    /**
     * Method under test: {@link AuthController#logout(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogout() {


        authController.logout(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link AuthController#logout(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogout2() {


        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession()).thenReturn(new StandardSession(new PersistentManager()));
        authController.logout(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link AuthController#logout(HttpServletRequest)}
     */
    @Test
    void testLogout3() {
        StandardSession standardSession = mock(StandardSession.class);
        doNothing().when(standardSession).invalidate();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession()).thenReturn(standardSession);
        authController.logout(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
        verify(defaultMultipartHttpServletRequest).getSession();
        verify(standardSession).invalidate();
    }

    /**
     * Method under test: {@link AuthController#logout(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogout4() {


        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession()).thenReturn(mock(StandardSession.class));
        new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)));
        authController.logout(null);
    }




}