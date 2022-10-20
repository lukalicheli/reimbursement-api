package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StatusTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Status#Status()}
     *   <li>{@link Status#setStatusID(int)}
     *   <li>{@link Status#setStatusName(String)}
     *   <li>{@link Status#toString()}
     *   <li>{@link Status#getStatusID()}
     *   <li>{@link Status#getStatusName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Status actualStatus = new Status();
        actualStatus.setStatusID(1);
        actualStatus.setStatusName("Status");
        String actualToStringResult = actualStatus.toString();
        assertEquals(1, actualStatus.getStatusID());
        assertEquals("Status", actualStatus.getStatusName());
        assertEquals("ReimbursementStatus{statusID=1, status='Status'}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Status#Status(int, String)}
     *   <li>{@link Status#setStatusID(int)}
     *   <li>{@link Status#setStatusName(String)}
     *   <li>{@link Status#toString()}
     *   <li>{@link Status#getStatusID()}
     *   <li>{@link Status#getStatusName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Status actualStatus = new Status(1, "Status");
        actualStatus.setStatusID(1);
        actualStatus.setStatusName("Status");
        String actualToStringResult = actualStatus.toString();
        assertEquals(1, actualStatus.getStatusID());
        assertEquals("Status", actualStatus.getStatusName());
        assertEquals("ReimbursementStatus{statusID=1, status='Status'}", actualToStringResult);
    }

    /**
     * Method under test: {@link Status#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.Status.equals(Status.java:51)
        //   See https://diff.blue/R013 to resolve this issue.

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName(null);

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");
        assertThrows(NullPointerException.class, () -> status.equals(status1));
    }

    /**
     * Method under test: {@link Status#equals(Object)}
     */
    @Test
    void testEquals() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");
        assertNotEquals(status, null);
    }

    /**
     * Method under test: {@link Status#equals(Object)}
     */
    @Test
    void testEquals2() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");
        assertNotEquals(status, "Different type to Status");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Status#equals(Object)}
     *   <li>{@link Status#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");
        assertEquals(status, status);
        int expectedHashCodeResult = status.hashCode();
        assertEquals(expectedHashCodeResult, status.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Status#equals(Object)}
     *   <li>{@link Status#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");
        assertEquals(status, status1);
        int expectedHashCodeResult = status.hashCode();
        assertEquals(expectedHashCodeResult, status1.hashCode());
    }

    /**
     * Method under test: {@link Status#equals(Object)}
     */
    @Test
    void testEquals5() {
        Status status = new Status();
        status.setStatusID(0);
        status.setStatusName("Status");

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");
        assertNotEquals(status, status1);
    }

    /**
     * Method under test: {@link Status#equals(Object)}
     */
    @Test
    void testEquals7() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("com.revature.project2.reimbursements.Status");

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");
        assertNotEquals(status, status1);
    }
}

