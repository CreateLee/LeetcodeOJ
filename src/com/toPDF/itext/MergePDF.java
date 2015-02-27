package com.toPDF.itext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.SimpleBookmark;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年11月13日上午8:56:04
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class MergePDF {
    private static Log log = new Log() {

	@Override
	public void warn(Object arg0, Throwable arg1) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void warn(Object arg0) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void trace(Object arg0, Throwable arg1) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void trace(Object arg0) {
	    // TODO Auto-generated method stub

	}

	@Override
	public boolean isWarnEnabled() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public boolean isTraceEnabled() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public boolean isInfoEnabled() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public boolean isFatalEnabled() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public boolean isErrorEnabled() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public boolean isDebugEnabled() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public void info(Object arg0, Throwable arg1) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void info(Object arg0) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void fatal(Object arg0, Throwable arg1) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void fatal(Object arg0) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void error(Object arg0, Throwable arg1) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void error(Object arg0) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void debug(Object arg0, Throwable arg1) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void debug(Object arg0) {
	    // TODO Auto-generated method stub

	}
    };

    public static void main(String[] args) {
	try {
	    List<InputStream> pdfs = new ArrayList<InputStream>();
	    pdfs.add(new FileInputStream("c:\\1.pdf"));
	    pdfs.add(new FileInputStream("c:\\2.pdf"));
	    OutputStream output = new FileOutputStream("c:\\merge.pdf");
	    MergePDF.concatPDFs(pdfs, output, true);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	try {
	    MergePDF.splitPDF(new FileInputStream("C:\\input.pdf"),
		    new FileOutputStream("C:\\output1.pdf"), 1, 12);
	    MergePDF.splitPDF(new FileInputStream("C:\\input.pdf"),
		    new FileOutputStream("C:\\output2.pdf"), 13, 20);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void iTextMerge(File baseFile, File bgFile, File outFile)
	    throws IOException, DocumentException {

	PdfReader bgReader = new PdfReader(bgFile.getAbsolutePath());
	PdfReader baseReader = new PdfReader(baseFile.getAbsolutePath());
	FileOutputStream out = new FileOutputStream(outFile);

	PdfStamper stamp = null;

	stamp = new PdfStamper(baseReader, out);
	Rectangle bgSize = bgReader.getCropBox(1);
	PdfImportedPage bgContent = stamp.getImportedPage(bgReader, 1);

	PdfGState blend = new PdfGState();
	blend.setFillOpacity(0.5f);
	// blend.setStrokeOpacity(0.5f);
	// blend.setBlendMode(PdfGState.BM_DARKEN);
	for (int i = 1; i <= baseReader.getNumberOfPages(); i++) {
	    Rectangle pageSize;
	    PdfContentByte content = stamp.getOverContent(i);

	    // content.setGState(blend);

	    pageSize = baseReader.getCropBox(i);
	    pageSize.rotate();

	    float hScale = pageSize.getWidth() / bgSize.getWidth(), vScale = pageSize
		    .getHeight() / bgSize.getHeight(), dominantScale = hScale < vScale ? hScale
		    : vScale, hTrans = (float) (pageSize.getLeft()
		    - bgSize.getLeft() * dominantScale + (pageSize.getWidth() - bgSize
		    .getWidth() * dominantScale) / 2.0), vTrans = (float) (pageSize
		    .getBottom() - bgSize.getBottom() * dominantScale + (pageSize
		    .getHeight() - bgSize.getHeight() * dominantScale) / 2.0);

	    content.addTemplate(bgContent, dominantScale, 0, 0, dominantScale,
		    hTrans, vTrans);

	}

	stamp.close();
    }
    
    public static void iTextMerge_(File baseFile, File bgFile, File outFile) throws IOException, DocumentException
    {
         
        PdfReader bgReader = new PdfReader(bgFile.getAbsolutePath());
        PdfReader baseReader = new PdfReader(baseFile.getAbsolutePath());
        FileOutputStream out = new FileOutputStream(outFile);
         
        PdfStamper stamp = null;
         
        stamp = new PdfStamper(baseReader, out);
        Rectangle bgSize = bgReader.getCropBox(1);
        PdfImportedPage bgContent = stamp.getImportedPage(bgReader, 1);
         
        PdfGState blend = new PdfGState();
        blend.setFillOpacity(0.5f);
    //  blend.setStrokeOpacity(0.5f);
    //  blend.setBlendMode(PdfGState.BM_DARKEN);
        for (int i = 1; i <= baseReader.getNumberOfPages(); i++)
        {
            Rectangle pageSize;
            PdfContentByte content = stamp.getOverContent(i);
              
             
        //  content.setGState(blend);
             
            pageSize = baseReader.getCropBox(i);
            pageSize.rotate();
             
            float hScale = pageSize.getWidth() / bgSize.getWidth(),
                  vScale = pageSize.getHeight() / bgSize.getHeight(),
                  dominantScale = hScale < vScale ? hScale : vScale,
                  hTrans = (float) (pageSize.getLeft() - bgSize.getLeft() * dominantScale + (pageSize.getWidth() - bgSize.getWidth() * dominantScale) / 2.0),
                  vTrans = (float) (pageSize.getBottom() - bgSize.getBottom() * dominantScale + (pageSize.getHeight() - bgSize.getHeight() * dominantScale) / 2.0);
             
             
            content.addTemplate(bgContent, dominantScale, 0, 0, dominantScale, hTrans, vTrans);
             
        }
         
        stamp.close();
         
         
    }

    public static void copyPages(InputStream inputStream,
	    OutputStream outputStream, int fromPage, int toPage) {
	try {
	    PdfReader reader = new PdfReader(inputStream);
	    Document document = new Document();
	    PdfCopy copy = new PdfCopy(document, outputStream);
	    int n = reader.getNumberOfPages();
	    document.open();
	    for (int i = fromPage; i < toPage + fromPage && i < n; i++) {
		copy.addPage(copy.getImportedPage(reader, i));
	    }

	    document.close();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (DocumentException e) {
	    e.printStackTrace();
	}
    }

    public static void splitPDFByBookmarks(String pdf, String outputFolder) {
	try {
	    PdfReader reader = new PdfReader(pdf);
	    // List of bookmarks: each bookmark is a map with values for title,
	    // page, etc
	    List<HashMap<String, Object>> bookmarks = SimpleBookmark
		    .getBookmark(reader);

	    for (int i = 0; i < bookmarks.size(); i++) {
		HashMap bm = bookmarks.get(i);
		HashMap nextBM = i == bookmarks.size() - 1 ? null : bookmarks
			.get(i + 1);
		// In my case I needed to split the title string
		String title = ((String) bm.get("Title")).split(" ")[2];

		// log.debug("Titel: " + title);
		String startPage = ((String) bm.get("Page")).split(" ")[0];
		String startPageNextBM = nextBM == null ? ""
			+ (reader.getNumberOfPages() + 1) : ((String) nextBM
			.get("Page")).split(" ")[0];
		// log.debug("Page: " + startPage);
		// log.debug("------------------");
		extractBookmarkToPDF(reader, Integer.valueOf(startPage),
			Integer.valueOf(startPageNextBM), title + ".pdf",
			outputFolder);
	    }
	} catch (IOException e) {
	    // log.error(e.getMessage());
	}
    }

    private static void extractBookmarkToPDF(PdfReader reader, int pageFrom,
	    int pageTo, String outputName, String outputFolder) {
	Document document = new Document();
	OutputStream os = null;

	try {
	    os = new FileOutputStream(outputFolder + outputName);

	    // Create a writer for the outputstream
	    PdfWriter writer = PdfWriter.getInstance(document, os);
	    document.open();
	    PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
	    PdfImportedPage page;

	    while (pageFrom < pageTo) {
		document.newPage();
		page = writer.getImportedPage(reader, pageFrom);
		cb.addTemplate(page, 0, 0);
		pageFrom++;
	    }

	    os.flush();
	    document.close();
	    os.close();
	} catch (Exception ex) {
	    // log.error(ex.getMessage());
	} finally {
	    if (document.isOpen())
		document.close();
	    try {
		if (os != null)
		    os.close();
	    } catch (IOException ioe) {
		// log.error(ioe.getMessage());
	    }
	}
    }

    /**
     * @author kevinLee
     *
     * @param inputStream
     *            Input PDF file
     * @param outputStream
     *            Output PDF file
     * @param fromPage
     *            start page from input PDF file
     * @param toPage
     *            end page from input PDF file
     */
    public static void splitPDF(InputStream inputStream,
	    OutputStream outputStream, int fromPage, int toPage) {
	Document document = new Document();
	try {
	    PdfReader inputPDF = new PdfReader(inputStream);

	    int totalPages = inputPDF.getNumberOfPages();

	    // make fromPage equals to toPage if it is greater
	    if (fromPage > toPage) {
		fromPage = toPage;
	    }
	    if (toPage > totalPages) {
		toPage = totalPages;
	    }

	    // Create a writer for the outputstream
	    PdfWriter writer = PdfWriter.getInstance(document, outputStream);

	    document.open();
	    PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
	    PdfImportedPage page;

	    while (fromPage <= toPage) {
		document.newPage();
		page = writer.getImportedPage(inputPDF, fromPage);
		cb.addTemplate(page, 0, 0);
		fromPage++;
	    }
	    outputStream.flush();
	    document.close();
	    outputStream.close();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (document.isOpen())
		document.close();
	    try {
		if (outputStream != null)
		    outputStream.close();
	    } catch (IOException ioe) {
		ioe.printStackTrace();
	    }
	}
    }

    public static void concatPDFs(List<InputStream> streamOfPDFFiles,
	    OutputStream outputStream, boolean paginate) {

	Document document = new Document();
	try {
	    List<InputStream> pdfs = streamOfPDFFiles;
	    List<PdfReader> readers = new ArrayList<PdfReader>();
	    int totalPages = 0;
	    Iterator<InputStream> iteratorPDFs = pdfs.iterator();

	    // Create Readers for the pdfs.
	    while (iteratorPDFs.hasNext()) {
		InputStream pdf = iteratorPDFs.next();
		PdfReader pdfReader = new PdfReader(pdf);
		readers.add(pdfReader);
		totalPages += pdfReader.getNumberOfPages();
	    }
	    // Create a writer for the outputstream
	    PdfWriter writer = PdfWriter.getInstance(document, outputStream);

	    document.open();
	    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
		    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	    PdfContentByte cb = writer.getDirectContent(); // Holds the PDF
	    // data

	    PdfImportedPage page;
	    int currentPageNumber = 0;
	    int pageOfCurrentReaderPDF = 0;
	    Iterator<PdfReader> iteratorPDFReader = readers.iterator();

	    // Loop through the PDF files and add to the output.
	    while (iteratorPDFReader.hasNext()) {
		PdfReader pdfReader = iteratorPDFReader.next();

		// Create a new page in the target for each source page.
		while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
		    document.newPage();
		    pageOfCurrentReaderPDF++;
		    currentPageNumber++;
		    page = writer.getImportedPage(pdfReader,
			    pageOfCurrentReaderPDF);
		    cb.addTemplate(page, 0, 0);

		    // Code for pagination.
		    if (paginate) {
			cb.beginText();
			cb.setFontAndSize(bf, 9);
			cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
				+ currentPageNumber + " of " + totalPages, 520,
				5, 0);
			cb.endText();
		    }
		}
		pageOfCurrentReaderPDF = 0;
	    }
	    outputStream.flush();
	    document.close();
	    outputStream.close();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (document.isOpen())
		document.close();
	    try {
		if (outputStream != null)
		    outputStream.close();
	    } catch (IOException ioe) {
		ioe.printStackTrace();
	    }
	}
    }
}
