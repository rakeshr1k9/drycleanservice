package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Role {
    private Integer idRole;
    private String roleName;
    private Byte isDeleted;
    private Timestamp roleCat;
    private Timestamp roleUat;

    @Id
    @Column(name = "id_role", nullable = false)
    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "role_name", nullable = true, length = 20)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    @Column(name = "role_cat", nullable = true)
    public Timestamp getRoleCat() {
        return roleCat;
    }

    public void setRoleCat(Timestamp roleCat) {
        this.roleCat = roleCat;
    }

    @Basic
    @Column(name = "role_uat", nullable = true)
    public Timestamp getRoleUat() {
        return roleUat;
    }

    public void setRoleUat(Timestamp roleUat) {
        this.roleUat = roleUat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return idRole == role.idRole &&
                isDeleted == role.isDeleted &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleCat, role.roleCat) &&
                Objects.equals(roleUat, role.roleUat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRole, roleName, isDeleted, roleCat, roleUat);
    }
}
