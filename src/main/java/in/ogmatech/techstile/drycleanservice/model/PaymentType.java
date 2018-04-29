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
@Table(name = "payment_type")
@EntityListeners(AuditingEntityListener.class)
public class PaymentType {

    private Long idPaymentType;
    private String paymentTypeName;
    private Byte isDeleted;
    private Date paymentTypeCat;
    private Date paymentTypeUat;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_payment_type", nullable = false)
    public Long getIdPaymentType() {
        return idPaymentType;
    }

    public void setIdPaymentType(Long idPaymentType) {
        this.idPaymentType = idPaymentType;
    }

    @Column(name = "payment_type_name", nullable = true, length = 45)
    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "payment_type_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getPaymentTypeCat() {
        return paymentTypeCat;
    }

    public void setPaymentTypeCat(Date paymentTypeCat) {
        this.paymentTypeCat = paymentTypeCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "payment_type_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getPaymentTypeUat() {
        return paymentTypeUat;
    }

    public void setPaymentTypeUat(Date paymentTypeUat) {
        this.paymentTypeUat = paymentTypeUat;
    }
    
}
