package com.javaex.opp.song.v3;

public class Song {

	private String title;	
	private String artist;
	private String album;
	private String composer;
	private String year;
	private String track;


	public Song() {
	}
	
	public Song(String title, String artist) {
		this.title=title;
		this.artist=artist;
		System.out.println("title, artist 초기화");
	
	}
	
	public Song(String artist, String title, String album, String year, String track, String composer) {
		this(title, artist);
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
		System.out.println("전체 필드 생성자");
	}

	public String gettitle() {

		return title;
	}
//	public void settitle(String tilte) {
//		this.title = title;
//	}
	
	public String getartist() {

		return artist;
	}
//	public void setartist(String artist) {
//		this.artist = artist;
//	}
	public String getalbum() {

		return album;
	}
//	public void setalbul(String album) {
//		this.album = album;
//	}
	public String getcomposer() {

		return composer;
	}
//	public void setcomposer(String composer) {
//		this.composer = composer;
//	}
	public String getyear() {

		return year;
	}
//	public void setyear(String year) {
//		this.year = year;
//	}
	public String gettrack() {

		return track;
	}
//	public void settrack(String track) {
//		this.track = track;
//	}
	
	public void showinfo() {
		System.out.println(artist +", " + album + " (" + title + ", " + year +", " + track +", " + composer+")");
	}
}
