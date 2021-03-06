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

import db.PostDBUtil;
import model.Post;
import model.User;

/**
 * Servlet implementation class PostOperation
 */
@WebServlet("/PostOperation")
public class PostOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostOperation() {
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
		
	System.out.println("Postoperations");
	HttpSession session=request.getSession();
	User user=(User) session.getAttribute("user");
	String edit=request.getParameter("edit");
	String delete=request.getParameter("delete");
	String like=request.getParameter("like");
	String save=request.getParameter("save");
	String unlike=request.getParameter("unlike");
	String message=request.getParameter("content");
	String id=request.getParameter("id");
	String mail=user.getEmail();
	Boolean iscompleted=false;
	
	if (save!=null) {
		try {
			postdb.save(mail,message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//request.setAttribute("created", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		dispatcher.forward(request, response);
	}
	if (edit!=null) {
		try {
			postdb.update(id, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//RequestDispatcher dispatcher = request.getRequestDispatcher("UpdatePost");
		//request.setAttribute("created", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		dispatcher.forward(request, response);
		
	}
	if (delete!=null) {
		iscompleted=user.delPost(delete, postdb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
//		request.setAttribute("created", true);
		dispatcher.forward(request, response);
	
	}

	if (like!=null) {
		iscompleted=user.likePost(like, postdb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
//		request.setAttribute("created", true);
		dispatcher.forward(request, response);
	}
	if (unlike!=null) {
		iscompleted=user.unlikePost(unlike, postdb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
//		request.setAttribute("created", true);
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
