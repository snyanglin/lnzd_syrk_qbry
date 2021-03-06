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
<title>技防检查通知书</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/sydw/sydwWord.css"><link/>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true" >
		<form action="" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center'" align="center" style="padding: 50px">
			<div style="width:694px;height:978px; border:1px solid #000000;padding: 20px">
				<table id="table" border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox text" style="width: 120px;font-size: 18px;font: bolder;"/>公安（分）局</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">责令${entity.title}通知书</span></div>
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
						<td style="height: 200px;padding-left: 50px;padding-right: 50ps;">
						${entity.wfxw}
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;根据 <input type="text" name="fg" value="${entity.fg}" class="easyui-validatebox text" style="width: 400px;"/>之规定，现责令你（单位）
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="gzfsCheck" disabled="disabled" type="checkbox" value="0"/>立即予以改正 
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="gzfsCheck" disabled="disabled" type="checkbox" value="1"/>立即<input type="text" name="gznr" value="${entity.gznr}" class="easyui-validatebox text" style="width: 550px;"/>.
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;<input name="gzfsCheck" disabled="disabled" type="checkbox" value="2" />在<input type="text" name="gzsj" value="${entity.gzsj}" style="width:100px" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
								前改正或者整改完毕，并将结果函告我单位。在期限届满之前，你（单位）必须<input type="text" name="zgsx" value="${entity.zgsx}" class="easyui-validatebox text" style="width: 400px;"/>。
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						如不服本决定，可在收到本通知书之日起六十日内向<input type="text" name="fydwmc" value="${entity.fydwmc}" class="easyui-validatebox text" style="width: 200px;"/>申请行政复议或者在六个月内依法向
						<input type="text" name="fymc" value="${entity.fymc}" class="easyui-validatebox text" style="width: 200px;"/>人民法院提起行政诉讼。
						</td>
					</tr>
					<tr class="dialogTr" align="right" style="padding-top: 260px">
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
						　　违法行为人<input type="text" name="wfxwr" value="${entity.wfxwr}" class="easyui-validatebox text" style="width: 400px;"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<input type="text" name="hgrq" value="${entity.hgrq}" class="easyui-validatebox date" style="width: 200px"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
				</table>
				</div>
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td  class="noprint" align="center">
							<a id="printButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">文书打印</span>
								<span class="l-btn-icon icon-save"> </span>
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
	$(function(){
		
		if('${printAble}' == null || '${printAble}' == ''){
			$('#printButton').hide();
		}
		
		var defaultVal = '${entity.gzfs}';
		
		if( defaultVal == null || defaultVal == ""){
			defaultVal = 2;
		}
		
		$('input[name=gzfsCheck]').each(function(i,o){
			var elment = $(o);
			if(elment.val() == defaultVal){
				elment.attr('checked',true);
			}else{
				elment.attr('checked',false);
			}
		});
	});
	
	//打印
	$('#printButton').click(function(){
		window.print();
	});
</script>