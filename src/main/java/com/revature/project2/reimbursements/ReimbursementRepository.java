package com.revature.project2.reimbursements;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, UUID> {
//    boolean existsByPending(UUID status_id);

    Optional<Reimbursement> findReimbursementByReimbID(UUID id);
    List<Reimbursement> findAllReimbursementByStatusID(int statusIDPending);
}
