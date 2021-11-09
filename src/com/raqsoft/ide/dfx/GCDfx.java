package com.raqsoft.ide.dfx;

import com.raqsoft.ide.common.GC;

/**
 * 集算器常量
 *
 */
public class GCDfx extends GC {
	/**
	 * 集算网新建网格名称前缀
	 */
	public final static String PRE_NEWPGM = "p";
	/**
	 * ETL新建网格名称前缀
	 */
	public final static String PRE_NEWETL = "s";

	/**
	 * 缺省的行高
	 */
	public final static int DEFAULT_ROW_HEIGHT = 20;

	/**
	 * 菜单常量
	 */
	/**
	 * 文件
	 */
	/** 新建SPL(T) */
	public static final String NEW_SPL = "file.newspl";
	/** 保存到FTP(P) */
	public static final String SAVE_FTP = "file.saveftp";
	/** 导入SPL文件(I) */
	public static final String FILE_LOADTXT = "file.loadtxt";
	/** 导出成SPL文件(E) */
	public static final String FILE_EXPORTTXT = "file.exporttxt";
	/** 重新打开文件(R) */
	public static final String FILE_REOPEN = "file.reopen";

	/** 新建SPL(T) */
	public static final short iNEW_SPL = MENU_DFX + 3;
	/** 保存到FTP(P) */
	public static final short iSAVE_FTP = MENU_DFX + 5;
	/** 导入SPL文件(I) */
	public static final short iDFX_IMPORT_TXT = MENU_DFX + 11;
	/** 导出成SPL文件(E) */
	public static final short iFILE_EXPORTTXT = MENU_DFX + 21;
	/** 重新打开文件(R) */
	public static final short iFILE_REOPEN = MENU_DFX + 31;

