package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Remark {
    private Integer idRemark;
    private String remarkName;
    private Byte isDeleted;
    private Timestamp remarkCat;
    private Timestamp remarkUat;

    @Id
    @Column(name = "id_remark", nullable = false)
    public Integer getIdRemark() {
        return idRemark;
    }

    public void setIdRemark(Integer idRemark) {
        this.idRemark = idRemark;
    }

    @Basic
    @Column(name = "remark_name", nullable = true, length = 20)
    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
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
    @Column(name = "remark_cat", nullable = true)
    public Timestamp getRemarkCat() {
        return remarkCat;
    }

    public void setRemarkCat(Timestamp remarkCat) {
        this.remarkCat = remarkCat;
    }

    @Basic
    @Column(name = "remark_uat", nullable = true)
    public Timestamp getRemarkUat() {
        return remarkUat;
    }

    public void setRemarkUat(Timestamp remarkUat) {
        this.remarkUat = remarkUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remark remark = (Remark) o;
        return idRemark == remark.idRemark &&
                isDeleted == remark.isDeleted &&
                Objects.equals(remarkName, remark.remarkName) &&
                Objects.equals(remarkCat, remark.remarkCat) &&
                Objects.equals(remarkUat, remark.remarkUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRemark, remarkName, isDeleted, remarkCat, remarkUat);
    }
}
