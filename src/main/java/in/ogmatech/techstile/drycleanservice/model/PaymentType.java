package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "payment_type", schema = "techstile", catalog = "")
public class PaymentType {
    private Integer idPaymentType;
    private String paymentTypeName;
    private Byte isDeleted;
    private Timestamp paymentTypeCat;
    private Timestamp paymentTypeUat;

    @Id
    @Column(name = "id_payment_type", nullable = false)
    public Integer getIdPaymentType() {
        return idPaymentType;
    }

    public void setIdPaymentType(Integer idPaymentType) {
        this.idPaymentType = idPaymentType;
    }

    @Basic
    @Column(name = "payment_type_name", nullable = true, length = 20)
    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
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
    @Column(name = "payment_type_cat", nullable = true)
    public Timestamp getPaymentTypeCat() {
        return paymentTypeCat;
    }

    public void setPaymentTypeCat(Timestamp paymentTypeCat) {
        this.paymentTypeCat = paymentTypeCat;
    }

    @Basic
    @Column(name = "payment_type_uat", nullable = true)
    public Timestamp getPaymentTypeUat() {
        return paymentTypeUat;
    }

    public void setPaymentTypeUat(Timestamp paymentTypeUat) {
        this.paymentTypeUat = paymentTypeUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentType that = (PaymentType) o;
        return idPaymentType == that.idPaymentType &&
                isDeleted == that.isDeleted &&
                Objects.equals(paymentTypeName, that.paymentTypeName) &&
                Objects.equals(paymentTypeCat, that.paymentTypeCat) &&
                Objects.equals(paymentTypeUat, that.paymentTypeUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPaymentType, paymentTypeName, isDeleted, paymentTypeCat, paymentTypeUat);
    }
}
