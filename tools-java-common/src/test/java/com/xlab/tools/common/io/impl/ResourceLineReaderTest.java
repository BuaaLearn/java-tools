package com.xlab.tools.common.io.impl;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.xlab.tools.common.io.LineProcessor;


public class ResourceLineReaderTest {

   
    @Test
    public void testReadByLines() {
        ResourceLineReader<UnitMapper> reader = new ResourceLineReader<>();
        String filename = "unitsMapper";
        List<UnitMapper> readByLines = reader.readByLines(filename , new LineProcessor<UnitMapper>() {
            @Override
            public UnitMapper process(String line) {
                String[] lines = line.split(" ");
                if(lines.length!=2){
                    return null;
                }else{
                    return new UnitMapper(lines[0],lines[1]);
                }
            }
        });
        System.out.println("size:"+readByLines.size());
        assertEquals("fail", 8,readByLines.size());
    }
}
class UnitMapper{
    private String chName;
    private String enName;
    /**
     * @param chName
     * @param enName
     */
    public UnitMapper(String chName, String enName) {
        super();
        this.chName = chName;
        this.enName = enName;
    }
    /**
     * @return the chName
     */
    public String getChName() {
        return chName;
    }
    /**
     * @param chName the chName to set
     */
    public void setChName(String chName) {
        this.chName = chName;
    }
    /**
     * @return the enName
     */
    public String getEnName() {
        return enName;
    }
    /**
     * @param enName the enName to set
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "enName:"+enName+",cnName:"+chName;
    }
}
