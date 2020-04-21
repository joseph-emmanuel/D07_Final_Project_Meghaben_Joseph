package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;
import model.Post;
import model.message;

public class MessageDBUtil {
private DataSource dataSource;

	
	public MessageDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
public ArrayList<message> getAllMessage() throws Exception{
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		ArrayList<message> allMessages  = new ArrayList<>();	
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM message";
			
			smt = conn.createStatement();
			
			res = smt.executeQuery(sql);
			
			
			while(res.next()) {
				
				String id = Integer.toString(res.getInt("id"));
				String email = res.getString("email").toString();
				String content = res.getString("content");
				String date = res.getString("date");
				
				allMessages.add(new message(id,content,date,email));
				
			}
			
			
		}finally {
			
			close(conn,smt,pstmt,res);
				
		}
			
		
		return allMessages;
		
	
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
