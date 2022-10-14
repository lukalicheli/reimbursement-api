package com.revature.project2.users;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;
import org.apache.catalina.session.PersistentManager;
import org.apache.catalina.session.StandardManager;
import org.apache.catalina.session.StandardSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    /**
     * Method under test: {@link UserController#getAllUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsers() {


        userController.getAllUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#getAllUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsers2() {


        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        userController.getAllUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById() {


        userController.getUserById("42", new StandardSession(new PersistentManager()));
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById2() {


        userController.getUserById("42", new StandardSession(mock(StandardManager.class)));
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById3() {


        userController.getUserById("42", null);
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById4() {


        StandardSession standardSession = mock(StandardSession.class);
        when(standardSession.getAttribute((String) any())).thenReturn(null);
        userController.getUserById("42", standardSession);
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById5() {


        StandardSession standardSession = mock(StandardSession.class);
        when(standardSession.getAttribute((String) any())).thenReturn(mock(UserResponse.class));
        userController.getUserById("42", standardSession);
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById6() {

        StandardSession standardSession = mock(StandardSession.class);
        UUID userId = UUID.randomUUID();
        when(standardSession.getAttribute((String) any())).thenReturn(new UserResponse(
                new User(userId, "janedoe", "jane.doe@example.org", "iloveyou", "Given Name", "Doe", true, new Role())));
        userController.getUserById("42", standardSession);
    }

    /**
     * Method under test: {@link UserController#registerNewUser(NewUserRequest, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterNewUser() {


        NewUserRequest requestBody = new NewUserRequest();
        userController.registerNewUser(requestBody, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#registerNewUser(NewUserRequest, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterNewUser2() {


        NewUserRequest requestBody = new NewUserRequest();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        userController.registerNewUser(requestBody, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link UserController#updateUserActivationByUsername(String, boolean, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserActivationByUsername() {


        userController.updateUserActivationByUsername("janedoe", true,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#updateUserActivationByUsername(String, boolean, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserActivationByUsername2() {


        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        userController.updateUserActivationByUsername("janedoe", true,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link UserController#updateUserRoleByUsername(String, Role, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserRoleByUsername() {


        Role role = mock(Role.class);
        doNothing().when(role).setId(anyInt());
        doNothing().when(role).setName((String) any());
        role.setId(1);
        role.setName("Name");
        userController.updateUserRoleByUsername("janedoe", role,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#updateUserRoleByUsername(String, Role, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserRoleByUsername2() {


        Role role = mock(Role.class);
        doNothing().when(role).setId(anyInt());
        doNothing().when(role).setName((String) any());
        role.setId(1);
        role.setName("Name");
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        userController.updateUserRoleByUsername("janedoe", role,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }
}

