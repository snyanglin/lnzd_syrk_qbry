package com.founder.syrkgl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyzjxxb;
import com.founder.syrkgl.service.RyRyzjxxbService;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.controller.RyRyzjxxbController.java]  
 * @ClassName:    [RyRyzjxxbController]   
 * @Description:  [实有人口附加信息-人员证件信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-3 下午3:40:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-3 下午3:40:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "ryRyzjxxb")
public class RyRyzjxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ryRyzjxxbService")
	private RyRyzjxxbService ryRyzjxxbService;

	/**
	 * @Title: add
	 * @Description: TODO(新增页面)
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String ryid) {
		ModelAndView mv = new ModelAndView("syrkgl/ryRyzjxxb");
		RyRyzjxxb entity = new RyRyzjxxb();
		entity.setRyid(ryid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * @Title: edit
	 * @Description: TODO(编辑页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id,
			SessionBean sessionBean) throws BussinessException {
		if (sessionBean != null
				&& !StringUtils.isBlank(sessionBean.getUserName())) { // 服务调用
			ModelAndView mv = new ModelAndView("syrkgl/ryRyzjxxb");
			RyRyzjxxb entity = ryRyzjxxbService.queryById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(entity));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("syrkgl/ryRyzjxxb");
			RyRyzjxxb entity = ryRyzjxxbService.queryById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject("entity", entity);
			return mv;
		}
	}

	/**
	 * @Title: save
	 * @Description: TODO(新增保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "ryid,cyzjdm,zjhm,zjqdsj,zjyxq", serverId = "3")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(RyRyzjxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ryRyzjxxbService.save(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @Title: update
	 * @Description: TODO(修改保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "id,ryid,cyzjdm,zjhm,zjqdsj,zjyxq", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public ModelAndView update(RyRyzjxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ryRyzjxxbService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @Title: delete
	 * @Description: TODO(注销保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "id", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public ModelAndView delete(RyRyzjxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ryRyzjxxbService.delete(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getDeleteSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCount", method = RequestMethod.GET)
	public @ResponseBody Integer queryCount(RyRyzjxxb entity){
		return ryRyzjxxbService.queryCount(entity);
	}

}
