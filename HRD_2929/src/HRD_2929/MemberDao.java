package HRD_2929;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	ConnectionUtil connUtil = ConnectionUtil.getInstance();
	public int getLastNumber(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int no = 0;
		String sql = "select max(\"custno\") from \"member_tbl_02\"";
		try{
			conn = connUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				no = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return no+1;
	}
	
	public void insertMember(MemberVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"member_tbl_02\" values ( ?, ?, ?)";
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCustno());
			pstmt.setString(2, vo.getCustname());
			pstmt.setDate(3, vo.getJoindate());
			pstmt.executeUpdate();
			System.out.println("등록 되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<MemberVo> getMemberList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select * from \"member_tbl_02\"";
		try{
			conn = connUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				MemberVo vo = new MemberVo();
				vo.setCustno(rs.getInt(1));
				vo.setCustname(rs.getString(2));
				vo.setJoindate(rs.getDate(3));
				list.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public MemberVo getLMember(int custno){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		String sql = "select * from \"member_tbl_02\" where \"custno\"=?";
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				vo = new MemberVo();
				vo.setCustno(rs.getInt(1));
				vo.setCustname(rs.getString(2));
				vo.setJoindate(rs.getDate(3));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vo;
	}
	
	public void updateMember(int custno, MemberVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update \"member_tbl_02\" set \"custname\" = ?, \"joindate\" = ? where \"custno\" = ?";
		try{
			conn = connUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCustname());
			pstmt.setDate(2, vo.getJoindate());
			pstmt.setInt(3, vo.getCustno());
			pstmt.executeUpdate();
			System.out.println("수정 되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

	