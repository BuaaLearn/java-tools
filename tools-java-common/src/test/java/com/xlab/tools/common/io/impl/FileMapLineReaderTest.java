package com.xlab.tools.common.io.impl;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.xlab.tools.common.io.LineMapProcessor;
import com.xlab.tools.common.io.Pair;

public class FileMapLineReaderTest {

    @Test
    public void testReadByLines() {
        FileMapLineReader<String, UnitMapper> reader = new FileMapLineReader<>();
        String filename = "data/unitsMapper";
        Map<String, UnitMapper> lines =
                reader.readByLines(filename, new LineMapProcessor<String, UnitMapper>() {
                    @Override
                    public Pair<String, UnitMapper> process(String line) {
                        String[] lines = line.split(" ");
                        if (lines.length != 2) {
                            return null;
                        } else {
                            return new Pair<String, UnitMapper>(lines[0], new UnitMapper(lines[0],
                                    lines[1]));
                        }
                    }
                });
        System.out.println("size:" + lines.size());
        Set<Entry<String, UnitMapper>> entrySet = lines.entrySet();
        for (Entry<String, UnitMapper> entry : entrySet) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
        assertEquals("fail", 8, lines.size());
    }
}
