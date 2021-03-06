if(typeof DzCheckEdit == "undefined" || !DzCheckEdit){
	var DzCheckEdit = {};
};
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-02-06 16:30:12
 */
$(function(){
	//加载地图
	DzCheckEdit.onloadMap();
	//设置只读属性
	DzCheckEdit.onloadReadonly();
	//加载按钮事件
	DzCheckEdit.onloadButton();
	//加载层户结构页面
	DzCheckEdit.onloadChjg();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-06 16:21:23
 */	
DzCheckEdit.onloadMap = function(){
	/*地图对象*/
	DzCheckEdit.map = new FrameTools.Map();
	/*设置地图代理*/
	DzCheckEdit.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	DzCheckEdit.map.setMapDiv("mapDiv");
	/*加载地图*/
	DzCheckEdit.map.onloadMap();
	/*显示鹰眼*/
	DzCheckEdit.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	DzCheckEdit.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	DzCheckEdit.map.showNewMapServer("mapDiv","DzCheckEdit.map");
	/*加载地图工具条*/
	DzCheckEdit.map.buildTools("mapDiv","toolDiv","DzCheckEdit.map");
	/*加载边界坐标值*/
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		DzCheckEdit.map.moveMapToBjzbz(bjzbz);
	}
	//加载坐标点
	DzCheckEdit.loadInitMarker();
};
/**
 * @title:onloadReadonly
 * @description:设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-06 16:40:32
 */	
DzCheckEdit.onloadReadonly = function(){
	//行政区划【只读】
	setInputReadonly('xzqhdm', true);
	//地名【只读】
	setInputReadonly('dmmc', true);
	//门楼牌号【只读】
	setInputReadonly('mlph', true);
	//门楼牌全称【只读】
	setInputReadonly('mlphqc', true);
	//责任区【只读】
	setInputReadonly('zrqmc', true);
	if(type=="1"){
		document.getElementById("hgButton").style.display = "none";
		document.getElementById("dtbdButton").style.display = "none";
	}
};
/**
 * @title:loadInitMarker
 * @description:气泡框内容
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-07 13:20:21
 */	
DzCheckEdit.loadInitMarker = function(){
	if(zbx!=""&&zby!=""){
		//气泡框内容
		var openHtml =  "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>地址全称："+dzmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>采集时间："+xt_cjsj+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>入库时间："+xt_cjsj+"</div></div>";
		//地图标点
		var img = "";
		if(xt_zxbz==""){
			//红色
			img = "jzw1.png";
		}else if(xt_zxbz=="0"){
			//绿色
			img = "jzw3.png";
		}else{
			//灰色
			img = "jzw0.png";
		}
		DzCheckEdit.markerObj = DzCheckEdit.map.initMarker(mlphqc,zbx,zby,img,openHtml,null,43,37);
		DzCheckEdit.map._MapApp.addOverlay(DzCheckEdit.markerObj);
	}
};
/**
 * @title:onloadButton
 * @description:按钮事件
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-07 13:21:32
 */
DzCheckEdit.onloadButton = function(){
	//后退
    $('#backButton').click(function(){
    	closeSelf();
	});
	//通过
    $('#hgButton').click(function(){
    	  topMessager.confirm('操作确认', '您是否确定地址【'+mlphqc+'】核实通过？',function(r){
    		  if(r){
    			   var zbx = $("#zbx").val();
  	    		   var zby = $("#zby").val();
  	    	       var win = document.getElementById('chjgid').contentWindow;
  	    	       var pdchjg = win.document.getElementById("pdchjg").value;
	  	    	   if(zbx==""&&zby==""){
		    		   topMessager.show({
						  title: MESSAGER_TITLE,
						  msg: '该地址未采集地址位置，请进行标点。',
						  timeout:2500
					   });
		    		   return;
		    	   }else if(pdchjg=="0"){
		    			topMessager.show({
							title: MESSAGER_TITLE,
							msg: '该地址未生成层户结构，请生成层户。',
							timeout:2500
						});
		    			return;
		    	   }else{
		    			//提交保存
		    			$("#dataForm").form('submit',{
		    				dataType : 'json',
		    				onSubmit: function() {
							},
							success:function(result) {
								//解析JSON格式
								result = parseReturn(result);
								 //返回成功后执行的方法
								if(result.status == 'success'){
									closeSelf();
									executeTabPageMethod(mainTabID, "DzCheck.queryButton()");
								}
								topMessager.show({
									title: MESSAGER_TITLE,
									msg: result.message,
									timeout:3500
								});
							}
		    			});
		    	   }
    		  }
    	  });
	});
    if(type=="0"){
    	 document.getElementById("whchButton").style.display = "";
    	 document.getElementById("ckchButton").style.display = "none";
    }else{
    	 document.getElementById("whchButton").style.display = "none";
    	 document.getElementById("ckchButton").style.display = "";
    }
    //标点
    $('#dtbdButton').click(function(){
    	$('#tt').tabs("select", "地图");
    	//设置当前地图操作状态为获取地图坐标的状态
    	DzCheckEdit.moveMapToDrawPoint();
	});
    //维护层户
    $('#whchButton').click(function(){
    	$('#tt').tabs("select", "层户");
	});
    //查看层户
    $('#ckchButton').click(function(){
    	$('#tt').tabs("select", "层户");
	});
};
/**
 * @title:moveMapToDrawPoint
 * @description:设置当前地图操作状态为获取地图坐标的状态
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-10 10:52:43
 */	
DzCheckEdit.moveMapToDrawPoint = function(){
	DzCheckEdit.map._MapApp.changeDragMode("drawPoint",null,null,function(obj){
		if(bjzbz!="" && bjzbz!='null'){
			//判断后坐标是否在区域内
			var judge = DzCheckEdit.map.PtInPolygon(obj,bjzbz);
			if(judge){
				//获取定位的坐标点
				var pointArray = obj.split(",");
				if(DzCheckEdit.markerObj!=null){
					DzCheckEdit.map._MapApp.removeOverlay(DzCheckEdit.markerObj);
				}
				DzCheckEdit.markerObj = DzCheckEdit.map.initMarker(mlphqc,pointArray[0],pointArray[1],"jzw2.png",null,null,43,37);
		  		DzCheckEdit.map._MapApp.addOverlay(DzCheckEdit.markerObj);
		  		document.getElementById("zbx").value = pointArray[0];
				document.getElementById("zby").value = pointArray[1];
			}else{
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: '坐标超出边界,请重新标点！',
					timeout:2500
				});
			}
		}
	});
};
/**
 * @title:onloadChjg
 * @description:加载层户结构页面
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2015-03-02 14:50:32
 */
