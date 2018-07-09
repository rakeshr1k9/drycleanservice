package in.ogmatech.techstile.drycleanservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Branch {
    private Integer idBranch;
    private String branchCode;
    private String branchName;
    private String branchPlace;
    private Byte isDeleted;
    private Timestamp branchCat;
    private Timestamp branchUat;
    private String branchLocation;
    private String branchAddress;
    private Integer branchPincode;
    private Long branchPhone1;
    private String branchWebsite;
    private String branchGstin;
    private String branchTagline;
    private Long branchPhone2;
    private Long branchPhone3;

    @Id
    @Column(name = "id_branch", nullable = false)
    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    @Basic
    @Column(name = "branch_code", nullable = true, length = 4)
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Basic
    @Column(name = "branch_name", nullable = true, length = 30)
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Basic
    @Column(name = "branch_place", nullable = true, length = 20)
    public String getBranchPlace() {
        return branchPlace;
    }

    public void setBranchPlace(String branchPlace) {
        this.branchPlace = branchPlace;
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
    @Column(name = "branch_cat", nullable = true)
    public Timestamp getBranchCat() {
        return branchCat;
    }

    public void setBranchCat(Timestamp branchCat) {
        this.branchCat = branchCat;
    }

    @Basic
    @Column(name = "branch_uat", nullable = true)
    public Timestamp getBranchUat() {
        return branchUat;
    }

    public void setBranchUat(Timestamp branchUat) {
        this.branchUat = branchUat;
    }

    @Basic
    @Column(name = "branch_location", nullable = true, length = 30)
    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    @Basic
    @Column(name = "branch_address", nullable = true, length = 60)
    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    @Basic
    @Column(name = "branch_pincode", nullable = true)
    public Integer getBranchPincode() {
        return branchPincode;
    }

    public void setBranchPincode(Integer branchPincode) {
        this.branchPincode = branchPincode;
    }

    @Basic
    @Column(name = "branch_phone1", nullable = true)
    public Long getBranchPhone1() {
        return branchPhone1;
    }

    public void setBranchPhone1(Long branchPhone1) {
        this.branchPhone1 = branchPhone1;
    }

    @Basic
    @Column(name = "branch_website", nullable = true, length = 30)
    public String getBranchWebsite() {
        return branchWebsite;
    }

    public void setBranchWebsite(String branchWebsite) {
        this.branchWebsite = branchWebsite;
    }

    @Basic
    @Column(name = "branch_gstin", nullable = true, length = 20)
    public String getBranchGstin() {
        return branchGstin;
    }

    public void setBranchGstin(String branchGstin) {
        this.branchGstin = branchGstin;
    }

    @Basic
    @Column(name = "branch_tagline", nullable = true, length = 30)
    public String getBranchTagline() {
        return branchTagline;
    }

    public void setBranchTagline(String branchTagline) {
        this.branchTagline = branchTagline;
    }

    @Basic
    @Column(name = "branch_phone2", nullable = true)
    public Long getBranchPhone2() {
        return branchPhone2;
    }

    public void setBranchPhone2(Long branchPhone2) {
        this.branchPhone2 = branchPhone2;
    }

    @Basic
    @Column(name = "branch_phone3", nullable = true)
    public Long getBranchPhone3() {
        return branchPhone3;
    }

    public void setBranchPhone3(Long branchPhone3) {
        this.branchPhone3 = branchPhone3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return idBranch == branch.idBranch &&
                isDeleted == branch.isDeleted &&
                Objects.equals(branchCode, branch.branchCode) &&
                Objects.equals(branchName, branch.branchName) &&
                Objects.equals(branchPlace, branch.branchPlace) &&
                Objects.equals(branchCat, branch.branchCat) &&
                Objects.equals(branchUat, branch.branchUat) &&
                Objects.equals(branchLocation, branch.branchLocation) &&
                Objects.equals(branchAddress, branch.branchAddress) &&
                Objects.equals(branchPincode, branch.branchPincode) &&
                Objects.equals(branchPhone1, branch.branchPhone1) &&
                Objects.equals(branchWebsite, branch.branchWebsite) &&
                Objects.equals(branchGstin, branch.branchGstin) &&
                Objects.equals(branchTagline, branch.branchTagline) &&
                Objects.equals(branchPhone2, branch.branchPhone2) &&
                Objects.equals(branchPhone3, branch.branchPhone3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBranch, branchCode, branchName, branchPlace, isDeleted, branchCat, branchUat, branchLocation, branchAddress, branchPincode, branchPhone1, branchWebsite, branchGstin, branchTagline, branchPhone2, branchPhone3);
    }
}
