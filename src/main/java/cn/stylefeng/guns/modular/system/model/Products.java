package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;

import java.io.File;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 产品表
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-21
 */
public class Products extends Model<Products> {

    private static final long serialVersionUID = 1L;

    /**
     * 产品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 产品名称
     */
    private String productTitle;
    /**
     * 产品图标
     */
    private String productIcon;
    /**
     * 产品广告语
     */
    private String productSlogen;
    /**
     * 产品种类 @mock=1 1.贷超平台 2.信用卡
     */
    private Integer productCategory;
    /**
     * 产品利率
     */
    private BigDecimal productRate;
    /**
     * 最高额度
     */
    private Integer productMaximum;
    /**
     * 最低可贷
     */
    private Integer productMinimum;
    /**
     * 产品网址
     */
    private String productUrl;
    /**
     * 热门falg
     */
    private Integer hotFlag;
    /**
     * 申请人数
     */
    private Integer applyCount;
    /**
     * 结算模式 @mock=1 1：日结 2：周结 3：月结 4：预留
     */
    private Integer checkoutMode;
    /**
     * 返佣模式 @mock=1 1：注册返 2：下款返 3：信用卡首刷返
     */
    private Integer bonusMode;
    /**
     * 计佣形式 @mock=1 1：固定数额 2：百分比 3：预留
     */
    private Integer bonusType;
    /**
     * 返佣金额，需要对照返佣模式、计佣形式配合使用
     */
    private BigDecimal bonusValue;
    /**
     * 返佣比例（百分比的值），需要对照返佣模式、计佣形式配合使用
     */
    private BigDecimal bonusRate;
    /**
     * 代理分享页面的网址
     */
    private String agenShareUrl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public String getProductSlogen() {
        return productSlogen;
    }

    public void setProductSlogen(String productSlogen) {
        this.productSlogen = productSlogen;
    }

    public Integer getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Integer productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getProductRate() {
        return productRate;
    }

    public void setProductRate(BigDecimal productRate) {
        this.productRate = productRate;
    }

    public Integer getProductMaximum() {
        return productMaximum;
    }

    public void setProductMaximum(Integer productMaximum) {
        this.productMaximum = productMaximum;
    }

    public Integer getProductMinimum() {
        return productMinimum;
    }

    public void setProductMinimum(Integer productMinimum) {
        this.productMinimum = productMinimum;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public Integer getHotFlag() {
        return hotFlag;
    }

    public void setHotFlag(Integer hotFlag) {
        this.hotFlag = hotFlag;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getCheckoutMode() {
        return checkoutMode;
    }

    public void setCheckoutMode(Integer checkoutMode) {
        this.checkoutMode = checkoutMode;
    }

    public Integer getBonusMode() {
        return bonusMode;
    }

    public void setBonusMode(Integer bonusMode) {
        this.bonusMode = bonusMode;
    }

    public Integer getBonusType() {
        return bonusType;
    }

    public void setBonusType(Integer bonusType) {
        this.bonusType = bonusType;
    }

    public BigDecimal getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(BigDecimal bonusValue) {
        this.bonusValue = bonusValue;
    }

    public BigDecimal getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(BigDecimal bonusRate) {
        this.bonusRate = bonusRate;
    }

    public String getAgenShareUrl() {
        return agenShareUrl;
    }

    public void setAgenShareUrl(String agenShareUrl) {
        this.agenShareUrl = agenShareUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Products{" +
        ", id=" + id +
        ", productTitle=" + productTitle +
        ", productIcon=" + productIcon +
        ", productSlogen=" + productSlogen +
        ", productCategory=" + productCategory +
        ", productRate=" + productRate +
        ", productMaximum=" + productMaximum +
        ", productMinimum=" + productMinimum +
        ", productUrl=" + productUrl +
        ", hotFlag=" + hotFlag +
        ", applyCount=" + applyCount +
        ", checkoutMode=" + checkoutMode +
        ", bonusMode=" + bonusMode +
        ", bonusType=" + bonusType +
        ", bonusValue=" + bonusValue +
        ", bonusRate=" + bonusRate +
        ", agenShareUrl=" + agenShareUrl +
        "}";
    }
}
