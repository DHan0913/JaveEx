package com.javaex.jdbc.dao;

// 데이터 전송 객체(DTO)
// - 데이터베이스 필드에 매칭되는 필드
// - getters/setters
// -기본생성자
// - 로직은 (가급적) 포함하지 않음 
// - toString(), equals() 메서드는 포함하기도 한다
public class AuthorVO {
	// 필드 
	private Long authorId;	// PK
	private String authorName;
	private String authorDesc;
	
	// 기본 생성자 
	public AuthorVO() {
		
	}
	// 전체 필드 생성자
	public AuthorVO(Long authorId, String authorName, String authorDesc) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	// 필드 생성자
	public AuthorVO(String authorName, String authorDesc) {
		super();
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	} 
	// Getters / Setters
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	//	toString or or equals는 오버라이드 하기도 함
	@Override
	public String toString() {
		return "AuthorVO [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	
	
}
