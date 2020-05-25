package com.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * Created by gaoxl on 2020/5/15.
 */
public class ProUtils {

    private Properties pro;

    public ProUtils(String filepath){
        pro = readProperties(filepath);
    }

    /**
     * 读取properties
     * @return pro
     */
    private Properties readProperties(String filepath){
        Properties p = new Properties();
        try {
            FileInputStream f = new FileInputStream(filepath);
            BufferedInputStream bf = new BufferedInputStream(f);
            p.load(bf);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return p;
    }

    /**
     * get value by key
     * @param key
     * @return
     */
    public String getPro(String key){
        String result = "";
        if (pro.containsKey(key)) {
            result = pro.getProperty(key);
        }
        return result;
    }

    public int getLines(){
        return pro.size();
    }

    public static void main(String[] args){
        ProUtils po = new ProUtils("element.properties");
        String result = po.getPro("username");
        System.out.println(result);
        System.out.println(po.getLines());
    }
}