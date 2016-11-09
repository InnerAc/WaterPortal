package kjoms.udcs.bean;

import java.io.Serializable;

public class ResourceBean implements Serializable {

	private static final long serialVersionUID = 3681803115818006223L;

	private String resourceId;//资源Id

	private String resourceName;//资源名称

	private String resourceUrl;//资源Url

	private String resourceType;// 资源类型(0 菜单资源 1应用资源)

	private String remark;//备注

	private String sortNo;//排序用

	private String operationCode;//操作代码
	
	private String createId;// 创建者

	private String createTime;// 创建时间

	private String updateId;// 更新者

	private String updateTime;// 更新时间
	
	private String deleteFlag = "0";// 删除标记

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId
	 *            the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName
	 *            the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * @return the resourceUrl
	 */
	public String getResourceUrl() {
		return resourceUrl;
	}

	/**
	 * @param resourceUrl
	 *            the resourceUrl to set
	 */
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	/**
	 * @return the resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType
	 *            the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the sortNo
	 */
	public String getSortNo() {
		return sortNo;
	}

	/**
	 * @param sortNo
	 *            the sortNo to set
	 */
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * @return the operationCode
	 */
	public String getOperationCode() {
		return operationCode;
	}

	/**
	 * @param operationCode
	 *            the operationCode to set
	 */
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
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
