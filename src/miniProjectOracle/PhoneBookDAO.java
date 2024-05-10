package miniProjectOracle;

import java.util.List;


public interface PhoneBookDAO {
	public List<PhoneBookVO> getList();	// 전체 
	public boolean insert(PhoneBookVO phoneBookVO);	// 삽입 
	public boolean delete(Long id);	// 삭제
	public PhoneBookVO get(Long id);	// 검색
	
}
