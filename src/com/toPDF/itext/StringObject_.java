package com.toPDF.itext;

import java.io.UnsupportedEncodingException;

import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.xml.simpleparser.NewLineHandler;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年11月12日下午7:08:09
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class StringObject_ {
    public static void main(String[] args) throws UnsupportedEncodingException {
	PdfString s1 = new PdfString("Test");
	PdfString s2 = new PdfString("\u6d4b\u8bd5", PdfString.TEXT_UNICODE);
	System.out.println(new String("\u6d4b\u8bd5".getBytes(), "unicode"));
	showObject(s1);
	showObject(s2);
	s1.setHexWriting(true);
	showObject(s1);
	showObject(new PdfDate());
    }

    public static void showObject(PdfString obj) {
	System.out.println(obj.getClass().getName() + ":");
	System.out.println("-> string? " + obj.isString());
	System.out.println("-> type: " + obj.type());
	System.out.println("-> bytes: " + new String(obj.getBytes()));
	System.out.println("-> toString: " + obj.toString());
	System.out.println("-> hexWriting: " + obj.isHexWriting());
	System.out.println("-> encoding: " + obj.getEncoding());
	System.out.println("-> bytes: " + new String(obj.getOriginalBytes()));
	System.out.println("-> unicode string: " + obj.toUnicodeString());
    }

}
