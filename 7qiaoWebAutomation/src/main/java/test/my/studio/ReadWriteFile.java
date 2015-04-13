package test.my.studio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ReadWriteFile {
	public static void main(String args[]) {
		BufferedReader br;
		BufferedWriter bw;
		try {
			br = new BufferedReader(new FileReader("F:\\input.xml"));
			String line = "";
			String lineTxt = null;
			while ((lineTxt = br.readLine()) != null) {
				line = line + lineTxt;
			}
			line.replaceAll(" ", "");
			System.out.println(line);
			
			bw = new BufferedWriter(new FileWriter("F:\\output_buff.xml"));

			if (line != null) {
				bw.write(line);
				bw.flush();
				bw.close();
			}
			
			br.close();
			bw.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
