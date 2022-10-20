package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import com.revature.project2.users.User;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class ReimbursementTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Reimbursement#Reimbursement()}
     *   <li>{@link Reimbursement#setAmount(double)}
     *   <li>{@link Reimbursement#setAuthor(User)}
     *   <li>{@link Reimbursement#setDescription(String)}
     *   <li>{@link Reimbursement#setReimbID(UUID)}
     *   <li>{@link Reimbursement#setResolved(String)}
     *   <li>{@link Reimbursement#setResolver(User)}
     *   <li>{@link Reimbursement#setStatus(Status)}
     *   <li>{@link Reimbursement#setSubmitted(String)}
     *   <li>{@link Reimbursement#setType(Type)}
     *   <li>{@link Reimbursement#toString()}
     *   <li>{@link Reimbursement#getAmount()}
     *   <li>{@link Reimbursement#getDescription()}
     *   <li>{@link Reimbursement#getReimbID()}
     *   <li>{@link Reimbursement#getResolved()}
     *   <li>{@link Reimbursement#getStatus()}
     *   <li>{@link Reimbursement#getSubmitted()}
     *   <li>{@link Reimbursement#getType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Reimbursement actualReimbursement = new Reimbursement();
        actualReimbursement.setAmount(10.0d);
        actualReimbursement.setAuthor(mock(User.class));
        actualReimbursement.setDescription("The characteristics of someone or something");
        UUID randomUUIDResult = UUID.randomUUID();
        actualReimbursement.setReimbID(randomUUIDResult);
        actualReimbursement.setResolved("Resolved");
        actualReimbursement.setResolver(mock(User.class));
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");
        actualReimbursement.setStatus(status);
        actualReimbursement.setSubmitted("Submitted");
        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        actualReimbursement.setType(type);
        actualReimbursement.toString();
        assertEquals(10.0d, actualReimbursement.getAmount());
        assertEquals("The characteristics of someone or something", actualReimbursement.getDescription());
        assertSame(randomUUIDResult, actualReimbursement.getReimbID());
        assertEquals("Resolved", actualReimbursement.getResolved());
        assertSame(status, actualReimbursement.getStatus());
        assertEquals("Submitted", actualReimbursement.getSubmitted());
        assertSame(type, actualReimbursement.getType());
    }

    /**
     * Method under test: {@link Reimbursement#Reimbursement(UUID, double, String, String, String, User, User, Status, Type)}
     */
    @Test
    void testConstructor2() {
        UUID randomUUIDResult = UUID.randomUUID();
        User author = mock(User.class);
        User resolver = mock(User.class);

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        Reimbursement actualReimbursement = new Reimbursement(randomUUIDResult, 10.0d, "Submitted", "Resolved",
                "The characteristics of someone or something", author, resolver, status, type);

        assertEquals(10.0d, actualReimbursement.getAmount());
        assertSame(type, actualReimbursement.getType());
        assertEquals("Submitted", actualReimbursement.getSubmitted());
        assertSame(randomUUIDResult, actualReimbursement.getReimbID());
        assertSame(status, actualReimbursement.getStatus());
        assertEquals("Resolved", actualReimbursement.getResolved());
        assertEquals("The characteristics of someone or something", actualReimbursement.getDescription());
    }

    /**
     * Method under test: {@link Reimbursement#equals(Object)}
     */
    @Test
    void testEquals() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(mock(User.class));
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        assertNotEquals(reimbursement, null);
    }

    /**
     * Method under test: {@link Reimbursement#equals(Object)}
     */
    @Test
    void testEquals2() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(mock(User.class));
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        assertNotEquals(reimbursement, "Different type to Reimbursement");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Reimbursement#equals(Object)}
     *   <li>{@link Reimbursement#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(mock(User.class));
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        assertEquals(reimbursement, reimbursement);
        int expectedHashCodeResult = reimbursement.hashCode();
        assertEquals(expectedHashCodeResult, reimbursement.hashCode());
    }

    /**
     * Method under test: {@link Reimbursement#equals(Object)}
     */
    @Test
    void testEquals4() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(mock(User.class));
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(mock(User.class));
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(mock(User.class));
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        assertNotEquals(reimbursement, reimbursement1);
    }

    /**
     * Method under test: {@link Reimbursement#equals(Object)}
     */
    @Test
    void testEquals5() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(0.5d);
        reimbursement.setAuthor(mock(User.class));
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(mock(User.class));
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(mock(User.class));
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        assertNotEquals(reimbursement, reimbursement1);
    }
}

