package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.revature.project2.users.User;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class NewReimbursementInsertionTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link NewReimbursementInsertion#NewReimbursementInsertion()}
     *   <li>{@link NewReimbursementInsertion#setAmount(double)}
     *   <li>{@link NewReimbursementInsertion#setAuthorID(UUID)}
     *   <li>{@link NewReimbursementInsertion#setDescription(String)}
     *   <li>{@link NewReimbursementInsertion#setStatusID(int)}
     *   <li>{@link NewReimbursementInsertion#setSubmitted(String)}
     *   <li>{@link NewReimbursementInsertion#setType(Type)}
     *   <li>{@link NewReimbursementInsertion#getAmount()}
     *   <li>{@link NewReimbursementInsertion#getAuthorID()}
     *   <li>{@link NewReimbursementInsertion#getDescription()}
     *   <li>{@link NewReimbursementInsertion#getStatusID()}
     *   <li>{@link NewReimbursementInsertion#getSubmitted()}
     *   <li>{@link NewReimbursementInsertion#getType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        NewReimbursementInsertion actualNewReimbursementInsertion = new NewReimbursementInsertion();
        actualNewReimbursementInsertion.setAmount(10.0d);
        UUID randomUUIDResult = UUID.randomUUID();
        actualNewReimbursementInsertion.setAuthorID(randomUUIDResult);
        actualNewReimbursementInsertion.setDescription("The characteristics of someone or something");
        actualNewReimbursementInsertion.setStatusID(1);
        actualNewReimbursementInsertion.setSubmitted("Submitted");
        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        actualNewReimbursementInsertion.setType(type);
        assertEquals(10.0d, actualNewReimbursementInsertion.getAmount());
        assertSame(randomUUIDResult, actualNewReimbursementInsertion.getAuthorID());
        assertEquals("The characteristics of someone or something", actualNewReimbursementInsertion.getDescription());
        assertEquals(1, actualNewReimbursementInsertion.getStatusID());
        assertEquals("Submitted", actualNewReimbursementInsertion.getSubmitted());
        assertSame(type, actualNewReimbursementInsertion.getType());
    }

    /**
     * Method under test: {@link NewReimbursementInsertion#NewReimbursementInsertion(double, String, String, UUID, int)}
     */
    @Test
    void testConstructor2() {
        UUID randomUUIDResult = UUID.randomUUID();
        NewReimbursementInsertion actualNewReimbursementInsertion = new NewReimbursementInsertion(10.0d, "Submitted",
                "The characteristics of someone or something", randomUUIDResult, 1);

        assertEquals(10.0d, actualNewReimbursementInsertion.getAmount());
        assertEquals("Submitted", actualNewReimbursementInsertion.getSubmitted());
        assertSame(randomUUIDResult, actualNewReimbursementInsertion.getAuthorID());
        assertEquals(1, actualNewReimbursementInsertion.getStatusID());
        assertEquals("The characteristics of someone or something", actualNewReimbursementInsertion.getDescription());
        Type type = actualNewReimbursementInsertion.getType();
        assertEquals("lodging", type.getTypeName());
        assertEquals(1, type.getTypeID());
    }

    /**
     * Method under test: {@link NewReimbursementInsertion#NewReimbursementInsertion(double, String, String, UUID, int)}
     */
    @Test
    void testConstructor3() {
        UUID randomUUIDResult = UUID.randomUUID();
        NewReimbursementInsertion actualNewReimbursementInsertion = new NewReimbursementInsertion(10.0d, "foo", "foo",
                randomUUIDResult, 2);

        assertEquals(10.0d, actualNewReimbursementInsertion.getAmount());
        assertEquals("foo", actualNewReimbursementInsertion.getSubmitted());
        assertSame(randomUUIDResult, actualNewReimbursementInsertion.getAuthorID());
        assertEquals(1, actualNewReimbursementInsertion.getStatusID());
        assertEquals("foo", actualNewReimbursementInsertion.getDescription());
        Type type = actualNewReimbursementInsertion.getType();
        assertEquals("travel", type.getTypeName());
        assertEquals(2, type.getTypeID());
    }

    /**
     * Method under test: {@link NewReimbursementInsertion#NewReimbursementInsertion(double, String, String, UUID, int)}
     */
    @Test
    void testConstructor4() {
        UUID randomUUIDResult = UUID.randomUUID();
        NewReimbursementInsertion actualNewReimbursementInsertion = new NewReimbursementInsertion(10.0d, "foo", "foo",
                randomUUIDResult, 3);

        assertEquals(10.0d, actualNewReimbursementInsertion.getAmount());
        assertEquals("foo", actualNewReimbursementInsertion.getSubmitted());
        assertSame(randomUUIDResult, actualNewReimbursementInsertion.getAuthorID());
        assertEquals(1, actualNewReimbursementInsertion.getStatusID());
        assertEquals("foo", actualNewReimbursementInsertion.getDescription());
        Type type = actualNewReimbursementInsertion.getType();
        assertEquals("food", type.getTypeName());
        assertEquals(3, type.getTypeID());
    }

    /**
     * Method under test: {@link NewReimbursementInsertion#NewReimbursementInsertion(double, String, String, UUID, int)}
     */
    @Test
    void testConstructor5() {
        UUID randomUUIDResult = UUID.randomUUID();
        NewReimbursementInsertion actualNewReimbursementInsertion = new NewReimbursementInsertion(10.0d, "foo", "foo",
                randomUUIDResult, 4);

        assertEquals(10.0d, actualNewReimbursementInsertion.getAmount());
        assertEquals("foo", actualNewReimbursementInsertion.getSubmitted());
        assertSame(randomUUIDResult, actualNewReimbursementInsertion.getAuthorID());
        assertEquals(1, actualNewReimbursementInsertion.getStatusID());
        assertEquals("foo", actualNewReimbursementInsertion.getDescription());
        Type type = actualNewReimbursementInsertion.getType();
        assertEquals("other", type.getTypeName());
        assertEquals(4, type.getTypeID());
    }

    /**
     * Method under test: {@link NewReimbursementInsertion#NewReimbursementInsertion(double, String, String, UUID, int)}
     */
    @Test
    void testConstructor6() {
        UUID randomUUIDResult = UUID.randomUUID();
        NewReimbursementInsertion actualNewReimbursementInsertion = new NewReimbursementInsertion(10.0d, "Submitted",
                "The characteristics of someone or something", randomUUIDResult, 0);

        assertEquals(10.0d, actualNewReimbursementInsertion.getAmount());
        assertEquals("Submitted", actualNewReimbursementInsertion.getSubmitted());
        assertSame(randomUUIDResult, actualNewReimbursementInsertion.getAuthorID());
        assertEquals(1, actualNewReimbursementInsertion.getStatusID());
        assertEquals("The characteristics of someone or something", actualNewReimbursementInsertion.getDescription());
        assertEquals(0, actualNewReimbursementInsertion.getType().getTypeID());
    }

    /**
     * Method under test: {@link NewReimbursementInsertion#extractEntity()}
     */
    @Test
    void testExtractEntity() {
        Reimbursement actualExtractEntityResult = (new NewReimbursementInsertion()).extractEntity();
        assertEquals(0.0d, actualExtractEntityResult.getAmount());
        assertNull(actualExtractEntityResult.getType());
        assertNull(actualExtractEntityResult.getSubmitted());
        assertNull(actualExtractEntityResult.getDescription());
        User author = actualExtractEntityResult.getAuthor();
        assertNull(author.getUserId());
        assertEquals("placeholder", author.getSurname());
        assertNull(author.getRole());
        assertEquals("placeholder", author.getPassword());
        assertEquals("placeholder", author.getGivenName());
        assertEquals("placeholder", author.getEmail());
        assertFalse(author.getActive());
        Status status = actualExtractEntityResult.getStatus();
        assertEquals(1, status.getStatusID());
        assertEquals("pending", status.getStatusName());
        assertEquals("placeholder", author.getUsername());
    }
}

