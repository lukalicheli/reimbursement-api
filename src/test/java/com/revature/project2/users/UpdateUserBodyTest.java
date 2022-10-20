package com.revature.project2.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UpdateUserBodyTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateUserBody#UpdateUserBody()}
     *   <li>{@link UpdateUserBody#setEmail(String)}
     *   <li>{@link UpdateUserBody#setGivenName(String)}
     *   <li>{@link UpdateUserBody#setIsActive(String)}
     *   <li>{@link UpdateUserBody#setPassword(String)}
     *   <li>{@link UpdateUserBody#setRoleName(String)}
     *   <li>{@link UpdateUserBody#setSurname(String)}
     *   <li>{@link UpdateUserBody#setUserId(String)}
     *   <li>{@link UpdateUserBody#setUsername(String)}
     *   <li>{@link UpdateUserBody#toString()}
     *   <li>{@link UpdateUserBody#getEmail()}
     *   <li>{@link UpdateUserBody#getGivenName()}
     *   <li>{@link UpdateUserBody#getIsActive()}
     *   <li>{@link UpdateUserBody#getPassword()}
     *   <li>{@link UpdateUserBody#getRoleName()}
     *   <li>{@link UpdateUserBody#getSurname()}
     *   <li>{@link UpdateUserBody#getUserId()}
     *   <li>{@link UpdateUserBody#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UpdateUserBody actualUpdateUserBody = new UpdateUserBody();
        actualUpdateUserBody.setEmail("jane.doe@example.org");
        actualUpdateUserBody.setGivenName("Given Name");
        actualUpdateUserBody.setIsActive("Is Active");
        actualUpdateUserBody.setPassword("iloveyou");
        actualUpdateUserBody.setRoleName("Role Name");
        actualUpdateUserBody.setSurname("Doe");
        actualUpdateUserBody.setUserId("42");
        actualUpdateUserBody.setUsername("janedoe");
        String actualToStringResult = actualUpdateUserBody.toString();
        assertEquals("jane.doe@example.org", actualUpdateUserBody.getEmail());
        assertEquals("Given Name", actualUpdateUserBody.getGivenName());
        assertEquals("Is Active", actualUpdateUserBody.getIsActive());
        assertEquals("iloveyou", actualUpdateUserBody.getPassword());
        assertEquals("Role Name", actualUpdateUserBody.getRoleName());
        assertEquals("Doe", actualUpdateUserBody.getSurname());
        assertEquals("42", actualUpdateUserBody.getUserId());
        assertEquals("janedoe", actualUpdateUserBody.getUsername());
        assertEquals(
                "UpdateUserBody{userId='42', username='janedoe', email='jane.doe@example.org', password='iloveyou',"
                        + " givenName='Given Name', surname='Doe', isActive='Is Active', roleName='Role Name'}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateUserBody#UpdateUserBody(String, String, String, String, String, String, String, String)}
     *   <li>{@link UpdateUserBody#setEmail(String)}
     *   <li>{@link UpdateUserBody#setGivenName(String)}
     *   <li>{@link UpdateUserBody#setIsActive(String)}
     *   <li>{@link UpdateUserBody#setPassword(String)}
     *   <li>{@link UpdateUserBody#setRoleName(String)}
     *   <li>{@link UpdateUserBody#setSurname(String)}
     *   <li>{@link UpdateUserBody#setUserId(String)}
     *   <li>{@link UpdateUserBody#setUsername(String)}
     *   <li>{@link UpdateUserBody#toString()}
     *   <li>{@link UpdateUserBody#getEmail()}
     *   <li>{@link UpdateUserBody#getGivenName()}
     *   <li>{@link UpdateUserBody#getIsActive()}
     *   <li>{@link UpdateUserBody#getPassword()}
     *   <li>{@link UpdateUserBody#getRoleName()}
     *   <li>{@link UpdateUserBody#getSurname()}
     *   <li>{@link UpdateUserBody#getUserId()}
     *   <li>{@link UpdateUserBody#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        UpdateUserBody actualUpdateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");
        actualUpdateUserBody.setEmail("jane.doe@example.org");
        actualUpdateUserBody.setGivenName("Given Name");
        actualUpdateUserBody.setIsActive("Is Active");
        actualUpdateUserBody.setPassword("iloveyou");
        actualUpdateUserBody.setRoleName("Role Name");
        actualUpdateUserBody.setSurname("Doe");
        actualUpdateUserBody.setUserId("42");
        actualUpdateUserBody.setUsername("janedoe");
        String actualToStringResult = actualUpdateUserBody.toString();
        assertEquals("jane.doe@example.org", actualUpdateUserBody.getEmail());
        assertEquals("Given Name", actualUpdateUserBody.getGivenName());
        assertEquals("Is Active", actualUpdateUserBody.getIsActive());
        assertEquals("iloveyou", actualUpdateUserBody.getPassword());
        assertEquals("Role Name", actualUpdateUserBody.getRoleName());
        assertEquals("Doe", actualUpdateUserBody.getSurname());
        assertEquals("42", actualUpdateUserBody.getUserId());
        assertEquals("janedoe", actualUpdateUserBody.getUsername());
        assertEquals(
                "UpdateUserBody{userId='42', username='janedoe', email='jane.doe@example.org', password='iloveyou',"
                        + " givenName='Given Name', surname='Doe', isActive='Is Active', roleName='Role Name'}",
                actualToStringResult);
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody(null, "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", null, "jane.doe@example.org", "iloveyou", "Given Name",
                "Doe", "Is Active", "Role Name");
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", null, "iloveyou", "Given Name", "Doe",
                "Is Active", "Role Name");
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", null, "Given Name",
                "Doe", "Is Active", "Role Name");
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals13() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", null,
                "Doe", "Is Active", "Role Name");
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals15() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", null, "Is Active", "Role Name");
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals17() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", null, "Role Name");
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals19() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.users.UpdateUserBody.equals(UpdateUserBody.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", null);
        assertThrows(NullPointerException.class, () -> updateUserBody.equals(new UpdateUserBody("42", "janedoe",
                "jane.doe@example.org", "iloveyou", "Given Name", "Doe", "Is Active", "Role Name")));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "Given Name", "Doe",
                "Is Active", "Role Name"), null);
        assertNotEquals(new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "Given Name", "Doe",
                "Is Active", "Role Name"), "Different type to UpdateUserBody");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateUserBody#equals(Object)}
     *   <li>{@link UpdateUserBody#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");
        assertEquals(updateUserBody, updateUserBody);
        int expectedHashCodeResult = updateUserBody.hashCode();
        assertEquals(expectedHashCodeResult, updateUserBody.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UpdateUserBody#equals(Object)}
     *   <li>{@link UpdateUserBody#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");
        UpdateUserBody updateUserBody1 = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");

        assertEquals(updateUserBody, updateUserBody1);
        int expectedHashCodeResult = updateUserBody.hashCode();
        assertEquals(expectedHashCodeResult, updateUserBody1.hashCode());
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals4() {
        UpdateUserBody updateUserBody = new UpdateUserBody("janedoe", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals6() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "42", "jane.doe@example.org", "iloveyou", "Given Name",
                "Doe", "Is Active", "Role Name");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals8() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "42", "iloveyou", "Given Name", "Doe",
                "Is Active", "Role Name");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals10() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "42", "Given Name",
                "Doe", "Is Active", "Role Name");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals12() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou", "42",
                "Doe", "Is Active", "Role Name");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals14() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "42", "Is Active", "Role Name");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals16() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "42", "Role Name");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }

    /**
     * Method under test: {@link UpdateUserBody#equals(Object)}
     */
    @Test
    void testEquals18() {
        UpdateUserBody updateUserBody = new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "42");
        assertNotEquals(updateUserBody, new UpdateUserBody("42", "janedoe", "jane.doe@example.org", "iloveyou",
                "Given Name", "Doe", "Is Active", "Role Name"));
    }
}

