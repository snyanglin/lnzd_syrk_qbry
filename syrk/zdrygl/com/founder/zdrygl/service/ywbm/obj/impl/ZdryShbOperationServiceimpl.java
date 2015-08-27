package com.founder.zdrygl.service.ywbm.obj.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.service.ywbm.impl.ZdryHBOperationServiceimpl;
import com.founder.zdrygl.vo.ZdryVO;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.za.obj.impl.ZdryHBOperationServiceimpl.java]  
 * @ClassName:    [ZdrySqjzOperationServiceimpl]   
 * @Description:  [重点人员 社区矫正人 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月7日 下午1:55:20]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月7日 下午1:55:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryShbOperationService")
@Transactional
public class ZdryShbOperationServiceimpl extends ZdryHBOperationServiceimpl {
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;		
	


	@Override
	public void saveLg(ZdryVO vo) throws BussinessException {
		super.saveLg(vo);
//		vo.getZdryShbzdryxxb().setId(vo.getZdryZdryzb().getId());
//		zdryShbzdryxxbDao.save(vo.getZdryShbzdryxxb());				
	}	

	

	
}