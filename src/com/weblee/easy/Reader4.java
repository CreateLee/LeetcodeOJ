package com.weblee.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.transform.Templates;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2015年3月7日下午12:52:30
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Reader4 {
    private int pos = 0;

    public File getFile() {
	return file;
    }

    public void setFile(File file) {
	this.file = file;
    }

    private File file = null;

    /*
     * The API: int read4(char *buf) reads 4 characters at a time from a file.
     */
    public int read4(char[] buf) {
	/*
	 * clear buf's value 
	 */
	for (int i=0; i<buf.length; i++) {
	    buf[i] = ' ';
	}
	
	int arrayLen = buf.length;
	RandomAccessFile raf = null;
	try {
	    raf = new RandomAccessFile(file, "r");

	    try {
		/*
		System.out.println(raf.length());
		if (pos < raf.length()) {
		    raf.seek(pos);
		} else {
		    return 0;
		}
		*/
		raf.seek(pos);
		
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(" ## seek exception");
		e.printStackTrace();
	    }

	    while (--arrayLen != -1) {
		try {
		    int temp;
		    if ((temp = raf.read()) != -1) {
			buf[buf.length - 1 - arrayLen] = (char) temp;
		    } else {
			break;
		    }
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    System.out.println(arrayLen + "\t"
			    + "## readBool exception");
		    e.printStackTrace();
		}
	    }
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    try {
		raf.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

	pos += (buf.length - arrayLen - 1);

	// System.out.println("\t" + "\t" + pos);
	return buf.length - arrayLen - 1;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Reader4 reader4 = new Reader4();

	reader4.setFile(new File("a.txt"));

	char[] buf = new char[6];

	System.out.print(reader4.read4(buf) + "\t");

	for (char c : buf) {
	    System.out.print("\t" + c);
	}

	System.out.println();

	System.out.print(reader4.read4(buf) + "\t");

	for (char c : buf) {
	    System.out.print("\t" + c);
	}
    }

}
