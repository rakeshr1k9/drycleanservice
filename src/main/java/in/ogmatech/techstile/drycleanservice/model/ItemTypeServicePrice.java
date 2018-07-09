package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_type_service_price", schema = "techstile", catalog = "")
public class ItemTypeServicePrice {
    private Integer idItemTypeServicePrice;
    private Integer itemTypeServiceAmount;
    private Byte isDeleted;
    private Timestamp itemTypeServicePriceCat;
    private Timestamp itemTypeServicePriceUat;
    private ItemType itemTypeByItemTypeId;

    @Id
    @Column(name = "id_item_type_service_price", nullable = false)
    public Integer getIdItemTypeServicePrice() {
        return idItemTypeServicePrice;
    }

    public void setIdItemTypeServicePrice(Integer idItemTypeServicePrice) {
        this.idItemTypeServicePrice = idItemTypeServicePrice;
    }

    @Basic
    @Column(name = "item_type_service_amount", nullable = true)
    public Integer getItemTypeServiceAmount() {
        return itemTypeServiceAmount;
    }

    public void setItemTypeServiceAmount(Integer itemTypeServiceAmount) {
        this.itemTypeServiceAmount = itemTypeServiceAmount;
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
    @Column(name = "item_type_service_price_cat", nullable = true)
    public Timestamp getItemTypeServicePriceCat() {
        return itemTypeServicePriceCat;
    }

    public void setItemTypeServicePriceCat(Timestamp itemTypeServicePriceCat) {
        this.itemTypeServicePriceCat = itemTypeServicePriceCat;
    }

    @Basic
    @Column(name = "item_type_service_price_uat", nullable = true)
    public Timestamp getItemTypeServicePriceUat() {
        return itemTypeServicePriceUat;
    }

    public void setItemTypeServicePriceUat(Timestamp itemTypeServicePriceUat) {
        this.itemTypeServicePriceUat = itemTypeServicePriceUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemTypeServicePrice that = (ItemTypeServicePrice) o;
        return idItemTypeServicePrice == that.idItemTypeServicePrice &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemTypeServiceAmount, that.itemTypeServiceAmount) &&
                Objects.equals(itemTypeServicePriceCat, that.itemTypeServicePriceCat) &&
                Objects.equals(itemTypeServicePriceUat, that.itemTypeServicePriceUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemTypeServicePrice, itemTypeServiceAmount, isDeleted, itemTypeServicePriceCat, itemTypeServicePriceUat);
    }

    @ManyToOne
    @JoinColumn(name = "item_type_id", referencedColumnName = "id_item_type", nullable = false)
    public ItemType getItemTypeByItemTypeId() {
        return itemTypeByItemTypeId;
    }

    public void setItemTypeByItemTypeId(ItemType itemTypeByItemTypeId) {
        this.itemTypeByItemTypeId = itemTypeByItemTypeId;
    }
}
