<!--  
	@Author: [xu_haibo@founder.com]
	@CreateDate:   [2015-6-29 上午8:51:54]
-->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技防责令通知书</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/sydw/sydwWord.css"><link/>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>jfjfjctz/saveJfzltzs" id="dataForm" name="dataForm" method="post">
			<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
			<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<input type="hidden" name="wh" id="wh" value="${entity.wh}" />
			<input type="hiddem" name="gzsj" id="gzsj" value="${entity.gzsj}">
			<input type="hiddem" name="gzfs" id="gzfs" value="${entity.gzfs}">
			<input type="hiddem" name="operation" id="operation" value="${entity.operation}">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<table id="table" border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox text" style="width: 120px;"/>公安（分）局</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">责令</span><input type="text" name="title" value="${entity.title}" class="easyui-validatebox text" style="width: 120px;"/><span style="font-size: 26px;font: bolder;">通知书</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							<span style="font-size: 18px;font: bolder;">${entity.wh}</span>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="text" name="dwmc" value="${entity.dwmc}" class="easyui-validatebox text" style="width: 200px;"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;经调查，发现你单（位）存在下述违法行为：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="wfxw" style="width: 600px;height: 60px;" class="easyui-validatebox">${entity.wfxw}</textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;根据 <input type="text" name="fg" value="${entity.fg}" class="easyui-validatebox text" style="width: 400px;"/>之规定，现责令你（单位）
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="gzfsCheck" type="checkbox" value="0"/>立即予以改正 
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="gzfsCheck" type="checkbox" value="1"/>立即<input type="text" name="gznr" value="${entity.gznr}" class="easyui-validatebox text" style="width: 550px;"/>.
						</td>
					</tr>
					<tr class="dialogTr">
						<%-- <td >
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="gzfsCheck" type="checkbox" value="2" />在<input type="text" name="gzsj" value="${entity.gzsj}" style="width:100px" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
								前改正或者整改完毕，并将结果函告我单位。在期限届满之前，你（单位）必须<input type="text" name="zgsx" value="${entity.zgsx}" class="easyui-validatebox text" style="width: 400px;"/>。
						</td> --%>
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="gzfsCheck" type="checkbox" value="2" />在<input class='easyui-combobox' type='text' id='gzsjArray' style="width:160px;" 
											data-options="valueField:'id',textField:'text',selectOnNavigation:false,required:false"/>
								前改正或者整改完毕，并将结果函告我单位。在期限届满之前，你（单位）必须<input type="text" name="zgsx" value="${entity.zgsx}" class="easyui-validatebox text" style="width: 400px;"/>。
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						如不服本决定，可在收到本通知书之日起六十日内向<input type="text" name="fydwmc" value="${entity.fydwmc}" class="easyui-validatebox text" style="width: 200px;"/>申请行政复议或者在六个月内依法向
						<input type="text" name="fymc" value="${entity.fymc}" class="easyui-validatebox text" style="width: 200px;"/>人民法院提起行政诉讼。
						</td>
					</tr>
					<tr class="dialogTr" align="right">
						<td>
						　　 公安机关（印）
						</td>
					</tr>
					<tr class="dialogTr" align="right">
						<td>
						　　<input type="text" name="fhrq" value="${entity.fhrq}" class="easyui-validatebox date" style="width: 200px"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　违法行为人<input type="text" name="wfxwr" value="${entity.wfxwr}" class="easyui-validatebox text" style="width: 600px;"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<input type="text" name="hgrq" value="${entity.hgrq}" class="easyui-validatebox date" style="width: 200px"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr" align="center">
						<td>
							<input name="operationCheck" type="checkbox" value="1" /> 进入下一步：复查
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a id="printButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">预览</span>
									<span class="l-btn-icon icon-print"> </span>
								</span>
							</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
	var mainTabID = "${mainTabID}";
	function doInit(paramArray) {
		
		$('input[name=operationCheck]').click(function(){
			if($(this).is(':checked')){
				$('#operation').val('fc');
			}
		});
		
		initGzsjArray();
		
		initCheckbox();
		//打印
		$('#printButton').click(function(){
			var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+'${entity.jcid}'+"&type=jfzltzs";
			window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
		});
	}
	
	function initGzsjArray(){
		
		var array = new Array();
		array = '${entity.gzsjStrArray}'.split(",");
		$("#gzsjArray").combobox("loadData"
			,[{id:"10",text:array[0]}
			,{id:"20",text:array[1]}
			,{id:"30",text:array[2]}
			,{id:"60",text:array[3]}
			,{id:"90",text:array[4]}]);
		
		$("#gzsjArray").combobox({
			onChange:function (i,o){
				if(i != null && i != ''){
					var gzsj = '';
					if(i == '10'){
						gzsj = array[0];
					}else if(i == '20'){
						gzsj = array[1];
					}else if(i == '30'){
						gzsj = array[2];
					}else if(i == '60'){
						gzsj = array[3];
					}else{
						gzsj = array[4];
					}
					$('#gzsj').val(gzsj);
				}
			}
		});
		
		var gzsj = $('#gzsj').val();
		if(gzsj != null&& gzsj != ''){
			
			for(var i = 0;i < array.length;i++){
				
				if(array[i] == gzsj){
					var cid = '10';
					if(i == 0){
						cid = '10';
					}else if(i == 1){
						cid = '20';
					}else if(i == 2){
						cid = '30';
					}else if(i == 3){
						cid = '60';
					}else{
						cid = '90';
					}
					console.log('cid:'+cid+' value:'+array[i]);
					$("#gzsjArray").combobox("setValue",cid);
					$("#gzsjArray").combobox("setText",array[i]);
				}
			}
			
		}
	}
	
	function initCheckbox(){
		var defaultVal = '${entity.gzfs}';
		if( defaultVal == null || defaultVal == ""){
			defaultVal = 2;
		}
		
		$('input[name=gzfsCheck]').each(function(i,o){
			var elment = $(o);
			if(elment.val() == defaultVal){
				elment.attr('checked',true);
				$('#gzfs').val(2);
			}else{
				elment.attr('checked',false);
			}
		});
		
		$('input[name=gzfsCheck]').click(function(){
			$(this).attr('checked',true);
			var clickElement = $(this).val();
			$('#gzfs').val(clickElement);
			$('input[name=gzfsCheck]').each(function(i,o){
				var elment = $(o);
				if(elment.val() != clickElement){
					elment.attr('checked',false);
				}
			});
		});
	}
	
	function beforeSubmit() {
		
	}
	
	function afterSubmit(arr) {
		executeTabPageMethod(mainTabID, "queryButton()");
		if (arr["saveID"]) {
			//var editUrl = basePath+'jfjfjctz/addJffctzs?jcid='+$("#jcid").val()+"&mainTabID="+mainTabID;
			//window.top.openWindowWithSave(false, null, window, null,
			//{title: '复查知书',url: editUrl,width: 880,inline:true,height:500}, null, null,null);
		}
	}
</script>