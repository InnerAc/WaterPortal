function genModules(){
	dm_ids = $('#dm_queue').html();
	$.get(base_path+'/module/modules/'+dm_ids,function(data){
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
		// $('.carousel').carousel({
  //          interval: 1000
  //         });
		$('.carousel').carousel('cycle');
	});
}

function genModule(module){
	dm = module.dm;
	newss = module.newss;
	var size = Number(dm.DM_SIZE) * 4
	dmodule = '';
	dmodule += '<div class="col-md-'+size+' col-lg-'+size+' col-sm-12"><div class="module" id="'+dm.DM_ID+'"><div class="mheader1">';
	dmodule += dm.DM_NAME;
	dmodule += '<div style="float:right;"><span class="glyphicon glyphicon-move"></span>\n<span class="glyphicon glyphicon-chevron-up"></span></div></div>';
	if(dm.DM_TYPE == '1'){//是列表新闻
		dmodule = dmodule.substring(0,dmodule.length-111);
		dmodule += '<a target="_Blank" href="'+base_path+'/news/list/'+dm.DM_ID+'" style="color:#fff;"><span class="glyphicon glyphicon-align-justify"></span></a>\n';
		dmodule += '<span class="glyphicon glyphicon-move"></span>\n<span class="glyphicon glyphicon-chevron-up"></span></div></div>'
		dmodule += '<div class="mbody">';
		mbody = '<table class="table table-condensed table-hover"><tbody>';
		n = newss.length;
		for(i=0;i<n;i++){
			mbody +='<tr><td  width="75%"><a target="_Blank" href="'+base_path+'/news/'+newss[i].N_ID+'">'+newss[i].N_TITLE+'</td><td>'+newss[i].N_DATE+'</td></tr>';
		}
		mbody += '</tbody></table>';
		dmodule += mbody;
	}
	if(dm.DM_TYPE == '2'){//显示公告
		if(newss.length > 0){
			dmodule = dmodule.substring(0,dmodule.length-111);
			dmodule += '<a target="_Blank" href="'+base_path+'/news/'+newss[0].N_ID+'" style="color:#fff;"><span class="glyphicon glyphicon-arrow-right"></span></a>\n';
			dmodule += '<span class="glyphicon glyphicon-move"></span>\n<span class="glyphicon glyphicon-chevron-up"></span></div></div>'
			
			dmodule += '<div class="mbody">';
			dmodule += '<h4>'+newss[0].N_TITLE+'</h4>';
			dmodule += newss[0].N_CONTENT;
		}else{
			dmodule += '<div class="mbody">';
			dmodule += '暂无公告';
		}
	}
	if(dm.DM_TYPE == '3'){
		dmodule += '<div class="mbody">';
		if(newss.length > 0){
			n = newss.length;
			dmodule += '<div id="pic'+dm.DM_ID+'" class="carousel slide"  data-ride="carousel" data-interval="1000" data-wrap="true"><div class="carousel-inner">';
			for(i=0;i<n;i++){
				if(i == 0){
					dmodule += '<div class="active item">';
				}else{
					dmodule += '<div class="item">';
				}
				dmodule += '<a target="_Blank" href="'+newss[i].N_PICTARGER+'"><img class="img-responsive" alt="'+newss[i].N_TITLE+'" src="'+base_path+'/static/image/'+newss[i].N_PICSRC+'"</img></a></div>';
			}
			dmodule += '</div>';
			dmodule += '<a class="carousel-control left" href="#pic'+dm.DM_ID+'" data-slide="prev">&lsaquo;</a><a class="carousel-control right" href="#pic'+dm.DM_ID+'" data-slide="next">&rsaquo;</a></div>';
		}else{
			dmodule += '暂无公告';
		}
	}
	if(dm.DM_TYPE == '4'){
		dmodule += '<div class="mbody tab-wrapper">';
		idms = module.dms;
		nnn = idms.length;
		mbody = '<form>';
		for(k=0;k<nnn;k++){
			dm = idms[k].dm;
			newss = idms[k].newss;
			if(k == 0){
				mbody += '<input type="radio" name="tab-radio" class="tab-radio" id="'+dm.DM_ID+'" checked><label for="'+dm.DM_ID+'" class="tab-handler">'+dm.DM_NAME+'</label>';
			}else{
				mbody += '<input type="radio" name="tab-radio" class="tab-radio" id="'+dm.DM_ID+'"><label for="'+dm.DM_ID+'" class="tab-handler">'+dm.DM_NAME+'</label>';
			}
			mbody += '<div class="tab-content">'
				if(dm.DM_TYPE == '1'){//是列表新闻
					mbody += '<table class="table table-condensed table-hover"><tbody>';
					n = newss.length;
					mbody += '<tr><td width="75%"></td><td style="float:right"><a target="_Blank" href="'+base_path+'/news/list/'+dm.DM_ID+'">更多>></a></td></tr>'
					for(i=0;i<n;i++){
						mbody +='<tr><td><a target="_Blank" href="'+base_path+'/news/'+newss[i].N_ID+'">'+newss[i].N_TITLE+'</td><td>'+newss[i].N_DATE+'</td></tr>';
					}
					mbody += '</tbody></table>';
				}
				if(dm.DM_TYPE == '2'){//显示公告
					if(newss.length > 0){
						mbody += '<h4>'+newss[0].N_TITLE+'</h4>';
						mbody += newss[0].N_CONTENT;
					}else{
						mbody += '暂无公告';
					}
				}
				if(dm.DM_TYPE == '3'){
					if(newss.length > 0){
						n = newss.length;
						mbody += '<div id="pic'+dm.DM_ID+'" class="carousel slide"  data-ride="carousel" data-interval="1000"><div class="carousel-inner">';
						for(i=0;i<n;i++){
							if(i == 0){
								mbody += '<div class="active item">';
							}else{
								mbody += '<div class="item">';
							}
							mbody += '<a target="_Blank" href="'+newss[i].N_PICTARGER+'"><img class="img-responsive" alt="'+newss[i].N_TITLE+'" src="'+base_path+'/static/image/'+newss[i].N_PICSRC+'"</img></a></div>';
						}
						mbody += '</div>';
						mbody += '<a class="carousel-control left" href="#pic'+dm.DM_ID+'" data-slide="prev">&lsaquo;</a><a class="carousel-control right" href="#pic'+dm.DM_ID+'" data-slide="next">&rsaquo;</a></div>';
					}else{
						mbody += '暂无公告';
					}
				}
				if(dm.DM_TYPE == '5'){
					mbody += '<iframe height="100%" width="100%" src="'+newss[0].N_PICTARGER+'"></iframe>'
				}
			mbody += '</div>';
		}
		mbody += '</form>';
		dmodule += mbody;
	}
	if(dm.DM_TYPE == '5'){
		dmodule = dmodule.substring(0,dmodule.length-111);
		dmodule += '<a target="_Blank" href="'+newss[0].N_PICTARGER+'" style="color:#fff;"><span class="glyphicon glyphicon-arrow-right"></span></a>\n';
		dmodule += '<span class="glyphicon glyphicon-move"></span>\n<span class="glyphicon glyphicon-chevron-up"></span></div></div>'
		dmodule += '<div class="mbody">  <iframe height="100%" width="100%" src="'+newss[0].N_PICTARGER+'"></iframe>';
	}
	dmodule += '</div></div></div>';
	return dmodule;
}

