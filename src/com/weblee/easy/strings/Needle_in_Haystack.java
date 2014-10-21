package com.weblee.easy.strings;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��10��19������9:47:35
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Needle_in_Haystack {
    /*
     * haystack �Ƿ����string needle����Y��������ʼλ�ú��string
     */
    public static String strStr(String haystack, String needle) {
	//
	// haystack.contains(needle);
	String string = haystack.substring(indexOf(haystack.toCharArray(), 0, haystack.length(), needle.toCharArray(), 0, needle.length(), 0));
	
	System.out.println(string + "+++++");
	
	if (haystack == null || needle == null)
	    return null;
	if (needle.length() == 0)
	    return haystack;

	if (needle.length() > haystack.length())
	    return null;

	for (int i = 0; i <= haystack.length() - needle.length(); i++) {
	    boolean isPass = true;
	    for (int j = 0; j < needle.length(); j++) {
		if (haystack.charAt(i + j) != needle.charAt(j)) {
		    isPass = false;
		    break;
		}
	    }
	    if (isPass == true) {
		return haystack.substring(i);
	    }
	}
	return null;
    }
    
    public static void main(String[] args) {
	System.out.println();
	System.out.println(strStr("likaiweblk", "kaiweb"));
    }
    
    
    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     *
     * @param   source       the characters being searched.
     * @param   sourceOffset offset of the source string.
     * @param   sourceCount  count of the source string.
     * @param   target       the characters being searched for.
     * @param   targetOffset offset of the target string.
     * @param   targetCount  count of the target string.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
            char[] target, int targetOffset, int targetCount,
            int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
}
