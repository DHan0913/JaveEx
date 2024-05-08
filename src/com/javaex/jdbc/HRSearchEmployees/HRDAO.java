package com.javaex.jdbc.HRSearchEmployees;

import java.util.List;

public interface HRDAO {
	// List - SELECT
	public List<HRVO> getList();	// 전체 목록
	public HRVO get(String name);	//	PK로 객체 찾기
	
}
