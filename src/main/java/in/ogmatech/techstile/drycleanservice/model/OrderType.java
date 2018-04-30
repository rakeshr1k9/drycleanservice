package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_type")
@EntityListeners(AuditingEntityListener.class)
public class OrderType implements Serializable {

    private Long idOrderType;
    private String orderTypeName;
    private Byte isDeleted;
    private Date orderTypeCat;
    private Date orderTypeUat;
    
    @Id
    @GeneratedValue
    @Column(name = "id_order_type", nullable = false)
    public Long getIdOrderType() {
        return idOrderType;
    }

    public void setIdOrderType(Long idOrderType) {
        this.idOrderType = idOrderType;
    }

    @Column(name = "order_type_name", nullable = true, length = 45)
    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "order_type_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getOrderTypeCat() {
        return orderTypeCat;
    }

    public void setOrderTypeCat(Date orderTypeCat) {
        this.orderTypeCat = orderTypeCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "order_type_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getOrderTypeUat() {
        return orderTypeUat;
    }

    public void setOrderTypeUat(Date orderTypeUat) {
        this.orderTypeUat = orderTypeUat;
    }

}
