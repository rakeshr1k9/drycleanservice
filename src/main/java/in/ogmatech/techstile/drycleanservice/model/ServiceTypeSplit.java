package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "service_type_split")
@EntityListeners(AuditingEntityListener.class)
public class ServiceTypeSplit implements Serializable {

    private Long idServiceTypeSplit;
    private Byte isDeleted;
    private Date serviceTypeSplitCat;
    private Date serviceTypeSplitUat;

    private Long serviceTypeId;
    private Long serviceIndividualId;

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

    @Column(name = "service_type_id", nullable = false)
    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    @Column(name = "service_individual_id", nullable = false)
    public Long getServiceIndividualId() {
        return serviceIndividualId;
    }

    public void setServiceIndividualId(Long serviceIndividualId) {
        this.serviceIndividualId = serviceIndividualId;
    }
}
