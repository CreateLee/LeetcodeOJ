package com.toPDF.topK;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014��12��2������12:14:57
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class TopK {
    private static int wordFrequent = 0;

    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	Map<String, Integer> entry = new HashMap<String, Integer>();

	File dirFile = new File("E:\\BaiduYunDownload\\ebook3000\\text");

	for (String string : dirFile.list()) {
	    // System.out.println(dirFile.getAbsolutePath()+ File.separator
	    // +string);
	    text2Map(entry, dirFile.getAbsolutePath() + File.separator + string);
	}

	Date date = new Date();
	System.out.println(date.getMinutes() + ":" + date.getSeconds());

	maxK(500, entry);
	date = new Date();
	System.out.println(date.getMinutes() + ":" + date.getSeconds());

    }

    public static String map2File(Map<String, Integer> map) throws IOException {
	String filePath = "./entrt.txt";
	File entry = new File(filePath);

	RandomAccessFile randomAccessFile = new RandomAccessFile(entry, "rw");

	Set<String> keys = map.keySet();

	for (String word : keys) {
	    randomAccessFile.write((word + "\t" + map.get(word)).getBytes());

	    randomAccessFile.write((char) Character.LINE_SEPARATOR);
	}

	randomAccessFile.close();

	return entry.getAbsolutePath();
    }

    /*
     * ��m�������и�ȡһ����������¼ÿ��������Դ���飬����һ����k��Ԫ�صĴ���ѡ�
     * ��ʱ�Ѷ�������������ȡ���Ѷ�Ԫ�أ����ӶѶ�Ԫ�ص���Դ������ȡ��һ��������ѣ���ȡ���ֵ��һֱ��������k�μ��ɡ� ʱ�临�Ӷȣ�k*log2(20)
     */
    public static void maxK(final int k, Map<String, Integer> map) {
	System.out.println(map.size() + "****************");

	TreeSet<Word> set = new TreeSet<Word>(new WordComparator());

	Set<String> keys = map.keySet();

	System.out.println(keys.size());

	for (String word : keys) {
	    wordFrequent += map.get(word);
	    
	    if (set.size() > k) {
		if (set.first().getFrequent() < map.get(word)) {
		    set.first().setList(null);
		    set.remove(set.first());

		    set.add(new Word(word, map.get(word)));
		} else if (set.first().getFrequent() == map.get(word)) {
		    set.first().getList().add(new Word(word, map.get(word)));
		}
	    } else {
		set.add(new Word(word, map.get(word)));
	    }
	}

	float wordsVar = map.size();
	float percent = 0;
	System.out.println("******setSize******" + set.size());
	System.out.println();

	Iterator<Word> iter = set.iterator();

	while (iter.hasNext()) {
	    Word tmp = iter.next();
	    double per = tmp.getFrequent();
	    percent += per;
	    
	    System.out.print(tmp.getWord() + "\t" + tmp.getFrequent() + "\t\t" + per);

	    if (!(tmp.getList().isEmpty())) {
		for (Word word : tmp.getList()) {
		    System.out.print(word.getWord() + "\t");
		}
	    }

	    System.out.println();
	}

	System.out.println();
	System.out.println(percent/wordFrequent);
    }

    public static void text2Map(Map<String, Integer> wordsMap, String filePath)
	    throws IOException {
	RandomAccessFile randomAccessFile = new RandomAccessFile(new File(
		filePath), "rw");

	String tempString = randomAccessFile.readLine();

	while (true) {
	    if (tempString == null) {
		break;
	    }

	    tempString = tempString.toLowerCase();
	    String[] strings = tempString.split("\\W+|\\d+");

	    for (String wordKey : strings) {
		if (wordKey.length() < 2) {
		    continue;
		}
		if (wordsMap.containsKey(wordKey.toLowerCase())) {
		    wordsMap.put(wordKey.toLowerCase(),
			    wordsMap.get(wordKey.toLowerCase()) + 1);
		} else {
		    wordsMap.put(wordKey.toLowerCase(), 1);
		}
	    }

	    tempString = randomAccessFile.readLine();
	}

    }

}

class WordComparator implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
	// TODO Auto-generated method stub
	return -(o1.getFrequent() - o2.getFrequent());
    }

}
