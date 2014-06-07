/**
 * http://www.developerscrappad.com/12/java/java-ee/ejb3-jpa-entity-one-to-one-relationship/
 */
package com.poolborges.example.jpaonetoone.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Borges
 */
@Entity
@Table(name = "APP_USER_DETAILS")
public class UserDetailsEntity implements Serializable {

    private static final long serialVersionUID = -5153047738832563340L;
    
    
    @Id
    @Column(name = "APP_USER_DETAILS_PK", nullable = false)
    private Long appUserDetailsPk;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "STATE_STR")
    private String stateStr;
    @Column(name = "COUNTRY_STR")
    private String countryStr;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "CONTACT")
    private String contact;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_USER_DETAILS_PK", referencedColumnName = "APP_USERS_PK", insertable = false, updatable = false)
    private UserEntity userEntity;

    public UserDetailsEntity() {
    }

    public UserDetailsEntity(String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getAppUserDetailsPk() {
        return appUserDetailsPk;
    }

    public void setAppUserDetailsPk(Long appUserDetailsPk) {
        this.appUserDetailsPk = appUserDetailsPk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getCountryStr() {
        return countryStr;
    }

    public void setCountryStr(String countryStr) {
        this.countryStr = countryStr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity usersEntity) {
        this.userEntity = usersEntity;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (appUserDetailsPk != null ? appUserDetailsPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetailsEntity)) {
            return false;
        }

        UserDetailsEntity other = (UserDetailsEntity) object;

        if ((this.appUserDetailsPk == null && other.appUserDetailsPk != null) || (this.appUserDetailsPk != null && !this.appUserDetailsPk.equals(other.appUserDetailsPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entity.UserDetailsEntity[ appUserDetailsPk=" + appUserDetailsPk + " ]";
        return String.format("entity.UserDetailsEntity[appUserDetailsPk=%s, firstName=%s, countryStr=%s]", appUserDetailsPk, firstName, countryStr);
    }
}