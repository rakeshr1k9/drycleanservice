package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "service_type_split")
@EntityListeners(AuditingEntityListener.class)
public class ServiceTypeSplit {

    private Long idServiceTypeSplit;
    private Byte isDeleted;
    private Date serviceTypeSplitCat;
    private Date serviceTypeSplitUat;

    private ServiceType serviceType;
    private ServiceIndividual serviceIndividual;

    @Id
    @GeneratedValue
    @Column(name = "id_service_type_split", nullable = false)
    public Long getIdServiceTypeSplit() {
        return idServiceTypeSplit;
    }

    public void setIdServiceTypeSplit(Long idServiceTypeSplit) {
        this.idServiceTypeSplit = idServiceTypeSplit;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_type_split_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getServiceTypeSplitCat() {
        return serviceTypeSplitCat;
    }

    public void setServiceTypeSplitCat(Date serviceTypeSplitCat) {
        this.serviceTypeSplitCat = serviceTypeSplitCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_type_split_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getServiceTypeSplitUat() {
        return serviceTypeSplitUat;
    }

    public void setServiceTypeSplitUat(Date serviceTypeSplitUat) {
        this.serviceTypeSplitUat = serviceTypeSplitUat;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "service_type_id", referencedColumnName = "id_service_type")
    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "service_individual_id", referencedColumnName = "id_service_individual")
    public ServiceIndividual getServiceIndividual() {
        return serviceIndividual;
    }

    public void setServiceIndividual(ServiceIndividual serviceIndividual) {
        this.serviceIndividual = serviceIndividual;
    }
}
