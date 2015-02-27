package com.toPDF.test;

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
 * @Time: 2014年11月12日下午1:16:26
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Test {

    public static void main(String[] args) throws MalformedURLException,
	    IOException, COSVisitorException {
	// TODO Auto-generated method stub
	String apikey = "abcde12345";
	//String url = "http://svn.apache.org/repos/asf/pdfbox/trunk/pdfbox/src/main/java/org/apache/pdfbox/contentstream/operator/Operator.java";
	
	String url = "http://www.digg.com";
	
	File outs = new File("mypdf.pdf");

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
