package com.revature.project2.reimbursements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.revature.project2.users.User;
import com.revature.project2.users.UserRepository;

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

    @Mock
    private UserRepository userRepository;

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
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        assertEquals(1, reimbursementService.getAllReimbs().size());
        verify(reimbursementRepository).findAll();
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllReimbs3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:35)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllReimbs(ReimbursementService.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenThrow(new ResourceNotFoundException());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        reimbursementService.getAllReimbs();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    void testGetAllReimbs4() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        assertEquals(2, reimbursementService.getAllReimbs().size());
        verify(reimbursementRepository).findAll();
        verify(user2).getUserId();
        verify(user3).getUserId();
        verify(user).getUserId();
        verify(user1).getUserId();
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
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:32)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllReimbs(ReimbursementService.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(null);
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(UUID.randomUUID());

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        reimbursementService.getAllReimbs();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllReimbs6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:35)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllReimbs(ReimbursementService.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(UUID.randomUUID());
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(null);

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        reimbursementService.getAllReimbs();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbs()}
     */
    @Test
    void testGetAllReimbs7() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(UUID.randomUUID());
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(UUID.randomUUID());

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");
        Type type11 = mock(Type.class);
        when(type11.getTypeName()).thenReturn("Type Name");
        doNothing().when(type11).setTypeID(anyInt());
        doNothing().when(type11).setTypeName((String) any());
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        assertEquals(12, reimbursementService.getAllReimbs().size());
        verify(reimbursementRepository).findAll();
        verify(user22).getUserId();
        verify(user23).getUserId();
        verify(type11).getTypeName();
        verify(type11).setTypeID(anyInt());
        verify(type11).setTypeName((String) any());
        verify(user20).getUserId();
        verify(user21).getUserId();
        verify(user18).getUserId();
        verify(user19).getUserId();
        verify(user16).getUserId();
        verify(user17).getUserId();
        verify(user14).getUserId();
        verify(user15).getUserId();
        verify(user12).getUserId();
        verify(user13).getUserId();
        verify(user10).getUserId();
        verify(user11).getUserId();
        verify(user8).getUserId();
        verify(user9).getUserId();
        verify(user6).getUserId();
        verify(user7).getUserId();
        verify(user4).getUserId();
        verify(user5).getUserId();
        verify(user2).getUserId();
        verify(user3).getUserId();
        verify(user).getUserId();
        verify(user1).getUserId();
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
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("No resource found using the provided search parameters.");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("No resource found using the provided search parameters.");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(reimbursementList);
        assertEquals(1, reimbursementService.getAllReimbsByStatus(1).size());
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus3() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenThrow(new ResourceNotFoundException());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("No resource found using the provided search parameters.");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("No resource found using the provided search parameters.");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(reimbursementList);
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllReimbsByStatus(1));
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus4() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("No resource found using the provided search parameters.");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("No resource found using the provided search parameters.");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(null);
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(UUID.randomUUID());

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(reimbursementList);
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllReimbsByStatus(1));
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
        verify(user22).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus5() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("No resource found using the provided search parameters.");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("No resource found using the provided search parameters.");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(UUID.randomUUID());
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(null);

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(reimbursementList);
        assertThrows(InvalidRequestException.class, () -> reimbursementService.getAllReimbsByStatus(1));
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
        verify(user22).getUserId();
        verify(user23).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllReimbsByStatus(int)}
     */
    @Test
    void testGetAllReimbsByStatus6() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("No resource found using the provided search parameters.");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("No resource found using the provided search parameters.");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("No resource found using the provided search parameters.");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("No resource found using the provided search parameters.");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(UUID.randomUUID());
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(UUID.randomUUID());

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");
        Type type11 = mock(Type.class);
        when(type11.getTypeName()).thenReturn("Type Name");
        doNothing().when(type11).setTypeID(anyInt());
        doNothing().when(type11).setTypeName((String) any());
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByStatusStatusID(anyInt())).thenReturn(reimbursementList);
        assertEquals(12, reimbursementService.getAllReimbsByStatus(1).size());
        verify(reimbursementRepository).findAllReimbursementByStatusStatusID(anyInt());
        verify(user22).getUserId();
        verify(user23).getUserId();
        verify(type11).getTypeName();
        verify(type11).setTypeID(anyInt());
        verify(type11).setTypeName((String) any());
        verify(user20).getUserId();
        verify(user21).getUserId();
        verify(user18).getUserId();
        verify(user19).getUserId();
        verify(user16).getUserId();
        verify(user17).getUserId();
        verify(user14).getUserId();
        verify(user15).getUserId();
        verify(user12).getUserId();
        verify(user13).getUserId();
        verify(user10).getUserId();
        verify(user11).getUserId();
        verify(user8).getUserId();
        verify(user9).getUserId();
        verify(user6).getUserId();
        verify(user7).getUserId();
        verify(user4).getUserId();
        verify(user5).getUserId();
        verify(user2).getUserId();
        verify(user3).getUserId();
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbs(String)}
     */
    @Test
    void testGetAllOwnedReimbs() {
        when(reimbursementRepository.findAllReimbursementByAuthorUsername((String) any())).thenReturn(new ArrayList<>());
        assertTrue(reimbursementService.getAllOwnedReimbs("janedoe").isEmpty());
        verify(reimbursementRepository).findAllReimbursementByAuthorUsername((String) any());
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbs(String)}
     */
    @Test
    void testGetAllOwnedReimbs2() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsername((String) any())).thenReturn(reimbursementList);
        assertEquals(1, reimbursementService.getAllOwnedReimbs("janedoe").size());
        verify(reimbursementRepository).findAllReimbursementByAuthorUsername((String) any());
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbs(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbs3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:35)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllOwnedReimbs(ReimbursementService.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenThrow(new ResourceNotFoundException());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsername((String) any())).thenReturn(reimbursementList);
        reimbursementService.getAllOwnedReimbs("janedoe");
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbs(String)}
     */
    @Test
    void testGetAllOwnedReimbs4() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsername((String) any())).thenReturn(reimbursementList);
        assertEquals(2, reimbursementService.getAllOwnedReimbs("janedoe").size());
        verify(reimbursementRepository).findAllReimbursementByAuthorUsername((String) any());
        verify(user2).getUserId();
        verify(user3).getUserId();
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbs(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbs5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:32)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllOwnedReimbs(ReimbursementService.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(null);
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(UUID.randomUUID());

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsername((String) any())).thenReturn(reimbursementList);
        reimbursementService.getAllOwnedReimbs("janedoe");
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbs(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbs6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:35)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllOwnedReimbs(ReimbursementService.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(UUID.randomUUID());
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(null);

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsername((String) any())).thenReturn(reimbursementList);
        reimbursementService.getAllOwnedReimbs("janedoe");
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbs(String)}
     */
    @Test
    void testGetAllOwnedReimbs7() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(UUID.randomUUID());
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(UUID.randomUUID());

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");
        Type type11 = mock(Type.class);
        when(type11.getTypeName()).thenReturn("Type Name");
        doNothing().when(type11).setTypeID(anyInt());
        doNothing().when(type11).setTypeName((String) any());
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsername((String) any())).thenReturn(reimbursementList);
        assertEquals(12, reimbursementService.getAllOwnedReimbs("janedoe").size());
        verify(reimbursementRepository).findAllReimbursementByAuthorUsername((String) any());
        verify(user22).getUserId();
        verify(user23).getUserId();
        verify(type11).getTypeName();
        verify(type11).setTypeID(anyInt());
        verify(type11).setTypeName((String) any());
        verify(user20).getUserId();
        verify(user21).getUserId();
        verify(user18).getUserId();
        verify(user19).getUserId();
        verify(user16).getUserId();
        verify(user17).getUserId();
        verify(user14).getUserId();
        verify(user15).getUserId();
        verify(user12).getUserId();
        verify(user13).getUserId();
        verify(user10).getUserId();
        verify(user11).getUserId();
        verify(user8).getUserId();
        verify(user9).getUserId();
        verify(user6).getUserId();
        verify(user7).getUserId();
        verify(user4).getUserId();
        verify(user5).getUserId();
        verify(user2).getUserId();
        verify(user3).getUserId();
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbsByApprovalStatus(String, int)}
     */
    @Test
    void testGetAllOwnedReimbsByApprovalStatus() {
        when(reimbursementRepository.findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt()))
                .thenReturn(new ArrayList<>());
        assertTrue(reimbursementService.getAllOwnedReimbsByApprovalStatus("janedoe", 1).isEmpty());
        verify(reimbursementRepository).findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt());
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbsByApprovalStatus(String, int)}
     */
    @Test
    void testGetAllOwnedReimbsByApprovalStatus2() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt()))
                .thenReturn(reimbursementList);
        assertEquals(1, reimbursementService.getAllOwnedReimbsByApprovalStatus("janedoe", 1).size());
        verify(reimbursementRepository).findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt());
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbsByApprovalStatus(String, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbsByApprovalStatus3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:35)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllOwnedReimbsByApprovalStatus(ReimbursementService.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenThrow(new ResourceNotFoundException());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt()))
                .thenReturn(reimbursementList);
        reimbursementService.getAllOwnedReimbsByApprovalStatus("janedoe", 1);
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbsByApprovalStatus(String, int)}
     */
    @Test
    void testGetAllOwnedReimbsByApprovalStatus4() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt()))
                .thenReturn(reimbursementList);
        assertEquals(2, reimbursementService.getAllOwnedReimbsByApprovalStatus("janedoe", 1).size());
        verify(reimbursementRepository).findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt());
        verify(user2).getUserId();
        verify(user3).getUserId();
        verify(user).getUserId();
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbsByApprovalStatus(String, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbsByApprovalStatus5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:32)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllOwnedReimbsByApprovalStatus(ReimbursementService.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(null);
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(UUID.randomUUID());

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt()))
                .thenReturn(reimbursementList);
        reimbursementService.getAllOwnedReimbsByApprovalStatus("janedoe", 1);
    }

    /**
     * Method under test: {@link ReimbursementService#getAllOwnedReimbsByApprovalStatus(String, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbsByApprovalStatus6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:35)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
        //       at com.revature.project2.reimbursements.ReimbursementService.getAllOwnedReimbsByApprovalStatus(ReimbursementService.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(user1);
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        User user2 = mock(User.class);
        when(user2.getUserId()).thenReturn(UUID.randomUUID());
        User user3 = mock(User.class);
        when(user3.getUserId()).thenReturn(UUID.randomUUID());

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");

        Reimbursement reimbursement1 = new Reimbursement();
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(user2);
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(user3);
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        User user4 = mock(User.class);
        when(user4.getUserId()).thenReturn(UUID.randomUUID());
        User user5 = mock(User.class);
        when(user5.getUserId()).thenReturn(UUID.randomUUID());

        Status status2 = new Status();
        status2.setStatusID(1);
        status2.setStatusName("Status");

        Type type2 = new Type();
        type2.setTypeID(1);
        type2.setTypeName("Type");

        Reimbursement reimbursement2 = new Reimbursement();
        reimbursement2.setAmount(10.0d);
        reimbursement2.setAuthor(user4);
        reimbursement2.setDescription("The characteristics of someone or something");
        reimbursement2.setReimbID(UUID.randomUUID());
        reimbursement2.setResolved("Resolved");
        reimbursement2.setResolver(user5);
        reimbursement2.setStatus(status2);
        reimbursement2.setSubmitted("Submitted");
        reimbursement2.setType(type2);
        User user6 = mock(User.class);
        when(user6.getUserId()).thenReturn(UUID.randomUUID());
        User user7 = mock(User.class);
        when(user7.getUserId()).thenReturn(UUID.randomUUID());

        Status status3 = new Status();
        status3.setStatusID(1);
        status3.setStatusName("Status");

        Type type3 = new Type();
        type3.setTypeID(1);
        type3.setTypeName("Type");

        Reimbursement reimbursement3 = new Reimbursement();
        reimbursement3.setAmount(10.0d);
        reimbursement3.setAuthor(user6);
        reimbursement3.setDescription("The characteristics of someone or something");
        reimbursement3.setReimbID(UUID.randomUUID());
        reimbursement3.setResolved("Resolved");
        reimbursement3.setResolver(user7);
        reimbursement3.setStatus(status3);
        reimbursement3.setSubmitted("Submitted");
        reimbursement3.setType(type3);
        User user8 = mock(User.class);
        when(user8.getUserId()).thenReturn(UUID.randomUUID());
        User user9 = mock(User.class);
        when(user9.getUserId()).thenReturn(UUID.randomUUID());

        Status status4 = new Status();
        status4.setStatusID(1);
        status4.setStatusName("Status");

        Type type4 = new Type();
        type4.setTypeID(1);
        type4.setTypeName("Type");

        Reimbursement reimbursement4 = new Reimbursement();
        reimbursement4.setAmount(10.0d);
        reimbursement4.setAuthor(user8);
        reimbursement4.setDescription("The characteristics of someone or something");
        reimbursement4.setReimbID(UUID.randomUUID());
        reimbursement4.setResolved("Resolved");
        reimbursement4.setResolver(user9);
        reimbursement4.setStatus(status4);
        reimbursement4.setSubmitted("Submitted");
        reimbursement4.setType(type4);
        User user10 = mock(User.class);
        when(user10.getUserId()).thenReturn(UUID.randomUUID());
        User user11 = mock(User.class);
        when(user11.getUserId()).thenReturn(UUID.randomUUID());

        Status status5 = new Status();
        status5.setStatusID(1);
        status5.setStatusName("Status");

        Type type5 = new Type();
        type5.setTypeID(1);
        type5.setTypeName("Type");

        Reimbursement reimbursement5 = new Reimbursement();
        reimbursement5.setAmount(10.0d);
        reimbursement5.setAuthor(user10);
        reimbursement5.setDescription("The characteristics of someone or something");
        reimbursement5.setReimbID(UUID.randomUUID());
        reimbursement5.setResolved("Resolved");
        reimbursement5.setResolver(user11);
        reimbursement5.setStatus(status5);
        reimbursement5.setSubmitted("Submitted");
        reimbursement5.setType(type5);
        User user12 = mock(User.class);
        when(user12.getUserId()).thenReturn(UUID.randomUUID());
        User user13 = mock(User.class);
        when(user13.getUserId()).thenReturn(UUID.randomUUID());

        Status status6 = new Status();
        status6.setStatusID(1);
        status6.setStatusName("Status");

        Type type6 = new Type();
        type6.setTypeID(1);
        type6.setTypeName("Type");

        Reimbursement reimbursement6 = new Reimbursement();
        reimbursement6.setAmount(10.0d);
        reimbursement6.setAuthor(user12);
        reimbursement6.setDescription("The characteristics of someone or something");
        reimbursement6.setReimbID(UUID.randomUUID());
        reimbursement6.setResolved("Resolved");
        reimbursement6.setResolver(user13);
        reimbursement6.setStatus(status6);
        reimbursement6.setSubmitted("Submitted");
        reimbursement6.setType(type6);
        User user14 = mock(User.class);
        when(user14.getUserId()).thenReturn(UUID.randomUUID());
        User user15 = mock(User.class);
        when(user15.getUserId()).thenReturn(UUID.randomUUID());

        Status status7 = new Status();
        status7.setStatusID(1);
        status7.setStatusName("Status");

        Type type7 = new Type();
        type7.setTypeID(1);
        type7.setTypeName("Type");

        Reimbursement reimbursement7 = new Reimbursement();
        reimbursement7.setAmount(10.0d);
        reimbursement7.setAuthor(user14);
        reimbursement7.setDescription("The characteristics of someone or something");
        reimbursement7.setReimbID(UUID.randomUUID());
        reimbursement7.setResolved("Resolved");
        reimbursement7.setResolver(user15);
        reimbursement7.setStatus(status7);
        reimbursement7.setSubmitted("Submitted");
        reimbursement7.setType(type7);
        User user16 = mock(User.class);
        when(user16.getUserId()).thenReturn(UUID.randomUUID());
        User user17 = mock(User.class);
        when(user17.getUserId()).thenReturn(UUID.randomUUID());

        Status status8 = new Status();
        status8.setStatusID(1);
        status8.setStatusName("Status");

        Type type8 = new Type();
        type8.setTypeID(1);
        type8.setTypeName("Type");

        Reimbursement reimbursement8 = new Reimbursement();
        reimbursement8.setAmount(10.0d);
        reimbursement8.setAuthor(user16);
        reimbursement8.setDescription("The characteristics of someone or something");
        reimbursement8.setReimbID(UUID.randomUUID());
        reimbursement8.setResolved("Resolved");
        reimbursement8.setResolver(user17);
        reimbursement8.setStatus(status8);
        reimbursement8.setSubmitted("Submitted");
        reimbursement8.setType(type8);
        User user18 = mock(User.class);
        when(user18.getUserId()).thenReturn(UUID.randomUUID());
        User user19 = mock(User.class);
        when(user19.getUserId()).thenReturn(UUID.randomUUID());

        Status status9 = new Status();
        status9.setStatusID(1);
        status9.setStatusName("Status");

        Type type9 = new Type();
        type9.setTypeID(1);
        type9.setTypeName("Type");

        Reimbursement reimbursement9 = new Reimbursement();
        reimbursement9.setAmount(10.0d);
        reimbursement9.setAuthor(user18);
        reimbursement9.setDescription("The characteristics of someone or something");
        reimbursement9.setReimbID(UUID.randomUUID());
        reimbursement9.setResolved("Resolved");
        reimbursement9.setResolver(user19);
        reimbursement9.setStatus(status9);
        reimbursement9.setSubmitted("Submitted");
        reimbursement9.setType(type9);
        User user20 = mock(User.class);
        when(user20.getUserId()).thenReturn(UUID.randomUUID());
        User user21 = mock(User.class);
        when(user21.getUserId()).thenReturn(UUID.randomUUID());

        Status status10 = new Status();
        status10.setStatusID(1);
        status10.setStatusName("Status");

        Type type10 = new Type();
        type10.setTypeID(1);
        type10.setTypeName("Type");

        Reimbursement reimbursement10 = new Reimbursement();
        reimbursement10.setAmount(10.0d);
        reimbursement10.setAuthor(user20);
        reimbursement10.setDescription("The characteristics of someone or something");
        reimbursement10.setReimbID(UUID.randomUUID());
        reimbursement10.setResolved("Resolved");
        reimbursement10.setResolver(user21);
        reimbursement10.setStatus(status10);
        reimbursement10.setSubmitted("Submitted");
        reimbursement10.setType(type10);
        User user22 = mock(User.class);
        when(user22.getUserId()).thenReturn(UUID.randomUUID());
        User user23 = mock(User.class);
        when(user23.getUserId()).thenReturn(null);

        Status status11 = new Status();
        status11.setStatusID(1);
        status11.setStatusName("Status");

        Type type11 = new Type();
        type11.setTypeID(1);
        type11.setTypeName("Type");

        Reimbursement reimbursement11 = new Reimbursement();
        reimbursement11.setAmount(10.0d);
        reimbursement11.setAuthor(user22);
        reimbursement11.setDescription("The characteristics of someone or something");
        reimbursement11.setReimbID(UUID.randomUUID());
        reimbursement11.setResolved("Resolved");
        reimbursement11.setResolver(user23);
        reimbursement11.setStatus(status11);
        reimbursement11.setSubmitted("Submitted");
        reimbursement11.setType(type11);

        ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(reimbursement11);
        reimbursementList.add(reimbursement10);
        reimbursementList.add(reimbursement9);
        reimbursementList.add(reimbursement8);
        reimbursementList.add(reimbursement7);
        reimbursementList.add(reimbursement6);
        reimbursementList.add(reimbursement5);
        reimbursementList.add(reimbursement4);
        reimbursementList.add(reimbursement3);
        reimbursementList.add(reimbursement2);
        reimbursementList.add(reimbursement1);
        reimbursementList.add(reimbursement);
        when(reimbursementRepository.findAllReimbursementByAuthorUsernameAndStatusStatusID((String) any(), anyInt()))
                .thenReturn(reimbursementList);
        reimbursementService.getAllOwnedReimbsByApprovalStatus("janedoe", 1);
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
        //       at com.revature.project2.reimbursements.ReimbursementService.generate(ReimbursementService.java:82)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementService.generate(null);
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate3() {
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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));
        NewReimbursementInsertion newReimbursementInsertion = new NewReimbursementInsertion(10.0d,
                "ERROR: can not register reimbursement amount less than $0.01", "The characteristics of someone or something",
                UUID.randomUUID(), 1);

        reimbursementService.generate(newReimbursementInsertion);
        verify(reimbursementRepository).save((Reimbursement) any());
        verify(userRepository).getById((UUID) any());
        assertEquals(1, newReimbursementInsertion.getStatusID());
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate4() {
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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        when(userRepository.getById((UUID) any())).thenThrow(new ResourceNotFoundException());
        assertThrows(ResourceNotFoundException.class,
                () -> reimbursementService.generate(
                        new NewReimbursementInsertion(10.0d, "ERROR: can not register reimbursement amount less than $0.01",
                                "The characteristics of someone or something", UUID.randomUUID(), 1)));
        verify(userRepository).getById((UUID) any());
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate5() {
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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));
        assertThrows(InvalidRequestException.class,
                () -> reimbursementService.generate(new NewReimbursementInsertion(10.0d,
                        "ERROR: can not register reimbursement amount less than $0.01", null, UUID.randomUUID(), 1)));
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
        reimbursement.setAuthor(mock(User.class));
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));
        assertThrows(InvalidRequestException.class,
                () -> reimbursementService.generate(new NewReimbursementInsertion(10.0d,
                        "ERROR: can not register reimbursement amount less than $0.01", "", UUID.randomUUID(), 1)));
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate7() {
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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));

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
        NewReimbursementInsertion newReimbursementInsertion = mock(NewReimbursementInsertion.class);
        when(newReimbursementInsertion.extractEntity()).thenReturn(reimbursement1);
        when(newReimbursementInsertion.getAuthorID()).thenReturn(UUID.randomUUID());
        when(newReimbursementInsertion.getDescription()).thenReturn("The characteristics of someone or something");
        when(newReimbursementInsertion.getAmount()).thenReturn(10.0d);
        doNothing().when(newReimbursementInsertion).setStatusID(anyInt());
        doNothing().when(newReimbursementInsertion).setSubmitted((String) any());
        reimbursementService.generate(newReimbursementInsertion);
        verify(reimbursementRepository).save((Reimbursement) any());
        verify(userRepository).getById((UUID) any());
        verify(newReimbursementInsertion).extractEntity();
        verify(newReimbursementInsertion).getAmount();
        verify(newReimbursementInsertion, atLeast(1)).getDescription();
        verify(newReimbursementInsertion).getAuthorID();
        verify(newReimbursementInsertion).setStatusID(anyInt());
        verify(newReimbursementInsertion).setSubmitted((String) any());
    }

    /**
     * Method under test: {@link ReimbursementService#generate(NewReimbursementInsertion)}
     */
    @Test
    void testGenerate8() {
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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));
        NewReimbursementInsertion newReimbursementInsertion = mock(NewReimbursementInsertion.class);
        when(newReimbursementInsertion.extractEntity()).thenThrow(new IllegalArgumentException());
        when(newReimbursementInsertion.getAuthorID()).thenThrow(new IllegalArgumentException());
        when(newReimbursementInsertion.getDescription()).thenReturn("The characteristics of someone or something");
        when(newReimbursementInsertion.getAmount()).thenReturn(10.0d);
        doNothing().when(newReimbursementInsertion).setStatusID(anyInt());
        doNothing().when(newReimbursementInsertion).setSubmitted((String) any());
        assertThrows(IllegalArgumentException.class, () -> reimbursementService.generate(newReimbursementInsertion));
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
    void testGenerate9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementService.generate(ReimbursementService.java:100)
        //   See https://diff.blue/R013 to resolve this issue.

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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));

        Status status1 = new Status();
        status1.setStatusID(1);
        status1.setStatusName("Status");

        Type type1 = new Type();
        type1.setTypeID(1);
        type1.setTypeName("Type");
        Reimbursement reimbursement1 = mock(Reimbursement.class);
        when(reimbursement1.getReimbID()).thenReturn(null);
        doNothing().when(reimbursement1).setAmount(anyDouble());
        doNothing().when(reimbursement1).setAuthor((User) any());
        doNothing().when(reimbursement1).setDescription((String) any());
        doNothing().when(reimbursement1).setReimbID((UUID) any());
        doNothing().when(reimbursement1).setResolved((String) any());
        doNothing().when(reimbursement1).setResolver((User) any());
        doNothing().when(reimbursement1).setStatus((Status) any());
        doNothing().when(reimbursement1).setSubmitted((String) any());
        doNothing().when(reimbursement1).setType((Type) any());
        reimbursement1.setAmount(10.0d);
        reimbursement1.setAuthor(mock(User.class));
        reimbursement1.setDescription("The characteristics of someone or something");
        reimbursement1.setReimbID(UUID.randomUUID());
        reimbursement1.setResolved("Resolved");
        reimbursement1.setResolver(mock(User.class));
        reimbursement1.setStatus(status1);
        reimbursement1.setSubmitted("Submitted");
        reimbursement1.setType(type1);
        NewReimbursementInsertion newReimbursementInsertion = mock(NewReimbursementInsertion.class);
        when(newReimbursementInsertion.extractEntity()).thenReturn(reimbursement1);
        when(newReimbursementInsertion.getAuthorID()).thenReturn(UUID.randomUUID());
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
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        UUID randomUUIDResult = UUID.randomUUID();
        reimbursement.setReimbID(randomUUIDResult);
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);

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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement1);
        when(reimbursementRepository.findById((UUID) any())).thenReturn(ofResult);
        User user1 = mock(User.class);
        when(user1.getUserId()).thenReturn(UUID.randomUUID());
        when(userRepository.getById((UUID) any())).thenReturn(user1);
        ReimbursementResponse actualUpdateStatusApproveOrDenyResult = reimbursementService
                .updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport");
        assertEquals(10.0d, actualUpdateStatusApproveOrDenyResult.getAmount());
        assertEquals("Type", actualUpdateStatusApproveOrDenyResult.getType());
        assertEquals("Submitted", actualUpdateStatusApproveOrDenyResult.getSubmitted());
        assertEquals("denied", actualUpdateStatusApproveOrDenyResult.getStatus());
        assertSame(randomUUIDResult, actualUpdateStatusApproveOrDenyResult.getReimbID());
        assertEquals("The characteristics of someone or something",
                actualUpdateStatusApproveOrDenyResult.getDescription());
        verify(reimbursementRepository).save((Reimbursement) any());
        verify(reimbursementRepository).findById((UUID) any());
        verify(user, atLeast(1)).getUserId();
        verify(userRepository).getById((UUID) any());
        verify(user1).getUserId();
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStatusApproveOrDeny2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.ResourceNotFoundException: No resource found using the provided search parameters.
        //       at com.revature.project2.reimbursements.ReimbursementResponse.<init>(ReimbursementResponse.java:35)
        //       at com.revature.project2.reimbursements.ReimbursementService.updateStatusApproveOrDeny(ReimbursementService.java:137)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);

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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement1);
        when(reimbursementRepository.findById((UUID) any())).thenReturn(ofResult);
        when(userRepository.getById((UUID) any())).thenReturn(mock(User.class));
        new ResourceNotFoundException();
        reimbursementService.updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport");
    }

    /**
     * Method under test: {@link ReimbursementService#updateStatusApproveOrDeny(ReimbursementApproveOrDenyAlteration, String)}
     */
    @Test
    void testUpdateStatusApproveOrDeny3() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn(UUID.randomUUID());

        Status status = new Status();
        status.setStatusID(1);
        status.setStatusName("Status");

        Type type = new Type();
        type.setTypeID(1);
        type.setTypeName("Type");

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(10.0d);
        reimbursement.setAuthor(user);
        reimbursement.setDescription("The characteristics of someone or something");
        reimbursement.setReimbID(UUID.randomUUID());
        reimbursement.setResolved("Resolved");
        reimbursement.setResolver(mock(User.class));
        reimbursement.setStatus(status);
        reimbursement.setSubmitted("Submitted");
        reimbursement.setType(type);
        Optional<Reimbursement> ofResult = Optional.of(reimbursement);

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
        when(reimbursementRepository.save((Reimbursement) any())).thenReturn(reimbursement1);
        when(reimbursementRepository.findById((UUID) any())).thenReturn(ofResult);
        User user1 = mock(User.class);
        when(user1.getUserId()).thenThrow(new IllegalArgumentException());
        when(userRepository.getById((UUID) any())).thenReturn(user1);
        assertThrows(InvalidRequestException.class, () -> reimbursementService
                .updateStatusApproveOrDeny(new ReimbursementApproveOrDenyAlteration(), "Resolver IDImport"));
        verify(reimbursementRepository).save((Reimbursement) any());
        verify(reimbursementRepository).findById((UUID) any());
        verify(user, atLeast(1)).getUserId();
        verify(userRepository).getById((UUID) any());
        verify(user1).getUserId();
    }
}

