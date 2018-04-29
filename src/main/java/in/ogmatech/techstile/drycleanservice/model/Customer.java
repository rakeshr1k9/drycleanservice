package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer extends ResourceSupport {

    private Long idCustomer;
    private Long customerMobile;
    private String customerName;
    private Byte isDeleted;
    private Date customerCat;
    private Date customerUat;
    private Long customerTypeId;

    @Id
    @GeneratedValue
    @Column(name = "id_customer", nullable = false)
    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Column(name = "customer_mobile", nullable = true, precision = 0)
    public Long getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(Long customerMobile) {
        this.customerMobile = customerMobile;
    }

    @Column(name = "customer_name", nullable = true, length = 45)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "customer_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getCustomerCat() {
        return customerCat;
    }

    public void setCustomerCat(Date customerCat) {
        this.customerCat = customerCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "customer_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getCustomerUat() {
        return customerUat;
    }

    public void setCustomerUat(Date customerUat) {
        this.customerUat = customerUat;
    }

    @Column(name = "customer_type_id", nullable = false)
    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