DzCheckEdit.onloadChjg = function(){
	var ch = "0"
	if(type=="1"){
		ch = "1";
	}
	//层户结构URL
	var src = contextPath+"/dz/dzBuilding?mldzid="+mldzid+"&type="+type+"&dzChb=2&chType="+ch+"&mainTabID="+mainTabID;
	//Iframe页面加载，解决加载页面先出输入框在加载样式问题
	var chjgHtml = "<iframe id='chjgid' style='width: 100%;height: 100%;' frameborder='no' src='"+src+"'></iframe>";
	$("#chDivId").html(chjgHtml);
	
};
/**
 * @title:addDzBm
 * @description:增加一个地址别名
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 19:02:54
 */	
DzCheckEdit.addDzBm = function(){
	 var tr1 = $('<tr id="dzBmTr1'+ dzBmCount +'"><td height="5"></td></tr>');
	 var tr2 = $('<tr class="dialogTr" id="dzBmTr2'+dzBmCount+'"></tr>');
     var td1 = $('<td width="30%" class="dialogTd" align="right">地址别名：</td>'); 	  
     var td2 = $('<td width="70%" class="dialogTd" id="dzbmTd'+ dzBmCount +'"></td>'); 
     var td2Html = new StringBuffer();
     td2Html.append("<input class='easyui-validatebox' type='text' id='dzbm_"+dzBmCount+"' name='dzBmArray["+dzBmCount+"].dzbm' style='width:215px;'/>");
     td2Html.append("&nbsp;<a class='delLine_btn' href='javascript:void(0);' onclick='DzCheckEdit.delDzBm("+ dzBmCount +")' title='注销当前地址别名'></a>");
     td2.html(td2Html.toString());
     tr2.append(td1);
     tr2.append(td2);
     $('#dzBmTable').append(tr1);
     $('#dzBmTable').append(tr2);
 	 $.parser.parse('#dzbmTd' + dzBmCount);
     dzBmCount++;
};
/**
 * @title:delDzBm
 * @description:注销当前地址别名
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-06 19:03:32
 */	
DzCheckEdit.delDzBm = function(No){
	 $("#dzBmTr1" + No).remove();
	 $("#dzBmTr2" + No).remove();
};
/**
 * @title:setMlpqc
 * @description:地址全称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-01-07 14:35:05
 */	
DzCheckEdit.setMlpqc = function(temp){
	var dmmc = $('#dmmc').val();
	var mlphqzmc = $('#mlphqzmc').val();
	var mlph = $('#mlph').val();
	var mlphhzmc = $('#mlphhzmc').val();
	var mlphqc = dmmc+mlphqzmc+mlph+mlphhzmc;
	$('#mlphqc').val(mlphqc);
};