	/**
	 * 编辑(E)
	 */
	public static final String EDIT = "edit";
	/** 撤销(Z) */
	public static final String UNDO = "edit.undo";
	/** 重做(Y) */
	public static final String REDO = "edit.redo";
	/** 复制ctrl-C */
	public static final String COPY = "edit.copy";
	/** 值复制ctrl-alt-C */
	public static final String COPYVALUE = "edit.copyvalue";
	/** 代码复制ctrl-shift-C */
	public static final String CODE_COPY = "edit.codecopy";
	/** 复制可呈现代码(C)无窗口html */
	public static final String COPY_HTML = "edit.copyhtml";
	/** 复制可呈现代码(P) */
	public static final String COPY_HTML_DIALOG = "edit.copyhtmldialog";
	/** 剪切ctrl-X */
	public static final String CUT = "edit.cut";
	/** 粘贴ctrl-V */
	public static final String PASTE = "edit.paste";
	/** 变迁粘贴ctrl-alt-V */
	public static final String PASTE_ADJUST = "edit.pasteadjust";
	/** Ctrl-Shift-V */
	public static final String PASTE_SPECIAL = "edit.pastespecial";
	/** 插入粘贴ctrl-B */
	public static final String PASTE_INSERT = "edit.pasteinsert";
	/** 插入变迁粘贴ctrl-alt-B */
	public static final String PASTE_ADJUST_INSERT = "edit.pasteadjustinsert";
	/** 插入 */
	public static final String INSERT = "edit.insert";
	/** 插入行(R) */
	public static final String INSERT_ROW = "edit.insertrow";
	/** 追加行(A) */
	public static final String ADD_ROW = "edit.addrow";
	/** 复制行 */
	public static final String DUP_ROW = "edit.duprow";
	/** 复制行 */
	public static final String DUP_ROW_ADJUST = "edit.duprowadjust";
	/** 插入列(C) */
	public static final String INSERT_COL = "edit.insertcol";
	/** 追加列(D) */
	public static final String ADD_COL = "edit.addcol";
	/** 回车换行(E)ctrl-enter */
	public static final String CTRL_ENTER = "edit.ctrlenter";
	/** 右移单元格(I)ctrl-insert */
	public static final String CTRL_INSERT = "edit.ctrlinsert";
	/** 下移单元格(S)alt-insert */
	public static final String ALT_INSERT = "edit.altinsert";
	/** 删除(D) */
	public static final String DELETE = "edit.delete";
	/** 清除 */
	public static final String CLEAR = "edit.clear";
	/** 全部清除 */
	public static final String FULL_CLEAR = "edit.fullclear";
	/** 删除行(R) */
	public static final String DELETE_ROW = "edit.deleterow";
	/** 删除列(C) */
	public static final String DELETE_COL = "edit.deletecol";
	/** 退格(B)ctrl-backspace */
	public static final String CTRL_BACK = "edit.ctrlback";
	/** 本格删除(D)ctrl-delete */
	public static final String CTRL_DELETE = "edit.ctrldelete";
	/** 移动复制(M) */
	public static final String MOVE_COPY = "edit.movecopy";
	/** 向上移动复制 */
	public static final String MOVE_COPY_UP = "edit.movecopyup";
	/** 向下移动复制 */
	public static final String MOVE_COPY_DOWN = "edit.movecopydown";
	/** 向左移动复制 */
	public static final String MOVE_COPY_LEFT = "edit.movecopyleft";
	/** 向右移动复制 */
	public static final String MOVE_COPY_RIGHT = "edit.movecopyright";
	/** 文本编辑框 */
	public static final String TEXT_EDITOR = "edit.texteditor";
	/** 注释 ctrl-/ */
	public static final String NOTE = "edit.note";
	/** 格式(O) */
	public static final String FORMAT = "edit.format";
	/** 行高(H) */
	public static final String ROW_HEIGHT = "edit.rowheight";
	/** 合适行高(R) */
	public static final String ROW_ADJUST = "edit.rowadjust";
	/** 隐藏行(I) */
	public static final String ROW_HIDE = "edit.rowhide";
	/** 取消隐藏行(V) */
	public static final String ROW_VISIBLE = "edit.rowvisible";
	/** 列宽(W) */
	public static final String COL_WIDTH = "edit.colwidth";
	/** 合适列宽(C) */
	public static final String COL_ADJUST = "edit.coladjust";
	/** 隐藏列(D) */
	public static final String COL_HIDE = "edit.colhide";
	/** 取消隐藏列(S) */
	public static final String COL_VISIBLE = "edit.colvisible";
	/** 统计图(G) */
	public static final String CHART = "edit.chart";
	/** 函数辅助(A) */
	public static final String FUNC_ASSIST = "edit.funcassist";
	/** 网格画布(G) */
	public static final String CANVAS = "edit.canvas";
	/** 查找(F) */
	public static final String SEARCH = "edit.search";
	/** 替换(R) */
	public static final String REPLACE = "edit.replace";

