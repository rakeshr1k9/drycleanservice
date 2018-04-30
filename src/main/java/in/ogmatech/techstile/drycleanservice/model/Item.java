package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "item")
@EntityListeners(AuditingEntityListener.class)
public class Item extends ResourceSupport {

    private Long idItem;
    private String itemQrCode;
    private Integer itemTotalAmount;
    private Date itemShouldDeliverAt;
    private Date itemDeliveredAt;
    private Byte isQuickDelivery;
    private Byte isDeleted;
    private Date itemCat;
    private Date itemUat;

    private Order order;
    private ItemType itemType;
    private ItemStatus itemStatus;

    private List<ItemRemark> itemRemarks;
    private List<ItemServiceType> itemServiceTypes;
    private List<ItemDyeingColor> itemDyeingColors;
    private List<ItemServiceScan> itemServiceScans;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id_order")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_type_id", referencedColumnName = "id_item_type")
    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_status_id", referencedColumnName = "id_item_status")
    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    public List<ItemRemark> getItemRemarks() {
        return itemRemarks;
    }

    public void setItemRemarks(List<ItemRemark> itemRemarks) {
        this.itemRemarks = itemRemarks;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    public List<ItemServiceType> getItemServiceTypes() {
        return itemServiceTypes;
    }

    public void setItemServiceTypes(List<ItemServiceType> itemServiceTypes) {
        this.itemServiceTypes = itemServiceTypes;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    public List<ItemDyeingColor> getItemDyeingColors() {
        return itemDyeingColors;
    }

    public void setItemDyeingColors(List<ItemDyeingColor> itemDyeingColors) {
        this.itemDyeingColors = itemDyeingColors;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    public List<ItemServiceScan> getItemServiceScans() {
        return itemServiceScans;
    }

    public void setItemServiceScans(List<ItemServiceScan> itemServiceScans) {
        this.itemServiceScans = itemServiceScans;
    }
}
