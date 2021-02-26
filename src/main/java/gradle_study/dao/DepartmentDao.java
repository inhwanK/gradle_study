package gradle_study.dao;

import java.util.List;

import gradle_study.dto.Department;


public interface DepartmentDao {
	List<Department> selectDeptByAll();
	Department selectDeptByNo(Department dept);
	
	int insertDept(Department dept);
	int updateDept(Department dept);
	int deleteDept(Department dept);
	
	
}
