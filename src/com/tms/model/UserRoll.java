package com.tms.model;

import java.util.Date;

public class UserRoll {
    private int UserRoll_id;
    private String UserRollName;
    private String CreatedBy;
    private String ModifiedBy;
    private Date CreatedDate;
    private Date ModifiedDate;

    public UserRoll(){}
public UserRoll(int UserRoll_id,String UserRollName,String CreatedBy,String ModifiedBy,Date CreatedDate,Date ModifiedDate){
        super();
        this.UserRoll_id=UserRoll_id;
        this.UserRollName=UserRollName;
        this.CreatedBy=CreatedBy;
        this.ModifiedBy=ModifiedBy;
        this.CreatedDate=CreatedDate;
        this.ModifiedDate=ModifiedDate;

}
    public UserRoll(String UserRollName,String CreatedBy,String ModifiedBy,Date CreatedDate,Date ModifiedDate){
        super();
        this.UserRollName=UserRollName;
        this.CreatedBy=CreatedBy;
        this.ModifiedBy=ModifiedBy;
        this.CreatedDate=CreatedDate;
        this.ModifiedDate=ModifiedDate;

    }
    /*getter here*/
    public int getUserRoll_id(){
        return UserRoll_id;
    }
    public String getUserRollName(){
        return UserRollName;
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

    /*setter here*/
    public void setUserRoll_id(int UserRoll_id){
        this.UserRoll_id=UserRoll_id;
    }
    public void setUserRollName(String UserRollName){
        this.UserRollName=UserRollName;
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
