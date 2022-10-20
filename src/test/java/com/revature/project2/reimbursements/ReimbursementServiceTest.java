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
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

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
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
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
        reimbursement1.setAuthor(UUID.randomUUID());
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(UUID.randomUUID());
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);

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
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllReimbs5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:34)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllReimbs(ReimbursementService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getType()).thenThrow(new ResourceNotFoundException());
        when(reimbursement.getStatus()).thenReturn(status1);
        when(reimbursement.getAmount()).thenReturn(10.0d);
        when(reimbursement.getDescription()).thenReturn("The characteristics of someone or something");
        when(reimbursement.getResolved()).thenReturn("Resolved");
        when(reimbursement.getSubmitted()).thenReturn("Submitted");
        when(reimbursement.getAuthor()).thenReturn(UUID.randomUUID());
        when(reimbursement.getReimbID()).thenReturn(UUID.randomUUID());
        when(reimbursement.getResolver()).thenReturn(UUID.randomUUID());
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatus((Status) any());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setType((Type) any());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        reimbursementService.getAllReimbs();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus() {
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(new ArrayList<>());
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllReimbsByStatus(1));
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus2() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("No resource found using the provided search parameters.");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("No resource found using the provided search parameters.");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(reimbursementList);
        assertEquals(1, reimbursementService.getAllReimbsByStatus(1).size());
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus3() {
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt()))
                .thenThrow(new ResourceNotFoundException());
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllReimbsByStatus(1));
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus4() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("No resource found using the provided search parameters.");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("No resource found using the provided search parameters.");

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getType()).thenThrow(new ResourceNotFoundException());
        when(reimbursement.getStatus()).thenReturn(status1);
        when(reimbursement.getAmount()).thenReturn(10.0d);
        when(reimbursement.getDescription()).thenReturn("The characteristics of someone or something");
        when(reimbursement.getResolved()).thenReturn("Resolved");
        when(reimbursement.getSubmitted()).thenReturn("Submitted");
        when(reimbursement.getAuthor()).thenReturn(UUID.randomUUID());
        when(reimbursement.getReimbID()).thenReturn(UUID.randomUUID());
        when(reimbursement.getResolver()).thenReturn(UUID.randomUUID());
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatus((Status) any());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setType((Type) any());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(reimbursementList);
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllReimbsByStatus(1));
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
        verify(reimbursement).getStatus();
        verify(reimbursement).getType();
        verify(reimbursement).getAmount();
        verify(reimbursement).getDescription();
        verify(reimbursement).getResolved();
        verify(reimbursement).getSubmitted();
        verify(reimbursement).getAuthorID();
        verify(reimbursement).getReimbID();
        verify(reimbursement).getResolverID();
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatus((Status) any());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setType((Type) any());
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
    void testGenerate6() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(UUID.randomUUID());
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(UUID.randomUUID());
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
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
    @Disabled("TODO: Complete this test")
    void testGenerate8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementService.generate(ReimbursementService.java:80)
        //   See https://diff.blue/R013 to resolve this issue.

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");
        Reimbursement reimbursement1 = mock(Reimbursement.class);
        when(reimbursement1.getReimbID()).thenReturn(null);
        doNothing().when(reimbursement1).setAmount(anyDouble());
        doNothing().when(reimbursement1).setAuthorID((UUID) any());
        doNothing().when(reimbursement1).setDescription((String) any());
        doNothing().when(reimbursement1).setReimbID((UUID) any());
        doNothing().when(reimbursement1).setResolved((String) any());
        doNothing().when(reimbursement1).setResolverID((UUID) any());
        doNothing().when(reimbursement1).setStatus((Status) any());
        doNothing().when(reimbursement1).setSubmitted((String) any());
        doNothing().when(reimbursement1).setType((Type) any());
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(UUID.randomUUID());
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(UUID.randomUUID());
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
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
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findById((UUID) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport"));
        verify(reimbursementRepository).findById((UUID) any());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny2() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        Status status1 = mock(Status.class);
        when(status1.getStatusID()).thenReturn(-1);
        doNothing().when(status1).setStatusID(anyInt());
        doNothing().when(status1).setStatusName((String) any());
        status1.setStatusID(1);
        status1.setStatusName("Status");
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatus()).thenReturn(status1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatus((Status) any());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setType((Type) any());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findById((UUID) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport"));
        verify(reimbursementRepository).findById((UUID) any());
        verify(reimbursement).getStatus();
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatus((Status) any());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setType((Type) any());
        verify(status1).getStatusID();
        verify(status1).setStatusID(anyInt());
        verify(status1).setStatusName((String) any());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */


    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny4() {
        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        Status status1 = mock(Status.class);
        when(status1.getStatusID()).thenReturn(1);
        doNothing().when(status1).setStatusID(anyInt());
        doNothing().when(status1).setStatusName((String) any());
        status1.setStatusID(1);
        status1.setStatusName("Status");
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatus()).thenReturn(status1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatus((Status) any());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setType((Type) any());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findById((UUID) any())).thenReturn(ofResult);
        assertThrows(InvalidRequestException.class, () -> reimbursementService.updateStatusApproveOrDeny(
                new ReimbursementApproveOrDenyAlteration(UUID.randomUUID(), true), "Resolver IDImport"));
        verify(reimbursementRepository).findById((UUID) any());
        verify(reimbursement).getStatus();
        verify(reimbursement).setAmount(anyDouble());
        verify(reimbursement).setAuthorID((UUID) any());
        verify(reimbursement).setDescription((String) any());
        verify(reimbursement).setReimbID((UUID) any());
        verify(reimbursement).setResolved((String) any());
        verify(reimbursement).setResolverID((UUID) any());
        verify(reimbursement).setStatus((Status) any());
        verify(reimbursement).setSubmitted((String) any());
        verify(reimbursement).setType((Type) any());
        verify(status1).getStatusID();
        verify(status1).setStatusID(anyInt());
        verify(status1).setStatusName((String) any());
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */


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

        when(reimbursementRepository.findById((UUID) any())).thenReturn(null);

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        Status status1 = mock(Status.class);
        when(status1.getStatusID()).thenReturn(-1);
        doNothing().when(status1).setStatusID(anyInt());
        doNothing().when(status1).setStatusName((String) any());
        status1.setStatusID(1);
        status1.setStatusName("Status");
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatus()).thenReturn(status1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatus((Status) any());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setType((Type) any());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        reimbursementService.updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport");
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */


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

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");
        Status status1 = mock(Status.class);
        when(status1.getStatusID()).thenReturn(-1);
        doNothing().when(status1).setStatusID(anyInt());
        doNothing().when(status1).setStatusName((String) any());
        status1.setStatusID(1);
        status1.setStatusName("Status");
        Reimbursement reimbursement = mock(Reimbursement.class);
        when(reimbursement.getStatus()).thenReturn(status1);
        doNothing().when(reimbursement).setAmount(anyDouble());
        doNothing().when(reimbursement).setAuthorID((UUID) any());
        doNothing().when(reimbursement).setDescription((String) any());
        doNothing().when(reimbursement).setReimbID((UUID) any());
        doNothing().when(reimbursement).setResolved((String) any());
        doNothing().when(reimbursement).setResolverID((UUID) any());
        doNothing().when(reimbursement).setStatus((Status) any());
        doNothing().when(reimbursement).setSubmitted((String) any());
        doNothing().when(reimbursement).setType((Type) any());
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(UUID.randomUUID());
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(UUID.randomUUID());
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);
        when(reimbursementRepository.findById((UUID) any())).thenReturn(ofResult);
        ReimbursementApproveOrDenyAlteration reimbursementApproveOrDenyAlteration = mock(
                ReimbursementApproveOrDenyAlteration.class);
        when(reimbursementApproveOrDenyAlteration.getReimbursementID()).thenThrow(new ResourceNotFoundException());
        reimbursementService.updateStatusApproveOrDeny(reimbursementApproveOrDenyAlteration, null);
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
}

