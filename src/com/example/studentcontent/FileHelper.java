package com.example.studentcontent;

import java.io.BufferedReader;
import java.util.List;

import android.content.Context;
import android.widget.Toast;

public class FileHelper {
	private static List<StuInfo> st;
	private static Context mContext;
	public FileHelper() {
	}

	public FileHelper(Context mContext, List<StuInfo> st) {
		super();
		FileHelper.st = st;
		FileHelper.mContext = mContext;
	}

	public void readFileOnLine(BufferedReader a) {// 输入文件路径
		try {
			String line = "";
			int index = 0, i = 0;
			line = a.readLine();
			
			while (line!= null) {// 通过readline按行读取
				StuInfo t=new StuInfo();
				index = line.indexOf(" ");
				t.setID(line.substring(0, index).trim());
				line = line.substring(index).trim();
				
				index = line.indexOf(" ");
				t.setName(line.substring(0, index).trim());
				
				index = line.indexOf(" ");
				line = line.substring(index).trim();
				t.setS1(Integer.valueOf(line.substring(0, index).trim()));

				index = line.indexOf(" ");
				line = line.substring(index).trim();
				t.setS2(Integer.valueOf(line.substring(0, index).trim()));

				index = line.indexOf(" ");
				line = line.substring(index).trim();
				t.setS3(Integer.valueOf(line.substring(0, index).trim()));
				st.add(t);
				i++;
				line=a.readLine();
			}
			StuInfo.NUM = i;
		} catch (Exception e) {
			Toast.makeText(mContext, "失败", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}

}