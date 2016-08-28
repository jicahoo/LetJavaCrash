package com.jichao.letjavacrash.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by jichao on 2016/8/28.
 */
public class ClassLoadUtil {

    public static List<Class> loadFromFile(final String filePath) {
        List<Class> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Class clazz = null;
                try {
                    clazz = Class.forName(line);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                list.add(clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
