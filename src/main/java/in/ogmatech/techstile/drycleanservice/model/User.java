package in.ogmatech.techstile.drycleanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends ResourceSupport{

    private long idUser;
    private String username;
    private String password;
    private BigDecimal userMobile;
    private byte isDeleted;
    private Date userCat;
    private Date userUat;
    private String userDeviceId;
    private Branch branch;

    @Id
    @GeneratedValue
    @Column(name = "id_user", nullable = false)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
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
    public BigDecimal getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(BigDecimal userMobile) {
        this.userMobile = userMobile;
    }

    @Column(name = "is_deleted", nullable = false)
    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
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

    @Column(name = "user_device_id", nullable = true, length = 45)
    public String getUserDeviceId() {
        return userDeviceId;
    }

    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id")
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
