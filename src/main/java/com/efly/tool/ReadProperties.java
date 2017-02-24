package com.efly.tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Nic on 2017/1/23.
 * 读取properties文件内容的工具类
 */
public class ReadProperties {
    public String Read(String path , String key){

        //读取properties文件，path为文件路径
        InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream(path);
        Properties properties = new Properties();
        try{
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return (String)properties.getProperty(key);
    }
}
