<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	page import="com.founder.framework.base.entity.SessionBean"%>
<%
	String contextPath = request.getContextPath();
	SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
	String userName = "";
	String userOrgName = "";
	if (userInfo != null) {
		userName = userInfo.getUserName();
		userOrgName = userInfo.getUserOrgName();
	}
%>
<HTML>
<HEAD>
<style type="text/css">
</style>
<TITLE></TITLE>
<link href="<%=contextPath%>/common/skin/mainnew.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript">
	var contextPath = "<%=contextPath%>";
	function logout_click(){
	 	window.top.location.href = contextPath+"/LoginPage/login?action=logout";
	 	//document.forms["dataform"].submit();
	 	//window.close();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<BODY class="bannerBody" onselectstart="return false;" oncontextmenu="return false;">
	<form name="dataform" action="<%=contextPath%>/LoginPage/login?action=caslogout" checkType="blur" target="_self" method="post"></form>
	<div class="banner_lf banner01">
		<div class="banner_rt">
			<table border="0" cellpadding="0" cellspacing="0"  style="float:right;line-height: 50px;height: 50px;">
				<tr>
					<td>
						<img src="../common/skin/images/banner_user.jpg" width="42" height="42" border="0">
					</td>
					<td>
					    <div class="userInfo"><%=userName%></div>
					    <div class="userInfo"><%=userOrgName%></div>
					</td>
					<td class="logout1" onclick="logout_click()" onmousemove="this.className='logout2'" onmouseout="this.className='logout1'">退出</td>
				</tr>
		    </table>
    	</div>
	 </div>
</BODY>
</HTML>