package com.revature.project2.reimbursements;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ers_reimbursement_statuses")
public class Status {
    
    @Id // indicates a primary key
    @Column(name = "status_id")
    private int statusID;

    @Column(name = "status", nullable = false, unique = true)
    private String status;

    public Status() {
        super();
    }

    public Status(int statusID, String status) {
        this.statusID = statusID;
        this.status = status;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return status;
    }

    public void setStatusName(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status that = (Status) o;
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
