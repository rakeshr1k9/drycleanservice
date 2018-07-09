package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "worker_service", schema = "techstile", catalog = "")
public class WorkerService {
    private Integer idWorkerService;
    private Byte isDeleted;
    private Timestamp workerServiceCat;
    private Timestamp workerServiceUat;
    private User userByUserId;
    private Service serviceByServiceId;

    @Id
    @Column(name = "id_worker_service", nullable = false)
    public Integer getIdWorkerService() {
        return idWorkerService;
    }

    public void setIdWorkerService(Integer idWorkerService) {
        this.idWorkerService = idWorkerService;
    }

    @Basic
    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Basic
    @Column(name = "worker_service_cat", nullable = true)
    public Timestamp getWorkerServiceCat() {
        return workerServiceCat;
    }

    public void setWorkerServiceCat(Timestamp workerServiceCat) {
        this.workerServiceCat = workerServiceCat;
    }

    @Basic
    @Column(name = "worker_service_uat", nullable = true)
    public Timestamp getWorkerServiceUat() {
        return workerServiceUat;
    }

    public void setWorkerServiceUat(Timestamp workerServiceUat) {
        this.workerServiceUat = workerServiceUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerService that = (WorkerService) o;
        return idWorkerService == that.idWorkerService &&
                isDeleted == that.isDeleted &&
                Objects.equals(workerServiceCat, that.workerServiceCat) &&
                Objects.equals(workerServiceUat, that.workerServiceUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idWorkerService, isDeleted, workerServiceCat, workerServiceUat);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id_service", nullable = false)
    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(Service serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }
}
