package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customer_type", schema = "techstile", catalog = "")
public class CustomerType {
    private Integer idCustomerType;
    private String customerTypeName;
    private Byte isDeleted;
    private Timestamp customerTypeCat;
    private Timestamp customerTypeUat;
    private CustomerBranch customerBranchByCustomerBranchIdCustomerBranch;

    @Id
    @Column(name = "id_customer_type", nullable = false)
    public Integer getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(Integer idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    @Basic
    @Column(name = "customer_type_name", nullable = true, length = 20)
    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Basic
    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Basic
    @Column(name = "customer_type_cat", nullable = true)
    public Timestamp getCustomerTypeCat() {
        return customerTypeCat;
    }

    public void setCustomerTypeCat(Timestamp customerTypeCat) {
        this.customerTypeCat = customerTypeCat;
    }

    @Basic
    @Column(name = "customer_type_uat", nullable = true)
    public Timestamp getCustomerTypeUat() {
        return customerTypeUat;
    }

    public void setCustomerTypeUat(Timestamp customerTypeUat) {
        this.customerTypeUat = customerTypeUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerType that = (CustomerType) o;
        return idCustomerType == that.idCustomerType &&
                isDeleted == that.isDeleted &&
                Objects.equals(customerTypeName, that.customerTypeName) &&
                Objects.equals(customerTypeCat, that.customerTypeCat) &&
                Objects.equals(customerTypeUat, that.customerTypeUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomerType, customerTypeName, isDeleted, customerTypeCat, customerTypeUat);
    }

    @ManyToOne
    @JoinColumn(name = "customer_branch_id_customer_branch", referencedColumnName = "id_customer_branch", nullable = false)
    public CustomerBranch getCustomerBranchByCustomerBranchIdCustomerBranch() {
        return customerBranchByCustomerBranchIdCustomerBranch;
    }

    public void setCustomerBranchByCustomerBranchIdCustomerBranch(CustomerBranch customerBranchByCustomerBranchIdCustomerBranch) {
        this.customerBranchByCustomerBranchIdCustomerBranch = customerBranchByCustomerBranchIdCustomerBranch;
    }
}
