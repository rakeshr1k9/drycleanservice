package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "worker_service")
@EntityListeners(AuditingEntityListener.class)
public class WorkerService implements Serializable {

    private Long idWorkerService;
    private Byte isDeleted;
    private Date workerServiceCat;
    private Date userServiceUat;

    private Long userId;
    private Long serviceIndividualId;

    @Id
    @GeneratedValue
    @Column(name = "id_worker_service", nullable = false)
    public Long getIdWorkerService() {
        return idWorkerService;
    }

    public void setIdWorkerService(Long idWorkerService) {
        this.idWorkerService = idWorkerService;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "worker_service_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getWorkerServiceCat() {
        return workerServiceCat;
    }

    public void setWorkerServiceCat(Date workerServiceCat) {
        this.workerServiceCat = workerServiceCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "worker_service_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getUserServiceUat() {
        return userServiceUat;
    }

    public void setUserServiceUat(Date userServiceUat) {
        this.userServiceUat = userServiceUat;
    }

    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "service_individual_id", nullable = false)
    public Long getServiceIndividualId() {
        return serviceIndividualId;
    }

    public void setServiceIndividualId(Long serviceIndividualId) {
        this.serviceIndividualId = serviceIndividualId;
    }
}
