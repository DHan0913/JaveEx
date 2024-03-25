package com.javaex.opp.song.v1;


public class SongApp {

	public static void main(String[] args) {
		

		Song s1 = new Song("아이유", "Real", "좋은날","2010", "3번 track", "이민수 작곡");
		Song s2 = new Song("BIGBANG","Always", "거짓말", "2007", "2번 track", "G-DRAGON 작곡");
		Song s3 = new Song("버스커버스커","버스커버스커1집", "벚꽃엔딩", "2012", "4번 track", "장범준 작곡");

		s1.showinfo();
		s2.showinfo();
		s3.showinfo();
	}
}
