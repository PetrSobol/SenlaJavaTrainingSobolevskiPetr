package menu;

import java.util.List;

import action.IAction;

public interface IMenu {
	public IAction getAction();
	public String getTitle();
    public void setTitle(String title);
	public Integer getId();
    public void setId(Integer id);
	public List<IMenu> getMenuList();
    public void setMenuList(IMenu menu);


}
