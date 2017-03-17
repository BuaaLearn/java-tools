package com.xlab.tools.common.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.xlab.tools.common.logger.LogUtil;

/**
 * <p>基础文件的读写</p>
 *
 */
public abstract class BaseLineReader<D> {
    private Logger log = LogUtil.getCommonLogger();

    /**
     * 
     * @param filename
     * @param processor
     * @return
     * @throws Exception
     */
    public List<D> readByLines(String filename,LineProcessor<D> processor){
        List<D> list = new ArrayList<>();
        BufferedReader br = null;
        String line = null;
        try {
            br = getReader(filename);
            while(null!=(line = br.readLine())){
                if(line!=null && !line.isEmpty()){
                   D d = processor.process(line);
                   if(d!=null){
                       list.add(d);
                   }
                }
            }
        } catch (IOException e) {
            log.error("load fail..."+filename,e);
        }finally{
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("close  fail..."+filename,e);
                }
            }
        }
        return list;
    }

    /**
     * 获得缓存流的读写
     * @param filename
     * @return
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException 
     */
    protected abstract BufferedReader getReader(String filename) throws UnsupportedEncodingException, FileNotFoundException ;
}
