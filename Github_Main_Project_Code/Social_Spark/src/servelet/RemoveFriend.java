package servelet;

import java.io.IOException;

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
import model.User;

/**
 * Servlet implementation class RemoveFriend
 */
@WebServlet("/RemoveFriend")
public class RemoveFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFriend() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/social")
    private DataSource datasource;
    private PostDBUtil postdb;
    private FriendDBUtil frienddb;
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
		
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
		String selectedPerson=request.getParameter("friend");
		System.out.println(selectedPerson);
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		System.out.println(user.getEmail());
		String uemail=user.getEmail();
		String femail=selectedPerson;
		try {
			frienddb.deleteFriend(uemail, femail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		dispatcher.forward(request, response);
	
	}	
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
