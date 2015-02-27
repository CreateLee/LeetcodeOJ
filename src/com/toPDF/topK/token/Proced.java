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
 * @Time: 2014��12��6������10:27:12
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
     * ��m�������и�ȡһ����������¼ÿ��������Դ���飬����һ����k��Ԫ�صĴ���ѡ�
     * ��ʱ�Ѷ�������������ȡ���Ѷ�Ԫ�أ����ӶѶ�Ԫ�ص���Դ������ȡ��һ��������ѣ���ȡ���ֵ��һֱ��������k�μ��ɡ� ʱ�临�Ӷȣ�k*log2(20)
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
