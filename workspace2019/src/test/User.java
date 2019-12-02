import java.util.Date;

@TableName("u_user")
public class User {
    //编号
    @ColumnName("c_id")
    private Integer id;
    //姓名
    @ColumnName("c_userName")
    private String userName;
    //生日
    @ColumnName("c_birthday")
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
