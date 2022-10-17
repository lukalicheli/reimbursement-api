package com.revature.project2.reimbursements;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ers_reimbursement_statuses")
@Component
public class ReimbursementStatus {
    @Id // indicates a primary key
    @Column(name = "status_id")
    private int statusID;

    @Column(name = "status", nullable = false, unique = true)
    private String status;

    public ReimbursementStatus() {
        super();
    }

    public ReimbursementStatus(int statusID, String status) {
        this.statusID = statusID;
        this.status = status;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementStatus that = (ReimbursementStatus) o;
        return statusID == that.statusID && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusID, status);
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "statusID=" + statusID +
                ", status='" + status + '\'' +
                '}';
    }
}
