package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class Role {

    private Long idRole;
    private String roleName;
    private Byte isDeleted;
    private Date roleCat;
    private Date roleUat;

    @Id
    @GeneratedValue
    @Column(name = "id_role", nullable = false)
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    @Column(name = "role_name", nullable = true, length = 45)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "role_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getRoleCat() {
        return roleCat;
    }

    public void setRoleCat(Date roleCat) {
        this.roleCat = roleCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "role_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getRoleUat() {
        return roleUat;
    }

    public void setRoleUat(Date roleUat) {
        this.roleUat = roleUat;
    }
}
