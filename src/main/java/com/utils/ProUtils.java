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

    public static void main(String[] args){
        Properties p = new Properties();
        try {
            FileInputStream f = new FileInputStream("element.properties");
            BufferedInputStream bf = new BufferedInputStream(f);
            p.load(bf);
            String username = p.getProperty("username");
            System.out.print(username);
        } catch (FileNotFoundException e){
            System.out.println("找不到文件");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("properties 读取失败");
            e.printStackTrace();
        }
    }
}
