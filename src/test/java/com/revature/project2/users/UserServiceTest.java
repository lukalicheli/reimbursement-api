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
import static org.mockito.Mockito.doThrow;
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
    private RoleRepo roleRepo;

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
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());

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
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsers3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:30)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsers(UserService.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        userService.getAllUsers();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers4() {
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

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role1);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(2, userService.getAllUsers().size());
        verify(userRepository).findAll();
        verify(user1).getActive();
        verify(user1).getRole();
        verify(user1).getEmail();
        verify(user1).getGivenName();
        verify(user1).getSurname();
        verify(user1).getUsername();
        verify(user1).getUserId();
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
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
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:25)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsers(UserService.java:32)
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

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role1);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");
        User user2 = mock(User.class);
        when(user2.getActive()).thenReturn(true);
        when(user2.getRole()).thenReturn(role2);
        when(user2.getEmail()).thenReturn("jane.doe@example.org");
        when(user2.getGivenName()).thenReturn("Given Name");
        when(user2.getSurname()).thenReturn("Doe");
        when(user2.getUsername()).thenReturn("janedoe");
        when(user2.getUserId()).thenReturn(UUID.randomUUID());

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        User user3 = mock(User.class);
        when(user3.getActive()).thenReturn(true);
        when(user3.getRole()).thenReturn(role3);
        when(user3.getEmail()).thenReturn("jane.doe@example.org");
        when(user3.getGivenName()).thenReturn("Given Name");
        when(user3.getSurname()).thenReturn("Doe");
        when(user3.getUsername()).thenReturn("janedoe");
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Role role4 = new Role();
        role4.setId(1);
        role4.setName("Name");
        User user4 = mock(User.class);
        when(user4.getActive()).thenReturn(true);
        when(user4.getRole()).thenReturn(role4);
        when(user4.getEmail()).thenReturn("jane.doe@example.org");
        when(user4.getGivenName()).thenReturn("Given Name");
        when(user4.getSurname()).thenReturn("Doe");
        when(user4.getUsername()).thenReturn("janedoe");
        when(user4.getUserId()).thenReturn(UUID.randomUUID());

        Role role5 = new Role();
        role5.setId(1);
        role5.setName("Name");
        User user5 = mock(User.class);
        when(user5.getActive()).thenReturn(true);
        when(user5.getRole()).thenReturn(role5);
        when(user5.getEmail()).thenReturn("jane.doe@example.org");
        when(user5.getGivenName()).thenReturn("Given Name");
        when(user5.getSurname()).thenReturn("Doe");
        when(user5.getUsername()).thenReturn("janedoe");
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Role role6 = new Role();
        role6.setId(1);
        role6.setName("Name");
        User user6 = mock(User.class);
        when(user6.getActive()).thenReturn(true);
        when(user6.getRole()).thenReturn(role6);
        when(user6.getEmail()).thenReturn("jane.doe@example.org");
        when(user6.getGivenName()).thenReturn("Given Name");
        when(user6.getSurname()).thenReturn("Doe");
        when(user6.getUsername()).thenReturn("janedoe");
        when(user6.getUserId()).thenReturn(UUID.randomUUID());

        Role role7 = new Role();
        role7.setId(1);
        role7.setName("Name");
        User user7 = mock(User.class);
        when(user7.getActive()).thenReturn(true);
        when(user7.getRole()).thenReturn(role7);
        when(user7.getEmail()).thenReturn("jane.doe@example.org");
        when(user7.getGivenName()).thenReturn("Given Name");
        when(user7.getSurname()).thenReturn("Doe");
        when(user7.getUsername()).thenReturn("janedoe");
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Role role8 = new Role();
        role8.setId(1);
        role8.setName("Name");
        User user8 = mock(User.class);
        when(user8.getActive()).thenReturn(true);
        when(user8.getRole()).thenReturn(role8);
        when(user8.getEmail()).thenReturn("jane.doe@example.org");
        when(user8.getGivenName()).thenReturn("Given Name");
        when(user8.getSurname()).thenReturn("Doe");
        when(user8.getUsername()).thenReturn("janedoe");
        when(user8.getUserId()).thenReturn(UUID.randomUUID());

        Role role9 = new Role();
        role9.setId(1);
        role9.setName("Name");
        User user9 = mock(User.class);
        when(user9.getActive()).thenReturn(true);
        when(user9.getRole()).thenReturn(role9);
        when(user9.getEmail()).thenReturn("jane.doe@example.org");
        when(user9.getGivenName()).thenReturn("Given Name");
        when(user9.getSurname()).thenReturn("Doe");
        when(user9.getUsername()).thenReturn("janedoe");
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Role role10 = new Role();
        role10.setId(1);
        role10.setName("Name");
        User user10 = mock(User.class);
        when(user10.getActive()).thenReturn(true);
        when(user10.getRole()).thenReturn(role10);
        when(user10.getEmail()).thenReturn("jane.doe@example.org");
        when(user10.getGivenName()).thenReturn("Given Name");
        when(user10.getSurname()).thenReturn("Doe");
        when(user10.getUsername()).thenReturn("janedoe");
        when(user10.getUserId()).thenReturn(UUID.randomUUID());

        Role role11 = new Role();
        role11.setId(1);
        role11.setName("Name");
        User user11 = mock(User.class);
        when(user11.getActive()).thenReturn(true);
        when(user11.getRole()).thenReturn(role11);
        when(user11.getEmail()).thenReturn("jane.doe@example.org");
        when(user11.getGivenName()).thenReturn("Given Name");
        when(user11.getSurname()).thenReturn("Doe");
        when(user11.getUsername()).thenReturn("janedoe");
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Role role12 = new Role();
        role12.setId(1);
        role12.setName("Name");
        User user12 = mock(User.class);
        when(user12.getActive()).thenReturn(true);
        when(user12.getRole()).thenReturn(role12);
        when(user12.getEmail()).thenReturn("jane.doe@example.org");
        when(user12.getGivenName()).thenReturn("Given Name");
        when(user12.getSurname()).thenReturn("Doe");
        when(user12.getUsername()).thenReturn("janedoe");
        when(user12.getUserId()).thenReturn(UUID.randomUUID());

        Role role13 = new Role();
        role13.setId(1);
        role13.setName("Name");
        User user13 = mock(User.class);
        when(user13.getActive()).thenReturn(true);
        when(user13.getRole()).thenReturn(role13);
        when(user13.getEmail()).thenReturn("jane.doe@example.org");
        when(user13.getGivenName()).thenReturn("Given Name");
        when(user13.getSurname()).thenReturn("Doe");
        when(user13.getUsername()).thenReturn("janedoe");
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Role role14 = new Role();
        role14.setId(1);
        role14.setName("Name");
        User user14 = mock(User.class);
        when(user14.getActive()).thenReturn(true);
        when(user14.getRole()).thenReturn(role14);
        when(user14.getEmail()).thenReturn("jane.doe@example.org");
        when(user14.getGivenName()).thenReturn("Given Name");
        when(user14.getSurname()).thenReturn("Doe");
        when(user14.getUsername()).thenReturn("janedoe");
        when(user14.getUserId()).thenReturn(UUID.randomUUID());

        Role role15 = new Role();
        role15.setId(1);
        role15.setName("Name");
        User user15 = mock(User.class);
        when(user15.getActive()).thenReturn(true);
        when(user15.getRole()).thenReturn(role15);
        when(user15.getEmail()).thenReturn("jane.doe@example.org");
        when(user15.getGivenName()).thenReturn("Given Name");
        when(user15.getSurname()).thenReturn("Doe");
        when(user15.getUsername()).thenReturn("janedoe");
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Role role16 = new Role();
        role16.setId(1);
        role16.setName("Name");
        User user16 = mock(User.class);
        when(user16.getActive()).thenReturn(true);
        when(user16.getRole()).thenReturn(role16);
        when(user16.getEmail()).thenReturn("jane.doe@example.org");
        when(user16.getGivenName()).thenReturn("Given Name");
        when(user16.getSurname()).thenReturn("Doe");
        when(user16.getUsername()).thenReturn("janedoe");
        when(user16.getUserId()).thenReturn(UUID.randomUUID());

        Role role17 = new Role();
        role17.setId(1);
        role17.setName("Name");
        User user17 = mock(User.class);
        when(user17.getActive()).thenReturn(true);
        when(user17.getRole()).thenReturn(role17);
        when(user17.getEmail()).thenReturn("jane.doe@example.org");
        when(user17.getGivenName()).thenReturn("Given Name");
        when(user17.getSurname()).thenReturn("Doe");
        when(user17.getUsername()).thenReturn("janedoe");
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Role role18 = new Role();
        role18.setId(1);
        role18.setName("Name");
        User user18 = mock(User.class);
        when(user18.getActive()).thenReturn(true);
        when(user18.getRole()).thenReturn(role18);
        when(user18.getEmail()).thenReturn("jane.doe@example.org");
        when(user18.getGivenName()).thenReturn("Given Name");
        when(user18.getSurname()).thenReturn("Doe");
        when(user18.getUsername()).thenReturn("janedoe");
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getRole()).thenThrow(new ResourceNotFoundException());
        when(user19.getEmail()).thenThrow(new ResourceNotFoundException());
        when(user19.getGivenName()).thenThrow(new ResourceNotFoundException());
        when(user19.getSurname()).thenThrow(new ResourceNotFoundException());
        when(user19.getUsername()).thenThrow(new ResourceNotFoundException());
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user19);
        userList.add(user18);
        userList.add(user17);
        userList.add(user16);
        userList.add(user15);
        userList.add(user14);
        userList.add(user13);
        userList.add(user12);
        userList.add(user11);
        userList.add(user10);
        userList.add(user9);
        userList.add(user8);
        userList.add(user7);
        userList.add(user6);
        userList.add(user5);
        userList.add(user4);
        userList.add(user3);
        userList.add(user2);
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        userService.getAllUsers();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsers6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:24)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsers(UserService.java:32)
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

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role1);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");
        User user2 = mock(User.class);
        when(user2.getActive()).thenReturn(true);
        when(user2.getRole()).thenReturn(role2);
        when(user2.getEmail()).thenReturn("jane.doe@example.org");
        when(user2.getGivenName()).thenReturn("Given Name");
        when(user2.getSurname()).thenReturn("Doe");
        when(user2.getUsername()).thenReturn("janedoe");
        when(user2.getUserId()).thenReturn(UUID.randomUUID());

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        User user3 = mock(User.class);
        when(user3.getActive()).thenReturn(true);
        when(user3.getRole()).thenReturn(role3);
        when(user3.getEmail()).thenReturn("jane.doe@example.org");
        when(user3.getGivenName()).thenReturn("Given Name");
        when(user3.getSurname()).thenReturn("Doe");
        when(user3.getUsername()).thenReturn("janedoe");
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Role role4 = new Role();
        role4.setId(1);
        role4.setName("Name");
        User user4 = mock(User.class);
        when(user4.getActive()).thenReturn(true);
        when(user4.getRole()).thenReturn(role4);
        when(user4.getEmail()).thenReturn("jane.doe@example.org");
        when(user4.getGivenName()).thenReturn("Given Name");
        when(user4.getSurname()).thenReturn("Doe");
        when(user4.getUsername()).thenReturn("janedoe");
        when(user4.getUserId()).thenReturn(UUID.randomUUID());

        Role role5 = new Role();
        role5.setId(1);
        role5.setName("Name");
        User user5 = mock(User.class);
        when(user5.getActive()).thenReturn(true);
        when(user5.getRole()).thenReturn(role5);
        when(user5.getEmail()).thenReturn("jane.doe@example.org");
        when(user5.getGivenName()).thenReturn("Given Name");
        when(user5.getSurname()).thenReturn("Doe");
        when(user5.getUsername()).thenReturn("janedoe");
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Role role6 = new Role();
        role6.setId(1);
        role6.setName("Name");
        User user6 = mock(User.class);
        when(user6.getActive()).thenReturn(true);
        when(user6.getRole()).thenReturn(role6);
        when(user6.getEmail()).thenReturn("jane.doe@example.org");
        when(user6.getGivenName()).thenReturn("Given Name");
        when(user6.getSurname()).thenReturn("Doe");
        when(user6.getUsername()).thenReturn("janedoe");
        when(user6.getUserId()).thenReturn(UUID.randomUUID());

        Role role7 = new Role();
        role7.setId(1);
        role7.setName("Name");
        User user7 = mock(User.class);
        when(user7.getActive()).thenReturn(true);
        when(user7.getRole()).thenReturn(role7);
        when(user7.getEmail()).thenReturn("jane.doe@example.org");
        when(user7.getGivenName()).thenReturn("Given Name");
        when(user7.getSurname()).thenReturn("Doe");
        when(user7.getUsername()).thenReturn("janedoe");
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Role role8 = new Role();
        role8.setId(1);
        role8.setName("Name");
        User user8 = mock(User.class);
        when(user8.getActive()).thenReturn(true);
        when(user8.getRole()).thenReturn(role8);
        when(user8.getEmail()).thenReturn("jane.doe@example.org");
        when(user8.getGivenName()).thenReturn("Given Name");
        when(user8.getSurname()).thenReturn("Doe");
        when(user8.getUsername()).thenReturn("janedoe");
        when(user8.getUserId()).thenReturn(UUID.randomUUID());

        Role role9 = new Role();
        role9.setId(1);
        role9.setName("Name");
        User user9 = mock(User.class);
        when(user9.getActive()).thenReturn(true);
        when(user9.getRole()).thenReturn(role9);
        when(user9.getEmail()).thenReturn("jane.doe@example.org");
        when(user9.getGivenName()).thenReturn("Given Name");
        when(user9.getSurname()).thenReturn("Doe");
        when(user9.getUsername()).thenReturn("janedoe");
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Role role10 = new Role();
        role10.setId(1);
        role10.setName("Name");
        User user10 = mock(User.class);
        when(user10.getActive()).thenReturn(true);
        when(user10.getRole()).thenReturn(role10);
        when(user10.getEmail()).thenReturn("jane.doe@example.org");
        when(user10.getGivenName()).thenReturn("Given Name");
        when(user10.getSurname()).thenReturn("Doe");
        when(user10.getUsername()).thenReturn("janedoe");
        when(user10.getUserId()).thenReturn(UUID.randomUUID());

        Role role11 = new Role();
        role11.setId(1);
        role11.setName("Name");
        User user11 = mock(User.class);
        when(user11.getActive()).thenReturn(true);
        when(user11.getRole()).thenReturn(role11);
        when(user11.getEmail()).thenReturn("jane.doe@example.org");
        when(user11.getGivenName()).thenReturn("Given Name");
        when(user11.getSurname()).thenReturn("Doe");
        when(user11.getUsername()).thenReturn("janedoe");
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Role role12 = new Role();
        role12.setId(1);
        role12.setName("Name");
        User user12 = mock(User.class);
        when(user12.getActive()).thenReturn(true);
        when(user12.getRole()).thenReturn(role12);
        when(user12.getEmail()).thenReturn("jane.doe@example.org");
        when(user12.getGivenName()).thenReturn("Given Name");
        when(user12.getSurname()).thenReturn("Doe");
        when(user12.getUsername()).thenReturn("janedoe");
        when(user12.getUserId()).thenReturn(UUID.randomUUID());

        Role role13 = new Role();
        role13.setId(1);
        role13.setName("Name");
        User user13 = mock(User.class);
        when(user13.getActive()).thenReturn(true);
        when(user13.getRole()).thenReturn(role13);
        when(user13.getEmail()).thenReturn("jane.doe@example.org");
        when(user13.getGivenName()).thenReturn("Given Name");
        when(user13.getSurname()).thenReturn("Doe");
        when(user13.getUsername()).thenReturn("janedoe");
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Role role14 = new Role();
        role14.setId(1);
        role14.setName("Name");
        User user14 = mock(User.class);
        when(user14.getActive()).thenReturn(true);
        when(user14.getRole()).thenReturn(role14);
        when(user14.getEmail()).thenReturn("jane.doe@example.org");
        when(user14.getGivenName()).thenReturn("Given Name");
        when(user14.getSurname()).thenReturn("Doe");
        when(user14.getUsername()).thenReturn("janedoe");
        when(user14.getUserId()).thenReturn(UUID.randomUUID());

        Role role15 = new Role();
        role15.setId(1);
        role15.setName("Name");
        User user15 = mock(User.class);
        when(user15.getActive()).thenReturn(true);
        when(user15.getRole()).thenReturn(role15);
        when(user15.getEmail()).thenReturn("jane.doe@example.org");
        when(user15.getGivenName()).thenReturn("Given Name");
        when(user15.getSurname()).thenReturn("Doe");
        when(user15.getUsername()).thenReturn("janedoe");
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Role role16 = new Role();
        role16.setId(1);
        role16.setName("Name");
        User user16 = mock(User.class);
        when(user16.getActive()).thenReturn(true);
        when(user16.getRole()).thenReturn(role16);
        when(user16.getEmail()).thenReturn("jane.doe@example.org");
        when(user16.getGivenName()).thenReturn("Given Name");
        when(user16.getSurname()).thenReturn("Doe");
        when(user16.getUsername()).thenReturn("janedoe");
        when(user16.getUserId()).thenReturn(UUID.randomUUID());

        Role role17 = new Role();
        role17.setId(1);
        role17.setName("Name");
        User user17 = mock(User.class);
        when(user17.getActive()).thenReturn(true);
        when(user17.getRole()).thenReturn(role17);
        when(user17.getEmail()).thenReturn("jane.doe@example.org");
        when(user17.getGivenName()).thenReturn("Given Name");
        when(user17.getSurname()).thenReturn("Doe");
        when(user17.getUsername()).thenReturn("janedoe");
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Role role18 = new Role();
        role18.setId(1);
        role18.setName("Name");
        User user18 = mock(User.class);
        when(user18.getActive()).thenReturn(true);
        when(user18.getRole()).thenReturn(role18);
        when(user18.getEmail()).thenReturn("jane.doe@example.org");
        when(user18.getGivenName()).thenReturn("Given Name");
        when(user18.getSurname()).thenReturn("Doe");
        when(user18.getUsername()).thenReturn("janedoe");
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getRole()).thenThrow(new ResourceNotFoundException());
        when(user19.getEmail()).thenThrow(new ResourceNotFoundException());
        when(user19.getGivenName()).thenThrow(new ResourceNotFoundException());
        when(user19.getSurname()).thenThrow(new ResourceNotFoundException());
        when(user19.getUsername()).thenThrow(new ResourceNotFoundException());
        when(user19.getUserId()).thenReturn(null);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user19);
        userList.add(user18);
        userList.add(user17);
        userList.add(user16);
        userList.add(user15);
        userList.add(user14);
        userList.add(user13);
        userList.add(user12);
        userList.add(user11);
        userList.add(user10);
        userList.add(user9);
        userList.add(user8);
        userList.add(user7);
        userList.add(user6);
        userList.add(user5);
        userList.add(user4);
        userList.add(user3);
        userList.add(user2);
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        userService.getAllUsers();
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByActiveStatus(boolean)}
     */
    @Test
    void testGetAllUsersFilterByActiveStatus() {
        when(userRepository.findAllByIsActive(anyBoolean())).thenReturn(new ArrayList<>());
        assertTrue(userService.getAllUsersFilterByActiveStatus(true).isEmpty());
        verify(userRepository).findAllByIsActive(anyBoolean());
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByActiveStatus(boolean)}
     */
    @Test
    void testGetAllUsersFilterByActiveStatus2() {
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

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAllByIsActive(anyBoolean())).thenReturn(userList);
        assertEquals(1, userService.getAllUsersFilterByActiveStatus(true).size());
        verify(userRepository).findAllByIsActive(anyBoolean());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByActiveStatus(boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsersFilterByActiveStatus3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:30)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsersFilterByActiveStatus(UserService.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAllByIsActive(anyBoolean())).thenReturn(userList);
        userService.getAllUsersFilterByActiveStatus(true);
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByActiveStatus(boolean)}
     */
    @Test
    void testGetAllUsersFilterByActiveStatus4() {
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

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role1);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAllByIsActive(anyBoolean())).thenReturn(userList);
        assertEquals(2, userService.getAllUsersFilterByActiveStatus(true).size());
        verify(userRepository).findAllByIsActive(anyBoolean());
        verify(user1).getActive();
        verify(user1).getRole();
        verify(user1).getEmail();
        verify(user1).getGivenName();
        verify(user1).getSurname();
        verify(user1).getUsername();
        verify(user1).getUserId();
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByActiveStatus(boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsersFilterByActiveStatus5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:25)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsersFilterByActiveStatus(UserService.java:39)
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

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role1);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");
        User user2 = mock(User.class);
        when(user2.getActive()).thenReturn(true);
        when(user2.getRole()).thenReturn(role2);
        when(user2.getEmail()).thenReturn("jane.doe@example.org");
        when(user2.getGivenName()).thenReturn("Given Name");
        when(user2.getSurname()).thenReturn("Doe");
        when(user2.getUsername()).thenReturn("janedoe");
        when(user2.getUserId()).thenReturn(UUID.randomUUID());

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        User user3 = mock(User.class);
        when(user3.getActive()).thenReturn(true);
        when(user3.getRole()).thenReturn(role3);
        when(user3.getEmail()).thenReturn("jane.doe@example.org");
        when(user3.getGivenName()).thenReturn("Given Name");
        when(user3.getSurname()).thenReturn("Doe");
        when(user3.getUsername()).thenReturn("janedoe");
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Role role4 = new Role();
        role4.setId(1);
        role4.setName("Name");
        User user4 = mock(User.class);
        when(user4.getActive()).thenReturn(true);
        when(user4.getRole()).thenReturn(role4);
        when(user4.getEmail()).thenReturn("jane.doe@example.org");
        when(user4.getGivenName()).thenReturn("Given Name");
        when(user4.getSurname()).thenReturn("Doe");
        when(user4.getUsername()).thenReturn("janedoe");
        when(user4.getUserId()).thenReturn(UUID.randomUUID());

        Role role5 = new Role();
        role5.setId(1);
        role5.setName("Name");
        User user5 = mock(User.class);
        when(user5.getActive()).thenReturn(true);
        when(user5.getRole()).thenReturn(role5);
        when(user5.getEmail()).thenReturn("jane.doe@example.org");
        when(user5.getGivenName()).thenReturn("Given Name");
        when(user5.getSurname()).thenReturn("Doe");
        when(user5.getUsername()).thenReturn("janedoe");
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Role role6 = new Role();
        role6.setId(1);
        role6.setName("Name");
        User user6 = mock(User.class);
        when(user6.getActive()).thenReturn(true);
        when(user6.getRole()).thenReturn(role6);
        when(user6.getEmail()).thenReturn("jane.doe@example.org");
        when(user6.getGivenName()).thenReturn("Given Name");
        when(user6.getSurname()).thenReturn("Doe");
        when(user6.getUsername()).thenReturn("janedoe");
        when(user6.getUserId()).thenReturn(UUID.randomUUID());

        Role role7 = new Role();
        role7.setId(1);
        role7.setName("Name");
        User user7 = mock(User.class);
        when(user7.getActive()).thenReturn(true);
        when(user7.getRole()).thenReturn(role7);
        when(user7.getEmail()).thenReturn("jane.doe@example.org");
        when(user7.getGivenName()).thenReturn("Given Name");
        when(user7.getSurname()).thenReturn("Doe");
        when(user7.getUsername()).thenReturn("janedoe");
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Role role8 = new Role();
        role8.setId(1);
        role8.setName("Name");
        User user8 = mock(User.class);
        when(user8.getActive()).thenReturn(true);
        when(user8.getRole()).thenReturn(role8);
        when(user8.getEmail()).thenReturn("jane.doe@example.org");
        when(user8.getGivenName()).thenReturn("Given Name");
        when(user8.getSurname()).thenReturn("Doe");
        when(user8.getUsername()).thenReturn("janedoe");
        when(user8.getUserId()).thenReturn(UUID.randomUUID());

        Role role9 = new Role();
        role9.setId(1);
        role9.setName("Name");
        User user9 = mock(User.class);
        when(user9.getActive()).thenReturn(true);
        when(user9.getRole()).thenReturn(role9);
        when(user9.getEmail()).thenReturn("jane.doe@example.org");
        when(user9.getGivenName()).thenReturn("Given Name");
        when(user9.getSurname()).thenReturn("Doe");
        when(user9.getUsername()).thenReturn("janedoe");
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Role role10 = new Role();
        role10.setId(1);
        role10.setName("Name");
        User user10 = mock(User.class);
        when(user10.getActive()).thenReturn(true);
        when(user10.getRole()).thenReturn(role10);
        when(user10.getEmail()).thenReturn("jane.doe@example.org");
        when(user10.getGivenName()).thenReturn("Given Name");
        when(user10.getSurname()).thenReturn("Doe");
        when(user10.getUsername()).thenReturn("janedoe");
        when(user10.getUserId()).thenReturn(UUID.randomUUID());

        Role role11 = new Role();
        role11.setId(1);
        role11.setName("Name");
        User user11 = mock(User.class);
        when(user11.getActive()).thenReturn(true);
        when(user11.getRole()).thenReturn(role11);
        when(user11.getEmail()).thenReturn("jane.doe@example.org");
        when(user11.getGivenName()).thenReturn("Given Name");
        when(user11.getSurname()).thenReturn("Doe");
        when(user11.getUsername()).thenReturn("janedoe");
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Role role12 = new Role();
        role12.setId(1);
        role12.setName("Name");
        User user12 = mock(User.class);
        when(user12.getActive()).thenReturn(true);
        when(user12.getRole()).thenReturn(role12);
        when(user12.getEmail()).thenReturn("jane.doe@example.org");
        when(user12.getGivenName()).thenReturn("Given Name");
        when(user12.getSurname()).thenReturn("Doe");
        when(user12.getUsername()).thenReturn("janedoe");
        when(user12.getUserId()).thenReturn(UUID.randomUUID());

        Role role13 = new Role();
        role13.setId(1);
        role13.setName("Name");
        User user13 = mock(User.class);
        when(user13.getActive()).thenReturn(true);
        when(user13.getRole()).thenReturn(role13);
        when(user13.getEmail()).thenReturn("jane.doe@example.org");
        when(user13.getGivenName()).thenReturn("Given Name");
        when(user13.getSurname()).thenReturn("Doe");
        when(user13.getUsername()).thenReturn("janedoe");
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Role role14 = new Role();
        role14.setId(1);
        role14.setName("Name");
        User user14 = mock(User.class);
        when(user14.getActive()).thenReturn(true);
        when(user14.getRole()).thenReturn(role14);
        when(user14.getEmail()).thenReturn("jane.doe@example.org");
        when(user14.getGivenName()).thenReturn("Given Name");
        when(user14.getSurname()).thenReturn("Doe");
        when(user14.getUsername()).thenReturn("janedoe");
        when(user14.getUserId()).thenReturn(UUID.randomUUID());

        Role role15 = new Role();
        role15.setId(1);
        role15.setName("Name");
        User user15 = mock(User.class);
        when(user15.getActive()).thenReturn(true);
        when(user15.getRole()).thenReturn(role15);
        when(user15.getEmail()).thenReturn("jane.doe@example.org");
        when(user15.getGivenName()).thenReturn("Given Name");
        when(user15.getSurname()).thenReturn("Doe");
        when(user15.getUsername()).thenReturn("janedoe");
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Role role16 = new Role();
        role16.setId(1);
        role16.setName("Name");
        User user16 = mock(User.class);
        when(user16.getActive()).thenReturn(true);
        when(user16.getRole()).thenReturn(role16);
        when(user16.getEmail()).thenReturn("jane.doe@example.org");
        when(user16.getGivenName()).thenReturn("Given Name");
        when(user16.getSurname()).thenReturn("Doe");
        when(user16.getUsername()).thenReturn("janedoe");
        when(user16.getUserId()).thenReturn(UUID.randomUUID());

        Role role17 = new Role();
        role17.setId(1);
        role17.setName("Name");
        User user17 = mock(User.class);
        when(user17.getActive()).thenReturn(true);
        when(user17.getRole()).thenReturn(role17);
        when(user17.getEmail()).thenReturn("jane.doe@example.org");
        when(user17.getGivenName()).thenReturn("Given Name");
        when(user17.getSurname()).thenReturn("Doe");
        when(user17.getUsername()).thenReturn("janedoe");
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Role role18 = new Role();
        role18.setId(1);
        role18.setName("Name");
        User user18 = mock(User.class);
        when(user18.getActive()).thenReturn(true);
        when(user18.getRole()).thenReturn(role18);
        when(user18.getEmail()).thenReturn("jane.doe@example.org");
        when(user18.getGivenName()).thenReturn("Given Name");
        when(user18.getSurname()).thenReturn("Doe");
        when(user18.getUsername()).thenReturn("janedoe");
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getRole()).thenThrow(new ResourceNotFoundException());
        when(user19.getEmail()).thenThrow(new ResourceNotFoundException());
        when(user19.getGivenName()).thenThrow(new ResourceNotFoundException());
        when(user19.getSurname()).thenThrow(new ResourceNotFoundException());
        when(user19.getUsername()).thenThrow(new ResourceNotFoundException());
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user19);
        userList.add(user18);
        userList.add(user17);
        userList.add(user16);
        userList.add(user15);
        userList.add(user14);
        userList.add(user13);
        userList.add(user12);
        userList.add(user11);
        userList.add(user10);
        userList.add(user9);
        userList.add(user8);
        userList.add(user7);
        userList.add(user6);
        userList.add(user5);
        userList.add(user4);
        userList.add(user3);
        userList.add(user2);
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAllByIsActive(anyBoolean())).thenReturn(userList);
        userService.getAllUsersFilterByActiveStatus(true);
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByRole(String)}
     */
    @Test
    void testGetAllUsersFilterByRole() {
        when(userRepository.findAllByRoleName((String) any())).thenReturn(new ArrayList<>());
        assertTrue(userService.getAllUsersFilterByRole("Select Role").isEmpty());
        verify(userRepository).findAllByRoleName((String) any());
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByRole(String)}
     */
    @Test
    void testGetAllUsersFilterByRole2() {
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

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAllByRoleName((String) any())).thenReturn(userList);
        assertEquals(1, userService.getAllUsersFilterByRole("Select Role").size());
        verify(userRepository).findAllByRoleName((String) any());
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByRole(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsersFilterByRole3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:30)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsersFilterByRole(UserService.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAllByRoleName((String) any())).thenReturn(userList);
        userService.getAllUsersFilterByRole("Select Role");
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByRole(String)}
     */
    @Test
    void testGetAllUsersFilterByRole4() {
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

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role1);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAllByRoleName((String) any())).thenReturn(userList);
        assertEquals(2, userService.getAllUsersFilterByRole("Select Role").size());
        verify(userRepository).findAllByRoleName((String) any());
        verify(user1).getActive();
        verify(user1).getRole();
        verify(user1).getEmail();
        verify(user1).getGivenName();
        verify(user1).getSurname();
        verify(user1).getUsername();
        verify(user1).getUserId();
        verify(user).getActive();
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getGivenName();
        verify(user).getSurname();
        verify(user).getUsername();
        verify(user).getUserId();
    }

    /**
     * Method under test: {@link UserService#getAllUsersFilterByRole(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllUsersFilterByRole5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:25)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.users.UserService.getAllUsersFilterByRole(UserService.java:46)
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

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role1);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");
        User user2 = mock(User.class);
        when(user2.getActive()).thenReturn(true);
        when(user2.getRole()).thenReturn(role2);
        when(user2.getEmail()).thenReturn("jane.doe@example.org");
        when(user2.getGivenName()).thenReturn("Given Name");
        when(user2.getSurname()).thenReturn("Doe");
        when(user2.getUsername()).thenReturn("janedoe");
        when(user2.getUserId()).thenReturn(UUID.randomUUID());

        Role role3 = new Role();
        role3.setId(1);
        role3.setName("Name");
        User user3 = mock(User.class);
        when(user3.getActive()).thenReturn(true);
        when(user3.getRole()).thenReturn(role3);
        when(user3.getEmail()).thenReturn("jane.doe@example.org");
        when(user3.getGivenName()).thenReturn("Given Name");
        when(user3.getSurname()).thenReturn("Doe");
        when(user3.getUsername()).thenReturn("janedoe");
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Role role4 = new Role();
        role4.setId(1);
        role4.setName("Name");
        User user4 = mock(User.class);
        when(user4.getActive()).thenReturn(true);
        when(user4.getRole()).thenReturn(role4);
        when(user4.getEmail()).thenReturn("jane.doe@example.org");
        when(user4.getGivenName()).thenReturn("Given Name");
        when(user4.getSurname()).thenReturn("Doe");
        when(user4.getUsername()).thenReturn("janedoe");
        when(user4.getUserId()).thenReturn(UUID.randomUUID());

        Role role5 = new Role();
        role5.setId(1);
        role5.setName("Name");
        User user5 = mock(User.class);
        when(user5.getActive()).thenReturn(true);
        when(user5.getRole()).thenReturn(role5);
        when(user5.getEmail()).thenReturn("jane.doe@example.org");
        when(user5.getGivenName()).thenReturn("Given Name");
        when(user5.getSurname()).thenReturn("Doe");
        when(user5.getUsername()).thenReturn("janedoe");
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Role role6 = new Role();
        role6.setId(1);
        role6.setName("Name");
        User user6 = mock(User.class);
        when(user6.getActive()).thenReturn(true);
        when(user6.getRole()).thenReturn(role6);
        when(user6.getEmail()).thenReturn("jane.doe@example.org");
        when(user6.getGivenName()).thenReturn("Given Name");
        when(user6.getSurname()).thenReturn("Doe");
        when(user6.getUsername()).thenReturn("janedoe");
        when(user6.getUserId()).thenReturn(UUID.randomUUID());

        Role role7 = new Role();
        role7.setId(1);
        role7.setName("Name");
        User user7 = mock(User.class);
        when(user7.getActive()).thenReturn(true);
        when(user7.getRole()).thenReturn(role7);
        when(user7.getEmail()).thenReturn("jane.doe@example.org");
        when(user7.getGivenName()).thenReturn("Given Name");
        when(user7.getSurname()).thenReturn("Doe");
        when(user7.getUsername()).thenReturn("janedoe");
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Role role8 = new Role();
        role8.setId(1);
        role8.setName("Name");
        User user8 = mock(User.class);
        when(user8.getActive()).thenReturn(true);
        when(user8.getRole()).thenReturn(role8);
        when(user8.getEmail()).thenReturn("jane.doe@example.org");
        when(user8.getGivenName()).thenReturn("Given Name");
        when(user8.getSurname()).thenReturn("Doe");
        when(user8.getUsername()).thenReturn("janedoe");
        when(user8.getUserId()).thenReturn(UUID.randomUUID());

        Role role9 = new Role();
        role9.setId(1);
        role9.setName("Name");
        User user9 = mock(User.class);
        when(user9.getActive()).thenReturn(true);
        when(user9.getRole()).thenReturn(role9);
        when(user9.getEmail()).thenReturn("jane.doe@example.org");
        when(user9.getGivenName()).thenReturn("Given Name");
        when(user9.getSurname()).thenReturn("Doe");
        when(user9.getUsername()).thenReturn("janedoe");
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Role role10 = new Role();
        role10.setId(1);
        role10.setName("Name");
        User user10 = mock(User.class);
        when(user10.getActive()).thenReturn(true);
        when(user10.getRole()).thenReturn(role10);
        when(user10.getEmail()).thenReturn("jane.doe@example.org");
        when(user10.getGivenName()).thenReturn("Given Name");
        when(user10.getSurname()).thenReturn("Doe");
        when(user10.getUsername()).thenReturn("janedoe");
        when(user10.getUserId()).thenReturn(UUID.randomUUID());

        Role role11 = new Role();
        role11.setId(1);
        role11.setName("Name");
        User user11 = mock(User.class);
        when(user11.getActive()).thenReturn(true);
        when(user11.getRole()).thenReturn(role11);
        when(user11.getEmail()).thenReturn("jane.doe@example.org");
        when(user11.getGivenName()).thenReturn("Given Name");
        when(user11.getSurname()).thenReturn("Doe");
        when(user11.getUsername()).thenReturn("janedoe");
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Role role12 = new Role();
        role12.setId(1);
        role12.setName("Name");
        User user12 = mock(User.class);
        when(user12.getActive()).thenReturn(true);
        when(user12.getRole()).thenReturn(role12);
        when(user12.getEmail()).thenReturn("jane.doe@example.org");
        when(user12.getGivenName()).thenReturn("Given Name");
        when(user12.getSurname()).thenReturn("Doe");
        when(user12.getUsername()).thenReturn("janedoe");
        when(user12.getUserId()).thenReturn(UUID.randomUUID());

        Role role13 = new Role();
        role13.setId(1);
        role13.setName("Name");
        User user13 = mock(User.class);
        when(user13.getActive()).thenReturn(true);
        when(user13.getRole()).thenReturn(role13);
        when(user13.getEmail()).thenReturn("jane.doe@example.org");
        when(user13.getGivenName()).thenReturn("Given Name");
        when(user13.getSurname()).thenReturn("Doe");
        when(user13.getUsername()).thenReturn("janedoe");
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Role role14 = new Role();
        role14.setId(1);
        role14.setName("Name");
        User user14 = mock(User.class);
        when(user14.getActive()).thenReturn(true);
        when(user14.getRole()).thenReturn(role14);
        when(user14.getEmail()).thenReturn("jane.doe@example.org");
        when(user14.getGivenName()).thenReturn("Given Name");
        when(user14.getSurname()).thenReturn("Doe");
        when(user14.getUsername()).thenReturn("janedoe");
        when(user14.getUserId()).thenReturn(UUID.randomUUID());

        Role role15 = new Role();
        role15.setId(1);
        role15.setName("Name");
        User user15 = mock(User.class);
        when(user15.getActive()).thenReturn(true);
        when(user15.getRole()).thenReturn(role15);
        when(user15.getEmail()).thenReturn("jane.doe@example.org");
        when(user15.getGivenName()).thenReturn("Given Name");
        when(user15.getSurname()).thenReturn("Doe");
        when(user15.getUsername()).thenReturn("janedoe");
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Role role16 = new Role();
        role16.setId(1);
        role16.setName("Name");
        User user16 = mock(User.class);
        when(user16.getActive()).thenReturn(true);
        when(user16.getRole()).thenReturn(role16);
        when(user16.getEmail()).thenReturn("jane.doe@example.org");
        when(user16.getGivenName()).thenReturn("Given Name");
        when(user16.getSurname()).thenReturn("Doe");
        when(user16.getUsername()).thenReturn("janedoe");
        when(user16.getUserId()).thenReturn(UUID.randomUUID());

        Role role17 = new Role();
        role17.setId(1);
        role17.setName("Name");
        User user17 = mock(User.class);
        when(user17.getActive()).thenReturn(true);
        when(user17.getRole()).thenReturn(role17);
        when(user17.getEmail()).thenReturn("jane.doe@example.org");
        when(user17.getGivenName()).thenReturn("Given Name");
        when(user17.getSurname()).thenReturn("Doe");
        when(user17.getUsername()).thenReturn("janedoe");
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Role role18 = new Role();
        role18.setId(1);
        role18.setName("Name");
        User user18 = mock(User.class);
        when(user18.getActive()).thenReturn(true);
        when(user18.getRole()).thenReturn(role18);
        when(user18.getEmail()).thenReturn("jane.doe@example.org");
        when(user18.getGivenName()).thenReturn("Given Name");
        when(user18.getSurname()).thenReturn("Doe");
        when(user18.getUsername()).thenReturn("janedoe");
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getRole()).thenThrow(new ResourceNotFoundException());
        when(user19.getEmail()).thenThrow(new ResourceNotFoundException());
        when(user19.getGivenName()).thenThrow(new ResourceNotFoundException());
        when(user19.getSurname()).thenThrow(new ResourceNotFoundException());
        when(user19.getUsername()).thenThrow(new ResourceNotFoundException());
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user19);
        userList.add(user18);
        userList.add(user17);
        userList.add(user16);
        userList.add(user15);
        userList.add(user14);
        userList.add(user13);
        userList.add(user12);
        userList.add(user11);
        userList.add(user10);
        userList.add(user9);
        userList.add(user8);
        userList.add(user7);
        userList.add(user6);
        userList.add(user5);
        userList.add(user4);
        userList.add(user3);
        userList.add(user2);
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAllByRoleName((String) any())).thenReturn(userList);
        userService.getAllUsersFilterByRole("Select Role");
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
        User user = mock(User.class);
        when(user.getActive()).thenReturn(true);
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
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
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    void testGetUserByUsername2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getActive()).thenThrow(new IllegalArgumentException());
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
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
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:30)
        //       at java.util.Optional.map(Optional.java:265)
        //       at com.revature.project2.users.UserService.getUserByUsername(UserService.java:62)
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
        User user = mock(User.class);
        when(user.getActive()).thenReturn(false);
        when(user.getRole()).thenReturn(role);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getGivenName()).thenReturn("Given Name");
        when(user.getSurname()).thenReturn("Doe");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getUserId()).thenReturn(UUID.randomUUID());
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
    }

    /**
     * Method under test: {@link UserService#getUserByUsername(String)}
     */
    @Test
    void testGetUserByUsername5() {
        Role role = mock(Role.class);
        when(role.getName()).thenReturn("Name");
        doNothing().when(role).setId(anyInt());
        doNothing().when(role).setName((String) any());
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
        verify(role).getName();
        verify(role).setId(anyInt());
        verify(role).setName((String) any());
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
        //       at com.revature.project2.users.UserService.getUserByUsername(UserService.java:63)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        Role role = mock(Role.class);
        when(role.getName()).thenReturn("Name");
        doNothing().when(role).setId(anyInt());
        doNothing().when(role).setName((String) any());
        role.setId(1);
        role.setName("Name");
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
    void testRegister10() {
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.existsByUsername((String) any())).thenReturn(false);
        when(userRepository.save((User) any())).thenReturn(mock(User.class));
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        NewUserRequest newUserRequest = mock(NewUserRequest.class);
        when(newUserRequest.extractEntity()).thenReturn(user);
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
        verify(user).getUserId();
    }


    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setRole((Role) any());
        Optional<User> ofResult = Optional.of(user);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenReturn(true);
        when(user1.getRole()).thenReturn(role);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());
        when(userRepository.getById((UUID) any())).thenReturn(user1);
        when(userRepository.save((User) any())).thenReturn(mock(User.class));
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        UserResponse actualUpdateUserRoleResult = userService.updateUserRole("janedoe", role1);
        assertEquals("jane.doe@example.org", actualUpdateUserRoleResult.getEmail());
        assertEquals("janedoe", actualUpdateUserRoleResult.getUsername());
        assertEquals("Doe", actualUpdateUserRoleResult.getSurname());
        assertEquals("Name", actualUpdateUserRoleResult.getRole());
        assertTrue(actualUpdateUserRoleResult.getIsActive());
        assertEquals("Given Name", actualUpdateUserRoleResult.getGivenName());
        verify(userRepository).getById((UUID) any());
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(user1).getActive();
        verify(user1).getRole();
        verify(user1).getEmail();
        verify(user1).getGivenName();
        verify(user1).getSurname();
        verify(user1).getUsername();
        verify(user1).getUserId();
        verify(user).getUserId();
        verify(user).setRole((Role) any());
    }


    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    void testUpdateUserRole3() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setRole((Role) any());
        Optional<User> ofResult = Optional.of(user);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        User user1 = mock(User.class);
        when(user1.getActive()).thenThrow(new IllegalArgumentException());
        when(user1.getRole()).thenReturn(role);
        when(user1.getEmail()).thenReturn("jane.doe@example.org");
        when(user1.getGivenName()).thenReturn("Given Name");
        when(user1.getSurname()).thenReturn("Doe");
        when(user1.getUsername()).thenReturn("janedoe");
        when(user1.getUserId()).thenReturn(UUID.randomUUID());
        when(userRepository.getById((UUID) any())).thenReturn(user1);
        when(userRepository.save((User) any())).thenReturn(mock(User.class));
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        assertThrows(InvalidRequestException.class, () -> userService.updateUserRole("janedoe", role1));
        verify(userRepository).getById((UUID) any());
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(user1).getActive();
        verify(user1).getRole();
        verify(user1).getEmail();
        verify(user1).getGivenName();
        verify(user1).getSurname();
        verify(user1).getUsername();
        verify(user1).getUserId();
        verify(user).getUserId();
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link UserService#updateUserRole(String, Role)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUserRole4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.InvalidRequestException: An error occurred
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:30)
        //       at com.revature.project2.users.UserService.updateUserRole(UserService.java:156)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        doNothing().when(user).setRole((Role) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));
        when(userRepository.save((User) any())).thenReturn(mock(User.class));
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        new InvalidRequestException("An error occurred");

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        userService.updateUserRole("janedoe", role);
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser() {
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.of(mock(User.class)));
        assertThrows(RuntimeException.class, () -> userService.updateUser(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser2() {
        when(userRepository.existsByEmail((String) any())).thenThrow(new IllegalArgumentException());
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.of(mock(User.class)));
        assertThrows(IllegalArgumentException.class, () -> userService.updateUser(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser3() {
        User user = mock(User.class);
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> userService.updateUser(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setSurname((String) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at java.util.Optional.orElseThrow(Optional.java:408)
        //       at com.revature.project2.users.UserService.updateUser(UserService.java:171)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        userService.updateUser(new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "Given Name",
                "Doe", "Is Active", "Role Name"));
    }


    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserService.updateUser(UserService.java:171)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(true);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        userService.updateUser(null);
    }


    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser11() {
        User user = mock(User.class);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> userService.updateUser(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", Boolean.TRUE.toString(), "Role Name")));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setSurname((String) any());
    }


    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser13() {
        User user = mock(User.class);
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Optional<Role> ofResult1 = Optional.of(role);
        when(roleRepo.findById((Integer) any())).thenReturn(ofResult1);
        userService.updateUser(new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "Given Name",
                "Doe", Boolean.TRUE.toString(), "admin"));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(roleRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser14() {
        User user = mock(User.class);
        doThrow(new IllegalArgumentException()).when(user).setRole((Role) any());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Optional<Role> ofResult1 = Optional.of(role);
        when(roleRepo.findById((Integer) any())).thenReturn(ofResult1);
        assertThrows(IllegalArgumentException.class, () -> userService.updateUser(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", Boolean.TRUE.toString(), "admin")));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(roleRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser15() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at java.util.Optional.orElseThrow(Optional.java:408)
        //       at com.revature.project2.users.UserService.updateUser(UserService.java:250)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        when(roleRepo.findById((Integer) any())).thenReturn(Optional.empty());
        userService.updateUser(new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "Given Name",
                "Doe", Boolean.TRUE.toString(), "admin"));
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser16() {
        User user = mock(User.class);
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Optional<Role> ofResult1 = Optional.of(role);
        when(roleRepo.findById((Integer) any())).thenReturn(ofResult1);
        userService.updateUser(new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "Given Name",
                "Doe", Boolean.TRUE.toString(), "finance manager"));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(roleRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    void testUpdateUser17() {
        User user = mock(User.class);
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Optional<Role> ofResult1 = Optional.of(role);
        when(roleRepo.findById((Integer) any())).thenReturn(ofResult1);
        userService.updateUser(new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "Given Name",
                "Doe", Boolean.TRUE.toString(), "employee"));
        verify(userRepository).existsByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).setActive(anyBoolean());
        verify(user).setEmail((String) any());
        verify(user).setGivenName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
        verify(user).setSurname((String) any());
        verify(roleRepo).findById((Integer) any());
    }


    /**
     * Method under test: {@link UserService#updateUser(UpdateUserBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser19() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserService.updateUser(UserService.java:196)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        doNothing().when(user).setRole((Role) any());
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setGivenName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setSurname((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.existsByEmail((String) any())).thenReturn(false);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        Optional<Role> ofResult1 = Optional.of(role);
        when(roleRepo.findById((Integer) any())).thenReturn(ofResult1);
        userService.updateUser(new UpdateUserBody());
    }


}
