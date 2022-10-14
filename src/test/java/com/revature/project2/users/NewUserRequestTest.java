package com.revature.project2.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class NewUserRequestTest {
    /**
     * Method under test: {@link NewUserRequest#extractEntity()}
     */
    @Test
    void testExtractEntity() {
        User actualExtractEntityResult = (new NewUserRequest()).extractEntity();
        assertNull(actualExtractEntityResult.getUsername());
        assertNull(actualExtractEntityResult.getSurname());
        assertNull(actualExtractEntityResult.getEmail());
        assertNull(actualExtractEntityResult.getPassword());
        assertNull(actualExtractEntityResult.getGivenName());
        Role role = actualExtractEntityResult.getRole();
        assertEquals("employee", role.getName());
        assertEquals(3, role.getId());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link NewUserRequest}
     *   <li>{@link NewUserRequest#setEmail(String)}
     *   <li>{@link NewUserRequest#setGivenName(String)}
     *   <li>{@link NewUserRequest#setPassword(String)}
     *   <li>{@link NewUserRequest#setSurname(String)}
     *   <li>{@link NewUserRequest#setUsername(String)}
     *   <li>{@link NewUserRequest#toString()}
     *   <li>{@link NewUserRequest#getEmail()}
     *   <li>{@link NewUserRequest#getGivenName()}
     *   <li>{@link NewUserRequest#getPassword()}
     *   <li>{@link NewUserRequest#getSurname()}
     *   <li>{@link NewUserRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        NewUserRequest actualNewUserRequest = new NewUserRequest();
        actualNewUserRequest.setEmail("jane.doe@example.org");
        actualNewUserRequest.setGivenName("Given Name");
        actualNewUserRequest.setPassword("iloveyou");
        actualNewUserRequest.setSurname("Doe");
        actualNewUserRequest.setUsername("janedoe");
        String actualToStringResult = actualNewUserRequest.toString();
        assertEquals("jane.doe@example.org", actualNewUserRequest.getEmail());
        assertEquals("Given Name", actualNewUserRequest.getGivenName());
        assertEquals("iloveyou", actualNewUserRequest.getPassword());
        assertEquals("Doe", actualNewUserRequest.getSurname());
        assertEquals("janedoe", actualNewUserRequest.getUsername());
        assertEquals(
                "NewUserRequest{givenName='Given Name', surname='Doe', email='jane.doe@example.org', username='janedoe',"
                        + " password='iloveyou'}",
                actualToStringResult);
    }
}

