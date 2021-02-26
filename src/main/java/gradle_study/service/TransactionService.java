package gradle_study.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gradle_study.conn.JdbcUtil;
import gradle_study.dto.Department;
import gradle_study.dto.Title;

public class TransactionService {
	public String tranAddTitleAndDepartment(Title title, Department dept) {
		String titleSql = "insert into title values(?,?)";
		String deptSql = "insert into department values(?,?,?)";
		Connection con = null;
		PreparedStatement tPstmt = null;
		PreparedStatement dPstmt = null;
		String res = null;
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);

			tPstmt = con.prepareStatement(titleSql);
			tPstmt.setInt(1, title.getNo());
			tPstmt.setString(2, title.getName());
			tPstmt.executeUpdate();

			dPstmt = con.prepareStatement(deptSql);
			dPstmt.setInt(1, dept.getDeptNo());
			dPstmt.setString(2, dept.getDeptName());
			dPstmt.setInt(3, dept.getFloor());
			dPstmt.executeUpdate();

			con.commit();
			res = "commit";

		} catch (SQLException e) {
			res = "rollback";
			rollbackUtil(con);
		} finally {

			System.out.println(res);
			closeUtil(con, tPstmt, dPstmt);
		}
		return res;

	}

	private void rollbackUtil(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeUtil(Connection con, PreparedStatement tPstmt, PreparedStatement dPstmt) {
		try {
			con.setAutoCommit(true);
			if (tPstmt != null)
				tPstmt.close();
			if (dPstmt != null)
				dPstmt.close();
			if (con != null)
				con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int tranRemoveTitleAndDepartment(Title title, Department dept) {
		String titleSql = "delete from title where tNo = ?";
		String deptSql = "delete from department where deptno = ?";
		Connection con = null;
		PreparedStatement tPstmt = null;
		PreparedStatement dPstmt = null;

		int res = 0;

		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			System.out.println("res : " + res);
			tPstmt = con.prepareStatement(titleSql);
			tPstmt.setInt(1, title.getNo());
			res += tPstmt.executeUpdate();
			System.out.println("res : " + res);

			dPstmt = con.prepareStatement(deptSql);
			dPstmt.setInt(1, dept.getDeptNo());
			res += dPstmt.executeUpdate();
			System.out.println("res : " + res);

			if (res == 2) {
				con.commit();
				System.out.println("commit()");
			} else {
				System.out.println("rollback");
				throw new SQLException();
			}
		} catch (SQLException e) {
			rollbackUtil(con);
		} finally {
			closeUtil(con, tPstmt, dPstmt);
			return res;
		}
	}
}

