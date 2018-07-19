package by.epam.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.dao.UserDAO;
import by.epam.dao.connectionpool.ConnectionPool;
import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.Person;
import by.epam.domain.user.Role;
import by.epam.domain.user.User;

public class SQLUserDAO implements UserDAO {
	private static final Logger log = LogManager.getLogger(SQLUserDAO.class.getName());

	@Override
	public User create(User user, Customer customer) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User create(User user, Performer performer) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User checkUser(String login, String password) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		User user = null;
		ConnectionPool conPool = ConnectionPool.getInstance();
		try (Connection connection = conPool.takeConnection()) {

//		try {	
//			
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Connection connection = null;
//			connection = DriverManager
//					.getConnection("jdbc:mysql://localhost:3306/allservices?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC","root", "root");

			preparedStatement = connection.prepareStatement(
					"SELECT users.login, users.password, users.isDelete, roles.role, persons.typePerson FROM allservices.users, allservices.roles, allservices.persons WHERE roles.id=users.roles_id AND persons.id=users.persons_id AND users.login=? AND users.password=?");
			preparedStatement.setString(1, login.toLowerCase());
			preparedStatement.setString(2, EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(password)));
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String isDelete = resultSet.getString("isDelete");
				String role = resultSet.getString("role");
				String typePerson = resultSet.getString("typePerson");
				user = new User(login, isDelete, new Role(role), new Person(typePerson));
			}
		} catch (SQLException e) {
			throw new DAOException("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			throw new DAOException("The thread was interrupted", e);
		} catch (NoSuchAlgorithmException e) {
			throw new DAOException("Isn't found algorithm for encryption", e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					for (StackTraceElement stackTraceElement : e.getStackTrace()) {
						log.error(stackTraceElement);
					}
				}
			}
		}
		return user;
	}

	@Override
	public User checkLoginUser(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Performer getPerformer(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean editCustomer(Customer customer) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPerformer(Performer performer) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User delete(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
