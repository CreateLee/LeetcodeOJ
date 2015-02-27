package com.toPDF.itext;

import com.itextpdf.text.pdf.PdfBoolean;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年11月12日下午6:19:06
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class PdfBoolean_ {
    public static void main(String[] args) {
	showObject(PdfBoolean.PDFTRUE);
	showObject(PdfBoolean.PDFFALSE);
    }

    public static void showObject(PdfBoolean obj) {
	System.out.println(obj.getClass().getName() + ":");
	System.out.println("-> boolean? " + obj.isBoolean());
	System.out.println("-> type: " + obj.type());
	System.out.println("-> toString: " + obj.toString());
	System.out.println("-> booleanvalue: " + obj.booleanValue());
    }
}
