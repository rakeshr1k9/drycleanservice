package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item_type_service_price")
@EntityListeners(AuditingEntityListener.class)
public class ItemTypeServicePrice {

    private Long idItemTypeServicePrice;
    private String itemTypeServicePrice;
    private Byte isDeleted;
    private Date itemTypeServicePriceCat;
    private Date itemTypeServicePriceUat;

    private Long itemTypeId;
    private Long serviceTypeId;

    @Id
    @GeneratedValue
    @Column(name = "id_item_type_service_price", nullable = false)
    public Long getIdItemTypeServicePrice() {
        return idItemTypeServicePrice;
    }

    public void setIdItemTypeServicePrice(Long idItemTypeServicePrice) {
        this.idItemTypeServicePrice = idItemTypeServicePrice;
    }

    @Column(name = "item_type_service_price", nullable = true, length = 45)
    public String getItemTypeServicePrice() {
        return itemTypeServicePrice;
    }

    public void setItemTypeServicePrice(String itemTypeServicePrice) {
        this.itemTypeServicePrice = itemTypeServicePrice;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_type_service_price_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemTypeServicePriceCat() {
        return itemTypeServicePriceCat;
    }

    public void setItemTypeServicePriceCat(Date itemTypeServicePriceCat) {
        this.itemTypeServicePriceCat = itemTypeServicePriceCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_type_service_price_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemTypeServicePriceUat() {
        return itemTypeServicePriceUat;
    }

    public void setItemTypeServicePriceUat(Date itemTypeServicePriceUat) {
        this.itemTypeServicePriceUat = itemTypeServicePriceUat;
    }

    @Column(name = "item_type_id", nullable = false)
    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    @Column(name = "service_type_id", nullable = false)
    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
