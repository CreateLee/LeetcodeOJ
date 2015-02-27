package com.toPDF.itext.html2pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年11月13日上午10:29:34
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class ParseHtmlAsian {
    public static final String HTML = "./hero.html";
    public static final String DEST = "./hero.pdf";

    /**
     * Creates a PDF with the words "Hello World"
     * 
     * @param file
     * @throws IOException
     * @throws DocumentException
     */
    public void createPdf(String file) throws IOException, DocumentException {
	Document document = new Document();

	PdfWriter writer = PdfWriter.getInstance(document,
		new FileOutputStream("hero.pdf"));

	document.open();

	XMLWorkerHelper.getInstance().parseXHtml(writer, document,
		new FileInputStream("hero.html"), Charset.forName("UTF-8"));

	document.close();
    }

    /**
     * Main method
     */
    public static void main(String[] args) throws IOException,
	    DocumentException {
	File file = new File(DEST);
	file.getParentFile().mkdirs();
	new ParseHtmlAsian().createPdf(DEST);
    }
}
