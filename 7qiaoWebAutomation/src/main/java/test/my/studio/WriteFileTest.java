package test.my.studio;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteFileTest {
	public static void main(String args[]) {
		try {
			File f = new File("F:\\input.xml");
			FileInputStream fis;

			fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			String linetxt = "";
			try {
				while ((line = br.readLine()) != null) {
					linetxt = linetxt + line;
				}
				linetxt.replaceAll("//s+/g", "");
				System.out.println(linetxt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"F:\\output_Buffer.xml"));
			bw.write(linetxt);

			bw.flush();
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
