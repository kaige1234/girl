package cn.com.ssm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * @ClassName CapitalSettlementConfig
 * @Description 资金方结算配置
 * @Author Administrator
 * @Date 2018/9/13 0013 上午 11:02
 * @Version 1.0
 **/
public class CapitalSettlementConfigBean implements Serializable{
    //主键
    private String strSettlementConfigId ;
    //主键
    private String strSettlementId;
    //开始生效日期
    private String strStartDate;
    //结束生效日期
    private String strEndDate;
    //结算类型 1-实时分账 2-提前还款结算 3-到期本息结算
    private Integer nSettlementType;
    //是否可以代偿 0-否 1-是
    private Integer isCompensatory;
    //是否反结算 0-否 1-是
    private Integer isCounterSettlement;
    //保证金费率
    private Integer nMarginRate;
    //创建人
    private String strCreator;
    //创建人姓名
    private String strCreatorName;
    //创建时间
    private Data dtCreateTime;
    //修改人
    private String strModifier;
    //修改人姓名
    private String strModifierName;
    //最后修改时间

    private Data dtModifyTime;
    //最后停用时间
    private Data dtDisableTime;
    //最后启用时间
    private Data dtEnableTime;
    //是否启用1-启用0-停用
    private Integer isEnabled;
    //数据状态 1-正常 0-删除
    private Integer nDataState;

    public String getStrSettlementConfigId() {
        return strSettlementConfigId;
    }

    public void setStrSettlementConfigId(String strSettlementConfigId) {
        this.strSettlementConfigId = strSettlementConfigId;
    }

    public String getStrSettlementId() {
        return strSettlementId;
    }

    public void setStrSettlementId(String strSettlementId) {
        this.strSettlementId = strSettlementId;
    }

    public String getStrStartDate() {
        return strStartDate;
    }

    public void setStrStartDate(String strStartDate) {
        this.strStartDate = strStartDate;
    }

    public String getStrEndDate() {
        return strEndDate;
    }

    public void setStrEndDate(String strEndDate) {
        this.strEndDate = strEndDate;
    }

    public Integer getnSettlementType() {
        return nSettlementType;
    }

    public void setnSettlementType(Integer nSettlementType) {
        this.nSettlementType = nSettlementType;
    }

    public Integer getIsCompensatory() {
        return isCompensatory;
    }

    public void setIsCompensatory(Integer isCompensatory) {
        this.isCompensatory = isCompensatory;
    }

    public Integer getIsCounterSettlement() {
        return isCounterSettlement;
    }

    public void setIsCounterSettlement(Integer isCounterSettlement) {
        this.isCounterSettlement = isCounterSettlement;
    }

    public Integer getnMarginRate() {
        return nMarginRate;
    }

    public void setnMarginRate(Integer nMarginRate) {
        this.nMarginRate = nMarginRate;
    }

    public String getStrCreator() {
        return strCreator;
    }

    public void setStrCreator(String strCreator) {
        this.strCreator = strCreator;
    }

    public String getStrCreatorName() {
        return strCreatorName;
    }

    public void setStrCreatorName(String strCreatorName) {
        this.strCreatorName = strCreatorName;
    }
    public Data getDtCreateTime() {
        return dtCreateTime;
    }

    public void setDtCreateTime(Data dtCreateTime) {
        this.dtCreateTime = dtCreateTime;
    }

    public String getStrModifier() {
        return strModifier;
    }

    public void setStrModifier(String strModifier) {
        this.strModifier = strModifier;
    }

    public String getStrModifierName() {
        return strModifierName;
    }

    public void setStrModifierName(String strModifierName) {
        this.strModifierName = strModifierName;
    }

    public Data getDtModifyTime() {
        return dtModifyTime;
    }

    public void setDtModifyTime(Data dtModifyTime) {
        this.dtModifyTime = dtModifyTime;
    }

    public Data getDtDisableTime() {
        return dtDisableTime;
    }

    public void setDtDisableTime(Data dtDisableTime) {
        this.dtDisableTime = dtDisableTime;
    }

    public Data getDtEnableTime() {
        return dtEnableTime;
    }

    public void setDtEnableTime(Data dtEnableTime) {
        this.dtEnableTime = dtEnableTime;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getnDataState() {
        return nDataState;
    }

    public void setnDataState(Integer nDataState) {
        this.nDataState = nDataState;
    }
}
