package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order_status", schema = "techstile", catalog = "")
public class OrderStatus {
    private Integer idOrderStatus;
    private String orderStatusName;
    private Byte isDeleted;
    private Timestamp orderStatusCat;
    private Timestamp orderStatusUat;
    private Integer orderStatusOrder;

    @Id
    @Column(name = "id_order_status", nullable = false)
    public Integer getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(Integer idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    @Basic
    @Column(name = "order_status_name", nullable = true, length = 20)
    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
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
    @Column(name = "order_status_cat", nullable = true)
    public Timestamp getOrderStatusCat() {
        return orderStatusCat;
    }

    public void setOrderStatusCat(Timestamp orderStatusCat) {
        this.orderStatusCat = orderStatusCat;
    }

    @Basic
    @Column(name = "order_status_uat", nullable = true)
    public Timestamp getOrderStatusUat() {
        return orderStatusUat;
    }

    public void setOrderStatusUat(Timestamp orderStatusUat) {
        this.orderStatusUat = orderStatusUat;
    }

    @Basic
    @Column(name = "order_status_order", nullable = true)
    public Integer getOrderStatusOrder() {
        return orderStatusOrder;
    }

    public void setOrderStatusOrder(Integer orderStatusOrder) {
        this.orderStatusOrder = orderStatusOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return idOrderStatus == that.idOrderStatus &&
                isDeleted == that.isDeleted &&
                Objects.equals(orderStatusName, that.orderStatusName) &&
                Objects.equals(orderStatusCat, that.orderStatusCat) &&
                Objects.equals(orderStatusUat, that.orderStatusUat) &&
                Objects.equals(orderStatusOrder, that.orderStatusOrder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOrderStatus, orderStatusName, isDeleted, orderStatusCat, orderStatusUat, orderStatusOrder);
    }
}
