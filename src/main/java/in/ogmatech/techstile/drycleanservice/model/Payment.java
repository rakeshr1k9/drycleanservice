package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payment")
@EntityListeners(AuditingEntityListener.class)
public class Payment implements Serializable {

    private Long idPayment;
    private Integer paymentRecievedAmount;
    private Byte isDeleted;
    private Date paymentCat;
    private Date paymentUat;

    private Long orderId;
    private Long paymentTypeId;

    @Id
    @GeneratedValue
    @Column(name = "id_payment", nullable = false)
    public Long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }

    @Column(name = "payment_recieved_amount", nullable = true)
    public Integer getPaymentRecievedAmount() {
        return paymentRecievedAmount;
    }

    public void setPaymentRecievedAmount(Integer paymentRecievedAmount) {
        this.paymentRecievedAmount = paymentRecievedAmount;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "payment_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getPaymentCat() {
        return paymentCat;
    }

    public void setPaymentCat(Date paymentCat) {
        this.paymentCat = paymentCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "payment_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getPaymentUat() {
        return paymentUat;
    }

    public void setPaymentUat(Date paymentUat) {
        this.paymentUat = paymentUat;
    }

    @Column(name = "order_id", nullable = false)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "payment_type_id", nullable = false)
    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }
}
