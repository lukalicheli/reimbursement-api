package com.revature.project2.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class UserResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#UserResponse()}
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
        UserResponse actualUserResponse = new UserResponse();
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
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UserResponse(), null);
        assertNotEquals(new UserResponse(), "Different type to UserResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UserResponse userResponse = new UserResponse();
        assertEquals(userResponse, userResponse);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserResponse userResponse = new UserResponse();
        UserResponse userResponse1 = new UserResponse();
        assertEquals(userResponse, userResponse1);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse1.hashCode());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
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
        UserResponse userResponse = new UserResponse(user);
        assertNotEquals(userResponse, new UserResponse());
    }
}

