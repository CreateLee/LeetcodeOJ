package com.toPDF.api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.pdfbox.exceptions.COSVisitorException;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年12月2日上午9:30:02
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class HTML2PDF {
    public static void main(String[] args) throws MalformedURLException,
	    IOException, COSVisitorException {
	// TODO Auto-generated method stub
	String apikey = "abcde12345";
	
	String url = "https://oj.leetcode.com/problems/min-stack";
	

	File outs = new File("Min Stack.pdf");

	URL u = new URL("http://api.htm2pdf.co.uk/urltopdf?apikey=" + apikey
		+ "&url=" + url);
	URLConnection uc = u.openConnection();
	BufferedInputStream is = new BufferedInputStream(uc.getInputStream());
	BufferedOutputStream bout = new BufferedOutputStream(
		new FileOutputStream(outs));

	byte[] b = new byte[8 * 1024];
	int read = 0;

	while ((read = is.read(b)) > -1) {
	    bout.write(b, 0, read);
	}

	bout.flush();
	bout.close();
	is.close();
    }
}
