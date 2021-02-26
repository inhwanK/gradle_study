package gradle_study.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_study.conn.JdbcUtil;
import gradle_study.dao.EmployeeDao;
import gradle_study.dto.Department;
import gradle_study.dto.Employee;
import gradle_study.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();

	private EmployeeDaoImpl() {
	}

	public static EmployeeDaoImpl getInstance() {
//		if(instance == null) {
//			instance = new EmployeeDaoImpl();
//		}
		return instance;
	}

	@Override
	public List<Employee> selectByEmpAll() {
		String sql = "select empno,empname,title_no,title_name,manager_no,manager_name,salary,deptno,deptName,floor from vw_full_employee;";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empno = rs.getInt("empno");
		String empname = rs.getString("empname");
		Title title = new Title(rs.getInt("title_no"));
		Employee manager = new Employee(rs.getInt("empno"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("deptno"));
		
		if (rs.getString("title_name") != null) {
			title.setName(rs.getString("title_name"));
		}
		
		if (rs.getString("manager_name") != null) {
			manager.setEmpname(rs.getString("manager_name"));
		}
		
		if (rs.getString("deptname") != null && rs.getInt("floor") != 0) {
			dept.setDeptName(rs.getString("deptname"));
			dept.setFloor(rs.getInt("floor"));
		}

		return new Employee(empno, empname, title, manager, salary, dept);
	}

	@Override
	public Employee selectByEmpNo(Employee emp) {
		String sql = "select empno,empname,title_no,title_name,manager_no,manager_name,salary,deptno,deptName,floor"
				+ " from vw_full_employee"
				+ " where empno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, emp.getEmpno());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmp(Employee emp) {
		String sql = "insert into employee values(?,?,?,?,?,?);";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEmpname());
			pstmt.setInt(3, emp.setTitle(emp.getTitle()));
			pstmt.setInt(4, emp.setManager(emp.getManager()));
			pstmt.setInt(5, emp.getSalary());
			pstmt.setInt(6, emp.getDept());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	@Override
	public int updateEmp(Employee emp) {
		String sql = "update employee " + 
				"   set empname =? , title = ?, manager=?, salary=?, dept=?" + 
				" where empno= ?;";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, emp.getEmpname());
			pstmt.setInt(2, emp.setTitle(emp.getTitle()));
			pstmt.setInt(3, emp.setManager(emp.getManager()));
			pstmt.setInt(4, emp.getSalary());
			pstmt.setInt(5, emp.getDept());
			pstmt.setInt(6, emp.getEmpno());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmp(Employee emp) {
		String sql = "delete " + 
				"  from employee" + 
				" where empno = ?;";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, emp.getEmpno());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
