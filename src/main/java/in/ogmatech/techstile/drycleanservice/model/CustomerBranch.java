package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customer_branch", schema = "techstile", catalog = "")
public class CustomerBranch {
    private Integer idCustomerBranch;
    private Timestamp customerBranchCat;
    private Timestamp customerBranchDat;
    private Branch branchByBranchId;
    private Customer customerByCustomerId;

    @Id
    @Column(name = "id_customer_branch", nullable = false)
    public Integer getIdCustomerBranch() {
        return idCustomerBranch;
    }

    public void setIdCustomerBranch(Integer idCustomerBranch) {
        this.idCustomerBranch = idCustomerBranch;
    }

    @Basic
    @Column(name = "customer_branch_cat", nullable = true)
    public Timestamp getCustomerBranchCat() {
        return customerBranchCat;
    }

    public void setCustomerBranchCat(Timestamp customerBranchCat) {
        this.customerBranchCat = customerBranchCat;
    }

    @Basic
    @Column(name = "customer_branch_dat", nullable = true)
    public Timestamp getCustomerBranchDat() {
        return customerBranchDat;
    }

    public void setCustomerBranchDat(Timestamp customerBranchDat) {
        this.customerBranchDat = customerBranchDat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerBranch that = (CustomerBranch) o;
        return idCustomerBranch == that.idCustomerBranch &&
                Objects.equals(customerBranchCat, that.customerBranchCat) &&
                Objects.equals(customerBranchDat, that.customerBranchDat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomerBranch, customerBranchCat, customerBranchDat);
    }

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id_branch", nullable = false)
    public Branch getBranchByBranchId() {
        return branchByBranchId;
    }

    public void setBranchByBranchId(Branch branchByBranchId) {
        this.branchByBranchId = branchByBranchId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
