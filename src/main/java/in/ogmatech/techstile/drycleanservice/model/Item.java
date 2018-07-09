package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Item {
    private Integer idItem;
    private Integer itemQrNumber;
    private Integer itemTotalAmount;
    private Timestamp itemShouldDeliverAt;
    private Timestamp itemDeliveredAt;
    private Byte isQuickDelivery;
    private Byte isDeleted;
    private Timestamp itemCat;
    private Timestamp itemUat;
    private String itemUpdatedByUser;
    private Branch branchByBranchId;

    @Id
    @Column(name = "id_item", nullable = false)
    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    @Basic
    @Column(name = "item_qr_number", nullable = true)
    public Integer getItemQrNumber() {
        return itemQrNumber;
    }

    public void setItemQrNumber(Integer itemQrNumber) {
        this.itemQrNumber = itemQrNumber;
    }

    @Basic
    @Column(name = "item_total_amount", nullable = true)
    public Integer getItemTotalAmount() {
        return itemTotalAmount;
    }

    public void setItemTotalAmount(Integer itemTotalAmount) {
        this.itemTotalAmount = itemTotalAmount;
    }

    @Basic
    @Column(name = "item_should_deliver_at", nullable = true)
    public Timestamp getItemShouldDeliverAt() {
        return itemShouldDeliverAt;
    }

    public void setItemShouldDeliverAt(Timestamp itemShouldDeliverAt) {
        this.itemShouldDeliverAt = itemShouldDeliverAt;
    }

    @Basic
    @Column(name = "item_delivered_at", nullable = true)
    public Timestamp getItemDeliveredAt() {
        return itemDeliveredAt;
    }

    public void setItemDeliveredAt(Timestamp itemDeliveredAt) {
        this.itemDeliveredAt = itemDeliveredAt;
    }

    @Basic
    @Column(name = "is_quick_delivery", nullable = true)
    public Byte getIsQuickDelivery() {
        return isQuickDelivery;
    }

    public void setIsQuickDelivery(Byte isQuickDelivery) {
        this.isQuickDelivery = isQuickDelivery;
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
    @Column(name = "item_cat", nullable = true)
    public Timestamp getItemCat() {
        return itemCat;
    }

    public void setItemCat(Timestamp itemCat) {
        this.itemCat = itemCat;
    }

    @Basic
    @Column(name = "item_uat", nullable = true)
    public Timestamp getItemUat() {
        return itemUat;
    }

    public void setItemUat(Timestamp itemUat) {
        this.itemUat = itemUat;
    }

    @Basic
    @Column(name = "item_updated_by_user", nullable = true, length = 45)
    public String getItemUpdatedByUser() {
        return itemUpdatedByUser;
    }

    public void setItemUpdatedByUser(String itemUpdatedByUser) {
        this.itemUpdatedByUser = itemUpdatedByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return idItem == item.idItem &&
                isDeleted == item.isDeleted &&
                Objects.equals(itemQrNumber, item.itemQrNumber) &&
                Objects.equals(itemTotalAmount, item.itemTotalAmount) &&
                Objects.equals(itemShouldDeliverAt, item.itemShouldDeliverAt) &&
                Objects.equals(itemDeliveredAt, item.itemDeliveredAt) &&
                Objects.equals(isQuickDelivery, item.isQuickDelivery) &&
                Objects.equals(itemCat, item.itemCat) &&
                Objects.equals(itemUat, item.itemUat) &&
                Objects.equals(itemUpdatedByUser, item.itemUpdatedByUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItem, itemQrNumber, itemTotalAmount, itemShouldDeliverAt, itemDeliveredAt, isQuickDelivery, isDeleted, itemCat, itemUat, itemUpdatedByUser);
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
