package com.revature.project2.users;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setActive(boolean)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setGivenName(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRole(Role)}
     *   <li>{@link User#setSurname(String)}
     *   <li>{@link User#setUserId(UUID)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getActive()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getGivenName()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRole()}
     *   <li>{@link User#getSurname()}
     *   <li>{@link User#getUserId()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setActive(true);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setGivenName("Given Name");
        actualUser.setPassword("iloveyou");
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        actualUser.setRole(role);
        actualUser.setSurname("Doe");
        UUID randomUUIDResult = UUID.randomUUID();
        actualUser.setUserId(randomUUIDResult);
        actualUser.setUsername("janedoe");
        actualUser.toString();
        assertTrue(actualUser.getActive());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Given Name", actualUser.getGivenName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(role, actualUser.getRole());
        assertEquals("Doe", actualUser.getSurname());
        assertSame(randomUUIDResult, actualUser.getUserId());
        assertEquals("janedoe", actualUser.getUsername());
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.User.equals(User.java:135)
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = mock(Role.class);
        doNothing().when(role).setId(anyInt());
        doNothing().when(role).setName((String) any());
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
        assertThrows(NullPointerException.class, () -> user.equals(user1));
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(user, null);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(user, "Different type to User");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#equals(Object)}
     *   <li>{@link User#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(user, user);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals4() {
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
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals5() {
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
        assertNotEquals(user, user1);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals6() {
        Role role = mock(Role.class);
        doNothing().when(role).setId(anyInt());
        doNothing().when(role).setName((String) any());
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
        assertNotEquals(user, user1);
    }

}

