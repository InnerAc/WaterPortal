package kjoms.udcs.invoke;

import java.util.List;

import kjoms.udcs.bean.OrgUnitBean;
import kjoms.udcs.bean.ResourceBean;
import kjoms.udcs.bean.UserBean;

public interface OpenService {

	public String getHello(String name);

	/**
	 * 根据登录Id及密码登录
	 * 
	 * @param loginId
	 * @param password
	 * @return 登录成功返回登录token
	 */
	public String login(String loginId,String password); 
	
	/**
	 * 根据keyId登录
	 * 
	 * @param keyId
	 * @return 登录成功返回登录token
	 */
	public String login(String keyId); 
	
	/**
	 * 根据token值及登录Id，判断用户是否已登录
	 * 
	 * @param token token值
	 * @param loginId 登录Id
	 * @return 是否已登录
	 */
	public boolean isLogin(String token, String loginId);
	
	/**
	 * 根据token值获取用户登录Id
	 * 
	 * @return 用户登录Id
	 */
	public String getLoginIdByToken(String token);
	
	/**
	 * 修改登录用户密码
	 * 
	 * @param token token值
	 * @param loginId 登录Id
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return 修改结果
	 */
	public boolean modifyPassword(String token, String loginId,String oldPassword,String newPassword);

	/**
	 * 根据登录Id获取登录用户信息
	 * 
	 * @param loginId 用户登录Id
	 * @return 用户信息
	 */
	public UserBean getUserByLoginId(String loginId);
	
	/**
	 * 根据机构Id获取用户列表
	 * 
	 * @param unitId 机构Id
	 * @param type (0:仅本机构用户 1:本机构及所有下属机构用户)
	 * @return 用户列表
	 */
	public List<UserBean> getUserByUnitId(String unitId,String type);
	
	/**
	 * 根据登录Id获取用户所属组织机构
	 * 
	 * @param loginId 登录Id
	 * @return 用户所属组织机构
	 */
	public OrgUnitBean getOrgUnitByLoginId(String loginId);
	
	/**
	 * 获取机构信息
	 * 
	 * @param unitId 机构Id
	 * @return 机构信息
	 */
	public OrgUnitBean getOrgUnitByUnitId(String unitId);
	
	/**
	 * 获取顶级组织机构信息列表
	 * 
	 * @return 顶级组织机构信息列表
	 */
	public List<OrgUnitBean> getTopOrgUnitList();
	
	/**
	 * 获取子机构列表
	 * 
	 * @param unitId 父机构Id
	 * @param type (0:仅子机构 1:子机构及所有下属机构)
	 * @return 机构列表
	 */
	public List<OrgUnitBean> getSubOrgUnitList(String unitId,String type);
	
	/**
	 * 根据登录Id获取用户资源列表
	 * 
	 * @param loginId 登录Id
	 * @return 资源列表
	 */
	public List<ResourceBean> getResourceByLoginId(String loginId);
	
	/**
	 * 根据登录Id获取用户资源列表
	 * 
	 * @param loginId 登录Id
	 * @param operationCode 操作代码
	 * @return 资源列表
	 */
	public List<ResourceBean> getResourceByLoginId(String loginId, String operationCode);
	
	/**
	 * 根据资源Id获取用户列表
	 * 
	 * @param resourceId 资源Id
	 * @param operationCode 操作代码
	 * @return 用户列表
	 */
	public List<UserBean> getUserByResourceId(String resourceId, String operationCode);
	
	/**
	 * 添加资源
	 * 
	 * @param resource 资源信息
	 * @param loginId 管理者登录Id
	 * @return 新增结果
	 */
	public boolean addResource(ResourceBean resource,String loginId);
	
	/**
	 * 保存资源信息
	 * 
	 * @param resource 资源信息
	 * @return 保存结果
	 */
	public boolean saveResource(ResourceBean resource);
	
	/**
	 * 删除指定资源
	 * 
	 * @param resourceId 资源Id
	 * @return 返回删除结果
	 */
	public boolean removeResource(String resourceId);
	
	/**
	 * 添加资源相关权限
	 * 
	 * @param resourceId 资源Id
	 * @param loginId 登录Id
	 * @param operationCode 操作代码
	 * @return 返回添加结果
	 */
	public boolean addResourceRight(String resourceId,String loginId,String operationCode);
	
	/**
	 * 删除资源指定权限
	 * 
	 * @param resourceId 资源Id
	 * @param loginId 用户登录Id
	 * @param operationCode 操作代码
	 * @return 返回删除结果
	 */
	public boolean removeResourceRight(String resourceId,String loginId,String operationCode);

}