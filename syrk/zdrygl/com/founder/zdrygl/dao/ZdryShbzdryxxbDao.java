package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
@Repository("zdryShbzdryxxbDao")
public class ZdryShbzdryxxbDao extends BaseDaoImpl {
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;


	/**
	 * 
	 * @Title: save
	 * @Description: TODO(保存)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZdryShbzdryxxb entity) {
		insert("ZdryShbzdryxxb.save", entity);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(更新)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(ZdryShbzdryxxb entity) {
		update("ZdryShbzdryxxb.update", entity);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(ZdryShbzdryxxb entity) {
		update("ZdryShbzdryxxb.delete", entity);
	}

	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询对象)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryShbzdryxxb    返回类型
	 * @throws
	 */
	public ZdryShbzdryxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryShbzdryxxb) queryForObject("ZdryShbzdryxxb.queryById", id);
		}
	}
	
	
	/**
	 * 
	 * @Title: querySyrk
	 * @Description: TODO(查询列表，涉环保重点人员单独查询)
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryShbzdryxxb entity, EasyUIPage page,SessionBean sessionBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryShbzdryxxb", entity);
		
		String userOrgCode=sessionBean.getUserOrgCode();
		String userOrgLevel=sessionBean.getUserOrgLevel();
		if("30".equals(userOrgLevel)){			
			map.put("userOrgCode", userOrgCode);
		}else if("31".equals(userOrgLevel)){
			OrgOrganization parentOrganization=this.orgOrganizationService.queryParentOrgByOrgcode(userOrgCode);
			map.put("userOrgCode", parentOrganization.getOrgcode());
		}
		page.setTotal((Integer) queryForObject("ZdryShbzdryxxb.queryCount", map)==null?0:(Integer) queryForObject("ZdryShbzdryxxb.queryCount", map));
		//orgCode2orgName set to sszrqdm 
		List<ZdryShbzdryxxb> list =queryForList("ZdryShbzdryxxb.query", map);
		for(ZdryShbzdryxxb xxb:list){
			OrgOrganization fxj = orgOrganizationService.queryByOrgcode(xxb.getSsfxjdm());
			xxb.setSsfxjdm(fxj.getOrgname());
			
			if("30".equals(userOrgLevel)){			
				xxb.setQx("view");
			}else if("31".equals(userOrgLevel)){
				xxb.setQx("edit");
			}
			
		}
		page.setRows(list);
		return page;
		
	}
}