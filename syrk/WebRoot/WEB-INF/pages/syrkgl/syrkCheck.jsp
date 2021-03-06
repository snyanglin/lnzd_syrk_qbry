<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String username = "";
    String userorg = "";
    String orgcode = "";
    if(userInfo!=null){
        username = userInfo.getUserName();
        userorg = userInfo.getUserOrgNameQc();
        orgcode = userInfo.getUserOrgCode();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>实有人口核实列表</title>
    <script type="text/javascript">
    <!--
       var username = "<%=username%>"; 
       var userorg = "<%=userorg%>";
       var orgcode = "<%=orgcode%>";
    //-->
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/syrkgl/syrkCheck.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true">
  	<div data-options="region:'center',border:false">
  			<table id="dg" class="easyui-datagrid" 
            	data-options="url:'<%=contextPath%>/syrkGl/queryList?isCheck=check',
	           		toolbar:'#datagridToolbar',
	           		border:false,
	           		rownumbers: true,
	           		sortName:'xm',
	           		sortOrder:'desc',
	           		pageSize:getAutoPageSize(180),
	           		pageList:[getAutoPageSize(180),
	           		getAutoPageSize(180) * 2],
	           		singleSelect:true,
	           		fitColumns:true">
			    <thead>
			        <tr>
			           	<th data-options="field:'syrkywlxdm',width:80,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SYRKYWLXDM.js'">人员类型</th>
			            <th data-options="field:'zjhm',width:120,align:'center',sortable:true,halign:'center'">证件号码</th>
				        <th data-options="field:'xm',width:60,align:'center',sortable:true,halign:'center'">姓名</th>
				        <th data-options="field:'hjd_dzxz',width:120,align:'left',sortable:true,halign:'center'">户籍描述</th>
				        <th data-options="field:'jzd_dzxz',width:120,align:'left',sortable:true,halign:'center',formatter:subjzddzxz">居住描述</th>
				        <th data-options="field:'hs_status',width:30,align:'center',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/DZ_BZDZ_HSZT.js'">核实状态</th>
			            <th data-options="field:'true',width:50,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
			        </tr>
			    </thead>
			</table>
  			<div id="datagridToolbar" style="padding:5px;height:auto;">
	  			<form id ="queryForm">
	   			<table cellspacing="0" cellpadding="0" border="0" >
					<tr class="dialogTr">
						<td class="dialogTd" nowrap="nowrap" align="right">姓名：</td>
						<td class="dialogTd">
							<input type="text" name="xm" id="xm" class="easyui-validatebox" 
								data-options="required:false,validType:'maxLength[20]'" style="width:125px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" nowrap="nowrap" align="right">性别：</td>
						<td class="dialogTd">
							<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:125px;"
									data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" nowrap="nowrap" align="right">民族：</td>
				    	<td class="dialogTd" >
				    	    <input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:125px;"
								data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					    </td>
					    <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
					    <td class="dialogTd" nowrap="nowrap" align="right">证件号码：</td>
						<td class="dialogTd" >
							<input type="text" name="zjhm" id="zjhm" class="easyui-validatebox" style="width:125px" 
								data-options="required:false,tipPosition:'bottom'" maxlength="400"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td class="dialogTd" nowrap="nowrap" align="right">人员类型：</td>
						<td class="dialogTd"><input class="easyui-combobox" type="text" id="syrkywlxdm" name="syrkywlxdm" style="width:125px"
							data-options="dataFilter:'[^1,^4]', url: contextPath+'/common/dict/BD_D_SYRKYWLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" nowrap="nowrap" align="right">居住地：</td>
				    	<td class="dialogTd"> 
				            <input type="text" name="jzd_dzxz" id ="jzd_dzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:125px;"/>
				        </td>
				        <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd"nowrap="nowrap" align="right">核实状态：</td>
						<td class="dialogTd">
							<input class="easyui-combobox" type="text" id="hs_status" name="hs_status" style="width:125px;" 
								data-options="url: contextPath + '/common/dict/DZ_BZDZ_HSZT.js',valueField:'id',textField:'text',
											  onLoadSuccess:function(){$('#hs_status').combobox('setValue','01');}"/>
						</td>
						<td nowrap="nowrap" colspan="3" align="right">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
						</td>
					</tr>
				</table>
	   		</form>
	    </div>
	</div> 
	<div id="win" class="easyui-window" title="实有人口核实注销" style="width:700px;height:200px"   
	      data-options="iconCls:'icon-save',modal:true,closed:true,collapsible:false,minimizable:false, maximizable:false"> 
	      <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
	      	<tr>
	      		<td align="center"> 
		      		<input type="hidden" id ="id" value="">
		       		<textarea id="xt_zxyy"  onblur="if(value==''){value='请输入注销原因...';}" onfocus="if(value=='请输入注销原因...'){value='';}" title="添加注销原因"
		       			class="easyui-validatebox" style="width: 613px; height:78px;"
						data-options="validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'">请输入注销原因...</textarea>
	      		</td>
	      	</tr>
	      	<tr>
	      		<td align="right">
	      			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateHs();">确定</a>
					<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
		       	</td>
		   	</tr>
	   	</table>
	</div>
</body>
</html>