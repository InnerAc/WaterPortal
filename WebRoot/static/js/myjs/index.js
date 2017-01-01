function login(){
	user = $('#userInfo');
	forms = '<form class="form-horizontal" action="'+base_path+'/login" method="POST"> <div class="form-group col-sm-12" style="margin-bottom:2px;"> <input type="text" class="form-control" name="userid" placeholder="用户名"/> </div> <div class="form-group col-sm-10" style="margin-bottom:0;"> <input type="password" class="form-control" name="pwd" placeholder="密码"/> </div> <div class="form-group  col-sm-2"  style="margin-bottom:0;"> <button type="submit" class="btn btn-default">登录</button> </div> </form>';
	user.html(forms);
}
function saveList(){
	modules_div = $('#show_modules');
	list = modules_div.find('.module');
	n = list.length;
	newlist = '';
	for(i=0;i<n;i++){
		if(i == 0){
			newlist += $(list[i]).attr('id');		
		}
		else{
			newlist += ','+$(list[i]).attr('id');
		}
	}
	console.log(newlist);

	apps_div = $('#apps');
	alist = apps_div.find('img')
	n = alist.length;
	newalist = '';
	for(i=0;i<n;i++){
		if(i == 0){
			newalist += $(alist[i]).attr('id');		
		}
		else{
			newalist += ','+$(alist[i]).attr('id');
		}
	}
	console.log(newalist);
	$.post(base_path+'/user/updateList/',{list:newlist});
	$.post(base_path+'/user/updateAPP/',{list:newalist});
}
function saveService(){
	modules_div = $('#show_modules');
	list = modules_div.find('.module');
	n = list.length;
	newlist = '';
	for(i=0;i<n;i++){
		if(i == 0){
			newlist += $(list[i]).attr('id');		
		}
		else{
			newlist += ','+$(list[i]).attr('id');
		}
	}
	console.log(newlist);

	apps_div = $('#apps');
	alist = apps_div.find('img')
	n = alist.length;
	newalist = '';
	for(i=0;i<n;i++){
		if(i == 0){
			newalist += $(alist[i]).attr('id');		
		}
		else{
			newalist += ','+$(alist[i]).attr('id');
		}
	}
	console.log(newalist);
	$.post(base_path+'/service/updateList/',{list:newlist});
	$.post(base_path+'/service/updateAPP/',{list:newalist});
}