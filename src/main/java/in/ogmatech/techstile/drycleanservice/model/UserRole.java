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

    private User user;
    private Role role;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id_role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
