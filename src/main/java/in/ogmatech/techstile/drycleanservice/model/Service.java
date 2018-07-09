package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Service {
    private Integer idService;
    private String serviceName;
    private String serviceCode;
    private Byte isDeleted;
    private Timestamp serviceCat;
    private Timestamp serviceUat;
    private Integer serviceOrder;

    @Id
    @Column(name = "id_service", nullable = false)
    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    @Basic
    @Column(name = "service_name", nullable = true, length = 20)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "service_code", nullable = true, length = 4)
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
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
    @Column(name = "service_cat", nullable = true)
    public Timestamp getServiceCat() {
        return serviceCat;
    }

    public void setServiceCat(Timestamp serviceCat) {
        this.serviceCat = serviceCat;
    }

    @Basic
    @Column(name = "service_uat", nullable = true)
    public Timestamp getServiceUat() {
        return serviceUat;
    }

    public void setServiceUat(Timestamp serviceUat) {
        this.serviceUat = serviceUat;
    }

    @Basic
    @Column(name = "service_order", nullable = true)
    public Integer getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(Integer serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return idService == service.idService &&
                isDeleted == service.isDeleted &&
                Objects.equals(serviceName, service.serviceName) &&
                Objects.equals(serviceCode, service.serviceCode) &&
                Objects.equals(serviceCat, service.serviceCat) &&
                Objects.equals(serviceUat, service.serviceUat) &&
                Objects.equals(serviceOrder, service.serviceOrder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idService, serviceName, serviceCode, isDeleted, serviceCat, serviceUat, serviceOrder);
    }
}
