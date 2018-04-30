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

    private Item item;
    private ServiceIndividual serviceIndividual;

    private User user;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", referencedColumnName = "id_item")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "service_individual_id", referencedColumnName = "id_service_individual")
    public ServiceIndividual getServiceIndividual() {
        return serviceIndividual;
    }

    public void setServiceIndividual(ServiceIndividual serviceIndividual) {
        this.serviceIndividual = serviceIndividual;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
