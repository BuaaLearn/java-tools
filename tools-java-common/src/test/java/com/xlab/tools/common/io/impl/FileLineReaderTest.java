package com.xlab.tools.common.io.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.xlab.tools.common.io.LineProcessor;


public class FileLineReaderTest {

    @Test
    public void testReadByLines() {
        FileLineReader<UnitMapper> reader = new  FileLineReader<>();
        String filename = "data/unitsMapper";
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
