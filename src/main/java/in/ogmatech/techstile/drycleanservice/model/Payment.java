package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@EntityListeners(AuditingEntityListener.class)
public class Payment {

    private Long idPayment;
    private Integer paymentRecievedAmount;
    private Byte isDeleted;
    private Date paymentCat;
    private Date paymentUat;

    private Order order;
    private PaymentType paymentType;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id_order")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_type_id", referencedColumnName = "id_payment_type")
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
