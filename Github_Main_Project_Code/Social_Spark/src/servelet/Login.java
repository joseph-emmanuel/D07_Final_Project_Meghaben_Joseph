package servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.FriendDBUtil;
import db.PostDBUtil;
import db.UserDBUtil;
import model.Post;
import model.User;
import model.friend;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    @Resource(name="jdbc/social")
    private DataSource datasource;
    private UserDBUtil userdb;
    private PostDBUtil postdb;
    private FriendDBUtil frienddb;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
		
			userdb = new UserDBUtil(datasource);		
			postdb = new PostDBUtil(datasource);	
			frienddb=new FriendDBUtil(datasource);
		
		}catch(Exception ex) {
			
			throw new ServletException(ex);
		
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		ArrayList<Post> userPosts = new ArrayList<>();
		ArrayList<User> people = new ArrayList<>();
		ArrayList<friend> friend = new ArrayList<>();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		try {
			userPosts=postdb.getUserPosts(email);
			people=userdb.getAllPeople(email);
			friend=frienddb.getAllFriends(email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		User tempUser = new User(email,pass);
		
		
		Boolean canLogin = tempUser.login(userdb);
		
		
		if(canLogin) {
			
			session.setAttribute("user", tempUser);
			session.setAttribute("userPosts", userPosts);
			session.setAttribute("people", people);
			session.setAttribute("friend", friend);
			
			
			response.sendRedirect("profile.jsp");
			
		}else {
			
			RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp");
			
			request.setAttribute("loginError", true);
			dispatcher.forward(request, response);
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
