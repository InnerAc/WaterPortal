package kjoms.udcs.bean;

import java.io.Serializable;

public class OrgUnitBean implements  Serializable {

	private static final long serialVersionUID = 876669114240479560L;

	private String unitId;//机构Id

	private String unitName;// 机构名称

	private String unitCode;// 机构代码

	private String keyCode;// 全宗号

	private String shortName;// 机构简称

	private String remark;// 机构简介

	private String unitKind;// 机构类型（单位、部门）

	private String telephone;// 联系电话

	private String address;// 联系地址
	
	private String topFlag = "0";

	private String sortNo;// 顺序号

	private String createId;// 创建者

	private String createTime;// 创建时间

	private String updateId;// 更新者

	private String updateTime;// 更新时间

	private String deleteFlag = "0";// 删除标记

	/**
	 * @return the unitId
	 */
	public String getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the unitCode
	 */
	public String getUnitCode() {
		return unitCode;
	}

	/**
	 * @param unitCode the unitCode to set
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
	 * @return the keyCode
	 */
	public String getKeyCode() {
		return keyCode;
	}

	/**
	 * @param keyCode the keyCode to set
	 */
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the unitKind
	 */
	public String getUnitKind() {
		return unitKind;
	}

	/**
	 * @param unitKind the unitKind to set
	 */
	public void setUnitKind(String unitKind) {
		this.unitKind = unitKind;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the topFlag
	 */
	public String getTopFlag() {
		return topFlag;
	}

	/**
	 * @param topFlag the topFlag to set
	 */
	public void setTopFlag(String topFlag) {
		this.topFlag = topFlag;
	}

	/**
	 * @return the sortNo
	 */
	public String getSortNo() {
		return sortNo;
	}

	/**
	 * @param sortNo the sortNo to set
	 */
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * @return the createId
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * @param createId the createId to set
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateId
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * @param updateId the updateId to set
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
}
