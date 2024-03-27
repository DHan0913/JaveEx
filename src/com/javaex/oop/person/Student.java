package com.javaex.oop.person;

public class Student extends Person { //자식 extends 부모
	
	private String schoolName;

	
	//생성자
	public Student(String schoolName) {
		super("찾을수 없음", 0);
		this.schoolName = schoolName;
		
	}
	public Student(String name, int age, String schoolName) {
		super(name, age);
		this.schoolName = schoolName;
	}
	
//	getters/setters
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		
		this.schoolName = schoolName;
	}
	
	@Override
	public void showinfo() {
		super.showinfo();
		System.out.println("학교:" + schoolName );
	}
	
}
