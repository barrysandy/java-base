package com.xgb.java.base.mytomcat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件工具类
 * <p>Title: 文件工具栏</p>
 * <p>Description:专门读取静态资源 </p>
 *
 * @author xiaowu
 * @version 1.0.0
 * @date 2018/6/25 14:53
 */
public class FileUtils {

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String getFileContent(String path) {
		StringBuffer sb = new StringBuffer();
		FileReader fileReader = null;
		BufferedReader br = null;
		//字符流
		try {
			fileReader = new FileReader(path);
			br = new BufferedReader(fileReader);
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return sb.toString();
	}

}
