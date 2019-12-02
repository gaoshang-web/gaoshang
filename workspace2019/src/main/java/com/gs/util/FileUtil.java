package com.gs.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class FileUtil {
	/**
	 * <pre>excelDownload(导出excel)
	 * 创建人：高尚博 2407499008@qq.com
	 * 创建时间：2019年6月25日 下午4:14:51
	 * 修改人：高尚博 2407499008@qq.com
	 * 修改时间：2019年6月25日 下午4:14:51
	 * 修改备注：
	 * @param wirthExcelWB
	 * @param response</pre>
	 */
	public static void excelDownload(XSSFWorkbook wirthExcelWB,HttpServletResponse response) {
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			//让浏览器识别是什么类型的文件
			response.reset(); // 重点突出
			response.setCharacterEncoding("UTF-8"); // 重点突出
			response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
			// inline在浏览器中直接显示，不提示用户下载
			// attachment弹出对话框，提示用户进行下载保存本地
			// 默认为inline方式
			response.setHeader("Content-Disposition", "attachment;filename="+ UUID.randomUUID().toString()+".xlsx");
			wirthExcelWB.write(out);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( null != out){
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
