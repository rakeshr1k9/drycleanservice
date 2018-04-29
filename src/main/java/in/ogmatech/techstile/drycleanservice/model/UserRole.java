package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user_role")
@EntityListeners(AuditingEntityListener.class)
public class UserRole {

    private Long idUserRole;
    private Byte isDeleted;
    private Date userRoleCat;
    private Date userRoleUat;
    private Long userId;
    private Long roleId;

    @Id
    @GeneratedValue
    @Column(name = "id_user_role", nullable = false)
    public Long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Long idUserRole) {
        this.idUserRole = idUserRole;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "user_role_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getUserRoleCat() {
        return userRoleCat;
    }

    public void setUserRoleCat(Date userRoleCat) {
        this.userRoleCat = userRoleCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "user_role_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getUserRoleUat() {
        return userRoleUat;
    }

    public void setUserRoleUat(Date userRoleUat) {
        this.userRoleUat = userRoleUat;
    }

    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "role_id", nullable = false)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
