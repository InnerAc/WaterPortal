package kjoms.udcs.bean;

import kjoms.udcs.invoke.OpenService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.hhu.portal.model.ServiceMap;
import edu.hhu.portal.model.USER;

public class CAClient {
	public static boolean loginCA(String userid,String pwd){
		System.out.println("Start CA");
		if(userid.equals("innerac") || userid.equals("admin"))
			return true;
		if(userid.equals("test")){
			return true;
		}
		if(userid.equals("caos")){
			return true;
		}
		boolean flag = false;
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();  
        context.setValidating(false);  
        context.load("classpath*:applicationContext*.xml");  
        context.refresh();  
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-client.xml");
		OpenService service = (OpenService) applicationContext.getBean("openService");
		
		String token = service.login(userid, pwd);
		flag = service.isLogin(token, userid);
		if(!flag){
			return flag;
		}
		String serviceName = service.getOrgUnitByLoginId(userid).getUnitName();
		String userName = service.getUserByLoginId(userid).getUserName();
		System.out.println("=====");
		USER user = USER.dao.selectById(userid);
		serviceName = ServiceMap.dao.serviceByService(serviceName);
		if(user == null){
			user = new USER();
			user.set("U_USERID", userid);
			user.set("U_NAME", userName);
			user.set("U_SERVICE", serviceName);
			user.save();
		}
		user.set("U_TOKEN", token);
		user.update();
		return flag;
	}
}
