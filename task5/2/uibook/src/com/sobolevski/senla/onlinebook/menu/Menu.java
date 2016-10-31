package com.sobolevski.senla.onlinebook.menu;

import java.util.ArrayList;
import java.util.List;

import com.sobolevski.senla.onlinebook.action.IAction;


public class Menu implements IMenu {
	private String title;
	private Integer id;
	private List<IMenu> listmenu;
	private IAction action;

	public Menu(String title, Integer id) {
		super();
		this.title = title;
		this.id = id;
		listmenu = null;
	}

	public Menu(String title, Integer id, IAction action) {
		super();
		this.action = action;
		this.title = title;
		this.id = id;
		listmenu = null;
	}

	@Override
	public String getTitle() {

		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;

	}

	@Override
	public Integer getId() {

		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

	@Override
	public List<IMenu> getMenuList() {

		return this.listmenu;
	}

	@Override
	public void setMenuList(IMenu menu) {
		if (listmenu == null) {
			listmenu = new ArrayList<IMenu>();
			listmenu.add(menu);
		} else {
			listmenu.add(menu);
		}

	}

	@Override
	public IAction getAction() {
		return action;
	}

}
