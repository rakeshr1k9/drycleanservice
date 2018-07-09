package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_remark", schema = "techstile", catalog = "")
public class ItemRemark {
    private Integer idItemRemark;
    private Byte isDeleted;
    private Timestamp itemRemarkCat;
    private Timestamp itemRemarkUat;
    private String itemRemarkUpdatedByUser;
    private Item itemByItemId;
    private Branch branchByBranchId;

    @Id
    @Column(name = "id_item_remark", nullable = false)
    public Integer getIdItemRemark() {
        return idItemRemark;
    }

    public void setIdItemRemark(Integer idItemRemark) {
        this.idItemRemark = idItemRemark;
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
    @Column(name = "item_remark_cat", nullable = true)
    public Timestamp getItemRemarkCat() {
        return itemRemarkCat;
    }

    public void setItemRemarkCat(Timestamp itemRemarkCat) {
        this.itemRemarkCat = itemRemarkCat;
    }

    @Basic
    @Column(name = "item_remark_uat", nullable = true)
    public Timestamp getItemRemarkUat() {
        return itemRemarkUat;
    }

    public void setItemRemarkUat(Timestamp itemRemarkUat) {
        this.itemRemarkUat = itemRemarkUat;
    }

    @Basic
    @Column(name = "item_remark_updated_by_user", nullable = true, length = 45)
    public String getItemRemarkUpdatedByUser() {
        return itemRemarkUpdatedByUser;
    }

    public void setItemRemarkUpdatedByUser(String itemRemarkUpdatedByUser) {
        this.itemRemarkUpdatedByUser = itemRemarkUpdatedByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRemark that = (ItemRemark) o;
        return idItemRemark == that.idItemRemark &&
                isDeleted == that.isDeleted &&
                Objects.equals(itemRemarkCat, that.itemRemarkCat) &&
                Objects.equals(itemRemarkUat, that.itemRemarkUat) &&
                Objects.equals(itemRemarkUpdatedByUser, that.itemRemarkUpdatedByUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idItemRemark, isDeleted, itemRemarkCat, itemRemarkUat, itemRemarkUpdatedByUser);
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
