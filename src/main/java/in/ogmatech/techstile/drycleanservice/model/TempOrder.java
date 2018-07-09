package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "temp_order", schema = "techstile", catalog = "")
public class TempOrder {
    private Integer idTempOrder;
    private Integer tempOrderNumber;
    private Timestamp tempOrderReceivedAt;
    private Byte isDeleted;
    private Timestamp tempOrderCat;
    private Timestamp tempOrderUat;
    private Order orderByOrderId;
    private Branch branchByBranchId;

    @Id
    @Column(name = "id_temp_order", nullable = false)
    public Integer getIdTempOrder() {
        return idTempOrder;
    }

    public void setIdTempOrder(Integer idTempOrder) {
        this.idTempOrder = idTempOrder;
    }

    @Basic
    @Column(name = "temp_order_number", nullable = true)
    public Integer getTempOrderNumber() {
        return tempOrderNumber;
    }

    public void setTempOrderNumber(Integer tempOrderNumber) {
        this.tempOrderNumber = tempOrderNumber;
    }

    @Basic
    @Column(name = "temp_order_received_at", nullable = true)
    public Timestamp getTempOrderReceivedAt() {
        return tempOrderReceivedAt;
    }

    public void setTempOrderReceivedAt(Timestamp tempOrderReceivedAt) {
        this.tempOrderReceivedAt = tempOrderReceivedAt;
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
    @Column(name = "temp_order_cat", nullable = true)
    public Timestamp getTempOrderCat() {
        return tempOrderCat;
    }

    public void setTempOrderCat(Timestamp tempOrderCat) {
        this.tempOrderCat = tempOrderCat;
    }

    @Basic
    @Column(name = "temp_order_uat", nullable = true)
    public Timestamp getTempOrderUat() {
        return tempOrderUat;
    }

    public void setTempOrderUat(Timestamp tempOrderUat) {
        this.tempOrderUat = tempOrderUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempOrder tempOrder = (TempOrder) o;
        return idTempOrder == tempOrder.idTempOrder &&
                isDeleted == tempOrder.isDeleted &&
                Objects.equals(tempOrderNumber, tempOrder.tempOrderNumber) &&
                Objects.equals(tempOrderReceivedAt, tempOrder.tempOrderReceivedAt) &&
                Objects.equals(tempOrderCat, tempOrder.tempOrderCat) &&
                Objects.equals(tempOrderUat, tempOrder.tempOrderUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTempOrder, tempOrderNumber, tempOrderReceivedAt, isDeleted, tempOrderCat, tempOrderUat);
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id_order", nullable = false)
    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id_branch", nullable = false)
    public Branch getBranchByBranchId() {
        return branchByBranchId;
    }

    public void setBranchByBranchId(Branch branchByBranchId) {
        this.branchByBranchId = branchByBranchId;
    }
}
