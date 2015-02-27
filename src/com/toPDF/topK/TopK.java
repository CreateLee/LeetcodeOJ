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
 * @Time: 2014年12月2日下午12:14:57
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
     * 从m个数组中各取一个数，并记录每个数的来源数组，建立一个含k个元素的大根堆。
     * 此时堆顶就是最大的数，取出堆顶元素，并从堆顶元素的来源数组中取下一个数加入堆，再取最大值，一直这样进行k次即可。 时间复杂度：k*log2(20)
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
