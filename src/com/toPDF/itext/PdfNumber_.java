package com.toPDF.itext;

import com.itextpdf.text.pdf.PdfNumber;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年11月12日下午6:21:08
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PdfNumber_ {
    public static void main(String[] args) {
	showObject(new PdfNumber("1.5"));
	showObject(new PdfNumber(100));
	showObject(new PdfNumber(100l));
	showObject(new PdfNumber(1.5));
	showObject(new PdfNumber(1.5f));
    }

    public static void showObject(PdfNumber obj) {
	System.out.println(obj.getClass().getName() + ":");
	System.out.println("-> number? " + obj.isNumber());
	System.out.println("-> type: " + obj.type());
	System.out.println("-> bytes: " + new String(obj.getBytes()));

	System.out.println("-> toString: " + obj.toString());
	System.out.println("-> intValue: " + obj.intValue());
	System.out.println("-> longValue: " + obj.longValue());
	System.out.println("-> doubleValue: " + obj.doubleValue());
	System.out.println("-> floatValue: " + obj.floatValue());
    }
}