	/** 撤销(Z) */
	public static final short iUNDO = MENU_DFX + 101;
	/** 重做(Y) */
	public static final short iREDO = MENU_DFX + 103;
	/** 复制ctrl-C */
	public static final short iCOPY = MENU_DFX + 111;
	/** 值复制ctrl-alt-C */
	public static final short iCOPYVALUE = MENU_DFX + 113;
	/** 代码复制ctrl-shift-C */
	public static final short iCODE_COPY = MENU_DFX + 115;
	/** 复制可呈现代码(C)无窗口html */
	public static final short iCOPY_HTML = MENU_DFX + 117;
	/** 复制可呈现代码(P) */
	public static final short iCOPY_HTML_DIALOG = MENU_DFX + 119;
	/** 剪切ctrl-X */
	public static final short iCUT = MENU_DFX + 121;
	/** 粘贴ctrl-V */
	public static final short iPASTE = MENU_DFX + 123;
	/** 变迁粘贴ctrl-alt-V */
	public static final short iPASTE_ADJUST = MENU_DFX + 125;
	/** Ctrl-Shift-V */
	public static final short iPASTE_SPECIAL = MENU_DFX + 127;
	/** 插入列(C) */
	public static final short iINSERT_COL = MENU_DFX + 131;
	/** 追加列(D) */
	public static final short iADD_COL = MENU_DFX + 133;
	/** 复制行 */
	public static final short iDUP_ROW = MENU_DFX + 141;
	/** 复制行 */
	public static final short iDUP_ROW_ADJUST = MENU_DFX + 143;
	/** 回车换行(E)ctrl-enter */
	public static final short iCTRL_ENTER = MENU_DFX + 145;
	/** 右移单元格(I)ctrl-insert */
	public static final short iCTRL_INSERT = MENU_DFX + 151;
	/** 下移单元格(S)alt-insert */
	public static final short iALT_INSERT = MENU_DFX + 153;
	/** 清除 */
	public static final short iCLEAR = MENU_DFX + 160;
	/** 全部清除 */
	public static final short iFULL_CLEAR = MENU_DFX + 162;
	/** 删除行(R) */
	public static final short iDELETE_ROW = MENU_DFX + 164;
	/** 删除列(C) */
	public static final short iDELETE_COL = MENU_DFX + 165;
	/** 退格(B)ctrl-backspace */
	public static final short iCTRL_BACK = MENU_DFX + 167;
	/** 本格删除(D)ctrl-delete */
	public static final short iCTRL_DELETE = MENU_DFX + 169;
	/** 文本编辑框 */
	public static final short iTEXT_EDITOR = MENU_DFX + 171;
	/** 向上移动复制 */
	public static final short iMOVE_COPY_UP = MENU_DFX + 175;
	/** 向下移动复制 */
	public static final short iMOVE_COPY_DOWN = MENU_DFX + 176;
	/** 向左移动复制 */
	public static final short iMOVE_COPY_LEFT = MENU_DFX + 177;
	/** 向右移动复制 */
	public static final short iMOVE_COPY_RIGHT = MENU_DFX + 178;
	/** 注释 ctrl-/ */
	public static final short iNOTE = MENU_DFX + 180;
	/** 行高(H) */
	public static final short iROW_HEIGHT = MENU_DFX + 182;
	/** 合适行高(R) */
	public static final short iROW_ADJUST = MENU_DFX + 183;
	/** 隐藏行(I) */
	public static final short iROW_HIDE = MENU_DFX + 184;
	/** 取消隐藏行(V) */
	public static final short iROW_VISIBLE = MENU_DFX + 185;
	/** 列宽(W) */
	public static final short iCOL_WIDTH = MENU_DFX + 186;
	/** 合适列宽(C) */
	public static final short iCOL_ADJUST = MENU_DFX + 187;
	/** 隐藏列(D) */
	public static final short iCOL_HIDE = MENU_DFX + 188;
	/** 取消隐藏列(S) */
	public static final short iCOL_VISIBLE = MENU_DFX + 189;
	/** 统计图(G) */
	public static final short iEDIT_CHART = MENU_DFX + 191;
	/** 函数辅助(A) */
	public static final short iFUNC_ASSIST = MENU_DFX + 193;
	/** 查找(F) */
	public static final short iSEARCH = MENU_DFX + 195;
	/** 替换(R) */
	public static final short iREPLACE = MENU_DFX + 197;

