package com.revature.project2.reimbursements;

import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;
import org.apache.catalina.session.PersistentManager;
import org.apache.catalina.session.StandardManager;
import org.apache.catalina.session.StandardSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class ReimbursementsControllerTest {
    @Mock
    private ReimbursementService reimbursementService;

    @InjectMocks
    private ReimbursementsController reimbursementsController;

    /**
     * Method under test: {@link ReimbursementsController#getAllReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllReimbs(ReimbursementsController.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllReimbs(ReimbursementsController.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController
                .getAllReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getReimbByID(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReimbByID() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getReimbByID(ReimbursementsController.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getReimbByID("42", new StandardSession(new PersistentManager()));
    }

    /**
     * Method under test: {@link ReimbursementsController#getReimbByID(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReimbByID2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getReimbByID(ReimbursementsController.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getReimbByID("42", new StandardSession(mock(StandardManager.class)));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllPendingReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPendingReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllPendingReimbs(ReimbursementsController.java:56)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllPendingReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllPendingReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPendingReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllPendingReimbs(ReimbursementsController.java:56)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllPendingReimbs(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllDeniedReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllDeniedReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllDeniedReimbs(ReimbursementsController.java:65)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllDeniedReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllDeniedReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllDeniedReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllDeniedReimbs(ReimbursementsController.java:65)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController
                .getAllDeniedReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllApprovedReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllApprovedReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllApprovedReimbs(ReimbursementsController.java:74)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllApprovedReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllApprovedReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllApprovedReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllApprovedReimbs(ReimbursementsController.java:74)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllApprovedReimbs(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedReimbs(ReimbursementsController.java:83)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedReimbs("janedoe", new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedReimbs(ReimbursementsController.java:83)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedReimbs("janedoe",
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedPendingReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedPendingReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedPendingReimbs(ReimbursementsController.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedPendingReimbs("janedoe",
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedPendingReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedPendingReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedPendingReimbs(ReimbursementsController.java:93)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedPendingReimbs("janedoe",
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedDeniedReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedDeniedReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedDeniedReimbs(ReimbursementsController.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedDeniedReimbs("janedoe",
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedDeniedReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedDeniedReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedDeniedReimbs(ReimbursementsController.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedDeniedReimbs("janedoe",
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedApprovedReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedApprovedReimbs() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedApprovedReimbs(ReimbursementsController.java:113)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedApprovedReimbs("janedoe",
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllOwnedApprovedReimbs(String, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllOwnedApprovedReimbs2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.getAllOwnedApprovedReimbs(ReimbursementsController.java:113)
        //   See https://diff.blue/R013 to resolve this issue.

        reimbursementsController.getAllOwnedApprovedReimbs("janedoe",
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#generate(NewReimbursementInsertion, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerate() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.generate(ReimbursementsController.java:124)
        //   See https://diff.blue/R013 to resolve this issue.

        NewReimbursementInsertion requestBody = new NewReimbursementInsertion();
        reimbursementsController.generate(requestBody, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#generate(NewReimbursementInsertion, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.revature.project2.common.exceptions.AuthenticationException: Could not find HTTP session on request. Please log in to access this endpoint.
        //       at com.revature.project2.common.SecurityUtils.enforceAuthentication(SecurityUtils.java:17)
        //       at com.revature.project2.reimbursements.ReimbursementsController.generate(ReimbursementsController.java:124)
        //   See https://diff.blue/R013 to resolve this issue.

        NewReimbursementInsertion requestBody = new NewReimbursementInsertion();
        reimbursementsController.generate(requestBody,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#approveOrDenyReimbByID(ReimbursementApproveOrDenyAlteration, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveOrDenyReimbByID() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementsController.approveOrDenyReimbByID(ReimbursementsController.java:139)
        //   See https://diff.blue/R013 to resolve this issue.

        ReimbursementApproveOrDenyAlteration importStatement = new ReimbursementApproveOrDenyAlteration();
        reimbursementsController.approveOrDenyReimbByID(importStatement,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#approveOrDenyReimbByID(ReimbursementApproveOrDenyAlteration, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveOrDenyReimbByID2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.revature.project2.reimbursements.ReimbursementsController.approveOrDenyReimbByID(ReimbursementsController.java:139)
        //   See https://diff.blue/R013 to resolve this issue.

        ReimbursementApproveOrDenyAlteration importStatement = new ReimbursementApproveOrDenyAlteration();
        reimbursementsController.approveOrDenyReimbByID(importStatement,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class))))));
    }
}

