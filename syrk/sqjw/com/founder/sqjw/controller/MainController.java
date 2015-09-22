package com.founder.sqjw.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.service.MainService;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
/**
 * @类名: MainController 
 * @描述: 主页Controller
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:20:53
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController{
	@Resource(name = "mainService")
	private MainService mainService;
	/**
	 * @Title: queryPcsXqgkTj
	 * @描述: 查询派出所辖区概况统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcsXqgkTj",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryPcsXqgkTj(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,MainVo entity){
		EasyUIPage pageui = mainService.queryPcsXqgkTj(page, entity);
		List<?> pages = pageui.getRows();
		int syrknum = 0, bzdznum = 0, sydwnum = 0, syfwnum = 0;
		for (int i = 0; i < pages.size(); i++) {
			MainVo mainvo = (MainVo) pages.get(i);
			String orgCode = mainvo.getOrgcode();
			System.out.println(orgCode.substring(7, orgCode.length()));
			if (!orgCode.substring(8, orgCode.length()).equals("0000")) {
				syrknum = syrknum + Integer.parseInt(mainvo.getSyrknum());
				bzdznum = bzdznum + Integer.parseInt(mainvo.getBzdznum());
				sydwnum = sydwnum + Integer.parseInt(mainvo.getSydwnum());
				syfwnum = syfwnum + Integer.parseInt(mainvo.getSyfwnum());
			}
			
		}
		for (int i = 0; i < pages.size(); i++) {
			MainVo mainvo = (MainVo) pages.get(i);
			String orgCode = mainvo.getOrgcode();
			if (orgCode.substring(8, orgCode.length()).equals("0000")) {
				mainvo.setBzdznum(bzdznum + "");
				mainvo.setSydwnum(sydwnum + "");
				mainvo.setSyfwnum(syfwnum + "");
				mainvo.setSyrknum(syrknum + "");
			}
		}

		return pageui;
	}
	/**
	 * @Title: queryListsyfw 
	 * @描述: 查询派出所辖区实有房概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListsyfw", method = RequestMethod.POST)
	public @ResponseBody
	List<SyfwListVo> queryListsyfw(String syfwlb) {
		List<SyfwListVo> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		String orgid = getSessionBean().getUserOrgCode();
		param.put("orgCode", orgid);
		if(syfwlb.equals("1")){
			 listVo = mainService
					.queryListczf(param);
		}else if(syfwlb.equals("2")){
			 listVo = mainService
					.queryListcheckczf(param);
		}else {
			listVo =  mainService.queryListuncheckczf(param);
		}
	
		return listVo;
	}
	/**
	 * @Title: queryListsyfw 
	 * @描述: 查询派出所辖区重点人口概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListzdrk", method = RequestMethod.POST)
	public @ResponseBody
	List<CountMapVO> queryListzdrk(String zdrybm) {
		List<CountMapVO> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		String orgid = getSessionBean().getUserOrgCode();
		param.put("orgCode", orgid);
		param.put("zdrydm", zdrybm);
		listVo = mainService.queryListzdry(param);
		return listVo;
	
		
	}
	/**
	 * @Title: queryPcsXqgkXq 
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryczf",method = RequestMethod.POST)
	public @ResponseBody List<MainVo> queryczf(MainVo entity){
		
		return mainService.queryPcsXqgkXq(entity);
	}
	
	/**
	 * @Title: queryListByRyidYwlx
	 * @描述: 查询人员派出所首页实有人口描点
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<SyrkSyrkxxzb>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListByRyidYwlx", method = RequestMethod.POST)
	public @ResponseBody
	List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		List<SyrkSyrkxxzb> listVo = mainService
				.queryListByRyidYwlx(entity);
		return listVo;
	}
	/**
	 * @Title: queryListByRyidYwlx
	 * @描述: 查询人员派出所首页描点
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<SyrkSyrkxxzb>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListMapsyrk", method = RequestMethod.POST)
	public @ResponseBody
	List<CountMapVO> queryListMapsyrk(String syrkywlxdm,String gxpcsdm,String gxzrqdm) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("syrkywlxdm", syrkywlxdm);
		param.put("gxpcsdm", gxpcsdm);
		param.put("gxzrqdm", gxzrqdm);
		List<CountMapVO> listVo = mainService
				.queryListMap(param);
		return listVo;
	}
	
	/**
	 * @Title: queryListMapzdrk
	 * @描述: 查询人员派出所首页描点
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<SyrkSyrkxxzb>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListMapzdrk", method = RequestMethod.POST)
	public @ResponseBody
	List<CountMapVO> queryListMapzdrk(String zdrybm,String orgid) {
		List<CountMapVO> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		param.put("orgCode", orgid);
		param.put("zdrydm", zdrybm);
		listVo = mainService.queryListzdry(param);
		return listVo;
	
		
	}
	
	
	
	/**
	 * @Title: queryListByRyidYwlx
	 * @描述: 查询人员派出所首页实有人口描点
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<SyrkSyrkxxzb>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/countPcs" ,method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> countPcs(String orgid){
		Map<String,Object> paramMap=new HashMap<String, Object>();
		Map<String,Object> resMap = new HashMap<String,Object>();
		String level = getSessionBean().getUserOrgLevel();
	    if(orgid.substring(8, orgid.length()).equals("0000")){
	    	paramMap.put("lx", 14);
	    	paramMap.put("orgCode", orgid);
	    	//所长统计
	    	resMap = mainService.querypcstj(paramMap);
	    	
	    }else{
	    	//责任区统计
	    	paramMap.put("lx", 15);
	    	 paramMap.put("orgCode", orgid);
	    	resMap = mainService.querypcstj(paramMap);
	    }
	   
		return resMap;
	}
	
}