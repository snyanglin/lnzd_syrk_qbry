//居住地址截取
subjzddzxz = function(val, row, index){
	var xzqhmc = "";
	if(row.fwdz_dzxz==null||row.fwdz_dzxz==""){
		xzqhmc = row.fwdz_mlpxz;
	}else{
		xzqhmc = row.fwdz_dzxz;
	}
	return xzqhmc;
};
//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//列表格式化[显示核实/注销]
datagridProcessFormater = function(val,row,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var hs_status = rowData.hs_status;
	var xt_zxbz = rowData.xt_zxbz;
	if ("1" == xt_zxbz) {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">核实</a>&nbsp;'+
		'&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">注销</a>&nbsp;';
	} else {
		if ("01" == hs_status) {
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="syrkCheck(this, '+index+')">核实</a>&nbsp;'+
			'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCancel(this, '+index+')">注销</a>&nbsp;';
		} else if ("02" == hs_status) {
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">核实</a>&nbsp;'+
			'&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">注销</a>&nbsp;';
		}
	}
};
//实有房屋核实
syrkCheck = function(linkObject,index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	 menu_open('实有房屋核实',
			 '/syfw/createHS?mainTabID='+getMainTabID()
			 + '&isCheck=check'
			 + '&id=' + rowData.id);
};
//注销panel
doCancel = function(linkObject,index){
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		document.getElementById("xt_zxyy").value ="请输入注销原因...";
		document.getElementById("id").value =rowData.id;
		$("#win").window("open"); 
};
//关闭注销窗口	  
function closeWindow(){
	var zxyy = document.getElementById("xt_zxyy").value;
	if(zxyy!="请输入注销原因..." && zxyy!=""){
		if(confirm("数据还未保存，确定要关闭吗?")){
			$("#win").window("close");
		}
	}else{
		$("#win").window("close");
	}
};
//注销后台操作
function updateHs(){
	var id = document.getElementById("id").value;
	var sydwHsUrl= contextPath+"/syfw/" + id + "/delete";
	var xt_zxyy = document.getElementById("xt_zxyy").value;
	if(xt_zxyy!="" ){
		if(xt_zxyy.length>100){
			return;
		}else{
			$.ajax({
				type:"POST",
				sync:true,
				url:sydwHsUrl,
				data:{'id':id,'xt_zxyy':xt_zxyy,'xt_zxbz':1, 'isCheck':'check'},
				dataType:'json',
				success:function(json){
					if(json.status=='success'){
						$.messager.alert("提示","实有房屋注销成功","info");
						$("#win").window("close");
						$("#dg").datagrid("load");
					}else{
						$.messager.alert("提示","实有房屋注销失败","info");
					}
				}
			
			});	
		}
	}else{
		$.messager.alert("提示","请输入注销原因","info");
	}
}
//查询按钮
function queryButton(){
	var fz_xm = document.getElementById("fz_xm").value;
	var fwlbdm = document.getElementById("fwlbdm").value;
	var fwdz_dzxz = document.getElementById("fwdz_dzxz").value;
	var sfczfw = document.getElementById("sfczfw").value;
	var hs_status = document.getElementById("hs_status").value;
	var reloadUrl = contextPath + '/syfw/list?isCheck=check';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid('load',{    
		'fz_xm':fz_xm,
		'fwlbdm':fwlbdm,
		'fwdz_dzxz':fwdz_dzxz,
		'sfczfw':sfczfw,
		'hs_status':hs_status
	});
};
//列表表头样式
function dbrwStyler(value, rowData, index){
	return "<font style='font-weight:bold;'>"+value+"</font>";
}
//格式化列表日期格式
function formatDate(value, rowData, index){
	return value.substring(0, 10);
}
	