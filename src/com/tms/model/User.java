package com.tms.model;
import java.util.Date;

public class User{
    private int User_id;
    private String UserName;
    private String UserLoginName;
    private String Password;
    private int UserGroup_id;
    private int QRAndThump_id;
    private int Registration_id;
    private String CreatedBy;
    private String ModifiedBy;
    private Date CreatedDate;
    private Date ModifiedDate;

    public User(){}

    /*Constructor with id */
    public User(int User_id,String UserName, String UserLoginName,String Password, int UserGroup_id, int QRAndThump_id, int Registration_id, String CreatedBy, String ModifiedBy, Date CreatedDate, Date ModifiedDate) {
        super();
        this.User_id = User_id;
        this.UserName=UserName;
        this.UserLoginName = UserLoginName;
        this.Password=Password;
        this.UserGroup_id = UserGroup_id;
        this.QRAndThump_id = QRAndThump_id;
        this.Registration_id = Registration_id;
        this.CreatedBy = CreatedBy;
        this.ModifiedBy = ModifiedBy;
        this.CreatedDate = CreatedDate;
        this.ModifiedDate = ModifiedDate;
    }

    /*Constructor without id*/

    public User(String UserName,String UserLoginName,String Password, int UserGroup_id, int QRAndThump_id, int Registration_id, String CreatedBy, String ModifiedBy, Date CreatedDate, Date ModifiedDate) {
       super();
       this.UserName=UserName;
        this.UserLoginName = UserLoginName;
        this.Password=Password;
        this.UserGroup_id = UserGroup_id;
        this.QRAndThump_id = QRAndThump_id;
        this.Registration_id = Registration_id;
        this.CreatedBy = CreatedBy;
        this.ModifiedBy = ModifiedBy;
        this.CreatedDate = CreatedDate;
        this.ModifiedDate = ModifiedDate;
    }

    /*Here is Getter*/
    public int getUser_id(){
        return User_id;
    }
    public String getUserName(){return UserName;}
    public String getUserLoginName() {
        return UserLoginName;
    }
    public String getPassword(){
        return Password;
    }
    public int getUserGroup_id(){
        return UserGroup_id;
    }
    public int getQRAndThump_id(){
        return QRAndThump_id;
    }
    public int getRegistration_id(){
        return Registration_id;
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

    /*Here is Setter*/
    public void setUser_id(int User_id){
        this.User_id=User_id;
    }
    public void setUserName(String UserName){ this.UserName=UserName;}
    public void setUserLoginName(String UserLoginName){
        this.UserLoginName=UserLoginName;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public void setUserGroup_id(int UserGroup_id){
        this.UserGroup_id=UserGroup_id;
    }
    public void setQRAndThump_id(int QRAndThump_id){
        this.QRAndThump_id=QRAndThump_id;
    }
    public void setRegistration_id(int Registration_id){
        this.Registration_id=Registration_id;
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
