 package model;

import db.PostDBUtil;
import db.UserDBUtil;

public class User {


	private String fname;
	private String lname;
	private String email;
	private String pass;
	
	public User(String fname, String lname, String email, String pass) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
	}


	public User(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}


	public User(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}


	public String getFname() {
		return this.fname;
	}


	public String getLname() {
		return this.lname;
	}


	public String getEmail() {
		return this.email;
	}


	public String getPass() {
		return this.pass;
	}
	
	
	public Boolean login(UserDBUtil userdb) {
		
		try {
			User tempUser = userdb.findUser(this.email);
				
			if(tempUser != null) {
				
				String tempPass = tempUser.getPass();
				
				if(this.pass.equals(tempPass)) {
					
					this.fname = tempUser.getFname();
					this.lname = tempUser.getLname();
					this.email = tempUser.getEmail();
					this.pass = null;
					
					return true;
				}	
					
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
public Boolean createPost(String content, String image, PostDBUtil postdb) {
		
		Post tempPost = new Post(this.email,content,image,null);
		
		try {
			postdb.insertPost(tempPost);
			return true;	
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}	
		
		return false;
	}
public Boolean editPost(String id,PostDBUtil postdb)
{
	try {
		//postdb.update(id);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return true;
}



public Boolean delPost(String id,PostDBUtil postdb)
{
	try {
		postdb.deletePost(id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	return true;
}
public Boolean likePost(String id,PostDBUtil postdb)
{
	
	try {
		postdb.likepost(id);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return true;
}
public Boolean unlikePost(String id,PostDBUtil postdb)
{
	
	try {
		postdb.unlikepost(id);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return true;
}
	@Override
	public String toString() {
		return this.email;
	}
	
}
