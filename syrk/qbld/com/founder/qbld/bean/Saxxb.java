package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Shgxrb.java]  
 * @ClassName:    [Saxxb]   
 * @Description:  [涉案信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-4 上午10:11:58]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-4 上午10:11:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_SAXX", pk = "ID")
public class Saxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("ZJHM")
	private String zjhm;
	@FieldDesc("AJBH")
	private String ajbh;
	@FieldDesc("AJLB")
	private String ajlb;
	@FieldDesc("FASJ")
	private String fasj;
	@FieldDesc("FADD")
	private String fadd;
	@FieldDesc("TAR")
	private String tar;
	@FieldDesc("JYAQ")
	private String jyaq;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getAjbh() {
		return ajbh;
	}
	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}
	public String getAjlb() {
		return ajlb;
	}
	public void setAjlb(String ajlb) {
		this.ajlb = ajlb;
	}
	public String getFasj() {
		return fasj;
	}
	public void setFasj(String fasj) {
		this.fasj = fasj;
	}
	public String getFadd() {
		return fadd;
	}
	public void setFadd(String fadd) {
		this.fadd = fadd;
	}
	public String getTar() {
		return tar;
	}
	public void setTar(String tar) {
		this.tar = tar;
	}
	public String getJyaq() {
		return jyaq;
	}
	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}
	
}
