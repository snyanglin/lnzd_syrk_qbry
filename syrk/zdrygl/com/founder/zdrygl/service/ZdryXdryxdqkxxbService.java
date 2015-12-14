
package com.founder.zdrygl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryXdryxdqkxxb;
import com.founder.zdrygl.vo.ZdryXdryxdqkxxbVO;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryXdryxdqkxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-11 03:10:48
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-11 03:10:48，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@TypeAnnotation("毒人员吸毒情况信息")
public interface ZdryXdryxdqkxxbService {


	/**
	 * 新增<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(ZdryXdryxdqkxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "删除", type = logType.delete)
    public void delete(ZdryXdryxdqkxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(ZdryXdryxdqkxxb entity, SessionBean sessionBean);

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryXdryxdqkxxb 返回类型
	 * @throws
	 */
	public ZdryXdryxdqkxxb queryById(String id);

	/**
	 * 查询列表<br>
	 *
	 * @param page
	 * @param entity
	 * @return
	 */
    public EasyUIPage queryList(EasyUIPage page, ZdryXdryxdqkxxbVO entity);
}
