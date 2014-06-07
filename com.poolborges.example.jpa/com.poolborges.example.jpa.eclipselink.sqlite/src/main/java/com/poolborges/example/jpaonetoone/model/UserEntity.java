/**
 * http://www.developerscrappad.com/12/java/java-ee/ejb3-jpa-entity-one-to-one-relationship/
 */
package com.poolborges.example.jpaonetoone.model;

/**
 *
 * @author Borges
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USERS")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -6473246407313338480L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APP_USERS_PK", nullable = false)
    private Long appUsersPk;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @OneToOne(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private UserDetailsEntity userDetailsEntity;

    public UserEntity() {
    }

    public UserEntity(Long appUsersPk) {

        this.appUsersPk = appUsersPk;
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Long getAppUsersPk() {
        return appUsersPk;
    }

    public void setAppUsersPk(Long appUsersPk) {
        this.appUsersPk = appUsersPk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetailsEntity getUserDetailsEntity() {
        return userDetailsEntity;
    }

    public void setUserDetailsEntity(UserDetailsEntity userDetailsEntity) {
        this.userDetailsEntity = userDetailsEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appUsersPk != null ? appUsersPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }

        UserEntity other = (UserEntity) object;

        if ((this.appUsersPk == null && other.appUsersPk != null) || (this.appUsersPk != null && !this.appUsersPk.equals(other.appUsersPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entity.UsersEntity[ appUsersPk=" + appUsersPk + ", ]";
        return String.format("entity.UsersEntity[id=%s, username=%s, password=%s, userDetailsEntity=%s]", appUsersPk, username, password, userDetailsEntity);
    }
}
