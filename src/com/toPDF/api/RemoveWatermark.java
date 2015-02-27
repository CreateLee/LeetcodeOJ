package com.toPDF.api;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfLayer;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年12月2日上午9:37:51
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class RemoveWatermark {

    public static void main(String[] args) throws FileNotFoundException,
	    DocumentException, IOException {
	// TODO Auto-generated method stub
	rmWatermark(null);
	//rmWM();
    }

    public static void rmWatermark(String file) throws FileNotFoundException,
	    DocumentException, IOException {
	// TODO Auto-generated method stub
	PdfReader reader = new PdfReader("./Min Stack.pdf");

	PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
		"./ms.pdf"));

	Map<String, PdfLayer> layers = stamper.getPdfLayers();
	
	System.out.println(layers.size());

	Set<String> set = layers.keySet();
	
	System.out.println(layers.isEmpty() ? "yes" : "no");
	
	System.out.println(set.size());

	int i = 1;
	for (String key : set) {
	    for (PdfName name : layers.get(key).getKeys()) {
		System.out.println(i++);
	    }
	    System.out.println(layers.get(key).getKeys());
	}

	stamper.close();
	reader.close();
    }

    public static void rmWM() throws FileNotFoundException, DocumentException,
	    IOException {
	PdfReader reader = new PdfReader("./Min Stack.pdf");
	PdfDictionary root = reader.getCatalog();
	root.remove(PdfName.OCPROPERTIES);
	root.remove(PdfName.WATERMARK);
	PdfDictionary page;
	PdfArray contentarray;
	PRStream stream;
	String content;
	PdfDictionary resources;
	PdfDictionary xobjects;
	for (int i = 0; i < reader.getNumberOfPages(); i++) {
	    page = reader.getPageN(1);
	    contentarray = page.getAsArray(PdfName.CONTENTS);
	    if (contentarray != null) {
		for (int j = 0; j < contentarray.size(); j++) {
		    stream = (PRStream) contentarray.getAsStream(j);
		    content = new String(PdfReader.getStreamBytes(stream));
		    if (content.indexOf("/OC") > 0) {
			stream.put(PdfName.LENGTH, new PdfNumber(0));
			stream.setData(new byte[0]);
		    }
		}
	    }
	    resources = page.getAsDict(PdfName.RESOURCES);
	    xobjects = resources.getAsDict(PdfName.XOBJECT);
	    for (PdfName name : xobjects.getKeys()) {
		stream = (PRStream) xobjects.getAsStream(name);
		if (stream.get(PdfName.OC) == null)
		    continue;
		stream.put(PdfName.LENGTH, new PdfNumber(0));
		stream.setData(new byte[0]);
	    }
	}
	PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
		"test_.pdf"));
	stamper.setViewerPreferences(PdfWriter.PageModeUseNone);
	stamper.close();
    }
}
