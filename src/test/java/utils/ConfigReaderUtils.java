package utils;
 

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderUtils {
    private Properties prop;

    public ConfigReaderUtils() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/secrets.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  

    public String getorderId() {
        return prop.getProperty("orderId");
    }
    
    public String keyId() {
        return prop.getProperty("keyId");
    }
    
    public String keySecret() {
        return prop.getProperty("keySecret");
    }
    
    public String paymentLinkId() {
    	return prop.getProperty("getorderId");
    }
    
}
