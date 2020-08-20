package hrd_1235;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	private ConnectionUtil connUtil = ConnectionUtil.getInstance();
	
	public int getLastNumber(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select max(\"stuno\") from \"student_tbl\"";
		int result = 0;
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		}catch(Exception e){
			
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
	
	public void insertStu(StudentVo studentVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"student_tbl\" values(?,?,?,?,?)";
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getLastNumber()+1);
			pstmt.setInt(2, studentVo.getStugrade());
			pstmt.setInt(3, studentVo.getStuclass());
			pstmt.setString(4, studentVo.getStuname());
			pstmt.setString(5, studentVo.getPhone());
			pstmt.executeUpdate();
		}catch(Exception e){
			
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
	
	public List<StudentVo> list(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from \"student_tbl\"";
		StudentVo vo = null;
		List<StudentVo> list = new ArrayList<StudentVo>();
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				vo = new StudentVo();
				vo.setStuno(rs.getInt(1));
				vo.setStugrade(rs.getInt(2));
				vo.setStuclass(rs.getInt(3));
				vo.setStuname(rs.getString(4));
				vo.setPhone(rs.getString(5));
				list.add(vo);
			}
		}catch(Exception e){
			
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
	
	public StudentVo select(int stuno){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from \"student_tbl\" where \"stuno\" = ?";
		StudentVo vo = null;
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuno);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo = new StudentVo();
				vo.setStuno(rs.getInt(1));
				vo.setStugrade(rs.getInt(2));
				vo.setStuclass(rs.getInt(3));
				vo.setStuname(rs.getString(4));
				vo.setPhone(rs.getString(5));
			}
		}catch(Exception e){
			
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
		return vo;
	}
	
	public void update(StudentVo studentVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update \"student_tbl\" set \"stugrade\" = ?, \"stuclass\" = ?, \"stuname\" = ?, \"phone\" = ? where \"stuno\" = ?";
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentVo.getStugrade());
			pstmt.setInt(2, studentVo.getStuclass());
			pstmt.setString(3, studentVo.getStuname());
			pstmt.setString(4, studentVo.getPhone());
			pstmt.setInt(5, studentVo.getStuno());
			pstmt.executeUpdate();
		}catch(Exception e){
			
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
	
	public void insertSco(ScoreVo scoreVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"score_tbl\" values(?,?,?,?,?)";
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scoreVo.getStuno());
			pstmt.setString(2, scoreVo.getExam());
			pstmt.setInt(3, scoreVo.getKorean());
			pstmt.setInt(4, scoreVo.getEnglish());
			pstmt.setInt(5, scoreVo.getMath());
			pstmt.executeUpdate();
		}catch(Exception e){
			
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
	
	public List<StudentVo> listScore(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.\"stuno\", a.\"stugrade\", a.\"stuclass\", a.\"stuname\", TRUNC((b.\"korean\"+b.\"english\"+b.\"math\")/3, 2) from \"student_tbl\" a, \"score_tbl\" b where a.\"stuno\" = b.\"stuno\"";
		StudentVo vo = null;
		List<StudentVo> list = new ArrayList<StudentVo>();
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				vo = new StudentVo();
				vo.setStuno(rs.getInt(1));
				vo.setStugrade(rs.getInt(2));
				vo.setStuclass(rs.getInt(3));
				vo.setStuname(rs.getString(4));
				vo.setAvg(rs.getFloat(5));
				list.add(vo);
			}
		}catch(Exception e){
			
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
}
