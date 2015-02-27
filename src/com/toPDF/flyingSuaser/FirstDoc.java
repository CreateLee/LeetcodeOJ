package com.toPDF.flyingSuaser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��11��16������3:34:29

 *************  function description  ***************
 *
 ****************************************************
 */

public class FirstDoc {
    public static void main(String[] ags) throws DocumentException, IOException {
	String url = "http://www.itextpdf.com/";
	downHTMLbyURL(url, "./");
	
	
        String outputFile = "firstdoc.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(downHTMLbyURL(url, "./"));
        renderer.layout();
        renderer.createPDF(os);
        
        os.close();
    }
    
    public static String downHTMLbyURL(String url, String savePthDir) {
	// �����ļ���
	String fileName = url.split("/")[url.split("/").length - 1];
	// �����ļ�·�����ļ���
	fileName = savePthDir + fileName;

	HttpURLConnection httpUrl = null;
	BufferedInputStream bis = null;
	FileOutputStream fos = null;

	try {
	    // �õ� httpurl ����
	    httpUrl = (HttpURLConnection) new URL(url).openConnection();
	    // ����ָ����������Դ
	    httpUrl.connect();
	    // ��ȡ����������
	    bis = new BufferedInputStream(httpUrl.getInputStream());
	    //
	    fos = new FileOutputStream(fileName);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	// ���ô��������
	/*
	 * System.getProperties().put("proxySet", "true");
	 * System.getProperties().put("proxyHost", "10.154.134.110");
	 * System.getProperties().put("proxyPort", "8080");
	 */

	int temp;
	// �����ļ�
	try {
	    while ((temp = bis.read()) != -1) {
		fos.write((char) temp);
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    try {
		fos.close();
		bis.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    httpUrl.disconnect();
	}

	return fileName;
    }
}
