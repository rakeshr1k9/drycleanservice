package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item_service_scan")
@EntityListeners(AuditingEntityListener.class)
public class ItemServiceScan {

    private Long idItemServiceScan;
    private Date itemServiceScanTime;
    private Byte isDeleted;
    private Date itemServiceScanCat;
    private Date itemServiceScanUat;
    private Long itemId;

    @Id
    @GeneratedValue
    @Column(name = "id_item_service_scan", nullable = false)
    public Long getIdItemServiceScan() {
        return idItemServiceScan;
    }

    public void setIdItemServiceScan(Long idItemServiceScan) {
        this.idItemServiceScan = idItemServiceScan;
    }

    @Column(name = "item_service_scan_time", nullable = true)
    public Date getItemServiceScanTime() {
        return itemServiceScanTime;
    }

    public void setItemServiceScanTime(Date itemServiceScanTime) {
        this.itemServiceScanTime = itemServiceScanTime;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_service_scan_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getItemServiceScanCat() {
        return itemServiceScanCat;
    }

    public void setItemServiceScanCat(Date itemServiceScanCat) {
        this.itemServiceScanCat = itemServiceScanCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "item_service_scan_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getItemServiceScanUat() {
        return itemServiceScanUat;
    }

    public void setItemServiceScanUat(Date itemServiceScanUat) {
        this.itemServiceScanUat = itemServiceScanUat;
    }

    @Column(name = "item_id", nullable = false)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
