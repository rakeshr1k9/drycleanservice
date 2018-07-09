package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_type", schema = "techstile", catalog = "")
public class OrderType {
    private Integer idOrderType;
    private String orderTypeName;
    private Byte isDeleted;
    private Timestamp orderTypeCat;
    private Timestamp orderTypeUat;

    @Id
    @Column(name = "id_order_type", nullable = false)
    public Integer getIdOrderType() {
        return idOrderType;
    }

    public void setIdOrderType(Integer idOrderType) {
        this.idOrderType = idOrderType;
    }

    @Basic
    @Column(name = "order_type_name", nullable = true, length = 20)
    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
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
    @Column(name = "order_type_cat", nullable = true)
    public Timestamp getOrderTypeCat() {
        return orderTypeCat;
    }

    public void setOrderTypeCat(Timestamp orderTypeCat) {
        this.orderTypeCat = orderTypeCat;
    }

    @Basic
    @Column(name = "order_type_uat", nullable = true)
    public Timestamp getOrderTypeUat() {
        return orderTypeUat;
    }

    public void setOrderTypeUat(Timestamp orderTypeUat) {
        this.orderTypeUat = orderTypeUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderType orderType = (OrderType) o;
        return idOrderType == orderType.idOrderType &&
                isDeleted == orderType.isDeleted &&
                Objects.equals(orderTypeName, orderType.orderTypeName) &&
                Objects.equals(orderTypeCat, orderType.orderTypeCat) &&
                Objects.equals(orderTypeUat, orderType.orderTypeUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOrderType, orderTypeName, isDeleted, orderTypeCat, orderTypeUat);
    }
}
