package gradle_study.dao;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import gradle_study.dao.impl.EmployeeDaoImpl;
import gradle_study.dto.Department;
import gradle_study.dto.Employee;
import gradle_study.dto.Title;

public class EmployeeDaoTest {


	private EmployeeDao dao = EmployeeDaoImpl.getInstance();
	

	@Test
	public void test01SelectByEmpAll() {
		System.out.printf("%s()%n","testSelectEmployeeByAll");
		List<Employee> list = dao.selectByEmpAll();
		Assert.assertNotNull(list);
//		list.stream().forEach(System.out::println);
		for(Employee e : list) {
			System.out.println(e);
		}
	}

	@Test
	public void test02SelectByEmpNo() {
		System.out.println("testSelectEmpByNo()");
		Employee selectEmp = dao.selectByEmpNo(new Employee(2106));
		Assert.assertNotNull(selectEmp);
		System.out.println(selectEmp);
	}

	@Test
	public void test03InsertEmp() {
		System.out.println("testInsertTitle()");
		Employee newEmp= new Employee(1004,"천사", new Title(5), new Employee(4377), 1000000, new Department(1));//값 안넣어서 그럼.
		int res = dao.insertEmp(newEmp);
		Assert.assertEquals(1, res);

	}

	@Test
	public void test04UpdateEmp() {
		System.out.println("testUpdateTitle()");
		Employee upEmp = new Employee(1004,"천사", new Title(4),new Employee(1003),10000000, new Department(3));// 이것도 값안넣어서 그ㅐㄹ
		int res = dao.updateEmp(upEmp);
		Assert.assertEquals(1, res);
		

		System.out.println(dao.selectByEmpNo(upEmp));
	}

	@Test
	public void test05DeleteEmp() {
		System.out.println("testdeleteTitle()");
		Employee deEmp = new Employee(1004);//이것도. ㅎ
		int res = dao.deleteEmp(deEmp);
		Assert.assertEquals(1, res);
		
		System.out.println(dao.selectByEmpNo(deEmp));
	}

}
