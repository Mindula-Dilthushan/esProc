package com.raqsoft.ide.dfx;

import com.raqsoft.ide.common.AppMenu;
import com.raqsoft.ide.common.GV;
import com.raqsoft.ide.common.PrjxAppToolBar;
import com.raqsoft.ide.common.ToolBarPropertyBase;
import com.raqsoft.ide.common.control.JWindowNames;
import com.raqsoft.ide.dfx.base.JTabbedParam;
import com.raqsoft.ide.dfx.base.PanelDfxWatch;
import com.raqsoft.ide.dfx.base.PanelValue;
import com.raqsoft.ide.dfx.control.DfxEditor;
import com.raqsoft.ide.dfx.dialog.DialogSearch;

/**
 * 集算器IDE中的常量
 *
 */
public class GVDfx extends GV {
	/**
	 * 网格编辑器
	 */
	public static DfxEditor dfxEditor = null;

	/**
	 * IDE右下角的多标签控件,有网格变量、表达式等标签页
	 */
	public static JTabbedParam tabParam = null;

	/**
	 * 单元格值面板
	 */
	public static PanelValue panelValue = null;

	/**
	 * 网格表达式计算面板
	 */
	public static PanelDfxWatch panelDfxWatch = null;

	/**
	 * 搜索对话框
	 */
	public static DialogSearch searchDialog = null;

	/**
	 * 匹配的窗口名称
	 */
	public static JWindowNames matchWindow = null;

	/**
	 * 取集算器菜单
	 * 
	 * @return
	 */
	public static AppMenu getDfxMenu() {
		appMenu = new MenuDfx();
		return appMenu;
	}

	/**
	 * 取集算器工具栏
	 * 
	 * @return
	 */
	public static ToolBarDfx getDfxTool() {
		appTool = new ToolBarDfx();
		return (ToolBarDfx) appTool;
	}

	/**
	 * 取属性工具栏
	 * 
	 * @return
	 */
	public static ToolBarPropertyBase getDfxProperty() {
		toolBarProperty = new ToolBarProperty();
		return toolBarProperty;
	}

	/**
	 * 取基础菜单（无文件打开时）
	 * 
	 * @return
	 */
	public static AppMenu getBaseMenu() {
		appMenu = new MenuBase();
		return appMenu;
	}

	/**
	 * 取基础工具栏（无文件打开时）
	 * 
	 * @return
	 */
	public static PrjxAppToolBar getBaseTool() {
		appTool = new ToolBarBase();
		return appTool;
	}

	/**
	 * 取基础属性工具栏（无文件打开时）
	 * 
	 * @return
	 */
	public static ToolBarPropertyBase getBaseProperty() {
		toolBarProperty = new ToolBarProperty();
		return toolBarProperty;
	}
}
