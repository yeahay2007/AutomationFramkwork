package test.my.studio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFileTest {
	public static void readTxtFile(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(fis);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String line = "";
				while ((lineTxt = bufferedReader.readLine()) != null) {
					line = line + lineTxt;
				}
				System.out.println(line);
				read.close();
			} else {
				System.out.println("Can not find the file");
			}
		} catch (Exception e) {
			System.out.println("Error for read file content");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		String filePath = "F:\\input.xml";
		readTxtFile(filePath);
	}
}
