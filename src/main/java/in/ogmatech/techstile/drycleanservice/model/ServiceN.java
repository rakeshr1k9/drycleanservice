package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "service")
@EntityListeners(AuditingEntityListener.class)
public class ServiceN {

    private Long idService;
    private Integer serviceOrder;
    private String serviceName;
    private String serviceCode;
    private Byte isDeleted;
    private Date serviceCat;
    private Date serviceUat;

    @Id
    @GeneratedValue
    @Column(name = "id_service", nullable = false)
    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    @Column(name = "service_order", nullable = true)
    public Integer getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(Integer serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Column(name = "service_name", nullable = true, length = 45)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Column(name = "service_code", nullable = true, length = 4)
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getServiceCat() {
        return serviceCat;
    }

    public void setServiceCat(Date serviceCat) {
        this.serviceCat = serviceCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "service_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getServiceUat() {
        return serviceUat;
    }

    public void setServiceUat(Date serviceUat) {
        this.serviceUat = serviceUat;
    }
}
