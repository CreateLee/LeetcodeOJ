package com.toPDF.topK;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年12月2日下午10:43:39
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class GetTxtPdf {
    public static void main(String[] args) throws IOException {
	parsePdfs("E:\\BaiduYunDownload\\ebook3000\\Popular books related to Lucene and search");
    }

    public static void parsePdfs(String pdfDir) throws IOException {
	File dir = new File(pdfDir);

	for (File pdf : dir.listFiles()) {
	    if (pdf.isDirectory() && pdf.getName() != "text") {
		for (File pdfFile : pdf.listFiles()) {
		    String txtName = pdfDir
			    + File.separator
			    + "text"
			    + File.separator
			    + pdfFile.getName().subSequence(0,
				    pdfFile.getName().length() - 4);
		    // System.out.println(txtName);

		    parsePdf(pdfFile.getAbsolutePath(), txtName);
		}

	    } else {
		String txtName = pdfDir
			+ File.separator
			+ "text"
			+ File.separator
			+ pdf.getName().subSequence(0,
				pdf.getName().length() - 4);
		// System.out.println(txtName);

		parsePdf(pdf.getAbsolutePath(), txtName);
	    }

	    // break;
	}
    }

    /**
     * Parses a PDF to a plain text file.
     * 
     * @param pdf
     *            the original PDF
     * @param txt
     *            the resulting text
     * @throws IOException
     */
    public static void parsePdf(String pdf, String txt) throws IOException {
	PdfReader reader = new PdfReader(pdf);
	PdfReaderContentParser parser = new PdfReaderContentParser(reader);
	PrintWriter out = new PrintWriter(new FileOutputStream(txt));
	TextExtractionStrategy strategy;
	for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	    strategy = parser.processContent(i,
		    new SimpleTextExtractionStrategy());
	    out.println(strategy.getResultantText());
	}

	out.flush();
	out.close();
	reader.close();
    }
}
