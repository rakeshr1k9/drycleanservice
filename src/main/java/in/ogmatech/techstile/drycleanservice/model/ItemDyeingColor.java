package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item_dyeing_color")
@EntityListeners(AuditingEntityListener.class)
public class ItemDyeingColor {

    private Long idItemDyeingColor;
    private Byte isDeleted;
    private Date itemDyeingColorCat;
    private Date itemDyeingColorUat;

    private Item item;
    private DyeingColor dyeingColor;

    @Id
    @GeneratedValue
    @Column(name = "id_item_dyeing_color", nullable = false)
    public Long getIdItemDyeingColor() {
        return idItemDyeingColor;
    }

    public void setIdItemDyeingColor(Long idItemDyeingColor) {
        this.idItemDyeingColor = idItemDyeingColor;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_dyeing_color_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemDyeingColorCat() {
        return itemDyeingColorCat;
    }

    public void setItemDyeingColorCat(Date itemDyeingColorCat) {
        this.itemDyeingColorCat = itemDyeingColorCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_dyeing_color_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemDyeingColorUat() {
        return itemDyeingColorUat;
    }

    public void setItemDyeingColorUat(Date itemDyeingColorUat) {
        this.itemDyeingColorUat = itemDyeingColorUat;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", referencedColumnName = "id_item")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dyeing_color_id", referencedColumnName = "id_dyeing_color")
    public DyeingColor getDyeingColor() {
        return dyeingColor;
    }

    public void setDyeingColor(DyeingColor dyeingColor) {
        this.dyeingColor = dyeingColor;
    }
}
