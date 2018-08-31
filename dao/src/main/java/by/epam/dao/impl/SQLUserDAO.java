package by.epam.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.dao.UserDAO;
import by.epam.dao.connectionpool.ConnectionPool;
import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.ownership.Ownership;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.user.Person;
import by.epam.domain.user.Role;
import by.epam.domain.user.User;

public class SQLUserDAO implements UserDAO {
	private static final Logger log = LoggerFactory.getLogger(SQLUserDAO.class.getName());

	private int noOfRecords;

	@Override
	public User createCustomerNatural(final User user) throws DAOException {
		int roleId = 0;
		int personId = 0;
		int userId = 0;
		int ownershipId = 0;
		int customerId = 0;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ROLE_USER);
			preparedStatement.setString(1, user.getRole().getTypeRole());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				roleId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERSON_USER);
			preparedStatement.setString(1, user.getPerson().getTypePerson());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				personId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_USER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2,
					EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(user.getPassword())));
			preparedStatement.setString(3, user.getIsDelete());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getPhoto());
			preparedStatement.setInt(8, roleId);
			preparedStatement.setInt(9, personId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			userId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OWNERSHIP_USER);
			preparedStatement.setString(1, user.getCustomer().getOwnership().getFormOwnership());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ownershipId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));

			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_PERSON,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, ownershipId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			customerId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_NATURAL_PERSON);
			preparedStatement.setString(1, user.getCustomer().getNaturalCustomerInfo().getName());
			preparedStatement.setString(2, user.getCustomer().getNaturalCustomerInfo().getSurname());
			preparedStatement.setInt(3, customerId);
			preparedStatement.executeUpdate();

			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		}

		return user;
	}

	@Override
	public User createCustomerLegal(final User user) throws DAOException {

		int roleId = 0;
		int personId = 0;
		int userId = 0;
		int ownershipId = 0;
		int customerId = 0;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ROLE_USER);
			preparedStatement.setString(1, user.getRole().getTypeRole());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				roleId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERSON_USER);
			preparedStatement.setString(1, user.getPerson().getTypePerson());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				personId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_USER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2,
					EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(user.getPassword())));
			preparedStatement.setString(3, user.getIsDelete());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getPhoto());
			preparedStatement.setInt(8, roleId);
			preparedStatement.setInt(9, personId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			userId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OWNERSHIP_USER);
			preparedStatement.setString(1, user.getCustomer().getOwnership().getFormOwnership());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ownershipId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));

			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_PERSON,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, ownershipId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			customerId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_LEGAL_PERSON);
			preparedStatement.setString(1, user.getCustomer().getLegalCustomerInfo().getName());
			preparedStatement.setString(2, user.getCustomer().getLegalCustomerInfo().getSurname());
			preparedStatement.setString(3, user.getCustomer().getLegalCustomerInfo().getRequisites());
			preparedStatement.setString(4, user.getCustomer().getLegalCustomerInfo().getCopyRegistration());
			preparedStatement.setInt(5, customerId);
			preparedStatement.executeUpdate();

			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return user;
	}

	@Override
	public User createCustomerCompany(final User user) throws DAOException {

		int roleId = 0;
		int personId = 0;
		int userId = 0;
		int ownershipId = 0;
		int customerId = 0;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ROLE_USER);
			preparedStatement.setString(1, user.getRole().getTypeRole());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				roleId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERSON_USER);
			preparedStatement.setString(1, user.getPerson().getTypePerson());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				personId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_USER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2,
					EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(user.getPassword())));
			preparedStatement.setString(3, user.getIsDelete());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getPhoto());
			preparedStatement.setInt(8, roleId);
			preparedStatement.setInt(9, personId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			userId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OWNERSHIP_USER);
			preparedStatement.setString(1, user.getCustomer().getOwnership().getFormOwnership());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ownershipId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}
			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_PERSON,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, ownershipId);
			preparedStatement.setInt(2, userId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			customerId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_COMPANY_PERSON);
			preparedStatement.setString(1, user.getCustomer().getCompanyCustomerInfo().getNameCompany());
			preparedStatement.setString(2, user.getCustomer().getCompanyCustomerInfo().getNameAgent());
			preparedStatement.setString(3, user.getCustomer().getCompanyCustomerInfo().getSurnameAgent());
			preparedStatement.setString(4, user.getCustomer().getCompanyCustomerInfo().getRequisites());
			preparedStatement.setString(5, user.getCustomer().getCompanyCustomerInfo().getDescription());
			preparedStatement.setInt(6, customerId);
			preparedStatement.executeUpdate();

			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return user;
	}

	@Override
	public User createPerformerLegal(final User user) throws DAOException {

		int roleId = 0;
		int personId = 0;
		int userId = 0;
		int ownershipId = 0;
		int performerId = 0;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ROLE_USER);
			preparedStatement.setString(1, user.getRole().getTypeRole());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				roleId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERSON_USER);
			preparedStatement.setString(1, user.getPerson().getTypePerson());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				personId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_USER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2,
					EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(user.getPassword())));
			preparedStatement.setString(3, user.getIsDelete());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getPhoto());
			preparedStatement.setInt(8, roleId);
			preparedStatement.setInt(9, personId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			userId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OWNERSHIP_USER);
			preparedStatement.setString(1, user.getPerformer().getOwnership().getFormOwnership());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ownershipId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_PERFORMER_PERSON,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getPerformer().getRequisites());
			preparedStatement.setInt(2, ownershipId);
			preparedStatement.setInt(3, userId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			performerId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_PERFORMER_LEGAL_PERSON);
			preparedStatement.setString(1, user.getPerformer().getLegalPerformerInfo().getName());
			preparedStatement.setString(2, user.getPerformer().getLegalPerformerInfo().getSurname());
			preparedStatement.setString(3, user.getPerformer().getLegalPerformerInfo().getCopyRegistration());
			preparedStatement.setInt(4, performerId);
			preparedStatement.executeUpdate();

			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return user;

	}

	@Override
	public User createPerformerCompany(final User user) throws DAOException {

		int roleId = 0;
		int personId = 0;
		int userId = 0;
		int ownershipId = 0;
		int performerId = 0;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ROLE_USER);
			preparedStatement.setString(1, user.getRole().getTypeRole());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				roleId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERSON_USER);
			preparedStatement.setString(1, user.getPerson().getTypePerson());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				personId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_USER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2,
					EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(user.getPassword())));
			preparedStatement.setString(3, user.getIsDelete());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getPhoto());
			preparedStatement.setInt(8, roleId);
			preparedStatement.setInt(9, personId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			userId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OWNERSHIP_USER);
			preparedStatement.setString(1, user.getPerformer().getOwnership().getFormOwnership());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ownershipId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_PERFORMER_PERSON,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getPerformer().getRequisites());
			preparedStatement.setInt(2, ownershipId);
			preparedStatement.setInt(3, userId);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			performerId = resultSet.getInt(1);

			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_PERFORMER_COMPANY_PERSON);
			preparedStatement.setString(1, user.getPerformer().getCompanyPerformerInfo().getNameCompany());
			preparedStatement.setString(2, user.getPerformer().getCompanyPerformerInfo().getNameAgent());
			preparedStatement.setString(3, user.getPerformer().getCompanyPerformerInfo().getSurnameAgent());
			preparedStatement.setString(4, user.getPerformer().getCompanyPerformerInfo().getDescription());
			preparedStatement.setInt(5, performerId);
			preparedStatement.executeUpdate();

			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return user;
	}

	@Override
	public User checkUser(final String username, final String password) throws DAOException {
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
		Connection connection = null;
		;
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_CHECK_USER);
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

				Role roleService = new Role.Builder().setTypeRole(role).build();
				Person person = new Person.Builder().setTypePerson(typePerson).build();
				ServiceStaffInfo serviceStaffInfo = new ServiceStaffInfo.Builder().setName(name).setSurname(surname)
						.build();

				user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
						.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(roleService)
						.setPerson(person).setServiceStaffInfo(serviceStaffInfo).build();
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

						Role roleCustomerNatural = new Role.Builder().setTypeRole(role).build();
						Person personNatural = new Person.Builder().setTypePerson(typePerson).build();
						Ownership ownershipNatural = new Ownership.Builder().setFormOwnership(formOwnership).build();
						NaturalCustomerInfo naturalCustomerInfo = new NaturalCustomerInfo.Builder().setName(name)
								.setSurname(surname).build();
						Customer customerNatural = new Customer.Builder().setOwnership(ownershipNatural)
								.setNaturalCustomerInfo(naturalCustomerInfo).build();

						user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
								.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
								.setRole(roleCustomerNatural).setPerson(personNatural).setCustomer(customerNatural)
								.build();
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

						Role roleCustomerLegal = new Role.Builder().setTypeRole(role).build();
						Person personLegal = new Person.Builder().setTypePerson(typePerson).build();
						Ownership ownershipLegal = new Ownership.Builder().setFormOwnership(formOwnership).build();
						LegalCustomerInfo legalCustomerInfo = new LegalCustomerInfo.Builder().setName(name)
								.setSurname(surname).setRequisites(requisites).setCopyRegistration(copyRegistration)
								.build();
						Customer customerLegal = new Customer.Builder().setOwnership(ownershipLegal)
								.setLegalCustomerInfo(legalCustomerInfo).build();

						user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
								.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
								.setRole(roleCustomerLegal).setPerson(personLegal).setCustomer(customerLegal).build();
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

						Role roleCustomerCompany = new Role.Builder().setTypeRole(role).build();
						Person personCompany = new Person.Builder().setTypePerson(typePerson).build();
						CompanyCustomerInfo companyCustomerInfo = new CompanyCustomerInfo.Builder()
								.setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname)
								.setRequisites(requisites).setDescription(description).build();
						Ownership ownershipCompany = new Ownership.Builder().setFormOwnership(formOwnership).build();
						Customer customerCompany = new Customer.Builder().setOwnership(ownershipCompany)
								.setCompanyCustomerInfo(companyCustomerInfo).build();

						user = user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
								.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
								.setRole(roleCustomerCompany).setPerson(personCompany).setCustomer(customerCompany)
								.build();
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

							Role rolePerformerLegal = new Role.Builder().setTypeRole(role).build();
							Person personLegal = new Person.Builder().setTypePerson(typePerson).build();
							Ownership ownershipLegal = new Ownership.Builder().setFormOwnership(formOwnership).build();
							LegalPerformerInfo legalPerformerInfo = new LegalPerformerInfo.Builder().setName(name)
									.setSurname(surname).setCopyRegistration(copyRegistration).build();
							Performer performerLegal = new Performer.Builder().setRequisites(requisites)
									.setOwnership(ownershipLegal).setLegalPerformerInfo(legalPerformerInfo).build();

							user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
									.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
									.setRole(rolePerformerLegal).setPerson(personLegal).setPerformer(performerLegal)
									.build();
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

							Role rolePerformerCompany = new Role.Builder().setTypeRole(role).build();
							Person personCompany = new Person.Builder().setTypePerson(typePerson).build();
							Ownership ownershipCompany = new Ownership.Builder().setFormOwnership(formOwnership)
									.build();
							CompanyPerformerInfo companyPerformerInfo = new CompanyPerformerInfo.Builder()
									.setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname)
									.setDescription(description).build();
							Performer performerCompany = new Performer.Builder().setRequisites(requisites)
									.setOwnership(ownershipCompany).setCompanyPerformerInfo(companyPerformerInfo)
									.build();

							user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
									.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
									.setRole(rolePerformerCompany).setPerson(personCompany)
									.setPerformer(performerCompany).build();
							break;
						}
					}
				}
			}

			connection.commit();
		} catch (NoSuchAlgorithmException e) {
			log.error("Isn't found algorithm for encryption", e);
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}
		return user;
	}

	@Override
	public String checkUsername(final String username) throws DAOException {
		String existingUser = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_EXIST_USER);
			preparedStatement.setString(1, username.toLowerCase());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				existingUser = resultSet.getString("username");
			}
		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return existingUser;
	}

	@Override
	public boolean editAdministration(final User user) throws DAOException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {

			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_SERVICE_PERSON);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoto());
			preparedStatement.setString(5, user.getServiceStaffInfo().getName());
			preparedStatement.setString(6, user.getServiceStaffInfo().getSurname());
			preparedStatement.setString(7, user.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		}

		return true;
	}

	@Override
	public boolean editCustomerNatural(final User user) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {

			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_CUSTOMER_NATURAL_PERSON);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoto());
			preparedStatement.setString(5, user.getCustomer().getNaturalCustomerInfo().getName());
			preparedStatement.setString(6, user.getCustomer().getNaturalCustomerInfo().getSurname());
			preparedStatement.setString(7, user.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return true;
	}

	@Override
	public boolean editCustomerLegal(final User user) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {

			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_CUSTOMER_LEGAL_PERSON);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoto());
			preparedStatement.setString(5, user.getCustomer().getLegalCustomerInfo().getName());
			preparedStatement.setString(6, user.getCustomer().getLegalCustomerInfo().getSurname());
			preparedStatement.setString(7, user.getCustomer().getLegalCustomerInfo().getRequisites());
			preparedStatement.setString(8, user.getCustomer().getLegalCustomerInfo().getCopyRegistration());
			preparedStatement.setString(9, user.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return true;
	}

	@Override
	public boolean editCustomerCompany(final User user) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {

			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_CUSTOMER_COMPANY_PERSON);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoto());
			preparedStatement.setString(5, user.getCustomer().getCompanyCustomerInfo().getNameCompany());
			preparedStatement.setString(6, user.getCustomer().getCompanyCustomerInfo().getNameAgent());
			preparedStatement.setString(7, user.getCustomer().getCompanyCustomerInfo().getSurnameAgent());
			preparedStatement.setString(8, user.getCustomer().getCompanyCustomerInfo().getRequisites());
			preparedStatement.setString(9, user.getCustomer().getCompanyCustomerInfo().getDescription());
			preparedStatement.setString(10, user.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return true;
	}

	@Override
	public boolean editPerformerLegal(final User user) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {

			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_PERFORMER_LEGAL_PERSON);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoto());
			preparedStatement.setString(5, user.getPerformer().getRequisites());
			preparedStatement.setString(6, user.getPerformer().getLegalPerformerInfo().getName());
			preparedStatement.setString(7, user.getPerformer().getLegalPerformerInfo().getSurname());
			preparedStatement.setString(8, user.getPerformer().getLegalPerformerInfo().getCopyRegistration());
			preparedStatement.setString(9, user.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return true;
	}

	@Override
	public boolean editPerformerCompany(final User user) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {

			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_PERFORMER_COMPANY_PERSON);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoto());
			preparedStatement.setString(5, user.getPerformer().getRequisites());
			preparedStatement.setString(6, user.getPerformer().getCompanyPerformerInfo().getNameCompany());
			preparedStatement.setString(7, user.getPerformer().getCompanyPerformerInfo().getNameAgent());
			preparedStatement.setString(8, user.getPerformer().getCompanyPerformerInfo().getSurnameAgent());
			preparedStatement.setString(9, user.getPerformer().getCompanyPerformerInfo().getDescription());
			preparedStatement.setString(10, user.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return true;
	}

	@Override
	public String checkPassword(final String oldPassword) throws DAOException {
		String username = "";

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_CHECK_PASSWORD);
			preparedStatement.setString(1,
					EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(oldPassword)));
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				username = resultSet.getString("username");
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("Isn't found algorithm for encryption", e);
		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}

		return username;
	}

	@Override
	public boolean editPassword(final User user, final String newPassword) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_PASSWORD);
			preparedStatement.setString(1,
					EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(newPassword)));
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.executeUpdate();
		} catch (NoSuchAlgorithmException e) {
			log.error("Isn't found algorithm for encryption", e);
		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}
		return true;

	}

	@Override
	public boolean delete(final String username) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.DELETE_USER);
			preparedStatement.setString(1, username);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}
		return true;
	}

	@Override
	public List<User> getAllUser(final int offset, final int noOfRecords) throws DAOException {
		String userName = null;
		String isDelete = null;
		String photo = null;
		String role = null;
		String typePerson = null;
		String email = null;
		String phoneNumber = null;
		String address = null;
		List<User> userList = new ArrayList<>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		User user = null;
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;
		;
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_USER);
			preparedStatement.setInt(1, offset);
			preparedStatement.setInt(2, noOfRecords);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userName = resultSet.getString(DAOConstant.USERNAME_PARAM_NAME);
				isDelete = resultSet.getString(DAOConstant.IS_DELETE_PARAM_NAME);
				email = resultSet.getString(DAOConstant.EMAIL_PARAM_NAME);
				phoneNumber = resultSet.getString(DAOConstant.PHONE_NUMBER_PARAM_NAME);
				address = resultSet.getString(DAOConstant.ADDRESS_PARAM_NAME);
				photo = resultSet.getString(DAOConstant.PHOTO_PARAM_NAME);
				role = resultSet.getString(DAOConstant.ROLE_PARAM_NAME);
				typePerson = resultSet.getString(DAOConstant.TYPE_PERSON_PARAM_NAME);

				Role roleUser = new Role.Builder().setTypeRole(role).build();
				Person person = new Person.Builder().setTypePerson(typePerson).build();

				user = new User.Builder().setUsername(userName).setIsDelete(isDelete).setEmail(email)
						.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(roleUser)
						.setPerson(person).build();
				userList.add(user);

			}
			resultSet = preparedStatement.executeQuery(SQLRequest.SELECT_COUNT_USER);
			if (resultSet.next())
				this.noOfRecords = resultSet.getInt(1);
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		}

		return userList;
	}

	@Override
	public int getNoOfRecords() throws DAOException {
		return noOfRecords;
	}

	@Override
	public User getUser(final String username) throws DAOException {
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
		Connection connection = null;
		;
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_USER_BY_USERNAME);
			preparedStatement.setString(1, username.toLowerCase());
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

				Role roleService = new Role.Builder().setTypeRole(role).build();
				Person person = new Person.Builder().setTypePerson(typePerson).build();
				ServiceStaffInfo serviceStaffInfo = new ServiceStaffInfo.Builder().setName(name).setSurname(surname)
						.build();

				user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
						.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(roleService)
						.setPerson(person).setServiceStaffInfo(serviceStaffInfo).build();
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

						Role roleCustomerNatural = new Role.Builder().setTypeRole(role).build();
						Person personNatural = new Person.Builder().setTypePerson(typePerson).build();
						Ownership ownershipNatural = new Ownership.Builder().setFormOwnership(formOwnership).build();
						NaturalCustomerInfo naturalCustomerInfo = new NaturalCustomerInfo.Builder().setName(name)
								.setSurname(surname).build();
						Customer customerNatural = new Customer.Builder().setOwnership(ownershipNatural)
								.setNaturalCustomerInfo(naturalCustomerInfo).build();

						user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
								.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
								.setRole(roleCustomerNatural).setPerson(personNatural).setCustomer(customerNatural)
								.build();
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

						Role roleCustomerLegal = new Role.Builder().setTypeRole(role).build();
						Person personLegal = new Person.Builder().setTypePerson(typePerson).build();
						Ownership ownershipLegal = new Ownership.Builder().setFormOwnership(formOwnership).build();
						LegalCustomerInfo legalCustomerInfo = new LegalCustomerInfo.Builder().setName(name)
								.setSurname(surname).setRequisites(requisites).setCopyRegistration(copyRegistration)
								.build();
						Customer customerLegal = new Customer.Builder().setOwnership(ownershipLegal)
								.setLegalCustomerInfo(legalCustomerInfo).build();

						user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
								.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
								.setRole(roleCustomerLegal).setPerson(personLegal).setCustomer(customerLegal).build();
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

						Role roleCustomerCompany = new Role.Builder().setTypeRole(role).build();
						Person personCompany = new Person.Builder().setTypePerson(typePerson).build();
						CompanyCustomerInfo companyCustomerInfo = new CompanyCustomerInfo.Builder()
								.setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname)
								.setRequisites(requisites).setDescription(description).build();
						Ownership ownershipCompany = new Ownership.Builder().setFormOwnership(formOwnership).build();
						Customer customerCompany = new Customer.Builder().setOwnership(ownershipCompany)
								.setCompanyCustomerInfo(companyCustomerInfo).build();

						user = user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
								.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
								.setRole(roleCustomerCompany).setPerson(personCompany).setCustomer(customerCompany)
								.build();
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

							Role rolePerformerLegal = new Role.Builder().setTypeRole(role).build();
							Person personLegal = new Person.Builder().setTypePerson(typePerson).build();
							Ownership ownershipLegal = new Ownership.Builder().setFormOwnership(formOwnership).build();
							LegalPerformerInfo legalPerformerInfo = new LegalPerformerInfo.Builder().setName(name)
									.setSurname(surname).setCopyRegistration(copyRegistration).build();
							Performer performerLegal = new Performer.Builder().setRequisites(requisites)
									.setOwnership(ownershipLegal).setLegalPerformerInfo(legalPerformerInfo).build();

							user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
									.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
									.setRole(rolePerformerLegal).setPerson(personLegal).setPerformer(performerLegal)
									.build();
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

							Role rolePerformerCompany = new Role.Builder().setTypeRole(role).build();
							Person personCompany = new Person.Builder().setTypePerson(typePerson).build();
							Ownership ownershipCompany = new Ownership.Builder().setFormOwnership(formOwnership)
									.build();
							CompanyPerformerInfo companyPerformerInfo = new CompanyPerformerInfo.Builder()
									.setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname)
									.setDescription(description).build();
							Performer performerCompany = new Performer.Builder().setRequisites(requisites)
									.setOwnership(ownershipCompany).setCompanyPerformerInfo(companyPerformerInfo)
									.build();

							user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email)
									.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo)
									.setRole(rolePerformerCompany).setPerson(personCompany)
									.setPerformer(performerCompany).build();
							break;
						}
					}
				}
			}

			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}
		return user;
	}

	@Override
	public List<User> getAllPerformer(int offset, int noOfRecords) throws DAOException {

		String userName = null;
		String isDelete = null;
		String photo = null;
		String role = null;
		String typePerson = null;
		String email = null;
		String phoneNumber = null;
		String address = null;
		String requisites = null;
		String formOwnership = null;
		String name = null;
		String surname = null;
		String nameCompany = null;
		String description = null;
		LegalPerformerInfo legalPerformerInfo = null;
		CompanyPerformerInfo companyPerformerInfo = null;
		Performer performer = null;
		List<User> userList = new ArrayList<>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		User user = null;
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;
		;
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_USER_PERFORMER);
			preparedStatement.setInt(1, offset);
			preparedStatement.setInt(2, noOfRecords);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userName = resultSet.getString(DAOConstant.USERNAME_PARAM_NAME);
				isDelete = resultSet.getString(DAOConstant.IS_DELETE_PARAM_NAME);
				email = resultSet.getString(DAOConstant.EMAIL_PARAM_NAME);
				phoneNumber = resultSet.getString(DAOConstant.PHONE_NUMBER_PARAM_NAME);
				address = resultSet.getString(DAOConstant.ADDRESS_PARAM_NAME);
				photo = resultSet.getString(DAOConstant.PHOTO_PARAM_NAME);
				role = resultSet.getString(DAOConstant.ROLE_PARAM_NAME);
				typePerson = resultSet.getString(DAOConstant.TYPE_PERSON_PARAM_NAME);
				requisites = resultSet.getString(DAOConstant.REQUISITES_PARAM_NAME);
				formOwnership = resultSet.getString(DAOConstant.FORM_OWNERSHIP_PARAM_NAME);

				Role roleUser = new Role.Builder().setTypeRole(role).build();
				Person person = new Person.Builder().setTypePerson(typePerson).build();
				Ownership ownership = new Ownership.Builder().setFormOwnership(formOwnership).build();
				performer = new Performer.Builder().setRequisites(requisites).setOwnership(ownership).build();

				user = new User.Builder().setUsername(userName).setIsDelete(isDelete).setEmail(email)
						.setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(roleUser)
						.setPerson(person).setPerformer(performer).build();
				userList.add(user);
			}
			resultSet = preparedStatement.executeQuery(SQLRequest.SELECT_COUNT_USER);
			if (resultSet.next())
				this.noOfRecords = resultSet.getInt(1);

			for (User tempUser : userList) {
				if (DAOConstant.CUSTOMER_LEGAL_PARAM_NAME
						.equals(tempUser.getPerformer().getOwnership().getFormOwnership())) {
					preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_LEGAL_PERFORMER);
					preparedStatement.setString(1, tempUser.getUsername());
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						name = resultSet.getString(DAOConstant.NAME_PARAM_NAME);
						surname = resultSet.getString(DAOConstant.SURNAME_PARAM_NAME);
						performer = new Performer.Builder().setRequisites(tempUser.getPerformer().getRequisites())
								.setOwnership(tempUser.getPerformer().getOwnership())
								.setLegalPerformerInfo(
										new LegalPerformerInfo.Builder().setName(name).setSurname(surname).build())
								.build();
						tempUser.setPerformer(performer);
					}
				}
				if (DAOConstant.CUSTOMER_COMPANY_PARAM_NAME
						.equals(tempUser.getPerformer().getOwnership().getFormOwnership())) {
					preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_COMPANY_PERFORMER);
					preparedStatement.setString(1, tempUser.getUsername());
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						nameCompany = resultSet.getString(DAOConstant.COMPANY_PARAM_NAME);
						name = resultSet.getString(DAOConstant.NAME_AGENT_PARAM_NAME);
						surname = resultSet.getString(DAOConstant.SURNAME_AGENT_PARAM_NAME);
						description = resultSet.getString(DAOConstant.DESCRIPTION_PARAM_NAME);
						performer = new Performer.Builder().setRequisites(tempUser.getPerformer().getRequisites())
								.setOwnership(tempUser.getPerformer().getOwnership())
								.setCompanyPerformerInfo(new CompanyPerformerInfo.Builder().setNameCompany(nameCompany)
										.setNameAgent(name).setSurnameAgent(surname).setDescription(description)
										.build())
								.build();
						tempUser.setPerformer(performer);
					}
				}
			}

			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		}

		return userList;
	}

}
