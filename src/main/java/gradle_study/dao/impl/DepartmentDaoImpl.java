package gradle_study.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gradle_study.conn.JdbcUtil;
import gradle_study.dao.DepartmentDao;
import gradle_study.dto.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

	public DepartmentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Department> selectDeptByAll() {
		String sql = "select * from department";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Department> list = new ArrayList<Department>();
				do {
					list.add(getDepartment(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return null;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("deptNo");
		String deptName = rs.getString("deptName");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public Department selectDeptByNo(Department dept) {
		String sql = "select deptNo, deptName, floor from department where deptno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, dept.getDeptNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				
				if (rs.next()) {
					return getDepartment(rs);
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public int insertDept(Department dept) {
		String sql = "insert into department(deptNo,deptName,floor) values(?,?,?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDeptName());
			pstmt.setInt(3, dept.getFloor());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	@Override
	public int updateDept(Department dept) {
		String sql = "update department set deptName = ? where deptNo = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public int deleteDept(Department dept) {
		String sql = "delete from department where deptNo = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, dept.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
