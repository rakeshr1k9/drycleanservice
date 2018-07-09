package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_dyeing_color", schema = "techstile", catalog = "")
public class ItemDyeingColor {
    private Integer idItemDyeingColor;
    private Byte isDeleted;
    private Timestamp itemDyeingColorCat;
    private Timestamp itemDyeingColorUat;
    private Item itemByItemId;
    private DyeingColor dyeingColorByDyeingColorId;

    @Id
    @Column(name = "id_item_dyeing_color", nullable = false)
    public Integer getIdItemDyeingColor() {
        return idItemDyeingColor;
    }

    public void setIdItemDyeingColor(Integer idItemDyeingColor) {
        this.idItemDyeingColor = idItemDyeingColor;
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
    @Column(name = "item_dyeing_color_cat", nullable = true)
    public Timestamp getItemDyeingColorCat() {
        return itemDyeingColorCat;
    }

    public void setItemDyeingColorCat(Timestamp itemDyeingColorCat) {
        this.itemDyeingColorCat = itemDyeingColorCat;
    }

    @Basic
    @Column(name = "item_dyeing_color_uat", nullable = true)
    public Timestamp getItemDyeingColorUat() {
        return itemDyeingColorUat;
    }

    public void setItemDyeingColorUat(Timestamp itemDyeingColorUat) {
        this.itemDyeingColorUat = itemDyeingColorUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDyeingColor that = (ItemDyeingColor) o;
        return idItemDyeingColor == that.idItemDyeingColor &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemDyeingColorCat, that.itemDyeingColorCat) &&
                Objects.equals(itemDyeingColorUat, that.itemDyeingColorUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemDyeingColor, isDeleted, itemDyeingColorCat, itemDyeingColorUat);
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
    @JoinColumn(name = "dyeing_color_id", referencedColumnName = "id_dyeing_color", nullable = false)
    public DyeingColor getDyeingColorByDyeingColorId() {
        return dyeingColorByDyeingColorId;
    }

    public void setDyeingColorByDyeingColorId(DyeingColor dyeingColorByDyeingColorId) {
        this.dyeingColorByDyeingColorId = dyeingColorByDyeingColorId;
    }
}
