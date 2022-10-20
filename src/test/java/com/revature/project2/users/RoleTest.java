package com.revature.project2.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#Role()}
     *   <li>{@link Role#setId(int)}
     *   <li>{@link Role#setName(String)}
     *   <li>{@link Role#toString()}
     *   <li>{@link Role#getId()}
     *   <li>{@link Role#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Role actualRole = new Role();
        actualRole.setId(1);
        actualRole.setName("Name");
        String actualToStringResult = actualRole.toString();
        assertEquals(1, actualRole.getId());
        assertEquals("Name", actualRole.getName());
        assertEquals("Role{role_id='1', role='Name'}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#Role(int, String)}
     *   <li>{@link Role#setId(int)}
     *   <li>{@link Role#setName(String)}
     *   <li>{@link Role#toString()}
     *   <li>{@link Role#getId()}
     *   <li>{@link Role#getName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Role actualRole = new Role(1, "Role");
        actualRole.setId(1);
        actualRole.setName("Name");
        String actualToStringResult = actualRole.toString();
        assertEquals(1, actualRole.getId());
        assertEquals("Name", actualRole.getName());
        assertEquals("Role{role_id='1', role='Name'}", actualToStringResult);
    }

    /**
     * Method under test: {@link Role#Role(int)}
     */
    @Test
    void testConstructor3() {
        Role actualRole = new Role(1);
        assertEquals(1, actualRole.getId());
        assertEquals("admin", actualRole.getName());
    }

    /**
     * Method under test: {@link Role#Role(int)}
     */
    @Test
    void testConstructor4() {
        Role actualRole = new Role(2);
        assertEquals(2, actualRole.getId());
        assertEquals("finance manager", actualRole.getName());
    }

    /**
     * Method under test: {@link Role#Role(int)}
     */
    @Test
    void testConstructor5() {
        Role actualRole = new Role(3);
        assertEquals(3, actualRole.getId());
        assertEquals("employee", actualRole.getName());
    }

    /**
     * Method under test: {@link Role#Role(int)}
     */
    @Test
    void testConstructor6() {
        assertEquals(8080, (new Role(8080)).getId());
    }

    /**
     * Method under test: {@link Role#Role(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Id Import"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:652)
        //       at java.lang.Integer.parseInt(Integer.java:770)
        //       at com.revature.project2.users.Role.<init>(Role.java:52)
        //   See https://diff.blue/R013 to resolve this issue.

        new Role("Id Import");
    }

    /**
     * Method under test: {@link Role#Role(String)}
     */
    @Test
    void testConstructor8() {
        assertEquals(42, (new Role("42")).getId());
    }

    /**
     * Method under test: {@link Role#Role(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Role id"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:652)
        //       at java.lang.Integer.parseInt(Integer.java:770)
        //       at com.revature.project2.users.Role.<init>(Role.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        new Role("Role id", "Role");

    }

    /**
     * Method under test: {@link Role#Role(String, String)}
     */
    @Test
    void testConstructor10() {
        Role actualRole = new Role("42", "Role");

        assertEquals(42, actualRole.getId());
        assertEquals("Role", actualRole.getName());
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void testEquals() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        assertNotEquals(role, null);
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void testEquals2() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        assertNotEquals(role, "Different type to Role");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#equals(Object)}
     *   <li>{@link Role#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");
        assertEquals(role, role);
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#equals(Object)}
     *   <li>{@link Role#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        assertEquals(role, role1);
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role1.hashCode());
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void testEquals5() {
        Role role = new Role();
        role.setId(123);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        assertNotEquals(role, role1);
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void testEquals6() {
        Role role = new Role();
        role.setId(1);
        role.setName(null);

        Role role1 = new Role();
        role1.setId(1);
        role1.setName("Name");
        assertNotEquals(role, role1);
    }
}

