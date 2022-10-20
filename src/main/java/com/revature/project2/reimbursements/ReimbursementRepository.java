package com.revature.project2.reimbursements;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, UUID> {

    List<Reimbursement> findAllReimbursementByStatusStatusID(int statusID);
    List<Reimbursement> findAllReimbursementByAuthorUsername(String author);
    List<Reimbursement> findAllReimbursementByAuthorUsernameAndStatusStatusID(String author, int statusID);
}
