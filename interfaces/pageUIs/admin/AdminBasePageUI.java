package pageUIs.admin;

public class AdminBasePageUI {
	public static final String MENU_BY_NAME = "xpath=//ul[contains(@class, 'nav-sidebar')]/li[contains(@class, 'has-treeview')]/a/p[contains(text(), '%s')]";
	public static final String SUB_MENU_BY_NAME = "xpath=//ul[contains(@class, 'nav-sidebar')]//li[contains(@class, 'has-treeview')]/ul[contains(@class, 'nav-treeview')]/li//p[contains(text(), '%s')]";
}
