package com.skula.school.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.os.Environment;

public class FileCreator {
	private static final String SCHOOL_FOLDER = "school";
	
	public static boolean writeFile(String name, List<List<String>> lines){
		try {
			String dirPath = Environment.getExternalStorageDirectory() + File.separator + SCHOOL_FOLDER;
	
			File myDir = new File(dirPath); 
			Boolean success = true;
			if (!myDir.exists()) {
				success = myDir.mkdir(); 
			}
			if (success) {
				Calendar c = Calendar.getInstance(); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String fileName = sdf.format(c.getTime()) + "_" + name + ".csv";
				
				File myFile = new File(dirPath, fileName);

				FileWriter fw = new FileWriter(myFile, true);
				BufferedWriter output = new BufferedWriter(fw);
				
				for(List<String> line : lines){
					for(String value : line){
						output.write(value+";");
					}
					output.write("\n");
				}
				output.flush();
				output.close();
			}
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
}
