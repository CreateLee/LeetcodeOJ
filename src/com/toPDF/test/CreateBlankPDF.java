package com.toPDF.test;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年11月12日下午1:09:07
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class CreateBlankPDF {

    public static void main(String[] args) throws COSVisitorException, IOException {
	// TODO Auto-generated method stub
	// Create a new empty document
	PDDocument document = new PDDocument();

	// Create a new blank page and add it to the document
	PDPage blankPage = new PDPage();
	document.addPage(blankPage);

	// Save the newly created document
	document.save("./BlankPage.pdf");

	// finally make sure that the document is properly
	// closed.
	document.close();

    }

}