	/**
	 * 程序(P)
	 */
	public static final String PROGRAM = "program";
	/** 网格参数(P) */
	public static final String PARAM = "program.param";
	/** 重置执行环境 */
	public static final String RESET = "program.reset";
	/** 执行 */
	public static final String EXEC = "program.exec";
	/** 调试执行 */
	public static final String EXE_DEBUG = "program.exe_debug";
	/** 执行到光标 */
	public static final String STEP_CURSOR = "program.stepcursor";
	/** 单步执行 */
	public static final String STEP_NEXT = "program.stepnext";
	/** 单步进入 */
	public static final String STEP_INTO = "program.stepinto";
	/** 单步返回 */
	public static final String STEP_RETURN = "program.stepreturn";
	/** 中断单步调试(T) */
	public static final String STEP_STOP = "program.stepstop";
	/** 暂停执行 */
	public static final String PAUSE = "program.pause";
	/** 继续执行 */
	public static final String CONTINUE = "program.continue";
	/** 停止执行 */
	public static final String STOP = "program.stop";
	/** 设置/取消断点 */
	public static final String BREAKPOINTS = "program.breakpoints";
	/** 计算当前格并锁定 */
	public static final String CALC_LOCK = "program.execlock";
	/** 计算格值 */
	public static final String CALC_AREA = "program.execarea";
	/** 显示格值 */
	public static final String SHOW_VALUE = "programe.showcellvalue";
	/** 清除格值(C) */
	public static final String CLEAR_VALUE = "program.clearvalue";
	/** 图形绘制(A) */
	public static final String DRAW_CHART = "program.drawchart";

	/** 网格参数(P) */
	public static final short iPARAM = MENU_DFX + 201;
	/** 重置执行环境 */
	public static final short iRESET = MENU_DFX + 210;
	/** 执行 */
	public static final short iEXEC = MENU_DFX + 221;
	/** 调试执行 */
	public static final short iEXE_DEBUG = MENU_DFX + 223;
	/** 执行到光标 */
	public static final short iSTEP_CURSOR = MENU_DFX + 225;
	/** 单步执行 */
	public static final short iSTEP_NEXT = MENU_DFX + 231;
	/** 单步进入 */
	public static final short iSTEP_INTO = MENU_DFX + 233;
	/** 单步返回 */
	public static final short iSTEP_RETURN = MENU_DFX + 235;
	/** 中断单步调试(T) */
	public static final short iSTEP_STOP = MENU_DFX + 237;
	/** 暂停和继续执行 */
	public static final short iPAUSE = MENU_DFX + 241;
	/** 停止执行 */
	public static final short iSTOP = MENU_DFX + 243;
	/** 设置/取消断点 */
	public static final short iBREAKPOINTS = MENU_DFX + 251;
	/** 计算当前格并锁定 */
	public static final short iCALC_LOCK = MENU_DFX + 261;
	/** 计算格值 */
	public static final short iCALC_AREA = MENU_DFX + 263;
	/** 显示格值 */
	public static final short iSHOW_VALUE = MENU_DFX + 265;
	/** 清除格值(C) */
	public static final short iCLEAR_VALUE = MENU_DFX + 267;
	/** 图形绘制(A) */
	public static final short iDRAW_CHART = MENU_DFX + 271;

	/** 工具(T) */
	public static final String TOOL = "tool";
	/** 网格常量(N) */
	public static final String CONST = "program.const";
	/** 命令行执行网格 */
	public static final String EXEC_CMD = "tool.execcmd";
	/** Sql生成器(Q) */
	public static final String SQLGENERATOR = "program.sqlgenerator";
	/** 在文件中查找替换 */
	public static final String FILE_REPLACE = "tool.filereplace";

	/** 网格常量(N) */
	public static final short iCONST = MENU_DFX + 301;
	/** 命令行执行网格 */
	public static final short iEXEC_CMD = MENU_DFX + 311;
	/** Sql生成器(Q) */
	public static final short iSQLGENERATOR = MENU_DFX + 321;
	/** 在文件中查找替换 */
	public static final short iFILE_REPLACE = MENU_DFX + 341;

	/** 远程 */
	/** 登录 */
	public static final short iREMOTE_SERVER_LOGIN = MENU_DFX + 401;
	/** 注销 */
	public static final short iREMOTE_SERVER_LOGOUT = MENU_DFX + 403;
	/** 数据源 */
	public static final short iREMOTE_SERVER_DATASOURCE = MENU_DFX + 405;
	/** 上传文件 */
	public static final short iREMOTE_SERVER_UPLOAD_FILE = MENU_DFX + 407;

}
