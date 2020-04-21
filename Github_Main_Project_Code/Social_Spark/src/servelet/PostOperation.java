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
	
	Boolean iscompleted=false;
	if (edit!=null) {
		iscompleted=user.editPost(edit, postdb);
	}
	if (delete!=null) {
		iscompleted=user.delPost(delete, postdb);
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
