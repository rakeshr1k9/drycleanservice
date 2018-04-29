package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "item_type")
@EntityListeners(AuditingEntityListener.class)
public class ItemType {

    private Long idItemType;
    private String itemTypeName;
    private String itemTypeImageLink;
    private Byte isDeleted;
    private Date itemTypeCat;
    private Date itemTypeUat;
    private Long itemCategoryId;

    @Id
    @GeneratedValue
    @Column(name = "id_item_type", nullable = false)
    public Long getIdItemType() {
        return idItemType;
    }

    public void setIdItemType(Long idItemType) {
        this.idItemType = idItemType;
    }

    @Column(name = "item_type_name", nullable = true, length = 45)
    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    @Column(name = "item_type_image_link", nullable = true, length = 45)
    public String getItemTypeImageLink() {
        return itemTypeImageLink;
    }

    public void setItemTypeImageLink(String itemTypeImageLink) {
        this.itemTypeImageLink = itemTypeImageLink;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_type_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemTypeCat() {
        return itemTypeCat;
    }

    public void setItemTypeCat(Date itemTypeCat) {
        this.itemTypeCat = itemTypeCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_type_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemTypeUat() {
        return itemTypeUat;
    }

    public void setItemTypeUat(Date itemTypeUat) {
        this.itemTypeUat = itemTypeUat;
    }

    @Column(name = "item_category_id", nullable = false)
    public Long getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Long itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }
}
