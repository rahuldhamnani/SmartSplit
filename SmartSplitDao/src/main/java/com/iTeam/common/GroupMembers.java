package com.iTeam.common;

/**
 * Created by rahuldhamnani on 4/17/16.
 * Comments -
 *
 *
 */

import java.io.Serializable;



import javax.persistence.*;

@Entity
@Table
@Embeddable
public class GroupMembers implements Serializable {


    private static final long serialVersionUID = 563328389604689177L;

    @Id
    @GeneratedValue
    @Column(name = "idGroupMembers")
    private int idGroupMembers;


    @Column(name = "UserID")
    private String userID;


    @Column(name = "GroupID")
    private int groupID;


    public GroupMembers()
    {

    }

    public GroupMembers(int groupID, String userID) {
        super();
        this.groupID = groupID;
        this.userID =userID;
    }

    public int getIdGroupMembers () {
        return  this.idGroupMembers;
    }

    public void setIdGroupMembers(int idGroupMembers)
    {
        this.idGroupMembers = idGroupMembers;
    }

    public int getGroupID() {return this.groupID;}

    public String getUserID() { return this.userID;}

    public void setGroupID( int  groupID)
    {
        this.groupID = groupID;
    }

    public  void setUserID (String userID)
    {
        this.userID = userID;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}

