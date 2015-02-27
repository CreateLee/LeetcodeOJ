package com.toPDF.topK.token;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.toPDF.topK.Word;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年12月6日下午10:27:12
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Proced {

    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	getMap("proced", 100);
    }

    public static void getMap(String filePath, int k) throws IOException {
	File entry = new File(filePath);

	RandomAccessFile randomAccessFile = new RandomAccessFile(entry, "rw");

	String entrys = randomAccessFile.readLine();

	TreeSet<Word> set = new TreeSet<Word>(new WordComparator());

	while (true) {
	    if (entrys == null) {
		break;
	    }

	    if (set.size() > k) {
		if (set.first().getFrequent() < Integer.parseInt(entrys
			.split(",")[1].trim())) {
		    set.remove(set.first());
		    set.add(new Word(entrys.split(" ")[0], Integer
			    .parseInt(entrys.split(" ")[1].trim())));
		}
	    } else {
		set.add(new Word(entrys.split(",")[0], Integer.parseInt(entrys
			.split(",")[1].trim())));
	    }

	    entrys = randomAccessFile.readLine();

	}

	randomAccessFile.close();

	Iterator<Word> iter = set.iterator();

	while (iter.hasNext()) {
	    Word tmp = iter.next();

	    if (!(tmp.getList().isEmpty())) {
		for (Word word : tmp.getList()) {
		    System.out.print(word.getWord() + "\t" + word.getFrequent());
		}
	    }

	    System.out.println();
	}

	System.out.println();

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

	    System.out.print(tmp.getWord() + "\t" + tmp.getFrequent() + "\t\t"
		    + per);

	    if (!(tmp.getList().isEmpty())) {
		for (Word word : tmp.getList()) {
		    System.out.print(word.getWord() + "\t");
		}
	    }

	    System.out.println();
	}

	System.out.println();

    }

}

class WordComparator implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
	// TODO Auto-generated method stub
	return -(o1.getFrequent() - o2.getFrequent());
    }

}
