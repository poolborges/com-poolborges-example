package com.poolborges.example.jpaonetoone.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Borges
 */
@Entity
public class UserPermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PERMISSION_ID")
    private long permissionID;
    @Basic
    @Column(name = "DESCRIPT")
    private String description;
    @Basic
    @Column(name = "OPENDOC")
    private boolean openDoc;
    @Basic
    @Column(name = "CLOSEDOC")
    private boolean closeDoc;

    public long getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(long permissionID) {
        this.permissionID = permissionID;
    }

    public String getDescript() {
        return description;
    }

    public void setDescript(String descript) {
        this.description = descript;
    }

    public boolean isOpenDoc() {
        return openDoc;
    }

    public void setOpenDoc(boolean openDoc) {
        this.openDoc = openDoc;
    }

    public boolean isCloseDoc() {
        return closeDoc;
    }

    public void setCloseDoc(boolean closeDoc) {
        this.closeDoc = closeDoc;
    }
}
