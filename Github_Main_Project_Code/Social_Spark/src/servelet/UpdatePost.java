package servelet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.PostDBUtil;
import model.User;

/**
 * Servlet implementation class UpdatePost
 */
@WebServlet("/UpdatePost")
public class UpdatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePost() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Resource(name="jdbc/social")
    private DataSource datasource;
    private PostDBUtil postdb;
    public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
		
			postdb = new PostDBUtil(datasource);			
		
		}catch(Exception ex) {
			
			throw new ServletException(ex);
		
		}
		
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside the updatepost");
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		String email=user.getEmail();
		String id=request.getParameter("id");
		String content=request.getAttribute("content").toString();
		System.out.println(content);
		try {
			postdb.update(id,"i am testing my function ha");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
