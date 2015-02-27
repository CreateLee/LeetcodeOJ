package com.toPDF.topK;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weblee
 * @Email: likaiweb@163.com
 * @Blog: http://www.cnblogs.com/lkzf/
 * @Time: 2014年12月2日下午12:50:46
 * 
 *************        function description ***************
 *
 ****************************************************
 */

public class Word {
    private String word;
    private int frequent;
    // frequent === class
    //List<Word> list = new ArrayList<Word>();
    List<Word> list;

    public List<Word> getList() {
        return list;
    }

    public void setList(List<Word> list) {
        this.list = list;
    }

    public Word() {
    }

    public Word(String word, int frequent) {
	this.word = word;
	this.frequent = frequent;
    }

    public String getWord() {
	return word;
    }

    public void setWord(String word) {
	this.word = word;
    }

    public int getFrequent() {
	return frequent;
    }

    public void setFrequent(int frequent) {
	this.frequent = frequent;
    }
}
