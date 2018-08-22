package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;

public interface UserDAO {

	User create(final User user) throws DAOException;
	
	User create(final User user, final Customer customer) throws DAOException;

	User create(final User user, final Performer performer) throws DAOException;

	User checkUser(final String username, final String password) throws DAOException;

	String checkUsername(final String username) throws DAOException;

	Customer getCustomer(final String username) throws DAOException;	

	Performer getPerformer(final String username) throws DAOException;

	boolean editUser (final User user) throws DAOException;
	
	boolean editCustomer(final Customer customer) throws DAOException;

	boolean editPerformer(final Performer performer) throws DAOException;
	
	User getUser(final String username) throws DAOException;
	
	List<User> getAllUser(final int offset, final int noOfRecords) throws DAOException;
	
	String checkPassword(final String oldPassword) throws DAOException;
	
	boolean editPassword (final User user, final String newPassword) throws DAOException;
	
	boolean delete(final String username) throws DAOException;
	
	int getNoOfRecords() throws DAOException;
}
