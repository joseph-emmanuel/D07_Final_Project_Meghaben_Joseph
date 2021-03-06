package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.DataSource;

import model.Post;

import java.util.Date;
public class Post {
	
	
	public String id;
	public String content;
	public  String image;
	public String date;
	public String email;
	public String like;
	
	public Post(String id, String content, String image, String date, String email) {
		
		this.id = id;
		this.content = content;
		this.image = image;
		this.date = date;
		this.email = email;
		this.like=null;
	}
	public Post(String id, String content, String image, String date, String email,String like) {
		
		this.id = id;
		this.content = content;
		this.image = image;
		this.date = date;
		this.email = email;
		this.like=like;
	}
      public Post(String email,String content, String image) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		this.email = email;
		this.content = content;
		this.image = image;
		this.id = null;
		this.date = sdf.format(new Date());
	}
      public Post(String email,String content, String image,String like) {
  		
  		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  		
  		this.email = email;
  		this.content = content;
  		this.image = image;
  		this.id = null;
  		this.date = sdf.format(new Date());
  		this.like=like;
  	}
      

	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	

}
