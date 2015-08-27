package com.founder.sqjw.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.vo.MainVo;
/**
 * @类名: MainDao 
 * @描述: 主页Dao
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:23:41
 */
@Repository("mainDao")
public class MainDao extends BaseDaoImpl{
	/**
	 * @Title: queryPcsXqgkTj 
	 * @描述: 查询派出所辖区概况统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryPcsXqgkTj(EasyUIPage page,MainVo entity) {
		page.setRows(queryForList("Main.queryPcsXqgkTj", entity));
		return page;
	}
	/**
	 * @Title: queryPcsXqgkXq 
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<MainVo>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<MainVo> queryPcsXqgkXq(MainVo entity) {
		return queryForList("Main.queryPcsXqgkXq", entity);
	}
}