package com.weblee.easy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年3月7日下午12:48:33
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ReadNCharactersGivenRead4II extends Reader4 {
    private char[] buffer = new char[4];
    int offset = 0, bufsize = 0;

    /*
     * The read4 API is defined in the parent class Reader4. int read4(char[]
     * buf);
     */
    public int read(char[] buf, int n) {
	int readBytes = 0;
	boolean eof = false;
	while (!eof && readBytes < n) {
	    int sz = (bufsize > 0) ? bufsize : read4(buffer);
	    if (bufsize == 0 && sz < 4)
		eof = true;
	    int bytes = Math.min(n - readBytes, sz);
	    System.arraycopy(buffer /* src */, offset /* srcPos */,
		    buf /* dest */, readBytes /* destPos */, bytes /* length */);
	    offset = (offset + bytes) % 4;
	    bufsize = sz - bytes;
	    readBytes += bytes;
	}
	return readBytes;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
