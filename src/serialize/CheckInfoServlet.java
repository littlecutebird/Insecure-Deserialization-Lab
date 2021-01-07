package serialize;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Account;

/**
 * Servlet implementation class CheckInfoServlet
 */
@WebServlet(urlPatterns = {"/check"})
public class CheckInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/deserializeView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base64str = request.getParameter("base64str");
		request.setAttribute("base64str", base64str);
		ByteArrayInputStream bais = new ByteArrayInputStream(Base64.getDecoder().decode(base64str));
		ObjectInputStream inp = new ObjectInputStream(bais);
		try {
			Account account = (Account)inp.readObject();
			request.setAttribute("username", account.getUsername());
			request.setAttribute("email", account.getEmail());
			request.setAttribute("year", account.getYear());
			request.setAttribute("sex", account.getSex());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/deserializeView.jsp");
		dispatcher.forward(request, response);
	}

}
