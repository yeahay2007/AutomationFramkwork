package selenium.my.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {

	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");  
        String currentDate = sdf.format(d);
        System.out.print(currentDate);
	}

}
