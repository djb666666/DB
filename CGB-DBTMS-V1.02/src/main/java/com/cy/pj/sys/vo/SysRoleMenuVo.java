package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.List;

public class SysRoleMenuVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2502237059956002188L;
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	@Override
	public String toString() {
		return "SysRoleMenuVo [id=" + id + ", name=" + name + ", note=" + note + ", menuIds=" + menuIds + "]";
	}
}
