package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "item")
@EntityListeners(AuditingEntityListener.class)
public class Item extends ResourceSupport implements Serializable {

    private Long idItem;
    private String itemQrCode;
    private Integer itemTotalAmount;
    private Date itemShouldDeliverAt;
    private Date itemDeliveredAt;
    private Byte isQuickDelivery;
    private Byte isDeleted;
    private Date itemCat;
    private Date itemUat;

    private Long orderId;
    private Long itemTypeId;
    private Long itemStatusId;

    @Id
    @GeneratedValue
    @Column(name = "id_item", nullable = false)
    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    @Column(name = "item_qr_code", nullable = true, length = 45)
    public String getItemQrCode() {
        return itemQrCode;
    }

    public void setItemQrCode(String itemQrCode) {
        this.itemQrCode = itemQrCode;
    }

    @Column(name = "item_total_amount", nullable = true)
    public Integer getItemTotalAmount() {
        return itemTotalAmount;
    }

    public void setItemTotalAmount(Integer itemTotalAmount) {
        this.itemTotalAmount = itemTotalAmount;
    }

    @Column(name = "item_should_deliver_at", nullable = true)
    public Date getItemShouldDeliverAt() {
        return itemShouldDeliverAt;
    }

    public void setItemShouldDeliverAt(Date itemShouldDeliverAt) {
        this.itemShouldDeliverAt = itemShouldDeliverAt;
    }

    @Column(name = "item_delivered_at", nullable = true)
    public Date getItemDeliveredAt() {
        return itemDeliveredAt;
    }

    public void setItemDeliveredAt(Date itemDeliveredAt) {
        this.itemDeliveredAt = itemDeliveredAt;
    }

    @Column(name = "is_quick_delivery", nullable = true)
    public Byte getIsQuickDelivery() {
        return isQuickDelivery;
    }

    public void setIsQuickDelivery(Byte isQuickDelivery) {
        this.isQuickDelivery = isQuickDelivery;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemCat() {
        return itemCat;
    }

    public void setItemCat(Date itemCat) {
        this.itemCat = itemCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemUat() {
        return itemUat;
    }

    public void setItemUat(Date itemUat) {
        this.itemUat = itemUat;
    }

    @Column(name = "order_id", nullable = false)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "item_type_id", nullable = false)
    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    @Column(name = "item_status_id", nullable = false)
    public Long getItemStatusId() {
        return itemStatusId;
    }

    public void setItemStatusId(Long itemStatusId) {
        this.itemStatusId = itemStatusId;
    }

}
