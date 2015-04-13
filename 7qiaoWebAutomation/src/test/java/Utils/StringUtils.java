package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * Replace blank space from the String
 * 注：\n 回车(\u000a) 
 * \t 水平制表符(\u0009) 
 * \s 空格(\u0008)
 * \r 换行(\u000d)
 *
 */

public class StringUtils {
	
	//For replace Black in String
	public String replaceBlack(String str){
		String dest = "";
		if (str!= null){
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static void main(String[] args) {
		
//		System.out.println(replaceBlack("Hello world   my timi"));
		
	}
}
