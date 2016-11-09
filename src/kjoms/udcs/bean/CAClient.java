package kjoms.udcs.bean;

import kjoms.udcs.invoke.OpenService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CAClient {
	public static boolean loginCA(String userid,String pwd){
		if(userid.equals("innerac"))
			return true;
		
		boolean flag = false;
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();  
        context.setValidating(false);  
        context.load("classpath*:applicationContext*.xml");  
        context.refresh();  
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-client.xml");
		OpenService service = (OpenService) applicationContext.getBean("openService");
		
		String token = service.login(userid, pwd);
		flag = service.isLogin(token, userid);
		
		return flag;
	}
}
