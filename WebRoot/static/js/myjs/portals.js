function fillapps(){
	apps = [['dagl','档案管理'],['szyxx','水资源信息管理'],['hhzy','河湖资源'],['gcgl','工程管理'],['hhkxc','河湖库巡查管理'],['stbc','水土保持监测管理'],['ntslsjtb','农田水利数据填报'],['ymgl','水利工程移民'],['fxfh','防汛防旱会商系统'],['szzfgl','水政执法管理'],['hdcs','河道采砂'],['nsbdmh','节水计量与监测监控系统'],['nsbdhs','工程监控系统'],['nsbdddyx','尾水导流工程运行监控系统'],['sqfx','水情分析'],['swsjcx','水文数据查询'],['sssjjh','水文数据交换'],['hdgl','河道管理'],['zyml','数据资源目录服务']];
	var appdiv = $('#apps');
	res = ''
	for(i=0;i<apps.length;i++){
		res += '<div class="col-md-1 col-sm-3"><center><a href=""><img class="img-responsive img-circle" alt="'
		res += apps[i][1];
		res += '" src="icon/';
		res += apps[i][0];
		res += '.png"/><span>'
		res += apps[i][1];
		res += '</span></a></center></div>\n';
	}
	appdiv.html(res);
}

function genModules(){
	dm_ids = $('#queue').html();
	$.get('/module/modules/'+dm_ids,function(data){
		dmodules = '';
		nn = data.length;
		for(var j=0;j<nn;j++){
			dmodules += genModule(data[j]);
		}
		$('#show_modules').html(dmodules);
		$(".glyphicon-chevron-up" ).on("click", function() {
			var icon = $(this);
			icon.toggleClass("ui-icon-minusthick ui-icon-plusthick" );
			icon.closest(".module").find(".mbody").toggle();
		});
	});
}

function genModule(module){
	dm = module.dm;
	newss = module.newss;
	var size = Number(dm.DM_SIZE) * 4
	dmodule = '';
	dmodule += '<div class="col-md-'+size+' col-lg-'+size+' col-sm-12"><div class="module" id="'+dm.DM_ID+'"><div class="mheader1">';
	dmodule += dm.DM_NAME;
	dmodule += '<div style="float:right;"><span class="glyphicon glyphicon-move"></span>\n<span class="glyphicon glyphicon-refresh"></span>\n<span class="glyphicon glyphicon-chevron-up"></span></div></div><div class="mbody">';
	if(newss.length > 0){//是列表新闻
		mbody = '<table class="table table-condensed table-hover"><tbody>';
		n = newss.length;
		for(i=0;i<n;i++){
			mbody +='<tr><td>'+newss[i].N_TITLE+'</td><td>'+newss[i].N_DATE+'</td></tr>';
		}
		mbody += '</tbody></table>';
		dmodule += mbody;
	}else{
		dmodule += "Test";
	}
	dmodule += '</div></div></div>';
	return dmodule;
}