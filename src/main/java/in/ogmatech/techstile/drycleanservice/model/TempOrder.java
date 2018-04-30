package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "temp_order")
@EntityListeners(AuditingEntityListener.class)
public class TempOrder implements Serializable {

    private Long idTempOrder;
    private Long tempOrderNumber;
    private Date tempOrderReceivedAt;
    private Byte isDeleted;
    private Date tempOrderCat;
    private Date tempOrderUat;

    private Long orderId;

    @Id
    @GeneratedValue
    @Column(name = "id_temp_order", nullable = false)
    public Long getIdTempOrder() {
        return idTempOrder;
    }

    public void setIdTempOrder(Long idTempOrder) {
        this.idTempOrder = idTempOrder;
    }

    @Column(name = "temp_order_number", nullable = true)
    public Long getTempOrderNumber() {
        return tempOrderNumber;
    }

    public void setTempOrderNumber(Long tempOrderNumber) {
        this.tempOrderNumber = tempOrderNumber;
    }

    @Column(name = "temp_order_received_at", nullable = true)
    public Date getTempOrderReceivedAt() {
        return tempOrderReceivedAt;
    }

    public void setTempOrderReceivedAt(Date tempOrderReceivedAt) {
        this.tempOrderReceivedAt = tempOrderReceivedAt;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "temp_order_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getTempOrderCat() {
        return tempOrderCat;
    }

    public void setTempOrderCat(Date tempOrderCat) {
        this.tempOrderCat = tempOrderCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "temp_order_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getTempOrderUat() {
        return tempOrderUat;
    }

    public void setTempOrderUat(Date tempOrderUat) {
        this.tempOrderUat = tempOrderUat;
    }

    @Column(name = "order_id", nullable = false)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
