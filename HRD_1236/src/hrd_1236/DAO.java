package hrd_1236;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	private ConnectionUtil connUtil = ConnectionUtil.getInstance();
	
	public List<LectureVO> lectureList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select \"idx\", \"name\", \"major\" from \"lecture_tbl\"";
		List<LectureVO> list = new ArrayList<LectureVO>();
		LectureVO lec = null;
		try{
			
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				lec = new LectureVO();
				lec.setIdx(rs.getInt(1));
				lec.setName(rs.getString(2));
				lec.setMajor(rs.getString(3));
				list.add(lec);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	public int lastId() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select max(\"id\") from \"semester_tbl\"";
		int result = 0;
		try{
			
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public void insertSemester(SemesterVO sem) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"semester_tbl\" values(?,?,?,?,?,?,?)";
		int lastId = lastId();
		try{
			
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lastId+1);
			pstmt.setString(2, sem.getName());
			pstmt.setInt(3, sem.getPoint());
			pstmt.setInt(4, sem.getLecturer());
			pstmt.setInt(5, sem.getWeek());
			pstmt.setString(6, sem.getStart_hour());
			pstmt.setString(7, sem.getEnd_hour());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<SemesterVO> semesterList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from \"semester_tbl\" order by \"id\" desc";
		List<SemesterVO> list = new ArrayList<SemesterVO>();
		SemesterVO sem = null;
		try{
			
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				sem = new SemesterVO();
				sem.setId(rs.getInt(1));
				sem.setName(rs.getString(2));
				sem.setPoint(rs.getInt(3));
				sem.setLecturer(rs.getInt(4));
				sem.setWeek(rs.getInt(5));
				sem.setStart_hour(rs.getString(6));
				sem.setEnd_hour(rs.getString(7));
				list.add(sem);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	public LectureVO selectLecture(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from \"lecture_tbl\" where \"idx\" = ?";
		LectureVO lec = null;
		try{
			
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				lec = new LectureVO();
				lec.setIdx(rs.getInt(1));
				lec.setName(rs.getString(2));
				lec.setMajor(rs.getString(3));
				lec.setField(rs.getString(4));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return lec;
	}
	
	public SemesterVO selectSemester(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from \"semester_tbl\" where \"id\" = ?";
		SemesterVO sem = null;
		try{
			
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sem = new SemesterVO();
				sem.setId(rs.getInt(1));
				sem.setName(rs.getString(2));
				sem.setPoint(rs.getInt(3));
				sem.setLecturer(rs.getInt(4));
				sem.setWeek(rs.getInt(5));
				sem.setStart_hour(rs.getString(6));
				sem.setEnd_hour(rs.getString(7));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sem;
	}
}
