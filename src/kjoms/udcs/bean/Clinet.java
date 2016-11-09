package kjoms.udcs.bean;

import java.util.List;

import kjoms.udcs.invoke.OpenService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Clinet {
	public static void main(String args[]){
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();  
        context.setValidating(false);  
        context.load("classpath*:applicationContext*.xml");  
        context.refresh();  
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-client.xml");
		OpenService service = (OpenService) applicationContext.getBean("openService");
		List<OrgUnitBean> units = service.getTopOrgUnitList();
		System.out.println(units.size());
		
		String token = service.login("caos", "111111");
		System.out.println(service.getLoginIdByToken(token));
		UserBean user = service.getUserByLoginId("caos");
		System.out.println(service.isLogin(token, "caos"));
		
		
		
		System.out.println("token = " + user.getUserName());
//		for(OrgUnitBean o:units)
//			System.out.println(o);
	}
}
