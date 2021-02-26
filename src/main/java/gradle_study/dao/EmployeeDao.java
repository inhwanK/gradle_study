package gradle_study.dao;

import java.util.List;

import gradle_study.dto.Employee;

public interface EmployeeDao {

	List<Employee> selectByEmpAll();

	Employee selectByEmpNo(Employee emp);

	// insert
	int insertEmp(Employee emp);

	// update
	int updateEmp(Employee emp);

	// delete
	int deleteEmp(Employee emp);
}
