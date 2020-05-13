package com.tms.model;

import java.util.Date;

public class UserGroup {
    private int UserGroup_id;
    private String UserGroupName;

    private String CreatedBy;
    private String ModifiedBy;
    private Date CreatedDate;
    private Date ModifiedDate;

    public UserGroup(int UserGroup_id, String UserGroupName, String CreatedBy, String ModifiedBy, Date CreatedDate, Date ModifiedDate) {
        super();
        this.UserGroup_id = UserGroup_id;
        this.UserGroupName = UserGroupName;

        this.CreatedBy = CreatedBy;
        this.ModifiedBy = ModifiedBy;
        this.CreatedDate = CreatedDate;
        this.ModifiedDate = ModifiedDate;
    }
    public UserGroup( String UserGroupName, String CreatedBy, String ModifiedBy, Date CreatedDate, Date ModifiedDate) {
        super();
        this.UserGroupName = UserGroupName;

        this.CreatedBy = CreatedBy;
        this.ModifiedBy = ModifiedBy;
        this.CreatedDate = CreatedDate;
        this.ModifiedDate = ModifiedDate;
    }


/*Getter*/
    public int getUserGroup_id(){
        return UserGroup_id;
    }
    public String getUserGroupName(){
        return UserGroupName;
    }
    public String getCreatedBy(){
        return CreatedBy;
    }
    public String getModifiedBy(){
        return ModifiedBy;
    }
    public Date getCreatedDate(){
        return CreatedDate;
    }
    public Date getModifiedDate(){
        return ModifiedDate;
    }


    /*Setter*/
    public void setUserGroup_id(int UserGroup_id){
        this.UserGroup_id=UserGroup_id;
    }
    public void setUserGroupName(String UserGroupName){
        this.UserGroupName=UserGroupName;
    }
    public void setCreatedBy(String CreatedBy){
        this.CreatedBy=CreatedBy;
    }
    public void setModifiedBy(String ModifiedBy){
        this.ModifiedBy=ModifiedBy;
    }
    public void setCreatedDate(Date CreatedDate){
        this.CreatedDate=CreatedDate;
    }
    public void setModifiedDate(Date ModifiedDate){
        this.ModifiedDate=ModifiedDate;
    }

}
