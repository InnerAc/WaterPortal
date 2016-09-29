package edu.hhu.portal.model;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import edu.hhu.portal.entity.J_DisplayModule;
import edu.hhu.portal.entity.J_News;

public class DisplayModule extends Model<DisplayModule>{
	public final static DisplayModule dao = new DisplayModule();
	
	public List<DisplayModule> findAll(){
		return find("SELECT * FROM DisplayModule");
	}
	
	public J_DisplayModule getDM(String DM_id){
		DisplayModule dm = findById(DM_id);
		J_DisplayModule jdm = new J_DisplayModule(dm.getStr("DM_id"), dm.getStr("DM_name"), dm.getStr("DM_service"), dm.getStr("DM_type"), dm.getStr("DM_size"), dm.getStr("DM_lvl"), dm.getStr("DM_disnum"), dm.getStr("DM_disid"), dm.getStr("DM_pictype"));
		if(jdm.getType().equals("2")){
			if(jdm.getDisid() == null || jdm.getDisid().equals("")){
				List<News> dnewss = News.dao.findBySuperId(DM_id, jdm.getDisnum());
				List<J_News> newss = new ArrayList<J_News>();
				for(News dnew : dnewss){
					newss.add(dnew.turnNews());
				}
				jdm.setNewss(newss);
			}else{
				String nids[] = jdm.getDisid().split(",");
				List<J_News> newss = new ArrayList<J_News>();
				for(String nid : nids){
					newss.add(News.dao.getNews(nid));
				}
				jdm.setNewss(newss);
			}
		}
		return jdm;
	}
}
