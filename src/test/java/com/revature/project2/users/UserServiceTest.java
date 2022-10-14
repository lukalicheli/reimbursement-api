package com.revature.project2.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.revature.project2.common.exceptions.InvalidRequestException;
import com.revature.project2.common.exceptions.ResourceNotFoundException;
import com.revature.project2.common.exceptions.ResourcePersistenceException;

import java.util.ArrayList;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(userService.getAllUsers().isEmpty());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(1, userService.getAllUsers().size());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers3() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(2, userService.getAllUsers().size());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers4() {
        when(userRepository.findAll()).thenThrow(new IllegalArgumentException());
        assertThrows(IllegalArgumentException.class, () -> userService.getAllUsers());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsers5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:24)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsers(UserService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        userService.getAllUsers();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers6() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(false);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(1, userService.getAllUsers().size());
        verify(userRepository).findAll();
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers7() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(1, userService.getAllUsers().size());
        verify(userRepository).findAll();
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
        verify(role1).getName();
        verify(role1).setId(anyInt());
        verify(role1).setName((String) any());
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsers8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:18)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsers(UserService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(null);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        userService.getAllUsers();
    }

    /**
     * Method under test: {@link UserService#getUserById(String)}
     */
    @Test
    void testGetUserById() {
        assertThrows(InvalidRequestException.class, () -> userService.getUserById("42"));
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    void testGetUserByUsername() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualUserByUsername = userService.getUserByUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserByUsername.getEmail());
        assertEquals("janedoe", actualUserByUsername.getUsername());
        assertEquals("Doe", actualUserByUsername.getSurname());
        assertEquals("Name", actualUserByUsername.getRole());
        assertTrue(actualUserByUsername.getIsActive());
        assertEquals("Given Name", actualUserByUsername.getGivenName());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    void testGetUserByUsername2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> userService.getUserByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserByUsername3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.InvalidRequestException: An error occurred
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:24)
        //       at java.util.Optional.map(Optional.java:265)
        //       at com.revature.project2.users.UserService.getUserByUsername(UserService.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new InvalidRequestException("An error occurred"));
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        userService.getUserByUsername("janedoe");
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    void testGetUserByUsername4() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(false);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualUserByUsername = userService.getUserByUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserByUsername.getEmail());
        assertEquals("janedoe", actualUserByUsername.getUsername());
        assertEquals("Doe", actualUserByUsername.getSurname());
        assertEquals("Name", actualUserByUsername.getRole());
        assertFalse(actualUserByUsername.getIsActive());
        assertEquals("Given Name", actualUserByUsername.getGivenName());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    void testGetUserByUsername5() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualUserByUsername = userService.getUserByUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserByUsername.getEmail());
        assertEquals("janedoe", actualUserByUsername.getUsername());
        assertEquals("Doe", actualUserByUsername.getSurname());
        assertEquals("Name", actualUserByUsername.getRole());
        assertTrue(actualUserByUsername.getIsActive());
        assertEquals("Given Name", actualUserByUsername.getGivenName());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
        verify(role1).getName();
        verify(role1).setId(anyInt());
        verify(role1).setName((String) any());
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserByUsername6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at java.util.Optional.orElseThrow(Optional.java:408)
        //       at com.revature.project2.users.UserService.getUserByUsername(UserService.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        userService.getUserByUsername("janedoe");
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister() {
        assertThrows(InvalidRequestException.class, () -> userService.register(new NewUserRequest()));
        assertThrows(InvalidRequestException.class, () -> userService.register(null));
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(ResourcePersistenceException.class, () -> userService.register(newUserRequest));
        verify(userRepository).existsByEmail((String) any());
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getPassword();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest, atLeast(1)).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister3() {
        when(userRepository.existsByEmail((String) any())).thenThrow(new ResourceNotFoundException());
        when(userRepository.existsByUsername((String) any())).thenThrow(new ResourceNotFoundException());
        when(userRepository.save((User) any())).thenThrow(new ResourceNotFoundException());
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(ResourceNotFoundException.class, () -> userService.register(newUserRequest));
        verify(userRepository).existsByEmail((String) any());
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getPassword();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest, atLeast(1)).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister4() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(ResourcePersistenceException.class, () -> userService.register(newUserRequest));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).existsByUsername((String) any());
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getPassword();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest, atLeast(1)).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister5() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("foo");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getPassword();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest, atLeast(1)).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister6() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("foo");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest, atLeast(1)).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister7() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getSurname();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister8() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getSurname();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister9() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getGivenName();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister10() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.existsByUsername((String) any())).thenReturn(false);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        userService.register(newUserRequest);
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).existsByUsername((String) any());
        verify(userRepository).save((User) any());
        verify(newUserRequest).extractEntity();
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getPassword();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest, atLeast(1)).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister11() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn(null);
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest).getPassword();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest, atLeast(1)).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister12() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn(null);
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getSurname();
        verify(newUserRequest).getUsername();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister13() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn(null);
        when(newUserRequest.getSurname()).thenReturn("Doe");
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest).getEmail();
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest, atLeast(1)).getSurname();
    }

    /**
     * Method under test: {@link UserService#register(NewUserRequest)}
     */
    @Test
    void testRegister14() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        when(userRepository.save((User) any())).thenReturn(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user1);
        when(newUserRequest.getPassword()).thenReturn("iloveyou");
        when(newUserRequest.getUsername()).thenReturn("janedoe");
        when(newUserRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(newUserRequest.getSurname()).thenReturn(null);
        when(newUserRequest.getGivenName()).thenReturn("Given Name");
        assertThrows(InvalidRequestException.class, () -> userService.register(newUserRequest));
        verify(newUserRequest, atLeast(1)).getGivenName();
        verify(newUserRequest).getSurname();
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    void testActivateUser() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.activateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualActivateUserResult = userService.activateUser("janedoe");
        assertEquals("jane.doe@example.org", actualActivateUserResult.getEmail());
        assertEquals("janedoe", actualActivateUserResult.getUsername());
        assertEquals("Doe", actualActivateUserResult.getSurname());
        assertEquals("Name", actualActivateUserResult.getRole());
        assertTrue(actualActivateUserResult.getIsActive());
        assertEquals("Given Name", actualActivateUserResult.getGivenName());
        verify(userRepository).activateUser((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    void testActivateUser2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.activateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> userService.activateUser("janedoe"));
        verify(userRepository).activateUser((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testActivateUser3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.InvalidRequestException: An error occurred
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:24)
        //       at com.revature.project2.users.UserService.activateUser(UserService.java:95)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new InvalidRequestException("An error occurred"));
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.activateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        userService.activateUser("janedoe");
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    void testActivateUser4() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(false);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.activateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualActivateUserResult = userService.activateUser("janedoe");
        assertEquals("jane.doe@example.org", actualActivateUserResult.getEmail());
        assertEquals("janedoe", actualActivateUserResult.getUsername());
        assertEquals("Doe", actualActivateUserResult.getSurname());
        assertEquals("Name", actualActivateUserResult.getRole());
        assertFalse(actualActivateUserResult.getIsActive());
        assertEquals("Given Name", actualActivateUserResult.getGivenName());
        verify(userRepository).activateUser((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    void testActivateUser5() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.activateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualActivateUserResult = userService.activateUser("janedoe");
        assertEquals("jane.doe@example.org", actualActivateUserResult.getEmail());
        assertEquals("janedoe", actualActivateUserResult.getUsername());
        assertEquals("Doe", actualActivateUserResult.getSurname());
        assertEquals("Name", actualActivateUserResult.getRole());
        assertTrue(actualActivateUserResult.getIsActive());
        assertEquals("Given Name", actualActivateUserResult.getGivenName());
        verify(userRepository).activateUser((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
        verify(role1).getName();
        verify(role1).setId(anyInt());
        verify(role1).setName((String) any());
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testActivateUser6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:18)
        //       at com.revature.project2.users.UserService.activateUser(UserService.java:95)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(null);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.activateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        userService.activateUser("janedoe");
    }

    /**
     * Method under test: {@link UserService#activateUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testActivateUser7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:18)
        //       at com.revature.project2.users.UserService.activateUser(UserService.java:95)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.activateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        userService.activateUser("janedoe");
    }

    /**
     * Method under test: {@link UserService#deactivateUser(String)}
     */
    @Test
    void testDeactivateUser() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.deactivateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualDeactivateUserResult = userService.deactivateUser("janedoe");
        assertEquals("jane.doe@example.org", actualDeactivateUserResult.getEmail());
        assertEquals("janedoe", actualDeactivateUserResult.getUsername());
        assertEquals("Doe", actualDeactivateUserResult.getSurname());
        assertEquals("Name", actualDeactivateUserResult.getRole());
        assertTrue(actualDeactivateUserResult.getIsActive());
        assertEquals("Given Name", actualDeactivateUserResult.getGivenName());
        verify(userRepository).deactivateUser((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#deactivateUser(String)}
     */
    @Test
    void testDeactivateUser2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.deactivateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> userService.deactivateUser("janedoe"));
        verify(userRepository).deactivateUser((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#deactivateUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeactivateUser3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.InvalidRequestException: An error occurred
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:24)
        //       at com.revature.project2.users.UserService.deactivateUser(UserService.java:108)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new InvalidRequestException("An error occurred"));
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.deactivateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        userService.deactivateUser("janedoe");
    }

    /**
     * Method under test: {@link UserService#deactivateUser(String)}
     */
    @Test
    void testDeactivateUser4() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(false);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.deactivateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualDeactivateUserResult = userService.deactivateUser("janedoe");
        assertEquals("jane.doe@example.org", actualDeactivateUserResult.getEmail());
        assertEquals("janedoe", actualDeactivateUserResult.getUsername());
        assertEquals("Doe", actualDeactivateUserResult.getSurname());
        assertEquals("Name", actualDeactivateUserResult.getRole());
        assertFalse(actualDeactivateUserResult.getIsActive());
        assertEquals("Given Name", actualDeactivateUserResult.getGivenName());
        verify(userRepository).deactivateUser((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#deactivateUser(String)}
     */
    @Test
    void testDeactivateUser5() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.deactivateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse actualDeactivateUserResult = userService.deactivateUser("janedoe");
        assertEquals("jane.doe@example.org", actualDeactivateUserResult.getEmail());
        assertEquals("janedoe", actualDeactivateUserResult.getUsername());
        assertEquals("Doe", actualDeactivateUserResult.getSurname());
        assertEquals("Name", actualDeactivateUserResult.getRole());
        assertTrue(actualDeactivateUserResult.getIsActive());
        assertEquals("Given Name", actualDeactivateUserResult.getGivenName());
        verify(userRepository).deactivateUser((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
        verify(role1).getName();
        verify(role1).setId(anyInt());
        verify(role1).setName((String) any());
    }

    /**
     * Method under test: {@link UserService#deactivateUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeactivateUser6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:18)
        //       at com.revature.project2.users.UserService.deactivateUser(UserService.java:108)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(null);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.deactivateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        userService.deactivateUser("janedoe");
    }

    /**
     * Method under test: {@link UserService#deactivateUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeactivateUser7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:18)
        //       at com.revature.project2.users.UserService.deactivateUser(UserService.java:108)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.deactivateUser((String) any())).thenReturn(1);
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        userService.deactivateUser("janedoe");
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");
        UserResponse actualUpdateUserRoleResult = userService.updateUserRole("janedoe", role2);
        assertEquals("jane.doe@example.org", actualUpdateUserRoleResult.getEmail());
        assertEquals("janedoe", actualUpdateUserRoleResult.getUsername());
        assertEquals("Doe", actualUpdateUserRoleResult.getSurname());
        assertEquals("Name", actualUpdateUserRoleResult.getRole());
        assertTrue(actualUpdateUserRoleResult.getIsActive());
        assertEquals("Given Name", actualUpdateUserRoleResult.getGivenName());
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.save((User) any())).thenThrow(new IllegalArgumentException());
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        assertThrows(InvalidRequestException.class, () -> userService.updateUserRole("janedoe", role1));
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole3() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.save((User) any())).thenThrow(new InvalidRequestException("An error occurred"));
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        assertThrows(InvalidRequestException.class, () -> userService.updateUserRole("janedoe", role1));
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole4() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role2);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        assertThrows(InvalidRequestException.class, () -> userService.updateUserRole("janedoe", role3));
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user, atLeast(1)).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserRole5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.InvalidRequestException: An error occurred
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:24)
        //       at com.revature.project2.users.UserService.updateUserRole(UserService.java:138)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new InvalidRequestException("An error occurred"));
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role2);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        userService.updateUserRole("janedoe", role3);
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole6() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(false);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role2);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        UserResponse actualUpdateUserRoleResult = userService.updateUserRole("janedoe", role3);
        assertEquals("jane.doe@example.org", actualUpdateUserRoleResult.getEmail());
        assertEquals("janedoe", actualUpdateUserRoleResult.getUsername());
        assertEquals("Doe", actualUpdateUserRoleResult.getSurname());
        assertEquals("Name", actualUpdateUserRoleResult.getRole());
        assertFalse(actualUpdateUserRoleResult.getIsActive());
        assertEquals("Given Name", actualUpdateUserRoleResult.getGivenName());
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user, atLeast(1)).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole7() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role2);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        UserResponse actualUpdateUserRoleResult = userService.updateUserRole("janedoe", role3);
        assertEquals("jane.doe@example.org", actualUpdateUserRoleResult.getEmail());
        assertEquals("janedoe", actualUpdateUserRoleResult.getUsername());
        assertEquals("Doe", actualUpdateUserRoleResult.getSurname());
        assertEquals("Name", actualUpdateUserRoleResult.getRole());
        assertTrue(actualUpdateUserRoleResult.getIsActive());
        assertEquals("Given Name", actualUpdateUserRoleResult.getGivenName());
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user, atLeast(1)).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
        verify(role1).getName();
        verify(role1).setId(anyInt());
        verify(role1).setName((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserRole8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:18)
        //       at com.revature.project2.users.UserService.updateUserRole(UserService.java:138)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(null);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role2);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        userService.updateUserRole("janedoe", role3);
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserRole9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserService.updateUserRole(UserService.java:128)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByUsername((String) any())).thenReturn(null);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        Role role2 = mock(Role.class);
        when(role2.getName()).thenReturn("Name");
        doNothing().when(role2).setId(anyInt());
        doNothing().when(role2).setName((String) any());
        role2.setId(1);
        role2.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role2);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user1).setActive(anyBoolean());
        doNothing().when(user1).setEmail((String) any());
        doNothing().when(user1).setGivenName((String) any());
        doNothing().when(user1).setPassword((String) any());
        doNothing().when(user1).setRole((Role) any());
        doNothing().when(user1).setSurname((String) any());
        doNothing().when(user1).setUserId((UUID) any());
        doNothing().when(user1).setUsername((String) any());
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        userService.updateUserRole("janedoe", role3);
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole10() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        Role role2 = mock(Role.class);
        when(role2.getName()).thenReturn("Name");
        doNothing().when(role2).setId(anyInt());
        doNothing().when(role2).setName((String) any());
        role2.setId(1);
        role2.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role2);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user1).setActive(anyBoolean());
        doNothing().when(user1).setEmail((String) any());
        doNothing().when(user1).setGivenName((String) any());
        doNothing().when(user1).setPassword((String) any());
        doNothing().when(user1).setRole((Role) any());
        doNothing().when(user1).setSurname((String) any());
        doNothing().when(user1).setUserId((UUID) any());
        doNothing().when(user1).setUsername((String) any());
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role1);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        assertThrows(InvalidRequestException.class, () -> userService.updateUserRole("janedoe", role3));
        verify(userRepository).findByUsername((String) any());
        verify(user1).setActive(anyBoolean());
        verify(user1).setEmail((String) any());
        verify(user1).setGivenName((String) any());
        verify(user1).setPassword((String) any());
        verify(user1).setRole((Role) any());
        verify(user1).setSurname((String) any());
        verify(user1).setUserId((UUID) any());
        verify(user1).setUsername((String) any());
        verify(role2).setId(anyInt());
        verify(role2).setName((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole11() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role2);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        assertThrows(InvalidRequestException.class, () -> userService.updateUserRole(null, role3));
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
        verify(role1).setId(anyInt());
        verify(role1).setName((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole12() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Role role1 = mock(Role.class);
        when(role1.getName()).thenReturn("Name");
        doNothing().when(role1).setId(anyInt());
        doNothing().when(role1).setName((String) any());
        role1.setId(1);
        role1.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role1);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setSurname((String) any());
        doNothing().when(user).setUserId((UUID) any());
        doNothing().when(user).setUsername((String) any());
        user.setActive(true);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        User user1 = new User();
        user1.setActive(true);
        user1.setEmail("jane.doe@example.org");
        user1.setGivenName("Given Name");
        user1.setPassword("iloveyou");
        user1.setRole(role2);
        user1.setSurname("Doe");
        user1.setUserId(UUID.randomUUID());
        user1.setUsername("janedoe");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        Role role3 = mock(Role.class);
        doNothing().when(role3).setId(anyInt());
        doNothing().when(role3).setName((String) any());
        role3.setId(1);
        role3.setName("Name");
        UserResponse actualUpdateUserRoleResult = userService.updateUserRole("janedoe", role3);
        assertEquals("jane.doe@example.org", actualUpdateUserRoleResult.getEmail());
        assertEquals("janedoe", actualUpdateUserRoleResult.getUsername());
        assertEquals("Doe", actualUpdateUserRoleResult.getSurname());
        assertEquals("Name", actualUpdateUserRoleResult.getRole());
        assertTrue(actualUpdateUserRoleResult.getIsActive());
        assertEquals("Given Name", actualUpdateUserRoleResult.getGivenName());
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user, atLeast(1)).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(user).setUserId((UUID) any());
        verify(user).setUsername((String) any());
        verify(role1).getName();
        verify(role1).setId(anyInt());
        verify(role1).setName((String) any());
        verify(role3).setId(anyInt());
        verify(role3).setName((String) any());
    }
}

