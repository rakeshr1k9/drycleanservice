package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "item_category")
@EntityListeners(AuditingEntityListener.class)
public class ItemCategory {

    private Long idItemCategory;
    private String itemCategoryName;
    private Byte isDeleted;
    private Date itemCategoryCat;
    private Date itemCategoryUat;

    private List<ItemType> itemTypes;

    @Id
    @GeneratedValue
    @Column(name = "id_item_category", nullable = false)
    public Long getIdItemCategory() {
        return idItemCategory;
    }

    public void setIdItemCategory(Long idItemCategory) {
        this.idItemCategory = idItemCategory;
    }

    @Column(name = "item_category_name", nullable = true, length = 45)
    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_category_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemCategoryCat() {
        return itemCategoryCat;
    }

    public void setItemCategoryCat(Date itemCategoryCat) {
        this.itemCategoryCat = itemCategoryCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_category_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemCategoryUat() {
        return itemCategoryUat;
    }

    public void setItemCategoryUat(Date itemCategoryUat) {
        this.itemCategoryUat = itemCategoryUat;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "itemCategory")
    public List<ItemType> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(List<ItemType> itemTypes) {
        this.itemTypes = itemTypes;
    }
}
