package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.User;
import model.friend;
public class FriendDBUtil {
private DataSource dataSource;

	
	public FriendDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addFriend(String uemail,String femail) throws Exception {
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String status="0";
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = String.format("INSERT INTO friend (uemail,femail,status) VALUES ('%s','%s','%s')", uemail,femail,status);
			
			smt = conn.createStatement();
			
			smt.executeUpdate(sql);
			
			
		}finally {
			System.out.println("completed the insert");
			close(conn,smt,pstmt,res);
		}
		}
public void blockUser(String uemail,String femail) throws Exception {
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String status="2";
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql2 = "update friend set status=? where uemail=? and femail=?";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, status);
			pstmt.setString(2, uemail);
			pstmt.setString(3, femail);
			pstmt.executeUpdate();
			
			System.out.println("Database updated successfully ");
			
		}finally {
			System.out.println("completed the insert");
			close(conn,smt,pstmt,res);
		}
		}


public void deleteFriend(String uemail,String femail) throws Exception {
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	try {
		
		conn = this.dataSource.getConnection();
		
		String sql2 = "DELETE FROM friend WHERE uemail=? and femail=?";
		
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, uemail);
		pstmt.setString(2, femail);
		pstmt.executeUpdate();
		
		System.out.println("Database updated successfully ");
		
	}finally {
		System.out.println("completed the insert");
		close(conn,smt,pstmt,res);
	}
	}



public ArrayList<friend> getAllFriends(String uemail) throws Exception {
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	String status="1";
	ArrayList<friend> uFriends = new ArrayList<>();
	try {
		
		conn = this.dataSource.getConnection();
		
		String sql = "SELECT * FROM friend WHERE uemail =? and status=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, uemail);
		pstmt.setString(2, status);
		
		res = pstmt.executeQuery();
		
		while(res.next()) {
			String tuemail = res.getString("uemail").toString();
			String tfemail = res.getString("femail").toString();
			String tstatus=res.getString("status").toString();
			uFriends.add(new friend(tuemail, tfemail, tstatus));
			
		}
			
		
	}finally {
		
		close(conn,smt,pstmt,res);
			
	}
		
	
	return uFriends;
	
}
private void close(Connection conn, Statement smt, PreparedStatement pstmt, ResultSet res) {
		
		try {
			
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(smt != null) {
				smt.close();
			}
			if(res != null) {
				res.close();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}
}
