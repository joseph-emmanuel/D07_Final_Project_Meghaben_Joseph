package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.Post;

public class PostDBUtil {

	
	private DataSource dataSource;

	
	public PostDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public ArrayList<Post> getAllPosts() throws Exception{
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String questionDataBaseId="jk@gmail.com"; 
		
		ArrayList<Post> allPosts  = new ArrayList<>();	
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM post  WHERE email= 'jk@gmail.com'";
			
			smt = conn.createStatement();
			
			res = smt.executeQuery(sql);
			
			
			while(res.next()) {
				
				String id = Integer.toString(res.getInt("id"));
				String email = res.getString("email").toString();
				String content = res.getString("content");
				String image = res.getString("image");
				String date = res.getString("date");
				
				allPosts.add(new Post(id,content,image,date,email));
				
			}
			
			
		}finally {
			
			close(conn,smt,pstmt,res);
				
		}
			
		
		return allPosts;
		
	
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
