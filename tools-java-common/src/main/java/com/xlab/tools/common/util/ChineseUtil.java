package com.xlab.tools.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.Logger;

import com.xlab.tools.common.io.logger.LogUtil;


public class ChineseUtil {
	private static Logger log = LogUtil.getCommonLogger();

	/**
	 * 简体中文
	 */
	static Set<Character> setZhSimple = new HashSet<>();

	/**
	 * 繁体中文
	 */
	static Set<Character> setZhTraditional = new HashSet<>();

	static {
		String fileName = "all-zh.txt";
		List<String> lines = new ArrayList<>();
		try {
			lines = FileUtil.readByResource(fileName);
		} catch (IOException e) {
			log.error(e);
		}
		if (0 == setZhSimple.size()) {
			setZhSimple = extractCharacter(2, 4, lines);
		}
		if (0 == setZhTraditional.size()) {
			setZhTraditional = extractCharacter(4, 4, lines);
		}
	}

	/**
	 * 半角转全角
	 * 
	 * @param input
	 *            str
	 * @return 全角字符串
	 */
	public static String transSingleToDouble(String str) {
		char c[] = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (' ' == c[i]) {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);
			}
		}
		return new String(c);
	}

	/**
	 * 抽取字符
	 * @param start 开始行, 从1开始
	 * @param step 步长
	 * @param lines
	 * @return
	 */
	private static Set<Character> extractCharacter(int start, int step,
			List<String> lines) {
		Set<Character> sets = new HashSet<>();
		for (int i = start - 1; i < lines.size(); i = i + step) {
			String line = lines.get(i);
			for (int j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);
				if (' ' != ch) {
					sets.add(ch);
				}
			}
		}
		return sets;
	}

	/**
	 * 全角转半角
	 * 
	 * @param input
	 *            String.
	 * @return 半角字符串
	 */
	public static String transDoubleToSingle(String str) {
		char c[] = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if ('\u3000' == c[i]) {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);
			}
		}
		return new String(c);
	}
	
	/**
     * <p>
     * 中文金额转化为数字型.比如两百-->200
     * </p>
     * @param text 中文字符串
     * @param quantifier 计量单位
     * @return
     */
    public static double transCnToDouble(String text, double quantifier) {
		double amounts = 0;
		int pos = -1;
		if ((pos = text.indexOf("亿"))!=-1) {
			amounts = transCnToDouble(text.substring(0,pos),10) * 100000000 + transCnToDouble(text.substring(pos+1),100000000);
		}else if((pos = text.indexOf("万"))!=-1) {
			amounts = transCnToDouble(text.substring(0,pos),10) * 10000 + transCnToDouble(text.substring(pos+1),10000);
		}else {
			//默认量级设成10，之后*0.1就会变成1。
			double temp=0;
			while (!text.isEmpty()) {
				switch (text.charAt(0)) {
				case '1':
				case '一':
				case '壹':
					temp = temp*10+1;
					break;
				case '2':
				case '二':
				case '两':
				case '贰':
					temp= temp*10+2;
					break;
				case '3':
				case '三':
				case '叁':
				case '叄':
					temp= temp*10+3;
					break;
				case '4':
				case '四':
				case '肆':
					temp= temp*10+4;
					break;
				case '5':
				case '五':
				case '伍':
					temp= temp*10+5;
					break;
				case '6':
				case '六':
				case '陆':
					temp= temp*10+6;
					break;
				case '7':
				case '七':
				case '柒':
					temp= temp*10+7;
					break;
				case '8':
				case '八':
				case '捌':
					temp= temp*10+8;
					break;
				case '9':
				case '九':
				case '玖':
					temp= temp*10+9;
					break;
				case '0':
				case '零':
					temp= temp*10+0;
					break;
				case '十':
				case '拾':
					if(temp==0)
						temp=1;
					quantifier = 10;
					amounts += temp*quantifier;
					temp=0;
					break;
				case '百':
				case '佰':
				case '陌':
					quantifier = 100;
					amounts += temp*quantifier;
					temp=0;
					break;
				case '千':
				case '仟':
				case '阡':
					quantifier = 1000;
					amounts += temp*quantifier;
					temp=0;
					break;
				case '元':
				case '圆':
				case '块':
					quantifier = 1;
					amounts += temp * quantifier;
					temp=0;
					break;
				case '角':
				case '毛':
					quantifier = 0.1;
					amounts += temp*quantifier;
					temp=0;
					break;
				case '分':
					quantifier = 0.01;
					amounts += temp*quantifier;
					temp=0;
					break;
				default:
					break;
				}
				text = text.substring(1);
			}
			if (Double.compare(temp,0)!=0) {
				amounts += temp * quantifier * 0.1;
			}
		}
		return amounts;
	}

	/**
	 * 是否为简体中文
	 * 
	 * @param ch
	 * @return
	 */
	public static boolean isChSimple(char ch) {
			return setZhSimple.contains(ch);
	}

	/**
	 * 是否为繁体中文
	 * 
	 * @param ch
	 * @return
	 */
	public static boolean isChTraditional(char ch) {
		return setZhTraditional.contains(ch);
	}
}