function genAPPS(){
	username = encodeURI(encodeURI($('#service_name').html()));
	token = $('#token').html();
	app_ids = $('#app_queue').html();
	userid = $('#userid').html();
	$.get(base_path+'/app/list/'+app_ids,function(data){
		appshtml = '';
		nn = data.length;
		for(j =0;j<nn;j++){
			app = data[j];
			if(app.A_ID == '19'){
				appshtml += '<div class="col-md-1 col-sm-3"><center><a target="_Blank" href="'+app.A_URL+'?username='+username+'"><img id="'+app.A_ID+'" class="img-responsive img-circle" alt="'+app.A_NAME+'" src="'+base_path+'/static/icon/'+app.A_ICON+'"/><span>'+app.A_NAME+'</span></a></center></div>';
			}else if(app.A_ID == '21'){
				appshtml += '<div class="col-md-1 col-sm-3"><center><a target="_Blank" href="'+app.A_URL+'/caLoginElse?hpToken='+token+'&currentLoginName='+userid+'&url='+app.A_URL+'"><img id="'+app.A_ID+'" class="img-responsive img-circle" alt="'+app.A_NAME+'" src="'+base_path+'/static/icon/'+app.A_ICON+'"/><span>'+app.A_NAME+'</span></a></center></div>';
			}else{
				appshtml += '<div class="col-md-1 col-sm-3"><center><a target="_Blank" href="'+app.A_URL+'?token='+token+'&loginid='+userid+'"><img id="'+app.A_ID+'" class="img-responsive img-circle" style="width:100%;margin-bottom:5%;" alt="'+app.A_NAME+'" src="'+base_path+'/static/icon/'+app.A_ICON+'"/><span>'+app.A_NAME+'</span></a></center></div>';
			}
		}
		$('#apps').html(appshtml);
		$('#apps').sortable();
		$('#apps').disableSelection();
	});
}