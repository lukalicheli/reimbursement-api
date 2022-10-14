package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.revature.project2.common.exceptions.InvalidRequestException;
import com.revature.project2.common.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReimbursementServiceTest {
    @Mock
    private ReimbursementRepository reimbursementRepository;

    @InjectMocks
    private ReimbursementService reimbursementService;

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    void testGetAllReimbs() {
        when(reimbursementRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(reimbursementService.getAllReimbs().isEmpty());
        verify(reimbursementRepository).findAll();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    void testGetAllReimbs2() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        assertEquals(1, reimbursementService.getAllReimbs().size());
        verify(reimbursementRepository).findAll();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    void testGetAllReimbs3() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthorID(UUID.randomUUID());
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolverID(UUID.randomUUID());
        reimbursement1.setStatusID(1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setTypeID(1);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        assertEquals(2, reimbursementService.getAllReimbs().size());
        verify(reimbursementRepository).findAll();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    void testGetAllReimbs4() {
        when(reimbursementRepository.findAll()).thenThrow(new ResourceNotFoundException());
        assertThrows(ResourceNotFoundException.class, () -> reimbursementService.getAllReimbs());
        verify(reimbursementRepository).findAll();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllPendingReimbs()}
     */
    @Test
    void testGetAllPendingReimbs() {
        when(reimbursementRepository.findAllReimbursementByStatusID(anyInt())).thenReturn(new ArrayList<>());
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllPendingReimbs());
        verify(reimbursementRepository).findAllReimbursementByStatusID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#getAllPendingReimbs()}
     */
    @Test
    void testGetAllPendingReimbs2() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setTypeID(1);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusID(anyInt())).thenReturn(reimbursementList);
        assertEquals(1, reimbursementService.getAllPendingReimbs().size());
        verify(reimbursementRepository).findAllReimbursementByStatusID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#getAllPendingReimbs()}
     */
    @Test
    void testGetAllPendingReimbs3() {
        when(reimbursementRepository.findAllReimbursementByStatusID(anyInt())).thenThrow(new ResourceNotFoundException());
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllPendingReimbs());
        verify(reimbursementRepository).findAllReimbursementByStatusID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#getReimbByID(String)}
     */
    @Test
    void testGetReimbByID() {
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getReimbByID("42"));
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate() {
        assertThrows(InvalidRequestException.class, () -> reimbursementService.generate(new NewReimbursementInsertion()));
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementService.generate(ReimbursementService.java:65)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementService.generate(null);
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate3() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        NewReimbursementInsertion newReimbursementInsertion = new NewReimbursementInsertion(10.0d,
                "ERROR: can not register reimbursement amount less than $0.01", "The characteristics of someone or something",
                UUID.randomUUID(), 1, 1);

        reimbursementService.generate(newReimbursementInsertion);
        verify(reimbursementRepository).save((Reimbursement) any());
        assertEquals(1, newReimbursementInsertion.getStatusID());
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate4() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        assertThrows(InvalidRequestException.class,
                () -> reimbursementService.generate(new NewReimbursementInsertion(10.0d,
                        "ERROR: can not register reimbursement amount less than $0.01", null, UUID.randomUUID(), 1, 1)));
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate5() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        assertThrows(InvalidRequestException.class,
                () -> reimbursementService.generate(new NewReimbursementInsertion(10.0d,
                        "ERROR: can not register reimbursement amount less than $0.01", "", UUID.randomUUID(), 1, 1)));
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate6() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthorID(UUID.randomUUID());
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolverID(UUID.randomUUID());
        reimbursement1.setStatusID(1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setTypeID(1);
        NewReimbursementInsertion newReimbursementInsertion = mock(NewReimbursementInsertion.class);
        when(newReimbursementInsertion.extractEntity()).thenReturn(reimbursement1);
        when(newReimbursementInsertion.getDescription()).thenReturn("The characteristics of someone or something");
        when(newReimbursementInsertion.getAmount()).thenReturn(10.0d);
        doNothing().when(newReimbursementInsertion).setStatusID(anyInt());
        doNothing().when(newReimbursementInsertion).setSubmitted((String) any());
        reimbursementService.generate(newReimbursementInsertion);
        verify(reimbursementRepository).save((Reimbursement) any());
        verify(newReimbursementInsertion).extractEntity();
        verify(newReimbursementInsertion).getAmount();
        verify(newReimbursementInsertion, atLeast(1)).getDescription();
        verify(newReimbursementInsertion).setStatusID(anyInt());
        verify(newReimbursementInsertion).setSubmitted((String) any());
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate7() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        NewReimbursementInsertion newReimbursementInsertion = mock(NewReimbursementInsertion.class);
        when(newReimbursementInsertion.extractEntity()).thenThrow(new ResourceNotFoundException());
        when(newReimbursementInsertion.getDescription()).thenReturn("The characteristics of someone or something");
        when(newReimbursementInsertion.getAmount()).thenReturn(10.0d);
        doNothing().when(newReimbursementInsertion).setStatusID(anyInt());
        doNothing().when(newReimbursementInsertion).setSubmitted((String) any());
        assertThrows(ResourceNotFoundException.class, () -> reimbursementService.generate(newReimbursementInsertion));
        verify(newReimbursementInsertion).extractEntity();
        verify(newReimbursementInsertion).getAmount();
        verify(newReimbursementInsertion, atLeast(1)).getDescription();
        verify(newReimbursementInsertion).setStatusID(anyInt());
        verify(newReimbursementInsertion).setSubmitted((String) any());
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerate8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementService.generate(ReimbursementService.java:80)
        //   See https://diff.blue/R013 to resolve this issue.

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        Reimbursement reimbursement1 = mock(Reimbursement.class);
        when(reimbursement1.getReimbID()).thenReturn(null);
        doNothing().when(reimbursement1).setAmount(anyDouble());
        doNothing().when(reimbursement1).setAuthorID((UUID) any());
        doNothing().when(reimbursement1).setDescription((String) any());
        doNothing().when(reimbursement1).setReimbID((UUID) any());
        doNothing().when(reimbursement1).setResolved((String) any());
        doNothing().when(reimbursement1).setResolverID((UUID) any());
        doNothing().when(reimbursement1).setStatusID(anyInt());
        doNothing().when(reimbursement1).setSubmitted((String) any());
        doNothing().when(reimbursement1).setTypeID(anyInt());
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthorID(UUID.randomUUID());
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolverID(UUID.randomUUID());
        reimbursement1.setStatusID(1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setTypeID(1);
        NewReimbursementInsertion newReimbursementInsertion = mock(NewReimbursementInsertion.class);
        when(newReimbursementInsertion.extractEntity()).thenReturn(reimbursement1);
        when(newReimbursementInsertion.getDescription()).thenReturn("The characteristics of someone or something");
        when(newReimbursementInsertion.getAmount()).thenReturn(10.0d);
        doNothing().when(newReimbursementInsertion).setStatusID(anyInt());
        doNothing().when(newReimbursementInsertion).setSubmitted((String) any());
        reimbursementService.generate(newReimbursementInsertion);
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny() {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport"));
        verify(reimbursementRepository).findReimbursementByReimbID((UUID) any());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny2() {
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(-1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport"));
        verify(reimbursementRepository).findReimbursementByReimbID((UUID) any());
        verify(reimbursement).getStatusID();
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatusID(anyInt());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setTypeID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny3() {
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(Optional.empty());
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        assertThrows(InvalidRequestException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport"));
        verify(reimbursementRepository).findReimbursementByReimbID((UUID) any());
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatusID(anyInt());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setTypeID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny4() {
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> reimbursementService.updateStatusApproveOrDeny(
                new ReimbursementApproveOrDenyAlteration(UUID.randomUUID(), true), "Resolver IDImport"));
        verify(reimbursementRepository).findReimbursementByReimbID((UUID) any());
        verify(reimbursement).getStatusID();
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatusID(anyInt());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setTypeID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny5() {
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class,
                () -> reimbursementService.updateStatusApproveOrDeny(null, "Resolver IDImport"));
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatusID(anyInt());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setTypeID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStatusApproveOrDeny6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementService.updateStatusApproveOrDeny(ReimbursementService.java:94)
        //   See https://diff.blue/R013 to resolve this issue.

        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(null);
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(-1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        reimbursementService.updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport");
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny7() {
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(-1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(ofResult);
        ReimbursementApproveOrDenyAlteration reimbursementApproveOrDenyAlteration = mock(
                ReimbursementApproveOrDenyAlteration.class);
        when(reimbursementApproveOrDenyAlteration.getReimbursementID()).thenThrow(new ResourceNotFoundException());
        assertThrows(ResourceNotFoundException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(reimbursementApproveOrDenyAlteration, "Resolver IDImport"));
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatusID(anyInt());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setTypeID(anyInt());
        verify(reimbursementApproveOrDenyAlteration).getReimbursementID();
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStatusApproveOrDeny8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementService.updateStatusApproveOrDeny(ReimbursementService.java:88)
        //   See https://diff.blue/R013 to resolve this issue.

        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(-1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(ofResult);
        ReimbursementApproveOrDenyAlteration reimbursementApproveOrDenyAlteration = mock(
                ReimbursementApproveOrDenyAlteration.class);
        when(reimbursementApproveOrDenyAlteration.getReimbursementID()).thenThrow(new ResourceNotFoundException());
        reimbursementService.updateStatusApproveOrDeny(reimbursementApproveOrDenyAlteration, null);
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny9() {
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatusID()).thenReturn(-1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatusID(anyInt());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setTypeID(anyInt());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthorID(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolverID(UUID.randomUUID());
        reimbursement.setStatusID(1);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setTypeID(1);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findReimbursementByReimbID((UUID) any())).thenReturn(ofResult);
        ReimbursementApproveOrDenyAlteration reimbursementApproveOrDenyAlteration = mock(
                ReimbursementApproveOrDenyAlteration.class);
        when(reimbursementApproveOrDenyAlteration.getReimbursementID()).thenThrow(new IllegalArgumentException());
        assertThrows(InvalidRequestException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(reimbursementApproveOrDenyAlteration, "Resolver IDImport"));
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatusID(anyInt());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setTypeID(anyInt());
        verify(reimbursementApproveOrDenyAlteration).getReimbursementID();
    }
}

