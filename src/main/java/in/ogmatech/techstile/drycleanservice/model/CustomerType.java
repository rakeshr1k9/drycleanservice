package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer_type")
@EntityListeners(AuditingEntityListener.class)
public class CustomerType {

    private Long idCustomerType;
    private String customerTypeName;
    private Byte isDeleted;
    private Date customerTypeCat;
    private Date customerTypeUat;
    
    @Id
    @GeneratedValue
    @Column(name = "id_customer_type", nullable = false)
    public Long getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(Long idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    @Column(name = "customer_type_name", nullable = true, length = 45)
    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "customer_type_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getCustomerTypeCat() {
        return customerTypeCat;
    }

    public void setCustomerTypeCat(Date customerTypeCat) {
        this.customerTypeCat = customerTypeCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "customer_type_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getCustomerTypeUat() {
        return customerTypeUat;
    }

    public void setCustomerTypeUat(Date customerTypeUat) {
        this.customerTypeUat = customerTypeUat;
    }
    
}
