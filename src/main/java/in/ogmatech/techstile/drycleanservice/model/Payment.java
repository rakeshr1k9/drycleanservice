package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payment {
    private Integer idPayment;
    private Integer paymentAmount;
    private Byte isDeleted;
    private Timestamp paymentCat;
    private Timestamp paymentUat;
    private String paymentManageByUser;
    private Timestamp paymentAt;
    private Order orderByOrderId;
    private Branch branchByBranchId;

    @Id
    @Column(name = "id_payment", nullable = false)
    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    @Basic
    @Column(name = "payment_amount", nullable = true)
    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
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
    @Column(name = "payment_cat", nullable = true)
    public Timestamp getPaymentCat() {
        return paymentCat;
    }

    public void setPaymentCat(Timestamp paymentCat) {
        this.paymentCat = paymentCat;
    }

    @Basic
    @Column(name = "payment_uat", nullable = true)
    public Timestamp getPaymentUat() {
        return paymentUat;
    }

    public void setPaymentUat(Timestamp paymentUat) {
        this.paymentUat = paymentUat;
    }

    @Basic
    @Column(name = "payment_manage_by_user", nullable = true, length = 45)
    public String getPaymentManageByUser() {
        return paymentManageByUser;
    }

    public void setPaymentManageByUser(String paymentManageByUser) {
        this.paymentManageByUser = paymentManageByUser;
    }

    @Basic
    @Column(name = "payment_at", nullable = true)
    public Timestamp getPaymentAt() {
        return paymentAt;
    }

    public void setPaymentAt(Timestamp paymentAt) {
        this.paymentAt = paymentAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return idPayment == payment.idPayment &&
                isDeleted == payment.isDeleted &&
                Objects.equals(paymentAmount, payment.paymentAmount) &&
                Objects.equals(paymentCat, payment.paymentCat) &&
                Objects.equals(paymentUat, payment.paymentUat) &&
                Objects.equals(paymentManageByUser, payment.paymentManageByUser) &&
                Objects.equals(paymentAt, payment.paymentAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPayment, paymentAmount, isDeleted, paymentCat, paymentUat, paymentManageByUser, paymentAt);
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
