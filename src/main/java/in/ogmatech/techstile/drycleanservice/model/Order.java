package in.ogmatech.techstile.drycleanservice.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "`order`")
@EntityListeners(AuditingEntityListener.class)
public class Order implements Serializable {
    private Integer idOrder;
    private Integer orderTotalAmount;
    private Date orderReceivedAt;
    private Date orderShouldDeliverAt;
    private Date orderDeliveredAt;
    private Byte isQuickDelivery;
    private Byte isDeleted;
    private Date orderCat;
    private Date orderUat;
    private String customerName;
    private Long customerMobile;
    private Integer orderTotalItem;
    private Integer orderTotalItemCompleted;
    private String customerTypeName;
    private Integer orderNumber;
    private String orderReceivedByUser;
    private String orderUpdatedByUser;
    private String orderDeliveredByUser;
    private Integer branchId;
    private Integer orderStatusId;
    private String orderStatusName;


    @Id
    @Column(name = "id_order", nullable = false)
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "order_total_amount", nullable = true)
    public Integer getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Integer orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    @Basic
    @Column(name = "order_received_at", nullable = true)
    public Date getOrderReceivedAt() {
        return orderReceivedAt;
    }

    public void setOrderReceivedAt(Date orderReceivedAt) {
        this.orderReceivedAt = orderReceivedAt;
    }

    @Basic
    @Column(name = "order_should_deliver_at", nullable = true)
    public Date getOrderShouldDeliverAt() {
        return orderShouldDeliverAt;
    }

    public void setOrderShouldDeliverAt(Date orderShouldDeliverAt) {
        this.orderShouldDeliverAt = orderShouldDeliverAt;
    }

    @Basic
    @Column(name = "order_delivered_at", nullable = true)
    public Date getOrderDeliveredAt() {
        return orderDeliveredAt;
    }

    public void setOrderDeliveredAt(Date orderDeliveredAt) {
        this.orderDeliveredAt = orderDeliveredAt;
    }

    @Basic
    @Column(name = "is_quick_delivery", nullable = false)
    public Byte getIsQuickDelivery() {
        return isQuickDelivery;
    }

    public void setIsQuickDelivery(Byte isQuickDelivery) {
        this.isQuickDelivery = isQuickDelivery;
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
    @Column(name = "order_cat", nullable = true)
    public Date getOrderCat() {
        return orderCat;
    }

    public void setOrderCat(Date orderCat) {
        this.orderCat = orderCat;
    }

    @Basic
    @Column(name = "order_uat", nullable = true)
    public Date getOrderUat() {
        return orderUat;
    }

    public void setOrderUat(Date orderUat) {
        this.orderUat = orderUat;
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
    @Column(name = "customer_mobile", nullable = true)
    public Long getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(Long customerMobile) {
        this.customerMobile = customerMobile;
    }

    @Basic
    @Column(name = "order_total_item", nullable = true)
    public Integer getOrderTotalItem() {
        return orderTotalItem;
    }

    public void setOrderTotalItem(Integer orderTotalItem) {
        this.orderTotalItem = orderTotalItem;
    }

    @Basic
    @Column(name = "order_total_item_completed", nullable = true)
    public Integer getOrderTotalItemCompleted() {
        return orderTotalItemCompleted;
    }

    public void setOrderTotalItemCompleted(Integer orderTotalItemCompleted) {
        this.orderTotalItemCompleted = orderTotalItemCompleted;
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
    @Column(name = "order_number", nullable = true)
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "order_received_by_user", nullable = true, length = 45)
    public String getOrderReceivedByUser() {
        return orderReceivedByUser;
    }

    public void setOrderReceivedByUser(String orderReceivedByUser) {
        this.orderReceivedByUser = orderReceivedByUser;
    }

    @Basic
    @Column(name = "order_updated_by_user", nullable = true, length = 45)
    public String getOrderUpdatedByUser() {
        return orderUpdatedByUser;
    }

    public void setOrderUpdatedByUser(String orderUpdatedByUser) {
        this.orderUpdatedByUser = orderUpdatedByUser;
    }

    @Basic
    @Column(name = "order_delivered_by_user", nullable = true, length = 45)
    public String getOrderDeliveredByUser() {
        return orderDeliveredByUser;
    }

    public void setOrderDeliveredByUser(String orderDeliveredByUser) {
        this.orderDeliveredByUser = orderDeliveredByUser;
    }

    @Column(name = "branch_id", nullable = false)
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    @Column(name = "order_status_id", nullable = false)
    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Column(name = "order_status_name", nullable = true, length = 20)
    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
}
