package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_status")
@EntityListeners(AuditingEntityListener.class)
public class OrderStatus implements Serializable {

    private Long idOrderStatus;
    private String orderStatusName;
    private Byte isDeleted;
    private Date orderStatusCat;
    private Date orderStatusUat;
    private Integer orderStatusOrder;

    @Id
    @GeneratedValue
    @Column(name = "id_order_status", nullable = false)
    public Long getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(Long idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    @Column(name = "order_status_name", nullable = true, length = 45)
    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "order_status_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getOrderStatusCat() {
        return orderStatusCat;
    }

    public void setOrderStatusCat(Date orderStatusCat) {
        this.orderStatusCat = orderStatusCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "order_status_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getOrderStatusUat() {
        return orderStatusUat;
    }

    public void setOrderStatusUat(Date orderStatusUat) {
        this.orderStatusUat = orderStatusUat;
    }

    @Column(name = "order_status_order", nullable = true)
    public Integer getOrderStatusOrder() {
        return orderStatusOrder;
    }

    public void setOrderStatusOrder(Integer orderStatusOrder) {
        this.orderStatusOrder = orderStatusOrder;
    }

}
