package com.founder.framework.newmain.controller;

import jxl.common.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.right.service.OrgRightPublic;
import com.founder.zafffwqz.bean.Jhyxswjbxxb;
@Controller
@RequestMapping("/newmain")
public class newmain extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@RequestMapping(value = "/getaccord", method = RequestMethod.GET)
	public ModelAndView addOrEditjhyxswjbxxb(){
		SessionBean sessionBean = getSessionBean();
		String userid = sessionBean.getUserId();
		String systemcodes = sessionBean.getUserOrgCode();
		
		OrgRightPublic orgRightPublic = new OrgRightPublic();
		Object json = orgRightPublic.getUserMenuJson(userid,"dhxt",false);
		ModelAndView mv = new ModelAndView("newmain/main_lefttest");
		mv.addObject("jsondata",json);
		return mv;
		
	}
	
}