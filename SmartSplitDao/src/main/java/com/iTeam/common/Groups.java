package com.iTeam.common;

/**
 * Created by rahuldhamnani on 4/17/16.
 * Comments -
 *
 *
 */

//import javax.persistence.*;
import java.io.Serializable;

//import java.io.Serializable;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Groups implements Serializable {


    private static final long serialVersionUID = 563328389604689177L;

    @Id
    @GeneratedValue
    @Column(name = "GroupID")
    private int groupid;


    @Column(name = "Name")
    private String name;

    @Column(name = "CreatedBy")
    private String createdBy;


    @Column(name="DateCreated")
    private String dateCreated;


    public Groups()
    {}

    public Groups(int groupid, String name, String createdBy, String dateCreated) {
        super();
        this.groupid = groupid;
        this.name = name;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;

    }



    public int getgroupId()
    {
        return groupid;
    }

    public String getName()
    {
        return name;
    }

    public String getDateCreated(String addedBy)
    {
        return dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;

    }

   public void setGroupid(int groupid)
   { this.groupid = groupid;
   }

    public void setName(String name) {
        this.name = name;
    }
    public void setCreatedBy(String createdBy)
    { this.createdBy = createdBy;}

    public void setDateCreated(String dateCreated)
    { this.dateCreated = dateCreated;}


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
