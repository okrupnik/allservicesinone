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
import by.epam.domain.ownership.Ownership;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.user.Person;
import by.epam.domain.user.Role;
import by.epam.domain.user.User;

public class SQLUserDAO implements UserDAO {
	private static final Logger log = LogManager.getLogger(SQLUserDAO.class.getName());

	@Override
	public User create(User user) throws DAOException {
		String roleId = null;
		String personId = null;
				
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection;
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			throw new DAOException("The thread was interrupted", e);
		}
		
		try {
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ROLE_USER);
			preparedStatement.setString(1, user.getRole().getTypeRole());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				roleId = resultSet.getString(DAOConstant.ID_PARAM_NAME);				
			}
			
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERSON_USER);
			preparedStatement.setString(1, user.getPerson().getTypePerson());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				personId = resultSet.getString(DAOConstant.ID_PARAM_NAME);				
			}
			
			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_USER);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(user.getPassword())));
			preparedStatement.setString(3, user.getIsDelete());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getPhoto());
			preparedStatement.setString(8, roleId);
			preparedStatement.setString(9, personId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			try {
				connection.rollback();
				throw new DAOException("Transaction failed", e);
			} catch (SQLException sqle) {
				throw new DAOException("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement);
				}
			}

		}
		
		return null;
	}

	@Override
	public User create(User user, Customer customer) throws DAOException {
		
		return null;
	}

	@Override
	public User create(User user, Performer performer) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User checkUser(String username, String password) throws DAOException {
		String isDelete = null;
		String photo = null;
		String role = null;
		String typePerson = null;
		String email = null;
		String phoneNumber = null;
		String formOwnership = null;
		String name = null;
		String surname = null;
		String address = null;
		String requisites = null;
		String copyRegistration = null;
		String companyName = null;
		String description = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		User user = null;
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection;
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			throw new DAOException("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.CHECK_USER);
			preparedStatement.setString(1, username.toLowerCase());
			preparedStatement.setString(2, EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(password)));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				isDelete = resultSet.getString(DAOConstant.IS_DELETE_PARAM_NAME);
				email = resultSet.getString(DAOConstant.EMAIL_PARAM_NAME);
				phoneNumber = resultSet.getString(DAOConstant.PHONE_NUMBER_PARAM_NAME);
				address = resultSet.getString(DAOConstant.ADDRESS_PARAM_NAME);
				photo = resultSet.getString(DAOConstant.PHOTO_PARAM_NAME);
				role = resultSet.getString(DAOConstant.ROLE_PARAM_NAME);
				typePerson = resultSet.getString(DAOConstant.TYPE_PERSON_PARAM_NAME);
				
			}
			if (typePerson.equals(DAOConstant.SERVICE_PERSON_PARAM_NAME)) {
				preparedStatement = connection.prepareStatement(SQLRequest.SELECT_SERVICE_STAFF);
				preparedStatement.setString(1, username.toLowerCase());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					name = resultSet.getString(DAOConstant.NAME_PARAM_NAME);
					surname = resultSet.getString(DAOConstant.SURNAME_PARAM_NAME);
				}
				user = new User(username, isDelete, email, phoneNumber, address, photo, new Role(role),
						new Person(typePerson), new ServiceStaffInfo(name, surname));
			} else {
				if (typePerson.equals(DAOConstant.CUSTOMER_PARAM_NAME)) {
					preparedStatement = connection.prepareStatement(SQLRequest.SELECT_CUSTOMER);
					preparedStatement.setString(1, username.toLowerCase());
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						formOwnership = resultSet.getString(DAOConstant.FORM_OWNERSHIP_PARAM_NAME);
					}
					switch (formOwnership) {
					case DAOConstant.CUSTOMER_NATURAL_PARAM_NAME:
						preparedStatement = connection.prepareStatement(SQLRequest.SELECT_CUSTOMER_NATURAL);
						preparedStatement.setString(1, username.toLowerCase());
						resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {
							name = resultSet.getString(DAOConstant.NAME_PARAM_NAME);
							surname = resultSet.getString(DAOConstant.SURNAME_PARAM_NAME);
						}
						user = new User(username, isDelete, email, phoneNumber, address, photo, new Role(role),
								new Person(typePerson),
								new Customer(new Ownership(formOwnership), new NaturalCustomerInfo(name, surname)));
						break;
					case DAOConstant.CUSTOMER_LEGAL_PARAM_NAME:
						preparedStatement = connection.prepareStatement(SQLRequest.SELECT_CUSTOMER_LEGAL);
						preparedStatement.setString(1, username.toLowerCase());
						resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {
							name = resultSet.getString(DAOConstant.NAME_PARAM_NAME);
							surname = resultSet.getString(DAOConstant.SURNAME_PARAM_NAME);
							requisites = resultSet.getString(DAOConstant.REQUISITES_PARAM_NAME);
							copyRegistration = resultSet.getString(DAOConstant.COPY_REGISTTRATION_PARAM_NAME);
						}
						user = new User(username, isDelete, email, phoneNumber, address, photo, new Role(role),
								new Person(typePerson), new Customer(new Ownership(formOwnership),
										new LegalCustomerInfo(name, surname, requisites, copyRegistration)));
						break;
					case DAOConstant.CUSTOMER_COMPANY_PARAM_NAME:
						preparedStatement = connection.prepareStatement(SQLRequest.SELECT_CUSTOMER_COMPANY);
						preparedStatement.setString(1, username.toLowerCase());
						resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {
							companyName = resultSet.getString(DAOConstant.COMPANY_PARAM_NAME);
							name = resultSet.getString(DAOConstant.NAME_AGENT_PARAM_NAME);
							surname = resultSet.getString(DAOConstant.SURNAME_AGENT_PARAM_NAME);
							requisites = resultSet.getString(DAOConstant.REQUISITES_PARAM_NAME);
							description = resultSet.getString(DAOConstant.DESCRIPTION_PARAM_NAME);
						}
						user = new User(username, isDelete, email, phoneNumber, address, photo, new Role(role),
								new Person(typePerson), new Customer(new Ownership(formOwnership),
										new CompanyCustomerInfo(companyName, name, surname, requisites, description)));
						break;
					}

				} else {
					if (typePerson.equals(DAOConstant.PERFORMER_PARAM_NAME)) {
						preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERFORMER);
						preparedStatement.setString(1, username.toLowerCase());
						resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {
							requisites = resultSet.getString(DAOConstant.REQUISITES_PARAM_NAME);
							formOwnership = resultSet.getString(DAOConstant.FORM_OWNERSHIP_PARAM_NAME);
						}
						switch (formOwnership) {
						case DAOConstant.PERFORMER_LEGAL_PARAM_NAME:
							preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERFORMER_LEGAL);
							preparedStatement.setString(1, username.toLowerCase());
							resultSet = preparedStatement.executeQuery();
							while (resultSet.next()) {
								name = resultSet.getString(DAOConstant.NAME_PARAM_NAME);
								surname = resultSet.getString(DAOConstant.SURNAME_PARAM_NAME);
								copyRegistration = resultSet.getString(DAOConstant.COPY_REGISTTRATION_PARAM_NAME);
							}
							user = new User(username, isDelete, email, phoneNumber, address, photo, new Role(role),
									new Person(typePerson), new Performer(requisites, new Ownership(formOwnership),
											new LegalPerformerInfo(name, surname, copyRegistration)));
							break;
						case DAOConstant.PERFORMER_COMPANY_PARAM_NAME:
							preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERFORMER_COMPANY);
							preparedStatement.setString(1, username.toLowerCase());
							resultSet = preparedStatement.executeQuery();
							while (resultSet.next()) {
								companyName = resultSet.getString(DAOConstant.COMPANY_PARAM_NAME);
								name = resultSet.getString(DAOConstant.NAME_AGENT_PARAM_NAME);
								surname = resultSet.getString(DAOConstant.SURNAME_AGENT_PARAM_NAME);
								description = resultSet.getString(DAOConstant.DESCRIPTION_PARAM_NAME);
							}
							user = new User(username, isDelete, email, phoneNumber, address, photo, new Role(role),
									new Person(typePerson), new Performer(requisites, new Ownership(formOwnership),
											new CompanyPerformerInfo(companyName, name, surname, description)));
							break;
						}
					}
				}
			}

			connection.commit();
		} catch (NoSuchAlgorithmException e) {
			throw new DAOException("Isn't found algorithm for encryption", e);
		} catch (Exception e) {
			try {
				connection.rollback();
				throw new DAOException("Transaction failed", e);
			} catch (SQLException sqle) {
				throw new DAOException("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement);
				}
			}

		}
		return user;
	}

	@Override
	public String checkUsername(String username) throws DAOException {
		String existingUser = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.EXIST_USER);
			preparedStatement.setString(1, username.toLowerCase());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				existingUser = resultSet.getString("username");
			}
		} catch (SQLException e) {
			throw new DAOException("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			throw new DAOException("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement);
				}
			}

		}

		return existingUser;
	}

	@Override
	public Customer getCustomer(String username) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Performer getPerformer(String username) throws DAOException {
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
	public User delete(String username) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
