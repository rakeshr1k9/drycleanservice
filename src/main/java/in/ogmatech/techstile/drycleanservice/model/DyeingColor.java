package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dyeing_color")
@EntityListeners(AuditingEntityListener.class)
public class DyeingColor {

    private Long idDyeingColor;
    private Integer dyeingColorNumber;
    private String dyeingColorName;
    private Byte isDeleted;
    private Date dyeingColorCat;
    private Date dyeingColorUat;

    @Id
    @GeneratedValue
    @Column(name = "id_dyeing_color", nullable = false)
    public Long getIdDyeingColor() {
        return idDyeingColor;
    }

    public void setIdDyeingColor(Long idDyeingColor) {
        this.idDyeingColor = idDyeingColor;
    }

    @Column(name = "dyeing_color_number", nullable = true)
    public Integer getDyeingColorNumber() {
        return dyeingColorNumber;
    }

    public void setDyeingColorNumber(Integer dyeingColorNumber) {
        this.dyeingColorNumber = dyeingColorNumber;
    }

    @Column(name = "dyeing_color_name", nullable = true, length = 45)
    public String getDyeingColorName() {
        return dyeingColorName;
    }

    public void setDyeingColorName(String dyeingColorName) {
        this.dyeingColorName = dyeingColorName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "dyeing_color_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getDyeingColorCat() {
        return dyeingColorCat;
    }

    public void setDyeingColorCat(Date dyeingColorCat) {
        this.dyeingColorCat = dyeingColorCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "dyeing_color_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getDyeingColorUat() {
        return dyeingColorUat;
    }

    public void setDyeingColorUat(Date dyeingColorUat) {
        this.dyeingColorUat = dyeingColorUat;
    }
}
