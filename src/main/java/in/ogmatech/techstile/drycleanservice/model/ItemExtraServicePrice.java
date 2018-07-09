package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_extra_service_price", schema = "techstile", catalog = "")
public class ItemExtraServicePrice {
    private Integer idItemExtraServicePrice;
    private Integer itemExtraServiceAmount;
    private Byte isDeleted;
    private Timestamp itemExtraServicePriceCat;
    private Timestamp itemExtraServicePriceUat;
    private String itemExtraServicePriceCreatedByUser;
    private String itemExtraServicePriceUpdatedByUser;
    private ExtraService extraServiceByExtraServiceId;
    private Item itemByItemId;

    @Id
    @Column(name = "id_item_extra_service_price", nullable = false)
    public Integer getIdItemExtraServicePrice() {
        return idItemExtraServicePrice;
    }

    public void setIdItemExtraServicePrice(Integer idItemExtraServicePrice) {
        this.idItemExtraServicePrice = idItemExtraServicePrice;
    }

    @Basic
    @Column(name = "item_extra_service_amount", nullable = true)
    public Integer getItemExtraServiceAmount() {
        return itemExtraServiceAmount;
    }

    public void setItemExtraServiceAmount(Integer itemExtraServiceAmount) {
        this.itemExtraServiceAmount = itemExtraServiceAmount;
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
    @Column(name = "item_extra_service_price_cat", nullable = true)
    public Timestamp getItemExtraServicePriceCat() {
        return itemExtraServicePriceCat;
    }

    public void setItemExtraServicePriceCat(Timestamp itemExtraServicePriceCat) {
        this.itemExtraServicePriceCat = itemExtraServicePriceCat;
    }

    @Basic
    @Column(name = "item_extra_service_price_uat", nullable = true)
    public Timestamp getItemExtraServicePriceUat() {
        return itemExtraServicePriceUat;
    }

    public void setItemExtraServicePriceUat(Timestamp itemExtraServicePriceUat) {
        this.itemExtraServicePriceUat = itemExtraServicePriceUat;
    }

    @Basic
    @Column(name = "item_extra_service_price_created_by_user", nullable = true, length = 45)
    public String getItemExtraServicePriceCreatedByUser() {
        return itemExtraServicePriceCreatedByUser;
    }

    public void setItemExtraServicePriceCreatedByUser(String itemExtraServicePriceCreatedByUser) {
        this.itemExtraServicePriceCreatedByUser = itemExtraServicePriceCreatedByUser;
    }

    @Basic
    @Column(name = "item_extra_service_price_updated_by_user", nullable = true, length = 45)
    public String getItemExtraServicePriceUpdatedByUser() {
        return itemExtraServicePriceUpdatedByUser;
    }

    public void setItemExtraServicePriceUpdatedByUser(String itemExtraServicePriceUpdatedByUser) {
        this.itemExtraServicePriceUpdatedByUser = itemExtraServicePriceUpdatedByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemExtraServicePrice that = (ItemExtraServicePrice) o;
        return idItemExtraServicePrice == that.idItemExtraServicePrice &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemExtraServiceAmount, that.itemExtraServiceAmount) &&
                Objects.equals(itemExtraServicePriceCat, that.itemExtraServicePriceCat) &&
                Objects.equals(itemExtraServicePriceUat, that.itemExtraServicePriceUat) &&
                Objects.equals(itemExtraServicePriceCreatedByUser, that.itemExtraServicePriceCreatedByUser) &&
                Objects.equals(itemExtraServicePriceUpdatedByUser, that.itemExtraServicePriceUpdatedByUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemExtraServicePrice, itemExtraServiceAmount, isDeleted, itemExtraServicePriceCat, itemExtraServicePriceUat, itemExtraServicePriceCreatedByUser, itemExtraServicePriceUpdatedByUser);
    }

    @ManyToOne
    @JoinColumn(name = "extra_service_id", referencedColumnName = "id_extra_service", nullable = false)
    public ExtraService getExtraServiceByExtraServiceId() {
        return extraServiceByExtraServiceId;
    }

    public void setExtraServiceByExtraServiceId(ExtraService extraServiceByExtraServiceId) {
        this.extraServiceByExtraServiceId = extraServiceByExtraServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id_item", nullable = false)
    public Item getItemByItemId() {
        return itemByItemId;
    }

    public void setItemByItemId(Item itemByItemId) {
        this.itemByItemId = itemByItemId;
    }
}
