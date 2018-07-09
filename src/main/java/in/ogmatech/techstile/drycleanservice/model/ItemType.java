package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_type", schema = "techstile", catalog = "")
public class ItemType {
    private Integer idItemType;
    private String itemTypeName;
    private String itemTypeImageLink;
    private Byte isDeleted;
    private Timestamp itemTypeCat;
    private Timestamp itemTypeUat;
    private ItemCategory itemCategoryByItemCategoryId;

    @Id
    @Column(name = "id_item_type", nullable = false)
    public Integer getIdItemType() {
        return idItemType;
    }

    public void setIdItemType(Integer idItemType) {
        this.idItemType = idItemType;
    }

    @Basic
    @Column(name = "item_type_name", nullable = true, length = 20)
    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    @Basic
    @Column(name = "item_type_image_link", nullable = true, length = 45)
    public String getItemTypeImageLink() {
        return itemTypeImageLink;
    }

    public void setItemTypeImageLink(String itemTypeImageLink) {
        this.itemTypeImageLink = itemTypeImageLink;
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
    @Column(name = "item_type_cat", nullable = true)
    public Timestamp getItemTypeCat() {
        return itemTypeCat;
    }

    public void setItemTypeCat(Timestamp itemTypeCat) {
        this.itemTypeCat = itemTypeCat;
    }

    @Basic
    @Column(name = "item_type_uat", nullable = true)
    public Timestamp getItemTypeUat() {
        return itemTypeUat;
    }

    public void setItemTypeUat(Timestamp itemTypeUat) {
        this.itemTypeUat = itemTypeUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType itemType = (ItemType) o;
        return idItemType == itemType.idItemType &&
                isDeleted == itemType.isDeleted &&
                Objects.equals(itemTypeName, itemType.itemTypeName) &&
                Objects.equals(itemTypeImageLink, itemType.itemTypeImageLink) &&
                Objects.equals(itemTypeCat, itemType.itemTypeCat) &&
                Objects.equals(itemTypeUat, itemType.itemTypeUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemType, itemTypeName, itemTypeImageLink, isDeleted, itemTypeCat, itemTypeUat);
    }

    @ManyToOne
    @JoinColumn(name = "item_category_id", referencedColumnName = "id_item_category", nullable = false)
    public ItemCategory getItemCategoryByItemCategoryId() {
        return itemCategoryByItemCategoryId;
    }

    public void setItemCategoryByItemCategoryId(ItemCategory itemCategoryByItemCategoryId) {
        this.itemCategoryByItemCategoryId = itemCategoryByItemCategoryId;
    }
}
