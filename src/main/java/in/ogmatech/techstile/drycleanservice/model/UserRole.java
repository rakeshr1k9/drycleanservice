package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "techstile", catalog = "")
public class UserRole {
    private Integer idUserRole;
    private Byte isDeleted;
    private Timestamp userRoleCat;
    private Timestamp userRoleUat;
    private User userByUserId;
    private Role roleByRoleId;

    @Id
    @Column(name = "id_user_role", nullable = false)
    public Integer getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
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
    @Column(name = "user_role_cat", nullable = true)
    public Timestamp getUserRoleCat() {
        return userRoleCat;
    }

    public void setUserRoleCat(Timestamp userRoleCat) {
        this.userRoleCat = userRoleCat;
    }

    @Basic
    @Column(name = "user_role_uat", nullable = true)
    public Timestamp getUserRoleUat() {
        return userRoleUat;
    }

    public void setUserRoleUat(Timestamp userRoleUat) {
        this.userRoleUat = userRoleUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return idUserRole == userRole.idUserRole &&
                isDeleted == userRole.isDeleted &&
                Objects.equals(userRoleCat, userRole.userRoleCat) &&
                Objects.equals(userRoleUat, userRole.userRoleUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUserRole, isDeleted, userRoleCat, userRoleUat);
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
    @JoinColumn(name = "role_id", referencedColumnName = "id_role", nullable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
