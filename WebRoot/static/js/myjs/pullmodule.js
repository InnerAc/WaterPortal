function listmodule(dmid){
	url = "/module/module/"+dmid;
	$.get(base_path+url,function(data){
		dm = data.dm;
		newss = data.newss;
		fillmodule(dm,newss);
	});
}
function fillmodule(dm,newss){
	dmid = dm.DM_ID;
	var module = $('#'+dmid);
	var size = Number(dm.DM_SIZE) * 4
	res = '<div class="col-md-'+size+'"><div class="panel panel-primary"><div class="panel-heading"><h1 class="panel-title">';
	res += dm.DM_NAME;
	res += '</h1></div><div class="panel-body"><table class="table table-hover">';
	n = newss.length
	for(i =0;i<n;i++){
		tr = '<tr><td><a href='+base_path+'"/news/'+newss[i].N_ID+'">'+newss[i].N_TITLE+'</a></td><td>'+newss[i].N_DATE+'</td></tr>';
		res += tr;
	}
	res += '</table></div></div></div>';
	module.html(res);
}