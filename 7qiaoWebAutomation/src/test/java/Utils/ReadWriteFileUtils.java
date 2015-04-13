package Utils;

import Utils.StringUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * 
 * Read and Write File
 *
 */


public class ReadWriteFileUtils {

	static String line = "";

	public static void ReadWriteFile() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("F:\\input.xml"));

			String lineTxt = null;
			while ((lineTxt = br.readLine()) != null) {
				line = line + lineTxt;
			}

			System.out.println(line);

			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void WriteFile(String line) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("F:\\output_buff.xml"));
			if (line != null) {
				bw.write(line);
				bw.flush();
				bw.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ReadWriteFile();
		StringUtils su = new StringUtils();
		System.out.println(su.replaceBlack(line));
		WriteFile(su.replaceBlack(line));
	}

}
