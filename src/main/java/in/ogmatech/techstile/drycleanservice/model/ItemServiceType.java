package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "item_service_type")
@EntityListeners(AuditingEntityListener.class)
public class ItemServiceType implements Serializable {

    private Long idItemServiceType;
    private Byte isDeleted;
    private Date itemServiceTypeCat;
    private Date itemServiceTypeUat;

    private Long itemId;
    private Long serviceTypeId;

    @Id
    @GeneratedValue
    @Column(name = "id_item_service_type", nullable = false)
    public Long getIdItemServiceType() {
        return idItemServiceType;
    }

    public void setIdItemServiceType(Long idItemServiceType) {
        this.idItemServiceType = idItemServiceType;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_service_type_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemServiceTypeCat() {
        return itemServiceTypeCat;
    }

    public void setItemServiceTypeCat(Date itemServiceTypeCat) {
        this.itemServiceTypeCat = itemServiceTypeCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_service_type_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemServiceTypeUat() {
        return itemServiceTypeUat;
    }

    public void setItemServiceTypeUat(Date itemServiceTypeUat) {
        this.itemServiceTypeUat = itemServiceTypeUat;
    }

    @Column(name = "item_id", nullable = false)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(name = "service_type_id", nullable = false)
    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
