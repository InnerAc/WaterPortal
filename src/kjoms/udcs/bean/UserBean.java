package kjoms.udcs.bean;

import java.io.Serializable;

public class UserBean implements  Serializable {

	private static final long serialVersionUID = 1772198543000783432L;

	private String loginId;// Id

	private String password;// 密码

	private String userName;// 用户名称

	private String sortNo;// 顺序号

	private String birthday;// 生日

	private String gender;// 性别

	private String eduLevel;// 学历

	private String mailbox;// email

	private String position;// 职务

	private String cellphone;// 手机

	private String qq;// QQ号码

	private String telephone;// 联系电话

	private String remark;// 个人简介

	private String usbKey;// ubskey
	
    private String adminFlag = "0";
    
    private String relationFlag = "0";

    private String createId ;// 创建者

    private String createTime ;// 创建时间

    private String updateId ;// 更新者

    private String updateTime ;// 更新时间

    private String deleteFlag  = "0";// 删除标记

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the eduLevel
	 */
	public String getEduLevel() {
		return eduLevel;
	}

	/**
	 * @param eduLevel the eduLevel to set
	 */
	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	/**
	 * @return the mailbox
	 */
	public String getMailbox() {
		return mailbox;
	}

	/**
	 * @param mailbox the mailbox to set
	 */
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}

	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
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
	 * @return the usbKey
	 */
	public String getUsbKey() {
		return usbKey;
	}

	/**
	 * @param usbKey the usbKey to set
	 */
	public void setUsbKey(String usbKey) {
		this.usbKey = usbKey;
	}

	/**
	 * @return the adminFlag
	 */
	public String getAdminFlag() {
		return adminFlag;
	}

	/**
	 * @param adminFlag the adminFlag to set
	 */
	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	/**
	 * @return the relationFlag
	 */
	public String getRelationFlag() {
		return relationFlag;
	}

	/**
	 * @param relationFlag the relationFlag to set
	 */
	public void setRelationFlag(String relationFlag) {
		this.relationFlag = relationFlag;
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
