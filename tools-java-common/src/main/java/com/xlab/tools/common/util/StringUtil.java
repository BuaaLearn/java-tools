package com.xlab.tools.common.util;

/**
 * <p>字符处理类</p>
 */
public class StringUtil {

	/**
	 * 
	 * <p>
	 * 判断是否中文字符
	 * </p>
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是不是单字
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isSingle(String text) {
		if (text.length() == 1)
			return true;
		return false;
	}

	/**
	 * 判断是不是只有汉字、英文字母和数字
	 * 
	 * @param text
	 *            需要检查的字符串
	 * @return
	 */
	public static boolean isLegal(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (isChinese(text.charAt(i)) || isNumber(text.charAt(i))
					|| isLetter(text.charAt(i)))
				continue;
			else
				return false;
		}
		return true;
	}

	/**
	 * 全角转半角
	 * 
	 * @param input
	 *            String.
	 * @return 半角字符串
	 */
	public static String toDBC(String input) {

		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);

			}
		}
		String returnString = new String(c);

		return returnString;
	}

    /**
     * 
     * <p>
     * 判断是否为空或空串或多个空格
     * </p>
     * @param value
     * @return
     */
    public static boolean isEmptyOrSpace(String value){
        return isEmpty(value) || value.trim().isEmpty();
    }

	/**
	 * <p>判断字符串是否为空</p>
	 * @param value
	 * @return
	 * @author huangtw3
	 * 2015年5月20日
	 */
    public static boolean isEmpty(String value) {
        return null == value || value.isEmpty();
    }
	/**
	 * 是否数字
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isNumber(char c) {
		if ((c >= '0' && c <= '9')) {
			return true;
		}
		return false;
	}
	/**
	 * 是否字母（绝对字母）
	 * @param c
	 * @return
	 */
	public static boolean isLetter(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			return true;
		}
		return false;
	}

    /**
     * <p>字符转化</p>
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if(null==obj){
            return "";
        }else{
            return obj.toString();
        }
    }

	/**
	 * 是否是特殊字符(除了字母，数字，汉字外)
	 * @param c
	 * @return
	 */
	public static boolean isSpecial(char c){//默认不排除特殊字符
	    if(isChinese(c) || isNumber(c) || isLetter(c)){
	        return false;
	    }
	    return true;
	}
}
