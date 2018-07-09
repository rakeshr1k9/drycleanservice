package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Customer {
    private Integer idCustomer;
    private Long customerMobile;
    private String customerName;
    private Byte isDeleted;
    private Timestamp customerCat;
    private Timestamp customerUat;
    private String customerAddress;

    @Id
    @Column(name = "id_customer", nullable = false)
    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Basic
    @Column(name = "customer_mobile", nullable = true)
    public Long getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(Long customerMobile) {
        this.customerMobile = customerMobile;
    }

    @Basic
    @Column(name = "customer_name", nullable = true, length = 45)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
    @Column(name = "customer_cat", nullable = true)
    public Timestamp getCustomerCat() {
        return customerCat;
    }

    public void setCustomerCat(Timestamp customerCat) {
        this.customerCat = customerCat;
    }

    @Basic
    @Column(name = "customer_uat", nullable = true)
    public Timestamp getCustomerUat() {
        return customerUat;
    }

    public void setCustomerUat(Timestamp customerUat) {
        this.customerUat = customerUat;
    }

    @Basic
    @Column(name = "customer_address", nullable = true, length = 60)
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return idCustomer == customer.idCustomer &&
                isDeleted == customer.isDeleted &&
                Objects.equals(customerMobile, customer.customerMobile) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(customerCat, customer.customerCat) &&
                Objects.equals(customerUat, customer.customerUat) &&
                Objects.equals(customerAddress, customer.customerAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCustomer, customerMobile, customerName, isDeleted, customerCat, customerUat, customerAddress);
    }
}
