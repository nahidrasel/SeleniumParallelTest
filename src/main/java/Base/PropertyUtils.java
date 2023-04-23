package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public Properties pro;
    public  final String ProjectDirectory = System.getProperty("user.dir").replace("\\", "/");
    public  void PropertiesReader() throws IOException {
         pro = new Properties();
         FileReader reader = new FileReader(ProjectDirectory + "/ConfigFiles/config.properties");
         pro.load(reader);
    }
}