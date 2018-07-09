package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_service_scan", schema = "techstile", catalog = "")
public class ItemServiceScan {
    private Integer idItemServiceScan;
    private Timestamp itemServiceScanTime;
    private Byte isDeleted;
    private Timestamp itemServiceScanCat;
    private Timestamp itemServiceScanUat;
    private Item itemByItemId;

    @Id
    @Column(name = "id_item_service_scan", nullable = false)
    public Integer getIdItemServiceScan() {
        return idItemServiceScan;
    }

    public void setIdItemServiceScan(Integer idItemServiceScan) {
        this.idItemServiceScan = idItemServiceScan;
    }

    @Basic
    @Column(name = "item_service_scan_time", nullable = true)
    public Timestamp getItemServiceScanTime() {
        return itemServiceScanTime;
    }

    public void setItemServiceScanTime(Timestamp itemServiceScanTime) {
        this.itemServiceScanTime = itemServiceScanTime;
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
    @Column(name = "item_service_scan_cat", nullable = true)
    public Timestamp getItemServiceScanCat() {
        return itemServiceScanCat;
    }

    public void setItemServiceScanCat(Timestamp itemServiceScanCat) {
        this.itemServiceScanCat = itemServiceScanCat;
    }

    @Basic
    @Column(name = "item_service_scan_uat", nullable = true)
    public Timestamp getItemServiceScanUat() {
        return itemServiceScanUat;
    }

    public void setItemServiceScanUat(Timestamp itemServiceScanUat) {
        this.itemServiceScanUat = itemServiceScanUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemServiceScan that = (ItemServiceScan) o;
        return idItemServiceScan == that.idItemServiceScan &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemServiceScanTime, that.itemServiceScanTime) &&
                Objects.equals(itemServiceScanCat, that.itemServiceScanCat) &&
                Objects.equals(itemServiceScanUat, that.itemServiceScanUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemServiceScan, itemServiceScanTime, isDeleted, itemServiceScanCat, itemServiceScanUat);
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
