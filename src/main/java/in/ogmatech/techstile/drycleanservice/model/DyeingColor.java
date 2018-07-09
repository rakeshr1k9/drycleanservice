package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dyeing_color", schema = "techstile", catalog = "")
public class DyeingColor {
    private Integer idDyeingColor;
    private Integer dyeingColorNumber;
    private String dyeingColorName;
    private Byte isDeleted;
    private Timestamp dyeingColorCat;
    private Timestamp dyeingColorUat;

    @Id
    @Column(name = "id_dyeing_color", nullable = false)
    public Integer getIdDyeingColor() {
        return idDyeingColor;
    }

    public void setIdDyeingColor(Integer idDyeingColor) {
        this.idDyeingColor = idDyeingColor;
    }

    @Basic
    @Column(name = "dyeing_color_number", nullable = true)
    public Integer getDyeingColorNumber() {
        return dyeingColorNumber;
    }

    public void setDyeingColorNumber(Integer dyeingColorNumber) {
        this.dyeingColorNumber = dyeingColorNumber;
    }

    @Basic
    @Column(name = "dyeing_color_name", nullable = true, length = 20)
    public String getDyeingColorName() {
        return dyeingColorName;
    }

    public void setDyeingColorName(String dyeingColorName) {
        this.dyeingColorName = dyeingColorName;
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
    @Column(name = "dyeing_color_cat", nullable = true)
    public Timestamp getDyeingColorCat() {
        return dyeingColorCat;
    }

    public void setDyeingColorCat(Timestamp dyeingColorCat) {
        this.dyeingColorCat = dyeingColorCat;
    }

    @Basic
    @Column(name = "dyeing_color_uat", nullable = true)
    public Timestamp getDyeingColorUat() {
        return dyeingColorUat;
    }

    public void setDyeingColorUat(Timestamp dyeingColorUat) {
        this.dyeingColorUat = dyeingColorUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DyeingColor that = (DyeingColor) o;
        return idDyeingColor == that.idDyeingColor &&
                isDeleted == that.isDeleted &&
                Objects.equals(dyeingColorNumber, that.dyeingColorNumber) &&
                Objects.equals(dyeingColorName, that.dyeingColorName) &&
                Objects.equals(dyeingColorCat, that.dyeingColorCat) &&
                Objects.equals(dyeingColorUat, that.dyeingColorUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDyeingColor, dyeingColorNumber, dyeingColorName, isDeleted, dyeingColorCat, dyeingColorUat);
    }
}
