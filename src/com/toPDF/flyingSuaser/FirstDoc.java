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
 * @Time: 2014年11月16日下午3:34:29

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
	// 生成文件名
	String fileName = url.split("/")[url.split("/").length - 1];
	// 生成文件路径及文件名
	fileName = savePthDir + fileName;

	HttpURLConnection httpUrl = null;
	BufferedInputStream bis = null;
	FileOutputStream fos = null;

	try {
	    // 得到 httpurl 连接
	    httpUrl = (HttpURLConnection) new URL(url).openConnection();
	    // 连接指定的网络资源
	    httpUrl.connect();
	    // 获取网络输入流
	    bis = new BufferedInputStream(httpUrl.getInputStream());
	    //
	    fos = new FileOutputStream(fileName);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	// 设置代理服务器
	/*
	 * System.getProperties().put("proxySet", "true");
	 * System.getProperties().put("proxyHost", "10.154.134.110");
	 * System.getProperties().put("proxyPort", "8080");
	 */

	int temp;
	// 保存文件
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
