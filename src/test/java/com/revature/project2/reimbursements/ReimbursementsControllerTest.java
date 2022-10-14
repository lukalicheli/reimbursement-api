package com.revature.project2.reimbursements;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.revature.project2.users.UserResponse;

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


        reimbursementsController.getAllReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllReimbs2() {


        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        reimbursementsController.getAllReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getReimbByID(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReimbByID() {


        reimbursementsController.getReimbByID("42", new StandardSession(new PersistentManager()));
    }

    /**
     * Method under test: {@link ReimbursementsController#getReimbByID(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReimbByID2() {


        reimbursementsController.getReimbByID("42", new StandardSession(mock(StandardManager.class)));
    }

    /**
     * Method under test: {@link ReimbursementsController#getReimbByID(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReimbByID3() {


        reimbursementsController.getReimbByID("42", null);
    }

    /**
     * Method under test: {@link ReimbursementsController#getReimbByID(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReimbByID4() {


        StandardSession standardSession = mock(StandardSession.class);
        when(standardSession.getAttribute((String) any())).thenReturn(null);
        reimbursementsController.getReimbByID("42", standardSession);
    }

    /**
     * Method under test: {@link ReimbursementsController#getReimbByID(String, HttpSession)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReimbByID5() {

        StandardSession standardSession = mock(StandardSession.class);
        when(standardSession.getAttribute((String) any())).thenReturn(mock(UserResponse.class));
        reimbursementsController.getReimbByID("42", standardSession);
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllPendingReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPendingReimbs() {


        reimbursementsController.getAllPendingReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(new Request(new Connector()))))));
    }

    /**
     * Method under test: {@link ReimbursementsController#getAllPendingReimbs(HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPendingReimbs2() {


        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        reimbursementsController.getAllPendingReimbs(new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link ReimbursementsController#generate(NewReimbursementInsertion, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerate() {


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


        NewReimbursementInsertion requestBody = new NewReimbursementInsertion();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        reimbursementsController.generate(requestBody, new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link ReimbursementsController#approveOrDenyReimbByID(ReimbursementApproveOrDenyAlteration, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveOrDenyReimbByID() {


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

        ReimbursementApproveOrDenyAlteration importStatement = new ReimbursementApproveOrDenyAlteration();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean()))
                .thenReturn(new StandardSession(new PersistentManager()));
        reimbursementsController.approveOrDenyReimbByID(importStatement,
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(
                        new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)))));
    }

    /**
     * Method under test: {@link ReimbursementsController#approveOrDenyReimbByID(ReimbursementApproveOrDenyAlteration, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveOrDenyReimbByID3() {


        ReimbursementApproveOrDenyAlteration importStatement = mock(ReimbursementApproveOrDenyAlteration.class);
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getSession(anyBoolean())).thenReturn(mock(StandardSession.class));
        new HttpServletRequestWrapper(
                new HttpServletRequestWrapper(new HttpServletRequestWrapper(defaultMultipartHttpServletRequest)));
        reimbursementsController.approveOrDenyReimbByID(importStatement, null);
    }
}

