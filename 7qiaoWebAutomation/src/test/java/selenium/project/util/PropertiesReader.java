package selenium.project.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by admin on 2014/11/7.
 */
public class PropertiesReader {

    Properties prop;
    InputStream input;

    public PropertiesReader(){
        prop = new Properties();
        try {
            input = new FileInputStream("testResource.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getPropertiesName(String propName){
        try {
            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propName);
    }

}
