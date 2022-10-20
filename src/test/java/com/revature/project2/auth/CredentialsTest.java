package com.revature.project2.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CredentialsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Credentials#Credentials()}
     *   <li>{@link Credentials#setPassword(String)}
     *   <li>{@link Credentials#setUsername(String)}
     *   <li>{@link Credentials#getPassword()}
     *   <li>{@link Credentials#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Credentials actualCredentials = new Credentials();
        actualCredentials.setPassword("iloveyou");
        actualCredentials.setUsername("janedoe");
        assertEquals("iloveyou", actualCredentials.getPassword());
        assertEquals("janedoe", actualCredentials.getUsername());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Credentials#Credentials(String, String)}
     *   <li>{@link Credentials#setPassword(String)}
     *   <li>{@link Credentials#setUsername(String)}
     *   <li>{@link Credentials#getPassword()}
     *   <li>{@link Credentials#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Credentials actualCredentials = new Credentials("janedoe", "iloveyou");
        actualCredentials.setPassword("iloveyou");
        actualCredentials.setUsername("janedoe");
        assertEquals("iloveyou", actualCredentials.getPassword());
        assertEquals("janedoe", actualCredentials.getUsername());
    }
}

