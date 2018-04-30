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
@Table(name = "remark")
@EntityListeners(AuditingEntityListener.class)
public class Remark implements Serializable {

    private Long idRemark;
    private String remarkName;
    private Byte isDeleted;
    private Date remarkCat;
    private Date remarkUat;

    @Id
    @GeneratedValue
    @Column(name = "id_remark", nullable = false)
    public Long getIdRemark() {
        return idRemark;
    }

    public void setIdRemark(Long idRemark) {
        this.idRemark = idRemark;
    }

    @Column(name = "remark_name", nullable = true, length = 45)
    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "remark_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getRemarkCat() {
        return remarkCat;
    }

    public void setRemarkCat(Date remarkCat) {
        this.remarkCat = remarkCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "remark_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getRemarkUat() {
        return remarkUat;
    }

    public void setRemarkUat(Date remarkUat) {
        this.remarkUat = remarkUat;
    }

}
