package com.zy.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFile();
	}
	
	public static void getFile() {
		File file = new File("d:\\zy.txt");
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			int i;
			//fileInputStream = new FileInputStream(file);
			bufferedReader = new BufferedReader(fileReader);
//			while((i = fileReader.read()) != -1) {
//				//System.out.print("intΪ"+i);
//			}
			//fileReader.close();
			String s = "";
			while((s = bufferedReader.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//fileInputStream.close();
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
