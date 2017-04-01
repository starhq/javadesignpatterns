package com.iluwatar.flux.action;

/**
 * Created by starhq on 2017/4/1.
 */
public class MenuAction extends Action {

    private MenuItem menuItem;

    public MenuAction(MenuItem menuItem) {
        super(ActionType.MENU_ITEM_SELECTED);
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
