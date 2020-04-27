package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.Post;

public class PostDBUtil {

//	 User user=(User)session.getAttribute("user");
	private DataSource dataSource;

	
	public PostDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public ArrayList<Post> getAllPosts() throws Exception{
		
		
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		ArrayList<Post> allPosts  = new ArrayList<>();	
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM post";
			
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
public ArrayList<Post> getUserPosts(String userEmail) throws Exception{
		
		//use
	
		userEmail=userEmail;
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		ArrayList<Post> userPosts  = new ArrayList<>();	
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM post where email = '" + userEmail +"'";
			
			smt = conn.createStatement();
			
			res = smt.executeQuery(sql);
			
			
			while(res.next()) {
				
				String id = Integer.toString(res.getInt("id"));
				String email = res.getString("email").toString();
				String content = res.getString("content");
				String image = res.getString("image");
				String date = res.getString("date");
				
				userPosts.add(new Post(id,content,image,date,email));
				
			}
			
			
		}finally {
			
			close(conn,smt,pstmt,res);
				
		}
			
		
		return userPosts;
		
	
	}
	
public void insertPost(Post tempPost) throws Exception {
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	String content = tempPost.getContent();	
	String email = tempPost.getEmail();	
	String image = tempPost.getImage();	
	String date = tempPost.getDate();	
	int like=tempPost.getLike();
	
	try {
		
		conn = this.dataSource.getConnection();
		
		String sql = String.format("INSERT INTO post (email,content,image,date) VALUES ('%s','%s','%s','%s')", email,content,image,date);
		
		smt = conn.createStatement();
		
		smt.executeUpdate(sql);
		
		
	}finally {
		
		close(conn,smt,pstmt,res);
	}
	}

	public void update(String id ,String ContentFinal) throws Exception {
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		int id1=Integer.parseInt(id);
		Post tempPost=null;
			try {
			
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM post WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				String email = res.getString("email").toString();
				String content = res.getString("content").toString();
				String image = res.getString("image").toString();
				String date = res.getString("date").toString();
				
				tempPost = new Post(id, content, image, date, email);
				
			}
			}finally {
				
			}
		
		
		String id11 = tempPost.getId();	
		String content = tempPost.getContent();	
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql2 = "update post set content=? where id=?";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, ContentFinal);
			pstmt.setString(2, tempPost.getId());
			pstmt.executeUpdate();
			
			System.out.println("Database updated successfully ");
			
		}
		finally {
			
			close(conn,smt,pstmt,res);
				
		}
	
}
public void	likepost(String id)throws Exception
	{
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Post tempPost=null;
		try {
			conn = this.dataSource.getConnection();
			String sql = "select * FROM post WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			res=pstmt.executeQuery();
			if(res.next()) {
				String email = res.getString("email").toString();
				String content = res.getString("content").toString();
				String image = res.getString("image").toString();
				String date = res.getString("date").toString();
				int like=res.getInt("tlike");
				//int like=res.getInt("like").toString();
				tempPost = new Post(id, content, image, date, email,like);
				
			}
		} finally {
			//close(conn,smt,pstmt,res);
		} 
		String id11 = tempPost.getId();	
		int like=tempPost.getLike();
		 Integer hitsCount=like++;
				
try {
			
			conn = this.dataSource.getConnection();
			
			String sql2 = "update post set tlike=? where id=?";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, Integer.toString(hitsCount));
			pstmt.setString(2, tempPost.getId());
			pstmt.executeUpdate();
			
			System.out.println("Database updated successfully  for like");
			
		}
		finally {
			
			close(conn,smt,pstmt,res);
				
		}
	}
	
	
public void deletePost(String id) throws Exception
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
		try {
			conn = this.dataSource.getConnection();
			String sql = "delete FROM post WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} finally {
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
