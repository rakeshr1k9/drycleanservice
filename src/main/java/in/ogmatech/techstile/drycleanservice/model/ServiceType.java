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
@Table(name = "service_type")
@EntityListeners(AuditingEntityListener.class)
public class ServiceType {

    private Long idServiceType;
    private String serviceTypeName;
    private String serviceTypeCode;
    private Byte isDeleted;
    private Date serviceTypeCat;
    private Date serviceTypeUat;

    private List<ItemServiceType> itemServiceTypes;
    private List<ItemTypeServicePrice> itemTypeServicePrices;
    private List<ServiceTypeSplit> serviceTypeSplits;

    @Id
    @GeneratedValue
    @Column(name = "id_service_type", nullable = false)
    public Long getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(Long idServiceType) {
        this.idServiceType = idServiceType;
    }

    @Column(name = "service_type_name", nullable = true, length = 45)
    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    @Column(name = "service_type_code", nullable = true, length = 45)
    public String getServiceTypeCode() {
        return serviceTypeCode;
    }

    public void setServiceTypeCode(String serviceTypeCode) {
        this.serviceTypeCode = serviceTypeCode;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_type_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getServiceTypeCat() {
        return serviceTypeCat;
    }

    public void setServiceTypeCat(Date serviceTypeCat) {
        this.serviceTypeCat = serviceTypeCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_type_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getServiceTypeUat() {
        return serviceTypeUat;
    }

    public void setServiceTypeUat(Date serviceTypeUat) {
        this.serviceTypeUat = serviceTypeUat;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serviceType")
    public List<ItemServiceType> getItemServiceTypes() {
        return itemServiceTypes;
    }

    public void setItemServiceTypes(List<ItemServiceType> itemServiceTypes) {
        this.itemServiceTypes = itemServiceTypes;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serviceType")
    public List<ItemTypeServicePrice> getItemTypeServicePrices() {
        return itemTypeServicePrices;
    }

    public void setItemTypeServicePrices(List<ItemTypeServicePrice> itemTypeServicePrices) {
        this.itemTypeServicePrices = itemTypeServicePrices;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serviceType")
    public List<ServiceTypeSplit> getServiceTypeSplits() {
        return serviceTypeSplits;
    }

    public void setServiceTypeSplits(List<ServiceTypeSplit> serviceTypeSplits) {
        this.serviceTypeSplits = serviceTypeSplits;
    }
}
