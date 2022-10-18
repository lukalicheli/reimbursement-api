package com.revature.project2.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.revature.project2.common.exceptions.InvalidRequestException;
import com.revature.project2.users.Role;
import com.revature.project2.users.User;
import com.revature.project2.users.UserRepository;
import com.revature.project2.users.UserResponse;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    /**
     * Method under test: {@link AuthService#authenticate(Credentials)}
     */
    @Test
    void testAuthenticate() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        UserResponse actualAuthenticateResult = authService.authenticate(new Credentials("janedoe", "iloveyou"));
        assertEquals("jane.doe@example.org", actualAuthenticateResult.getEmail());
        assertEquals("janedoe", actualAuthenticateResult.getUsername());
        assertEquals("Doe", actualAuthenticateResult.getSurname());
        assertEquals("Name", actualAuthenticateResult.getRole());
        assertTrue(actualAuthenticateResult.getIsActive());
        assertEquals("Given Name", actualAuthenticateResult.getGivenName());
        verify(userRepository).findUserByUsernameAndPassword((String) any(), (String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
    }

    /**
     * Method under test: {@link AuthService#authenticate(Credentials)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.InvalidRequestException: An error occurred
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:29)
        //       at java.util.Optional.map(Optional.java:265)
        //       at com.revature.project2.auth.AuthService.authenticate(AuthService.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new InvalidRequestException("An error occurred"));
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        authService.authenticate(new Credentials("janedoe", "iloveyou"));
    }

    /**
     * Method under test: {@link AuthService#authenticate(Credentials)}
     */
    @Test
    void testAuthenticate3() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(false);
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        UserResponse actualAuthenticateResult = authService.authenticate(new Credentials("janedoe", "iloveyou"));
        assertEquals("jane.doe@example.org", actualAuthenticateResult.getEmail());
        assertEquals("janedoe", actualAuthenticateResult.getUsername());
        assertEquals("Doe", actualAuthenticateResult.getSurname());
        assertEquals("Name", actualAuthenticateResult.getRole());
        assertFalse(actualAuthenticateResult.getIsActive());
        assertEquals("Given Name", actualAuthenticateResult.getGivenName());
        verify(userRepository).findUserByUsernameAndPassword((String) any(), (String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
    }

    /**
     * Method under test: {@link AuthService#authenticate(Credentials)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find a user account with the provided credentials!
        //       at java.util.Optional.orElseThrow(Optional.java:408)
        //       at com.revature.project2.auth.AuthService.authenticate(AuthService.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.findUserByUsernameAndPassword((String) any(), (String) any())).thenReturn(Optional.empty());
        authService.authenticate(new Credentials("janedoe", "iloveyou"));
    }

    /**
     * Method under test: {@link AuthService#authenticate(Credentials)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.auth.AuthService.authenticate(AuthService.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        authService.authenticate(new Credentials(null, "iloveyou"));
    }


    /**
     * Method under test: {@link AuthService#authenticate(Credentials)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.auth.AuthService.authenticate(AuthService.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findUserByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        authService.authenticate(new Credentials("janedoe", null));
    }

    /**
     * Method under test: {@link AuthService#authenticate(Credentials)}
     */
}