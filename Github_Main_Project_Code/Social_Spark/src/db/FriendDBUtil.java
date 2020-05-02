package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.Post;
public class FriendDBUtil {
private DataSource dataSource;

	
	public FriendDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addFriend(Post tempPost) throws Exception {
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		String content = tempPost.getContent();	
		String email = tempPost.getEmail();	
		String image = tempPost.getImage();	
		String date = tempPost.getDate();	
		String like=tempPost.getLike();
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = String.format("INSERT INTO post (email,content,image,date) VALUES ('%s','%s','%s','%s')", email,content,image,date);
			
			smt = conn.createStatement();
			
			smt.executeUpdate(sql);
			
			
		}finally {
			
			close(conn,smt,pstmt,res);
		}
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
