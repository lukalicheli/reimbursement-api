package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.revature.project2.users.User;

import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class ReimbursementResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReimbursementResponse#ReimbursementResponse()}
     *   <li>{@link ReimbursementResponse#setAmount(double)}
     *   <li>{@link ReimbursementResponse#setAuthorID(String)}
     *   <li>{@link ReimbursementResponse#setDescription(String)}
     *   <li>{@link ReimbursementResponse#setReimbID(UUID)}
     *   <li>{@link ReimbursementResponse#setResolved(String)}
     *   <li>{@link ReimbursementResponse#setResolverID(String)}
     *   <li>{@link ReimbursementResponse#setStatus(String)}
     *   <li>{@link ReimbursementResponse#setSubmitted(String)}
     *   <li>{@link ReimbursementResponse#setTypeID(String)}
     *   <li>{@link ReimbursementResponse#toString()}
     *   <li>{@link ReimbursementResponse#getAmount()}
     *   <li>{@link ReimbursementResponse#getAuthorID()}
     *   <li>{@link ReimbursementResponse#getDescription()}
     *   <li>{@link ReimbursementResponse#getReimbID()}
     *   <li>{@link ReimbursementResponse#getResolved()}
     *   <li>{@link ReimbursementResponse#getResolverID()}
     *   <li>{@link ReimbursementResponse#getStatus()}
     *   <li>{@link ReimbursementResponse#getSubmitted()}
     *   <li>{@link ReimbursementResponse#getType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ReimbursementResponse actualReimbursementResponse = new ReimbursementResponse();
        actualReimbursementResponse.setAmount(10.0d);
        actualReimbursementResponse.setAuthorID("JaneDoe");
        actualReimbursementResponse.setDescription("The characteristics of someone or something");
        UUID randomUUIDResult = UUID.randomUUID();
        actualReimbursementResponse.setReimbID(randomUUIDResult);
        actualReimbursementResponse.setResolved("Resolved");
        actualReimbursementResponse.setResolverID("Resolver ID");
        actualReimbursementResponse.setStatus("Status");
        actualReimbursementResponse.setSubmitted("Submitted");
        actualReimbursementResponse.setTypeID("Type");
        actualReimbursementResponse.toString();
        assertEquals(10.0d, actualReimbursementResponse.getAmount());
        assertEquals("JaneDoe", actualReimbursementResponse.getAuthorID());
        assertEquals("The characteristics of someone or something", actualReimbursementResponse.getDescription());
        assertSame(randomUUIDResult, actualReimbursementResponse.getReimbID());
        assertEquals("Resolved", actualReimbursementResponse.getResolved());
        assertEquals("Resolver ID", actualReimbursementResponse.getResolverID());
        assertEquals("Status", actualReimbursementResponse.getStatus());
        assertEquals("Submitted", actualReimbursementResponse.getSubmitted());
        assertEquals("Type", actualReimbursementResponse.getType());
    }

    /**
     * Method under test: {@link ReimbursementResponse#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementResponse.equals(ReimbursementResponse.java:122)
        //   See https://diff.blue/R013 to resolve this issue.

        ReimbursementResponse reimbursementResponse = new ReimbursementResponse();
        assertThrows(NullPointerException.class, () -> reimbursementResponse.equals(new ReimbursementResponse()));
    }

    /**
     * Method under test: {@link ReimbursementResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new ReimbursementResponse(), null);
        assertNotEquals(new ReimbursementResponse(), "Different type to ReimbursementResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReimbursementResponse#equals(Object)}
     *   <li>{@link ReimbursementResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        ReimbursementResponse reimbursementResponse = new ReimbursementResponse();
        assertEquals(reimbursementResponse, reimbursementResponse);
        int expectedHashCodeResult = reimbursementResponse.hashCode();
        assertEquals(expectedHashCodeResult, reimbursementResponse.hashCode());
    }

    /**
     * Method under test: {@link ReimbursementResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        ReimbursementResponse reimbursementResponse = new ReimbursementResponse();
        reimbursementResponse.setReimbID(UUID.randomUUID());
        assertNotEquals(reimbursementResponse, new ReimbursementResponse());
    }

    /**
     * Method under test: {@link ReimbursementResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        ReimbursementResponse reimbursementResponse = new ReimbursementResponse();
        reimbursementResponse.setAmount(10.0d);
        assertNotEquals(reimbursementResponse, new ReimbursementResponse());
    }

    /**
     * Method under test: {@link ReimbursementResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());
        UUID reimbID = UUID.randomUUID();
        Status status = new Status();
        ReimbursementResponse reimbursementResponse = new ReimbursementResponse(new Reimbursement(reimbID, 10.0d,
                "Submitted", "Resolved", "The characteristics of someone or something", user, user1, status, new Type()));
        assertNotEquals(reimbursementResponse, new ReimbursementResponse());
    }
}

