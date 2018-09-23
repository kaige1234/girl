package cn.com.ssm.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class propertiesUtil1 {
    private static Logger logger = LoggerFactory.getLogger(propertiesUtil1.class);
    private static Properties pro =null;

    static{
        pro = new Properties();
        String path="util/filepath.properties";
        try {
            pro.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(path),"Utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperties(String key){
        String value = pro.getProperty(key);
        if(StringUtils.isBlank(value)){
            return "";
        }
        return value.trim();
    }


    public static void main(String[] args){
        propertiesUtil1 pros =  new propertiesUtil1();
       String value = pros.getProperties("file.path");

       System.out.println(value);
    }

}
