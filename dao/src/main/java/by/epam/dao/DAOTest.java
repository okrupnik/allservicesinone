package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.dao.impl.SQLUserDAO;
import by.epam.domain.user.User;

public class DAOTest {

	public static void main(String[] args) {
		UserDAO userDAO = new SQLUserDAO();
		try {
			User user = userDAO.checkUser("admin", "admin");
			System.out.println(user.getLogin() + " " + user.getIsDelete() + " " + user.getRole().getTypeRole() + " " + user.getPerson().getTypePerson() + " ");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
