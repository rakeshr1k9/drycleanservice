package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service_individual")
@EntityListeners(AuditingEntityListener.class)
public class ServiceIndividual implements Serializable {

    private Long idServiceIndividual;
    private Integer serviceIndividualOrder;
    private String serviceIndividualName;
    private String serviceIndividualCode;
    private Byte isDeleted;
    private Date serviceIndividualCat;
    private Date serviceIndividualUat;

    @Id
    @GeneratedValue
    @Column(name = "id_service_individual", nullable = false)
    public Long getIdServiceIndividual() {
        return idServiceIndividual;
    }

    public void setIdServiceIndividual(Long idServiceIndividual) {
        this.idServiceIndividual = idServiceIndividual;
    }

    @Column(name = "service_individual_order", nullable = true)
    public Integer getServiceIndividualOrder() {
        return serviceIndividualOrder;
    }

    public void setServiceIndividualOrder(Integer serviceIndividualOrder) {
        this.serviceIndividualOrder = serviceIndividualOrder;
    }

    @Column(name = "service_individual_name", nullable = true, length = 45)
    public String getServiceIndividualName() {
        return serviceIndividualName;
    }

    public void setServiceIndividualName(String serviceIndividualName) {
        this.serviceIndividualName = serviceIndividualName;
    }

    @Column(name = "service_individual_code", nullable = true, length = 4)
    public String getServiceIndividualCode() {
        return serviceIndividualCode;
    }

    public void setServiceIndividualCode(String serviceIndividualCode) {
        this.serviceIndividualCode = serviceIndividualCode;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_individual_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getServiceIndividualCat() {
        return serviceIndividualCat;
    }

    public void setServiceIndividualCat(Date serviceIndividualCat) {
        this.serviceIndividualCat = serviceIndividualCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_individual_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getServiceIndividualUat() {
        return serviceIndividualUat;
    }

    public void setServiceIndividualUat(Date serviceIndividualUat) {
        this.serviceIndividualUat = serviceIndividualUat;
    }

}
