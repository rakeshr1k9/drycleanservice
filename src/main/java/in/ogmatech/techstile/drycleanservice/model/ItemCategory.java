package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_category", schema = "techstile", catalog = "")
public class ItemCategory {
    private Integer idItemCategory;
    private String itemCategoryName;
    private Byte isDeleted;
    private Timestamp itemCategoryCat;
    private Timestamp itemCategoryUat;

    @Id
    @Column(name = "id_item_category", nullable = false)
    public Integer getIdItemCategory() {
        return idItemCategory;
    }

    public void setIdItemCategory(Integer idItemCategory) {
        this.idItemCategory = idItemCategory;
    }

    @Basic
    @Column(name = "item_category_name", nullable = true, length = 20)
    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
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
    @Column(name = "item_category_cat", nullable = true)
    public Timestamp getItemCategoryCat() {
        return itemCategoryCat;
    }

    public void setItemCategoryCat(Timestamp itemCategoryCat) {
        this.itemCategoryCat = itemCategoryCat;
    }

    @Basic
    @Column(name = "item_category_uat", nullable = true)
    public Timestamp getItemCategoryUat() {
        return itemCategoryUat;
    }

    public void setItemCategoryUat(Timestamp itemCategoryUat) {
        this.itemCategoryUat = itemCategoryUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCategory that = (ItemCategory) o;
        return idItemCategory == that.idItemCategory &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemCategoryName, that.itemCategoryName) &&
                Objects.equals(itemCategoryCat, that.itemCategoryCat) &&
                Objects.equals(itemCategoryUat, that.itemCategoryUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemCategory, itemCategoryName, isDeleted, itemCategoryCat, itemCategoryUat);
    }
}
