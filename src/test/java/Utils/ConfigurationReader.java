package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    /* this class will be responsible for loading properties file
        and will provide access to values based on key names.

     */
    // We use this class to load custom .properties files
    private static Properties configFile;

    // static block is run only once, instead of being run many times
    static {
        try {
            //provide access to file
            //try & catch block stand for handling exceptions
            //// if exception occurs, code inside a catch block will be executed
            // any class that is related to InputOutput produce checked exceptions
            // without handling checked exceptions, you cannot run a code
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");

            configFile = new Properties();
            // load your properties file
            configFile.load(fileInputStream);
            // close configuration. properties file
            fileInputStream.close();
        }catch(IOException e){
            System.out.println("Failed to load properties file");
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return configFile.getProperty(key);
    }
}
