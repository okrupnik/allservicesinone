package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.user.User;

public interface UserDAO {
	
	User createCustomerNatural(final User user) throws DAOException;
	
	User createCustomerLegal(final User user) throws DAOException;
	
	User createCustomerCompany(final User user) throws DAOException;
	
	User createPerformerLegal(final User user) throws DAOException;
	
	User createPerformerCompany(final User user) throws DAOException;

	User checkUser(final String username, final String password) throws DAOException;

	String checkUsername(final String username) throws DAOException;
	
	boolean editAdministration(final User user) throws DAOException;

	boolean editCustomerNatural(final User user) throws DAOException;

	boolean editCustomerLegal(final User user) throws DAOException;

	boolean editCustomerCompany(final User user) throws DAOException;

	boolean editPerformerLegal(final User user) throws DAOException;

	boolean editPerformerCompany(final User user) throws DAOException;
	
	User getUser(final String username) throws DAOException;
	
	List<User> getAllUser(final int offset, final int noOfRecords) throws DAOException;
	
	String checkPassword(final String oldPassword) throws DAOException;
	
	boolean editPassword (final User user, final String newPassword) throws DAOException;
	
	boolean delete(final String username) throws DAOException;
	
	int getNoOfRecords() throws DAOException;
}
