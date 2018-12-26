package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-21
 */
@TableName("client_info")
public class Info extends Model<Info> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 角色
     */
    private Integer role;
    /**
     * 手机号
     */
    private Integer mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 注册时间
     */
    private Integer createTime;
    /**
     * 身份证号
     */
    private String IdCard;
    /**
     * 可否登录状态
     */
    private Integer status;


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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String IdCard) {
        this.IdCard = IdCard;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Info{" +
        ", id=" + id +
        ", userName=" + userName +
        ", realName=" + realName +
        ", role=" + role +
        ", mobile=" + mobile +
        ", password=" + password +
        ", avatar=" + avatar +
        ", createTime=" + createTime +
        ", IdCard=" + IdCard +
        ", status=" + status +
        "}";
    }
}
