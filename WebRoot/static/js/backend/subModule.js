function addModule(span){
	clickspan = $(span);
	mservice = clickspan.attr('targetservice');
	mname = clickspan.attr('targetname');
	mid= clickspan.attr('targetid');
	apushtohtml(mname,mid,mservice)
	li = clickspan.parents('li');
	li.remove();
}
function apushtohtml(mname,mid,mservice){
	div = $('#sm-modules');
	module = '<div class="col-md-4 col-sm-4 col-xs-12 mod"><section class="panel panel-default"><header class="panel-heading bg-info lt no-border h4" style="cursor:pointer;" id="'+mid+'" name="'+mname+'" service="'+mservice+'">'+mname+'</header><h4><i class="fa fa-times bg-danger" style="cursor:pointer;" onclick="deleteModule(this);"></i>'+mservice+'</h4></section></div>';
	div.append(module);
}
function deleteModule(i){
	i = $(i);
	header = i.parent().prev();
	mname = header.attr('name');
	mid = header.attr('id');
	mservice = header.attr('service');
	dpushtohtml(mname,mid,mservice)
	console.log(mid+' '+mname+' '+mservice);
	div = header.parent().parent();
	div.remove();
}
function dpushtohtml(mname,mid,mservice){
	div = $('#sm-modules-all');
	module = '<li class="list-group-item"><span class="pull-right" ><i>'+mservice+'</i><span targetid="'+mid+'" targetname="'+mname+'" targetservice="'+mservice+'" onclick="addModule(this);" style="cursor:pointer;"><i class="fa fa-plus icon-muted fa-fw m-r-xs bg-info"></i></span></span><span class="pull-left media-xs"><i class="fa fa-dot-circle-o"></i></span><a class="clear">'+mname+'</a></li>';
	div.append(module);
}
function save(){
	div = $('#sm-modules');
	headers = div.find('header');
	n = headers.length;
	list = '';
	for(i=0;i<n;i++){
		if(i == 0){
			list = $(headers[i]).attr('id');
		}else{
			list += ','+$(headers[i]).attr('id');
		}
	}
	$.post('/user/updateList/',{list:list},function(data){
		alert("保存成功！！");
	});
}
function init(){
	lists = $('#queue').html();
	lists = lists.split(',');
	ul = $('#sm-modules-all');
	spans = ul.find('span');
	m = spans.length;
	n = lists.length;
	for(i=0;i<n;i++){
		for(j=0;j<m;j++){
			if($(spans[j]).attr('targetid') == lists[i]){
				addModule(spans[j]);
			}
		}
	}
}