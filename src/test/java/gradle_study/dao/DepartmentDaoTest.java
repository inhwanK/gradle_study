package gradle_study.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import gradle_study.dao.impl.DepartmentDaoImpl;
import gradle_study.dto.Department;

public class DepartmentDaoTest {
	private DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();
	private static final String con = null;

	@Test
	public void testSelectDeptByAll() {
		List<Department> list = dao.selectDeptByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectDeptByNo() {
		System.out.println("testSelectDeptByNo");
		Department selectDept = dao.selectDeptByNo(new Department(1));
		Assert.assertNotNull(selectDept);
		System.out.println(selectDept);
	}

	@Test
	public void testInsertDept() {
		System.out.println("testInsertDept");
		Department inDept = new Department(8, "마케팅", 23);
		int res = dao.insertDept(inDept);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testUpdateDept() {
		System.out.println("testUpdateDept");
		Department upDept = new Department(8,"연구",29);
		int res = dao.updateDept(upDept);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testDeleteDept() {
		System.out.println("testDeleteDept");
		Department deDept = new Department(8);
		int res = dao.deleteDept(deDept);
		Assert.assertEquals(1, res);
		
		System.out.println(dao.selectDeptByNo(deDept));
	}

}
