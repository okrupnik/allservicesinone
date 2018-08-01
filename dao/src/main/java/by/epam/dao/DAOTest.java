package by.epam.dao;

import java.security.NoSuchAlgorithmException;

import by.epam.dao.exception.DAOException;
import by.epam.dao.impl.EncryptPassword;
import by.epam.dao.impl.SQLUserDAO;
import by.epam.domain.user.User;

public class DAOTest {

	public static void main(String[] args) {
		UserDAO userDAO = new SQLUserDAO();
		try {
			String pass = EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash("12345"));
			String pass2 = EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash("qwert"));
			User user = userDAO.checkUser("admin", "admin");
			System.out.println(user.getUsername() + " " + user.getIsDelete() + " " + user.getRole().getTypeRole() + " " + user.getPerson().getTypePerson() + " ");
		} catch (DAOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
