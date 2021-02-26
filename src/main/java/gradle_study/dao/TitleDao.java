package gradle_study.dao;

import java.util.List;

import gradle_study.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
	
	Title selecTitleByNo(Title title);
	
	int insertTitle(Title title);
	int updateTitle(Title title);
	int deleteTitle(Title title);
	
}
