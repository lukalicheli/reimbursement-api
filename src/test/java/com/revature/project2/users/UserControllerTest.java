package com.revature.project2.users;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.revature.project2.common.ResourceCreationResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllUsers(UserController.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#getAllUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsers2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllUsers(UserController.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        userController
                .getAllUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link UserController#getAllActiveUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllActiveUsers() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllActiveUsers(UserController.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllActiveUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#getAllActiveUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllActiveUsers2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllActiveUsers(UserController.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        userController
                .getAllActiveUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new RequestFacade(new Request(new Connector())))))));
    }

    /**
     * Method under test: {@link UserController#getAllActiveUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllActiveUsers3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllActiveUsers(UserController.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        userController
                .getAllActiveUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link UserController#getAllInactiveUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllInactiveUsers() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllInactiveUsers(UserController.java:52)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllInactiveUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#getAllInactiveUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllInactiveUsers2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllInactiveUsers(UserController.java:52)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllInactiveUsers(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link UserController#getAllAdminUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllAdminUsers() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllAdminUsers(UserController.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllAdminUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#getAllAdminUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllAdminUsers2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllAdminUsers(UserController.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        userController
                .getAllAdminUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link UserController#getAllFinanceManagerUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllFinanceManagerUsers() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllFinanceManagerUsers(UserController.java:70)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllFinanceManagerUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#getAllFinanceManagerUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllFinanceManagerUsers2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllFinanceManagerUsers(UserController.java:70)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllFinanceManagerUsers(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link UserController#getAllEmployeeUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllEmployeeUsers() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllEmployeeUsers(UserController.java:79)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllEmployeeUsers(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#getAllEmployeeUsers(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllEmployeeUsers2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getAllEmployeeUsers(UserController.java:79)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getAllEmployeeUsers(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getUserById(UserController.java:87)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getUserById("42", new StandardSession(new PersistentManager()));
    }

    /**
     * Method under test: {@link UserController#getUserById(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.getUserById(UserController.java:87)
        //   See https://diff.blue/R013 to resolve this issue.

        userController.getUserById("42", new StandardSession(mock(StandardManager.class)));
    }

    /**
     * Method under test: {@link UserController#registerNewUser(NewUserRequest, HttpServletRequest)}
     */
    @Test
    void testRegisterNewUser() {
        ResourceCreationResponse resourceCreationResponse = new ResourceCreationResponse("42");
        when(userService.register((NewUserRequest) any())).thenReturn(resourceCreationResponse);
        NewUserRequest requestBody = new NewUserRequest();
        assertSame(resourceCreationResponse,
                userController.registerNewUser(requestBody, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector())))))));
        verify(userService).register((NewUserRequest) any());
    }

    /**
     * Method under test: {@link UserController#updateUser(UpdateUserBody, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.updateUser(UserController.java:107)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");

        userController.updateUser(updateUserBody, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link UserController#updateUser(UpdateUserBody, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.users.UserController.updateUser(UserController.java:107)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");

        userController.updateUser(updateUserBody,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }
}

