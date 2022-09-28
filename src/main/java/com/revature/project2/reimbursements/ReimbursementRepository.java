package com.revature.project2.reimbursements;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, UUID> {
//    boolean existsByPending(UUID status_id);
}
