function fillModule(module){
	var type = module.type;
	if(type == 1 || type == 2){
		fillNews(module);
	}
}

/**
 * 填充公告或新闻类型
 * @param module
 */
function fillNews(module){
	console.log(module);
	var div =  module.id;
	var title = module.name;
	var type = module.type;
	if(type == 1){	//公告类型
		var content = module.content
		var md = $('#'+div);
		str = '<div class="panel panel-success">\n<div class="panel-heading">'
		str += title;
		str += '<a style="float:right" href='+base_path+'"/mdlist/'+div+'">历史公告>></a></div><div class="panel-body">';
		str += content;
		str += '</div></div>';
		md.html(str);
	}
	if(type == 2){	//列表新闻类型
		var md = $('#'+div);
		str = '<div class="panel panel-success">\n<div class="panel-heading">'
		str += title;
		str += '<a style="float:right" href='+base_path+'"/news/list/'+div+'">更多>></a></div><div class="panel-body">';
		str += '<table class="table table-condensed table-hover"><tbody>';
		var newss = module.newss;
		for(i=0;i<newss.length;i++){
			str += '<tr><td><a href='+base_path+'"/news/'+newss[i].id+'">'+newss[i].title+'</a></td><td>'+newss[i].date+'</td></tr>'
		}
		str += '</tbody></table></div></div>'
		md.html(str);
	}
}