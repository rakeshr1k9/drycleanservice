package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@EntityListeners(AuditingEntityListener.class)
public class Order extends ResourceSupport {

    private Long idOrder;
    private Integer orderTotalAmount;
    private Date orderRecievedAt;
    private Date orderShouldDeliverAt;
    private Date orderDeliveredAt;
    private String orderBagNumber;
    private Byte isQuickDeivery;
    private Byte isDeleted;
    private Date orderCat;
    private Date orderUat;

    private Long customerId;
    private Long branchId;
    private Long orderStatusId;
    private Long orderTypeId;

    @Id
    @GeneratedValue
    @Column(name = "id_order", nullable = false)
    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    @Column(name = "order_total_amount", nullable = true)
    public Integer getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Integer orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    @Column(name = "order_recieved_at", nullable = true)
    public Date getOrderRecievedAt() {
        return orderRecievedAt;
    }

    public void setOrderRecievedAt(Date orderRecievedAt) {
        this.orderRecievedAt = orderRecievedAt;
    }

    @Column(name = "order_should_deliver_at", nullable = true)
    public Date getOrderShouldDeliverAt() {
        return orderShouldDeliverAt;
    }

    public void setOrderShouldDeliverAt(Date orderShouldDeliverAt) {
        this.orderShouldDeliverAt = orderShouldDeliverAt;
    }

    @Column(name = "order_delivered_at", nullable = true)
    public Date getOrderDeliveredAt() {
        return orderDeliveredAt;
    }

    public void setOrderDeliveredAt(Date orderDeliveredAt) {
        this.orderDeliveredAt = orderDeliveredAt;
    }

    @Column(name = "order_bag_number", nullable = true, length = 45)
    public String getOrderBagNumber() {
        return orderBagNumber;
    }

    public void setOrderBagNumber(String orderBagNumber) {
        this.orderBagNumber = orderBagNumber;
    }

    @Column(name = "is_quick_delivery", nullable = false)
    public Byte getisQuickDeivery() {
        return isQuickDeivery;
    }

    public void setisQuickDeivery(Byte isQuickDeivery) {
        this.isQuickDeivery = isQuickDeivery;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "order_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getOrderCat() {
        return orderCat;
    }

    public void setOrderCat(Date orderCat) {
        this.orderCat = orderCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "order_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getOrderUat() {
        return orderUat;
    }

    public void setOrderUat(Date orderUat) {
        this.orderUat = orderUat;
    }

    @Column(name = "customer_id", nullable = false)
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Column(name = "branch_id", nullable = false)
    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    @Column(name = "order_status_id", nullable = false)
    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Column(name = "order_type_id", nullable = false)
    public Long getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Long orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
}
