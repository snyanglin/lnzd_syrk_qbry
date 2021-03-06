package com.founder.zdrygl.base.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryDtjsZszhjsbrxxbService.java]  
 * @ClassName:    [ZdryDtjsZszhjsbrxxbService]   
 * @Description:  [肇事肇祸精神病人信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("动态纪实肇事肇祸精神病人信息服务")
public interface ZdryDtjsZszhjsbrxxbService {


	/**
	 * @Title: queryList
	 * @Description: TODO(涉稳信息查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZszhjsbrxxb entity);	
	
	
	public String save(ZdryDtjsZszhjsbrxxb entity,SessionBean sessionBean);
	
	
	public ZdryDtjsZszhjsbrxxb queryById(String id);
	
	
	public void delete(ZdryDtjsZszhjsbrxxb entity,SessionBean sessionBean);

	
	public String update(ZdryDtjsZszhjsbrxxb entity,SessionBean sessionBean);



	

}
