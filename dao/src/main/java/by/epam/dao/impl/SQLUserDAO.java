package by.epam.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		int roleId = 0;
		int personId = 0;
		int userId = 0;
		int ownershipId = 0;
		int customerId = 0;
		int performerId = 0;
				
		
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
			preparedStatement.setString(2, EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(user.getPassword())));
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
			
			if (user.getPerson().getTypePerson().equals(DAOConstant.SERVICE_PERSON_PARAM_NAME)) {
				preparedStatement = connection.prepareStatement(SQLRequest.CREATE_SERVICE_PERSON);
				preparedStatement.setString(1, user.getServiceStaffInfo().getName());
				preparedStatement.setString(2, user.getServiceStaffInfo().getSurname());
				preparedStatement.setInt(3, userId);
				preparedStatement.executeUpdate();
			}
			
			if (user.getPerson().getTypePerson().equals(DAOConstant.CUSTOMER_PARAM_NAME)) {
				preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OWNERSHIP_USER);
				preparedStatement.setString(1, user.getCustomer().getOwnership().getFormOwnership());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					ownershipId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));				
				}
				
				preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_PERSON, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, ownershipId);
				preparedStatement.setInt(2, userId);
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				resultSet.next();
				customerId = resultSet.getInt(1);
				
				switch (user.getCustomer().getOwnership().getFormOwnership()) {
				case DAOConstant.CUSTOMER_NATURAL_PARAM_NAME:
					preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_NATURAL_PERSON);
					preparedStatement.setString(1, user.getCustomer().getNaturalCustomerInfo().getName());
					preparedStatement.setString(2, user.getCustomer().getNaturalCustomerInfo().getSurname());
					preparedStatement.setInt(3, customerId);
					preparedStatement.executeUpdate();
					break;
				case DAOConstant.CUSTOMER_LEGAL_PARAM_NAME:
					preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_LEGAL_PERSON);
					preparedStatement.setString(1, user.getCustomer().getLegalCustomerInfo().getName());
					preparedStatement.setString(2, user.getCustomer().getLegalCustomerInfo().getSurname());
					preparedStatement.setString(3, user.getCustomer().getLegalCustomerInfo().getRequisites());
					preparedStatement.setString(4, user.getCustomer().getLegalCustomerInfo().getCopyRegistration());
					preparedStatement.setInt(5, customerId);
					preparedStatement.executeUpdate();
					break;
				case DAOConstant.CUSTOMER_COMPANY_PARAM_NAME:
					preparedStatement = connection.prepareStatement(SQLRequest.CREATE_CUSTOMER_COMPANY_PERSON);
					preparedStatement.setString(1, user.getCustomer().getCompanyCustomerInfo().getNameCompany());
					preparedStatement.setString(2, user.getCustomer().getCompanyCustomerInfo().getNameAgent());
					preparedStatement.setString(3, user.getCustomer().getCompanyCustomerInfo().getSurnameAgent());
					preparedStatement.setString(4, user.getCustomer().getCompanyCustomerInfo().getRequisites());
					preparedStatement.setString(5, user.getCustomer().getCompanyCustomerInfo().getDescription());
					preparedStatement.setInt(6, customerId);
					preparedStatement.executeUpdate();
					break;
				}
								
			} else {
				if (user.getPerson().getTypePerson().equals(DAOConstant.PERFORMER_PARAM_NAME)) {
					preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OWNERSHIP_USER);
					preparedStatement.setString(1, user.getPerformer().getOwnership().getFormOwnership());
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						ownershipId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));				
					}
					
					preparedStatement = connection.prepareStatement(SQLRequest.CREATE_PERFORMER_PERSON, Statement.RETURN_GENERATED_KEYS);
					preparedStatement.setString(1, user.getPerformer().getRequisites());
					preparedStatement.setInt(2, ownershipId);
					preparedStatement.setInt(3, userId);
					preparedStatement.executeUpdate();
					resultSet = preparedStatement.getGeneratedKeys();
					resultSet.next();
					performerId = resultSet.getInt(1);
					
					switch (user.getPerformer().getOwnership().getFormOwnership()) {					
					case DAOConstant.PERFORMER_LEGAL_PARAM_NAME:
						preparedStatement = connection.prepareStatement(SQLRequest.CREATE_PERFORMER_LEGAL_PERSON);
						preparedStatement.setString(1, user.getPerformer().getLegalPerformerInfo().getName());
						preparedStatement.setString(2, user.getPerformer().getLegalPerformerInfo().getSurname());
						preparedStatement.setString(3, user.getPerformer().getLegalPerformerInfo().getCopyRegistration());
						preparedStatement.setInt(4, performerId);
						preparedStatement.executeUpdate();
						break;
					case DAOConstant.PERFORMER_COMPANY_PARAM_NAME:
						preparedStatement = connection.prepareStatement(SQLRequest.CREATE_PERFORMER_COMPANY_PERSON);
						preparedStatement.setString(1, user.getPerformer().getCompanyPerformerInfo().getNameCompany());
						preparedStatement.setString(2, user.getPerformer().getCompanyPerformerInfo().getNameAgent());
						preparedStatement.setString(3, user.getPerformer().getCompanyPerformerInfo().getSurnameAgent());
						preparedStatement.setString(4, user.getPerformer().getCompanyPerformerInfo().getDescription());
						preparedStatement.setInt(5, performerId);
						preparedStatement.executeUpdate();
						break;
					}
									
				}
			}
			
			
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
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement);
				}
			}

		}
		
		return user;
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
				user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email).
						setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(role).build()).
						setPerson(new Person.Builder().setTypePerson(typePerson).build()).setServiceStaffInfo(new ServiceStaffInfo.Builder().setName(name).setSurname(surname).build()).build();						
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
						user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email).
								setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(role).build()).
								setPerson(new Person.Builder().setTypePerson(typePerson).build()).
								setCustomer(new Customer.Builder().setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
								setNaturalCustomerInfo(new NaturalCustomerInfo.Builder().setName(name).setSurname(surname).build()).build()).build();
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
						user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email).
								setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(role).build()).
								setPerson(new Person.Builder().setTypePerson(typePerson).build()).
								setCustomer(new Customer.Builder().setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
								setLegalCustomerInfo(new LegalCustomerInfo.Builder().setName(name).setSurname(surname).setRequisites(requisites).setCopyRegistration(copyRegistration).build()).build()).build();								
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
						user = user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email).
								setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(role).build()).
								setPerson(new Person.Builder().setTypePerson(typePerson).build()).
								setCustomer(new Customer.Builder().setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
								setCompanyCustomerInfo(new CompanyCustomerInfo.Builder().setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname).setRequisites(requisites).setDescription(description).build()).build()).build();
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
							user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email).
									setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(role).build()).
									setPerson(new Person.Builder().setTypePerson(typePerson).build()).
									setPerformer(new Performer.Builder().setRequisites(requisites).setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
									setLegalPerformerInfo(new LegalPerformerInfo.Builder().setName(name).setSurname(surname).setCopyRegistration(copyRegistration).build()).build()).build();
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
							user = new User.Builder().setUsername(username).setIsDelete(isDelete).setEmail(email).
									setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(role).build()).
									setPerson(new Person.Builder().setTypePerson(typePerson).build()).
									setPerformer(new Performer.Builder().setRequisites(requisites).setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
									setCompanyPerformerInfo(new CompanyPerformerInfo.Builder().setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname).setDescription(description).build()).build()).build();
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
				if (connection != null)
					connection.close();
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
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_EXIST_USER);
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
	public boolean editUser(User user) throws DAOException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ConnectionPool conPool = ConnectionPool.getInstance();
		
		try (Connection connection = conPool.takeConnection()) {
									
			if (user.getPerson().getTypePerson().equals(DAOConstant.SERVICE_PERSON_PARAM_NAME)) {
				preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_SERVICE_PERSON);
				preparedStatement.setString(1, user.getEmail());
				preparedStatement.setString(2, user.getPhoneNumber());
				preparedStatement.setString(3, user.getAddress());
				preparedStatement.setString(4, user.getPhoto());
				preparedStatement.setString(5, user.getServiceStaffInfo().getName());
				preparedStatement.setString(6, user.getServiceStaffInfo().getSurname());
				preparedStatement.setString(7, user.getUsername());
				preparedStatement.executeUpdate();
			}
			
			if (user.getPerson().getTypePerson().equals(DAOConstant.CUSTOMER_PARAM_NAME)) {
				switch (user.getCustomer().getOwnership().getFormOwnership()) {
				case DAOConstant.CUSTOMER_NATURAL_PARAM_NAME:
					preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_CUSTOMER_NATURAL_PERSON);
					preparedStatement.setString(1, user.getEmail());
					preparedStatement.setString(2, user.getPhoneNumber());
					preparedStatement.setString(3, user.getAddress());
					preparedStatement.setString(4, user.getPhoto());
					preparedStatement.setString(5, user.getCustomer().getNaturalCustomerInfo().getName());
					preparedStatement.setString(6, user.getCustomer().getNaturalCustomerInfo().getSurname());
					preparedStatement.setString(7, user.getUsername());
					preparedStatement.executeUpdate();
					break;
				case DAOConstant.CUSTOMER_LEGAL_PARAM_NAME:
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
					break;
				case DAOConstant.CUSTOMER_COMPANY_PARAM_NAME:
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
					break;
				}
								
			} else {
				if (user.getPerson().getTypePerson().equals(DAOConstant.PERFORMER_PARAM_NAME)) {					
					switch (user.getPerformer().getOwnership().getFormOwnership()) {					
					case DAOConstant.PERFORMER_LEGAL_PARAM_NAME:
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
						break;
					case DAOConstant.PERFORMER_COMPANY_PARAM_NAME:
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
						break;
					}
									
				}
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
				
		return true;
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
	public String checkPassword(String oldPassword) throws DAOException {		
		String username = "";

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_CHECK_PASSWORD);
			preparedStatement.setString(1, EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(oldPassword)));
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				username = resultSet.getString("username");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new DAOException("Isn't found algorithm for encryption", e);
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
		
		return username;
	}

	@Override
	public boolean editPassword(User user, String newPassword) throws DAOException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_PASSWORD);
			preparedStatement.setString(1, EncryptPassword.byteArrayToHexString(EncryptPassword.computeHash(newPassword)));
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.executeUpdate();
			return true;
		} catch (NoSuchAlgorithmException e) {
			throw new DAOException("Isn't found algorithm for encryption", e);
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
		
	}
	
	@Override
	public User delete(String username) throws DAOException {

		
		return null;
	}
}
