package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class ReimbursementApproveOrDenyAlterationTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReimbursementApproveOrDenyAlteration#ReimbursementApproveOrDenyAlteration()}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#setReimbursementID(UUID)}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#setStatusUpdate(boolean)}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#getReimbursementID()}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#getStatusUpdate()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ReimbursementApproveOrDenyAlteration actualReimbursementApproveOrDenyAlteration = new ReimbursementApproveOrDenyAlteration();
        UUID randomUUIDResult = UUID.randomUUID();
        actualReimbursementApproveOrDenyAlteration.setReimbursementID(randomUUIDResult);
        actualReimbursementApproveOrDenyAlteration.setStatusUpdate(true);
        assertSame(randomUUIDResult, actualReimbursementApproveOrDenyAlteration.getReimbursementID());
        assertTrue(actualReimbursementApproveOrDenyAlteration.getStatusUpdate());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReimbursementApproveOrDenyAlteration#ReimbursementApproveOrDenyAlteration(UUID, boolean)}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#setReimbursementID(UUID)}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#setStatusUpdate(boolean)}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#getReimbursementID()}
     *   <li>{@link ReimbursementApproveOrDenyAlteration#getStatusUpdate()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ReimbursementApproveOrDenyAlteration actualReimbursementApproveOrDenyAlteration = new ReimbursementApproveOrDenyAlteration(
                UUID.randomUUID(), true);
        UUID randomUUIDResult = UUID.randomUUID();
        actualReimbursementApproveOrDenyAlteration.setReimbursementID(randomUUIDResult);
        actualReimbursementApproveOrDenyAlteration.setStatusUpdate(true);
        assertSame(randomUUIDResult, actualReimbursementApproveOrDenyAlteration.getReimbursementID());
        assertTrue(actualReimbursementApproveOrDenyAlteration.getStatusUpdate());
    }
}

