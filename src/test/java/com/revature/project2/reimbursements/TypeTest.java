package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TypeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Type#Type()}
     *   <li>{@link Type#setTypeID(int)}
     *   <li>{@link Type#setTypeName(String)}
     *   <li>{@link Type#toString()}
     *   <li>{@link Type#getTypeID()}
     *   <li>{@link Type#getTypeName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Type actualType = new Type();
        actualType.setTypeID(1);
        actualType.setTypeName("Type");
        String actualToStringResult = actualType.toString();
        assertEquals(1, actualType.getTypeID());
        assertEquals("Type", actualType.getTypeName());
        assertEquals("ReimbursementType{typeID=1, type='Type'}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Type#Type(int, String)}
     *   <li>{@link Type#setTypeID(int)}
     *   <li>{@link Type#setTypeName(String)}
     *   <li>{@link Type#toString()}
     *   <li>{@link Type#getTypeID()}
     *   <li>{@link Type#getTypeName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Type actualType = new Type(1, "Type");
        actualType.setTypeID(1);
        actualType.setTypeName("Type");
        String actualToStringResult = actualType.toString();
        assertEquals(1, actualType.getTypeID());
        assertEquals("Type", actualType.getTypeName());
        assertEquals("ReimbursementType{typeID=1, type='Type'}", actualToStringResult);
    }

    /**
     * Method under test: {@link Type#Type(int)}
     */
    @Test
    void testConstructor3() {
        Type actualType = new Type(1);
        assertEquals(1, actualType.getTypeID());
        assertEquals("lodging", actualType.getTypeName());
    }

    /**
     * Method under test: {@link Type#Type(int)}
     */
    @Test
    void testConstructor4() {
        Type actualType = new Type(2);
        assertEquals(2, actualType.getTypeID());
        assertEquals("travel", actualType.getTypeName());
    }

    /**
     * Method under test: {@link Type#Type(int)}
     */
    @Test
    void testConstructor5() {
        Type actualType = new Type(3);
        assertEquals(3, actualType.getTypeID());
        assertEquals("food", actualType.getTypeName());
    }

    /**
     * Method under test: {@link Type#Type(int)}
     */
    @Test
    void testConstructor6() {
        Type actualType = new Type(4);
        assertEquals(4, actualType.getTypeID());
        assertEquals("other", actualType.getTypeName());
    }

    /**
     * Method under test: {@link Type#Type(int)}
     */
    @Test
    void testConstructor7() {
        assertEquals(8080, (new Type(8080)).getTypeID());
    }

    /**
     * Method under test: {@link Type#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.Type.equals(Type.java:69)
        //   See https://diff.blue/R013 to resolve this issue.

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName(null);

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");
        assertThrows(NullPointerException.class, () -> type.equals(type1));
    }

    /**
     * Method under test: {@link Type#equals(Object)}
     */
    @Test
    void testEquals() {
        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        assertNotEquals(type, null);
    }

    /**
     * Method under test: {@link Type#equals(Object)}
     */
    @Test
    void testEquals2() {
        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        assertNotEquals(type, "Different type to Type");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Type#equals(Object)}
     *   <li>{@link Type#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        assertEquals(type, type);
        int expectedHashCodeResult = type.hashCode();
        assertEquals(expectedHashCodeResult, type.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Type#equals(Object)}
     *   <li>{@link Type#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");
        assertEquals(type, type1);
        int expectedHashCodeResult = type.hashCode();
        assertEquals(expectedHashCodeResult, type1.hashCode());
    }

    /**
     * Method under test: {@link Type#equals(Object)}
     */
    @Test
    void testEquals5() {
        Type type = new Type();
        type.setTypeID(0);
        type.setTypeName("Type");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");
        assertNotEquals(type, type1);
    }

    /**
     * Method under test: {@link Type#equals(Object)}
     */
    @Test
    void testEquals7() {
        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("com.revature.project2.reimbursements.Type");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");
        assertNotEquals(type, type1);
    }
}

