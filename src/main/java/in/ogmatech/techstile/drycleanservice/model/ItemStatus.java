package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_status", schema = "techstile", catalog = "")
public class ItemStatus {
    private Integer idItemStatus;
    private String itemStatusName;
    private Byte isDeleted;
    private Timestamp itemStatusCat;
    private Timestamp itemStatusUat;
    private Integer itemStatusOrder;

    @Id
    @Column(name = "id_item_status", nullable = false)
    public Integer getIdItemStatus() {
        return idItemStatus;
    }

    public void setIdItemStatus(Integer idItemStatus) {
        this.idItemStatus = idItemStatus;
    }

    @Basic
    @Column(name = "item_status_name", nullable = true, length = 20)
    public String getItemStatusName() {
        return itemStatusName;
    }

    public void setItemStatusName(String itemStatusName) {
        this.itemStatusName = itemStatusName;
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
    @Column(name = "item_status_cat", nullable = true)
    public Timestamp getItemStatusCat() {
        return itemStatusCat;
    }

    public void setItemStatusCat(Timestamp itemStatusCat) {
        this.itemStatusCat = itemStatusCat;
    }

    @Basic
    @Column(name = "item_status_uat", nullable = true)
    public Timestamp getItemStatusUat() {
        return itemStatusUat;
    }

    public void setItemStatusUat(Timestamp itemStatusUat) {
        this.itemStatusUat = itemStatusUat;
    }

    @Basic
    @Column(name = "item_status_order", nullable = true)
    public Integer getItemStatusOrder() {
        return itemStatusOrder;
    }

    public void setItemStatusOrder(Integer itemStatusOrder) {
        this.itemStatusOrder = itemStatusOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStatus that = (ItemStatus) o;
        return idItemStatus == that.idItemStatus &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemStatusName, that.itemStatusName) &&
                Objects.equals(itemStatusCat, that.itemStatusCat) &&
                Objects.equals(itemStatusUat, that.itemStatusUat) &&
                Objects.equals(itemStatusOrder, that.itemStatusOrder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemStatus, itemStatusName, isDeleted, itemStatusCat, itemStatusUat, itemStatusOrder);
    }
}
