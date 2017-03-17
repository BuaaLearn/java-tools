package com.xlab.tools.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 文件工具类
 */
public class FileUtil {

    private static Logger log = LogManager.getLogger(FileUtil.class);

    /**
     * <p>
     * 按行追加的方式写入到文件
     * </p>
     * 
     * @param fileName
     * @param line
     * @param flag 是否覆盖创建文件.true为覆盖创建,false追加并创建文件
     */
    public static void append(String fileName, String line, boolean flag) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (!flag) {
                file.createNewFile();
                log.warn("file " + file + " has created");
            } else {
                log.error("file " + file + " not exist");
                return;
            }
        }
        // 如果为true的话，就需要进行追加
        FileWriter writer = new FileWriter(fileName, true);
        writer.append(line + "\r\n");
        writer.close();
    }

    /**
     * <p>
     * 判断文件是否存在
     * </p>
     * 
     * @param fileName
     * @return 文件名称
     */
    public static boolean exist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }


    /**
     * <p>
     * 文件删除操作
     * </p>
     * 
     * @param filename
     */
    public static void deleteFile(String filename) {
        if (exist(filename)) {
            log.info("start to delete file:" + filename);
            new File(filename).delete();
        }
    }

    /**
     * <p>
     * 多个文件删除
     * </p>
     * 
     * @param filenames 多个文件名称
     */
    public static void deleteFile(String... filenames) {
        for (String filename : filenames) {
            deleteFile(filename);
        }
    }

    /**
     * 加载资源文件
     * 
     * @param fileName 资源文件名称
     * @return
     * @throws IOException
     */
    public static List<String> readByResource(String fileName) throws IOException {
        InputStream in = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        List<String> list = new ArrayList<String>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().length() > 0) {
                list.add(line);
            }
        }
        reader.close();
        in.close();
        return list;
    }


    /**
     * 读取目录的子文件
     * 
     * @param folderName
     * @return
     */
    public static String[] getlistFile(String folderName) {
        File file = new File(folderName);
        if (file.isDirectory()) {
            return file.list();
        } else {
            return null;
        }
    }

    /**
     * 按行读取文件
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<String> readByLine(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            log.error("file '" + fileName + "' not exist.");
            return null;
        }
        InputStream in = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        List<String> list = new ArrayList<String>();
        String line = null;
        while ((line = reader.readLine()) != null) {

            if (!line.trim().isEmpty()) {
                list.add(line);
            }
        }
        reader.close();
        in.close();
        return list;
    }

    /**
     * <p>
     * 文件重命名
     * </p>
     * 
     * @param srcName
     * @param newName
     */
    public static void reName(String srcName, String newName) {
        File file = new File(srcName);
        if (!file.exists()) {
            log.error("file '" + srcName + "' not exist.");
            return;
        }
        file.renameTo(new File(newName));
    }


    /**
     * 判断文件的编码格式
     * 
     * @param fileName :file
     * @return 文件编码格式
     * @throws Exception
     */
    public static String getFileEncode(String fileName) throws Exception {
        FileInputStream fileIn = new FileInputStream(fileName);
        BufferedInputStream bin = new BufferedInputStream(fileIn);
        int p = (bin.read() << 8) + bin.read();
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        fileIn.close();
        bin.close();
        return code;
    }

}
