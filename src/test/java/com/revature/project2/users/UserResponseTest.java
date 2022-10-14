package com.revature.project2.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class UserResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#UserResponse(User)}
     *   <li>{@link UserResponse#setEmail(String)}
     *   <li>{@link UserResponse#setGivenName(String)}
     *   <li>{@link UserResponse#setId(String)}
     *   <li>{@link UserResponse#setIsActive(boolean)}
     *   <li>{@link UserResponse#setRole(String)}
     *   <li>{@link UserResponse#setSurname(String)}
     *   <li>{@link UserResponse#setUsername(String)}
     *   <li>{@link UserResponse#toString()}
     *   <li>{@link UserResponse#getEmail()}
     *   <li>{@link UserResponse#getGivenName()}
     *   <li>{@link UserResponse#getId()}
     *   <li>{@link UserResponse#getIsActive()}
     *   <li>{@link UserResponse#getRole()}
     *   <li>{@link UserResponse#getSurname()}
     *   <li>{@link UserResponse#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
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
        UserResponse actualUserResponse = new UserResponse(user);
        actualUserResponse.setEmail("jane.doe@example.org");
        actualUserResponse.setGivenName("Given Name");
        actualUserResponse.setId("42");
        actualUserResponse.setIsActive(true);
        actualUserResponse.setRole("Role");
        actualUserResponse.setSurname("Doe");
        actualUserResponse.setUsername("janedoe");
        String actualToStringResult = actualUserResponse.toString();
        assertEquals("jane.doe@example.org", actualUserResponse.getEmail());
        assertEquals("Given Name", actualUserResponse.getGivenName());
        assertEquals("42", actualUserResponse.getId());
        assertTrue(actualUserResponse.getIsActive());
        assertEquals("Role", actualUserResponse.getRole());
        assertEquals("Doe", actualUserResponse.getSurname());
        assertEquals("janedoe", actualUserResponse.getUsername());
        assertEquals("UserResponse{id='42', givenName='Given Name', surname='Doe', email='jane.doe@example.org', username="
                + "'janedoe', role='Role', active='true'}", actualToStringResult);
    }

    /**
     * Method under test: {@link UserResponse#UserResponse(User)}
     */
    @Test
    void testConstructor2() {
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
        UserResponse actualUserResponse = new UserResponse(user);
        assertEquals("jane.doe@example.org", actualUserResponse.getEmail());
        assertEquals("janedoe", actualUserResponse.getUsername());
        assertEquals("Doe", actualUserResponse.getSurname());
        assertEquals("Name", actualUserResponse.getRole());
        assertTrue(actualUserResponse.getIsActive());
        assertEquals("Given Name", actualUserResponse.getGivenName());
    }

    /**
     * Method under test: {@link UserResponse#UserResponse(User)}
     */
    @Test
    void testConstructor3() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        User user = new User();
        user.setActive(false);
        user.setEmail("jane.doe@example.org");
        user.setGivenName("Given Name");
        user.setPassword("iloveyou");
        user.setRole(role);
        user.setSurname("Doe");
        user.setUserId(UUID.randomUUID());
        user.setUsername("janedoe");
        UserResponse actualUserResponse = new UserResponse(user);
        assertEquals("jane.doe@example.org", actualUserResponse.getEmail());
        assertEquals("janedoe", actualUserResponse.getUsername());
        assertEquals("Doe", actualUserResponse.getSurname());
        assertEquals("Name", actualUserResponse.getRole());
        assertFalse(actualUserResponse.getIsActive());
        assertEquals("Given Name", actualUserResponse.getGivenName());
    }

    /**
     * Method under test: {@link UserResponse#UserResponse(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UserResponse.<init>(UserResponse.java:18)
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
        user.setUserId(null);
        user.setUsername("janedoe");
        new UserResponse(user);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new UserResponse(new User())).equals(null);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new UserResponse(new User())).equals("Different type to UserResponse");
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new UserResponse(new User())).equals(new UserResponse(new User()));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
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
        UserResponse userResponse = new UserResponse(user);
        UUID userId = UUID.randomUUID();
        assertNotEquals(userResponse, new UserResponse(
                new User(userId, "janedoe", "jane.doe@example.org", "iloveyou", "Given Name", "Doe", true, new Role())));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
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
        assertNotEquals(new UserResponse(user), "42");
    }
}

