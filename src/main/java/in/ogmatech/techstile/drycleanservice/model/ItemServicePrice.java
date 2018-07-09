package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_service_price", schema = "techstile", catalog = "")
public class ItemServicePrice {
    private Integer idItemServicePrice;
    private Byte isDeleted;
    private Timestamp itemServicePriceCat;
    private Timestamp itemServicePriceUat;
    private Integer itemServiceAmount;
    private String itemServicePriceCreatedByUser;
    private String itemServicePriceUpdatedByUser;
    private Item itemByItemId;
    private Branch branchByBranchId;

    @Id
    @Column(name = "id_item_service_price", nullable = false)
    public Integer getIdItemServicePrice() {
        return idItemServicePrice;
    }

    public void setIdItemServicePrice(Integer idItemServicePrice) {
        this.idItemServicePrice = idItemServicePrice;
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
    @Column(name = "item_service_price_cat", nullable = true)
    public Timestamp getItemServicePriceCat() {
        return itemServicePriceCat;
    }

    public void setItemServicePriceCat(Timestamp itemServicePriceCat) {
        this.itemServicePriceCat = itemServicePriceCat;
    }

    @Basic
    @Column(name = "item_service_price_uat", nullable = true)
    public Timestamp getItemServicePriceUat() {
        return itemServicePriceUat;
    }

    public void setItemServicePriceUat(Timestamp itemServicePriceUat) {
        this.itemServicePriceUat = itemServicePriceUat;
    }

    @Basic
    @Column(name = "item_service_amount", nullable = true)
    public Integer getItemServiceAmount() {
        return itemServiceAmount;
    }

    public void setItemServiceAmount(Integer itemServiceAmount) {
        this.itemServiceAmount = itemServiceAmount;
    }

    @Basic
    @Column(name = "item_service_price_created_by_user", nullable = true, length = 45)
    public String getItemServicePriceCreatedByUser() {
        return itemServicePriceCreatedByUser;
    }

    public void setItemServicePriceCreatedByUser(String itemServicePriceCreatedByUser) {
        this.itemServicePriceCreatedByUser = itemServicePriceCreatedByUser;
    }

    @Basic
    @Column(name = "item_service_price_updated_by_user", nullable = true, length = 45)
    public String getItemServicePriceUpdatedByUser() {
        return itemServicePriceUpdatedByUser;
    }

    public void setItemServicePriceUpdatedByUser(String itemServicePriceUpdatedByUser) {
        this.itemServicePriceUpdatedByUser = itemServicePriceUpdatedByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemServicePrice that = (ItemServicePrice) o;
        return idItemServicePrice == that.idItemServicePrice &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemServicePriceCat, that.itemServicePriceCat) &&
                Objects.equals(itemServicePriceUat, that.itemServicePriceUat) &&
                Objects.equals(itemServiceAmount, that.itemServiceAmount) &&
                Objects.equals(itemServicePriceCreatedByUser, that.itemServicePriceCreatedByUser) &&
                Objects.equals(itemServicePriceUpdatedByUser, that.itemServicePriceUpdatedByUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemServicePrice, isDeleted, itemServicePriceCat, itemServicePriceUat, itemServiceAmount, itemServicePriceCreatedByUser, itemServicePriceUpdatedByUser);
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id_item", nullable = false)
    public Item getItemByItemId() {
        return itemByItemId;
    }

    public void setItemByItemId(Item itemByItemId) {
        this.itemByItemId = itemByItemId;
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
