package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classe.Friend;
import classe.User;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Search() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		HashMap<String, Friend> tabFriend = user.searchMatch(request.getParameter("search"));
		User userTmp = new User();
		userTmp.setFriends(tabFriend);
		session.setAttribute("userTmp", userTmp);
		this.getServletContext().getRequestDispatcher("/resultSearch.jsp").forward(request, response);
	}

}
