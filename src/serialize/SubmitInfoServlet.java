package serialize;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Account;

/**
 * Servlet implementation class SubmitInfoServlet
 * Submit username, email, year of birth, sex then return object java in base64 (serialize)
 */
@WebServlet(urlPatterns = {"/submit"})
public class SubmitInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/serializeView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String year = request.getParameter("year");
		String sex = request.getParameter("sex");
		String errorString = "";
		if (username == null || username.isEmpty()) errorString = "Please submit username";
		else if (email == null || email.isEmpty()) errorString = "Please submit email";
		else if (year == null || year.isEmpty()) errorString = "Please submit year of birth";
		else if (sex == null || sex.isEmpty()) errorString = "Please submit sex";
		request.setAttribute("errorString", errorString);
		request.setAttribute("username", username);
		request.setAttribute("email", email);
		request.setAttribute("year", year);
		request.setAttribute("sex",sex);
		if (errorString.isEmpty()) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(baos);
			Account account = new Account(username, email, sex, year);
			out.writeObject(account);
			request.setAttribute("base64Object", Base64.getEncoder().encodeToString(baos.toByteArray()));
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/serializeView.jsp");
		dispatcher.forward(request, response);
	}

}
