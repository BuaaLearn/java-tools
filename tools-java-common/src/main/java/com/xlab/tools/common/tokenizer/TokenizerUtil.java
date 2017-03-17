package com.xlab.tools.common.tokenizer;

import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * <p>
 * 分词工具
 * </p>
 */
public class TokenizerUtil {

    /**
     * <p>
     * 转化为字符数组
     * </p>
     * 
     * @param sentA
     * @return
     */
    public static String[] toStrArray(String sentA) {
        if (sentA == null) {
            return null;
        }
        String strs[] = new String[sentA.length()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = sentA.substring(i, i + 1);
        }
        return strs;
    }

    /**
     * <p>
     * 转化为词语的数组
     * </p>
     * 
     * @param sentA
     * @return
     */
    public static String[] toWordArray(String sentA) {
        List<Term> listTerm = NlpAnalysis.parse(sentA);
        String ret[] = new String[listTerm.size()];
        for (int i = 0; i < listTerm.size(); i++) {
            ret[i] = listTerm.get(i).getName();
        }
        return ret;
    }

    /**
     * <p>
     * Nlp的to模式进行分词
     * </p>
     * 
     * @param sentA
     * @return
     */
    public static String[] toWordArrayTo(String sentA) {
        List<Term> listTerm = ToAnalysis.parse(sentA);
        // List<Term> listTerm = NlpAnalysis.parse(sentA);
        String ret[] = new String[listTerm.size()];
        for (int i = 0; i < listTerm.size(); i++) {
            ret[i] = listTerm.get(i).getName();
        }
        return ret;
    }//

    /**
     * <p>
     * 使用索引的方式进行分词,粒度很细,混合的
     * </p>
     * 
     * @param sentA
     * @return
     */
    public static String[] toWordArrayIndex(String sentA) {
        List<Term> listTerm = IndexAnalysis.parse(sentA);
        String ret[] = new String[listTerm.size()];
        for (int i = 0; i < listTerm.size(); i++) {
            ret[i] = listTerm.get(i).getName();
        }
        return ret;
    }

    /**
     * <p>
     * 使用base的方式进行分词
     * </p>
     * 
     * @param sentA
     * @return
     */
    public static String[] toWordArrayBase(String sentA) {
        List<Term> listTerm = BaseAnalysis.parse(sentA);
        String ret[] = new String[listTerm.size()];
        for (int i = 0; i < listTerm.size(); i++) {
            ret[i] = listTerm.get(i).getName();
        }
        return ret;
    }
}
