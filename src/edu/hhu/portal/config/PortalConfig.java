package edu.hhu.portal.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

import edu.hhu.portal.controller.ModuleController;
import edu.hhu.portal.controller.NewsController;
import edu.hhu.portal.controller.PageController;
import edu.hhu.portal.controller.TestController;
import edu.hhu.portal.model.DisplayModule;
import edu.hhu.portal.model.Files;
import edu.hhu.portal.model.News;

public class PortalConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		PropKit.use("sql.properties");
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/test",TestController.class);
		me.add("/module",ModuleController.class);
		me.add("/news",NewsController.class);
		me.add("/",PageController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		String sqlurl = PropKit.get("url").trim();
		String sqluser = PropKit.get("user").trim();
		String sqlpwd = PropKit.get("pwd").trim();
		C3p0Plugin cp = new C3p0Plugin(sqlurl,sqluser, sqlpwd);
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		arp.addMapping("DisplayModule", "DM_id", DisplayModule.class);
		arp.addMapping("News","N_id", News.class);
		arp.addMapping("Files","F_id" ,Files.class);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

}
