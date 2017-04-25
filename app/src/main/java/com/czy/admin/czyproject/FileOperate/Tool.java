package com.czy.admin.czyproject.FileOperate;

import android.util.Log;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 工具类
 *
 * @author gph
 */
public class Tool {
	/**
	 * 将字符串写入到文本文件中
	 */
	public void writeTxtToFile(String strcontent, String filePath,
			String fileName) {
		// 生成文件夹之后，再生成文件，不然会出错
		makeFilePath(filePath, fileName);// 生成文件

		String strFilePath = filePath + fileName;
		// 每次写入时，都换行写
		String strContent = strcontent + "\r\n";
		try {
			File file = new File(strFilePath);
			if (!file.exists()) {
				Log.d("TestFile", "Create the file:" + strFilePath);
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			RandomAccessFile raf = new RandomAccessFile(file, "rwd");
			raf.seek(file.length());
			raf.write(strContent.getBytes());
			raf.close();
		} catch (Exception e) {
			Log.e("error:", e + "");
		}
	}

	/**
	 * 生成文件
	 */
	public File makeFilePath(String filePath, String fileName) {
		File file = null;
		makeRootDirectory(filePath);// 生成文件夹
		try {
			file = new File(filePath + fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * 生成文件夹
	 */
	public static void makeRootDirectory(String filePath) {
		File file = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.mkdir();
			}
		} catch (Exception e) {
			Log.i("error:", e + "");
		}
	}
}
