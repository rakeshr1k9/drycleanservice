package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends ResourceSupport implements Serializable {

    private Long idUser;
    private String username;
    private String password;
    private Long userMobile;
    private Byte isDeleted;
    private Date userCat;
    private Date userUat;
    private String userDeviceIdentity;

    private Long branchId;

    @Id
    @GeneratedValue
    @Column(name = "id_user", nullable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_mobile", nullable = true, precision = 0)
    public Long getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(Long userMobile) {
        this.userMobile = userMobile;
    }

    @Column(name = "is_deleted", nullable = false)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "user_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getUserCat() {
        return userCat;
    }

    public void setUserCat(Date userCat) {
        this.userCat = userCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "user_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getUserUat() {
        return userUat;
    }

    public void setUserUat(Date userUat) {
        this.userUat = userUat;
    }

    @Column(name = "user_device_identity", nullable = true, length = 45)
    public String getUserDeviceIdentity() {
        return userDeviceIdentity;
    }

    public void setUserDeviceIdentity(String userDeviceIdentity) {
        this.userDeviceIdentity = userDeviceIdentity;
    }

    @Column(name = "branch_id", nullable = false)
    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
