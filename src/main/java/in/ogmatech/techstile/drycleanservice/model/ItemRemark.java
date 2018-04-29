package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item_remark")
@EntityListeners(AuditingEntityListener.class)
public class ItemRemark {

    private Long idItemRemark;
    private Byte isDeleted;
    private Date itemRemarkCat;
    private Date itemRemarkUat;

    private Long itemId;
    private Long remarkId;

    @Id
    @GeneratedValue
    @Column(name = "id_item_remark", nullable = false)
    public Long getIdItemRemark() {
        return idItemRemark;
    }

    public void setIdItemRemark(Long idItemRemark) {
        this.idItemRemark = idItemRemark;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_remark_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemRemarkCat() {
        return itemRemarkCat;
    }

    public void setItemRemarkCat(Date itemRemarkCat) {
        this.itemRemarkCat = itemRemarkCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_remark_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemRemarkUat() {
        return itemRemarkUat;
    }

    public void setItemRemarkUat(Date itemRemarkUat) {
        this.itemRemarkUat = itemRemarkUat;
    }

    @Column(name = "item_id", nullable = false)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(name = "remark_id", nullable = false)
    public Long getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Long remarkId) {
        this.remarkId = remarkId;
    }
}
