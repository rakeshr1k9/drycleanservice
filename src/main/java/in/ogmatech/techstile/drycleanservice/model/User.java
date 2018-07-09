package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    private Integer idUser;
    private String username;
    private String password;
    private Long userMobile;
    private Byte isDeleted;
    private Timestamp userCat;
    private Timestamp userUat;
    private String userDeviceIdentity;
    private Branch branchByBranchId;

    @Id
    @Column(name = "id_user", nullable = false)
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_mobile", nullable = true)
    public Long getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(Long userMobile) {
        this.userMobile = userMobile;
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
    @Column(name = "user_cat", nullable = true)
    public Timestamp getUserCat() {
        return userCat;
    }

    public void setUserCat(Timestamp userCat) {
        this.userCat = userCat;
    }

    @Basic
    @Column(name = "user_uat", nullable = true)
    public Timestamp getUserUat() {
        return userUat;
    }

    public void setUserUat(Timestamp userUat) {
        this.userUat = userUat;
    }

    @Basic
    @Column(name = "user_device_identity", nullable = true, length = 20)
    public String getUserDeviceIdentity() {
        return userDeviceIdentity;
    }

    public void setUserDeviceIdentity(String userDeviceIdentity) {
        this.userDeviceIdentity = userDeviceIdentity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser &&
                isDeleted == user.isDeleted &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userMobile, user.userMobile) &&
                Objects.equals(userCat, user.userCat) &&
                Objects.equals(userUat, user.userUat) &&
                Objects.equals(userDeviceIdentity, user.userDeviceIdentity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, username, password, userMobile, isDeleted, userCat, userUat, userDeviceIdentity);
    }

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id_branch")
    public Branch getBranchByBranchId() {
        return branchByBranchId;
    }

    public void setBranchByBranchId(Branch branchByBranchId) {
        this.branchByBranchId = branchByBranchId;
    }
}
