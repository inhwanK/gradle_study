package gradle_study.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gradle_study.dto.Department;
import gradle_study.dto.Title;

public class TransactionServiceTest {
private static TransactionService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//TransactionService 실행하기 전에 수행.
		service = new TransactionService();
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		//TransactionService 실행한  후에 수행.
		service = null;
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01TranAddTitleAndDepartment_FailTitle() {
		System.out.printf("%s()%n","testTranAddTitleAndDepartment_FailTitle");
		Title title = new Title(1,"인턴");
		Department dept = new Department(5,"비상계획부",10);
		String res = service.tranAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback",res);
	}
	@Test
	public void test02TranAddTitleAndDepartment_FailDept() {
		System.out.printf("%s()%n","testTranAddTitleAndDepartment_FailDept");
		Title title = new Title(5,"인턴");
		Department dept = new Department(1,"비상계획부",10);
		
		String res = service.tranAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback",res);
	}
	
	@Test
	public void test03TranAddTitleAndDepartment_FailBoth() {
		System.out.printf("%s()%n","testTranAddTitleAndDepartment_FailBoth");
		Title title = new Title(1,"인턴");
		Department dept = new Department(1,"비상계획부",10);
		
		String res = service.tranAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback",res);
	}
	@Test
	public void test04TranAddTitleAndDepartment_Success() {
		System.out.printf("%s()%n","testTranAddTitleAndDepartment_Success");
		Title title = new Title(6,"인턴");
		Department dept = new Department(5,"비상계획부",90);
		
		String res = service.tranAddTitleAndDepartment(title, dept);
		Assert.assertEquals("commit",res);
	}

	@Test
	public void test05TranRemoveTitleAndDepartment_FailTitle() {
		System.out.printf("%s()%n","testTranRemoveTitleAndDepartment_FailTitle");
		Title title = new Title(0);
		Department dept = new Department(5);
		
		int res = service.tranRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(1,res);
	}
	@Test
	public void test06TranRemoveTitleAndDepartment_FailDept() {
		System.out.printf("%s()%n","testTranRemoveTitleAndDepartment_FailDept");
		Title title = new Title(6);
		Department dept = new Department(0);
		
		int res = service.tranRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(1,res);
	}
	@Test
	public void test07TranRemoveTitleAndDepartment_FailBoth() {
		System.out.printf("%s()%n","testTranRemoveTitleAndDepartment_FailBoth");
		Title title = new Title(0);
		Department dept = new Department(0);
		
		int res = service.tranRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(0,res);
	}
	@Test
	public void test08TranRemoveTitleAndDepartment_Success() {
		System.out.printf("%s()%n","testTranRemoveTitleAndDepartment_Success");
		Title title = new Title(6);
		Department dept = new Department(5);
		
		int res = service.tranRemoveTitleAndDepartment(title, dept);
		Assert.assertEquals(2,res);
	}

}
