package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "extra_service", schema = "techstile", catalog = "")
public class ExtraService {
    private Integer idExtraService;
    private String extraServiceName;
    private Byte isDeleted;
    private Timestamp extraServiceCat;
    private Timestamp extraServiceUat;

    @Id
    @Column(name = "id_extra_service", nullable = false)
    public Integer getIdExtraService() {
        return idExtraService;
    }

    public void setIdExtraService(Integer idExtraService) {
        this.idExtraService = idExtraService;
    }

    @Basic
    @Column(name = "extra_service_name", nullable = true, length = 20)
    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
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
    @Column(name = "extra_service_cat", nullable = true)
    public Timestamp getExtraServiceCat() {
        return extraServiceCat;
    }

    public void setExtraServiceCat(Timestamp extraServiceCat) {
        this.extraServiceCat = extraServiceCat;
    }

    @Basic
    @Column(name = "extra_service_uat", nullable = true)
    public Timestamp getExtraServiceUat() {
        return extraServiceUat;
    }

    public void setExtraServiceUat(Timestamp extraServiceUat) {
        this.extraServiceUat = extraServiceUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraService that = (ExtraService) o;
        return idExtraService == that.idExtraService &&
                isDeleted == that.isDeleted &&
                Objects.equals(extraServiceName, that.extraServiceName) &&
                Objects.equals(extraServiceCat, that.extraServiceCat) &&
                Objects.equals(extraServiceUat, that.extraServiceUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idExtraService, extraServiceName, isDeleted, extraServiceCat, extraServiceUat);
    }
}
