package gradle_study.dto;

public class Employee {
	private int empno;
	private String empname;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dept;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empno) {
		super();
		this.empno = empno;
	}

	public Employee(int empno, Department dept) {
		super();
		this.empno = empno;
		this.dept = dept;
	}

	public Employee(int empno, String empname, Title title, Employee manager, int salary, Department dept) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Title getTitle() {
		return title;
	}

	public int setTitle(Title title) {
		this.title = title;
		return this.title.getNo();
	}

	public Employee getManager() {
		return manager;
	}

	public int setManager(Employee manager) {
		this.manager = manager;
		return this.manager.empno;
	}

	public int getSalary() {
		return salary;
	}

	public int setSalary(int salary) {
		this.salary = salary;
		return this.salary;
	}

	public int getDept() {
		return dept.getDeptNo();
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return String.format("Employee [%s, %s, %s, %s, %s, %s]", empno, empname, title.getNo(), manager.getEmpno(), salary, dept.getDeptNo());
	}

}
