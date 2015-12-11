package com.founder.zdrygl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryDtjsSfxxb;
import com.founder.zdrygl.service.ZdryDtjsSfxxbService;
import com.google.gson.Gson;
@Controller
@RequestMapping("dtjsMore")
public class ZdryDtjsSfxxController extends BaseController {
	@Resource
	private ZdryDtjsSfxxbService zdryDtjsSfxxbService;
	

	@RequestMapping(value = "/moreDtjsSfxx", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryDtjsSfList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			String zdryZjhm,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		ZdryDtjsSfxxb entity=new ZdryDtjsSfxxb();
		entity.setZdryzjhm(zdryZjhm);
		return zdryDtjsSfxxbService.queryList(page, entity);
	}
	

	@RequestMapping(value = "/addDtjsSfxx", method = RequestMethod.GET)
	public ModelAndView addDtjsSfjbxx( String zdryZjhm,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsSfxxAdd");		
			ZdryDtjsSfxxb entity=new ZdryDtjsSfxxb();
			entity.setZdryzjhm(zdryZjhm);
			mv.addObject("entity", entity);
			return mv;
		
	}
	
	@RequestMapping(value = "/editDtjsSfxx", method = RequestMethod.GET)
	public ModelAndView editDtjsSfxx( String id,String type,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsSfxxAdd");		
			ZdryDtjsSfxxb entity=this.zdryDtjsSfxxbService.queryById(id);
			mv.addObject("entity", entity);
			mv.addObject("type", type);
			return mv;
		
	}
	@RequestMapping(value = "/saveDtjsSfxx", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDtjsSfxx(ZdryDtjsSfxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(StringUtils.isBlank(entity.getId())){
						
				String id =this.zdryDtjsSfxxbService.save(entity,sessionBean);		
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.SAVE_ID, "" + id); // 返回主键

			}else{
				zdryDtjsSfxxbService.update(entity, sessionBean);
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				model.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	@RequestMapping(value = "/deleteDtjsSfxx", method = RequestMethod.POST)
	public ModelAndView deleteDtjsSfxx(ZdryDtjsSfxxb entity,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView(getViewName(sessionBean));		
			Map<String, Object> map = new HashMap<String, Object>();
		    try {
			    this.zdryDtjsSfxxbService.delete(entity, sessionBean);;
				map.put(AppConst.STATUS, AppConst.SUCCESS);
				map.put(AppConst.MESSAGES, getDeleteSuccess());
			} catch (Exception e) {
				e.printStackTrace();
				map.put(AppConst.STATUS, AppConst.FAIL);
				map.put(AppConst.MESSAGES, getDeleteFail());
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));    
			return mv;
		
	}
}
